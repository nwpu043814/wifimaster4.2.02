package com.lantern.browser.comment.b;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;
import java.util.Locale;

final class c
  implements TextWatcher
{
  c(b paramb) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString().trim();
    if (paramEditable.length() > 0)
    {
      b.a(this.a).setVisibility(0);
      paramEditable = String.format(Locale.getDefault(), this.a.getContext().getString(R.string.comment_already_input), new Object[] { Integer.valueOf(paramEditable.length()) });
      b.a(this.a).setText(paramEditable);
      b.b(this.a).setClickable(true);
      b.b(this.a).setBackgroundResource(R.drawable.comment_submit_btn_enable);
    }
    for (;;)
    {
      return;
      b.a(this.a).setVisibility(4);
      b.b(this.a).setClickable(false);
      b.b(this.a).setBackgroundResource(R.drawable.comment_submit_btn_disable);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */