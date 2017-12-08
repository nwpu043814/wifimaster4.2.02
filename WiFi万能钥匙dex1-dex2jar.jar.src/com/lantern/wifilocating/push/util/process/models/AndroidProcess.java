package com.lantern.wifilocating.push.util.process.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.io.IOException;

public class AndroidProcess
  implements Parcelable
{
  public static final Parcelable.Creator<AndroidProcess> CREATOR = new b();
  public final String c;
  public final int d;
  
  public AndroidProcess(int paramInt)
  {
    this.d = paramInt;
    this.c = a(paramInt);
  }
  
  protected AndroidProcess(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
  }
  
  private static String a(int paramInt)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = ProcFile.b(String.format("/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) })).trim();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      for (;;) {}
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!"null".equals(localObject1)) {}
    }
    else
    {
      localObject2 = Stat.a(paramInt).a();
    }
    return (String)localObject2;
  }
  
  public Cgroup a()
  {
    return Cgroup.a(this.d);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/process/models/AndroidProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */