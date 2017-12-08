package com.alipay.android.a.a.a;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class n
  implements ConnectionKeepAliveStrategy
{
  n(l paraml) {}
  
  public final long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    return 180000L;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */