package bluefay.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.bluefay.framework.R.dimen;
import com.bluefay.framework.R.drawable;

public final class a
  extends LinearLayout
{
  public a(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new LinearLayout.LayoutParams(-1, paramContext.getResources().getDimensionPixelSize(R.dimen.framework_webview_bottom_bar_height)));
    setBackgroundResource(R.drawable.framework_title_bar_bg_transparent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/webkit/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */