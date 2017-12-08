package com.wifipay.framework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class WPButton
  extends Button
{
  private a a;
  
  public WPButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public WPButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WPButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/WPButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */