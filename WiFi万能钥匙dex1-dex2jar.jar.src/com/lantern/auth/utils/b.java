package com.lantern.auth.utils;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.telephony.SmsManager;
import com.bluefay.b.h;
import com.lantern.auth.g;

public final class b
{
  private Context a;
  private com.bluefay.b.a b;
  private int c = 0;
  private String d = "";
  private String e = "";
  private BroadcastReceiver f = new c(this);
  private Handler g = new Handler(new d(this));
  
  public b(Context paramContext, com.bluefay.b.a parama)
  {
    this.a = paramContext;
    this.b = parama;
    paramContext = new IntentFilter();
    paramContext.addAction("SENT_SMS_ACTION");
    this.a.registerReceiver(this.f, paramContext);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramInt != 1) {
      com.lantern.analytics.a.e().onEvent("LoginOn", g.a(this.d, "5", "2", this.e));
    }
    if (this.b != null) {
      this.b.a(paramInt, paramString, null);
    }
  }
  
  public final void a()
  {
    try
    {
      this.a.unregisterReceiver(this.f);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.d = paramString3;
    this.e = paramString4;
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      h.a("send phone or content is null", new Object[0]);
      this.c = 3;
      a(0, "send sms content is null");
    }
    for (;;)
    {
      return;
      paramString3 = SmsManager.getDefault();
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.a, 0, new Intent("SENT_SMS_ACTION"), 0);
      try
      {
        Thread localThread = new java/lang/Thread;
        paramString4 = new com/lantern/auth/utils/e;
        paramString4.<init>(this, paramString3, paramString1, paramString2, localPendingIntent);
        localThread.<init>(paramString4);
        localThread.start();
      }
      catch (Exception paramString1)
      {
        h.a(paramString1);
        this.c = 3;
        a(0, "send sms failed");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */