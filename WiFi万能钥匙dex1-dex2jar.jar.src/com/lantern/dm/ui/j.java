package com.lantern.dm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bluefay.a.e;
import com.lantern.dm.R.color;
import com.lantern.dm.R.drawable;
import com.lantern.dm.R.string;

final class j
  implements View.OnClickListener
{
  j(i parami, int paramInt, long paramLong, b.d paramd) {}
  
  public final void onClick(View paramView)
  {
    if (!i.a(this.d)) {
      e.a(i.b(this.d).getString(R.string.download_operation_frequent));
    }
    for (;;)
    {
      return;
      if ((this.a == 192) || (this.a == 190))
      {
        i.c(this.d).b(new long[] { this.b });
        this.c.g.setText(i.b(this.d).getString(R.string.download_continu_file));
        this.c.g.setTextColor(i.b(this.d).getResources().getColor(R.color.framework_primary_color));
        this.c.g.setBackgroundResource(R.drawable.dm_button_resume_bg);
      }
      else if (!com.bluefay.a.a.c(i.b(this.d)))
      {
        e.a(i.b(this.d).getString(R.string.download_newwork_failed));
      }
      else if (e.b(i.b(this.d)))
      {
        i.a(this.d, this.c, this.b);
        com.lantern.analytics.a.e().onEvent("dlmw");
      }
      else
      {
        i.c(this.d).c(new long[] { this.b });
        this.c.g.setText(i.b(this.d).getString(R.string.download_pause_file));
        this.c.g.setTextColor(i.b(this.d).getResources().getColor(R.color.framework_list_fragment_tips_text_color));
        this.c.g.setBackgroundResource(R.drawable.dm_button_pause_bg);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */