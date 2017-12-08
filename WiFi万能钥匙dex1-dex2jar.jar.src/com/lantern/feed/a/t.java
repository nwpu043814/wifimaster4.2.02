package com.lantern.feed.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.core.imageloader.f;
import com.lantern.feed.b.k;
import java.util.HashMap;
import org.json.JSONObject;

final class t
  implements f
{
  t(m paramm) {}
  
  public final void a()
  {
    h.a("popAdTarget onBitmapFailed", new Object[0]);
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", String.valueOf(m.s(this.a).i()));
    localHashMap.put("reason", "image");
    a.e().onEvent("nfwdshow_ad", new JSONObject(localHashMap).toString());
  }
  
  public final void a(Bitmap paramBitmap)
  {
    h.a("popAdTarget onBitmapLoaded", new Object[0]);
    m.s(this.a).a(paramBitmap);
    m.r(this.a).obtainMessage(42).sendToTarget();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */