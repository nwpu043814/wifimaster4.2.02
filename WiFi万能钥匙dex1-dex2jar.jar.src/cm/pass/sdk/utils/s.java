package cm.pass.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class s
{
  private static s a;
  private b b = null;
  
  private SubscriptionInfo a(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    return (SubscriptionInfo)a(paramObject, paramString, paramArrayOfObject, null);
  }
  
  private SubscriptionInfo a(List<SubscriptionInfo> paramList, int paramInt)
  {
    SubscriptionInfo localSubscriptionInfo = (SubscriptionInfo)paramList.get(0);
    Iterator localIterator = paramList.iterator();
    paramList = localSubscriptionInfo;
    if (localIterator.hasNext())
    {
      localSubscriptionInfo = (SubscriptionInfo)localIterator.next();
      if (localSubscriptionInfo.getSimSlotIndex() != paramInt) {
        break label57;
      }
      paramList = localSubscriptionInfo;
    }
    label57:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  public static s a()
  {
    if (a == null) {
      a = new s();
    }
    return a;
  }
  
  /* Error */
  private Object a(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 62	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 68	java/lang/Class:getName	()Ljava/lang/String;
    //   7: invokestatic 72	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore 5
    //   12: aload_3
    //   13: ifnull +24 -> 37
    //   16: aload 4
    //   18: ifnull +19 -> 37
    //   21: aload 5
    //   23: aload_2
    //   24: aload 4
    //   26: invokevirtual 76	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   29: aload_1
    //   30: aload_3
    //   31: invokevirtual 82	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   34: astore_1
    //   35: aload_1
    //   36: areturn
    //   37: aload 5
    //   39: aload_2
    //   40: iconst_0
    //   41: anewarray 64	java/lang/Class
    //   44: invokevirtual 76	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   47: aload_1
    //   48: iconst_0
    //   49: anewarray 4	java/lang/Object
    //   52: invokevirtual 82	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore_1
    //   56: goto -21 -> 35
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   64: new 6	cm/pass/sdk/utils/s$a
    //   67: dup
    //   68: aload_2
    //   69: invokespecial 88	cm/pass/sdk/utils/s$a:<init>	(Ljava/lang/String;)V
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	s
    //   0	73	1	paramObject	Object
    //   0	73	2	paramString	String
    //   0	73	3	paramArrayOfObject	Object[]
    //   0	73	4	paramArrayOfClass	Class[]
    //   10	28	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   0	12	59	java/lang/Exception
    //   21	35	59	java/lang/Exception
    //   37	56	59	java/lang/Exception
  }
  
  private String a(TelephonyManager paramTelephonyManager, String paramString, int paramInt)
  {
    Object localObject = null;
    Class localClass = Integer.TYPE;
    paramString = a(paramTelephonyManager, paramString, new Object[] { Integer.valueOf(paramInt) }, new Class[] { localClass });
    paramTelephonyManager = (TelephonyManager)localObject;
    if (paramString != null) {
      paramTelephonyManager = paramString.toString();
    }
    return paramTelephonyManager;
  }
  
  private void a(List<SubscriptionInfo> paramList, TelephonyManager paramTelephonyManager)
  {
    boolean bool = true;
    int i;
    if (paramList != null) {
      i = paramList.size();
    }
    for (;;)
    {
      if (i == 1)
      {
        paramList = (SubscriptionInfo)paramList.get(0);
        label30:
        this.b.b(paramList.getSimSlotIndex());
        this.b.d(paramList.getSubscriptionId());
      }
      try
      {
        this.b.a(a(paramTelephonyManager, "getDeviceId", paramList.getSimSlotIndex()));
      }
      catch (a locala5)
      {
        try
        {
          b.a(this.b, b(paramTelephonyManager, "getSimState", paramList.getSimSlotIndex()));
          if (c.b() == 0) {
            i = paramList.getSimSlotIndex();
          }
        }
        catch (a locala5)
        {
          try
          {
            this.b.c(a(paramTelephonyManager, "getSubscriberId", paramList.getSubscriptionId()));
          }
          catch (a locala5)
          {
            try
            {
              for (;;)
              {
                this.b.e(a(paramTelephonyManager, "getSimOperator", paramList.getSubscriptionId()));
                do
                {
                  return;
                  i = 0;
                  break;
                } while (i <= 1);
                paramList = a(paramList, 0);
                break label30;
                locala1 = locala1;
                try
                {
                  this.b.a(a(paramTelephonyManager, "getDeviceIdGemini", paramList.getSimSlotIndex()));
                }
                catch (a locala2)
                {
                  this.b.a(paramTelephonyManager.getDeviceId());
                }
                continue;
                locala3 = locala3;
                b localb;
                try
                {
                  b.a(this.b, b(paramTelephonyManager, "getSimStateGemini", paramList.getSimSlotIndex()));
                }
                catch (a locala4)
                {
                  localb = this.b;
                  if (paramTelephonyManager.getSimState() != 5) {}
                }
                for (;;)
                {
                  localb.a(bool);
                  break;
                  bool = false;
                }
                i = paramList.getSubscriptionId();
                continue;
                locala5 = locala5;
                try
                {
                  this.b.c(a(paramTelephonyManager, "getSubscriberIdGemini", i));
                }
                catch (a locala6)
                {
                  this.b.c(paramTelephonyManager.getSubscriberId());
                }
              }
            }
            catch (a paramList)
            {
              for (;;)
              {
                try
                {
                  this.b.e(a(paramTelephonyManager, "getSimOperatorGemini", i));
                }
                catch (a paramList)
                {
                  this.b.e(paramTelephonyManager.getSimOperator());
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void b(List<SubscriptionInfo> paramList, TelephonyManager paramTelephonyManager)
  {
    int j = 1;
    int i;
    if (paramList != null) {
      i = paramList.size();
    }
    for (;;)
    {
      if (i > 1) {}
      try
      {
        this.b.b(a(paramTelephonyManager, "getDeviceId", 1));
      }
      catch (a locala5)
      {
        try
        {
          b.b(this.b, b(paramTelephonyManager, "getSimState", 1));
          paramList = a(paramList, 1);
          this.b.c(paramList.getSimSlotIndex());
          this.b.e(paramList.getSubscriptionId());
          if (c.b() == 0) {
            i = j;
          }
        }
        catch (a locala5)
        {
          try
          {
            this.b.d(a(paramTelephonyManager, "getSubscriberId", paramList.getSubscriptionId()));
          }
          catch (a locala5)
          {
            try
            {
              for (;;)
              {
                this.b.f(a(paramTelephonyManager, "getSimOperator", paramList.getSubscriptionId()));
                return;
                i = 0;
                break;
                locala1 = locala1;
                try
                {
                  this.b.b(a(paramTelephonyManager, "getDeviceIdGemini", 1));
                }
                catch (a locala2) {}
                continue;
                locala3 = locala3;
                try
                {
                  b.b(this.b, b(paramTelephonyManager, "getSimStateGemini", 1));
                }
                catch (a locala4) {}
                continue;
                i = paramList.getSubscriptionId();
                continue;
                locala5 = locala5;
                try
                {
                  this.b.d(a(paramTelephonyManager, "getSubscriberIdGemini", i));
                }
                catch (a locala6) {}
              }
            }
            catch (a paramList)
            {
              for (;;)
              {
                try
                {
                  this.b.f(a(paramTelephonyManager, "getSimOperatorGemini", i));
                }
                catch (a paramList) {}
              }
            }
          }
        }
      }
    }
  }
  
  private boolean b(TelephonyManager paramTelephonyManager, String paramString, int paramInt)
  {
    boolean bool = true;
    Class localClass = Integer.TYPE;
    paramTelephonyManager = a(paramTelephonyManager, paramString, new Object[] { Integer.valueOf(paramInt) }, new Class[] { localClass });
    if ((paramTelephonyManager != null) && (Integer.parseInt(paramTelephonyManager.toString()) == 5)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void c(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      paramContext = SubscriptionManager.from(paramContext.getApplicationContext());
      if (paramContext == null) {}
    }
    for (;;)
    {
      try
      {
        paramContext = a(paramContext, "getDefaultDataSubscriptionInfo", null);
        if (paramContext != null) {
          b.a(this.b, paramContext.getSimSlotIndex());
        }
        return;
      }
      catch (a paramContext)
      {
        continue;
      }
      b.a(this.b, -1);
    }
  }
  
  private void d(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        if ((paramContext.getType() != 1) || (paramContext.getState() != NetworkInfo.State.CONNECTED)) {
          break label54;
        }
        b.b(this.b, 1);
      }
    }
    for (;;)
    {
      return;
      label54:
      if ((paramContext.getType() == 0) && (paramContext.getState() == NetworkInfo.State.CONNECTED)) {
        b.b(this.b, 0);
      } else {
        b.b(this.b, -1);
      }
    }
  }
  
  private void e(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    if (localTelephonyManager == null) {}
    for (;;)
    {
      return;
      paramContext = g(paramContext);
      a(paramContext, localTelephonyManager);
      b(paramContext, localTelephonyManager);
    }
  }
  
  private void f(Context paramContext)
  {
    boolean bool1 = true;
    paramContext = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    this.b.b(0);
    this.b.c(1);
    this.b.a(-1);
    try
    {
      str1 = a(paramContext, "getDeviceId", 0);
      this.b.a(str1);
      str1 = a(paramContext, "getDeviceId", 1);
      this.b.b(str1);
    }
    catch (a locala5)
    {
      try
      {
        str1 = a(paramContext, "getSubscriberId", 0);
        this.b.c(str1);
        str1 = a(paramContext, "getSubscriberId", 1);
        this.b.d(str1);
      }
      catch (a locala5)
      {
        try
        {
          bool2 = b(paramContext, "getSimState", 0);
          this.b.a(bool2);
          bool2 = b(paramContext, "getSimState", 1);
          this.b.b(bool2);
        }
        catch (a locala5)
        {
          try
          {
            for (;;)
            {
              boolean bool2;
              String str1 = a(paramContext, "getSimOperator", 0);
              this.b.e(str1);
              str1 = a(paramContext, "getSimOperator", 1);
              this.b.f(str1);
              if ((TextUtils.isEmpty(this.b.b())) && (!TextUtils.isEmpty(this.b.c())))
              {
                this.b.a(this.b.a());
                this.b.b("");
                this.b.c(this.b.c());
                this.b.d("");
                this.b.b(this.b.h());
                this.b.c(-1);
                this.b.a(this.b.e());
                this.b.b(false);
                this.b.e(this.b.d());
                this.b.f("");
                this.b.a(this.b.g());
                return;
                locala1 = locala1;
                try
                {
                  String str2 = a(paramContext, "getDeviceIdGemini", 0);
                  this.b.a(str2);
                  str2 = a(paramContext, "getDeviceIdGemini", 1);
                  this.b.b(str2);
                }
                catch (a locala2)
                {
                  String str3 = paramContext.getDeviceId();
                  this.b.a(str3);
                }
                continue;
                locala3 = locala3;
                try
                {
                  String str4 = a(paramContext, "getSubscriberIdGemini", 0);
                  this.b.c(str4);
                  str4 = a(paramContext, "getSubscriberIdGemini", 1);
                  this.b.d(str4);
                }
                catch (a locala4)
                {
                  String str5 = paramContext.getSubscriberId();
                  this.b.c(str5);
                }
                continue;
                locala5 = locala5;
                try
                {
                  bool2 = b(paramContext, "getSimStateGemini", 0);
                  this.b.a(bool2);
                  bool2 = b(paramContext, "getSimStateGemini", 1);
                  this.b.b(bool2);
                }
                catch (a locala6)
                {
                  if (paramContext.getSimState() == 5) {}
                  for (;;)
                  {
                    this.b.a(bool1);
                    break;
                    bool1 = false;
                  }
                }
              }
            }
          }
          catch (a locala7)
          {
            for (;;)
            {
              try
              {
                String str6 = a(paramContext, "getSimOperatorGemini", 0);
                this.b.e(str6);
                str6 = a(paramContext, "getSimOperatorGemini", 1);
                this.b.f(str6);
              }
              catch (a locala8)
              {
                paramContext = paramContext.getSimOperator();
                this.b.e(paramContext);
              }
              continue;
              if ((!TextUtils.isEmpty(this.b.b())) && (TextUtils.isEmpty(this.b.c())))
              {
                this.b.b("");
                this.b.b(false);
                this.b.c(-1);
                this.b.a(this.b.g());
              }
              else if ((TextUtils.isEmpty(this.b.b())) && (TextUtils.isEmpty(this.b.c())))
              {
                this.b.a("");
                this.b.b("");
                this.b.b(-1);
                this.b.c(-1);
                this.b.a(false);
                this.b.b(false);
                this.b.a(-1);
              }
            }
          }
        }
      }
    }
  }
  
  private List<SubscriptionInfo> g(Context paramContext)
  {
    SubscriptionManager localSubscriptionManager = SubscriptionManager.from(paramContext.getApplicationContext());
    paramContext = null;
    if (localSubscriptionManager != null) {
      paramContext = localSubscriptionManager.getActiveSubscriptionInfoList();
    }
    return paramContext;
  }
  
  public b a(Context paramContext)
  {
    if (this.b == null) {
      b(paramContext);
    }
    return this.b;
  }
  
  public s b(Context paramContext)
  {
    this.b = new b();
    if (Build.VERSION.SDK_INT >= 22) {
      e(paramContext);
    }
    for (;;)
    {
      c(paramContext);
      d(paramContext);
      return this;
      f(paramContext);
    }
  }
  
  public static class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  public static class b
  {
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private boolean e = false;
    private boolean f = false;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private String k = "";
    private String l = "";
    private int m = -1;
    private int n = -1;
    
    public String a()
    {
      return this.b;
    }
    
    protected void a(int paramInt)
    {
      this.m = paramInt;
    }
    
    protected void a(String paramString)
    {
      if (paramString != null) {
        this.a = paramString;
      }
    }
    
    protected void a(boolean paramBoolean)
    {
      this.e = paramBoolean;
    }
    
    public String b()
    {
      return this.c;
    }
    
    protected void b(int paramInt)
    {
      this.g = paramInt;
    }
    
    protected void b(String paramString)
    {
      if (paramString != null) {
        this.b = paramString;
      }
    }
    
    protected void b(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }
    
    public String c()
    {
      return this.d;
    }
    
    protected void c(int paramInt)
    {
      this.h = paramInt;
    }
    
    protected void c(String paramString)
    {
      if (paramString != null) {
        this.c = paramString;
      }
    }
    
    public String d()
    {
      return this.l;
    }
    
    protected void d(int paramInt)
    {
      this.i = paramInt;
    }
    
    protected void d(String paramString)
    {
      if (paramString != null) {
        this.d = paramString;
      }
    }
    
    protected void e(int paramInt)
    {
      this.j = paramInt;
    }
    
    protected void e(String paramString)
    {
      if (paramString != null) {
        this.k = paramString;
      }
    }
    
    public boolean e()
    {
      return this.f;
    }
    
    public int f()
    {
      return this.m;
    }
    
    public String f(int paramInt)
    {
      String str;
      if (this.g == paramInt) {
        str = this.c;
      }
      for (;;)
      {
        return str;
        if (this.h == paramInt) {
          str = this.d;
        } else {
          str = "";
        }
      }
    }
    
    protected void f(String paramString)
    {
      this.l = paramString;
    }
    
    public int g()
    {
      return this.g;
    }
    
    public String g(int paramInt)
    {
      String str;
      if (this.g == paramInt) {
        str = this.a;
      }
      for (;;)
      {
        return str;
        if (this.h == paramInt) {
          str = this.b;
        } else {
          str = "";
        }
      }
    }
    
    public int h()
    {
      return this.h;
    }
    
    public String h(int paramInt)
    {
      String str;
      if (this.g == paramInt) {
        str = this.k;
      }
      for (;;)
      {
        return str;
        if (this.h == paramInt) {
          str = this.l;
        } else {
          str = "";
        }
      }
    }
    
    public int i(int paramInt)
    {
      if (this.g == paramInt) {
        paramInt = this.i;
      }
      for (;;)
      {
        return paramInt;
        if (this.h == paramInt) {
          paramInt = this.j;
        } else {
          paramInt = -1;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */