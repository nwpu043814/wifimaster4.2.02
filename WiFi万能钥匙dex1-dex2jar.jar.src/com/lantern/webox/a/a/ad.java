package com.lantern.webox.a.a;

import com.lantern.analytics.a;
import com.lantern.webox.a.r.a;
import com.snda.wifilocating.wxapi.OnWeChatResponse;

final class ad
  implements OnWeChatResponse
{
  ad(ab paramab, r.a parama, int paramInt) {}
  
  public final void onResp(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.a();
      a.e().onEvent("share1", String.valueOf(this.b));
    }
    for (;;)
    {
      return;
      if (paramInt == -2) {
        this.a.c();
      } else {
        this.a.b();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */