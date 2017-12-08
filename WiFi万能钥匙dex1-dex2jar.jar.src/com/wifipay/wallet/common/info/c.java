package com.wifipay.wallet.common.info;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<UserInfo>
{
  public final UserInfo a(Parcel paramParcel)
  {
    return new UserInfo(paramParcel);
  }
  
  public final UserInfo[] a(int paramInt)
  {
    return new UserInfo[paramInt];
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/info/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */