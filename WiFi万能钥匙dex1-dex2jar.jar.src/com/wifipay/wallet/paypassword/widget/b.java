package com.wifipay.wallet.paypassword.widget;

import android.os.Handler.Callback;
import android.os.Message;
import com.wifipay.framework.api.d;
import java.util.ArrayList;

class b
  implements Handler.Callback
{
  b(WPSafeKeyboard paramWPSafeKeyboard) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    WPSafeKeyboard.a(this.a).b(2);
    if ((paramMessage.what == 1) && (WPSafeKeyboard.b(this.a).size() == 6))
    {
      WPSafeKeyboard.a(this.a, (String)paramMessage.obj);
      WPSafeKeyboard.c(this.a).onCompleted(true);
    }
    for (;;)
    {
      if (this.a.b())
      {
        paramMessage = WPSafeKeyboard.d(this.a);
        WPSafeKeyboard.e(this.a).a(paramMessage);
      }
      return true;
      WPSafeKeyboard.c(this.a).onCompleted(false);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */