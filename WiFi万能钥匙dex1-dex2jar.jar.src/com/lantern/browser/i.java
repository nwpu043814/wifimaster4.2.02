package com.lantern.browser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.bluefay.b.h;
import com.lantern.core.d.a;
import com.lantern.core.d.a.b;

public final class i
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    long l;
    if ("android.intent.action.DOWNLOAD_COMPLETE".equals(paramIntent.getAction()))
    {
      l = paramIntent.getLongExtra("extra_download_id", 0L);
      if (bp.c(l)) {
        break label30;
      }
    }
    for (;;)
    {
      return;
      label30:
      bp.b(l);
      paramIntent = new a(paramContext);
      Object localObject = new a.b();
      ((a.b)localObject).a(new long[] { l });
      paramIntent = paramIntent.a((a.b)localObject);
      int i;
      if ((paramIntent != null) && (paramIntent.moveToFirst()))
      {
        i = paramIntent.getColumnIndex("_data");
        if (i == -1) {}
      }
      try
      {
        localObject = Uri.parse(paramIntent.getString(i));
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        localIntent.setDataAndType((Uri)localObject, "application/vnd.android.package-archive");
        paramContext.startActivity(localIntent);
        if (paramIntent == null) {
          continue;
        }
        paramIntent.close();
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          h.a(paramContext);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */