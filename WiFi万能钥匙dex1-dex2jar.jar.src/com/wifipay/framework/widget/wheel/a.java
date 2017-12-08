package com.wifipay.framework.widget.wheel;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public abstract class a
  implements WheelViewAdapter
{
  private List<DataSetObserver> a;
  
  public View getEmptyItem(View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.a == null) {
      this.a = new LinkedList();
    }
    this.a.add(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.a != null) {
      this.a.remove(paramDataSetObserver);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/wheel/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */