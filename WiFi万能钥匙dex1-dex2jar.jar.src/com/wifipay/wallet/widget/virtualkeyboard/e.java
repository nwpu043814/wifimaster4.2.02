package com.wifipay.wallet.widget.virtualkeyboard;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class e
  implements View.OnFocusChangeListener
{
  e(VirtualKeyboardView paramVirtualKeyboardView, String paramString, EditText paramEditText) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    VirtualKeyboardView.a(this.c, this.a, this.b);
    VirtualKeyboardView.d(this.c);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/widget/virtualkeyboard/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */