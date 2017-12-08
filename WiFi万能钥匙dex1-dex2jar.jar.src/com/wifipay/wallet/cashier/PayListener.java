package com.wifipay.wallet.cashier;

import com.wifipay.common.net.entitybase.BaseResp;

public abstract interface PayListener
{
  public abstract void payFinish(int paramInt, BaseResp paramBaseResp);
  
  public abstract void rePay();
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/PayListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */