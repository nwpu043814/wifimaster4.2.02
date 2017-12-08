package com.lantern.feed.ui;

import android.os.Message;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.bluefay.d.b;
import com.lantern.feed.b.g;
import org.json.JSONObject;

final class ax
  extends b
{
  ax(aw paramaw, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    String str1 = (String)paramMessage.obj;
    for (;;)
    {
      try
      {
        paramMessage = new org/json/JSONObject;
        paramMessage.<init>(str1);
        str1 = paramMessage.optString("apsId");
        String str2 = this.a.k.U();
        if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
          break;
        }
        if (paramMessage.optInt("stat") != 1) {
          break label140;
        }
        bool = true;
        if (bool == this.a.k.R()) {
          break;
        }
        this.a.k.b(bool);
        aw.a(this.a);
        this.a.requestLayout();
      }
      catch (Exception paramMessage)
      {
        h.a(paramMessage);
      }
      break;
      label140:
      boolean bool = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */