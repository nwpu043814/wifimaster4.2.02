package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class SendMessageToWX
{
  public static class Req
    extends BaseReq
  {
    private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
    private static final String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
    public static final int WXSceneFavorite = 2;
    public static final int WXSceneSession = 0;
    public static final int WXSceneTimeline = 1;
    public WXMediaMessage message;
    public int scene;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      if (this.message == null) {
        a.a("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
      }
      for (boolean bool = false;; bool = this.message.checkArgs())
      {
        return bool;
        if ((this.message.mediaObject.type() == 6) && (this.scene == 2)) {
          ((WXFileObject)this.message.mediaObject).setContentLengthLimit(26214400);
        }
      }
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
      this.scene = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
    }
    
    public int getType()
    {
      return 2;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
      paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
    }
    
    public int getType()
    {
      return 2;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/modelmsg/SendMessageToWX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */