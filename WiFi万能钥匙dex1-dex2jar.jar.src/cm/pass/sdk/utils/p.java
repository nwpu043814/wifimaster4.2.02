package cm.pass.sdk.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.telephony.SmsManager;
import android.text.TextUtils;
import java.lang.reflect.Field;

public class p
{
  public static String a;
  private static p d;
  private static Context e;
  protected short b;
  private String c;
  
  public p(Context paramContext)
  {
    e = paramContext.getApplicationContext();
    a = m.a(paramContext).a();
    this.c = t.e(paramContext);
    this.b = 0;
  }
  
  public static p a(Context paramContext)
  {
    if (d == null) {
      d = new p(paramContext);
    }
    return d;
  }
  
  public void a()
  {
    if (this.c.equals("1065987711")) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(a)) && (!TextUtils.isEmpty(this.c))) {
        break;
      }
      j.a("Send Messages is Error：", "isEmpty");
    }
    if (("1065987711".equals(this.c)) && (!a.startsWith("op#cx"))) {
      a = "op#cx" + a;
    }
    Object localObject1 = s.a().a(e);
    int i = ((s.b)localObject1).i(((s.b)localObject1).f());
    if (Build.VERSION.SDK_INT > 21) {
      localObject1 = SmsManager.getSmsManagerForSubscriptionId(i);
    }
    for (;;)
    {
      Object localObject5 = new Intent("umc_sent_sms_action");
      localObject5 = PendingIntent.getBroadcast(e, 0, (Intent)localObject5, 0);
      Object localObject6 = new Intent("umc_delivered_sms_action");
      localObject6 = PendingIntent.getBroadcast(e, 0, (Intent)localObject6, 0);
      j.e("SmsUtils", "number =" + this.c + " ,content = " + a);
      try
      {
        ((SmsManager)localObject1).sendDataMessage(this.c, null, this.b, a.getBytes(), (PendingIntent)localObject5, (PendingIntent)localObject6);
        long l = System.currentTimeMillis();
        o.a().a(e, "KEY_SEND_SMS_TIME", l);
      }
      catch (Exception localException) {}
      break;
      localObject5 = SmsManager.getDefault();
      Object localObject2 = localObject5;
      if (i != -1) {
        try
        {
          localObject2 = localObject5.getClass().getDeclaredField("mSubId");
          ((Field)localObject2).setAccessible(true);
          ((Field)localObject2).set(localObject5, Integer.valueOf(i));
          localObject2 = localObject5;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          j.a("SmsUtils", "获取指定smsManager失败");
          localNoSuchFieldException.printStackTrace();
          Object localObject3 = localObject5;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          j.a("SmsUtils", "获取指定smsManager失败");
          localIllegalAccessException.printStackTrace();
          Object localObject4 = localObject5;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */