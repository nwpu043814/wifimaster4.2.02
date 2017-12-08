package com.linksure.apservice.ui.profile.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.style;
import com.linksure.apservice.utils.e;

public class PhotoDialog
  extends DialogFragment
{
  private String a = "";
  
  public static PhotoDialog a()
  {
    return new PhotoDialog();
  }
  
  public final PhotoDialog a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    paramDialogInterface.dismiss();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Object localObject2 = getActivity().getLayoutInflater().inflate(R.layout.aps_photo_dialog, null);
    paramBundle = new Dialog(getActivity(), R.style.style_dialog);
    Object localObject1 = (PhotoView)((View)localObject2).findViewById(R.id.aps_logo);
    ((PhotoView)localObject1).a();
    e.a(this.a, new h(this, (PhotoView)localObject1));
    ((PhotoView)localObject1).findViewById(R.id.aps_logo).setOnClickListener(new i(this));
    paramBundle.setContentView((View)localObject2);
    paramBundle.setCanceledOnTouchOutside(true);
    paramBundle.show();
    localObject1 = paramBundle.getWindow();
    ((Window)localObject1).setWindowAnimations(R.style.aps_photo_dialog);
    ((Window)localObject1).setGravity(80);
    ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
    localObject2 = ((Window)localObject1).getAttributes();
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).height = -1;
    ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    return paramBundle;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/widget/PhotoDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */