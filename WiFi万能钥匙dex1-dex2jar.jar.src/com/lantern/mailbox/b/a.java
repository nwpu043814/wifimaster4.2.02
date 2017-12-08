package com.lantern.mailbox.b;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.lantern.core.c;
import com.lantern.core.g.k;
import com.lantern.core.g.k.b;
import com.lantern.mailbox.MailboxActivity;
import com.lantern.mailbox.R.drawable;
import com.lantern.mailbox.R.string;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static a a;
  private static final int[] b = { 20161001, 20161002, 20161003 };
  private int c = 0;
  private String[] d = { "", "", "" };
  
  private a()
  {
    b();
  }
  
  public static a a()
  {
    try
    {
      if (a == null)
      {
        locala = new com/lantern/mailbox/b/a;
        locala.<init>();
        a = locala;
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  private static void b()
  {
    NotificationManager localNotificationManager = (NotificationManager)c.getAppContext().getSystemService("notification");
    int[] arrayOfInt = b;
    int j = arrayOfInt.length;
    for (int i = 0; i < j; i++) {
      localNotificationManager.cancel(arrayOfInt[i]);
    }
  }
  
  public final void a(List<com.lantern.mailbox.d.a> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Collections.sort(paramList, new b(this));
      Context localContext = c.getAppContext();
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        com.lantern.mailbox.d.a locala = (com.lantern.mailbox.d.a)localIterator.next();
        Object localObject = locala.j();
        this.c %= 3;
        paramList = (NotificationManager)c.getAppContext().getSystemService("notification");
        int i = (this.c + 1) % 3;
        if (this.d[i].equals(localObject))
        {
          paramList.cancel(b[i]);
          i = b[i];
        }
        for (;;)
        {
          localObject = new NotificationCompat.Builder(localContext);
          paramList = locala.r();
          if (locala.d() > 3) {
            paramList = String.format(localContext.getString(R.string.mailbox_names), new Object[] { locala.r(), Integer.valueOf(locala.d()) });
          }
          ((NotificationCompat.Builder)localObject).setContentTitle(paramList);
          ((NotificationCompat.Builder)localObject).setContentText(locala.b() + locala.k() + locala.c());
          ((NotificationCompat.Builder)localObject).setSmallIcon(R.drawable.mailbox_push_default_icon);
          ((NotificationCompat.Builder)localObject).setDefaults(1);
          ((NotificationCompat.Builder)localObject).setAutoCancel(true);
          paramList = new Intent(localContext, MailboxActivity.class);
          paramList.putExtra("source", "notify");
          paramList.putExtra("url", locala.q());
          paramList.putExtra("lid", locala.j());
          paramList.putExtra("type", locala.o());
          paramList.setFlags(268435456);
          ((NotificationCompat.Builder)localObject).setContentIntent(PendingIntent.getActivity(localContext, 0, paramList, 134217728));
          ((NotificationManager)localContext.getSystemService("notification")).notify(i, ((NotificationCompat.Builder)localObject).build());
          break;
          i = (this.c + 2) % 3;
          if (this.d[i].equals(localObject))
          {
            paramList.cancel(b[i]);
            i = b[i];
          }
          else
          {
            this.d[this.c] = localObject;
            paramList.cancel(b[this.c]);
            paramList = b;
            i = this.c;
            this.c = (i + 1);
            i = paramList[i];
          }
        }
      }
      k.a().a(k.b.e);
      com.lantern.analytics.a.e().onEvent("MNotif");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */