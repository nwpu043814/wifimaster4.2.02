package com.lantern.download.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Button;
import com.lantern.dm.R.color;
import com.lantern.dm.R.drawable;
import com.lantern.dm.R.string;

final class c
  implements DialogInterface.OnClickListener
{
  c(a parama, long paramLong, a.a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.c(this.c).c(new long[] { this.a });
    this.b.c.setText(a.b(this.c).getString(R.string.download_pause_file));
    this.b.c.setTextColor(a.b(this.c).getResources().getColor(R.color.framework_list_fragment_tips_text_color));
    this.b.c.setBackgroundResource(R.drawable.dm_button_pause_bg);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */