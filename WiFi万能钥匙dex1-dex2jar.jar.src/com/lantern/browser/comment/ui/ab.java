package com.lantern.browser.comment.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class ab
  extends GestureDetector.SimpleOnGestureListener
{
  ab(WkCommentFloorView paramWkCommentFloorView, WkCommentFloorView.b paramb, int paramInt) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    WkCommentFloorView.a(this.c, this.a.d.a(), paramMotionEvent, this.b - 1);
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */