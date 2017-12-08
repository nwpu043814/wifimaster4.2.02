package com.wifipay.wallet.paypassword.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.prod.core.model.BankCard;
import java.util.ArrayList;
import java.util.HashMap;

public class RetrievePPCardFragment
  extends BaseFragment
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  protected ArrayList<BankCard> a;
  private ListView b;
  private View c;
  private View d;
  private TextView e;
  private String f;
  
  private void e()
  {
    this.c.setOnClickListener(this);
    this.c.setBackgroundResource(R.drawable.wifipay_pref_item_bg_p);
    this.e.setText(R.string.wifipay_add_new_card);
    if ((com.wifipay.wallet.common.utils.f.a(this.a)) && (this.a.size() > 0))
    {
      this.d.setVisibility(0);
      this.b.setAdapter(new a(getActivity()));
      this.b.setOnItemClickListener(this);
    }
    for (;;)
    {
      return;
      this.d.setVisibility(8);
    }
  }
  
  private void f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bindcardsource", CashierType.SETPWD.getType());
    localHashMap.put("cashier_type", this.f);
    Intent localIntent = new Intent("com.wifipay.action.BIND_CARD");
    localIntent.putExtra("local_data", localHashMap);
    startActivity(localIntent);
    c().finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_retrieve_add_card) {
      f();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = ((ArrayList)getArguments().getSerializable("card_list"));
    this.f = getArguments().getString("cashier_type");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifipay_fragment_retrieve_pp_card, null);
    this.b = ((ListView)paramLayoutInflater.findViewById(R.id.wifipay_retrieve_card_list));
    this.c = paramLayoutInflater.findViewById(R.id.wifipay_retrieve_add_card);
    this.d = paramLayoutInflater.findViewById(R.id.wifipay_retrieve_card_list_area);
    this.e = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_card_item_info));
    e();
    return paramLayoutInflater;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (BankCard)this.a.get(paramInt);
    paramView = new Bundle();
    paramView.putSerializable("card_info", paramAdapterView);
    paramView.putSerializable("cashier_type", this.f);
    a(R.id.wifipay_fragment_pp_new, paramView);
  }
  
  private class a
    extends BaseAdapter
  {
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public int getCount()
    {
      return RetrievePPCardFragment.this.a.size();
    }
    
    public Object getItem(int paramInt)
    {
      return RetrievePPCardFragment.this.a.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      BankCard localBankCard;
      if (paramView == null)
      {
        paramView = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(R.layout.wifipay_select_card_item_wx, null);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(R.id.wifipay_card_item_info));
        paramViewGroup.b = ((TextView)paramView.findViewById(R.id.wifipay_sub_card_item_info));
        paramViewGroup.b.setVisibility(8);
        paramView.setTag(paramViewGroup);
        localBankCard = (BankCard)getItem(paramInt);
        if (!localBankCard.cardType.equals("DR")) {
          break label168;
        }
      }
      label168:
      for (String str = com.wifipay.common.a.f.a(R.string.wifipay_debit_card);; str = com.wifipay.common.a.f.a(R.string.wifipay_credit_card))
      {
        paramViewGroup.a.setText(localBankCard.bankName + str + "(" + localBankCard.cardNo + ")");
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    private class a
    {
      public TextView a;
      public TextView b;
      
      private a() {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/fragment/RetrievePPCardFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */