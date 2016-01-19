package jp.softbank.cas.pegasus2.amazon.monthly.web;

import com.amazon.dtasdk.v2.serialization.messages.GetUserIdSerializableRequest;
import com.amazon.dtasdk.v2.serialization.messages.GetUserIdSerializableResponse;
import com.amazon.dtasdk.v2.serialization.messages.GetUserIdSerializableResponseValue;
import com.amazon.dtasdk.v2.servlets.AccountLinkingServlet;
import com.amazon.dtasdk.v2.signature.CredentialStore;
import jp.softbank.cas.pegasus2.amazon.monthly.domain.User;
import jp.softbank.cas.pegasus2.amazon.monthly.domain.UserRepository;
import jp.softbank.cas.pegasus2.amazon.monthly.service.CredentialService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class AccountLinkingServletImpl  extends AccountLinkingServlet{
    Log log = LogFactory.getLog(AccountLinkingServletImpl.class);

    private static final String AMAZON_HEALTH_CHECK_INFO_FIELD_1 = "TESTVALUE";
    private static final String AMAZON_HEALTH_CHECK_CUSTOMER_ID = "AMAZONTEST";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
        //TODO: should be remove
        userRepository.save(new User("bob", "b"));
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialService credentialService;

    @Override
    public GetUserIdSerializableResponse getUserId(GetUserIdSerializableRequest request) {
        String username = request.getInfoField1();
        String password = request.getInfoField2();

        User user =  userRepository.findByUsernameAndPassword(username, password);

        GetUserIdSerializableResponse response = new GetUserIdSerializableResponse();
        if (user != null) {
            response.setResponse(GetUserIdSerializableResponseValue.OK);
            response.setUserId(user.getId().toString());
        } else {
            response.setResponse(GetUserIdSerializableResponseValue.FAIL_ACCOUNT_INVALID);
            response.setUserId(null);
        }

        return response;
    }

    @Override
    public CredentialStore getCredentialStore() {
        return credentialService.getCredentialStore();
    }
}
