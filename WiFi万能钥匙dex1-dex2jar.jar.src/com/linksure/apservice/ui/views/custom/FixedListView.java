package com.linksure.apservice.ui.views.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;

public class FixedListView
  extends ListView
{
  public FixedListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FixedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FixedListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getLayoutParams().height == -2) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/custom/FixedListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */