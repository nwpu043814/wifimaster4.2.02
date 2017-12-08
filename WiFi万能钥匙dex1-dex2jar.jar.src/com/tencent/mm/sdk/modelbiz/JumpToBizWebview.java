package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;

public final class JumpToBizWebview
{
  public static class Req
    extends BaseReq
  {
    private static final int EXT_MSG_LENGTH = 1024;
    private static final String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
    public String extMsg;
    public int scene = 1;
    public String toUserName;
    public int webType;
    
    public boolean checkArgs()
    {
      boolean bool = false;
      if ((this.toUserName == null) || (this.toUserName.length() <= 0)) {
        a.a("MicroMsg.SDK.JumpToBizWebview.Req", "checkArgs fail, toUserName is invalid");
      }
      for (;;)
      {
        return bool;
        if ((this.extMsg != null) && (this.extMsg.length() > 1024)) {
          a.a("MicroMsg.SDK.JumpToBizWebview.Req", "ext msg is not null, while the length exceed 1024 bytes");
        } else {
          bool = true;
        }
      }
    }
    
    public int getType()
    {
      return 8;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
      paramBundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
      paramBundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
      paramBundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/modelbiz/JumpToBizWebview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */