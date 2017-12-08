package com.lantern.browser;

import com.lantern.analytics.a;
import com.snda.wifilocating.wxapi.OnWeChatResponse;
import com.snda.wifilocating.wxapi.WXEntryActivity;

final class ar
  implements OnWeChatResponse
{
  ar(int paramInt) {}
  
  public final void onResp(int paramInt)
  {
    WXEntryActivity.setListener(null);
    if (paramInt == 0) {
      a.e().onEvent("share1", String.valueOf(this.a));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */