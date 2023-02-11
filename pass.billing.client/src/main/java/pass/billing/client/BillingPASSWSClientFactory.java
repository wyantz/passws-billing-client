/**
 * 
 */
package pass.billing.client;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

/**
 * @author Awiyanto Ajisasongko
 *
 */
public class BillingPASSWSClientFactory {
	private static BillingPASSWSClient gateway = null;

	private static Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.pass.billing.wsclient");
		return marshaller;
	}

	private static Wss4jSecurityInterceptor securityInterceptor(String username, String password) {
		Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
		wss4jSecurityInterceptor.setSecurementActions("UsernameToken");
		wss4jSecurityInterceptor.setSecurementUsername(username);
		wss4jSecurityInterceptor.setSecurementPassword(password);
		wss4jSecurityInterceptor.setSecurementPasswordType("PasswordText");
		
		// Agar Created tidak disertakan karena seringkali menyebabkan
		// Error message expired. Maka cukup Nonce saja yang disertakan
		// Biasanya 'Nonce Created'
		wss4jSecurityInterceptor.setSecurementUsernameTokenElements("Nonce");
		return wss4jSecurityInterceptor;
	}

	public static BillingPASSWSClient getInstance(String url, String username, String password) {
		if (gateway == null) {
			gateway = new BillingPASSWSClient(url);
			gateway.setMarshaller(marshaller());
			gateway.setUnmarshaller(marshaller());

			ClientInterceptor[] interceptors = new ClientInterceptor[] { securityInterceptor(username, password) };
			gateway.setInterceptors(interceptors);

			HttpsUrlConnectionMessageSender sender = new HttpsUrlConnectionMessageSender();
			sender.setTrustManagers(new TrustManager[] { new MyTrustManager() });
			sender.setHostnameVerifier(new HostnameVerifier() {

				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});
			gateway.setMessageSender(sender);
		}
		return gateway;
	}
}
