package bluefay.app;

import android.view.MenuItem;
import android.widget.PopupWindow;

final class d
  implements com.bluefay.widget.b
{
  d(b paramb) {}
  
  public final void a(MenuItem paramMenuItem)
  {
    if (paramMenuItem != null)
    {
      this.a.onMenuItemSelected(0, paramMenuItem);
      if (b.b(this.a) != null)
      {
        b.b(this.a).dismiss();
        b.c(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */