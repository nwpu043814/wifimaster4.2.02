package com.lantern.browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public final class bc
  extends BaseAdapter
{
  private Context a;
  private List<String> b = new ArrayList();
  
  public bc(Context paramContext, List<String> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public final int getCount()
  {
    return this.b.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if ((paramInt > this.b.size() - 1) || (paramInt < 0)) {}
    for (Object localObject = null;; localObject = this.b.get(paramInt)) {
      return localObject;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(R.layout.browser_popmenu_item, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.a = ((TextView)paramView.findViewById(R.id.popmenu_item));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText((CharSequence)this.b.get(paramInt));
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  private static final class a
  {
    TextView a;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */