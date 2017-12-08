package com.lantern.wifilocating.push.g.c;

import org.json.JSONObject;

public abstract class c
{
  private boolean a;
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      if (this.a)
      {
        paramJSONObject = new java/lang/RuntimeException;
        paramJSONObject.<init>("Processor has Excuted");
        throw paramJSONObject;
      }
    }
    finally {}
    this.a = true;
    d locald = new com/lantern/wifilocating/push/g/c/d;
    locald.<init>(this, paramJSONObject);
    locald.start();
  }
  
  public abstract void b(JSONObject paramJSONObject);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/g/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */