package com.wifipay.wallet.prod.core.model;

import com.wifipay.common.a.f;
import java.io.Serializable;

public class BankCard
  extends BaseCard
  implements Serializable
{
  private static final long serialVersionUID = -1835956984044470877L;
  public String agreementNo;
  public String bankAccountId;
  public String bankCode;
  public String bankName;
  public String cardNo;
  public String cardType;
  public String lastPay;
  public String mobile;
  public boolean showDelete = false;
  
  public BankCard()
  {
    this.type = "CONVENIENCE";
    this.paymentType = "CONVENIENCE";
  }
  
  public int getLogo()
  {
    return f.a("bank_" + this.bankCode.toLowerCase());
  }
  
  public String getName()
  {
    return this.bankName + " ( *" + this.cardNo + " ) ";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/core/model/BankCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */