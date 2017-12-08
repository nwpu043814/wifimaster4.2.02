package com.bluefay.preference;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;

public class SettingsDialogFragment
  extends DialogFragment
{
  public DialogInterface.OnCancelListener a;
  public DialogInterface.OnDismissListener b;
  private int c;
  private Fragment d;
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    if (this.a != null) {
      this.a.onCancel(paramDialogInterface);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.c = paramBundle.getInt("key_dialog_id", 0);
      int i = paramBundle.getInt("key_parent_fragment_id", -1);
      if (i >= 0)
      {
        this.d = getFragmentManager().findFragmentById(i);
        if (!(this.d instanceof a)) {
          throw new IllegalArgumentException("key_parent_fragment_id must implement " + a.class.getName());
        }
      }
      if ((this.d instanceof PSPreferenceFragment)) {
        ((PSPreferenceFragment)this.d).i = this;
      }
    }
    return null;
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (((this.d instanceof PSPreferenceFragment)) && (((PSPreferenceFragment)this.d).i == this)) {
      ((PSPreferenceFragment)this.d).i = null;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.b != null) {
      this.b.onDismiss(paramDialogInterface);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.d != null)
    {
      paramBundle.putInt("key_dialog_id", this.c);
      paramBundle.putInt("key_parent_fragment_id", this.d.getId());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.d != null) && ((this.d instanceof PSPreferenceFragment))) {
      PSPreferenceFragment.e();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/preference/SettingsDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */