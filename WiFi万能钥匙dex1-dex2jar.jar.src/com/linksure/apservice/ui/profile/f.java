package com.linksure.apservice.ui.profile;

import android.os.Message;
import com.bluefay.d.b;
import com.linksure.apservice.a.a;
import com.linksure.apservice.a.i;
import org.json.JSONObject;

final class f
  extends b
{
  f(ProfileActivity paramProfileActivity, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    try
    {
      paramMessage = new org/json/JSONObject;
      paramMessage.<init>(str);
      paramMessage = paramMessage.optString("apsId");
      i.a(this.a.getApplication()).a(true, paramMessage, new g(this));
      return;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        paramMessage = "";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */