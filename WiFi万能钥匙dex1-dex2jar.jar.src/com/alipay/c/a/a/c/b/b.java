package com.alipay.c.a.a.c.b;

import android.content.Context;
import com.alipay.c.a.a.c.a.c;
import com.alipay.c.a.a.c.a.d;
import java.util.HashMap;
import java.util.Map;

public final class b
  implements a
{
  private static a a = null;
  private static com.alipay.c.a.a.c.a b = null;
  
  public static a a(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramContext == null)
    {
      paramContext = (Context)localObject1;
      return paramContext;
    }
    if (a == null) {
      if (paramContext != null) {
        break label45;
      }
    }
    label45:
    for (paramContext = (Context)localObject2;; paramContext = com.alipay.c.a.a.c.b.a(paramContext, paramString))
    {
      b = paramContext;
      a = new b();
      paramContext = a;
      break;
    }
  }
  
  public final c a(d paramd)
  {
    com.alipay.f.a.a.b.a.a.a locala = new com.alipay.f.a.a.b.a.a.a();
    locala.c = paramd.a();
    locala.b = "8";
    locala.a = "1";
    locala.d = new HashMap();
    locala.d.put("apdid", paramd.b());
    locala.d.put("apdidToken", paramd.c());
    locala.d.put("umidToken", paramd.d());
    locala.d.put("dynamicKey", paramd.f());
    locala.e = paramd.e();
    return com.alipay.c.a.a.c.a.b.a(b.a(locala));
  }
  
  public final boolean a(String paramString)
  {
    return b.a(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */