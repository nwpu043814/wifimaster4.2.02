package com.lantern.browser;

import android.widget.Toast;
import com.lantern.analytics.a;
import com.snda.wifilocating.wxapi.OnWeChatResponse;
import com.snda.wifilocating.wxapi.WXEntryActivity;

final class ba
  implements OnWeChatResponse
{
  ba(ay paramay) {}
  
  public final void onResp(int paramInt)
  {
    if (paramInt == 0) {
      switch (this.a.b)
      {
      }
    }
    for (;;)
    {
      a.e().onEvent("share1", String.valueOf(this.a.b));
      WXEntryActivity.setListener(null);
      return;
      Toast.makeText(at.d(this.a.d), R.string.browser_fav_success, 0).show();
      continue;
      Toast.makeText(at.d(this.a.d), R.string.browser_share_success, 0).show();
      continue;
      this.a.a.loadUrl("javascript:shareCallback()");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */