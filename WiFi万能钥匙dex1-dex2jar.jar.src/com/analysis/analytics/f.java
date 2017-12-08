package com.analysis.analytics;

public abstract class f
  implements Runnable
{
  public abstract void a();
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/analytics/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */