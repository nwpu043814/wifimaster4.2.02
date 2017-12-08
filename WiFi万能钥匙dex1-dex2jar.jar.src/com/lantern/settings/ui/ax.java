package com.lantern.settings.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.lantern.settings.R.string;

final class ax
  implements View.OnClickListener
{
  ax(SpitslotActivity paramSpitslotActivity) {}
  
  public final void onClick(View paramView)
  {
    ((ClipboardManager)this.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", "481721560"));
    Toast.makeText(this.a.getBaseContext(), R.string.settings_spitslot_copy_qq_toast, 0).show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */