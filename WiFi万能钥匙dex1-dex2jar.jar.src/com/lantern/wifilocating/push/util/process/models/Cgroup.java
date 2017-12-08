package com.lantern.wifilocating.push.util.process.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;

public final class Cgroup
  extends ProcFile
{
  public static final Parcelable.Creator<Cgroup> CREATOR = new c();
  public final ArrayList<ControlGroup> a;
  
  private Cgroup(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(ControlGroup.CREATOR);
  }
  
  private Cgroup(String paramString)
  {
    super(paramString);
    paramString = this.b.split("\n");
    this.a = new ArrayList();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = paramString[i];
      }
      try
      {
        ArrayList localArrayList = this.a;
        ControlGroup localControlGroup = new com/lantern/wifilocating/push/util/process/models/ControlGroup;
        localControlGroup.<init>(str);
        localArrayList.add(localControlGroup);
        i++;
        continue;
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static Cgroup a(int paramInt)
  {
    return new Cgroup(String.format("/proc/%d/cgroup", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public final ControlGroup a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    ControlGroup localControlGroup;
    int i;
    if (localIterator.hasNext())
    {
      localControlGroup = (ControlGroup)localIterator.next();
      String[] arrayOfString = localControlGroup.b.split(",");
      int j = arrayOfString.length;
      i = 0;
      label49:
      if (i < j) {
        if (!arrayOfString[i].equals(paramString)) {}
      }
    }
    for (paramString = localControlGroup;; paramString = null)
    {
      return paramString;
      i++;
      break label49;
      break;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/process/models/Cgroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */