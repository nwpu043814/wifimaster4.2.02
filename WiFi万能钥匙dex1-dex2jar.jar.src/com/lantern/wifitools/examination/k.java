package com.lantern.wifitools.examination;

import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

final class k
  implements Runnable
{
  k(ExaminationFragment paramExaminationFragment, ImageView paramImageView, long paramLong) {}
  
  public final void run()
  {
    if (this.c.getActivity() != null)
    {
      ExaminationFragment.b(this.c, this.a, this.b + 1200L);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      localRotateAnimation.setFillAfter(true);
      localRotateAnimation.setDuration(1200L);
      this.a.startAnimation(localRotateAnimation);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */