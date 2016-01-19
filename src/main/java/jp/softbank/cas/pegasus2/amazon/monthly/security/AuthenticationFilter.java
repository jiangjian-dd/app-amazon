package jp.softbank.cas.pegasus2.amazon.monthly.security;
//
//import com.amazon.dtasdk.v2.signature.Credential;
//import com.amazon.dtasdk.v2.signature.CredentialStore;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//@Component
//public class AuthenticationFilter implements Filter {
//
//    private Log log = LogFactory.getLog(AuthenticationFilter.class);
//
//    private final static String HEADER_AUTHORIZATION = "Authentication";
//    private final static String HEADER_X_AMZ_REQUEST_ID = "x-amz-request-id";
//    private final static String HEADER_X_AMZ_DATE = "x-amz-date";
//    private final static String HEADER_X_AMZ_CUSTOMER_ID = "x-amz-customer-id";
//    private final static String HEADER_X_AMZ_DTA_VERSION = "x-amz-dta-version";
//
//    @Value("${secret-key}" )
//    private String secretKey;
//
//    @Value("${public-key}")
//    private String publicKey;
//
//    private CredentialStore credentialStore;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        credentialStore = new CredentialStore();
//        credentialStore.add(new Credential(secretKey, publicKey));
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //TODO: validate authentication in request header
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {}
//}
