package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WXImageObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXImageObject";
  private static final int URL_LENGTH_LIMIT = 10240;
  public byte[] imageData;
  public String imagePath;
  public String imageUrl;
  
  public WXImageObject() {}
  
  public WXImageObject(Bitmap paramBitmap)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.imageData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return;
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        paramBitmap.printStackTrace();
      }
    }
  }
  
  public WXImageObject(byte[] paramArrayOfByte)
  {
    this.imageData = paramArrayOfByte;
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
    if (((this.imageData == null) || (this.imageData.length == 0)) && ((this.imagePath == null) || (this.imagePath.length() == 0)) && ((this.imageUrl == null) || (this.imageUrl.length() == 0))) {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, all arguments are null");
    }
    for (;;)
    {
      return bool;
      if ((this.imageData != null) && (this.imageData.length > 10485760)) {
        a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, content is too large");
      } else if ((this.imagePath != null) && (this.imagePath.length() > 10240)) {
        a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, path is invalid");
      } else if ((this.imagePath != null) && (getFileSize(this.imagePath) > 10485760)) {
        a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, image content is too large");
      } else if ((this.imageUrl != null) && (this.imageUrl.length() > 10240)) {
        a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, url is invalid");
      } else {
        bool = true;
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wximageobject_imageData", this.imageData);
    paramBundle.putString("_wximageobject_imagePath", this.imagePath);
    paramBundle.putString("_wximageobject_imageUrl", this.imageUrl);
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public int type()
  {
    return 2;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.imageData = paramBundle.getByteArray("_wximageobject_imageData");
    this.imagePath = paramBundle.getString("_wximageobject_imagePath");
    this.imageUrl = paramBundle.getString("_wximageobject_imageUrl");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/modelmsg/WXImageObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */