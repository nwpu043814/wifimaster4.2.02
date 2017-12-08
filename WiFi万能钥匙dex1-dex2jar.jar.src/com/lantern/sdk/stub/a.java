package com.lantern.sdk.stub;

import android.content.Intent;
import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  public static a a(Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramIntent == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (a)localObject1;
      localObject1 = localObject2;
      try
      {
        if (paramIntent.hasExtra("what"))
        {
          localObject1 = new com/lantern/sdk/stub/a;
          ((a)localObject1).<init>(paramIntent.getStringExtra("what"));
          ((a)localObject1).b = paramIntent.getStringExtra("appid");
          ((a)localObject1).c = paramIntent.getStringExtra("pkg");
          ((a)localObject1).d = paramIntent.getStringExtra("param");
        }
      }
      catch (Throwable paramIntent)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  private JSONObject b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("what", this.a);
      localJSONObject1.put("appid", this.b);
      localJSONObject1.put("pkg", this.c);
      localJSONObject1.put("param", this.d);
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
  
  public final boolean a()
  {
    if ((this.a != null) && (this.a.length() > 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final String toString()
  {
    return b().toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/sdk/stub/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */