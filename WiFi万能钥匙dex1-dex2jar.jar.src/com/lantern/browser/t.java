package com.lantern.browser;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.lantern.core.c;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

final class t
  implements DialogInterface.OnClickListener
{
  t(n paramn, j paramj, int paramInt1, int paramInt2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("url", this.a.a());
    paramDialogInterface.put("pkg", this.a.c());
    paramDialogInterface.put("click", "y");
    Object localObject = new JSONObject(paramDialogInterface).toString();
    paramDialogInterface.clear();
    paramDialogInterface.put("funId", "brogprstp");
    paramDialogInterface.put("ext", localObject);
    paramDialogInterface.put("cts", String.valueOf(System.currentTimeMillis()));
    com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(paramDialogInterface)));
    localObject = this.d;
    c.getAppContext();
    ((n)localObject).a().c(new long[] { this.a.b() });
    if (!this.a.d())
    {
      if ((this.b == 0) || (this.c == 2))
      {
        localObject = new ContentValues();
        ((ContentValues)localObject).put("is_visible_in_downloads_ui", Boolean.valueOf(true));
        ((ContentValues)localObject).put("visibility", Integer.valueOf(0));
        c.getAppContext().getContentResolver().update(com.lantern.core.model.a.a, (ContentValues)localObject, "_id= ?", new String[] { String.valueOf(this.a.b()) });
        paramDialogInterface.clear();
        paramDialogInterface.put("url", this.a.a());
        paramDialogInterface.put("pkg", this.a.c());
        localObject = new JSONObject(paramDialogInterface).toString();
        paramDialogInterface.clear();
        paramDialogInterface.put("funId", "brostdsta");
        paramDialogInterface.put("ext", localObject);
        paramDialogInterface.put("cts", String.valueOf(System.currentTimeMillis()));
        com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(paramDialogInterface)));
        paramDialogInterface.clear();
        paramDialogInterface.put("funId", "brosltfst");
        paramDialogInterface.put("ext", localObject);
        paramDialogInterface.put("cts", String.valueOf(System.currentTimeMillis()));
        com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(paramDialogInterface)));
      }
      Toast.makeText(n.c(this.d), R.string.browser_download_start, 0).show();
    }
    n.b(this.d).put(Long.valueOf(this.a.b()), this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */