package com.lantern.settings.ui;

import com.bluefay.a.e;
import com.lantern.settings.R.string;

final class o
  implements com.bluefay.b.a
{
  o(FeedbackActivity paramFeedbackActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      e.a(R.string.settings_feedback_send_ok);
      com.lantern.analytics.a.e().c();
      com.lantern.analytics.a.e().d();
      this.a.finish();
    }
    for (;;)
    {
      return;
      e.a(R.string.settings_feedback_send_failed);
      FeedbackActivity.a(this.a, false);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */