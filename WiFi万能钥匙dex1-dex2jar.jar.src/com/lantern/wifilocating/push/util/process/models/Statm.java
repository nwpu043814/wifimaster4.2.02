package com.lantern.wifilocating.push.util.process.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class Statm
  extends ProcFile
{
  public static final Parcelable.Creator<Statm> CREATOR = new g();
  public final String[] a;
  
  private Statm(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createStringArray();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeStringArray(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/process/models/Statm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */