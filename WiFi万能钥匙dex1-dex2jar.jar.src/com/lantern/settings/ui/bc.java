package com.lantern.settings.ui;

import android.widget.Button;
import com.lantern.settings.diagnose.AutoScrollTextView;
import java.text.DecimalFormat;

final class bc
  implements Runnable
{
  bc(ba paramba) {}
  
  public final void run()
  {
    if (UrlTestActivity.b(this.a.a)) {}
    for (;;)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\nsuccess:" + UrlTestActivity.g(this.a.a));
      localStringBuilder.append("\nfailed:" + UrlTestActivity.h(this.a.a));
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
      localStringBuilder.append("\nrate:" + localDecimalFormat.format(UrlTestActivity.g(this.a.a) * 100.0D / (UrlTestActivity.g(this.a.a) + UrlTestActivity.h(this.a.a))) + "%");
      UrlTestActivity.c(this.a.a).append(localStringBuilder.toString());
      UrlTestActivity.d(this.a.a).setEnabled(true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */