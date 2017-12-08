package com.lantern.safecommand.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ConnectionStateNotify$1
  implements Parcelable.Creator<ConnectionStateNotify>
{
  public final ConnectionStateNotify createFromParcel(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    int i = paramParcel.readInt();
    int j = paramParcel.readInt();
    paramParcel = new ConnectionStateNotify();
    paramParcel.setSsid(str);
    paramParcel.setState(i);
    paramParcel.setVpnErrCode(j);
    return paramParcel;
  }
  
  public final ConnectionStateNotify[] newArray(int paramInt)
  {
    return new ConnectionStateNotify[paramInt];
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/aidl/ConnectionStateNotify$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */