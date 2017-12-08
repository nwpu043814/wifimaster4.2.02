package com.lantern.core.a;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.lantern.core.config.AppListSaveConf;
import com.lantern.core.config.d;
import com.lantern.core.p;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static a a;
  private com.bluefay.b.a b = new b(this);
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public final void b()
  {
    Object localObject1 = new JSONObject();
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("v", "0");
      ((JSONObject)localObject2).put("ts", "0");
      ((JSONObject)localObject1).put("pkgsav", localObject2);
      new com.lantern.core.config.a.a(this.b, (JSONObject)localObject1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        try
        {
          localObject1 = com.lantern.core.c.getAppContext();
          localObject2 = (AppListSaveConf)d.a((Context)localObject1).a(AppListSaveConf.class);
          if (localObject2 != null)
          {
            l2 = ((AppListSaveConf)localObject2).c();
            l1 = p.a((Context)localObject1, "sdk_common", "app_list_recode_time", 0L);
            boolean bool = TextUtils.isEmpty(((AppListSaveConf)localObject2).d());
            if (!bool) {
              continue;
            }
          }
          return;
        }
        catch (Exception localException)
        {
          long l2;
          long l1;
          long l3;
          c localc;
          localException.printStackTrace();
          continue;
        }
        localJSONException = localJSONException;
        localJSONException.printStackTrace();
        continue;
        l3 = Long.parseLong(localJSONException.d());
        if ((l2 != -1L) && (l3 > 0L) && ((l1 == 0L) || (l2 - l1 >= l3)))
        {
          p.b((Context)localObject1, "sdk_common", "app_list_recode_time", l2);
          localc = new com/lantern/core/a/c;
          localc.<init>((Context)localObject1);
          localc.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */