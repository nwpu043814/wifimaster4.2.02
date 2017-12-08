package com.lantern.core.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.lantern.core.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  private static k d;
  private Handler a = new Handler(Looper.getMainLooper(), new l(this));
  private ConcurrentHashMap<b, Boolean> b = new ConcurrentHashMap();
  private ConcurrentHashMap<b, List<b>> c = new ConcurrentHashMap();
  private List<a> e = new ArrayList();
  private c f = new c();
  
  private k()
  {
    Map localMap = this.f.a();
    if (!localMap.isEmpty()) {
      this.b.putAll(localMap);
    }
  }
  
  public static final k a()
  {
    if (d == null) {
      d = new k();
    }
    return d;
  }
  
  private void a(List<b> paramList, b paramb)
  {
    for (b localb : ) {
      if (b.a(localb) == paramb)
      {
        paramList.add(localb);
        a(paramList, localb);
      }
    }
  }
  
  private void e(b paramb)
  {
    if ((this.e != null) && (!this.e.isEmpty()))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramb;
      this.a.sendMessage(localMessage);
    }
  }
  
  public final void a(a parama)
  {
    synchronized (this.e)
    {
      this.e.remove(parama);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    this.b.put(paramb, Boolean.valueOf(true));
    if (paramb.a()) {
      this.f.a(paramb, true);
    }
    e(paramb);
  }
  
  public final void b()
  {
    synchronized (this.e)
    {
      this.e.clear();
      return;
    }
  }
  
  public final void b(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      synchronized (this.e)
      {
        if (!this.e.contains(parama)) {
          this.e.add(parama);
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          parama.a(null);
        }
      }
      this.a.post(new m(this, parama));
    }
  }
  
  public final void b(b paramb)
  {
    this.b.put(paramb, Boolean.valueOf(false));
    if (paramb.a()) {
      this.f.a(paramb, false);
    }
    e(paramb);
  }
  
  public final void c(b paramb)
  {
    this.b.remove(paramb);
    if (paramb.a()) {
      this.f.a(paramb);
    }
    e(paramb);
  }
  
  public final boolean d(b paramb)
  {
    Object localObject = (Boolean)this.b.get(paramb);
    boolean bool;
    if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      localObject = (List)this.c.get(paramb);
      if (localObject != null) {}
      for (paramb = (b)localObject;; paramb = (b)localObject)
      {
        if ((paramb == null) || (paramb.isEmpty())) {
          break label141;
        }
        paramb = paramb.iterator();
        do
        {
          if (!paramb.hasNext()) {
            break;
          }
          localObject = (b)paramb.next();
          localObject = (Boolean)this.b.get(localObject);
        } while ((localObject == null) || (!((Boolean)localObject).booleanValue()));
        bool = true;
        break;
        localObject = new ArrayList();
        a((List)localObject, paramb);
        this.c.put(paramb, localObject);
      }
      label141:
      bool = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(k.b paramb);
  }
  
  public static enum b
  {
    private b y;
    private boolean z;
    
    private b(b paramb)
    {
      this(paramb, true);
    }
    
    private b(b paramb, boolean paramBoolean)
    {
      this.y = paramb;
      this.z = paramBoolean;
    }
    
    public final boolean a()
    {
      return this.z;
    }
  }
  
  private static final class c
  {
    private SharedPreferences a = c.getInstance().getSharedPreferences("red_dot_settings", 0);
    
    public final Map<k.b, Boolean> a()
    {
      HashMap localHashMap = new HashMap();
      Map localMap = this.a.getAll();
      if ((localMap != null) && (!localMap.isEmpty()))
      {
        k.b[] arrayOfb = k.b.values();
        if ((arrayOfb != null) && (arrayOfb.length > 0))
        {
          int j = arrayOfb.length;
          for (int i = 0; i < j; i++)
          {
            k.b localb = arrayOfb[i];
            Object localObject = String.valueOf(localb);
            if (localMap.containsKey(localObject))
            {
              localObject = localMap.get(localObject);
              if ((localObject instanceof Boolean)) {
                localHashMap.put(localb, (Boolean)localObject);
              }
            }
          }
        }
      }
      return localHashMap;
    }
    
    public final void a(k.b paramb)
    {
      this.a.edit().remove(String.valueOf(paramb)).commit();
    }
    
    public final void a(k.b paramb, boolean paramBoolean)
    {
      this.a.edit().putBoolean(String.valueOf(paramb), paramBoolean).commit();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */