package com.lantern.core.model;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.bluefay.b.h;
import com.lantern.core.g.u;
import org.json.JSONException;
import org.json.JSONObject;

public class WkAccessPoint
  implements Parcelable
{
  public static final Parcelable.Creator<WkAccessPoint> CREATOR = new b();
  public String a;
  public String b;
  public int c;
  public int d;
//      localJSONObject1.put("ssid", this.a);
//      localJSONObject1.put("bssid", this.b);
//      localJSONObject1.put("securityLevel", String.valueOf(this.c));
//      localJSONObject1.put("rssi", String.valueOf(this.d));
  
  public WkAccessPoint()
  {
    this.a = "";
    this.b = "";
    this.c = 0;
    this.d = 0;
  }
  
  public WkAccessPoint(ScanResult paramScanResult)
  {
    a(paramScanResult.SSID);
    b(paramScanResult.BSSID);
    this.d = paramScanResult.level;
    c(paramScanResult.capabilities);
  }
  
  public WkAccessPoint(WifiConfiguration paramWifiConfiguration)
  {
    a(u.a(paramWifiConfiguration.SSID));
    b(paramWifiConfiguration.BSSID);
    this.c = u.a(paramWifiConfiguration);
  }
  
  public WkAccessPoint(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public WkAccessPoint(WkAccessPoint paramWkAccessPoint)
  {
    a(paramWkAccessPoint.a);
    b(paramWkAccessPoint.b);
    this.c = paramWkAccessPoint.c;
    this.d = paramWkAccessPoint.d;
  }
  
  public WkAccessPoint(String paramString1, String paramString2)
  {
    a(paramString1);
    b(paramString2);
  }
  
  public WkAccessPoint(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("ssid");
    this.b = paramJSONObject.optString("bssid");
    this.c = paramJSONObject.optInt("securityLevel");
    this.d = paramJSONObject.optInt("rssi");
  }
  
  public final String a()
  {
    if (this.a != null) {}
    for (String str = this.a;; str = "") {
      return str;
    }
  }
  
  public final void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      this.a = paramString;
      return;
      paramString = "";
    }
  }
  
  public boolean a(ScanResult paramScanResult)
  {
    if ((this.a.equals(paramScanResult.SSID)) && (this.c == u.a(paramScanResult)))
    {
      this.b = paramScanResult.BSSID;
      if (WifiManager.compareSignalLevel(paramScanResult.level, this.d) > 0) {
        this.d = paramScanResult.level;
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final String b()
  {
    if (this.b != null) {}
    for (String str = this.b;; str = "") {
      return str;
    }
  }
  
  public final void b(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      this.b = paramString;
      return;
      paramString = "";
    }
  }
  
  public JSONObject c()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("ssid", this.a);
      localJSONObject1.put("bssid", this.b);
      localJSONObject1.put("securityLevel", String.valueOf(this.c));
      localJSONObject1.put("rssi", String.valueOf(this.d));
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
  
  public final void c(String paramString)
  {
    int i;
    if (paramString.contains("WAPI-PSK")) {
      i = 31;
    }
    for (;;)
    {
      this.c = i;
      return;
      if (paramString.contains("WAPI-CERT")) {
        i = 32;
      } else if (paramString.contains("WEP")) {
        i = 1;
      } else if (paramString.contains("PSK")) {
        i = 2;
      } else if (paramString.contains("EAP")) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof WkAccessPoint)) {
      if ((((WkAccessPoint)paramObject).a.equals(this.a)) && (((WkAccessPoint)paramObject).b.equals(this.b))) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = super.equals(paramObject);
    }
  }
  
  public int hashCode()
  {
    return this.a.hashCode() + this.b.hashCode();
  }
  
  public String toString()
  {
    return c().toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/model/WkAccessPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */