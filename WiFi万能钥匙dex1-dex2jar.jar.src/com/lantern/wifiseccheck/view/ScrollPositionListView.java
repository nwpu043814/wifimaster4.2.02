package com.lantern.wifiseccheck.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ListView;

public class ScrollPositionListView
  extends ListView
{
  private static final String TAG = "ScrollPositionListView";
  int mCurrentfirstVisibleItem = 0;
  private OnScrollYListener onScrollYListener;
  SparseArray<ItemRecod> recordSp = new SparseArray(0);
  
  public ScrollPositionListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ScrollPositionListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ScrollPositionListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int getViewScrollY()
  {
    int j = 0;
    int k;
    for (int i = 0; j < this.mCurrentfirstVisibleItem; i = k)
    {
      localObject = (ItemRecod)this.recordSp.get(j);
      k = i;
      if (localObject != null) {
        k = i + ((ItemRecod)localObject).height;
      }
      j++;
    }
    ItemRecod localItemRecod = (ItemRecod)this.recordSp.get(this.mCurrentfirstVisibleItem);
    Object localObject = localItemRecod;
    if (localItemRecod == null) {
      localObject = new ItemRecod();
    }
    return i - ((ItemRecod)localObject).top;
  }
  
  private void init()
  {
    setOnScrollListener(new ScrollPositionListView.1(this));
  }
  
  public void setOnScrollYListener(OnScrollYListener paramOnScrollYListener)
  {
    this.onScrollYListener = paramOnScrollYListener;
  }
  
  class ItemRecod
  {
    int height = 0;
    int top = 0;
    
    ItemRecod() {}
  }
  
  public static abstract interface OnScrollYListener
  {
    public abstract void onScrollY(int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/view/ScrollPositionListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */