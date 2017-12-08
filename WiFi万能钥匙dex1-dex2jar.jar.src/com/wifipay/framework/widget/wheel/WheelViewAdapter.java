package com.wifipay.framework.widget.wheel;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public abstract interface WheelViewAdapter
{
  public abstract View getEmptyItem(View paramView, ViewGroup paramViewGroup);
  
  public abstract View getItem(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract int getItemsCount();
  
  public abstract void registerDataSetObserver(DataSetObserver paramDataSetObserver);
  
  public abstract void unregisterDataSetObserver(DataSetObserver paramDataSetObserver);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/wheel/WheelViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */