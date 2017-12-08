package com.wifipay.wallet.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifipay.R.layout;
import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.home.bean.SubApp;
import com.wifipay.wallet.home.widget.image.SmartImageView;
import java.util.List;

public class HomeGridAdapter
  extends BaseAdapter
{
  private Context a;
  private List<SubApp> b;
  private onItemClickListener c;
  
  public HomeGridAdapter(Context paramContext, List<SubApp> paramList)
  {
    this.b = paramList;
    this.a = paramContext;
  }
  
  public void a(onItemClickListener paramonItemClickListener)
  {
    this.c = paramonItemClickListener;
  }
  
  public void a(List<SubApp> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.b == null) {}
    for (int i = 0;; i = this.b.size()) {
      return i;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SubApp localSubApp;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.wifipay_home_content_item, paramViewGroup, false);
      paramViewGroup = new a(paramView, this.a);
      paramView.setTag(paramViewGroup);
      localSubApp = (SubApp)this.b.get(paramInt);
      paramViewGroup.b.setText(localSubApp.name);
      paramViewGroup.a.setImageUrl(localSubApp.icon);
      if (!f.b(localSubApp.tag)) {
        break label152;
      }
      paramViewGroup.c.setVisibility(4);
      label96:
      if (!f.b(localSubApp.subTitle)) {
        break label186;
      }
      paramViewGroup.d.setVisibility(4);
    }
    for (;;)
    {
      if (this.c != null) {
        paramViewGroup.e.setOnClickListener(new b(this, paramViewGroup, paramInt));
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label152:
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setImageUrl(((SubApp)this.b.get(paramInt)).tag);
      break label96;
      label186:
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setText(localSubApp.subTitle);
    }
  }
  
  public static abstract interface onItemClickListener
  {
    public abstract void onItemClick(View paramView, int paramInt);
    
    public abstract void onItemLongClick();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/adapter/HomeGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */