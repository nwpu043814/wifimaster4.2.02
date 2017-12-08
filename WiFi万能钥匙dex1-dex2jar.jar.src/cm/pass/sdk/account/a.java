package cm.pass.sdk.account;

import android.content.Context;
import android.text.TextUtils;
import cm.pass.sdk.a.a.a;
import cm.pass.sdk.a.c;
import cm.pass.sdk.utils.h;
import cm.pass.sdk.utils.j;
import cm.pass.sdk.utils.m;
import cm.pass.sdk.utils.n;
import cm.pass.sdk.utils.q;
import cm.pass.sdk.utils.t;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static Context a;
  private static a b = null;
  private c c;
  
  private a(Context paramContext)
  {
    a = paramContext.getApplicationContext();
    this.c = c.a();
    this.c.a(a);
  }
  
  public static a a(Context paramContext)
  {
    if (b == null) {
      b = new a(paramContext);
    }
    return b;
  }
  
  private String c(String paramString)
  {
    if (("3".equals(paramString)) || ("4".equals(paramString))) {}
    for (paramString = "0";; paramString = "1") {
      return paramString;
    }
  }
  
  private String d()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.c.a("FILE_UMCSDK_ACCOUNT", 4);
        str1 = ((cm.pass.sdk.a.a)localObject1).a("KEY_UMCSDK_ACCOUNT", "");
        String str2;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          str2 = ((cm.pass.sdk.a.a)localObject1).a("KEY_UMCSDK_TIMESTAMP", "");
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("CycleAccount : ");
          j.e("SsoAccountTools", str1 + "\ttimestamp :" + str2);
          localObject1 = str1;
          if (!TextUtils.isEmpty(str1)) {
            localObject1 = cm.pass.sdk.utils.a.b(str1, "ader147526ekc235");
          }
          return (String)localObject1;
        }
        catch (Exception localException2)
        {
          String str1;
          Object localObject2;
          for (;;) {}
        }
        localException1 = localException1;
        str1 = "";
      }
      localObject2 = str1;
    }
  }
  
  public b.a.a.a a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    j.a("SsoAccountTools", "addAccount account is " + paramString1);
    for (;;)
    {
      try
      {
        String str = h.b("12345678", paramString3);
        paramString3 = new b/a/a/a;
        paramString3.<init>();
        try
        {
          paramString3.b(paramString2);
          paramString3.i(paramString7);
          paramString3.d(paramString4);
          paramString3.h(q.a(a));
          paramString3.g(m.a(a).a());
          paramString3.c(str);
          paramString3.a(paramString1);
          paramString3.e(paramString5);
          paramString3.f(paramString6);
          paramString3.a(System.currentTimeMillis());
          if (TextUtils.isEmpty(paramString3.f()))
          {
            paramString1 = paramString3;
            return paramString1;
          }
          paramString4 = a();
          paramString2 = paramString4.iterator();
          if (!paramString2.hasNext()) {
            continue;
          }
          paramString5 = (b.a.a.a)paramString2.next();
          if (!paramString5.a().equals(paramString3.a())) {
            continue;
          }
          paramString1 = new java/lang/StringBuilder;
          paramString1.<init>("Remove User : ");
          j.e("SsoAccountTools", paramString5.b());
          paramString2.remove();
          continue;
          paramString2.printStackTrace();
        }
        catch (Exception paramString2)
        {
          paramString1 = paramString3;
        }
      }
      catch (Exception paramString2)
      {
        long l;
        paramString1 = null;
        continue;
      }
      continue;
      if (c(paramString3.h()).equals(c(paramString5.h())))
      {
        paramString2.remove();
        continue;
        paramString4.add(paramString3);
        paramString1 = n.a(paramString4);
        l = System.currentTimeMillis();
        a(cm.pass.sdk.utils.a.a(paramString1, "ader147526ekc235"), String.valueOf(l));
        paramString1 = paramString3;
      }
    }
  }
  
  public UserInfo a(b.a.a.a parama)
  {
    Object localObject2 = null;
    Object localObject1;
    if (parama == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (UserInfo)localObject1;
      try
      {
        String str1 = h.a("12345678", parama.c());
        localObject1 = localObject2;
        if (str1 != null)
        {
          localObject1 = new cm/pass/sdk/account/UserInfo;
          ((UserInfo)localObject1).<init>();
          String str2 = t.a();
          Object localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          localObject3 = System.currentTimeMillis();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>(parama.e());
          str1 = t.b(str1, str2 + (String)localObject3);
          ((UserInfo)localObject1).setUserName(cm.pass.sdk.utils.a.b(parama.a(), "0d97c416116e"));
          ((UserInfo)localObject1).setAuthToken(str1);
          ((UserInfo)localObject1).setImei(parama.g());
          ((UserInfo)localObject1).setImsi(parama.f());
          ((UserInfo)localObject1).setMachineCode(parama.g());
          ((UserInfo)localObject1).setPassid(parama.e());
          ((UserInfo)localObject1).setTimeStamp((String)localObject3);
          ((UserInfo)localObject1).setTokenNonce(str2);
          ((UserInfo)localObject1).setAuthType(parama.h());
        }
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
        localObject1 = localObject2;
      }
    }
  }
  
  /* Error */
  public List<b.a.a.a> a()
  {
    // Byte code:
    //   0: ldc 83
    //   2: ldc_w 266
    //   5: invokestatic 118	cm/pass/sdk/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: new 268	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 269	java/util/ArrayList:<init>	()V
    //   15: astore 4
    //   17: aload_0
    //   18: invokespecial 271	cm/pass/sdk/account/a:d	()Ljava/lang/String;
    //   21: astore 5
    //   23: getstatic 27	cm/pass/sdk/account/a:a	Landroid/content/Context;
    //   26: invokestatic 146	cm/pass/sdk/utils/m:a	(Landroid/content/Context;)Lcm/pass/sdk/utils/m;
    //   29: invokevirtual 148	cm/pass/sdk/utils/m:a	()Ljava/lang/String;
    //   32: astore 6
    //   34: aload 5
    //   36: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifeq +6 -> 45
    //   42: aload 4
    //   44: areturn
    //   45: aload 5
    //   47: invokestatic 274	cm/pass/sdk/utils/n:a	(Ljava/lang/String;)Ljava/util/List;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +190 -> 244
    //   57: aload 5
    //   59: checkcast 176	java/util/List
    //   62: astore 5
    //   64: aload 5
    //   66: astore 4
    //   68: new 76	java/lang/StringBuilder
    //   71: astore 5
    //   73: aload 5
    //   75: ldc_w 276
    //   78: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: ldc 83
    //   83: aload 5
    //   85: aload 4
    //   87: invokeinterface 280 1 0
    //   92: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 98	cm/pass/sdk/utils/j:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 4
    //   103: invokeinterface 180 1 0
    //   108: astore 7
    //   110: iconst_0
    //   111: istore_1
    //   112: aload 7
    //   114: invokeinterface 186 1 0
    //   119: ifeq +70 -> 189
    //   122: aload 7
    //   124: invokeinterface 190 1 0
    //   129: checkcast 125	b/a/a/a
    //   132: astore 8
    //   134: new 76	java/lang/StringBuilder
    //   137: astore 5
    //   139: aload 5
    //   141: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   144: aload_0
    //   145: aload 5
    //   147: aload 8
    //   149: invokevirtual 285	b/a/a/a:d	()J
    //   152: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   155: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 288	cm/pass/sdk/account/a:b	(Ljava/lang/String;)Z
    //   161: ifne +16 -> 177
    //   164: aload 6
    //   166: aload 8
    //   168: invokevirtual 171	b/a/a/a:f	()Ljava/lang/String;
    //   171: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifne +67 -> 241
    //   177: aload 7
    //   179: invokeinterface 198 1 0
    //   184: iconst_1
    //   185: istore_1
    //   186: goto -74 -> 112
    //   189: iload_1
    //   190: ifeq +29 -> 219
    //   193: aload 4
    //   195: invokestatic 210	cm/pass/sdk/utils/n:a	(Ljava/util/List;)Ljava/lang/String;
    //   198: astore 5
    //   200: invokestatic 166	java/lang/System:currentTimeMillis	()J
    //   203: lstore_2
    //   204: aload_0
    //   205: aload 5
    //   207: ldc 106
    //   209: invokestatic 211	cm/pass/sdk/utils/a:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   212: lload_2
    //   213: invokestatic 215	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   216: invokevirtual 216	cm/pass/sdk/account/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: goto -177 -> 42
    //   222: astore 5
    //   224: aload 5
    //   226: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   229: aload_0
    //   230: invokevirtual 290	cm/pass/sdk/account/a:b	()V
    //   233: goto -191 -> 42
    //   236: astore 5
    //   238: goto -14 -> 224
    //   241: goto -55 -> 186
    //   244: goto -176 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	a
    //   111	79	1	i	int
    //   203	10	2	l	long
    //   15	179	4	localObject1	Object
    //   21	185	5	localObject2	Object
    //   222	3	5	localException1	Exception
    //   236	1	5	localException2	Exception
    //   32	133	6	str	String
    //   108	70	7	localIterator	Iterator
    //   132	35	8	locala	b.a.a.a
    // Exception table:
    //   from	to	target	type
    //   45	52	222	java/lang/Exception
    //   57	64	222	java/lang/Exception
    //   68	110	236	java/lang/Exception
    //   112	177	236	java/lang/Exception
    //   177	184	236	java/lang/Exception
    //   193	219	236	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    j.e("SsoAccountTools", "removeAccountByName() : [ account : " + paramString + "]");
    try
    {
      List localList = a();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        String str = ((b.a.a.a)localIterator.next()).a();
        if ((str.equals(paramString)) || (str.equals(cm.pass.sdk.utils.a.a(paramString, "0d97c416116e")))) {
          localIterator.remove();
        }
      }
      paramString = n.a(localList);
      long l = System.currentTimeMillis();
      a(cm.pass.sdk.utils.a.a(paramString, "ader147526ekc235"), String.valueOf(l));
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a.a locala = this.c.a("FILE_UMCSDK_ACCOUNT", 4).a();
    locala.a("KEY_UMCSDK_ACCOUNT", paramString1);
    locala.a("KEY_UMCSDK_TIMESTAMP", paramString2);
    locala.a();
    j.e("SsoAccountTools", "putAccount() account = " + paramString1 + ", timestamp = " + paramString2);
  }
  
  public void b()
  {
    String str = System.currentTimeMillis();
    j.a("SsoAccountTools", "clearAllAccount timeStamp = " + str);
    a("", str);
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      long l = (System.currentTimeMillis() - Long.parseLong(paramString)) / 24L / 60L / 60L / 1000L;
      j.e("SsoAccountTools", "ExpireTime : " + (89L - l));
      bool1 = bool2;
      if (l >= 0L)
      {
        bool1 = bool2;
        if (l < 89L) {
          bool1 = false;
        }
      }
    }
  }
  
  public b.a.a.a c()
  {
    Iterator localIterator = a().iterator();
    b.a.a.a locala2;
    do
    {
      if (!localIterator.hasNext()) {
        break label68;
      }
      locala2 = (b.a.a.a)localIterator.next();
      j.a("SsoAccountTools", locala2.toString());
      locala1 = locala2;
      if ("3".equals(locala2.h())) {
        break;
      }
    } while (!"4".equals(locala2.h()));
    for (b.a.a.a locala1 = locala2;; locala1 = null)
    {
      return locala1;
      label68:
      j.a("SsoAccountTools", "ssoAccountList is null");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/account/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */