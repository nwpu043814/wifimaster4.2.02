package com.lantern.wifitools.apgrade.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

final class a
  implements TextWatcher
{
  a(ApGradeEditText paramApGradeEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    int i = ApGradeEditText.a(this.a).length();
    if (i <= 60) {
      ApGradeEditText.b(this.a).setText(String.valueOf(i) + "/60");
    }
    for (;;)
    {
      return;
      paramEditable.delete(60, i);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    ApGradeEditText.a(this.a, paramCharSequence);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */