package com.lantern.wifitools.examination;

import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.lantern.wifitools.R.anim;

final class j
  implements Runnable
{
  j(ExaminationFragment paramExaminationFragment, ImageView paramImageView, long paramLong) {}
  
  public final void run()
  {
    if (this.c.getActivity() != null)
    {
      ExaminationFragment.a(this.c, this.a, this.b + 1200L);
      this.a.startAnimation(AnimationUtils.loadAnimation(this.c.getActivity(), R.anim.fade_out));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */