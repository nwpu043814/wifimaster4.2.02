package com.lantern.download.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bluefay.a.e;
import com.lantern.dm.R.color;
import com.lantern.dm.R.drawable;
import com.lantern.dm.R.string;

final class b
  implements View.OnClickListener
{
  b(a parama, int paramInt, long paramLong, a.a parama1) {}
  
  public final void onClick(View paramView)
  {
    if (!a.a(this.d)) {
      e.a(a.b(this.d).getString(R.string.download_operation_frequent));
    }
    for (;;)
    {
      return;
      if ((this.a == 192) || (this.a == 190))
      {
        a.c(this.d).b(new long[] { this.b });
        this.c.c.setText(a.b(this.d).getString(R.string.download_continu_file));
        this.c.c.setTextColor(a.b(this.d).getResources().getColor(R.color.framework_primary_color));
        this.c.c.setBackgroundResource(R.drawable.dm_button_resume_bg);
      }
      else if (!com.bluefay.a.a.c(a.b(this.d)))
      {
        e.a(a.b(this.d).getString(R.string.download_newwork_failed));
      }
      else if (e.b(a.b(this.d)))
      {
        a.a(this.d, this.c, this.b);
      }
      else
      {
        a.c(this.d).c(new long[] { this.b });
        this.c.c.setText(a.b(this.d).getString(R.string.download_pause_file));
        this.c.c.setTextColor(a.b(this.d).getResources().getColor(R.color.framework_list_fragment_tips_text_color));
        this.c.c.setBackgroundResource(R.drawable.dm_button_pause_bg);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */