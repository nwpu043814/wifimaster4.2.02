package com.tencent.wxop.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class al
  extends DefaultConnectionKeepAliveStrategy
{
  al(ak paramak) {}
  
  public final long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    long l2 = super.getKeepAliveDuration(paramHttpResponse, paramHttpContext);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = 30000L;
    }
    return l1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */