package ct;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONObject;

public final class cm
{
  public static int a = 0;
  private final co b;
  private final ck c;
  private final cl d;
  
  public cm(co paramco, ck paramck, cl paramcl)
  {
    this.b = paramco;
    this.c = paramck;
    this.d = paramcl;
  }
  
  private String b(int paramInt, String paramString, bi parambi)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject2 = null;
    Object localObject1;
    if (parambi == null)
    {
      localObject1 = localObject2;
      return (String)localObject1;
    }
    for (;;)
    {
      Object localObject4;
      try
      {
        if (this.c == null)
        {
          String str1 = b.a.a(this.b);
          String str2 = b.a.a(this.c, bool1);
          String str3 = b.a.a(this.d);
          localObject4 = parambi.h();
          localObject1 = localObject2;
          if (localObject4 == null) {
            break;
          }
          Object localObject3 = new java/util/HashMap;
          ((HashMap)localObject3).<init>();
          ((HashMap)localObject3).put("imei", ((bj)localObject4).a());
          ((HashMap)localObject3).put("imsi", ((bj)localObject4).b());
          ((HashMap)localObject3).put("phonenum", b.a.b(((bj)localObject4).e));
          ((HashMap)localObject3).put("qq", b.a.b(((bj)localObject4).g));
          ((HashMap)localObject3).put("mac", ((bj)localObject4).c().toLowerCase(Locale.ENGLISH));
          ((bj)localObject4).a.a();
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>((Map)localObject3);
          localObject3 = ((JSONObject)localObject1).toString();
          if (((bj)localObject4).n == null)
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>(100);
            ((StringBuilder)localObject1).append(((bj)localObject4).a()).append("_").append(((bj)localObject4).b()).append("_").append(((bj)localObject4).c()).append("_QQGeoLocation");
            ((bj)localObject4).n = b.a.d(((StringBuilder)localObject1).toString());
          }
          String str5 = ((bj)localObject4).n;
          df.a();
          int i = df.a(parambi.a);
          String str4 = dh.d(parambi);
          localObject1 = ((bj)localObject4).j;
          parambi = (bi)localObject1;
          if (localObject1 != null) {
            parambi = ((String)localObject1).replace("\"", "");
          }
          localObject1 = parambi;
          if (parambi != null) {
            localObject1 = parambi.replace("|", "");
          }
          parambi = new java/lang/StringBuilder;
          parambi.<init>();
          localObject1 = (String)localObject1 + "_" + ((bj)localObject4).i;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("{\"version\":\"");
          if (((bj)localObject4).q != null) {
            break label643;
          }
          parambi = "None";
          parambi = parambi + "\",\"address\":" + paramInt;
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          paramString = parambi + ",\"source\":203,\"access_token\":\"" + str5 + "\",\"app_name\":\"" + paramString + "\",\"app_label\":\"" + (String)localObject1 + "\",\"bearing\":1";
          parambi = new java/lang/StringBuilder;
          parambi.<init>();
          parambi = paramString + ",\"control\":2";
          paramString = new java/lang/StringBuilder;
          paramString.<init>();
          parambi = parambi + ",\"pstat\":" + i;
          paramString = new java/lang/StringBuilder;
          paramString.<init>();
          paramString = parambi + ",\"wlan\":" + str4;
          parambi = new java/lang/StringBuilder;
          parambi.<init>();
          localObject1 = paramString + ",\"attribute\":" + (String)localObject3 + ",\"location\":" + str3 + ",\"cells\":" + str2 + ",\"wifis\":" + str1 + "}";
          break;
        }
        if (a != this.c.e)
        {
          bool1 = bool2;
          a = this.c.e;
          continue;
        }
      }
      catch (Exception paramString)
      {
        localObject1 = localObject2;
      }
      bool1 = false;
      continue;
      label643:
      parambi = ((bj)localObject4).q;
    }
  }
  
  @Nullable
  public final cl a()
  {
    return this.d;
  }
  
  public final String a(int paramInt, String paramString, bi parambi)
  {
    return b(paramInt, paramString, parambi);
  }
  
  @Nullable
  public final ck b()
  {
    return this.c;
  }
  
  @Nullable
  public final co c()
  {
    return this.b;
  }
  
  public final boolean d()
  {
    if (this.d != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean e()
  {
    if (this.c != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean f()
  {
    if (this.b != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */