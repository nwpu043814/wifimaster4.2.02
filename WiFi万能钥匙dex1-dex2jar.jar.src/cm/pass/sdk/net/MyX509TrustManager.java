package cm.pass.sdk.net;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class MyX509TrustManager
  implements X509TrustManager
{
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/MyX509TrustManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */