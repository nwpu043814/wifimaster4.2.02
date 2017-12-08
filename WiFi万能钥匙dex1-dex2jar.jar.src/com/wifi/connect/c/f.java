package com.wifi.connect.c;

import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public String a = "wk" + UUID.randomUUID().toString();
  public long b = System.currentTimeMillis();
  public int c;
  public int d;
  public long e;
  public String f;
  public String g;
  public int h;
  public long i;
  public String j;
  public boolean k = false;
  
  private JSONObject b()
  {
    int m = 1;
    if (this.k == true) {}
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("eventId", this.a);
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localJSONObject.put("qryallTime", this.b);
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localJSONObject.put("qryallApcnt", this.c);
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localJSONObject.put("qryallBSSIDcnt", this.d);
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localJSONObject.put("retTime", this.e);
        localJSONObject.put("retStatus", this.f);
        localJSONObject.put("retReason", this.g);
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localJSONObject.put("retKeycnt", this.h);
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localJSONObject.put("retSystime", this.i);
        localJSONObject.put("retQid", this.j);
        localJSONObject.put("dqryNetmodel", String.valueOf(m));
        return localJSONObject;
        m = 0;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          Object localObject = null;
        }
      }
    }
  }
  
  public final JSONArray a()
  {
    JSONObject localJSONObject = b();
    JSONArray localJSONArray;
    if (localJSONObject != null)
    {
      localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject);
    }
    for (;;)
    {
      return localJSONArray;
      localJSONArray = null;
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */