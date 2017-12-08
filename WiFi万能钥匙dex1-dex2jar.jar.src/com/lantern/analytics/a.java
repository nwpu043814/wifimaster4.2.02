package com.lantern.analytics;

import android.app.Activity;
import android.app.ApplicationErrorReport;
import android.app.ApplicationErrorReport.CrashInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.bluefay.b.h;
import com.lantern.analytics.a.d;
import com.lantern.analytics.b.a.a;
import com.lantern.analytics.b.e;
import com.lantern.core.g.n;
import com.lantern.core.model.f;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements a.a
{
  private static a a;
  private Context b;
  private com.lantern.analytics.b.a c;
  private d d;
  private com.lantern.analytics.a.a e;
  private ExecutorService f = Executors.newSingleThreadExecutor();
  private String g = "005012";
  private com.bluefay.b.a h = new b(this);
  private BroadcastReceiver i = new c(this);
  
  private a(Context paramContext)
  {
    this.b = paramContext;
    Object localObject3 = com.lantern.core.c.getProcessName();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject3).contains(":"))
      {
        localObject3 = ((String)localObject3).split(":");
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (localObject3.length == 2) {
            localObject1 = localObject3[1];
          }
        }
      }
    }
    h.a("subprocess:" + (String)localObject1);
    this.d = new d(paramContext, (String)localObject1);
    this.e = new com.lantern.analytics.a.a(paramContext, (String)localObject1);
    this.c = new com.lantern.analytics.b.a();
    this.c.a(this);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    this.b.registerReceiver(this.i, paramContext);
  }
  
  public static a a(Context paramContext)
  {
    f localf = n.a();
    if (a == null)
    {
      a = new a(paramContext.getApplicationContext());
      com.lantern.core.c.getServer().a(localf.a);
      com.lantern.core.c.getServer().a(localf.b, localf.c, localf.d);
    }
    return a;
  }
  
  public static void a(Activity paramActivity)
  {
    e();
    paramActivity = paramActivity.getClass().getName();
    h.a("onPause:" + paramActivity);
  }
  
  public static void b(Activity paramActivity)
  {
    e();
    paramActivity = paramActivity.getClass().getName();
    h.a("onResume:" + paramActivity);
  }
  
  public static a e()
  {
    if (a == null) {
      throw new IllegalArgumentException("Agent need init first");
    }
    return a;
  }
  
  public final d a()
  {
    return this.d;
  }
  
  public final void a(String paramString)
  {
    Object localObject = new HashMap();
    if ("".length() > 0) {
      ((HashMap)localObject).put("ext", "");
    }
    ((Map)localObject).put("funId", paramString);
    ((Map)localObject).put("cts", String.valueOf(System.currentTimeMillis()));
    try
    {
      paramString = new org/json/JSONObject;
      paramString.<init>((Map)localObject);
      localObject = new JSONArray();
      ((JSONArray)localObject).put(paramString);
      a(this.g, (JSONArray)localObject);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
        paramString = null;
      }
    }
  }
  
  public final void a(String paramString, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      this.f.execute(new com.lantern.analytics.d.c(paramString, paramJSONArray));
    }
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    a(paramString, paramJSONObject, true);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject != null) {
      this.f.execute(new com.lantern.analytics.d.c(paramString, paramJSONObject, paramBoolean));
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    ApplicationErrorReport localApplicationErrorReport = new ApplicationErrorReport();
    localApplicationErrorReport.packageName = this.b.getPackageName();
    localApplicationErrorReport.processName = this.b.getPackageName();
    localApplicationErrorReport.time = System.currentTimeMillis();
    localApplicationErrorReport.type = 1;
    localApplicationErrorReport.crashInfo = new ApplicationErrorReport.CrashInfo(paramThrowable);
    h.c("crashinfo:" + localApplicationErrorReport.crashInfo.stackTrace);
    paramThrowable = new e(this.b, localApplicationErrorReport).a();
    this.e.a(paramThrowable);
  }
  
  public final com.lantern.analytics.a.a b()
  {
    return this.e;
  }
  
  public final void b(String paramString, JSONArray paramJSONArray)
  {
    this.f.execute(new com.lantern.analytics.d.a(paramString, paramJSONArray));
  }
  
  public final void b(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.f.execute(new com.lantern.analytics.d.a(paramString, paramJSONObject));
    }
  }
  
  public final void c()
  {
    if (!com.bluefay.a.a.c(this.b)) {}
    for (;;)
    {
      return;
      if (!com.bluefay.a.a.a(this.b)) {
        h.c("is not wifi connected, sumbitCrashLog not upload");
      } else {
        this.f.execute(new com.lantern.analytics.d.b());
      }
    }
  }
  
  public final void d()
  {
    if (!com.bluefay.a.a.c(this.b)) {}
    for (;;)
    {
      return;
      if (!com.bluefay.a.a.a(this.b)) {
        h.c("is not wifi connected, sumbitEventLog not upload");
      } else {
        this.f.execute(new com.lantern.analytics.d.c());
      }
    }
  }
  
  public final void onEvent(String paramString)
  {
    onEvent(paramString, "");
  }
  
  public final void onEvent(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localHashMap.put("ext", paramString2);
    }
    onEvent(paramString1, localHashMap);
  }
  
  public final void onEvent(String paramString, Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      paramMap.put("funId", paramString);
      paramMap.put("cts", String.valueOf(System.currentTimeMillis()));
      try
      {
        paramString = new org/json/JSONObject;
        paramString.<init>(paramMap);
        b(this.g, paramString);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          h.a(paramString);
          paramString = null;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */