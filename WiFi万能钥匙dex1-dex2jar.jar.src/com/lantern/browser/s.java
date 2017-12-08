package com.lantern.browser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

final class s
  implements DialogInterface.OnClickListener
{
  s(n paramn, j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", this.a.a());
    localHashMap.put("pkg", this.a.c());
    localHashMap.put("click", "n");
    paramDialogInterface = new JSONObject(localHashMap).toString();
    localHashMap.clear();
    localHashMap.put("funId", "brogprstp");
    localHashMap.put("ext", paramDialogInterface);
    localHashMap.put("cts", String.valueOf(System.currentTimeMillis()));
    a.e().a("005012", new JSONArray().put(new JSONObject(localHashMap)));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */