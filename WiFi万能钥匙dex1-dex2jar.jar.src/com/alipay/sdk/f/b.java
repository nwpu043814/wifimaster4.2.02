package com.alipay.sdk.f;

import android.text.TextUtils;
import org.json.JSONObject;

public final class b
{
  String a;
  public String b;
  
  public b(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = null;
    if (TextUtils.isEmpty(this.b)) {}
    for (;;)
    {
      return localJSONObject;
      try
      {
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(this.b);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public final String toString()
  {
    return "\nenvelop:" + this.a + "\nbody:" + this.b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */