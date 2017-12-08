package cm.pass.sdk.utils;

import android.content.Context;
import android.widget.Toast;

public class q
{
  public static String a(Context paramContext)
  {
    o localo = o.a();
    Object localObject1 = localo.a(paramContext, "UMC_DEVICEID");
    Object localObject2 = localObject1;
    if ("".equals(localObject1)) {}
    try
    {
      localObject2 = r.a(paramContext);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Toast.makeText(paramContext, "没有读取用户电话状态权限，请到设置里开启", 0).show();
      }
    }
    localo.a(paramContext, "UMC_DEVICEID", (String)localObject1);
    localObject2 = localObject1;
    return (String)localObject2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */