package com.lantern.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.bluefay.b.h;
import com.lantern.core.d.a.b;

final class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_download_id", 0L);
    h.a("EXTRA_DOWNLOAD_ID:" + l, new Object[0]);
    if (a.a(this.a) == l) {
      this.a.a();
    }
    for (;;)
    {
      return;
      if (a.b(this.a) == l)
      {
        paramContext = new a.b();
        paramContext.a(new long[] { l });
        paramContext = a.c(this.a).a(paramContext);
        int j = -1;
        int i = j;
        if (paramContext != null)
        {
          i = j;
          if (paramContext.moveToFirst()) {
            i = paramContext.getInt(paramContext.getColumnIndex("status"));
          }
        }
        if (paramContext != null) {
          paramContext.close();
        }
        if ((8 == i) && (a.d(this.a) != null))
        {
          com.lantern.analytics.a.e().onEvent("upd0f");
          a.d(this.a).a();
        }
        a.a(this.a, 0L);
      }
      else
      {
        h.c("not upgrade id EXTRA_DOWNLOAD_ID:" + l);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */