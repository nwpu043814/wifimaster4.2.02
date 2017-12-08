package com.lantern.browser.search.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.lantern.browser.search.ui.WkSearchHistoryItem;

public final class a
  extends BaseAdapter
{
  public final int getCount()
  {
    return com.lantern.browser.search.a.a.a().b();
  }
  
  public final Object getItem(int paramInt)
  {
    return com.lantern.browser.search.a.a.a().a(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    c localc = com.lantern.browser.search.a.a.a().a(paramInt);
    if (localc == null)
    {
      paramView = null;
      return paramView;
    }
    if (paramView != null) {}
    for (paramView = (WkSearchHistoryItem)paramView;; paramView = new WkSearchHistoryItem(paramViewGroup.getContext()))
    {
      paramView.a(localc);
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */