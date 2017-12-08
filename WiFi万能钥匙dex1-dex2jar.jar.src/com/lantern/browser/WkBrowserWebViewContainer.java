package com.lantern.browser;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class WkBrowserWebViewContainer
  extends RelativeLayout
{
  private Context a;
  
  public WkBrowserWebViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WkBrowserWebViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/WkBrowserWebViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */