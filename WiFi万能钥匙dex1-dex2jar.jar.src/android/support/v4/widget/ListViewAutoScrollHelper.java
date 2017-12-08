package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

public class ListViewAutoScrollHelper
  extends AutoScrollHelper
{
  private final ListView mTarget;
  
  public ListViewAutoScrollHelper(ListView paramListView)
  {
    super(paramListView);
    this.mTarget = paramListView;
  }
  
  public boolean canTargetScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public boolean canTargetScrollVertically(int paramInt)
  {
    boolean bool2 = false;
    ListView localListView = this.mTarget;
    int k = localListView.getCount();
    int j = localListView.getChildCount();
    int i = localListView.getFirstVisiblePosition();
    boolean bool1;
    if (paramInt > 0)
    {
      if ((i + j < k) || (localListView.getChildAt(j - 1).getBottom() > localListView.getHeight())) {
        break label94;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramInt < 0) {
        if (i <= 0)
        {
          bool1 = bool2;
          if (localListView.getChildAt(0).getTop() >= 0) {}
        }
        else
        {
          label94:
          bool1 = true;
        }
      }
    }
  }
  
  public void scrollTargetBy(int paramInt1, int paramInt2)
  {
    ListView localListView = this.mTarget;
    paramInt1 = localListView.getFirstVisiblePosition();
    if (paramInt1 == -1) {}
    for (;;)
    {
      return;
      View localView = localListView.getChildAt(0);
      if (localView != null) {
        localListView.setSelectionFromTop(paramInt1, localView.getTop() - paramInt2);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/ListViewAutoScrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */