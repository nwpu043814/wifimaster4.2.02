package cm.pass.sdk.net;

import cm.pass.sdk.utils.e;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class MyHostnameVerifier
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (e.c.contains("www.cmpassport.com"))
    {
      bool1 = bool2;
      if (!paramString.contains("www.cmpassport.com")) {
        if (!paramString.contains("open.mmarket.com")) {
          break label43;
        }
      }
    }
    label43:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/MyHostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */