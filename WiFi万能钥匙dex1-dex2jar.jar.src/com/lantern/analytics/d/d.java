package com.lantern.analytics.d;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.f;
import com.lantern.core.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private String b;
  
  public d(com.bluefay.b.a parama)
  {
    this.a = parama;
  }
  
  private static Integer a(String... paramVarArgs)
  {
    Object localObject2 = null;
    if (!c.getServer().i()) {}
    for (paramVarArgs = Integer.valueOf(0);; paramVarArgs = Integer.valueOf(10))
    {
      return paramVarArgs;
      if (com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {
        break;
      }
    }
    String str2 = paramVarArgs[0];
    String str3 = paramVarArgs[1];
    Object localObject1;
    if (paramVarArgs.length > 3)
    {
      localObject1 = paramVarArgs[2];
      paramVarArgs = paramVarArgs[3];
    }
    for (;;)
    {
      String str1 = f.b();
      if (str1 != null) {}
      for (str1 = String.format("%s%s", new Object[] { str1, "/app/fa.sec" });; str1 = String.format("%s%s", new Object[] { "http://app.51y5.net", "/app/fa.sec" }))
      {
        com.bluefay.d.a.getAppContext();
        HashMap localHashMap = c.getServer().s();
        localHashMap.put("pid", "00600201");
        localHashMap.put("content", str2);
        localHashMap.put("contact", str3);
        if (localObject1 != null) {
          localHashMap.put("feedbackType", localObject1);
        }
        if (!TextUtils.isEmpty(paramVarArgs)) {
          localHashMap.put("sex", paramVarArgs);
        }
        h.a("params:%s", new Object[] { localHashMap });
        paramVarArgs = com.bluefay.b.d.a(str1, c.getServer().b("00600201", localHashMap));
        if ((paramVarArgs != null) && (paramVarArgs.length() != 0)) {
          break label231;
        }
        paramVarArgs = Integer.valueOf(10);
        break;
      }
      label231:
      h.a("JSON:" + paramVarArgs, new Object[0]);
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramVarArgs);
        if ("0".equals(((JSONObject)localObject1).getString("retCd"))) {
          break label337;
        }
        i = 0;
      }
      catch (JSONException paramVarArgs)
      {
        for (;;)
        {
          h.a(paramVarArgs);
          int i = 30;
          continue;
          i = 1;
        }
      }
      paramVarArgs = (String[])localObject2;
      if (((JSONObject)localObject1).has("retMsg")) {
        paramVarArgs = ((JSONObject)localObject1).getString("retMsg");
      }
      h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(i), paramVarArgs });
      paramVarArgs = Integer.valueOf(i);
      break;
      label337:
      paramVarArgs = null;
      localObject1 = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */