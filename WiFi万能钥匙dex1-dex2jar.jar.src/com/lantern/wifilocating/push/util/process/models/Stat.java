package com.lantern.wifilocating.push.util.process.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class Stat
  extends ProcFile
{
  public static final Parcelable.Creator<Stat> CREATOR = new f();
  private final String[] a;
  
  private Stat(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createStringArray();
  }
  
  private Stat(String paramString)
  {
    super(paramString);
    this.a = this.b.split("\\s+");
  }
  
  public static Stat a(int paramInt)
  {
    return new Stat(String.format("/proc/%d/stat", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public final String a()
  {
    return this.a[1].replace("(", "").replace(")", "");
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/process/models/Stat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */