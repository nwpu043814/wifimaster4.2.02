package com.lantern.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class WkFeedContentContainer
  extends FrameLayout
{
  private WkFeedListView a;
  
  public WkFeedContentContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public WkFeedContentContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WkFeedContentContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    if ((this.a != null) && (this.a.getVisibility() == 0)) {}
    for (boolean bool = this.a.canScrollVertically(paramInt);; bool = true) {
      return bool;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    for (int i = getChildCount() - 1;; i--) {
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if ((localView instanceof WkFeedListView)) {
          this.a = ((WkFeedListView)localView);
        }
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedContentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */