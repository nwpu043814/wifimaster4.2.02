package com.wifipay.wallet.bank;

public enum BankStatusColor
{
  ABC("#018c77"),  BOC("#c75056"),  BOS("#d39049"),  CIB("#1b65a4"),  CITIC("#c75056"),  CMB("#c75056"),  CMBC("#018c77"),  GD("#92458d"),  HXB("#c75056"),  ICBC("#c75056"),  JS("#1b65a4"),  PSBC("#018c77"),  SPDB("#1b65a4"),  SZPAB("#d39049");
  
  private String mColor;
  
  private BankStatusColor(String paramString)
  {
    this.mColor = paramString;
  }
  
  public final String getType()
  {
    return this.mColor;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/bank/BankStatusColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */