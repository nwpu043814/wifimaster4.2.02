package com.linksure.apservice.a.a.c;

import com.linksure.apservice.a.a.a.d;
import java.io.PrintStream;
import org.json.JSONObject;

public abstract class b<T>
  extends d<T>
{
  private String d;
  
  public final void a(String paramString)
  {
    System.out.println("resp:" + paramString);
    this.d = paramString;
    for (;;)
    {
      try
      {
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        if ("H.SYS.0000".equals(localJSONObject.optString("retCd")))
        {
          this.b = localJSONObject.getString("retMsg");
          a(localJSONObject);
          return;
        }
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        this.b = ("resp json err: " + paramString.getMessage());
        continue;
      }
      this.a = localJSONObject.getInt("retCd");
      this.b = localJSONObject.optString("retMsg");
    }
  }
  
  public abstract void a(JSONObject paramJSONObject);
  
  public String toString()
  {
    return this.d;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */