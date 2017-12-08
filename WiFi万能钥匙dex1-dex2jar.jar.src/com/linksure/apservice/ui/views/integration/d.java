package com.linksure.apservice.ui.views.integration;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.bluefay.b.h;
import java.util.ArrayList;

public final class d
  extends PagerAdapter
{
  private ArrayList<View> a;
  
  public d(ArrayList<View> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {}
  
  public final int getCount()
  {
    return this.a.size();
  }
  
  public final int getItemPosition(Object paramObject)
  {
    return super.getItemPosition(paramObject);
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    h.a("instantiateItem position:" + paramInt, new Object[0]);
    View localView = (View)this.a.get(paramInt);
    if ((localView != null) && (paramViewGroup != null) && (localView.getParent() == null)) {
      paramViewGroup.addView(localView);
    }
    return localView;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    if (paramView == paramObject) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/integration/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */