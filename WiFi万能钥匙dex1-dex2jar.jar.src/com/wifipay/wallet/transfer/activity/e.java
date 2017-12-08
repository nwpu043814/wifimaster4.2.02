package com.wifipay.wallet.transfer.activity;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.TimerTask;

class e
  extends TimerTask
{
  e(TransferAmountInputActivity paramTransferAmountInputActivity) {}
  
  public void run()
  {
    ((InputMethodManager)TransferAmountInputActivity.a(this.a).getContext().getSystemService("input_method")).showSoftInput(TransferAmountInputActivity.a(this.a), 0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/transfer/activity/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */