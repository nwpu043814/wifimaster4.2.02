package com.lantern.browser.search.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.lantern.browser.R.layout;

public class WkSearchMainView
  extends FrameLayout
{
  private Context a;
  
  public WkSearchMainView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public WkSearchMainView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public WkSearchMainView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    inflate(this.a, R.layout.search_main_view, this);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/WkSearchMainView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */