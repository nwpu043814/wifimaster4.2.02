package com.lantern.e.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;

final class j
  implements DialogInterface.OnClickListener
{
  j(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Process.killProcess(Process.myPid());
    System.exit(0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/e/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */