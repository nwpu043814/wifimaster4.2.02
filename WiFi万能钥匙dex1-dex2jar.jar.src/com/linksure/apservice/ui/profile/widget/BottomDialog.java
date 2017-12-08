package com.linksure.apservice.ui.profile.widget;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import bluefay.app.k.a;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.b.a;
import com.linksure.apservice.ui.profile.ProfileActivity;
import com.linksure.apservice.ui.profile.detail.a.a;
import com.linksure.apservice.utils.b;

public class BottomDialog
  extends DialogFragment
{
  private a.a a;
  private a b;
  private Context c;
  
  public static BottomDialog a()
  {
    return new BottomDialog();
  }
  
  public final BottomDialog a(Context paramContext, a.a parama, a parama1)
  {
    this.c = paramContext;
    this.b = parama1;
    this.a = parama;
    return this;
  }
  
  final void b()
  {
    ((ProfileActivity)getActivity()).c(this.b);
    b.b(this.b.k);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    paramDialogInterface.dismiss();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    View localView = LayoutInflater.from(getActivity()).inflate(R.layout.aps_bottom_dialog, null, false);
    paramBundle = new k.a(this.c);
    localView.findViewById(R.id.aps_btn_clean).setOnClickListener(new c(this));
    localView.findViewById(R.id.aps_btn_complain).setOnClickListener(new d(this));
    localView.findViewById(R.id.aps_btn_follow).setOnClickListener(new e(this));
    paramBundle = paramBundle.a(localView).c();
    paramBundle.setCancelable(true);
    paramBundle.setCanceledOnTouchOutside(true);
    return paramBundle;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/widget/BottomDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */