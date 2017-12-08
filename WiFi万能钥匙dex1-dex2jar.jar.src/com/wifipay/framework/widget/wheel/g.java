package com.wifipay.framework.widget.wheel;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class g
  extends GestureDetector.SimpleOnGestureListener
{
  g(WheelScroller paramWheelScroller) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    WheelScroller.a(this.a, 0);
    WheelScroller.b(this.a).fling(0, WheelScroller.a(this.a), 0, (int)-paramFloat2, 0, 0, -2147483647, Integer.MAX_VALUE);
    WheelScroller.b(this.a, 0);
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/wheel/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */