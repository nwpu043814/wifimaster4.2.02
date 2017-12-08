package com.lantern.wifitools.examination;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.bluefay.a.e;
import com.lantern.analytics.a;

final class d
  implements View.OnClickListener
{
  d(ExamResultFragment paramExamResultFragment) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.getActivity() != null)
    {
      paramView = new Intent("wifi.intent.action.notification.jump");
      paramView.setPackage(ExamResultFragment.c(this.a).getPackageName());
      paramView.putExtra("extra_jump_tab", "Connect");
      paramView.putExtra("extra_jump_open_main", true);
      paramView.addFlags(268435456);
      e.a(ExamResultFragment.d(this.a), paramView);
      a.e().onEvent("surf_cli");
      this.a.getActivity().finish();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */