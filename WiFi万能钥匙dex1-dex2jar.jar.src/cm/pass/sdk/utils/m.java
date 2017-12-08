package cm.pass.sdk.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.Toast;

public class m
{
  private static final String a = m.class.getSimpleName();
  private static m c;
  private Context b;
  
  private m(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static final m a(Context paramContext)
  {
    if (c == null) {
      c = new m(paramContext);
    }
    return c;
  }
  
  public String a()
  {
    try
    {
      Object localObject1 = s.a().a(this.b);
      localObject2 = ((s.b)localObject1).f(((s.b)localObject1).f());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = ((TelephonyManager)this.b.getSystemService("phone")).getSubscriberId();
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).startsWith("460")) {}
      }
      else
      {
        localObject2 = "";
      }
      j.a(a, (String)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Toast.makeText(this.b, "没有读取用户电话状态权限，请到设置里开启", 0).show();
        Object localObject2 = "";
      }
    }
    return (String)localObject2;
  }
  
  public String b()
  {
    try
    {
      Object localObject1 = s.a().a(this.b);
      localObject2 = ((s.b)localObject1).g(((s.b)localObject1).f());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = ((TelephonyManager)this.b.getSystemService("phone")).getDeviceId();
      }
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("imei is ");
      j.a("UMC_SDK", (String)localObject1);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = "";
      }
    }
    return (String)localObject2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */