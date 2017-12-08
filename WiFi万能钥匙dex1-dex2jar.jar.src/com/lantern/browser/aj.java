package com.lantern.browser;

import android.webkit.WebView;
import android.widget.Toast;
import com.lantern.analytics.a;
import com.snda.wifilocating.wxapi.OnWeChatResponse;
import com.snda.wifilocating.wxapi.WXEntryActivity;

final class aj
  implements OnWeChatResponse
{
  aj(ah paramah) {}
  
  public final void onResp(int paramInt)
  {
    if (paramInt == 0) {
      switch (this.a.c)
      {
      }
    }
    for (;;)
    {
      a.e().onEvent("share1", String.valueOf(this.a.c));
      WXEntryActivity.setListener(null);
      return;
      Toast.makeText(this.a.d, R.string.browser_fav_success, 0).show();
      continue;
      Toast.makeText(this.a.d, R.string.browser_share_success, 0).show();
      continue;
      this.a.b.loadUrl("javascript:shareCallback()");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */