package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXAppExtendObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final int EXTINFO_LENGTH_LIMIT = 2048;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
  public String extInfo;
  public byte[] fileData;
  public String filePath;
  
  public WXAppExtendObject() {}
  
  public WXAppExtendObject(String paramString1, String paramString2)
  {
    this.extInfo = paramString1;
    this.filePath = paramString2;
  }
  
  public WXAppExtendObject(String paramString, byte[] paramArrayOfByte)
  {
    this.extInfo = paramString;
    this.fileData = paramArrayOfByte;
  }
  
  private int getFileSize(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label19;
      }
      i = j;
    }
    for (;;)
    {
      return i;
      label19:
      paramString = new File(paramString);
      i = j;
      if (paramString.exists()) {
        i = (int)paramString.length();
      }
    }
  }
  
  public boolean checkArgs()
  {
    boolean bool = false;
    if (((this.extInfo == null) || (this.extInfo.length() == 0)) && ((this.filePath == null) || (this.filePath.length() == 0)) && ((this.fileData == null) || (this.fileData.length == 0))) {
      a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, all arguments is null");
    }
    for (;;)
    {
      return bool;
      if ((this.extInfo != null) && (this.extInfo.length() > 2048)) {
        a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, extInfo is invalid");
      } else if ((this.filePath != null) && (this.filePath.length() > 10240)) {
        a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, filePath is invalid");
      } else if ((this.filePath != null) && (getFileSize(this.filePath) > 10485760)) {
        a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileSize is too large");
      } else if ((this.fileData != null) && (this.fileData.length > 10485760)) {
        a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileData is too large");
      } else {
        bool = true;
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxappextendobject_extInfo", this.extInfo);
    paramBundle.putByteArray("_wxappextendobject_fileData", this.fileData);
    paramBundle.putString("_wxappextendobject_filePath", this.filePath);
  }
  
  public int type()
  {
    return 7;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.extInfo = paramBundle.getString("_wxappextendobject_extInfo");
    this.fileData = paramBundle.getByteArray("_wxappextendobject_fileData");
    this.filePath = paramBundle.getString("_wxappextendobject_filePath");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/modelmsg/WXAppExtendObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */