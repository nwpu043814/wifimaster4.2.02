package com.lantern.wifilocating.push;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.lantern.wifilocating.push.f.e;
import com.lantern.wifilocating.push.service.PushService;
import java.util.ArrayList;

public final class c
{
  private static Context a;
  private static Object b = new Object();
  private static boolean c;
  
  public static Context a()
  {
    if (a == null) {
      a = PushService.a();
    }
    return a;
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 23	com/lantern/wifilocating/push/c:a	Landroid/content/Context;
    //   3: ifnull +10 -> 13
    //   6: getstatic 23	com/lantern/wifilocating/push/c:a	Landroid/content/Context;
    //   9: aload_0
    //   10: if_acmpeq +39 -> 49
    //   13: aload_0
    //   14: invokevirtual 35	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: astore_3
    //   18: aload_3
    //   19: putstatic 23	com/lantern/wifilocating/push/c:a	Landroid/content/Context;
    //   22: getstatic 19	com/lantern/wifilocating/push/c:b	Ljava/lang/Object;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: getstatic 37	com/lantern/wifilocating/push/c:c	Z
    //   31: iconst_1
    //   32: if_icmpeq +15 -> 47
    //   35: aload_3
    //   36: ifnull +11 -> 47
    //   39: getstatic 43	android/os/Build$VERSION:SDK_INT	I
    //   42: bipush 14
    //   44: if_icmpge +6 -> 50
    //   47: aload_2
    //   48: monitorexit
    //   49: return
    //   50: aload_3
    //   51: instanceof 45
    //   54: ifne +21 -> 75
    //   57: aload_2
    //   58: monitorexit
    //   59: goto -10 -> 49
    //   62: astore_0
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    //   67: astore_0
    //   68: aload_0
    //   69: invokestatic 50	com/lantern/wifilocating/push/util/h:a	(Ljava/lang/Throwable;)V
    //   72: goto -23 -> 49
    //   75: invokestatic 56	android/os/Process:myPid	()I
    //   78: istore_1
    //   79: aload_3
    //   80: ldc 58
    //   82: invokevirtual 62	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   85: checkcast 64	android/app/ActivityManager
    //   88: invokevirtual 68	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   91: invokeinterface 74 1 0
    //   96: astore 4
    //   98: aload 4
    //   100: invokeinterface 80 1 0
    //   105: ifeq +52 -> 157
    //   108: aload 4
    //   110: invokeinterface 84 1 0
    //   115: checkcast 86	android/app/ActivityManager$RunningAppProcessInfo
    //   118: astore_0
    //   119: aload_0
    //   120: getfield 89	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   123: iload_1
    //   124: if_icmpne -26 -> 98
    //   127: aload_0
    //   128: getfield 93	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   131: astore_0
    //   132: aload_3
    //   133: invokestatic 99	com/lantern/wifilocating/push/util/j:j	(Landroid/content/Context;)Ljava/lang/String;
    //   136: astore 4
    //   138: aload 4
    //   140: ifnull +12 -> 152
    //   143: aload 4
    //   145: aload_0
    //   146: invokevirtual 105	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifne +13 -> 162
    //   152: aload_2
    //   153: monitorexit
    //   154: goto -105 -> 49
    //   157: aconst_null
    //   158: astore_0
    //   159: goto -27 -> 132
    //   162: aload_3
    //   163: checkcast 45	android/app/Application
    //   166: astore_3
    //   167: new 6	com/lantern/wifilocating/push/c$a
    //   170: astore_0
    //   171: aload_0
    //   172: iconst_0
    //   173: invokespecial 108	com/lantern/wifilocating/push/c$a:<init>	(B)V
    //   176: aload_3
    //   177: aload_0
    //   178: invokevirtual 112	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   181: iconst_1
    //   182: putstatic 37	com/lantern/wifilocating/push/c:c	Z
    //   185: aload_2
    //   186: monitorexit
    //   187: goto -138 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramContext	Context
    //   78	47	1	i	int
    //   17	160	3	localObject2	Object
    //   96	48	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	35	62	finally
    //   39	47	62	finally
    //   47	49	62	finally
    //   50	59	62	finally
    //   63	65	62	finally
    //   75	98	62	finally
    //   98	132	62	finally
    //   132	138	62	finally
    //   143	152	62	finally
    //   152	154	62	finally
    //   162	187	62	finally
    //   22	28	67	java/lang/Throwable
    //   65	67	67	java/lang/Throwable
  }
  
  private static final class a
    implements Application.ActivityLifecycleCallbacks
  {
    ArrayList<String> a = new ArrayList();
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity) {}
    
    public final void onActivityResumed(Activity paramActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      if (this.a.size() == 0) {
        e.a().b(c.b());
      }
      this.a.add(String.valueOf(paramActivity));
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      this.a.remove(String.valueOf(paramActivity));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */