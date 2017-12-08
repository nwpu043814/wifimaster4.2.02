package com.wifi.connect.b;

import android.os.Message;
import com.bluefay.b.a;
import com.bluefay.b.h;
import com.bluefay.d.b;

final class ak
  extends b
{
  ak(aj paramaj, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    h.a("handle what:" + i);
    if (i == 128002) {
      if (aj.a(this.a) != null) {
        aj.a(this.a).a(1, "SCAN_RESULTS_AVAILABLE", null);
      }
    }
    for (;;)
    {
      return;
      if (i == 101)
      {
        aj.b(this.a);
        aj.d(this.a).sendEmptyMessageDelayed(101, aj.c(this.a));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */