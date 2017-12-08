package com.wifipay.wallet.prod.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class StartPayParams
  implements Serializable
{
  private static final long serialVersionUID = 2217251327397947940L;
  public HashMap<String, String> additionalParams;
  public String bindcardsource;
  public ArrayList<PayCard> cards;
  public PayCard chosenCard;
  public ProductInfo productInfo;
  public String subType;
  public String type;
  
  public static class ProductInfo
    implements Serializable
  {
    private static final long serialVersionUID = 5028004620966190468L;
    public String productAccountName;
    public String productAmount;
    public String productAmountFavourable;
    public String productAmountOld;
    public String productName;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/core/model/StartPayParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */