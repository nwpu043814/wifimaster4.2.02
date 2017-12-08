package com.wifipay.wallet.bank;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.home.widget.image.SmartImageView;
import com.wifipay.wallet.prod.core.model.BankCard;
import java.util.ArrayList;

public class a
  extends BaseAdapter
{
  private BaseActivity a;
  private ArrayList<BankCard> b;
  
  public a(BaseActivity paramBaseActivity, ArrayList<BankCard> paramArrayList)
  {
    this.a = paramBaseActivity;
    if (paramArrayList == null) {}
    for (this.b = new ArrayList();; this.b = paramArrayList) {
      return;
    }
  }
  
  public BankCard a(int paramInt)
  {
    return (BankCard)this.b.get(paramInt);
  }
  
  public int getCount()
  {
    return this.b.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt != this.b.size()) {}
    for (paramInt = 0;; paramInt = 1) {
      return paramInt;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt == this.b.size())
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.wifipay_manager_bankcard_newcard, null);
      paramView.setOnClickListener(new b(this));
      return paramView;
    }
    label73:
    BankCard localBankCard;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.wifipay_manager_bankcard_item, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localBankCard = (BankCard)this.b.get(paramInt);
      paramViewGroup.f.a(d.h(localBankCard.bankCode), R.drawable.wifipay_banklogo_default);
      paramViewGroup.d.setText(localBankCard.bankName);
      paramViewGroup.a.a(d.i(localBankCard.bankCode), R.drawable.wifipay_bankbg_default);
      if (!TextUtils.equals(localBankCard.cardType, "CR")) {
        break label183;
      }
      paramViewGroup.b.setText(R.string.wifipay_credit_card);
    }
    for (;;)
    {
      paramViewGroup.c.setText(localBankCard.cardNo);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label73;
      label183:
      paramViewGroup.b.setText(R.string.wifipay_debit_card);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  static class a
  {
    SmartImageView a;
    TextView b;
    TextView c;
    TextView d;
    RelativeLayout e;
    SmartImageView f;
    
    a(View paramView)
    {
      this.e = ((RelativeLayout)paramView.findViewById(R.id.wifipay_bank_manager_itembg));
      this.f = ((SmartImageView)paramView.findViewById(R.id.wifipay_manager_bank_logo));
      this.d = ((TextView)paramView.findViewById(R.id.wifipay_manager_bank_name));
      this.b = ((TextView)paramView.findViewById(R.id.wifipay_manager_bank_type));
      this.c = ((TextView)paramView.findViewById(R.id.wifipay_manager_bank_number));
      this.a = ((SmartImageView)paramView.findViewById(R.id.wifipay_bank_manager_watermark));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/bank/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */