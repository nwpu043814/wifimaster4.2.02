package com.wifipay.wallet.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class UserInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<UserInfo> CREATOR = new c();
  private static final long serialVersionUID = -6710393720922190240L;
  private String accessToken;
  private boolean autoLogin;
  private String availableBalance = "0.00";
  private String category;
  private String cert;
  private String certNo;
  private String certSerialNo;
  private String frozenBalance = "0.00";
  private String gesturePwd;
  private String headerImage;
  private String lati;
  private String loginName;
  private long loginTime;
  private String loginType;
  private String longi;
  private String mapSP;
  private String memberId;
  private String merchantNo = "1234";
  private String mobileNumber;
  private String operatorId;
  private String outToken;
  private String realName;
  private String remainMoney;
  private String trueName;
  private String uhId;
  private String userAvatar;
  private int walletState = -1;
  
  public UserInfo() {}
  
  public UserInfo(Parcel paramParcel)
  {
    this.loginName = paramParcel.readString();
    this.memberId = paramParcel.readString();
    this.operatorId = paramParcel.readString();
    this.accessToken = paramParcel.readString();
    this.trueName = paramParcel.readString();
    this.certNo = paramParcel.readString();
    this.gesturePwd = paramParcel.readString();
    boolean[] arrayOfBoolean = new boolean[1];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.autoLogin = arrayOfBoolean[0];
    this.mobileNumber = paramParcel.readString();
    this.userAvatar = paramParcel.readString();
    this.loginTime = paramParcel.readLong();
    this.loginType = paramParcel.readString();
    this.walletState = paramParcel.readInt();
    this.availableBalance = paramParcel.readString();
    this.frozenBalance = paramParcel.readString();
    this.outToken = paramParcel.readString();
    this.uhId = paramParcel.readString();
    this.longi = paramParcel.readString();
    this.lati = paramParcel.readString();
    this.mapSP = paramParcel.readString();
    this.remainMoney = paramParcel.readString();
    this.realName = paramParcel.readString();
    this.cert = paramParcel.readString();
    this.certSerialNo = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccessToken()
  {
    return this.accessToken;
  }
  
  public String getAvailableBalance()
  {
    return this.availableBalance;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getCert()
  {
    return this.cert;
  }
  
  public String getCertNo()
  {
    return this.certNo;
  }
  
  public String getCertSerialNo()
  {
    return this.certSerialNo;
  }
  
  public String getFrozenBalance()
  {
    return this.frozenBalance;
  }
  
  public String getHeaderImage()
  {
    return this.headerImage;
  }
  
  public String getLati()
  {
    return this.lati;
  }
  
  public String getLoginName()
  {
    return this.loginName;
  }
  
  public String getLongi()
  {
    return this.longi;
  }
  
  public String getMapSP()
  {
    return this.mapSP;
  }
  
  public String getMemberId()
  {
    return this.memberId;
  }
  
  public String getMerchantNo()
  {
    return this.merchantNo;
  }
  
  public String getOperatorId()
  {
    return this.operatorId;
  }
  
  public String getOutToken()
  {
    return this.outToken;
  }
  
  public String getRealName()
  {
    return this.realName;
  }
  
  public String getRemainMoney()
  {
    return this.remainMoney;
  }
  
  public String getTrueName()
  {
    return this.trueName;
  }
  
  public String getUhId()
  {
    return this.uhId;
  }
  
  public int getWalletState()
  {
    return this.walletState;
  }
  
  public boolean isAutoLogin()
  {
    return this.autoLogin;
  }
  
  public void setAccessToken(String paramString)
  {
    this.accessToken = paramString;
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    this.autoLogin = paramBoolean;
  }
  
  public void setAvailableBalance(String paramString)
  {
    this.availableBalance = paramString;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setCert(String paramString)
  {
    this.cert = paramString;
  }
  
  public void setCertNo(String paramString)
  {
    this.certNo = paramString;
  }
  
  public void setCertSerialNo(String paramString)
  {
    this.certSerialNo = paramString;
  }
  
  public void setFrozenBalance(String paramString)
  {
    this.frozenBalance = paramString;
  }
  
  public void setHeaderImage(String paramString)
  {
    this.headerImage = paramString;
  }
  
  public void setLati(String paramString)
  {
    this.lati = paramString;
  }
  
  public void setLoginName(String paramString)
  {
    this.loginName = paramString;
  }
  
  public void setLongi(String paramString)
  {
    this.longi = paramString;
  }
  
  public void setMapSP(String paramString)
  {
    this.mapSP = paramString;
  }
  
  public void setMemberId(String paramString)
  {
    this.memberId = paramString;
  }
  
  public void setMerchantNo(String paramString)
  {
    this.merchantNo = paramString;
  }
  
  public void setOperatorId(String paramString)
  {
    this.operatorId = paramString;
  }
  
  public void setOutToken(String paramString)
  {
    this.outToken = paramString;
  }
  
  public void setRealName(String paramString)
  {
    this.realName = paramString;
  }
  
  public void setRemainMoney(String paramString)
  {
    this.remainMoney = paramString;
  }
  
  public void setTrueName(String paramString)
  {
    this.trueName = paramString;
  }
  
  public void setUhId(String paramString)
  {
    this.uhId = paramString;
  }
  
  public void setWalletState(int paramInt)
  {
    this.walletState = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.loginName);
    paramParcel.writeString(this.memberId);
    paramParcel.writeString(this.operatorId);
    paramParcel.writeString(this.accessToken);
    paramParcel.writeString(this.trueName);
    paramParcel.writeString(this.certNo);
    paramParcel.writeString(this.gesturePwd);
    paramParcel.writeBooleanArray(new boolean[] { this.autoLogin });
    paramParcel.writeString(this.mobileNumber);
    paramParcel.writeString(this.userAvatar);
    paramParcel.writeLong(this.loginTime);
    paramParcel.writeString(this.loginType);
    paramParcel.writeInt(this.walletState);
    paramParcel.writeString(this.availableBalance);
    paramParcel.writeString(this.frozenBalance);
    paramParcel.writeString(this.outToken);
    paramParcel.writeString(this.uhId);
    paramParcel.writeString(this.longi);
    paramParcel.writeString(this.lati);
    paramParcel.writeString(this.mapSP);
    paramParcel.writeString(this.remainMoney);
    paramParcel.writeString(this.realName);
    paramParcel.writeString(this.cert);
    paramParcel.writeString(this.certSerialNo);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/info/UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */