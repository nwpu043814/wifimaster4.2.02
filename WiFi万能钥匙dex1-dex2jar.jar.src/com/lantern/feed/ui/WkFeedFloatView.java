package com.lantern.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class WkFeedFloatView
  extends FrameLayout
{
  public WkFeedFloatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundColor(-1509949440);
  }
  
  public WkFeedFloatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setBackgroundColor(-1509949440);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedFloatView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */