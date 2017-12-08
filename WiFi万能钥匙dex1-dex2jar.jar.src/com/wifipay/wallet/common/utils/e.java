package com.wifipay.wallet.common.utils;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;

final class e
  implements TextWatcher
{
  int a = 0;
  int b = 0;
  boolean c = false;
  int d = 0;
  int e = 0;
  private char[] g;
  private StringBuffer h = new StringBuffer();
  
  e(EditText paramEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (this.c)
    {
      this.d = this.f.getSelectionEnd();
      int i = 0;
      while (i < this.h.length()) {
        if (this.h.charAt(i) == ' ') {
          this.h.deleteCharAt(i);
        } else {
          i++;
        }
      }
      i = 0;
      int j = 0;
      while (j < this.h.length())
      {
        int k;
        if ((j != 4) && (j != 9) && (j != 14))
        {
          k = i;
          if (j != 19) {}
        }
        else
        {
          this.h.insert(j, ' ');
          k = i + 1;
        }
        j++;
        i = k;
      }
      if (i > this.e)
      {
        j = this.d;
        this.d = (i - this.e + j);
      }
      this.g = new char[this.h.length()];
      this.h.getChars(0, this.h.length(), this.g, 0);
      paramEditable = this.h.toString();
      if (this.d <= paramEditable.length()) {
        break label241;
      }
      this.d = paramEditable.length();
    }
    for (;;)
    {
      this.f.setText(paramEditable);
      Selection.setSelection(this.f.getText(), this.d);
      this.c = false;
      return;
      label241:
      if (this.d < 0) {
        this.d = 0;
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 0;
    this.a = paramCharSequence.length();
    if (this.h.length() > 0) {
      this.h.delete(0, this.h.length());
    }
    this.e = 0;
    while (paramInt1 < paramCharSequence.length())
    {
      if (paramCharSequence.charAt(paramInt1) == ' ') {
        this.e += 1;
      }
      paramInt1++;
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramCharSequence.length();
    this.h.append(paramCharSequence.toString());
    if ((this.b == this.a) || (this.b <= 3) || (this.c)) {}
    for (this.c = false;; this.c = true) {
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */