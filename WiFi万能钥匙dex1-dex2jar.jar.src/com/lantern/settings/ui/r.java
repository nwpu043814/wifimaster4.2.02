package com.lantern.settings.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.bluefay.a.e;
import com.lantern.analytics.a;
import com.lantern.analytics.d.d;
import com.lantern.settings.R.string;

final class r
  implements View.OnClickListener
{
  r(FeedbackActivity paramFeedbackActivity) {}
  
  public final void onClick(View paramView)
  {
    if (FeedbackActivity.b(this.a)) {}
    for (;;)
    {
      return;
      FeedbackActivity.c(this.a);
      String str = FeedbackActivity.d(this.a).getText().toString().trim();
      paramView = FeedbackActivity.e(this.a).getText().toString();
      if ("20150108".equals(paramView))
      {
        paramView = new Intent(this.a.getBaseContext(), DiagnoseActivity.class);
        this.a.startActivity(paramView);
      }
      else if (("364060792".equals(paramView)) || ("2852373784".equals(paramView)) || (paramView.length() == 0))
      {
        e.a(R.string.settings_feedback_contact_invalid);
      }
      else if (str.length() == 0)
      {
        e.a(R.string.settings_feedback_content_invalid);
      }
      else
      {
        FeedbackActivity.a(this.a, true);
        if (FeedbackActivity.f(this.a))
        {
          new d(FeedbackActivity.g(this.a)).execute(new String[] { str, paramView, "2" });
        }
        else
        {
          a.e();
          new d(FeedbackActivity.g(this.a)).execute(new String[] { str, paramView });
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */