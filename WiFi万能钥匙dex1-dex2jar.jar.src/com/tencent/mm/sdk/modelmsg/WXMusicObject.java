package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;

public class WXMusicObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXMusicObject";
  public String musicDataUrl;
  public String musicLowBandDataUrl;
  public String musicLowBandUrl;
  public String musicUrl;
  
  public boolean checkArgs()
  {
    boolean bool = false;
    if (((this.musicUrl == null) || (this.musicUrl.length() == 0)) && ((this.musicLowBandUrl == null) || (this.musicLowBandUrl.length() == 0))) {
      a.a("MicroMsg.SDK.WXMusicObject", "both arguments are null");
    }
    for (;;)
    {
      return bool;
      if ((this.musicUrl != null) && (this.musicUrl.length() > 10240)) {
        a.a("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicUrl is too long");
      } else if ((this.musicLowBandUrl != null) && (this.musicLowBandUrl.length() > 10240)) {
        a.a("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicLowBandUrl is too long");
      } else {
        bool = true;
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
    paramBundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
  }
  
  public int type()
  {
    return 3;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.musicUrl = paramBundle.getString("_wxmusicobject_musicUrl");
    this.musicLowBandUrl = paramBundle.getString("_wxmusicobject_musicLowBandUrl");
    this.musicDataUrl = paramBundle.getString("_wxmusicobject_musicDataUrl");
    this.musicLowBandDataUrl = paramBundle.getString("_wxmusicobject_musicLowBandDataUrl");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/modelmsg/WXMusicObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */