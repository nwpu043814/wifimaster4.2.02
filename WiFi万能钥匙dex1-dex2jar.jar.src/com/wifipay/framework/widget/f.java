package com.wifipay.framework.widget;

import android.text.Editable;
import android.text.TextWatcher;

class f
  implements TextWatcher
{
  f(WPClearEditText paramWPClearEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    WPClearEditText localWPClearEditText = this.a;
    if ((this.a.isEnabled()) && (paramCharSequence.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localWPClearEditText.a(true, bool);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */