package cm.pass.sdk.b;

import android.content.Context;
import android.os.Handler;
import cm.pass.sdk.utils.d;
import cm.pass.sdk.utils.m;
import cm.pass.sdk.utils.o;
import cm.pass.sdk.utils.r;
import cm.pass.sdk.utils.t;

public class b
{
  private static Handler a = new Handler();
  
  public static void a() {}
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    if (("102101".equals(paramString10)) || ("102102".equals(paramString10)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      String str = System.currentTimeMillis();
      a.postDelayed(new b.1(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, str, paramString7, paramString8, paramString9, paramString10, paramString11), 6000L);
    }
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    a locala = new a();
    locala.a(m.a(paramContext).a());
    locala.b(m.a(paramContext).b());
    locala.c(paramString1);
    locala.d(paramString2);
    locala.e(paramString3);
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    locala.f(paramString1);
    locala.g(r.b(paramContext));
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    locala.h(paramString1);
    paramString1 = paramString6;
    if (paramString6 == null) {
      paramString1 = "";
    }
    locala.i(paramString1);
    paramString1 = paramString7;
    if (paramString7 == null) {
      paramString1 = "";
    }
    locala.j(paramString1);
    paramString1 = paramString8;
    if (paramString8 == null) {
      paramString1 = "";
    }
    locala.k(paramString1);
    paramString1 = paramString9;
    if (paramString9 == null) {
      paramString1 = "";
    }
    locala.l(paramString1);
    paramString1 = paramString10;
    if (paramString10 == null) {
      paramString1 = "";
    }
    locala.m(paramString1);
    locala.n(paramString11);
    locala.o(paramString12);
    paramString1 = t.d(paramContext);
    if ("212".equals(paramString12)) {
      if ("0".equals(paramString1))
      {
        paramString1 = "没有收到移动短信网关用户短信上行记录";
        o.a().a(paramContext);
      }
    }
    for (;;)
    {
      "".equals(paramString1);
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      locala.p(paramString2);
      locala.q(r.d(paramContext));
      new d().a(null, locala);
      return;
      paramString1 = "短信发送失败";
      break;
      paramString1 = paramString13;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */