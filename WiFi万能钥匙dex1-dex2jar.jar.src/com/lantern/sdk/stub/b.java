package com.lantern.sdk.stub;

import android.content.Context;
import android.content.Intent;
import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public String a;
  public int b;
  public String c;
  public String d;
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  private boolean a()
  {
    if ((this.a != null) && (this.a.length() > 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(Context paramContext, b paramb)
  {
    boolean bool = false;
    if (paramContext == null) {
      h.c("Context is null");
    }
    for (;;)
    {
      return bool;
      if (!paramb.a())
      {
        h.c("resp is invalid");
      }
      else
      {
        Intent localIntent = new Intent("wifi.intent.action.SDK_RESULT");
        localIntent.putExtra("what", paramb.a);
        localIntent.putExtra("retcode", paramb.b);
        if (paramb.c != null) {
          localIntent.putExtra("retmsg", paramb.c);
        }
        if (paramb.d != null) {
          localIntent.putExtra("data", paramb.d);
        }
        try
        {
          paramContext.sendBroadcast(localIntent);
          bool = true;
        }
        catch (Exception paramContext)
        {
          h.a(paramContext);
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString, b paramb)
  {
    boolean bool = false;
    if (paramContext == null) {
      h.c("Context is null");
    }
    for (;;)
    {
      return bool;
      if (paramString == null)
      {
        h.c("pkg is null");
      }
      else if (!paramb.a())
      {
        h.c("resp is invalid");
      }
      else
      {
        Intent localIntent = new Intent("wifi.intent.action.SDK_RESULT");
        localIntent.setPackage(paramString);
        localIntent.putExtra("what", paramb.a);
        localIntent.putExtra("retcode", paramb.b);
        if (paramb.c != null) {
          localIntent.putExtra("retmsg", paramb.c);
        }
        if (paramb.d != null) {
          localIntent.putExtra("data", paramb.d);
        }
        try
        {
          localIntent.addFlags(268435456).addFlags(134217728);
          paramContext.startActivity(localIntent);
          bool = true;
        }
        catch (Exception paramContext)
        {
          h.a(paramContext);
        }
      }
    }
  }
  
  private JSONObject b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("what", this.a);
      localJSONObject1.put("retcode", this.b);
      localJSONObject1.put("retmsg", this.c);
      localJSONObject1.put("data", this.d);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.a(localJSONException);
        JSONObject localJSONObject2 = new JSONObject();
      }
    }
  }
  
  public final String toString()
  {
    return b().toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/sdk/stub/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */