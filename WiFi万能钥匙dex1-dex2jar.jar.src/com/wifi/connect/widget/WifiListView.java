package com.wifi.connect.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.bluefay.b.h;

public class WifiListView
  extends ListView
{
  public WifiListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WifiListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WifiListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IndexOutOfBoundsException paramMotionEvent)
    {
      for (;;)
      {
        h.a(paramMotionEvent);
        boolean bool = true;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/WifiListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */