package bluefay.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class c
  implements DialogInterface.OnClickListener
{
  c(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = b.a(this.a).a(paramInt);
    if (paramDialogInterface != null) {
      this.a.onMenuItemSelected(0, paramDialogInterface);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */