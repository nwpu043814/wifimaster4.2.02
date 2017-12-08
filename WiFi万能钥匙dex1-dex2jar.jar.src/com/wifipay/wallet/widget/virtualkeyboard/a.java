package com.wifipay.wallet.widget.virtualkeyboard;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;

public class a
  extends BaseAdapter
{
  private Context a;
  private SparseArray<String> b;
  
  public a(Context paramContext, SparseArray<String> paramSparseArray)
  {
    this.a = paramContext;
    this.b = paramSparseArray;
  }
  
  public void a(SparseArray<String> paramSparseArray)
  {
    this.b = paramSparseArray;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
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
    if (paramView == null)
    {
      paramView = View.inflate(this.a, R.layout.wifipay_virtual_keyboard_item, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(R.id.wifipay_keyboard_text_keys));
      paramViewGroup.b = ((RelativeLayout)paramView.findViewById(R.id.wifipay_keyboard_delete));
      paramView.setTag(paramViewGroup);
      if (paramInt != 9) {
        break label121;
      }
      paramViewGroup.b.setVisibility(4);
      paramViewGroup.a.setVisibility(0);
      paramViewGroup.a.setText((CharSequence)this.b.get(paramInt));
      paramViewGroup.a.setBackgroundResource(R.drawable.wifipay_password_delete_key_bg);
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label121:
      if (paramInt == 11)
      {
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.a.setVisibility(4);
      }
      else
      {
        paramViewGroup.b.setVisibility(4);
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.a.setText((CharSequence)this.b.get(paramInt));
      }
    }
  }
  
  public final class a
  {
    public TextView a;
    public RelativeLayout b;
    
    public a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/widget/virtualkeyboard/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */