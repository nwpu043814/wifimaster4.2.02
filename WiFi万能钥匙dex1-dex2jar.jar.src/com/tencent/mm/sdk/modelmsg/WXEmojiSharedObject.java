package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.b.a;

public class WXEmojiSharedObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
  public int packageflag;
  public String packageid;
  public String thumburl;
  public String url;
  
  public WXEmojiSharedObject() {}
  
  public WXEmojiSharedObject(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.thumburl = paramString1;
    this.packageflag = paramInt;
    this.packageid = paramString2;
    this.url = paramString3;
  }
  
  public boolean checkArgs()
  {
    if ((TextUtils.isEmpty(this.packageid)) || (TextUtils.isEmpty(this.thumburl)) || (TextUtils.isEmpty(this.url)) || (this.packageflag == -1)) {
      a.a("MicroMsg.SDK.WXEmojiSharedObject", "checkArgs fail, packageid or thumburl is invalid");
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
    paramBundle.putInt("_wxemojisharedobject_packageflag", this.packageflag);
    paramBundle.putString("_wxemojisharedobject_packageid", this.packageid);
    paramBundle.putString("_wxemojisharedobject_url", this.url);
  }
  
  public int type()
  {
    return 15;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.thumburl = paramBundle.getString("_wxwebpageobject_thumburl");
    this.packageflag = paramBundle.getInt("_wxwebpageobject_packageflag");
    this.packageid = paramBundle.getString("_wxwebpageobject_packageid");
    this.url = paramBundle.getString("_wxwebpageobject_url");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/modelmsg/WXEmojiSharedObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */