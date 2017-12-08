package com.lantern.browser.comment.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.bluefay.a.e;
import com.lantern.browser.R.string;

final class f
  implements View.OnClickListener
{
  f(b paramb) {}
  
  public final void onClick(View paramView)
  {
    paramView = b.c(this.a).getText().toString().trim().replaceAll("\n\n+", "\n");
    if (paramView.length() > 5000) {
      e.a(String.format(this.a.getContext().getString(R.string.comment_error_msg5), new Object[] { Integer.valueOf(5000) }));
    }
    for (;;)
    {
      return;
      if (b.d(this.a) != null) {
        b.d(this.a).a(paramView);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */