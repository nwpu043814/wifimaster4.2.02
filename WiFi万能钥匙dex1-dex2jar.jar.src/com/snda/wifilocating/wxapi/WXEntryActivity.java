package com.snda.wifilocating.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.qihoo.util.StubApp1053578832;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity
  extends Activity
  implements IWXAPIEventHandler
{
  private static OnWeChatResponse mListener;
  private IWXAPI api;
  
  static
  {
    StubApp1053578832.interface11(86);
  }
  
  public static void setListener(OnWeChatResponse paramOnWeChatResponse)
  {
    mListener = paramOnWeChatResponse;
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.api.handleIntent(paramIntent, this);
    finish();
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    finish();
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (mListener != null) {
      mListener.onResp(paramBaseResp.errCode);
    }
    finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/snda/wifilocating/wxapi/WXEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */