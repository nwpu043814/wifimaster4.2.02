package com.linksure.apservice.ui.category;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class j
  implements DialogInterface.OnCancelListener
{
  j(CategoryFragment paramCategoryFragment) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    this.a.getActivity().finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */