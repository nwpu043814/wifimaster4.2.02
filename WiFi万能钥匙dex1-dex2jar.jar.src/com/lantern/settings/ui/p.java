package com.lantern.settings.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class p
  implements TextWatcher
{
  p(FeedbackActivity paramFeedbackActivity) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    FeedbackActivity.a(this.a);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */