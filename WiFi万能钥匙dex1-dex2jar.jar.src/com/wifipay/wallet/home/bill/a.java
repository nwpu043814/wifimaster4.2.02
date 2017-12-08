package com.wifipay.wallet.home.bill;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.wifipay.R.array;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.common.a.f;
import com.wifipay.common.a.g;
import java.util.List;
import java.util.Map;

public class a
  extends BaseAdapter
{
  String[] a = f.c(R.array.wifipay_bill_details_type);
  private boolean b = false;
  private List<Map<String, Object>> c;
  private Context d;
  
  public a(List<Map<String, Object>> paramList, boolean paramBoolean, Context paramContext)
  {
    this.b = paramBoolean;
    this.d = paramContext;
    this.c = paramList;
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.wifipay_home_bill_detail_item, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setText((String)((Map)this.c.get(paramInt)).get("bill_type"));
      paramViewGroup.b.setText((String)((Map)this.c.get(paramInt)).get("bill_content"));
      if ((!this.b) || (!g.a((String)((Map)this.c.get(paramInt)).get("bill_type"), this.a[10]))) {
        break label158;
      }
      paramViewGroup.b.setTextColor(-65536);
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label158:
      paramViewGroup.b.setTextColor(this.d.getResources().getColor(R.color.wifipay_color_999999));
    }
  }
  
  static class a
  {
    TextView a;
    TextView b;
    
    public a(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(R.id.wifipay_item_detail_text_type));
      this.b = ((TextView)paramView.findViewById(R.id.wifipay_item_detail_text_content));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */