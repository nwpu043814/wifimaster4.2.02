package com.lantern.browser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class o
  extends BroadcastReceiver
{
  o(n paramn) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getAction();
      Object localObject1;
      Object localObject2;
      if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
      {
        paramContext = paramIntent.getData().getSchemeSpecificPart();
        paramIntent = this.a.e(paramContext);
        if (paramIntent.size() > 0)
        {
          Iterator localIterator = paramIntent.iterator();
          if (localIterator.hasNext())
          {
            paramIntent = (j)localIterator.next();
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("url", paramIntent.a());
            ((HashMap)localObject1).put("pkg", paramIntent.c());
            localObject2 = new JSONObject((Map)localObject1).toString();
            ((HashMap)localObject1).clear();
            ((HashMap)localObject1).put("ext", localObject2);
            ((HashMap)localObject1).put("cts", String.valueOf(System.currentTimeMillis()));
            if (paramIntent.d())
            {
              ((HashMap)localObject1).put("funId", "brosldins");
              a.e().a("005012", new JSONArray().put(new JSONObject((Map)localObject1)));
            }
            for (;;)
            {
              paramIntent.a("INSTALLED");
              n.a(paramIntent);
              break;
              ((HashMap)localObject1).put("funId", "brostdins");
              a.e().a("005012", new JSONArray().put(new JSONObject((Map)localObject1)));
            }
          }
        }
        paramIntent = l.a().b(paramContext);
        if (paramIntent != null)
        {
          h.a("ACTION_PACKAGE_ADDED getFileName:" + paramIntent.c(), new Object[0]);
          paramIntent.f("INSTALLED");
          l.a().c(paramContext, "INSTALLED");
          n.a(paramIntent);
          a.e().onEvent("binssuc", paramIntent.a());
          paramContext = paramIntent.i();
          if (!TextUtils.isEmpty(paramContext)) {
            new Thread(new p(this, paramContext)).start();
          }
        }
      }
      else if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
      {
        paramIntent = paramIntent.getData().getSchemeSpecificPart();
        paramContext = this.a.e(paramIntent);
        if (paramContext.size() > 0)
        {
          localObject1 = paramContext.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramContext = (j)((Iterator)localObject1).next();
            paramContext.a("NOT_DOWNLOAD");
            n.a(paramContext);
          }
        }
        localObject1 = l.a().b(paramIntent);
        if (localObject1 != null)
        {
          h.a("ACTION_PACKAGE_REMOVED getFileName:" + ((k)localObject1).c(), new Object[0]);
          if (!TextUtils.isEmpty(((k)localObject1).c()))
          {
            localObject2 = new File(n.a(this.a), ((k)localObject1).c());
            paramContext = "DOWNLOADED";
            if (!((File)localObject2).exists()) {
              paramContext = "NOT_DOWNLOAD";
            }
            ((k)localObject1).f(paramContext);
            l.a().c(paramIntent, paramContext);
            n.a((k)localObject1);
          }
          else if (!((k)localObject1).f().equals("NOT_DOWNLOAD"))
          {
            ((k)localObject1).f("NOT_DOWNLOAD");
            l.a().c(paramIntent, "NOT_DOWNLOAD");
            n.a((k)localObject1);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */