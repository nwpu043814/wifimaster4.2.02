package com.lantern.launcher.ui;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import com.lantern.core.c;
import com.lantern.core.k;

final class p
  implements View.OnClickListener
{
  p(UserGuideFragment paramUserGuideFragment, Button paramButton, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    this.a.setEnabled(false);
    com.lantern.core.p.c(UserGuideFragment.g(this.c), "sdk_device", "firststart", false);
    com.lantern.core.p.b("prev_version", k.b(UserGuideFragment.h(this.c)));
    paramView = com.lantern.notifaction.a.a(c.getInstance());
    paramView.d();
    paramView.e();
    if (TextUtils.isEmpty(com.lantern.core.p.c(UserGuideFragment.i(this.c))))
    {
      com.lantern.analytics.a.e().onEvent("regsta");
      com.lantern.auth.a.a().a(UserGuideFragment.j(this.c));
      this.b.setVisibility(0);
      paramView = AnimationUtils.loadAnimation(UserGuideFragment.k(this.c), 2131034172);
      this.b.startAnimation(paramView);
      UserGuideFragment.l(this.c).sendEmptyMessageDelayed(2, 10000L);
    }
    for (;;)
    {
      return;
      UserGuideFragment.a(this.c);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */