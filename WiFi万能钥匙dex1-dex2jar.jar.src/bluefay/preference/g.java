package bluefay.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;

final class g
  implements DialogInterface.OnMultiChoiceClickListener
{
  g(MultiCheckPreference paramMultiCheckPreference) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt, boolean paramBoolean)
  {
    MultiCheckPreference.a(this.a)[paramInt] = paramBoolean;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */