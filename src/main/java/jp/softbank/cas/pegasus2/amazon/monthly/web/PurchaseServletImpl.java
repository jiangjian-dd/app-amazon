package jp.softbank.cas.pegasus2.amazon.monthly.web;

import com.amazon.dtasdk.v2.serialization.messages.*;
import com.amazon.dtasdk.v2.servlets.PurchaseServlet;
import com.amazon.dtasdk.v2.signature.CredentialStore;
import jp.softbank.cas.pegasus2.amazon.monthly.domain.User;
import jp.softbank.cas.pegasus2.amazon.monthly.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class PurchaseServletImpl extends PurchaseServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Autowired
    private CredentialService credentialService;

    @Override
    public FulfillPurchaseResponse fulfillPurchase(FulfillPurchaseRequest request) {
        FulfillPurchaseResponse response = new FulfillPurchaseResponse();
        response.setResponse(FulfillPurchaseResponseValue.OK);
        return response;
    }

    @Override
    public RevokePurchaseResponse revokePurchase(RevokePurchaseRequest request) {
        RevokePurchaseResponse response = new RevokePurchaseResponse();
        response.setResponse(RevokePurchaseResponseValue.OK);
        return response;
    }

    @Override
    public SubscriptionResponse processSubscriptionActivate(SubscriptionActivateRequest request) {
        SubscriptionResponse response = new SubscriptionResponse();
        response.setResponse(SubscriptionResponseValue.OK);
        return response;
    }

    @Override
    public SubscriptionResponse processSubscriptionDeactivate(SubscriptionDeactivateRequest request) {
        SubscriptionResponse response = new SubscriptionResponse();
        response.setResponse(SubscriptionResponseValue.OK);
        return response;
    }

    @Override
    public CredentialStore getCredentialStore() {
        return credentialService.getCredentialStore();
    }
}
