package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$2
  extends Animation
{
  SwipeRefreshLayout$2(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f2 = SwipeRefreshLayout.access$400(this.this$0);
    float f1 = SwipeRefreshLayout.access$400(this.this$0);
    SwipeRefreshLayout.access$500(this.this$0).setTriggerPercentage(f2 + (0.0F - f1) * paramFloat);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/SwipeRefreshLayout$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */