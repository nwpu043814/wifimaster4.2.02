package com.wifi.connect.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.bluefay.b.h;

final class b
  implements View.OnTouchListener
{
  b(BeginnerGuideFragment paramBeginnerGuideFragment) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction())
    {
    }
    float f2;
    float f1;
    for (bool1 = false;; bool1 = false)
    {
      return bool1;
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      h.a("btn1Rect:%s", new Object[] { BeginnerGuideFragment.a(this.a).toString() });
      h.a("btn2Rect:%s", new Object[] { BeginnerGuideFragment.b(this.a).toString() });
      h.a("touch up,x:%s,y:%s", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
      paramView = this.a.getActivity();
      if (paramView != null) {
        break;
      }
    }
    if ((BeginnerGuideFragment.a(this.a).contains(f2, f1)) || (BeginnerGuideFragment.b(this.a).contains(f2, f1)))
    {
      h.a("contains true", new Object[0]);
      paramMotionEvent = new Intent();
      paramMotionEvent.putExtra("doQuery", true);
      paramView.setResult(-1, paramMotionEvent);
    }
    for (;;)
    {
      paramView.finish();
      bool1 = bool2;
      break;
      paramView.setResult(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */