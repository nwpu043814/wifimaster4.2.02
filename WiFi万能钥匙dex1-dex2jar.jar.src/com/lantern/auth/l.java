package com.lantern.auth;

import android.content.Context;
import android.os.AsyncTask;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.f;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l
{
  private Context a;
  private com.bluefay.b.a b;
  
  public l(Context paramContext, com.bluefay.b.a parama)
  {
    this.a = paramContext;
    this.b = parama;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    new a().execute(new String[] { paramString1, paramString2 });
  }
  
  final class a
    extends AsyncTask<String, Integer, Integer>
  {
    private String b = null;
    
    a() {}
    
    private Integer a(String... paramVarArgs)
    {
      if (!com.bluefay.a.a.c(l.a(l.this))) {
        paramVarArgs = Integer.valueOf(10);
      }
      for (;;)
      {
        return paramVarArgs;
        c.getServer().f("00200501");
        Object localObject = paramVarArgs[0];
        String str = paramVarArgs[1];
        paramVarArgs = c.getServer().s();
        paramVarArgs.put("thirdAppId", localObject);
        paramVarArgs.put("scope", str);
        localObject = c.getServer().b("00200501", paramVarArgs);
        paramVarArgs = f.a(c.getAppContext()).a("ssohost");
        if (paramVarArgs != null) {}
        for (paramVarArgs = String.format("%s%s", new Object[] { paramVarArgs, "/sso/fa.sec" });; paramVarArgs = String.format("%s%s", new Object[] { "https://sso.51y5.net", "/sso/fa.sec" }))
        {
          paramVarArgs = d.a(paramVarArgs, (Map)localObject);
          if ((paramVarArgs != null) && (paramVarArgs.length() != 0)) {
            break label161;
          }
          paramVarArgs = Integer.valueOf(10);
          break;
        }
        try
        {
          label161:
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>("--------json--------");
          h.a(paramVarArgs, new Object[0]);
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramVarArgs);
          if ("0".equals(((JSONObject)localObject).getString("retCd"))) {
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
        if (((JSONObject)localObject).has("code"))
        {
          this.b = ((JSONObject)localObject).getString("code");
          j = i;
        }
        paramVarArgs = Integer.valueOf(j);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */