package com.lantern.wifilocating.push.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.lantern.wifilocating.push.PushNotificationActivity;
import com.lantern.wifilocating.push.util.b;
import com.lantern.wifilocating.push.util.l;

public final class a
{
  public static void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      int k;
      Object localObject1;
      Object localObject2;
      String str1;
      Object localObject3;
      int j;
      try
      {
        k = paramIntent.getIntExtra("intent_type", 0);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("target intent type:");
        com.lantern.wifilocating.push.util.h.b(k);
        localObject2 = paramIntent.getStringExtra("push_id");
        str1 = paramIntent.getStringExtra("push_sequence");
        localObject3 = paramIntent.getStringExtra("push_sequence_type");
        String str2 = paramIntent.getStringExtra("push_status");
        j = paramIntent.getIntExtra("push_syt", 0);
        int i = paramIntent.getIntExtra("push_dc_level", 0);
        String str3 = paramIntent.getStringExtra("push_content_misc");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.lantern.wifilocating.push.g.a.a.a().a((String)localObject1);
        if (!TextUtils.isEmpty(str3)) {
          h.b(str3);
        }
        localObject2 = new com/lantern/wifilocating/push/a/b/a;
        ((com.lantern.wifilocating.push.a.b.a)localObject2).<init>();
        ((com.lantern.wifilocating.push.a.b.a)localObject2).a((String)localObject3);
        ((com.lantern.wifilocating.push.a.b.a)localObject2).b(str1);
        ((com.lantern.wifilocating.push.a.b.a)localObject2).c((String)localObject1);
        ((com.lantern.wifilocating.push.a.b.a)localObject2).d(str2);
        ((com.lantern.wifilocating.push.a.b.a)localObject2).f(j);
        if (k == 6)
        {
          paramIntent = new java/lang/StringBuilder;
          paramIntent.<init>("clear notification : rid=");
          b.c((String)localObject1);
          ((com.lantern.wifilocating.push.a.b.a)localObject2).d(4);
          ((com.lantern.wifilocating.push.a.b.a)localObject2).e(3);
          com.lantern.wifilocating.push.f.a.a("012003", ((com.lantern.wifilocating.push.a.b.a)localObject2).a(), j, i);
          continue;
        }
      }
      finally {}
      ((com.lantern.wifilocating.push.a.b.a)localObject2).d(3);
      ((com.lantern.wifilocating.push.a.b.a)localObject2).e(1);
      com.lantern.wifilocating.push.f.a.a("012003", ((com.lantern.wifilocating.push.a.b.a)localObject2).a(), j, 2);
      if (paramIntent.hasExtra("target_intent"))
      {
        paramIntent = (Intent)paramIntent.getParcelableExtra("target_intent");
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("target Intent:");
        com.lantern.wifilocating.push.util.h.b(paramIntent);
        try
        {
          localObject1 = com.lantern.wifilocating.push.c.a();
          switch (k)
          {
          }
        }
        catch (Throwable paramIntent)
        {
          com.lantern.wifilocating.push.util.h.a(paramIntent);
        }
        if (a((Context)localObject1, PushNotificationActivity.class.getName()))
        {
          PushNotificationActivity.a((Context)localObject1, paramIntent);
        }
        else
        {
          paramIntent.addFlags(268435456);
          com.lantern.wifilocating.push.util.j.a((Context)localObject1, paramIntent, 0);
          continue;
          paramIntent.addFlags(268435456);
          com.lantern.wifilocating.push.util.j.a((Context)localObject1, paramIntent, 0);
          continue;
          com.lantern.wifilocating.push.util.j.a((Context)localObject1, paramIntent, 1);
          continue;
          com.lantern.wifilocating.push.util.j.a((Context)localObject1, paramIntent, 2);
          continue;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("start download---");
          com.lantern.wifilocating.push.util.h.b(paramIntent);
          if (paramIntent != null)
          {
            str1 = paramIntent.getStringExtra("down_url");
            localObject3 = paramIntent.getStringExtra("app_name");
            boolean bool = paramIntent.getBooleanExtra("need_tips", false);
            localObject1 = paramIntent.getStringExtra("dialog_title");
            paramIntent = paramIntent.getStringExtra("dialog_content");
            localObject2 = new com/lantern/wifilocating/push/i/i$a;
            ((i.a)localObject2).<init>(str1);
            if (bool)
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramIntent))) {}
              for (;;)
              {
                localObject3 = new com/lantern/wifilocating/push/i/c;
                ((c)localObject3).<init>(com.lantern.wifilocating.push.c.a());
                ((c)localObject3).a((String)localObject1);
                ((c)localObject3).b(paramIntent);
                paramIntent = new com/lantern/wifilocating/push/i/j;
                paramIntent.<init>((i.a)localObject2);
                ((c)localObject3).a(paramIntent);
                ((c)localObject3).b();
                ((c)localObject3).a();
                break;
                localObject1 = com.lantern.wifilocating.push.c.a().getString(l.b(com.lantern.wifilocating.push.c.a(), "push_dlg_title_download"));
                paramIntent = com.lantern.wifilocating.push.c.a().getString(l.b(com.lantern.wifilocating.push.c.a(), "push_dlg_conent_download"), new Object[] { localObject3 });
              }
            }
            ((i.a)localObject2).start();
          }
        }
      }
    }
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    bool1 = true;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 1).activities;
        int j = paramContext.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        boolean bool2 = paramContext[i].name.equals(paramString);
        if (!bool2) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        int i;
        com.lantern.wifilocating.push.util.h.a(paramContext);
        bool1 = false;
        continue;
      }
      return bool1;
      i++;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */