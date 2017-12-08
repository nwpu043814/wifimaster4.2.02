package com.wifipay.wallet.common.utils;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

public class CountDown
{
  private Timer a;
  private TimerTask b;
  private int c;
  private int d;
  private OnCountDownListener e;
  private Handler f = new c(this);
  
  public CountDown(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.cancel();
      this.b = null;
    }
    if (this.a != null)
    {
      this.a.cancel();
      this.a.purge();
      this.a = null;
    }
  }
  
  public void a(int paramInt)
  {
    a();
    this.d = 0;
    this.a = new Timer(true);
    this.b = new b(this);
    this.a.scheduleAtFixedRate(this.b, 1000L, paramInt);
  }
  
  public void a(OnCountDownListener paramOnCountDownListener)
  {
    this.e = paramOnCountDownListener;
  }
  
  public static abstract interface OnCountDownListener
  {
    public abstract void onCountDownFinished();
    
    public abstract void onCountDownRun(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/utils/CountDown.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */