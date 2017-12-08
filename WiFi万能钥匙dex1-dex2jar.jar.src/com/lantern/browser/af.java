package com.lantern.browser;

import android.os.Handler;
import com.lantern.analytics.a;
import com.snda.wifilocating.wxapi.OnWeChatResponse;
import com.snda.wifilocating.wxapi.WXEntryActivity;

final class af
  implements OnWeChatResponse
{
  af(ae paramae, String paramString, int paramInt) {}
  
  public final void onResp(int paramInt)
  {
    WkBrowserJsInterface.access$300().post(new ag(this, paramInt));
    WXEntryActivity.setListener(null);
    if (paramInt == 0) {
      a.e().onEvent("share1", String.valueOf(this.b));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */