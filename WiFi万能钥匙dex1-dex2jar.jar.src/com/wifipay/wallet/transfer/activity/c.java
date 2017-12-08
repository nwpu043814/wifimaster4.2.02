package com.wifipay.wallet.transfer.activity;

import android.text.TextUtils;
import android.widget.EditText;
import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;

class c
  implements WPAlertDialog.onPositiveListener
{
  c(TransferAmountInputActivity paramTransferAmountInputActivity) {}
  
  public void onPositive()
  {
    if (TextUtils.isEmpty(TransferAmountInputActivity.a(this.a).getText().toString().trim())) {}
    for (;;)
    {
      return;
      TransferAmountInputActivity.a(this.a, TextUtils.equals(TransferAmountInputActivity.a(this.a).getText().toString().trim(), TransferAmountInputActivity.b(this.a).substring(0, 1)));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/transfer/activity/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */