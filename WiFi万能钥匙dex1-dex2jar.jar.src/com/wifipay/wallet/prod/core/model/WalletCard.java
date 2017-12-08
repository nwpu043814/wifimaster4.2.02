package com.wifipay.wallet.prod.core.model;

import com.wifipay.R.string;
import com.wifipay.common.a.f;

public class WalletCard
  extends BaseCard
{
  private static final long serialVersionUID = 2174502536077571960L;
  public String availableBalance;
  public String frozenBalance;
  public String icon = "wallet_logo";
  public String name = f.a(R.string.wifipay_wallet_name);
  public int state;
  
  public WalletCard()
  {
    this.type = "BALANCE";
    this.paymentType = "BALANCE";
  }
  
  public int getLogo()
  {
    return f.a(this.icon);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/core/model/WalletCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */