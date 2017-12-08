package com.linksure.apservice.ui.common.search;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Message;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

public final class o
{
  private ProgressBar a;
  private boolean b = false;
  private Handler c = new p(this);
  
  public o(ProgressBar paramProgressBar)
  {
    this.a = paramProgressBar;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Message localMessage = this.c.obtainMessage();
    localMessage.what = 1;
    localMessage.arg1 = paramInt1;
    this.c.sendMessageDelayed(localMessage, paramInt2);
  }
  
  public final void a()
  {
    this.a.setVisibility(0);
    this.a.setAlpha(1.0F);
    a(10, 0);
    a(11, 10);
    a(20, 50);
    a(90, 500);
  }
  
  public final void a(int paramInt)
  {
    int i = this.a.getProgress();
    ObjectAnimator localObjectAnimator;
    if ((paramInt >= 100) && (!this.b))
    {
      this.b = true;
      this.a.setProgress(paramInt);
      paramInt = this.a.getProgress();
      localObjectAnimator = ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.setDuration(1500L);
      localObjectAnimator.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator.addUpdateListener(new q(this, paramInt));
      localObjectAnimator.addListener(new r(this));
      localObjectAnimator.start();
      this.c.removeMessages(1);
    }
    for (;;)
    {
      return;
      localObjectAnimator = ObjectAnimator.ofInt(this.a, "progress", new int[] { i, paramInt });
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator.start();
    }
  }
  
  public final void b()
  {
    a(100, 0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/search/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */