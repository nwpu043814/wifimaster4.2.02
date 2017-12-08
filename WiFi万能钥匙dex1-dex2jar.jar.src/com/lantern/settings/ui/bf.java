package com.lantern.settings.ui;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.lantern.settings.diagnose.AutoScrollTextView;

final class bf
  implements Runnable
{
  bf(bd parambd, String paramString) {}
  
  public final void run()
  {
    if (UrlTestActivity.b(this.b.e)) {}
    for (;;)
    {
      return;
      SpannableString localSpannableString = new SpannableString("error:" + this.a);
      localSpannableString.setSpan(new ForegroundColorSpan(-65281), 0, localSpannableString.length(), 33);
      UrlTestActivity.c(this.b.e).append("\n");
      UrlTestActivity.c(this.b.e).append(localSpannableString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */