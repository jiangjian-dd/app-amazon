package jp.softbank.cas.pegasus2.amazon.monthly.service;

import com.amazon.dtasdk.v2.signature.Credential;
import com.amazon.dtasdk.v2.signature.CredentialStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CredentialService {
    @Value("${secret-key}")
    private String secretKey;

    @Value("${public-key}")
    private String publicKey;

    private static CredentialStore credentialStore;

    public CredentialStore getCredentialStore() {
        if (credentialStore != null) {
            return credentialStore;
        }

        Credential credential = new Credential(secretKey, publicKey);
        credentialStore = new CredentialStore();
        credentialStore.add(credential);
        return credentialStore;
    }
}
