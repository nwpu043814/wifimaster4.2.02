package com.wifipay.wallet.bank.presenter;

import com.wifipay.wallet.prod.security.query.QueryHpsCardResp;

public abstract interface IBankManage
{
  public abstract void initView();
  
  public abstract void onStart();
  
  public abstract void setAdapter(QueryHpsCardResp paramQueryHpsCardResp);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/bank/presenter/IBankManage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */