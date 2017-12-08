package com.lantern.core.model;

import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private String a;
  private String b;
  
  public e()
  {
    this((byte)0);
  }
  
  private e(byte paramByte)
  {
    this.a = "";
    this.b = "";
  }
  
  public e(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.optString("retCd", "");
    }
    for (this.b = paramJSONObject.optString("retMsg", "");; this.b = "")
    {
      return;
      this.a = "";
    }
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final void b(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean c()
  {
    return "0".equals(this.a);
  }
  
  public final boolean d()
  {
    return "H.SEC.0100".equals(this.a);
  }
  
  public final boolean e()
  {
    return "H.SYS.0003".equals(this.a);
  }
  
  public JSONObject f()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("retcode", this.a);
      localJSONObject1.put("retmsg", this.b);
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
  
  public String toString()
  {
    return f().toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */