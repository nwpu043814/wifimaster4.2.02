package bluefay.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class e
  implements DialogInterface.OnClickListener
{
  e(ListPreference paramListPreference) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ListPreference.a(this.a, paramInt);
    this.a.onClick(paramDialogInterface, -1);
    paramDialogInterface.dismiss();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */