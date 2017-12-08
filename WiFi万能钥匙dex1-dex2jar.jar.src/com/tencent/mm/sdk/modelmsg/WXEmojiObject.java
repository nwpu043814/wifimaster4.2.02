package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXEmojiObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
  public byte[] emojiData;
  public String emojiPath;
  
  public WXEmojiObject()
  {
    this.emojiData = null;
    this.emojiPath = null;
  }
  
  public WXEmojiObject(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public WXEmojiObject(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
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
    if (((this.emojiData == null) || (this.emojiData.length == 0)) && ((this.emojiPath == null) || (this.emojiPath.length() == 0))) {
      a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
    }
    for (;;)
    {
      return bool;
      if ((this.emojiData != null) && (this.emojiData.length > 10485760)) {
        a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
      } else if ((this.emojiPath != null) && (getFileSize(this.emojiPath) > 10485760)) {
        a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
      } else {
        bool = true;
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
    paramBundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
  }
  
  public void setEmojiData(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }
  
  public void setEmojiPath(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public int type()
  {
    return 8;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.emojiData = paramBundle.getByteArray("_wxemojiobject_emojiData");
    this.emojiPath = paramBundle.getString("_wxemojiobject_emojiPath");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/modelmsg/WXEmojiObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */