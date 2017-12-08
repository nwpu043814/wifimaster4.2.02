package com.wifipay.common.net.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.net.UnifyDispose;
import com.wifipay.common.net.b.a.h;
import com.wifipay.common.net.entitybase.BaseResp;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class k
  implements Comparable
{
  private static long o;
  private final w a;
  private final int b;
  private final String c;
  private String d;
  private String e;
  private final int f;
  private u g;
  private Integer h;
  private o i;
  private boolean j;
  private boolean k;
  private boolean l;
  private t m;
  private String n;
  
  public k(int paramInt, String paramString, u paramu)
  {
    if (w.a) {}
    for (w localw = new w();; localw = null)
    {
      this.a = localw;
      this.j = false;
      this.k = false;
      this.l = false;
      this.b = paramInt;
      this.c = paramString;
      this.e = a(paramInt, paramString);
      this.g = paramu;
      a(new a());
      this.f = e(paramString);
      return;
    }
  }
  
  private static String a(int paramInt, String paramString)
  {
    paramString = new StringBuilder("Request:").append(paramInt).append(":").append(paramString).append(":").append(System.currentTimeMillis()).append(":");
    long l1 = o;
    o = 1L + l1;
    return g.a(l1);
  }
  
  private byte[] a(Map paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        localStringBuilder.append(URLEncoder.encode((String)paramMap.getKey(), paramString));
        localStringBuilder.append('=');
        localStringBuilder.append(URLEncoder.encode((String)paramMap.getValue(), paramString));
        localStringBuilder.append('&');
      }
      paramMap = localStringBuilder.toString().getBytes(paramString);
    }
    catch (UnsupportedEncodingException paramMap)
    {
      throw new RuntimeException("Encoding not supported: " + paramString, paramMap);
    }
    return paramMap;
  }
  
  private static int e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString == null) {}
      }
    }
    for (int i1 = paramString.hashCode();; i1 = 0) {
      return i1;
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(k paramk)
  {
    m localm2 = s();
    m localm1 = paramk.s();
    if (localm2 == localm1) {}
    for (int i1 = this.h.intValue() - paramk.h.intValue();; i1 = localm1.ordinal() - localm2.ordinal()) {
      return i1;
    }
  }
  
  protected h a(h paramh)
  {
    return paramh;
  }
  
  public final k a(int paramInt)
  {
    this.h = Integer.valueOf(paramInt);
    return this;
  }
  
  public k a(o paramo)
  {
    this.i = paramo;
    return this;
  }
  
  public k a(t paramt)
  {
    this.m = paramt;
    return this;
  }
  
  public k a(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  protected abstract r a(j paramj);
  
  protected void a(Object paramObject)
  {
    if ((paramObject instanceof BaseResp))
    {
      BaseResp localBaseResp = (BaseResp)paramObject;
      if (TextUtils.equals(localBaseResp.resultCode, "10006")) {
        EventBus.getDefault().post(new UnifyDispose(localBaseResp, b()));
      }
    }
    for (;;)
    {
      return;
      if (this.g != null) {
        this.g.a(this.n, paramObject);
      } else {
        EventBus.getDefault().post(paramObject);
      }
    }
  }
  
  public String b()
  {
    return this.n;
  }
  
  public void b(h paramh)
  {
    Object localObject = c(paramh);
    if (this.g != null) {
      if (localObject != null) {
        this.g.a(this.n, localObject);
      }
    }
    for (;;)
    {
      return;
      this.g.a(this.n, paramh);
      continue;
      EventBus.getDefault().post(localObject);
    }
  }
  
  public void b(String paramString)
  {
    if (w.a) {
      this.a.a(paramString, Thread.currentThread().getId());
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  public Object c(h paramh)
  {
    return null;
  }
  
  void c(String paramString)
  {
    if (this.i != null)
    {
      this.i.b(this);
      d();
    }
    long l1;
    if (w.a)
    {
      l1 = Thread.currentThread().getId();
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break label66;
      }
      new Handler(Looper.getMainLooper()).post(new l(this, paramString, l1));
    }
    for (;;)
    {
      return;
      label66:
      this.a.a(paramString, l1);
      this.a.a(toString());
    }
  }
  
  protected void d()
  {
    this.g = null;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String e()
  {
    if (this.d != null) {}
    for (String str = this.d;; str = this.c) {
      return str;
    }
  }
  
  public String f()
  {
    return this.c;
  }
  
  public void g()
  {
    this.k = true;
  }
  
  public boolean h()
  {
    return this.k;
  }
  
  public Map i()
  {
    return Collections.emptyMap();
  }
  
  @Deprecated
  protected Map j()
  {
    return n();
  }
  
  @Deprecated
  protected String k()
  {
    return o();
  }
  
  @Deprecated
  public String l()
  {
    return p();
  }
  
  @Deprecated
  public byte[] m()
  {
    Object localObject = j();
    if ((localObject != null) && (((Map)localObject).size() > 0)) {}
    for (localObject = a((Map)localObject, k());; localObject = null) {
      return (byte[])localObject;
    }
  }
  
  protected Map n()
  {
    return null;
  }
  
  protected String o()
  {
    return "UTF-8";
  }
  
  public String p()
  {
    return "application/x-www-form-urlencoded; charset=" + o();
  }
  
  public byte[] q()
  {
    Object localObject = n();
    if ((localObject != null) && (((Map)localObject).size() > 0)) {}
    for (localObject = a((Map)localObject, o());; localObject = null) {
      return (byte[])localObject;
    }
  }
  
  public final boolean r()
  {
    return this.j;
  }
  
  public m s()
  {
    return m.b;
  }
  
  public final int t()
  {
    return this.m.a();
  }
  
  public String toString()
  {
    String str2 = "0x" + Integer.toHexString(c());
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.k) {}
    for (String str1 = "[X] ";; str1 = "[ ] ") {
      return str1 + e() + " " + str2 + " " + s() + " " + this.h;
    }
  }
  
  public t u()
  {
    return this.m;
  }
  
  public void v()
  {
    this.l = true;
  }
  
  public boolean w()
  {
    return this.l;
  }
  
  public void x()
  {
    if (this.g != null) {
      this.g.a(this.n);
    }
  }
  
  public void y()
  {
    if (this.g != null) {
      this.g.b(this.n);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */