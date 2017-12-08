package com.wifi.connect.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

final class o
  extends BaseAdapter
{
  o(n paramn) {}
  
  public final int getCount()
  {
    return n.a(this.a).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return n.a(this.a).get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return (View)n.a(this.a).get(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */