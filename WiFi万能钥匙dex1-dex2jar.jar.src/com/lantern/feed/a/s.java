package com.lantern.feed.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.core.imageloader.f;
import java.util.HashMap;
import org.json.JSONObject;

final class s
  implements f
{
  s(m paramm) {}
  
  public final void a()
  {
    h.a("onReqPopSuccess onBitmapFailed", new Object[0]);
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", String.valueOf(m.q(this.a).a()));
    localHashMap.put("reason", "image");
    a.e().onEvent("nfwdshow", new JSONObject(localHashMap).toString());
  }
  
  public final void a(Bitmap paramBitmap)
  {
    h.a("onReqPopSuccess onBitmapLoaded", new Object[0]);
    m.q(this.a).a(paramBitmap);
    m.r(this.a).obtainMessage(35, m.q(this.a)).sendToTarget();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */