package com.lantern.core.imageloader.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

final class p
{
  final b a = new b();
  final Context b;
  final ExecutorService c;
  final r d;
  final Map<String, c> e;
  final Map<Object, a> f;
  final Map<Object, a> g;
  final Set<Object> h;
  final Handler i;
  final Handler j;
  final j k;
  final ak l;
  final List<c> m;
  final c n;
  final boolean o;
  boolean p;
  
  p(Context paramContext, ExecutorService paramExecutorService, Handler paramHandler, r paramr, j paramj, ak paramak)
  {
    this.a.start();
    at.a(this.a.getLooper());
    this.b = paramContext;
    this.c = paramExecutorService;
    this.e = new LinkedHashMap();
    this.f = new WeakHashMap();
    this.g = new WeakHashMap();
    this.h = new HashSet();
    this.i = new a(this.a.getLooper(), this);
    this.d = paramr;
    this.j = paramHandler;
    this.k = paramj;
    this.l = paramak;
    this.m = new ArrayList(8);
    this.p = at.d(this.b);
    this.o = at.b(paramContext, "android.permission.ACCESS_NETWORK_STATE");
    this.n = new c(this);
    this.n.a();
  }
  
  private void a(a parama)
  {
    Object localObject = parama.c();
    if (localObject != null)
    {
      parama.k = true;
      this.f.put(localObject, parama);
    }
  }
  
  private static void a(List<c> paramList)
  {
    if (paramList.isEmpty()) {}
    for (;;)
    {
      return;
      if (((c)paramList.get(0)).b.l)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          paramList = (c)localIterator.next();
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(", ");
          }
          localStringBuilder.append(at.a(paramList));
        }
        at.a("Dispatcher", "delivered", localStringBuilder.toString());
      }
    }
  }
  
  private void e(c paramc)
  {
    a locala = paramc.k;
    if (locala != null) {
      a(locala);
    }
    paramc = paramc.l;
    if (paramc != null)
    {
      int i2 = paramc.size();
      for (int i1 = 0; i1 < i2; i1++) {
        a((a)paramc.get(i1));
      }
    }
  }
  
  private void f(c paramc)
  {
    if (paramc.b()) {}
    for (;;)
    {
      return;
      this.m.add(paramc);
      a();
    }
  }
  
  final void a()
  {
    ArrayList localArrayList = new ArrayList(this.m);
    this.m.clear();
    this.j.sendMessage(this.j.obtainMessage(8, localArrayList));
    a(localArrayList);
  }
  
  final void a(NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected()) && (!this.f.isEmpty()))
    {
      Iterator localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
      {
        paramNetworkInfo = (a)localIterator.next();
        localIterator.remove();
        if (paramNetworkInfo.a.l) {
          at.a("Dispatcher", "replaying", paramNetworkInfo.b.a());
        }
        a(paramNetworkInfo, false);
      }
    }
  }
  
  final void a(a parama, boolean paramBoolean)
  {
    if (this.h.contains(parama.j))
    {
      this.g.put(parama.c(), parama);
      if (parama.a.l) {
        at.a("Dispatcher", "paused", parama.b.a(), "because tag '" + parama.j + "' is paused");
      }
    }
    for (;;)
    {
      return;
      c localc = (c)this.e.get(parama.i);
      Object localObject;
      if (localc != null)
      {
        paramBoolean = localc.b.l;
        localObject = parama.b;
        if (localc.k == null)
        {
          localc.k = parama;
          if (paramBoolean) {
            if ((localc.l == null) || (localc.l.isEmpty())) {
              at.a("Hunter", "joined", ((ag)localObject).a(), "to empty hunter");
            } else {
              at.a("Hunter", "joined", ((ag)localObject).a(), at.a(localc, "to "));
            }
          }
        }
        else
        {
          if (localc.l == null) {
            localc.l = new ArrayList(3);
          }
          localc.l.add(parama);
          if (paramBoolean) {
            at.a("Hunter", "joined", ((ag)localObject).a(), at.a(localc, "to "));
          }
          int i1 = parama.b.p;
          if (i1 - 1 > localc.s - 1) {
            localc.s = i1;
          }
        }
      }
      else if (this.c.isShutdown())
      {
        if (parama.a.l) {
          at.a("Dispatcher", "ignored", parama.b.a(), "because shut down");
        }
      }
      else
      {
        localObject = c.a(parama.a, this, this.k, this.l, parama);
        ((c)localObject).n = this.c.submit((Runnable)localObject);
        this.e.put(parama.i, localObject);
        if (paramBoolean) {
          this.f.remove(parama.c());
        }
        if (parama.a.l) {
          at.a("Dispatcher", "enqueued", parama.b.a());
        }
      }
    }
  }
  
  final void a(c paramc)
  {
    this.i.sendMessageDelayed(this.i.obtainMessage(5, paramc), 500L);
  }
  
  final void a(c paramc, boolean paramBoolean)
  {
    String str2;
    StringBuilder localStringBuilder;
    if (paramc.b.l)
    {
      str2 = at.a(paramc);
      localStringBuilder = new StringBuilder("for error");
      if (!paramBoolean) {
        break label75;
      }
    }
    label75:
    for (String str1 = " (will replay)";; str1 = "")
    {
      at.a("Dispatcher", "batched", str2, str1);
      this.e.remove(paramc.f);
      f(paramc);
      return;
    }
  }
  
  final void a(Object paramObject)
  {
    if (!this.h.remove(paramObject)) {}
    for (;;)
    {
      return;
      Object localObject1 = null;
      Iterator localIterator = this.g.values().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.j.equals(paramObject))
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((List)localObject2).add(locala);
          localIterator.remove();
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null) {
        this.j.sendMessage(this.j.obtainMessage(13, localObject1));
      }
    }
  }
  
  final void b(c paramc)
  {
    this.i.sendMessage(this.i.obtainMessage(6, paramc));
  }
  
  final void c(c paramc)
  {
    boolean bool2 = true;
    if (paramc.b()) {}
    for (;;)
    {
      return;
      if (!this.c.isShutdown()) {
        break;
      }
      a(paramc, false);
    }
    if (this.o) {}
    for (NetworkInfo localNetworkInfo = ((ConnectivityManager)at.a(this.b, "connectivity")).getActiveNetworkInfo();; localNetworkInfo = null)
    {
      int i1;
      label72:
      int i2;
      label81:
      label88:
      boolean bool3;
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
      {
        i1 = 1;
        if (paramc.r <= 0) {
          break label143;
        }
        i2 = 1;
        if (i2 != 0) {
          break label148;
        }
        bool1 = false;
        bool3 = paramc.i.b();
        if (bool1) {
          break label178;
        }
        if ((!this.o) || (!bool3)) {
          break label172;
        }
      }
      label143:
      label148:
      label172:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        a(paramc, bool1);
        if (!bool1) {
          break;
        }
        e(paramc);
        break;
        i1 = 0;
        break label72;
        i2 = 0;
        break label81;
        paramc.r -= 1;
        bool1 = paramc.i.a(localNetworkInfo);
        break label88;
      }
      label178:
      if ((!this.o) || (i1 != 0))
      {
        if (paramc.b.l) {
          at.a("Dispatcher", "retrying", at.a(paramc));
        }
        if ((paramc.p instanceof z.a)) {
          paramc.j |= y.a.d;
        }
        paramc.n = this.c.submit(paramc);
        break;
      }
      a(paramc, bool3);
      if (!bool3) {
        break;
      }
      e(paramc);
      break;
    }
  }
  
  final void d(c paramc)
  {
    if (x.b(paramc.h)) {
      this.k.a(paramc.f, paramc.m);
    }
    this.e.remove(paramc.f);
    f(paramc);
    if (paramc.b.l) {
      at.a("Dispatcher", "batched", at.a(paramc), "for completion");
    }
  }
  
  private static final class a
    extends Handler
  {
    private final p a;
    
    public a(Looper paramLooper, p paramp)
    {
      super();
      this.a = paramp;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 3: 
      case 8: 
      default: 
        aa.a.post(new q(this, paramMessage));
      case 1: 
      case 2: 
      case 11: 
      case 12: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 9: 
        for (;;)
        {
          return;
          paramMessage = (a)paramMessage.obj;
          this.a.a(paramMessage, true);
          continue;
          Object localObject2 = (a)paramMessage.obj;
          paramMessage = this.a;
          Object localObject3 = ((a)localObject2).i;
          localObject1 = (c)paramMessage.e.get(localObject3);
          if (localObject1 != null)
          {
            ((c)localObject1).a((a)localObject2);
            if (((c)localObject1).a())
            {
              paramMessage.e.remove(localObject3);
              if (((a)localObject2).a.l) {
                at.a("Dispatcher", "canceled", ((a)localObject2).b.a());
              }
            }
          }
          if (paramMessage.h.contains(((a)localObject2).j))
          {
            paramMessage.g.remove(((a)localObject2).c());
            if (((a)localObject2).a.l) {
              at.a("Dispatcher", "canceled", ((a)localObject2).b.a(), "because paused request got canceled");
            }
          }
          paramMessage = (a)paramMessage.f.remove(((a)localObject2).c());
          if ((paramMessage != null) && (paramMessage.a.l))
          {
            at.a("Dispatcher", "canceled", paramMessage.b.a(), "from replaying");
            continue;
            localObject2 = paramMessage.obj;
            localObject3 = this.a;
            if (((p)localObject3).h.add(localObject2))
            {
              localObject1 = ((p)localObject3).e.values().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                c localc = (c)((Iterator)localObject1).next();
                bool = localc.b.l;
                a locala = localc.k;
                paramMessage = localc.l;
                if ((paramMessage != null) && (!paramMessage.isEmpty())) {}
                for (int i = 1; (locala != null) || (i != 0); i = 0)
                {
                  if ((locala != null) && (locala.j.equals(localObject2)))
                  {
                    localc.a(locala);
                    ((p)localObject3).g.put(locala.c(), locala);
                    if (bool) {
                      at.a("Dispatcher", "paused", locala.b.a(), "because tag '" + localObject2 + "' was paused");
                    }
                  }
                  if (i == 0) {
                    break label626;
                  }
                  for (i = paramMessage.size() - 1; i >= 0; i--)
                  {
                    locala = (a)paramMessage.get(i);
                    if (locala.j.equals(localObject2))
                    {
                      localc.a(locala);
                      ((p)localObject3).g.put(locala.c(), locala);
                      if (bool) {
                        at.a("Dispatcher", "paused", locala.b.a(), "because tag '" + localObject2 + "' was paused");
                      }
                    }
                  }
                }
                continue;
                label626:
                if (localc.a())
                {
                  ((Iterator)localObject1).remove();
                  if (bool) {
                    at.a("Dispatcher", "canceled", at.a(localc), "all actions paused");
                  }
                }
              }
              continue;
              paramMessage = paramMessage.obj;
              this.a.a(paramMessage);
              continue;
              paramMessage = (c)paramMessage.obj;
              this.a.d(paramMessage);
              continue;
              paramMessage = (c)paramMessage.obj;
              this.a.c(paramMessage);
              continue;
              paramMessage = (c)paramMessage.obj;
              this.a.a(paramMessage, false);
              continue;
              this.a.a();
              continue;
              paramMessage = (NetworkInfo)paramMessage.obj;
              this.a.a(paramMessage);
            }
          }
        }
      }
      Object localObject1 = this.a;
      if (paramMessage.arg1 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((p)localObject1).p = bool;
        break;
      }
    }
  }
  
  static final class b
    extends HandlerThread
  {
    b()
    {
      super(10);
    }
  }
  
  static final class c
    extends BroadcastReceiver
  {
    private final p a;
    
    c(p paramp)
    {
      this.a = paramp;
    }
    
    final void a()
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.AIRPLANE_MODE");
      if (this.a.o) {
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      }
      this.a.b.registerReceiver(this, localIntentFilter);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {}
      for (;;)
      {
        return;
        String str = paramIntent.getAction();
        if ("android.intent.action.AIRPLANE_MODE".equals(str))
        {
          if (paramIntent.hasExtra("state"))
          {
            paramContext = this.a;
            boolean bool = paramIntent.getBooleanExtra("state", false);
            paramIntent = paramContext.i;
            paramContext = paramContext.i;
            if (bool) {}
            for (int i = 1;; i = 0)
            {
              paramIntent.sendMessage(paramContext.obtainMessage(10, i, 0));
              break;
            }
          }
        }
        else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
        {
          paramIntent = (ConnectivityManager)at.a(paramContext, "connectivity");
          paramContext = this.a;
          paramIntent = paramIntent.getActiveNetworkInfo();
          paramContext.i.sendMessage(paramContext.i.obtainMessage(9, paramIntent));
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */