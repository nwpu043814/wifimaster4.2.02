package com.wifi.connect.c;

import com.bluefay.b.h;
import com.lantern.core.model.WkAccessPoint;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public String a;
  public String b;
  public String c;
  public ArrayList<WkAccessPoint> d;
  public String e;
  public long f;
  
  public b()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = new ArrayList();
  }
  
  public b(String paramString1, String paramString2, String paramString3, ArrayList<WkAccessPoint> paramArrayList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramArrayList;
  }
  
  public static b a(JSONArray paramJSONArray)
  {
    int i = 0;
    if (paramJSONArray.length() == 0)
    {
      localObject = null;
      return (b)localObject;
    }
    b localb = new b();
    Object localObject = paramJSONArray.getJSONObject(0);
    localb.b = ((JSONObject)localObject).getString("la");
    localb.a = ((JSONObject)localObject).getString("lo");
    localb.c = ((JSONObject)localObject).getString("mapSP");
    localb.d = new ArrayList();
    int j = paramJSONArray.length();
    for (;;)
    {
      localObject = localb;
      if (i >= j) {
        break;
      }
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      localObject = new WkAccessPoint();
      ((WkAccessPoint)localObject).a = localJSONObject.optString("ssid");
      ((WkAccessPoint)localObject).b = localJSONObject.optString("bssid");
      ((WkAccessPoint)localObject).c = localJSONObject.optInt("secLevel");
      ((WkAccessPoint)localObject).d = localJSONObject.optInt("rssi");
      localb.d.add(localObject);
      i++;
    }
  }
  
  private JSONArray a()
  {
    JSONArray localJSONArray;
    if ((this.a == null) || (this.a.length() == 0)) {
      localJSONArray = null;
    }
    for (;;)
    {
      return localJSONArray;
      if ((this.b == null) || (this.b.length() == 0)) {
        localJSONArray = null;
      } else if ((this.d == null) || (this.d.size() == 0)) {
        localJSONArray = null;
      } else {
        try
        {
          localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>();
          long l = System.currentTimeMillis();
          Iterator localIterator = this.d.iterator();
          while (localIterator.hasNext())
          {
            WkAccessPoint localWkAccessPoint = (WkAccessPoint)localIterator.next();
            JSONObject localJSONObject = new org/json/JSONObject;
            localJSONObject.<init>();
            localJSONObject.put("ssid", localWkAccessPoint.a);
            localJSONObject.put("bssid", localWkAccessPoint.b);
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localJSONObject.put("rssi", localWkAccessPoint.d);
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localJSONObject.put("secLevel", localWkAccessPoint.c);
            localJSONObject.put("la", this.b);
            localJSONObject.put("lo", this.a);
            localJSONObject.put("mapSP", this.c);
            localJSONObject.put("ts", String.valueOf(l));
            localJSONArray.put(localJSONObject);
          }
        }
        catch (JSONException localJSONException)
        {
          h.a(localJSONException);
          Object localObject = null;
        }
      }
    }
  }
  
  public final String toString()
  {
    Object localObject = a();
    if (localObject != null) {}
    for (localObject = ((JSONArray)localObject).toString();; localObject = "[]") {
      return (String)localObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */