package com.lantern.analytics.d;

import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.f;
import com.lantern.core.o;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  public final void run()
  {
    if (!c.getServer().i()) {}
    File localFile;
    for (;;)
    {
      return;
      File[] arrayOfFile = com.lantern.analytics.a.e().b().a();
      if (arrayOfFile != null)
      {
        int k = arrayOfFile.length;
        for (int j = 0; j < k; j++)
        {
          localFile = arrayOfFile[j];
          h.a("start upload file:" + localFile.getAbsolutePath(), new Object[0]);
          if ((localFile == null) || (localFile.length() <= 51200L)) {
            break label107;
          }
          localFile.delete();
          com.lantern.analytics.a.e().onEvent("crashlar");
        }
      }
    }
    label107:
    String str1 = f.a().a("host");
    if (str1 != null) {}
    for (str1 = String.format("%s%s", new Object[] { str1, "/dc/fa.do" });; str1 = String.format("%s%s", new Object[] { "http://cr.51y5.net", "/dc/fa.do" }))
    {
      String str2 = com.bluefay.b.b.a(localFile, "utf-8");
      Object localObject = c.getServer().s();
      ((HashMap)localObject).put("pid", "00500101");
      ((HashMap)localObject).put("dcType", "005011");
      ((HashMap)localObject).put("msg", str2);
      str2 = d.a(str1, c.getServer().a((HashMap)localObject));
      h.a("JSON:" + str2, new Object[0]);
      if ((str2 == null) || (str2.length() == 0)) {
        break;
      }
      str1 = null;
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(str2);
        if ("0".equals(((JSONObject)localObject).getString("retCd"))) {
          break label374;
        }
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          h.a(localJSONException);
          int i = 30;
          continue;
          i = 1;
        }
      }
      if (((JSONObject)localObject).has("retMsg")) {
        str1 = ((JSONObject)localObject).getString("retMsg");
      }
      h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(i), str1 });
      if (i != 1) {
        break;
      }
      com.lantern.analytics.a.e().b().b(localFile.getName());
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */