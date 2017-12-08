package com.wifipay.common.net;

import android.content.Context;
import com.wifipay.common.net.b.b.l;
import com.wifipay.common.net.b.k;
import com.wifipay.common.net.b.o;

public class HttpManager
{
  private static HttpManager b;
  private o a;
  public Context mContext;
  
  private HttpManager(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.a = l.a();
  }
  
  public static HttpManager getInstance()
  {
    if (b != null) {
      return b;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  public static void init(Context paramContext)
  {
    if (b == null) {
      b = new HttpManager(paramContext);
    }
  }
  
  public static void stop()
  {
    if (b != null)
    {
      b.a.b();
      b.a = null;
      b.mContext = null;
      b = null;
    }
  }
  
  public void cancel(k paramk)
  {
    if (paramk != null) {
      paramk.g();
    }
  }
  
  public void cancel(String paramString)
  {
    b.getRequestQueue().a(new a(this, paramString));
  }
  
  public void cancelAll()
  {
    b.getRequestQueue().a(new b(this));
  }
  
  public o getRequestQueue()
  {
    if (this.a != null) {
      return this.a;
    }
    throw new IllegalStateException("Not initialized");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/HttpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */