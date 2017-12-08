package com.wifipay.wallet.common.utils;

import android.os.Handler;
import java.util.TimerTask;

class b
  extends TimerTask
{
  b(CountDown paramCountDown) {}
  
  public void run()
  {
    CountDown.a(this.a);
    if (CountDown.b(this.a) - CountDown.c(this.a) <= 0)
    {
      this.a.a();
      CountDown.d(this.a).sendEmptyMessage(1);
    }
    for (;;)
    {
      return;
      CountDown.d(this.a).sendEmptyMessage(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */