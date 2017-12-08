package bluefay.preference;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.List;

public final class r
{
  private Activity a;
  private PreferenceFragment b;
  private Context c;
  private long d = 0L;
  private int e;
  private SharedPreferences f;
  private SharedPreferences.Editor g;
  private boolean h;
  private String i;
  private int j;
  private PreferenceScreen k;
  private List<b> l;
  private List<c> m;
  private List<a> n;
  private List<DialogInterface> o;
  private d p;
  
  public r(Activity paramActivity)
  {
    this.a = paramActivity;
    this.e = 100;
    this.c = paramActivity;
    a(paramActivity.getPackageName() + "_preferences");
  }
  
  private void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.g != null)) {}
    try
    {
      this.g.apply();
      this.h = paramBoolean;
      return;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      for (;;)
      {
        this.g.commit();
      }
    }
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 97	bluefay/preference/r:o	Ljava/util/List;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: new 99	java/util/ArrayList
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 97	bluefay/preference/r:o	Ljava/util/List;
    //   21: invokespecial 102	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   24: aload_0
    //   25: getfield 97	bluefay/preference/r:o	Ljava/util/List;
    //   28: invokeinterface 107 1 0
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: invokevirtual 111	java/util/ArrayList:size	()I
    //   39: iconst_1
    //   40: isub
    //   41: istore_1
    //   42: iload_1
    //   43: iflt -32 -> 11
    //   46: aload_2
    //   47: iload_1
    //   48: invokevirtual 115	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   51: checkcast 117	android/content/DialogInterface
    //   54: invokeinterface 120 1 0
    //   59: iinc 1 -1
    //   62: goto -20 -> 42
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	r
    //   41	19	1	i1	int
    //   15	32	2	localArrayList	ArrayList
    //   65	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	65	finally
    //   12	35	65	finally
    //   66	68	65	finally
  }
  
  public final Preference a(CharSequence paramCharSequence)
  {
    if (this.k == null) {}
    for (paramCharSequence = null;; paramCharSequence = this.k.c(paramCharSequence)) {
      return paramCharSequence;
    }
  }
  
  final PreferenceFragment a()
  {
    return this.b;
  }
  
  public final PreferenceScreen a(Context paramContext, int paramInt, PreferenceScreen paramPreferenceScreen)
  {
    a(true);
    paramContext = (PreferenceScreen)new q(paramContext, this).a(paramInt, paramPreferenceScreen);
    paramContext.a(this);
    a(false);
    return paramContext;
  }
  
  /* Error */
  final void a(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 147	bluefay/preference/r:l	Ljava/util/List;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: new 99	java/util/ArrayList
    //   15: astore 5
    //   17: aload 5
    //   19: aload_0
    //   20: getfield 147	bluefay/preference/r:l	Ljava/util/List;
    //   23: invokespecial 102	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload 5
    //   30: invokeinterface 148 1 0
    //   35: istore 4
    //   37: iconst_0
    //   38: istore_3
    //   39: iload_3
    //   40: iload 4
    //   42: if_icmpge -31 -> 11
    //   45: aload 5
    //   47: iload_3
    //   48: invokeinterface 149 2 0
    //   53: checkcast 9	bluefay/preference/r$b
    //   56: iload_1
    //   57: aload_2
    //   58: invokeinterface 152 3 0
    //   63: ifne -52 -> 11
    //   66: iinc 3 1
    //   69: goto -30 -> 39
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	r
    //   0	77	1	paramInt	int
    //   0	77	2	paramIntent	Intent
    //   38	29	3	i1	int
    //   35	8	4	i2	int
    //   15	31	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	11	72	finally
    //   12	28	72	finally
    //   73	75	72	finally
  }
  
  final void a(DialogInterface paramDialogInterface)
  {
    try
    {
      if (this.o == null)
      {
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        this.o = localArrayList;
      }
      this.o.add(paramDialogInterface);
      return;
    }
    finally {}
  }
  
  final void a(PreferenceFragment paramPreferenceFragment)
  {
    this.b = paramPreferenceFragment;
  }
  
  final void a(a parama)
  {
    try
    {
      if (this.n == null)
      {
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        this.n = localArrayList;
      }
      if (!this.n.contains(parama)) {
        this.n.add(parama);
      }
      return;
    }
    finally {}
  }
  
  final void a(b paramb)
  {
    try
    {
      if (this.l == null)
      {
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        this.l = localArrayList;
      }
      if (!this.l.contains(paramb)) {
        this.l.add(paramb);
      }
      return;
    }
    finally {}
  }
  
  final void a(c paramc)
  {
    try
    {
      if (this.m == null)
      {
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        this.m = localArrayList;
      }
      if (!this.m.contains(paramc)) {
        this.m.add(paramc);
      }
      return;
    }
    finally {}
  }
  
  final void a(d paramd)
  {
    this.p = paramd;
  }
  
  public final void a(String paramString)
  {
    this.i = paramString;
    this.f = null;
  }
  
  final boolean a(PreferenceScreen paramPreferenceScreen)
  {
    if (paramPreferenceScreen != this.k) {
      this.k = paramPreferenceScreen;
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  final long b()
  {
    try
    {
      long l1 = this.d;
      this.d = (1L + l1);
      return l1;
    }
    finally {}
  }
  
  /* Error */
  final void b(DialogInterface paramDialogInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 97	bluefay/preference/r:o	Ljava/util/List;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: getfield 97	bluefay/preference/r:o	Ljava/util/List;
    //   16: aload_1
    //   17: invokeinterface 181 2 0
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: goto -14 -> 11
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	r
    //   0	33	1	paramDialogInterface	DialogInterface
    // Exception table:
    //   from	to	target	type
    //   2	11	28	finally
    //   12	25	28	finally
    //   29	31	28	finally
  }
  
  final void b(a parama)
  {
    try
    {
      if (this.n != null) {
        this.n.remove(parama);
      }
      return;
    }
    finally {}
  }
  
  final void b(c paramc)
  {
    try
    {
      if (this.m != null) {
        this.m.remove(paramc);
      }
      return;
    }
    finally {}
  }
  
  public final SharedPreferences c()
  {
    if (this.f == null) {
      this.f = this.c.getSharedPreferences(this.i, this.j);
    }
    return this.f;
  }
  
  final PreferenceScreen d()
  {
    return this.k;
  }
  
  final SharedPreferences.Editor e()
  {
    if (this.h) {
      if (this.g == null) {
        this.g = c().edit();
      }
    }
    for (SharedPreferences.Editor localEditor = this.g;; localEditor = c().edit()) {
      return localEditor;
    }
  }
  
  final boolean f()
  {
    if (!this.h) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  final Activity g()
  {
    return this.a;
  }
  
  /* Error */
  final void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 169	bluefay/preference/r:m	Ljava/util/List;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: new 99	java/util/ArrayList
    //   15: astore_3
    //   16: aload_3
    //   17: aload_0
    //   18: getfield 169	bluefay/preference/r:m	Ljava/util/List;
    //   21: invokespecial 102	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: invokeinterface 148 1 0
    //   32: istore_2
    //   33: iconst_0
    //   34: istore_1
    //   35: iload_1
    //   36: iload_2
    //   37: if_icmpge -26 -> 11
    //   40: aload_3
    //   41: iload_1
    //   42: invokeinterface 149 2 0
    //   47: checkcast 12	bluefay/preference/r$c
    //   50: invokeinterface 201 1 0
    //   55: iinc 1 1
    //   58: goto -23 -> 35
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	r
    //   34	22	1	i1	int
    //   32	6	2	i2	int
    //   15	26	3	localArrayList	ArrayList
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	61	finally
    //   12	26	61	finally
    //   62	64	61	finally
  }
  
  final void i()
  {
    for (;;)
    {
      try
      {
        if (this.n == null) {
          break label72;
        }
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>(this.n);
        if (localArrayList != null)
        {
          int i2 = localArrayList.size();
          int i1 = 0;
          if (i1 < i2)
          {
            ((a)localArrayList.get(i1)).g();
            i1++;
            continue;
          }
        }
        l();
      }
      finally {}
      return;
      label72:
      Object localObject2 = null;
    }
  }
  
  final int j()
  {
    try
    {
      int i1 = this.e;
      this.e = (i1 + 1);
      return i1;
    }
    finally {}
  }
  
  final d k()
  {
    return this.p;
  }
  
  public static abstract interface a
  {
    public abstract void g();
  }
  
  public static abstract interface b
  {
    public abstract boolean a(int paramInt, Intent paramIntent);
  }
  
  public static abstract interface c
  {
    public abstract void a_();
  }
  
  static abstract interface d
  {
    public abstract boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */