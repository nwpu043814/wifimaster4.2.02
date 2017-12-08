package com.lantern.core.model;

import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public final String toString()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("mobile", this.a);
      ((JSONObject)localObject).put("uhid", this.b);
      ((JSONObject)localObject).put("sim", this.c);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.a(localJSONException);
        String str = "";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/model/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */