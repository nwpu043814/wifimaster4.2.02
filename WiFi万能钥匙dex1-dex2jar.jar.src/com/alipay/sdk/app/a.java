package com.alipay.sdk.app;

public class a
  extends H5PayActivity
{
  public final void a()
  {
    try
    {
      synchronized (AuthTask.a)
      {
        ???.notify();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */