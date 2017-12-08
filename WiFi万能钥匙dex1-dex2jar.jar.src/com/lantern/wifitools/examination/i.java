package com.lantern.wifitools.examination;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

final class i
  implements Animation.AnimationListener
{
  i(ExamResultFragment paramExamResultFragment, LinearLayout paramLinearLayout1, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout2) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
    ExamResultFragment.a(this.b, this.c);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */