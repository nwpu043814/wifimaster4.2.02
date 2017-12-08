package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;

public class WXTextObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXTextObject";
  public String text;
  
  public WXTextObject()
  {
    this(null);
  }
  
  public WXTextObject(String paramString)
  {
    this.text = paramString;
  }
  
  public boolean checkArgs()
  {
    if ((this.text == null) || (this.text.length() == 0) || (this.text.length() > 10240)) {
      a.a("MicroMsg.SDK.WXTextObject", "checkArgs fail, text is invalid");
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxtextobject_text", this.text);
  }
  
  public int type()
  {
    return 1;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.text = paramBundle.getString("_wxtextobject_text");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/modelmsg/WXTextObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */