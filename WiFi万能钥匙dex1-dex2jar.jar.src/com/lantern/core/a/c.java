package com.lantern.core.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.bluefay.b.i;
import com.lantern.analytics.a;
import com.lantern.core.f;
import com.lantern.core.n;
import com.lantern.core.o;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends AsyncTask<Void, Void, Void>
{
  private Context a;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private Void a()
  {
    label394:
    label408:
    for (;;)
    {
      try
      {
        if (this.a != null)
        {
          Object localObject2 = this.a.getPackageManager();
          JSONArray localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>();
          List localList = ((PackageManager)localObject2).getInstalledPackages(0);
          String str2 = UUID.randomUUID().toString();
          int j = localList.size();
          int i = 0;
          if (i < localList.size())
          {
            localObject2 = (PackageInfo)localList.get(i);
            Object localObject3 = new org/json/JSONObject;
            ((JSONObject)localObject3).<init>();
            try
            {
              if (f.k())
              {
                ((JSONObject)localObject3).put("pkgName", i.a(((PackageInfo)localObject2).packageName));
                ((JSONObject)localObject3).put("versionName", ((PackageInfo)localObject2).versionName);
                ((JSONObject)localObject3).put("versionCode", String.valueOf(((PackageInfo)localObject2).versionCode));
                if (Build.VERSION.SDK_INT >= 9)
                {
                  ((JSONObject)localObject3).put("installTime", String.valueOf(((PackageInfo)localObject2).firstInstallTime));
                  ((JSONObject)localObject3).put("updateTime", String.valueOf(((PackageInfo)localObject2).lastUpdateTime));
                }
                ((JSONObject)localObject3).put("an", "");
                if (((((PackageInfo)localObject2).applicationInfo.flags & 0x80) == 0) && ((((PackageInfo)localObject2).applicationInfo.flags & 0x1) != 0)) {
                  break label394;
                }
                localObject2 = "user";
                ((JSONObject)localObject3).put("appType", localObject2);
                ((JSONObject)localObject3).put("uid", str2);
                ((JSONObject)localObject3).put("size", String.valueOf(j));
                localJSONArray.put(localObject3);
                if (((i + 1) % 5 != 0) && (i + 1 != localList.size())) {
                  break label408;
                }
                localObject2 = com.lantern.core.c.getServer();
                localObject3 = n.a(Uri.encode(localJSONArray.toString().trim(), "UTF-8"), ((o)localObject2).l(), ((o)localObject2).m());
                localObject2 = new org/json/JSONObject;
                ((JSONObject)localObject2).<init>();
                ((JSONObject)localObject2).put("ED", localObject3);
                a.e().b("005022", (JSONObject)localObject2);
                if ((i + 1) % 5 != 0) {
                  break label408;
                }
              }
            }
            catch (Exception localException2) {}
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      try
      {
        localJSONArray = new org/json/JSONArray;
        localJSONArray.<init>();
        i++;
      }
      catch (Exception localException3)
      {
        String str1;
        Object localObject1 = null;
        continue;
      }
      ((JSONObject)localObject3).put("pkgName", ((PackageInfo)localObject2).packageName);
      continue;
      localException2.printStackTrace();
      continue;
      return null;
      str1 = "system";
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */