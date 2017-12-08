package com.lantern.wifilocating.push.util.process.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ProcFile
  extends File
  implements Parcelable
{
  public static final Parcelable.Creator<ProcFile> CREATOR = new e();
  public final String b;
  
  protected ProcFile(Parcel paramParcel)
  {
    super(paramParcel.readString());
    this.b = paramParcel.readString();
  }
  
  protected ProcFile(String paramString)
  {
    super(paramString);
    this.b = b(paramString);
  }
  
  protected static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
    localStringBuilder.append(localBufferedReader.readLine());
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine()) {
      localStringBuilder.append('\n').append(paramString);
    }
    localBufferedReader.close();
    return localStringBuilder.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long length()
  {
    return this.b.length();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getAbsolutePath());
    paramParcel.writeString(this.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/process/models/ProcFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */