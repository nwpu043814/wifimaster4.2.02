package com.linksure.apservice.ui.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.b.b;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context a;
  private List<b> b;
  
  public a(Context paramContext, List<b> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public final b a(int paramInt)
  {
    return (b)this.b.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.b == null) {}
    for (int i = 0;; i = this.b.size()) {
      return i;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.a).inflate(R.layout.aps_category_adapter, paramViewGroup, false);
    ((TextView)paramView.findViewById(R.id.category)).setText(((b)this.b.get(paramInt)).b);
    return paramView;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */