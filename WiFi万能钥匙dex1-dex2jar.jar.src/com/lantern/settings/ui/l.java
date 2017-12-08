package com.lantern.settings.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

final class l
  implements DialogInterface.OnClickListener
{
  l(DiagnoseActivity paramDiagnoseActivity, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.getText().toString();
    String str = this.b.getText().toString();
    try
    {
      if (!TextUtils.isEmpty(paramDialogInterface)) {
        Double.parseDouble(paramDialogInterface);
      }
      if (!TextUtils.isEmpty(str)) {
        Double.parseDouble(str);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        Toast.makeText(this.c, "输入的数据格式不对", 0).show();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */