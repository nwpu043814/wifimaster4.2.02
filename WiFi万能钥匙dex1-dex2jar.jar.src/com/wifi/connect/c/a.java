package com.wifi.connect.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.model.WkAccessPoint;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String a = "";
  public int b;
  public int c;
  public String d = "";
  public String e;
  public String f;
  public String g;
  public ArrayList<WkAccessPoint> h;
  public long i;
  
  public a()
  {
    this("", "", "", new ArrayList());
  }
  
  public a(String paramString1, String paramString2, String paramString3, ArrayList<WkAccessPoint> paramArrayList)
  {
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)c.getAppContext().getSystemService("phone");
        localObject = localTelephonyManager.getNetworkOperator();
        if (localObject != null) {
          this.a = ((String)localObject);
        }
        localObject = localTelephonyManager.getCellLocation();
        if (!(localObject instanceof GsmCellLocation)) {
          continue;
        }
        this.b = ((GsmCellLocation)localObject).getLac();
        this.c = ((GsmCellLocation)localObject).getCid();
        this.d = "GSM";
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
      }
      this.e = paramString1;
      this.f = paramString2;
      this.g = paramString3;
      this.h = paramArrayList;
      this.i = System.currentTimeMillis();
      return;
      if ((localObject instanceof CdmaCellLocation))
      {
        this.b = ((CdmaCellLocation)localObject).getNetworkId();
        this.c = ((CdmaCellLocation)localObject).getBaseStationId();
        this.d = "CDMA";
      }
    }
  }
  
  public final JSONArray a()
  {
    JSONArray localJSONArray;
    if ((this.e == null) || (this.e.length() == 0)) {
      localJSONArray = null;
    }
    for (;;)
    {
      return localJSONArray;
      if ((this.f == null) || (this.f.length() == 0)) {
        localJSONArray = null;
      } else if ((this.h == null) || (this.h.size() == 0)) {
        localJSONArray = null;
      } else {
        try
        {
          localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>();
          Iterator localIterator = this.h.iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (WkAccessPoint)localIterator.next();
            JSONObject localJSONObject = new org/json/JSONObject;
            localJSONObject.<init>();
            localJSONObject.put("ssid", ((WkAccessPoint)localObject2).a);
            localJSONObject.put("bssid", ((WkAccessPoint)localObject2).b);
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localJSONObject.put("rssi", ((WkAccessPoint)localObject2).d);
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localJSONObject.put("secLevel", ((WkAccessPoint)localObject2).c);
            localJSONObject.put("la", this.f);
            localJSONObject.put("lo", this.e);
            localJSONObject.put("mapSP", this.g);
            localJSONObject.put("mccmnc", this.a);
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localJSONObject.put("lac", this.b);
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localJSONObject.put("cid", this.c);
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localJSONObject.put("ctype", this.d);
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localJSONObject.put("cts", this.i);
            localJSONArray.put(localJSONObject);
          }
        }
        catch (JSONException localJSONException)
        {
          h.a(localJSONException);
          Object localObject1 = null;
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */