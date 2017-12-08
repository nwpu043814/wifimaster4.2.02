package com.lantern.wifilocating.push.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.j;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static a a;
  private Context b;
  private com.lantern.wifilocating.push.a.a.a c;
  private ExecutorService d = Executors.newSingleThreadExecutor();
  private String e = "005012";
  private BroadcastReceiver f = new b(this);
  
  private a(Context paramContext)
  {
    this.b = paramContext;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ("com.snda.wifilocating.push".contains(":"))
    {
      String[] arrayOfString = "com.snda.wifilocating.push".split(":");
      localObject1 = localObject2;
      if (arrayOfString != null)
      {
        localObject1 = localObject2;
        if (arrayOfString.length == 2) {
          localObject1 = arrayOfString[1];
        }
      }
    }
    h.a("subprocess:" + (String)localObject1);
    this.c = new com.lantern.wifilocating.push.a.a.a(paramContext, (String)localObject1);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    this.b.registerReceiver(this.f, paramContext);
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {
      a = new a(paramContext.getApplicationContext());
    }
    return a;
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.d.execute(new com.lantern.wifilocating.push.a.c.a(paramString, paramJSONObject));
    }
  }
  
  public static a c()
  {
    if (a == null) {
      throw new IllegalArgumentException("Agent need init first");
    }
    return a;
  }
  
  public final com.lantern.wifilocating.push.a.a.a a()
  {
    return this.c;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString2);
      paramString2 = localJSONObject;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        h.a(paramString2);
        paramString2 = null;
      }
    }
    a(paramString1, paramString2);
  }
  
  public final void a(String paramString, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      this.d.execute(new com.lantern.wifilocating.push.a.c.b(paramString, paramJSONArray));
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!j.c(this.b)) {}
    for (;;)
    {
      return;
      if ((paramBoolean) && (!j.d(this.b))) {
        h.c("is not wifi connected, sumbitEventLog not upload");
      } else {
        this.d.execute(new com.lantern.wifilocating.push.a.c.b());
      }
    }
  }
  
  public final void b()
  {
    a(true);
  }
  
  public final void b(String paramString, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      this.d.execute(new com.lantern.wifilocating.push.a.c.a(paramString, paramJSONArray));
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
        a(this.e, paramString);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */