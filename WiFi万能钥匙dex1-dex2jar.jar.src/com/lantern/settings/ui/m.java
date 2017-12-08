package com.lantern.settings.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.settings.R.string;
import org.json.JSONObject;

final class m
  implements com.bluefay.b.a
{
  m(EditUserNameFragment paramEditUserNameFragment, String paramString) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    EditUserNameFragment.a(this.b);
    switch (paramInt)
    {
    default: 
      if ((paramObject != null) && ("O.OPEN.0004".equals(((JSONObject)paramObject).optString("retCd"))))
      {
        com.lantern.analytics.a.e().onEvent("nntofal");
        EditUserNameFragment.f(this.b);
        if (this.b.getActivity() != null) {
          this.b.getActivity().finish();
        }
      }
      break;
    }
    for (;;)
    {
      return;
      if (EditUserNameFragment.b(this.b) == 1) {
        com.lantern.analytics.a.e().onEvent("cmtsnsuc", "b");
      }
      for (;;)
      {
        p.i(EditUserNameFragment.c(this.b), this.a);
        new com.lantern.settings.a.e(p.c(EditUserNameFragment.d(this.b)), c.getServer().h(), this.a).execute(new Void[0]);
        paramString = this.b.getActivity();
        if (paramString == null) {
          break;
        }
        EditUserNameFragment.e(this.b).putExtra("INTENT_KEY_USER_NAME", this.a);
        paramString.setResult(-1, EditUserNameFragment.e(this.b));
        paramString.finish();
        break;
        if (EditUserNameFragment.b(this.b) == 2) {
          com.lantern.analytics.a.e().onEvent("cmtsnsuc", "c");
        }
      }
      if (TextUtils.isEmpty(paramString)) {
        com.bluefay.a.e.a(R.string.settings_user_info_submit_nickname_failed);
      } else {
        com.bluefay.a.e.a(paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */