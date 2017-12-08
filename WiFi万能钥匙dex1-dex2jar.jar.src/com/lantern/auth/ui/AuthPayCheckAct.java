package com.lantern.auth.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.bluefay.a.e;
import com.bluefay.b.d;
import com.bluefay.material.f;
import com.lantern.auth.WkParamsConfig;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.sdk.stub.a;
import com.qihoo.util.StubApp1053578832;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthPayCheckAct
  extends Activity
{
  private f a;
  
  static
  {
    StubApp1053578832.interface11(5);
  }
  
  private static void b(Context paramContext, Intent paramIntent, a parama)
  {
    try
    {
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(parama.d);
      String str1 = ((JSONObject)localObject).getString("scope");
      String str2 = ((JSONObject)localObject).getString("appName");
      String str3 = ((JSONObject)localObject).getString("appIcon");
      localObject = new com/lantern/auth/WkParamsConfig;
      ((WkParamsConfig)localObject).<init>(parama.b, str1, str2, str3);
      parama = (a)localObject;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject;
        com.bluefay.b.h.a(parama);
        parama = null;
      }
    }
    localObject = new Intent("wifi.intent.action.AUTH_MAIN");
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("key_params_config", parama);
    ((Intent)localObject).putExtras(paramIntent.getExtras());
    e.a(paramContext, (Intent)localObject);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  private final class a
    extends AsyncTask<String, Integer, Boolean>
  {
    private Intent b;
    private a c;
    
    public a(Intent paramIntent, a parama)
    {
      this.b = paramIntent;
      this.c = parama;
    }
    
    private static Boolean a(String... paramVarArgs)
    {
      Object localObject = c.getServer().s();
      ((HashMap)localObject).put("sAppId", paramVarArgs[0]);
      localObject = c.getServer().b("05000503", (HashMap)localObject);
      paramVarArgs = com.lantern.auth.h.c();
      if (TextUtils.isEmpty(paramVarArgs))
      {
        paramVarArgs = String.format("%s%s", new Object[] { "https://oauth.51y5.net", "/open-sso/fa.sec" });
        paramVarArgs = new d(paramVarArgs);
        paramVarArgs.a(5000, 5000);
        localObject = paramVarArgs.b((Map)localObject);
        com.bluefay.b.h.a("CheckPayNeedLogin json =" + (String)localObject, new Object[0]);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label177;
        }
      }
      for (;;)
      {
        try
        {
          paramVarArgs = new org/json/JSONObject;
          paramVarArgs.<init>((String)localObject);
          if (!"0".equals(paramVarArgs.optString("retCd"))) {
            break label177;
          }
          boolean bool = paramVarArgs.optBoolean("verify");
          paramVarArgs = Boolean.valueOf(bool);
          return paramVarArgs;
        }
        catch (JSONException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
        paramVarArgs = String.format("%s%s", new Object[] { paramVarArgs, "/open-sso/fa.sec" });
        break;
        label177:
        paramVarArgs = Boolean.valueOf(false);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/AuthPayCheckAct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */