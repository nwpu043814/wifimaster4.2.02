package com.wifipay.wallet.authentication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.wallet.BaseActivity;

public class UploadResultActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String h;
  
  static
  {
    StubApp1053578832.interface11(104);
  }
  
  private void i()
  {
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("mobile"))) {
      this.h = localBundle.getString("mobile");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_btn_confirm) {
      finish();
    }
  }
  
  public native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/activity/UploadResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */