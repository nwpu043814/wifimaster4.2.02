package com.lantern.analytics.c;

import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String g;
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.a != null) {
        localJSONObject.put("exceptionClassName", this.a);
      }
      if (this.b != null) {
        localJSONObject.put("exceptionMessage", this.b);
      }
      if (this.c != null) {
        localJSONObject.put("throwFileName", this.c);
      }
      if (this.d != null) {
        localJSONObject.put("throwClassName", this.d);
      }
      if (this.e != null) {
        localJSONObject.put("throwMethodName", this.e);
      }
      localJSONObject.put("throwLineNumber", String.valueOf(this.f));
      if (this.g != null) {
        localJSONObject.put("stackTrace", this.g);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.c(localJSONException.getMessage());
      }
    }
    return localJSONObject.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */