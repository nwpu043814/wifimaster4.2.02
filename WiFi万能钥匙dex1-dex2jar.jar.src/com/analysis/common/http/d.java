package com.analysis.common.http;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class d
  implements X509TrustManager
{
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/http/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */