package com.wifipay.framework.widget.wheel;

class d
  implements WheelScroller.ScrollingListener
{
  d(WPWheelView paramWPWheelView) {}
  
  public void onFinished()
  {
    if (WPWheelView.c(this.a))
    {
      this.a.b();
      WPWheelView.a(this.a, false);
    }
    WPWheelView.b(this.a, 0);
    this.a.invalidate();
  }
  
  public void onJustify()
  {
    if (Math.abs(WPWheelView.a(this.a)) > 1) {
      WPWheelView.b(this.a).a(WPWheelView.a(this.a), 0);
    }
  }
  
  public void onScroll(int paramInt)
  {
    WPWheelView.a(this.a, paramInt);
    paramInt = this.a.getHeight();
    if (WPWheelView.a(this.a) > paramInt)
    {
      WPWheelView.b(this.a, paramInt);
      WPWheelView.b(this.a).a();
    }
    for (;;)
    {
      return;
      if (WPWheelView.a(this.a) < -paramInt)
      {
        WPWheelView.b(this.a, -paramInt);
        WPWheelView.b(this.a).a();
      }
    }
  }
  
  public void onStarted()
  {
    WPWheelView.a(this.a, true);
    this.a.a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/wheel/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */