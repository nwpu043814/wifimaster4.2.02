package com.wifi.connect.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class WkContainerView
  extends FrameLayout
{
  public a a;
  
  public WkContainerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WkContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WkContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.a != null) {
      this.a.onKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void onKeyEvent(KeyEvent paramKeyEvent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/WkContainerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */