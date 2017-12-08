package com.wifi.connect.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.bluefay.b.h;

final class aq
  implements View.OnTouchListener
{
  aq(TopViewNearbyApActivity paramTopViewNearbyApActivity, View paramView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    paramView = new Rect();
    this.a.getGlobalVisibleRect(paramView);
    if (!paramView.contains(i, j)) {
      this.b.finish();
    }
    for (;;)
    {
      return false;
      h.a("------wholeview----", new Object[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */