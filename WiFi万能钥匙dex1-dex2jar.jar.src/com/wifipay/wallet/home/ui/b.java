package com.wifipay.wallet.home.ui;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

class b
  implements DownloadListener
{
  b(AccountWebActivity paramAccountWebActivity) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    this.a.startActivity(paramString1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */