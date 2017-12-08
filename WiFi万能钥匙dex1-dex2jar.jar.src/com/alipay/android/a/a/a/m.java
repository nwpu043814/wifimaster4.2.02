package com.alipay.android.a.a.a;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

final class m
  extends DefaultRedirectHandler
{
  int a;
  
  m(l paraml) {}
  
  public final boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    this.a += 1;
    boolean bool2 = super.isRedirectRequested(paramHttpResponse, paramHttpContext);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.a < 5)
      {
        int i = paramHttpResponse.getStatusLine().getStatusCode();
        if (i != 301)
        {
          bool1 = bool2;
          if (i != 302) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */