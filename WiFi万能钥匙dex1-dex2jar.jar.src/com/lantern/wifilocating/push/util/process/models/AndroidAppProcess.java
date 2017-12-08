package com.lantern.wifilocating.push.util.process.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class AndroidAppProcess
  extends AndroidProcess
{
  public static final Parcelable.Creator<AndroidAppProcess> CREATOR = new a();
  public boolean a;
  public int b;
  private final Cgroup e;
  
  public AndroidAppProcess(int paramInt)
  {
    super(paramInt);
    this.e = super.a();
    ControlGroup localControlGroup2 = this.e.a("cpuacct");
    ControlGroup localControlGroup1 = this.e.a("cpu");
    if ((localControlGroup1 == null) || (localControlGroup2 == null) || (!localControlGroup2.c.contains("pid_"))) {
      throw new a(paramInt);
    }
    if (!localControlGroup1.c.contains("bg_non_interactive")) {}
    for (;;)
    {
      this.a = bool;
      try
      {
        this.b = Integer.parseInt(localControlGroup2.c.split("/")[1].replace("uid_", ""));
        return;
        bool = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.b = Status.a(this.d).a();
        }
      }
    }
  }
  
  protected AndroidAppProcess(Parcel paramParcel)
  {
    super(paramParcel);
    this.e = ((Cgroup)paramParcel.readParcelable(Cgroup.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      return;
    }
  }
  
  public final Cgroup a()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.e, paramInt);
    if (this.a) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
  
  public static final class a
    extends Exception
  {
    public a(int paramInt)
    {
      super();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/process/models/AndroidAppProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */