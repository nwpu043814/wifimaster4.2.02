package com.wifipay.wallet.common.utils;

import android.os.Handler;
import android.os.Message;

class c
  extends Handler
{
  c(CountDown paramCountDown) {}
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        }
      }
      catch (Exception paramMessage)
      {
        continue;
        if (CountDown.e(this.a) == null) {
          continue;
        }
        CountDown.e(this.a).onCountDownFinished();
        continue;
      }
      finally {}
      return;
      if (CountDown.e(this.a) != null) {
        CountDown.e(this.a).onCountDownRun(CountDown.b(this.a), CountDown.b(this.a) - CountDown.c(this.a));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */