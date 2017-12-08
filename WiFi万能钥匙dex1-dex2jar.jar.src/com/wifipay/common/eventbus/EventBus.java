package com.wifipay.common.eventbus;

import android.os.Looper;
import com.wifipay.common.logging.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class EventBus
{
  public static String TAG = "EventBus";
  static volatile EventBus a;
  private static final f b = new f();
  private static final Map c = new HashMap();
  private final Map d = new HashMap();
  private final Map e = new HashMap();
  private final Map f = new ConcurrentHashMap();
  private final ThreadLocal g = new c(this);
  private final h h = new h(this, Looper.getMainLooper(), 10);
  private final b i = new b(this);
  private final a j = new a(this);
  private final n k;
  private final ExecutorService l;
  private final boolean m;
  private final boolean n;
  private final boolean o;
  private final boolean p;
  private final boolean q;
  private final boolean r;
  private final int s;
  private Map t;
  
  public EventBus()
  {
    this(b);
  }
  
  EventBus(f paramf)
  {
    if (paramf.j != null) {}
    for (int i1 = paramf.j.size();; i1 = 0)
    {
      this.s = i1;
      this.k = new n(paramf.j, paramf.h, paramf.g);
      this.n = paramf.a;
      this.o = paramf.b;
      this.p = paramf.c;
      this.q = paramf.d;
      this.m = paramf.e;
      this.r = paramf.f;
      this.l = paramf.i;
      return;
    }
  }
  
  private static List a(Class paramClass)
  {
    synchronized (c)
    {
      Object localObject2 = (List)c.get(paramClass);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new java/util/ArrayList;
        ((ArrayList)localObject2).<init>();
        for (localObject1 = paramClass; localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass())
        {
          ((List)localObject2).add(localObject1);
          a((List)localObject2, ((Class)localObject1).getInterfaces());
        }
        c.put(paramClass, localObject2);
        localObject1 = localObject2;
      }
      return (List)localObject1;
    }
  }
  
  private void a(p paramp, Object paramObject, Throwable paramThrowable)
  {
    if ((paramObject instanceof l)) {
      if (this.n)
      {
        Logger.e("SubscriberExceptionEvent subscriber %s %s", new Object[] { paramp.a.getClass() + " threw an exception", paramThrowable });
        paramp = (l)paramObject;
        Logger.e("Initial event %s " + paramp.c + " caused exception in " + paramp.d, new Object[] { paramp.b });
      }
    }
    for (;;)
    {
      return;
      if (this.m) {
        throw new g("Invoking subscriber failed", paramThrowable);
      }
      if (this.n) {
        Logger.e("Could not dispatch event: %s %s", new Object[] { paramObject.getClass() + " to subscribing class " + paramp.a.getClass(), paramThrowable });
      }
      if (this.p) {
        post(new l(this, paramThrowable, paramObject, paramp.a));
      }
    }
  }
  
  private void a(p paramp, Object paramObject, boolean paramBoolean)
  {
    if ((this.t != null) && (this.t.containsKey(paramObject))) {
      this.t.remove(paramObject);
    }
    for (;;)
    {
      return;
      switch (d.a[paramp.b.b.ordinal()])
      {
      default: 
        throw new IllegalStateException("Unknown thread mode: " + paramp.b.b);
      case 1: 
        a(paramp, paramObject);
        break;
      case 2: 
        if (paramBoolean) {
          a(paramp, paramObject);
        } else {
          this.h.a(paramp, paramObject);
        }
        break;
      case 3: 
        if (paramBoolean) {
          this.i.a(paramp, paramObject);
        } else {
          a(paramp, paramObject);
        }
        break;
      case 4: 
        this.j.a(paramp, paramObject);
      }
    }
  }
  
  private void a(Object paramObject, e parame)
  {
    Class localClass = paramObject.getClass();
    boolean bool;
    if (this.r)
    {
      List localList = a(localClass);
      int i1 = localList.size() - 1;
      bool = false;
      while (i1 >= 0)
      {
        bool |= a(paramObject, parame, (Class)localList.get(i1));
        i1--;
      }
    }
    for (;;)
    {
      if (!bool)
      {
        if (this.o) {
          Logger.d("No subscribers registered for event %s" + localClass, new Object[0]);
        }
        if ((this.q) && (localClass != i.class) && (localClass != l.class)) {
          post(new i(this, paramObject));
        }
      }
      return;
      bool = a(paramObject, parame, localClass);
    }
  }
  
  private void a(Object paramObject, m paramm)
  {
    Class localClass = paramm.c;
    p localp = new p(paramObject, paramm);
    Object localObject = (CopyOnWriteArrayList)this.d.get(localClass);
    if (localObject == null)
    {
      localObject = new CopyOnWriteArrayList();
      this.d.put(localClass, localObject);
    }
    label320:
    label321:
    for (;;)
    {
      int i2 = ((CopyOnWriteArrayList)localObject).size();
      for (int i1 = 0;; i1++) {
        if (i1 <= i2)
        {
          if ((i1 == i2) || (paramm.d > ((p)((CopyOnWriteArrayList)localObject).get(i1)).b.d)) {
            ((CopyOnWriteArrayList)localObject).add(i1, localp);
          }
        }
        else
        {
          List localList = (List)this.e.get(paramObject);
          localObject = localList;
          if (localList == null)
          {
            localObject = new ArrayList();
            this.e.put(paramObject, localObject);
          }
          ((List)localObject).add(localClass);
          if (!paramm.e) {
            break label320;
          }
          if (!this.r) {
            break;
          }
          paramm = this.f.entrySet().iterator();
          while (paramm.hasNext())
          {
            paramObject = (Map.Entry)paramm.next();
            if (localClass.isAssignableFrom((Class)((Map.Entry)paramObject).getKey())) {
              b(localp, ((Map.Entry)paramObject).getValue());
            }
          }
          if (!((CopyOnWriteArrayList)localObject).contains(localp)) {
            break label321;
          }
          throw new g("Subscriber " + paramObject.getClass() + " already registered to event " + localClass);
        }
      }
      b(localp, this.f.get(localClass));
      return;
    }
  }
  
  private void a(Object paramObject, Class paramClass)
  {
    paramClass = (List)this.d.get(paramClass);
    int i2;
    if (paramClass != null)
    {
      int i1 = paramClass.size();
      i2 = 0;
      if (i2 < i1)
      {
        p localp = (p)paramClass.get(i2);
        if (localp.a != paramObject) {
          break label84;
        }
        localp.c = false;
        paramClass.remove(i2);
        i2--;
        i1--;
      }
    }
    label84:
    for (;;)
    {
      i2++;
      break;
      return;
    }
  }
  
  static void a(List paramList, Class[] paramArrayOfClass)
  {
    int i2 = paramArrayOfClass.length;
    for (int i1 = 0; i1 < i2; i1++)
    {
      Class localClass = paramArrayOfClass[i1];
      if (!paramList.contains(localClass))
      {
        paramList.add(localClass);
        a(paramList, localClass.getInterfaces());
      }
    }
  }
  
  private boolean a(Object paramObject, e parame, Class paramClass)
  {
    try
    {
      paramClass = (CopyOnWriteArrayList)this.d.get(paramClass);
      if ((paramClass == null) || (paramClass.isEmpty())) {
        break label131;
      }
      paramClass = paramClass.iterator();
    }
    finally
    {
      try
      {
        do
        {
          p localp;
          a(localp, paramObject, parame.c);
          bool = parame.f;
          parame.e = null;
          parame.d = null;
          parame.f = false;
        } while (!bool);
        bool = true;
        return bool;
      }
      finally
      {
        parame.e = null;
        parame.d = null;
        parame.f = false;
      }
      paramObject = finally;
    }
    if (paramClass.hasNext())
    {
      localp = (p)paramClass.next();
      parame.e = paramObject;
      parame.d = localp;
    }
    for (;;)
    {
      label131:
      boolean bool = false;
    }
  }
  
  private void b(p paramp, Object paramObject)
  {
    if (paramObject != null) {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label23;
      }
    }
    label23:
    for (boolean bool = true;; bool = false)
    {
      a(paramp, paramObject, bool);
      return;
    }
  }
  
  public static f builder()
  {
    return new f();
  }
  
  public static void clearCaches()
  {
    n.a();
    c.clear();
  }
  
  public static EventBus getDefault()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        EventBus localEventBus = new com/wifipay/common/eventbus/EventBus;
        localEventBus.<init>();
        a = localEventBus;
      }
      return a;
    }
    finally {}
  }
  
  ExecutorService a()
  {
    return this.l;
  }
  
  void a(j paramj)
  {
    Object localObject = paramj.a;
    p localp = paramj.b;
    j.a(paramj);
    if (localp.c) {
      a(localp, localObject);
    }
  }
  
  void a(p paramp, Object paramObject)
  {
    try
    {
      paramp.b.a.invoke(paramp.a, new Object[] { paramObject });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        a(paramp, paramObject, localInvocationTargetException.getCause());
      }
    }
    catch (IllegalAccessException paramp)
    {
      throw new IllegalStateException("Unexpected exception", paramp);
    }
  }
  
  public void cancelEventDelivery(Object paramObject)
  {
    e locale = (e)this.g.get();
    if (!locale.b) {
      throw new g("This method may only be called from inside event handling methods on the posting thread");
    }
    if (paramObject == null) {
      throw new g("Event may not be null");
    }
    if (locale.e != paramObject) {
      throw new g("Only the currently handled event may be aborted");
    }
    if (locale.d.b.b != ThreadMode.POSTING) {
      throw new g(" event handlers may only abort the incoming event");
    }
    locale.f = true;
  }
  
  public Object getStickyEvent(Class paramClass)
  {
    synchronized (this.f)
    {
      paramClass = paramClass.cast(this.f.get(paramClass));
      return paramClass;
    }
  }
  
  public boolean hasSubscriberForEvent(Class paramClass)
  {
    paramClass = a(paramClass);
    int i1;
    Object localObject;
    if (paramClass != null)
    {
      int i2 = paramClass.size();
      i1 = 0;
      if (i1 < i2) {
        localObject = (Class)paramClass.get(i1);
      }
    }
    for (;;)
    {
      try
      {
        localObject = (CopyOnWriteArrayList)this.d.get(localObject);
        if ((localObject != null) && (!((CopyOnWriteArrayList)localObject).isEmpty()))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      i1++;
      break;
      boolean bool = false;
    }
  }
  
  public boolean isRegistered(Object paramObject)
  {
    try
    {
      boolean bool = this.e.containsKey(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  /* Error */
  public void post(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/wifipay/common/eventbus/EventBus:g	Ljava/lang/ThreadLocal;
    //   4: invokevirtual 433	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   7: checkcast 372	com/wifipay/common/eventbus/e
    //   10: astore_3
    //   11: aload_3
    //   12: getfield 454	com/wifipay/common/eventbus/e:a	Ljava/util/List;
    //   15: astore 4
    //   17: aload 4
    //   19: aload_1
    //   20: invokeinterface 163 2 0
    //   25: pop
    //   26: aload_3
    //   27: getfield 434	com/wifipay/common/eventbus/e:b	Z
    //   30: ifne +96 -> 126
    //   33: invokestatic 84	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   36: invokestatic 384	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   39: if_acmpne +33 -> 72
    //   42: iconst_1
    //   43: istore_2
    //   44: aload_3
    //   45: iload_2
    //   46: putfield 378	com/wifipay/common/eventbus/e:c	Z
    //   49: aload_3
    //   50: iconst_1
    //   51: putfield 434	com/wifipay/common/eventbus/e:b	Z
    //   54: aload_3
    //   55: getfield 381	com/wifipay/common/eventbus/e:f	Z
    //   58: ifeq +19 -> 77
    //   61: new 230	com/wifipay/common/eventbus/g
    //   64: dup
    //   65: ldc_w 456
    //   68: invokespecial 361	com/wifipay/common/eventbus/g:<init>	(Ljava/lang/String;)V
    //   71: athrow
    //   72: iconst_0
    //   73: istore_2
    //   74: goto -30 -> 44
    //   77: aload 4
    //   79: invokeinterface 457 1 0
    //   84: ifne +32 -> 116
    //   87: aload_0
    //   88: aload 4
    //   90: iconst_0
    //   91: invokeinterface 365 2 0
    //   96: aload_3
    //   97: invokespecial 459	com/wifipay/common/eventbus/EventBus:a	(Ljava/lang/Object;Lcom/wifipay/common/eventbus/e;)V
    //   100: goto -23 -> 77
    //   103: astore_1
    //   104: aload_3
    //   105: iconst_0
    //   106: putfield 434	com/wifipay/common/eventbus/e:b	Z
    //   109: aload_3
    //   110: iconst_0
    //   111: putfield 378	com/wifipay/common/eventbus/e:c	Z
    //   114: aload_1
    //   115: athrow
    //   116: aload_3
    //   117: iconst_0
    //   118: putfield 434	com/wifipay/common/eventbus/e:b	Z
    //   121: aload_3
    //   122: iconst_0
    //   123: putfield 378	com/wifipay/common/eventbus/e:c	Z
    //   126: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	EventBus
    //   0	127	1	paramObject	Object
    //   43	31	2	bool	boolean
    //   10	112	3	locale	e
    //   15	74	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   77	100	103	finally
  }
  
  public void postSticky(Object paramObject)
  {
    synchronized (this.f)
    {
      this.f.put(paramObject.getClass(), paramObject);
      post(paramObject);
      return;
    }
  }
  
  public void register(Object paramObject)
  {
    Object localObject = paramObject.getClass();
    localObject = this.k.a((Class)localObject);
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramObject, (m)((Iterator)localObject).next());
      }
    }
    finally {}
  }
  
  public void removeAllStickyEvents()
  {
    synchronized (this.f)
    {
      this.f.clear();
      return;
    }
  }
  
  public void removeChildEvent(Object paramObject)
  {
    if (this.t == null) {
      this.t = new HashMap();
    }
    this.t.put(paramObject, Integer.valueOf(0));
  }
  
  public Object removeStickyEvent(Class paramClass)
  {
    synchronized (this.f)
    {
      paramClass = paramClass.cast(this.f.remove(paramClass));
      return paramClass;
    }
  }
  
  public boolean removeStickyEvent(Object paramObject)
  {
    synchronized (this.f)
    {
      Class localClass = paramObject.getClass();
      if (paramObject.equals(this.f.get(localClass)))
      {
        this.f.remove(localClass);
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    return "EventBus[indexCount=" + this.s + ", eventInheritance=" + this.r + "]";
  }
  
  public void unregister(Object paramObject)
  {
    Object localObject;
    try
    {
      localObject = (List)this.e.get(paramObject);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a(paramObject, (Class)((Iterator)localObject).next());
        }
        this.e.remove(paramObject);
      }
    }
    finally {}
    for (;;)
    {
      if (this.t != null) {
        this.t = null;
      }
      return;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("Subscriber to unregister was not registered before: %s");
      Logger.w(paramObject.getClass(), new Object[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */