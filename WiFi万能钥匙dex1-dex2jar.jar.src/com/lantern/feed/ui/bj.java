package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.lantern.analytics.a;
import com.lantern.feed.b.k;
import java.util.HashMap;
import org.json.JSONObject;

final class bj
  extends CountDownTimer
{
  bj(bi parambi, long paramLong)
  {
    super(paramLong, 1000L);
  }
  
  public final void onFinish()
  {
    this.a.dismiss();
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", bi.b(this.a).i());
    localHashMap.put("type", "auto");
    a.e().onEvent("nfw1_ad", new JSONObject(localHashMap).toString());
  }
  
  public final void onTick(long paramLong)
  {
    bi.a(this.a).setText(String.valueOf((int)(paramLong / 1000L)));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */