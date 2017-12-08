package com.lantern.browser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

final class u
  implements DialogInterface.OnClickListener
{
  u(n paramn, j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("url", this.a.a());
    paramDialogInterface.put("pkg", this.a.c());
    paramDialogInterface.put("click", "n");
    String str = new JSONObject(paramDialogInterface).toString();
    paramDialogInterface.clear();
    paramDialogInterface.put("funId", "brogprstp");
    paramDialogInterface.put("ext", str);
    paramDialogInterface.put("cts", String.valueOf(System.currentTimeMillis()));
    a.e().a("005012", new JSONArray().put(new JSONObject(paramDialogInterface)));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */