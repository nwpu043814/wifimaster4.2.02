package com.lantern.dm.ui;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Button;
import com.lantern.dm.R.color;
import com.lantern.dm.R.drawable;
import com.lantern.dm.R.string;

final class k
  implements DialogInterface.OnClickListener
{
  k(i parami, long paramLong, b.d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new ContentValues();
    paramDialogInterface.put("numfailed", "0");
    paramDialogInterface.put("allowed_network_types", "-1");
    paramDialogInterface.put("control", Integer.valueOf(0));
    paramDialogInterface.put("status", Integer.valueOf(190));
    i.b(this.c).getContentResolver().update(com.lantern.core.model.a.a, paramDialogInterface, " status != '192' AND _id = ? ", new String[] { String.valueOf(this.a) });
    this.b.g.setText(i.b(this.c).getString(R.string.download_pause_file));
    this.b.g.setTextColor(i.b(this.c).getResources().getColor(R.color.framework_list_fragment_tips_text_color));
    this.b.g.setBackgroundResource(R.drawable.dm_button_pause_bg);
    com.lantern.analytics.a.e().onEvent("dlmw1");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */