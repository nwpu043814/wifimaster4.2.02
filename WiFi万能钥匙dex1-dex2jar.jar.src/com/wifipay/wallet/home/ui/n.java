package com.wifipay.wallet.home.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import com.wifipay.wallet.home.widget.BannerViewPager;
import com.wifipay.wallet.home.widget.a;
import java.lang.reflect.Field;
import java.util.List;

class n
  extends Handler
{
  n(m paramm) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    m.a(this.a).removeAllViews();
    this.a.a(this.a.b.size());
    this.a.c = new BannerViewPager(this.a.a, m.b(this.a));
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      paramMessage = new com/wifipay/wallet/home/widget/a;
      HomeActivity localHomeActivity = this.a.a;
      AccelerateDecelerateInterpolator localAccelerateDecelerateInterpolator = new android/view/animation/AccelerateDecelerateInterpolator;
      localAccelerateDecelerateInterpolator.<init>();
      paramMessage.<init>(localHomeActivity, localAccelerateDecelerateInterpolator);
      paramMessage.a(300);
      localField.set(this.a.c, paramMessage);
      this.a.c.setBannerDelayTime(4000L);
      this.a.c.setImageDrawable(this.a.b);
      this.a.c.setOnItemClickListener(this.a);
      this.a.c.c();
      m.a(this.a).addView(this.a.c);
      return;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */