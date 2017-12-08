package bluefay.webkit;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class d
  extends GestureDetector.SimpleOnGestureListener
{
  d(c paramc) {}
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (paramMotionEvent2.getRawY() - paramMotionEvent1.getRawY() > 100.0F) {
      c.b(this.a);
    }
    for (;;)
    {
      return bool;
      if (paramMotionEvent1.getRawY() - paramMotionEvent2.getRawY() > 100.0F) {
        c.c(this.a);
      } else {
        bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/webkit/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */