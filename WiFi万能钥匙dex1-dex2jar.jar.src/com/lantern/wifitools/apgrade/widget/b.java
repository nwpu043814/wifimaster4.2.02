package com.lantern.wifitools.apgrade.widget;

import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

final class b
  implements RatingBar.OnRatingBarChangeListener
{
  b(ApGradeStarBigViewGroup paramApGradeStarBigViewGroup) {}
  
  public final void onRatingChanged(RatingBar paramRatingBar, float paramFloat, boolean paramBoolean)
  {
    if ((int)Math.ceil(paramFloat) == 0) {
      this.a.a(1);
    }
    for (;;)
    {
      return;
      ApGradeStarBigViewGroup.a(this.a).setRating((int)Math.ceil(paramFloat));
      ApGradeStarBigViewGroup.a(this.a, (int)Math.ceil(paramFloat));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */