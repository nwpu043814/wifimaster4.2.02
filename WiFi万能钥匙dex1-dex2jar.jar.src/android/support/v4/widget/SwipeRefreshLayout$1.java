package android.support.v4.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$1
  extends Animation
{
  SwipeRefreshLayout$1(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = 0;
    if (SwipeRefreshLayout.access$000(this.this$0) != SwipeRefreshLayout.access$100(this.this$0)) {
      i = SwipeRefreshLayout.access$000(this.this$0) + (int)((SwipeRefreshLayout.access$100(this.this$0) - SwipeRefreshLayout.access$000(this.this$0)) * paramFloat);
    }
    int j = i - SwipeRefreshLayout.access$200(this.this$0).getTop();
    int k = SwipeRefreshLayout.access$200(this.this$0).getTop();
    i = j;
    if (j + k < 0) {
      i = 0 - k;
    }
    SwipeRefreshLayout.access$300(this.this$0, i);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/SwipeRefreshLayout$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */