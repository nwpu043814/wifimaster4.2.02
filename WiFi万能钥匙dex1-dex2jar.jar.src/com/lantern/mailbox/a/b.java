package com.lantern.mailbox.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.lantern.mailbox.MailboxActivity;
import com.lantern.mailbox.R.color;

final class b
  implements View.OnClickListener
{
  b(a parama, com.lantern.mailbox.d.a parama1, a.a parama2) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.h())
    {
      this.a.c(false);
      this.b.e.setVisibility(8);
      this.b.b.setText(a.a(this.c, this.a, a.a(this.c).getResources().getColor(R.color.mailbox_gray)));
      com.lantern.mailbox.c.a.a().a(this.a.j());
    }
    if (("2".equals(this.a.o())) || ("1".equals(this.a.o())))
    {
      MailboxActivity.a(a.a(this.c), this.a.q(), "mailbox_list");
      com.lantern.analytics.a.e().onEvent("JMPnews");
    }
    for (;;)
    {
      return;
      paramView = new Intent("android.intent.action.VIEW", Uri.parse(this.a.q()));
      paramView.setPackage(a.a(this.c).getPackageName());
      a.a(this.c).startActivity(paramView);
      com.lantern.analytics.a.e().onEvent("JMPctm");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */