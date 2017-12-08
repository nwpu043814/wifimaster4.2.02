package com.lantern.browser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

final class v
  implements DialogInterface.OnClickListener
{
  v(n paramn, j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("url", this.a.a());
    paramDialogInterface.put("pkg", this.a.c());
    paramDialogInterface.put("click", "y");
    String str = new JSONObject(paramDialogInterface).toString();
    paramDialogInterface.clear();
    paramDialogInterface.put("funId", "brogprstp");
    paramDialogInterface.put("ext", str);
    paramDialogInterface.put("cts", String.valueOf(System.currentTimeMillis()));
    a.e().a("005012", new JSONArray().put(new JSONObject(paramDialogInterface)));
    this.a.a(n.a(this.b, this.a));
    n.b(this.b).put(Long.valueOf(this.a.b()), this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */