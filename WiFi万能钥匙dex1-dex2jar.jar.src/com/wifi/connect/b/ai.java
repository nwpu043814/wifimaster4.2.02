package com.wifi.connect.b;

import android.content.Intent;
import android.os.Message;
import com.bluefay.b.a;
import com.bluefay.b.h;
import com.bluefay.d.b;

final class ai
  extends b
{
  ai(ah paramah, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    h.a("handle what:" + i);
    if (i == 128001)
    {
      i = ((Intent)paramMessage.obj).getIntExtra("wifi_state", 4);
      h.a("state:" + i);
      if (ah.a(this.a) != null) {
        ah.a(this.a).a(1, "", Integer.valueOf(i));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */