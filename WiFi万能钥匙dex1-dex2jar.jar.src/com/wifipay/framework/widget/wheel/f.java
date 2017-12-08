package com.wifipay.framework.widget.wheel;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;

public class f
{
  private List<View> a;
  private List<View> b;
  private WPWheelView c;
  
  public f(WPWheelView paramWPWheelView)
  {
    this.c = paramWPWheelView;
  }
  
  private View a(List<View> paramList)
  {
    View localView;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localView = (View)paramList.get(0);
      paramList.remove(0);
    }
    for (paramList = localView;; paramList = null) {
      return paramList;
    }
  }
  
  private List<View> a(View paramView, List<View> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new LinkedList();
    }
    ((List)localObject).add(paramView);
    return (List<View>)localObject;
  }
  
  private void a(View paramView, int paramInt)
  {
    int i = this.c.getViewAdapter().getItemsCount();
    if (((paramInt < 0) || (paramInt >= i)) && (!this.c.c())) {
      this.b = a(paramView, this.b);
    }
    for (;;)
    {
      return;
      this.a = a(paramView, this.a);
    }
  }
  
  public int a(LinearLayout paramLinearLayout, int paramInt, c paramc)
  {
    int j = 0;
    int i = paramInt;
    if (j < paramLinearLayout.getChildCount())
    {
      int k;
      int m;
      if (!paramc.a(paramInt))
      {
        a(paramLinearLayout.getChildAt(j), paramInt);
        paramLinearLayout.removeViewAt(j);
        k = j;
        m = i;
        if (j == 0)
        {
          m = i + 1;
          k = j;
        }
      }
      for (;;)
      {
        paramInt++;
        j = k;
        i = m;
        break;
        k = j + 1;
        m = i;
      }
    }
    return i;
  }
  
  public View a()
  {
    return a(this.a);
  }
  
  public View b()
  {
    return a(this.b);
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/wheel/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */