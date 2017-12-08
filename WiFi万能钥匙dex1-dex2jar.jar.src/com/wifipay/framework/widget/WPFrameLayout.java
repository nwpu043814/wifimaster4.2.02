package com.wifipay.framework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class WPFrameLayout
  extends FrameLayout
{
  private a a;
  
  public WPFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public WPFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WPFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    if (bool)
    {
      if (this.a == null) {
        this.a = new a(this);
      }
      this.a.a();
    }
    return bool;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/WPFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */