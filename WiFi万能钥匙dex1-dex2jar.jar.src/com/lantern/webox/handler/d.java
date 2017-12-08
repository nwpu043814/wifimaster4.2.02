package com.lantern.webox.handler;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.event.WebEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public final class d
  extends a
{
  private Collection<b> a;
  private AtomicLong b;
  
  public d(WkBrowserWebView paramWkBrowserWebView)
  {
    super(paramWkBrowserWebView);
    paramWkBrowserWebView.a("eventBridge", this);
    this.b = new AtomicLong(0L);
    this.a = new CopyOnWriteArrayList();
  }
  
  public final String a(String paramString, a parama)
  {
    String str = this.b.getAndIncrement();
    this.a.add(new b(str, paramString, parama));
    return str;
  }
  
  public final void a(Object paramObject)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a().equals(paramObject)) {
        this.a.remove(localb);
      }
    }
  }
  
  public final void onWebEvent(WebEvent paramWebEvent)
  {
    super.onWebEvent(paramWebEvent);
    if (paramWebEvent.getType() == 200)
    {
      String str = (String)((Map)paramWebEvent.getData()).get("type");
      if (str != null)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).a(str, paramWebEvent);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onEvent(String paramString, Object paramObject);
  }
  
  public final class b
  {
    private Object b;
    private String c;
    private d.a d;
    
    public b(Object paramObject, String paramString, d.a parama)
    {
      this.b = paramObject;
      this.c = paramString;
      this.d = parama;
    }
    
    public final Object a()
    {
      return this.b;
    }
    
    public final void a(String paramString, Object paramObject)
    {
      if ((this.c.equals("*")) || (this.c.equals(paramString))) {
        this.d.onEvent(paramString, paramObject);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/handler/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */