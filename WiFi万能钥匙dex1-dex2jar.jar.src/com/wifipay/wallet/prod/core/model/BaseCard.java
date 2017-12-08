package com.wifipay.wallet.prod.core.model;

import android.text.TextUtils;
import java.io.Serializable;

public abstract class BaseCard
  implements Serializable
{
  private static final long serialVersionUID = -7626245315958768336L;
  public String enabled;
  public String isDefault;
  public String paymentType;
  public String type;
  
  public abstract int getLogo();
  
  public abstract String getName();
  
  public String getType()
  {
    if (TextUtils.isEmpty(this.type)) {
      this.type = this.paymentType;
    }
    return this.type;
  }
  
  public boolean isDefault()
  {
    return TextUtils.equals(this.isDefault, "Y");
  }
  
  public boolean isEnable()
  {
    return TextUtils.equals(this.enabled, "Y");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/core/model/BaseCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */