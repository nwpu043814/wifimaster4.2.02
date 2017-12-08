package com.linksure.apservice.ui.profile.widget;

import android.view.MotionEvent;

public final class n
{
  private g a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  
  public n(g paramg)
  {
    this.a = paramg;
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    this.d = paramMotionEvent.getX(0);
    this.e = paramMotionEvent.getY(0);
    this.f = paramMotionEvent.getX(1);
    this.g = paramMotionEvent.getY(1);
    return (this.g - this.e) / (this.f - this.d);
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return;
      if (paramMotionEvent.getPointerCount() == 2)
      {
        this.b = a(paramMotionEvent);
        continue;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          this.c = a(paramMotionEvent);
          double d1 = Math.toDegrees(Math.atan(this.c)) - Math.toDegrees(Math.atan(this.b));
          if (Math.abs(d1) <= 120.0D) {
            this.a.a((float)d1, (this.f + this.d) / 2.0F, (this.g + this.e) / 2.0F);
          }
          this.b = this.c;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/widget/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */