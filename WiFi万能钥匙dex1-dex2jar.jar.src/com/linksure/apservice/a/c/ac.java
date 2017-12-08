package com.linksure.apservice.a.c;

import android.content.Context;
import android.text.SpannableString;
import android.util.Log;
import android.util.SparseArray;
import com.linksure.apservice.a.a.g;
import com.linksure.apservice.a.h;
import com.linksure.apservice.a.j;
import com.linksure.apservice.b.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ac
  extends com.linksure.apservice.a.e.c
  implements com.linksure.apservice.a.f
{
  a a = new a();
  Context b;
  private com.linksure.apservice.a.a c;
  private com.linksure.apservice.a.b.c d;
  private com.linksure.apservice.a.a.f e;
  private com.linksure.apservice.a.a.e f;
  private com.linksure.apservice.a.b.d g;
  private g h;
  private SparseArray<com.linksure.apservice.a.c.a.a> i = new SparseArray();
  
  public ac(Context paramContext, com.linksure.apservice.a.a parama, com.linksure.apservice.a.a.e parame, com.linksure.apservice.a.b.d paramd, com.linksure.apservice.a.b.c paramc, com.linksure.apservice.a.a.f paramf, g paramg)
  {
    this.b = paramContext;
    this.c = parama;
    this.f = parame;
    this.g = paramd;
    this.d = paramc;
    this.e = paramf;
    this.h = paramg;
    this.i.put(1, new com.linksure.apservice.a.c.a.e(this.f, this.g));
    paramContext = new com.linksure.apservice.a.c.a.b(this.d, this.e, this.f, this.g);
    this.i.put(2, paramContext);
  }
  
  private boolean e(String paramString)
  {
    if (paramString == null) {}
    for (boolean bool = false;; bool = paramString.equals(a.a(this.a))) {
      return bool;
    }
  }
  
  public final List<i> a()
  {
    return a.b(this.a);
  }
  
  public final void a(int paramInt, String paramString, h<Boolean> paramh)
  {
    Log.e("--->", "Send message: " + paramString);
    paramh = new j(paramh);
    com.linksure.apservice.a.f.b.a(new ad(this, (com.linksure.apservice.a.c.a.a)this.i.get(paramInt), a.a(this.a), paramString, paramh));
  }
  
  public final void a(long paramLong)
  {
    this.a.a(paramLong);
    com.linksure.apservice.a.f.b.a(new ah(this, paramLong, a.a(this.a)));
  }
  
  public final void a(long paramLong, h<Void> paramh)
  {
    int j = this.a.b(paramLong).g;
    paramh = new j(paramh);
    com.linksure.apservice.a.f.b.a(new af(this, (com.linksure.apservice.a.c.a.a)this.i.get(j), paramLong, paramh));
  }
  
  final void a(com.linksure.apservice.a.d.f paramf)
  {
    if (e(paramf.e)) {}
    for (int j = 0;; j = 1)
    {
      this.c.a(paramf, j);
      return;
    }
  }
  
  final void a(i parami)
  {
    if (parami.g == 1) {}
    try
    {
      SpannableString localSpannableString = com.linksure.apservice.utils.text.a.a(parami.j);
      parami.k = ((SpannableString)com.linksure.apservice.utils.c.a(this.b, localSpannableString));
      return;
    }
    catch (Exception parami)
    {
      for (;;)
      {
        parami.printStackTrace();
      }
    }
  }
  
  public final void a(String paramString)
  {
    com.linksure.apservice.a.f.b.a(new aj(this, paramString));
  }
  
  public final void a(String paramString, long paramLong, h<List<i>> paramh)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      l = Long.MAX_VALUE;
      this.a.a();
      a.a(this.a, paramString);
    }
    paramString = this.g.a(paramString, l);
    if (paramString.isEmpty()) {
      paramh.a(Collections.EMPTY_LIST);
    }
    for (;;)
    {
      return;
      paramString = com.linksure.apservice.a.f.d.a(paramString);
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext()) {
        a((i)localIterator.next());
      }
      this.a.a(paramString);
      new j(paramh).a(paramString);
    }
  }
  
  public final void b()
  {
    this.a = new a();
  }
  
  public final void b(String paramString)
  {
    com.linksure.apservice.a.f.b.a(new ai(this, paramString));
  }
  
  final void c(String paramString)
  {
    com.linksure.apservice.a.d.f localf = this.g.a(paramString);
    if (e(paramString)) {}
    for (int j = 0;; j = -1)
    {
      if (localf != null) {
        this.c.a(localf, j);
      }
      return;
    }
  }
  
  final class a
  {
    private ac.b b = new ac.b(ac.this);
    private String c;
    private ArrayList<i> d = new ArrayList();
    
    a() {}
    
    final a a()
    {
      this.d.clear();
      return this;
    }
    
    final a a(long paramLong)
    {
      int k = -1;
      int j = this.d.size();
      int i = 0;
      if (i < j) {
        if ((((i)this.d.get(i)).e != paramLong) || (((i)this.d.get(i)).g == 0)) {}
      }
      for (j = i;; j = -1)
      {
        ArrayList localArrayList;
        if (j >= 0)
        {
          localArrayList = this.d;
          if (j == 0)
          {
            i = k;
            com.linksure.apservice.a.f.b.c(new an(this, j, i));
          }
        }
        else
        {
          return this;
          i++;
          break;
        }
        if ((((i)localArrayList.get(j - 1)).g == 0) && ((localArrayList.size() <= j + 1) || (((i)localArrayList.get(j + 1)).g == 0))) {}
        for (i = j - 1;; i = -1) {
          break;
        }
      }
    }
    
    final a a(long paramLong, int paramInt)
    {
      i locali = b(paramLong);
      if (locali != null) {
        com.linksure.apservice.a.f.b.c(new am(this, locali, paramInt));
      }
      return this;
    }
    
    final a a(com.linksure.apservice.a.d.f paramf)
    {
      if ((this.c == null) || (!this.c.equals(paramf.e))) {}
      for (;;)
      {
        return this;
        i locali = com.linksure.apservice.a.f.d.a(paramf);
        locali.f = 2;
        if (paramf.b == 1) {
          ac.this.a(locali);
        }
        com.linksure.apservice.a.f.b.c(new ak(this, this.b.a(this.d, locali), locali));
      }
    }
    
    final a a(List<i> paramList)
    {
      com.linksure.apservice.a.f.b.c(new al(this, this.b.a(paramList)));
      return this;
    }
    
    final i b(long paramLong)
    {
      Iterator localIterator = this.d.iterator();
      i locali;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locali = (i)localIterator.next();
      } while (locali.e != paramLong);
      for (;;)
      {
        return locali;
        locali = null;
      }
    }
  }
  
  final class b
  {
    private long b = 300000L;
    
    b() {}
    
    final i a(List<i> paramList, i parami)
    {
      long l;
      if (paramList.isEmpty())
      {
        l = 0L;
        if (parami.i - l <= this.b) {
          break label59;
        }
      }
      label59:
      for (paramList = ac.b(parami.i);; paramList = null)
      {
        return paramList;
        l = ((i)paramList.get(paramList.size() - 1)).i;
        break;
      }
    }
    
    final List<i> a(List<i> paramList)
    {
      int j = 0;
      if (paramList.isEmpty()) {}
      for (;;)
      {
        return paramList;
        ArrayList localArrayList2 = new ArrayList();
        long l2 = 0L;
        int i = 0;
        while (i < paramList.size())
        {
          long l1 = l2;
          if (((i)paramList.get(i)).i - l2 >= this.b)
          {
            l1 = ((i)paramList.get(i)).i;
            localArrayList2.add(Long.valueOf(l1));
          }
          i++;
          l2 = l1;
        }
        ArrayList localArrayList1 = new ArrayList(localArrayList2.size() + paramList.size());
        i = 0;
        if (i < paramList.size())
        {
          if ((j < localArrayList2.size()) && (((i)paramList.get(i)).i == ((Long)localArrayList2.get(j)).longValue()))
          {
            localArrayList1.add(ac.b(((Long)localArrayList2.get(j)).longValue()));
            localArrayList1.add(paramList.get(i));
            j++;
          }
          for (;;)
          {
            i++;
            break;
            localArrayList1.add(paramList.get(i));
          }
        }
        paramList = localArrayList1;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/c/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */