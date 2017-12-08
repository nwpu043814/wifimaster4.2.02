package com.lantern.feed.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.lantern.feed.ui.h;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private List<d> a;
  
  public c(List<d> paramList)
  {
    this.a = paramList;
  }
  
  public final int getCount()
  {
    if (this.a != null) {}
    for (int i = this.a.size() - 1;; i = 0) {
      return i;
    }
  }
  
  public final Object getItem(int paramInt)
  {
    if ((this.a != null) && (paramInt >= 0) && (paramInt < this.a.size() - 1)) {}
    for (Object localObject = this.a.get(paramInt + 1);; localObject = null) {
      return localObject;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.a != null) && (paramInt >= 0) && (paramInt < this.a.size() - 1)) {}
    for (d locald = (d)this.a.get(paramInt + 1);; locald = null)
    {
      if (locald != null) {
        if (paramView == null)
        {
          paramView = new h(paramViewGroup.getContext());
          paramView.setText(locald.b());
          paramView.a();
        }
      }
      for (;;)
      {
        return paramView;
        paramView = (h)paramView;
        break;
        paramView = null;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */