package com.lantern.feed.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.d.a.b;

final class e
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      String str = paramIntent.getAction();
      long l = paramIntent.getLongExtra("extra_download_id", 0L);
      int i = paramIntent.getIntExtra("status", -1);
      h.a("downloadReceiver action:" + str + " id:" + l, new Object[0]);
      if ("android.intent.action.DOWNLOAD_COMPLETE".equals(str))
      {
        paramContext = new com.lantern.core.d.a(paramContext);
        paramIntent = new a.b();
        paramIntent.a(new long[] { l });
        paramContext = paramContext.a(paramIntent);
        if ((paramContext != null) && (paramContext.moveToFirst()))
        {
          if (paramContext.getInt(paramContext.getColumnIndex("status")) == 8)
          {
            i = paramContext.getColumnIndex("local_uri");
            if (i != -1)
            {
              paramContext = paramContext.getString(i);
              if (TextUtils.isEmpty(paramContext)) {
                continue;
              }
              m.a().a(l, Uri.parse(paramContext));
              com.lantern.feed.channel.a.a.a().a(l, Uri.parse(paramContext));
              continue;
            }
          }
          m.a().a(l);
          com.lantern.feed.channel.a.a.a().a(l);
        }
      }
      else if ("android.intent.action.DOWNLOAD_REMOVE".equals(str))
      {
        m.a().c(l);
        com.lantern.feed.channel.a.a.a().c(l);
      }
      else if ((i == 190) || (i == 192))
      {
        m.a().b(l);
        com.lantern.feed.channel.a.a.a().b(l);
      }
      else if ((i != 200) && (i != -1))
      {
        m.a().a(l);
        com.lantern.feed.channel.a.a.a().a(l);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */