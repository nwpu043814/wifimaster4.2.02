package com.lantern.webox.authz;

import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public long a = System.currentTimeMillis();
  public long b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public int h;
  public boolean i;
  
  public final void a()
  {
    if ((this.h == 101) || (this.h == 1)) {}
    for (;;)
    {
      return;
      this.h = 2;
    }
  }
  
  public final JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("cts", this.a);
      localJSONObject.put("ssid", this.c);
      localJSONObject.put("bssid", this.d);
      localJSONObject.put("aurl", this.e);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("site", this.f + "," + this.g);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("res", this.h);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.a(localJSONException);
        Object localObject = null;
      }
    }
  }
  
  public final String toString()
  {
    Object localObject = b();
    if (localObject != null) {}
    for (localObject = ((JSONObject)localObject).toString();; localObject = "{}") {
      return (String)localObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/authz/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */