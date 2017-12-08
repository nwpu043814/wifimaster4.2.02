package com.wifipay.wallet.prod.core.model;

import android.text.TextUtils;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.common.a.g;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.common.info.b;
import java.io.Serializable;

public class PayCard
  extends BaseCard
  implements Serializable
{
  private static final String NEW_BANK_CARD_DEPOSIT = "添加新卡充值";
  private static final String NEW_BANK_CARD_PAY = "添加新卡支付";
  private static final String NEW_BANK_CARD_TRANSFER = "添加新卡转账";
  private static final String NEW_BANK_CARD_WITHDRAW = "添加新卡提现";
  private static final long serialVersionUID = 5590433112948586129L;
  public String agreementNo;
  public String bankCode;
  public String cardNo;
  public String cardType;
  public String desc;
  public String instMobile;
  public String mobile;
  public int seqNum;
  
  public static PayCard balanceCard()
  {
    PayCard localPayCard = new PayCard();
    localPayCard.desc = f.a(R.string.wifipay_pay_with_balance);
    localPayCard.type = "BALANCE";
    localPayCard.paymentType = "BALANCE";
    if (Float.parseFloat(b.a().k()) > 0.0F) {}
    for (localPayCard.enabled = "Y";; localPayCard.enabled = "N")
    {
      localPayCard.isDefault = "N";
      return localPayCard;
    }
  }
  
  public static PayCard newCard(String paramString)
  {
    PayCard localPayCard = new PayCard();
    if (!g.a(paramString)) {
      if (g.a(paramString, CashierType.DEPOSIT.getType())) {
        localPayCard.desc = "添加新卡充值";
      }
    }
    for (;;)
    {
      localPayCard.type = "NEW_CARD";
      localPayCard.paymentType = "CONVENIENCE";
      localPayCard.enabled = "Y";
      localPayCard.isDefault = "N";
      localPayCard.seqNum = 100;
      return localPayCard;
      if (g.a(paramString, CashierType.TRANSFER.getType())) {
        localPayCard.desc = "添加新卡转账";
      } else if (g.a(paramString, CashierType.WITHDRAW.getType())) {
        localPayCard.desc = "添加新卡提现";
      } else if (g.a(paramString, CashierType.CALLAPPPAY.getType())) {
        localPayCard.desc = "添加新卡支付";
      }
    }
  }
  
  public int getLogo()
  {
    int i;
    if (TextUtils.equals(getType(), "BALANCE")) {
      i = f.a("wifipay_wallet_logo");
    }
    for (;;)
    {
      return i;
      if (TextUtils.equals(getType(), "NEW_CARD")) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public String getName()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(this.desc);
    if (TextUtils.equals(getType(), "CONVENIENCE")) {
      if (this.cardType.equals("DR"))
      {
        str = f.a(R.string.wifipay_debit_card);
        localStringBuilder1.append(str).append("(").append(this.cardNo).append(")");
      }
    }
    while (!TextUtils.equals(getType(), "BALANCE")) {
      for (;;)
      {
        return localStringBuilder1.toString();
        str = f.a(R.string.wifipay_credit_card);
      }
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append("(剩余¥");
    if (b.a().k() == null) {}
    for (String str = "0";; str = b.a().k())
    {
      localStringBuilder2.append(str).append(")");
      if (Float.parseFloat(b.a().k()) > 0.0F) {
        break;
      }
      this.enabled = "N";
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/core/model/PayCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */