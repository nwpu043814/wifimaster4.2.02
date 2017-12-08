package com.wifipay.wallet.bank.presenter;

import android.content.Intent;
import android.view.Window;
import android.widget.ListView;
import com.wifipay.R.id;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.bank.activity.BankQuotaActivity;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.BankCard;
import com.wifipay.wallet.prod.security.query.QueryHpsCardResp;
import com.wifipay.wallet.prod.security.query.QueryService;
import java.util.ArrayList;

public class a
  implements IBankManage
{
  private final BaseActivity a;
  private com.wifipay.wallet.bank.a b;
  private ListView c;
  private ArrayList<BankCard> d = new ArrayList();
  
  public a(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  private void a(BankCard paramBankCard)
  {
    Intent localIntent = new Intent(this.a, BankQuotaActivity.class);
    localIntent.putExtra("agreement_id", paramBankCard.agreementNo);
    localIntent.putExtra("card_no", paramBankCard.cardNo);
    localIntent.putExtra("card_code", paramBankCard.bankCode);
    localIntent.putExtra("card_unbind_h5", b(paramBankCard));
    this.a.startActivity(localIntent);
  }
  
  private String b(BankCard paramBankCard)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("?bankcode=").append(paramBankCard.bankCode.toLowerCase()).append("&bankname=").append(paramBankCard.bankName).append("&banktype=").append(paramBankCard.cardType).append("&banknumber=").append(paramBankCard.cardNo).append("&agreementNo=").append(paramBankCard.agreementNo);
    return localStringBuffer.toString();
  }
  
  public void initView()
  {
    this.c = ((ListView)this.a.getWindow().findViewById(R.id.wifipay_bank_manager_item));
    this.c.setOnItemClickListener(new b(this));
  }
  
  public void onStart()
  {
    ((QueryService)RpcService.getBgRpcProxy(QueryService.class)).queryHpsCard(String.valueOf(System.currentTimeMillis()));
  }
  
  public void setAdapter(QueryHpsCardResp paramQueryHpsCardResp)
  {
    if (paramQueryHpsCardResp == null)
    {
      if (this.b == null) {
        this.b = new com.wifipay.wallet.bank.a(this.a, this.d);
      }
      if (this.c != null) {
        this.c.setAdapter(this.b);
      }
    }
    for (;;)
    {
      return;
      if (ResponseCode.SUCCESS.getCode().equals(paramQueryHpsCardResp.resultCode))
      {
        this.d.clear();
        this.d.addAll(paramQueryHpsCardResp.resultObject);
        if (this.b == null)
        {
          this.b = new com.wifipay.wallet.bank.a(this.a, this.d);
          this.c.setAdapter(this.b);
        }
        else
        {
          this.b.notifyDataSetChanged();
        }
      }
      else
      {
        this.a.b(paramQueryHpsCardResp.resultMessage);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/bank/presenter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */