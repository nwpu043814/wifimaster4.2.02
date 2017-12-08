package com.wifi.connect.model;

import com.bluefay.b.h;
import com.lantern.core.model.WkAccessPoint;
import org.json.JSONException;
import org.json.JSONObject;

public class AccessPointMasterInfo
  extends WkAccessPoint
{
  public String e;
  public String f;
  public String g;
  
  public final JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ssid", this.a);
      localJSONObject.put("alias", this.f);
      localJSONObject.put("homepage", this.e);
      localJSONObject.put("address", this.g);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.a(localJSONException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/AccessPointMasterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */