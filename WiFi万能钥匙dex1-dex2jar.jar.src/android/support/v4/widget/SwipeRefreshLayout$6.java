package android.support.v4.widget;

import android.view.animation.Animation;

class SwipeRefreshLayout$6
  implements Runnable
{
  SwipeRefreshLayout$6(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void run()
  {
    SwipeRefreshLayout.access$902(this.this$0, true);
    if (SwipeRefreshLayout.access$500(this.this$0) != null)
    {
      SwipeRefreshLayout.access$402(this.this$0, SwipeRefreshLayout.access$800(this.this$0));
      SwipeRefreshLayout.access$1300(this.this$0).setDuration(SwipeRefreshLayout.access$1200(this.this$0));
      SwipeRefreshLayout.access$1300(this.this$0).setAnimationListener(SwipeRefreshLayout.access$1400(this.this$0));
      SwipeRefreshLayout.access$1300(this.this$0).reset();
      SwipeRefreshLayout.access$1300(this.this$0).setInterpolator(SwipeRefreshLayout.access$1500(this.this$0));
      this.this$0.startAnimation(SwipeRefreshLayout.access$1300(this.this$0));
    }
    SwipeRefreshLayout.access$1100(this.this$0, SwipeRefreshLayout.access$700(this.this$0) + this.this$0.getPaddingTop(), SwipeRefreshLayout.access$1000(this.this$0));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/SwipeRefreshLayout$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */