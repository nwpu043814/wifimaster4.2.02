package com.lantern.wifilocating.push.util.process.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ControlGroup
  implements Parcelable
{
  public static final Parcelable.Creator<ControlGroup> CREATOR = new d();
  public final int a;
  public final String b;
  public final String c;
  
  protected ControlGroup(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  protected ControlGroup(String paramString)
  {
    paramString = paramString.split(":");
    this.a = Integer.parseInt(paramString[0]);
    this.b = paramString[1];
    this.c = paramString[2];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/process/models/ControlGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */