package com.lantern.settings.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import com.bluefay.a.e;
import com.lantern.analytics.d.d;
import com.lantern.settings.R.string;

final class aw
  implements View.OnClickListener
{
  aw(SpitslotActivity paramSpitslotActivity) {}
  
  public final void onClick(View paramView)
  {
    if (SpitslotActivity.b(this.a)) {}
    for (;;)
    {
      return;
      SpitslotActivity.c(this.a);
      String str2 = SpitslotActivity.d(this.a).getText().toString().trim();
      String str1 = SpitslotActivity.e(this.a).getText().toString();
      paramView = "";
      if (SpitslotActivity.f(this.a).isChecked()) {
        paramView = "M";
      }
      for (;;)
      {
        if (!"20150108".equals(str1)) {
          break label124;
        }
        paramView = new Intent(this.a.getBaseContext(), DiagnoseActivity.class);
        this.a.startActivity(paramView);
        break;
        if (SpitslotActivity.g(this.a).isChecked()) {
          paramView = "F";
        }
      }
      label124:
      if (("481721560".equals(str1)) || ("lianwifi".equals(str1)) || (str1.length() == 0))
      {
        e.a(R.string.settings_feedback_contact_invalid);
      }
      else if (str2.length() == 0)
      {
        e.a(R.string.settings_feedback_content_invalid);
      }
      else
      {
        SpitslotActivity.a(this.a, true);
        new d(SpitslotActivity.h(this.a)).execute(new String[] { str2, str1, "2", paramView });
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */