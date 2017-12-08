package com.lantern.auth.c;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.d;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private String b;
  
  public a(com.bluefay.b.a parama)
  {
    this.a = parama;
  }
  
  private Integer a(String... paramVarArgs)
  {
    if (!com.bluefay.a.a.c(c.getAppContext())) {
      paramVarArgs = Integer.valueOf(10);
    }
    for (;;)
    {
      return paramVarArgs;
      c.getServer().f("05000502");
      Object localObject = paramVarArgs[0];
      String str = paramVarArgs[1];
      paramVarArgs = c.getServer().s();
      paramVarArgs.put("uhid", p.d(c.getAppContext(), ""));
      paramVarArgs.put("thirdAppId", localObject);
      paramVarArgs.put("scope", str);
      paramVarArgs.put("token", p.f(c.getInstance()));
      localObject = c.getServer().b("05000502", paramVarArgs);
      paramVarArgs = com.lantern.auth.h.c();
      if (TextUtils.isEmpty(paramVarArgs)) {}
      for (paramVarArgs = String.format("%s%s", new Object[] { "https://oauth.51y5.net", "/open-sso/fa.sec" });; paramVarArgs = String.format("%s%s", new Object[] { paramVarArgs, "/open-sso/fa.sec" }))
      {
        localObject = d.a(paramVarArgs, (Map)localObject);
        com.bluefay.b.h.a("AuthKeyTask json " + (String)localObject, new Object[0]);
        if ((localObject != null) && (((String)localObject).length() != 0)) {
          break label207;
        }
        paramVarArgs = Integer.valueOf(10);
        break;
      }
      try
      {
        label207:
        paramVarArgs = new org/json/JSONObject;
        paramVarArgs.<init>((String)localObject);
        if ("0".equals(paramVarArgs.getString("retCd"))) {
          break;
        }
        i = 0;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          int j = 30;
          continue;
          int i = 1;
        }
      }
      j = i;
      if (paramVarArgs.has("ak"))
      {
        this.b = paramVarArgs.getString("ak");
        j = i;
      }
      paramVarArgs = Integer.valueOf(j);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */