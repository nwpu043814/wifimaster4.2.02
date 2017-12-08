package com.wifipay.wallet.pay;

public class SyncResp
{
  private static SPayResp a;
  
  public static SPayResp a()
  {
    return a;
  }
  
  public static SPayResp a(String paramString)
  {
    SPayResp localSPayResp = new SPayResp();
    localSPayResp.resultCode = "-3";
    if (paramString != null) {}
    for (;;)
    {
      localSPayResp.resultMessage = paramString;
      return localSPayResp;
      paramString = "unknown error";
    }
  }
  
  public static void a(SPayResp paramSPayResp)
  {
    a = paramSPayResp;
  }
  
  public static void b()
  {
    if ((a != null) && (a.pay_source == 1)) {}
    try
    {
      synchronized (WifiPayApiImpl.SYNC_ACT)
      {
        WifiPayApiImpl.SYNC_ACT.notifyAll();
        return;
      }
      try
      {
        synchronized (WifiPayApiImpl.SYNC)
        {
          WifiPayApiImpl.SYNC.notifyAll();
        }
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public static SPayResp c()
  {
    return a(null);
  }
  
  public static abstract interface ErrCode
  {
    public static final String ERR_CANCEL = "-3";
    public static final String ERR_FAIL = "-2";
    public static final String ERR_OK = "0";
    public static final String ERR_UNKNOWN = "-5";
    public static final String ERR_UNSUPPORT = "-4";
    public static final String ERR_WAIT = "-1";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/SyncResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */