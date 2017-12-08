package com.wifipay.framework.widget.wheel;

import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;

class h
  extends Handler
{
  h(WheelScroller paramWheelScroller) {}
  
  public void handleMessage(Message paramMessage)
  {
    WheelScroller.b(this.a).computeScrollOffset();
    int j = WheelScroller.b(this.a).getCurrY();
    int i = WheelScroller.a(this.a) - j;
    WheelScroller.a(this.a, j);
    if (i != 0) {
      WheelScroller.c(this.a).onScroll(i);
    }
    if (Math.abs(j - WheelScroller.b(this.a).getFinalY()) <= 0)
    {
      WheelScroller.b(this.a).getFinalY();
      WheelScroller.b(this.a).forceFinished(true);
    }
    if (!WheelScroller.b(this.a).isFinished()) {
      WheelScroller.d(this.a).sendEmptyMessage(paramMessage.what);
    }
    for (;;)
    {
      return;
      if (paramMessage.what == 0) {
        WheelScroller.e(this.a);
      } else {
        this.a.b();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/wheel/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */