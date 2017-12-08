package com.lantern.wifiseccheck.view;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class CustomDialog$Builder$2
  implements View.OnClickListener
{
  CustomDialog$Builder$2(CustomDialog.Builder paramBuilder, CustomDialog paramCustomDialog) {}
  
  public void onClick(View paramView)
  {
    if (CustomDialog.Builder.access$200(this.this$0) != null) {
      CustomDialog.Builder.access$200(this.this$0).onClick(this.val$dialog, -2);
    }
    this.val$dialog.dismiss();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/view/CustomDialog$Builder$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */