package cm.pass.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import cm.pass.sdk.broadcastreceiver.SmsSendReceiver;

public class d
{
  private static SmsSendReceiver a;
  private a.a.a.c.b b = null;
  
  private void a(a.a.a.c.b paramb)
  {
    b(paramb);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt, String paramString11, cm.pass.sdk.interfaces.c paramc)
  {
    this.b = new cm.pass.sdk.net.g(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramInt, paramString11, new cm.pass.sdk.net.a.f(paramc));
    a(this.b);
  }
  
  private void b(a.a.a.c.b paramb)
  {
    new Thread(new d.1(this, new cm.pass.sdk.net.i(paramb))).start();
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (a != null)
      {
        paramContext.unregisterReceiver(a);
        a = null;
      }
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public void a(a.a.a.c.c paramc, cm.pass.sdk.b.a parama)
  {
    this.b = new cm.pass.sdk.net.j(paramc, parama);
    a(this.b);
  }
  
  public void a(Context paramContext)
  {
    String str2 = m.a(paramContext).a();
    j.a("TelephoneUtil", "doFreeLogin IMSI: " + str2);
    if ("".equals(str2)) {}
    for (;;)
    {
      return;
      String str1 = o.a().b(paramContext, "KEY_IMSI" + str2);
      long l = o.a().d(paramContext, "KEY_IMSI_TIME" + str2);
      if ((!"".equals(str1)) && (System.currentTimeMillis() - l < 600000L))
      {
        j.d("", "Sent SMS Successful");
      }
      else if (!l.a(paramContext).b("android.permission.SEND_SMS"))
      {
        j.a("", "no permission SEND_SMS");
      }
      else
      {
        b(paramContext);
        a = new SmsSendReceiver(paramContext);
        paramContext.registerReceiver(a, new IntentFilter("umc_sent_sms_action"));
        p.a(paramContext).a();
      }
    }
  }
  
  public void a(Context paramContext, String paramString, cm.pass.sdk.interfaces.i parami)
  {
    j.c("BusinessUtils", "doGetLoginConfigInfo==");
    this.b = new cm.pass.sdk.net.c(paramContext, paramString, "", new cm.pass.sdk.net.a.d(parami));
    a(this.b);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, cm.pass.sdk.interfaces.g paramg)
  {
    this.b = new cm.pass.sdk.net.h(paramContext, paramString1, paramString2, paramString3, new cm.pass.sdk.net.a.g(paramg));
    a(this.b);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, cm.pass.sdk.interfaces.b paramb)
  {
    String str3 = l.a(paramContext).c();
    String str1 = l.a(paramContext).f();
    String str2 = m.a(paramContext).b();
    paramContext = m.a(paramContext).a();
    this.b = new cm.pass.sdk.net.l(new cm.pass.sdk.net.a.k(paramb), paramString1, paramString2, paramString4, paramString3, str3, str1, paramInt, str2, paramContext);
    a(this.b);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, cm.pass.sdk.interfaces.c paramc)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, "", "", l.a(paramContext).c(), l.a(paramContext).f(), paramInt, m.a(paramContext).b(), paramc);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, cm.pass.sdk.interfaces.f paramf)
  {
    this.b = new cm.pass.sdk.net.d(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, new cm.pass.sdk.net.a.e(new d.2(this, paramf)));
    a(this.b);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, cm.pass.sdk.interfaces.e parame)
  {
    String str3 = m.a(paramContext).a();
    String str1 = q.a(paramContext);
    String str2 = t.a();
    paramString4 = t.a(paramString4, str2);
    String str4 = System.currentTimeMillis();
    t.b(paramContext, str2);
    t.a(paramContext, str4);
    this.b = new cm.pass.sdk.net.b(paramContext, new cm.pass.sdk.net.a.c(paramContext, paramString7, parame), paramString1, paramString2, paramString3, paramString4, str4, paramString5, str1, str3, paramString6);
    a(this.b);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, cm.pass.sdk.interfaces.d paramd)
  {
    this.b = new cm.pass.sdk.net.f(new cm.pass.sdk.net.a.b(paramd), paramString1, paramString2, paramString3, paramString6, paramString7, paramString4, paramString5, "http://dev.10086.cn", paramString9, paramString8, paramString10, paramString11);
    a(this.b);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, cm.pass.sdk.interfaces.h paramh)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString4))) {
      paramh.a(false, "102", "account/imsi参数异常", "", "", false);
    }
    for (;;)
    {
      return;
      this.b = new cm.pass.sdk.net.k(paramString1, "http://dev.10086.cn", paramString2, paramString3, paramString4, new cm.pass.sdk.net.a.j(paramh));
      a(this.b);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9, cm.pass.sdk.interfaces.a parama)
  {
    this.b = new cm.pass.sdk.net.e(paramString1, paramString2, "http://dev.10086.cn", paramString3, paramString4, paramString8, paramString9, paramInt, paramString6, paramString7, paramString5, new cm.pass.sdk.net.a.a(parama));
    a(this.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */