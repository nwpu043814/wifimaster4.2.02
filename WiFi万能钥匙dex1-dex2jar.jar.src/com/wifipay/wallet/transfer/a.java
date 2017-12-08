package com.wifipay.wallet.transfer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.common.a.g;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.common.utils.f;
import java.util.ArrayList;

public class a
  extends BaseAdapter
{
  private Context a;
  private ArrayList<ContactsDetail> b;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(ArrayList<ContactsDetail> paramArrayList)
  {
    this.b = paramArrayList;
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
    Object localObject;
    if (paramView != null)
    {
      paramViewGroup = (a)paramView.getTag();
      localObject = ((ContactsDetail)this.b.get(paramInt)).payeeName;
      if ((g.a((CharSequence)localObject)) || (f.e((String)localObject))) {
        break label228;
      }
      paramViewGroup.a.setVisibility(0);
      if (((String)localObject).length() <= 2) {
        break label204;
      }
      paramViewGroup.a.setText(((String)localObject).replace(((String)localObject).substring(0, ((String)localObject).length() - 2), "*"));
      label88:
      localObject = ((ContactsDetail)this.b.get(paramInt)).payeeLoginName;
      if (f.c((String)localObject)) {
        break label239;
      }
      paramViewGroup.b.setText(((String)localObject).replace(((String)localObject).substring(3, 7), "****"));
    }
    for (;;)
    {
      return paramView;
      localObject = new a();
      paramView = LayoutInflater.from(this.a).inflate(R.layout.wifipay_item_transfer_linkman, paramViewGroup, false);
      ((a)localObject).a = ((TextView)paramView.findViewById(R.id.wifipay_item_transfer_name));
      ((a)localObject).b = ((TextView)paramView.findViewById(R.id.wifipay_item_transfer_number));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      break;
      label204:
      paramViewGroup.a.setText(((String)localObject).replace(((String)localObject).substring(0, 1), "*"));
      break label88;
      label228:
      paramViewGroup.a.setVisibility(4);
      break label88;
      label239:
      paramViewGroup.b.setText(d.d(((String)localObject).replace(((String)localObject).substring(3, 7), "****")));
    }
  }
  
  class a
  {
    TextView a;
    TextView b;
    
    a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/transfer/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */