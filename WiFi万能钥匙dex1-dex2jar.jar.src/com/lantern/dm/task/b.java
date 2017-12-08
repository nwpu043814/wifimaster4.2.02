package com.lantern.dm.task;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.lantern.dm.R.id;
import com.lantern.dm.R.layout;
import com.lantern.dm.R.string;
import com.lantern.dm.ui.DownloadList;
import java.util.Collection;
import java.util.Iterator;

public final class b
{
  private Context a;
  private i b;
  private NotificationCompat.Builder c;
  private Collection<a> d;
  private a e;
  private int f = 0;
  
  public b(Context paramContext, i parami)
  {
    this.a = paramContext;
    this.b = parami;
    this.c = new NotificationCompat.Builder(this.a);
  }
  
  private void a(a parama)
  {
    Object localObject;
    long l2;
    long l1;
    int i;
    label93:
    int k;
    Context localContext;
    int j;
    int m;
    if (parama.C)
    {
      localObject = new Intent(this.a, DownloadList.class);
      ((Intent)localObject).setFlags(268435456);
      localObject = PendingIntent.getActivity(this.a, 0, (Intent)localObject, 0);
      this.c.setContentIntent((PendingIntent)localObject);
      localObject = new RemoteViews(this.a.getPackageName(), R.layout.dm_notification);
      l2 = parama.u;
      l1 = parama.t;
      if (l1 > 0L) {
        break label248;
      }
      i = 0;
      ((RemoteViews)localObject).setTextViewText(R.id.dm_title, parama.A);
      ((RemoteViews)localObject).setViewVisibility(R.id.dm_notfy, 0);
      ((RemoteViews)localObject).setProgressBar(R.id.dm_notfy, 100, i, false);
      k = R.id.dm_state;
      localContext = this.a;
      j = parama.j;
      m = parama.y;
      if (j != 190) {
        break label262;
      }
      parama = localContext.getString(R.string.download_waited_file) + "\t" + i + "%";
    }
    for (;;)
    {
      ((RemoteViews)localObject).setTextViewText(k, parama);
      this.c.setSmallIcon(17301633);
      this.c.setContent((RemoteViews)localObject);
      this.b.a(this.c.build());
      return;
      this.c.setContentIntent(null);
      break;
      label248:
      i = (int)(l2 * 100L / l1);
      break label93;
      label262:
      if (j == 192) {
        parama = i + "%";
      } else if (j == 193) {
        parama = localContext.getString(R.string.download_paused_file) + "\t" + i + "%";
      } else if (j == 195)
      {
        if (m == -1) {
          parama = localContext.getString(R.string.download_paused_file) + "\t" + i + "%";
        } else {
          parama = localContext.getString(R.string.download_waiting) + "\t" + i + "%";
        }
      }
      else if (j == 498) {
        parama = localContext.getString(R.string.download_failed_storage) + "\t" + i + "%";
      } else {
        parama = localContext.getString(R.string.download_failed) + "\t" + i + "%";
      }
    }
  }
  
  private static boolean b(a parama)
  {
    if ((100 <= parama.j) && (parama.j < 200) && (parama.h != 2) && (parama.j != 490)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean c(a parama)
  {
    if ((parama.j > 200) && (parama.h != 2) && (parama.j != 490)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void a(Collection<a> paramCollection)
  {
    this.d = paramCollection;
    if (paramCollection.size() == 1)
    {
      paramCollection = (a)paramCollection.iterator().next();
      this.e = paramCollection;
      if ((b(paramCollection)) || (c(paramCollection)))
      {
        this.f = 0;
        a(paramCollection);
      }
    }
    label153:
    label356:
    label357:
    for (;;)
    {
      return;
      if ((paramCollection.size() == 0) && (this.e != null))
      {
        if (((b(this.e)) || (c(this.e))) && (this.f < 2))
        {
          this.f += 1;
          a(this.e);
        }
      }
      else
      {
        Object localObject = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        paramCollection = null;
        Iterator localIterator = ((Collection)localObject).iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          localObject = (a)localIterator.next();
          if (((a)localObject).h == 2) {
            break label356;
          }
          localStringBuilder.append(((a)localObject).A);
          localStringBuilder.append("、");
          i++;
          paramCollection = (Collection<a>)localObject;
        }
        for (;;)
        {
          break label153;
          if (i == 0) {
            break label357;
          }
          if (i == 1)
          {
            a(paramCollection);
            break;
          }
          paramCollection = new RemoteViews(this.a.getPackageName(), R.layout.dm_notification);
          int j = localStringBuilder.length();
          localStringBuilder.replace(j - 1, j, "");
          localObject = this.a.getString(R.string.dm_downloading, new Object[] { Integer.valueOf(i) });
          paramCollection.setTextViewText(R.id.dm_title, (CharSequence)localObject);
          paramCollection.setViewVisibility(R.id.dm_notfy, 8);
          paramCollection.setTextViewText(R.id.dm_state, localStringBuilder.toString());
          this.c.setSmallIcon(17301633);
          this.c.setContent(paramCollection);
          this.b.a(this.c.build());
          break;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */