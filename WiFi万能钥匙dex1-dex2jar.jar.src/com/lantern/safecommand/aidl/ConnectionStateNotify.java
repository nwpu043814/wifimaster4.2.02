package com.lantern.safecommand.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ConnectionStateNotify
  implements Parcelable
{
  public static final Parcelable.Creator<ConnectionStateNotify> CREATOR = new ConnectionStateNotify.1();
  public static final int HC_CONNECTED = 2;
  public static final int NETWORK_DISCONNECTED = 0;
  public static final int VPN_AUTH_REVOKED = 3;
  public static final int VPN_CONNECTED_HC = 4;
  public static final int VPN_CONNECTED_WIFI = 3;
  public static final int VPN_FAIL_NATIVE = 2;
  public static final int VPN_STARTED = 1;
  public static final int VPN_STOP = 0;
  public static final int WIFI_CONNECTED = 1;
  private String ssid = "";
  private int state;
  private int vpnErrCode;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public int getVpnErrCode()
  {
    return this.vpnErrCode;
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public void setVpnErrCode(int paramInt)
  {
    this.vpnErrCode = paramInt;
  }
  
  public String toString()
  {
    return "state = " + this.state + " ssid= " + this.ssid + " vpnErrCode =" + this.vpnErrCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ssid);
    paramParcel.writeInt(this.state);
    paramParcel.writeInt(this.vpnErrCode);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/aidl/ConnectionStateNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */