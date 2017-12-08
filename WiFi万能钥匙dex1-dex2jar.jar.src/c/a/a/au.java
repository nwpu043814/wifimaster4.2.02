package c.a.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class au
  implements Cloneable
{
  private static bt[] j = new bt[0];
  private static bq[] k = new bq[0];
  int a;
  int b;
  int c;
  private ac d;
  private List[] e = new List[4];
  private int f;
  private cn g;
  private co h;
  private int i;
  
  public au()
  {
    this(new ac());
  }
  
  public au(int paramInt)
  {
    this(new ac(paramInt));
  }
  
  private au(ac paramac)
  {
    this.d = paramac;
  }
  
  private au(q paramq)
  {
    this(new ac(paramq));
    boolean bool1;
    if (this.d.e() == 5) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = this.d.b(6);
      int m = 0;
      if (m < 4) {
        try
        {
          int i1 = this.d.d(m);
          Object localObject;
          if (i1 > 0)
          {
            List[] arrayOfList = this.e;
            localObject = new java/util/ArrayList;
            ((ArrayList)localObject).<init>(i1);
            arrayOfList[m] = localObject;
          }
          int n = 0;
          for (;;)
          {
            if (n < i1)
            {
              int i2 = paramq.a();
              localObject = bt.a(paramq, m, bool1);
              this.e[m].add(localObject);
              if (m == 3)
              {
                if (((bt)localObject).g() == 250) {
                  this.a = i2;
                }
                if ((((bt)localObject).g() == 24) && (((ca)localObject).d() == 0)) {
                  this.c = i2;
                }
              }
              n++;
              continue;
              bool1 = false;
              break;
            }
          }
          m++;
        }
        catch (db localdb)
        {
          if (!bool2) {
            throw localdb;
          }
        }
      }
    }
    this.f = paramq.a();
  }
  
  public au(byte[] paramArrayOfByte)
  {
    this(new q(paramArrayOfByte));
  }
  
  public static au a(bt parambt)
  {
    au localau = new au();
    localau.d.d();
    localau.d.a(7);
    localau.a(parambt, 0);
    return localau;
  }
  
  private String c(int paramInt)
  {
    if (paramInt > 3) {}
    StringBuffer localStringBuffer;
    for (String str = null;; str = localStringBuffer.toString())
    {
      return str;
      localStringBuffer = new StringBuffer();
      bt[] arrayOfbt = a(paramInt);
      int m = 0;
      if (m < arrayOfbt.length)
      {
        str = arrayOfbt[m];
        if (paramInt == 0)
        {
          localStringBuffer.append(";;\t" + str.g);
          localStringBuffer.append(", type = " + ct.b(str.h));
          localStringBuffer.append(", class = " + m.b(str.i));
        }
        for (;;)
        {
          localStringBuffer.append("\n");
          m++;
          break;
          localStringBuffer.append(str);
        }
      }
    }
  }
  
  public final ac a()
  {
    return this.d;
  }
  
  public final void a(bt parambt, int paramInt)
  {
    if (this.e[paramInt] == null) {
      this.e[paramInt] = new LinkedList();
    }
    this.d.c(paramInt);
    this.e[paramInt].add(parambt);
  }
  
  public final bt[] a(int paramInt)
  {
    if (this.e[paramInt] == null) {}
    for (Object localObject = j;; localObject = (bt[])((List)localObject).toArray(new bt[((List)localObject).size()]))
    {
      return (bt[])localObject;
      localObject = this.e[paramInt];
    }
  }
  
  public final bt b()
  {
    Object localObject = this.e[0];
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (localObject = null;; localObject = (bt)((List)localObject).get(0)) {
      return (bt)localObject;
    }
  }
  
  public final bq[] b(int paramInt)
  {
    Object localObject;
    if (this.e[paramInt] == null)
    {
      localObject = k;
      return (bq[])localObject;
    }
    LinkedList localLinkedList = new LinkedList();
    bt[] arrayOfbt = a(paramInt);
    HashSet localHashSet = new HashSet();
    paramInt = 0;
    label42:
    bg localbg;
    if (paramInt < arrayOfbt.length)
    {
      localbg = arrayOfbt[paramInt].f();
      if (!localHashSet.contains(localbg)) {
        break label224;
      }
      m = localLinkedList.size() - 1;
      label80:
      if (m < 0) {
        break label224;
      }
      localObject = (bq)localLinkedList.get(m);
      if ((((bq)localObject).e().h() == arrayOfbt[paramInt].h()) && (((bq)localObject).e().i() == arrayOfbt[paramInt].i()) && (((bq)localObject).e().f().equals(localbg))) {
        ((bq)localObject).a(arrayOfbt[paramInt]);
      }
    }
    label224:
    for (int m = 0;; m = 1)
    {
      if (m != 0)
      {
        localLinkedList.add(new bq(arrayOfbt[paramInt]));
        localHashSet.add(localbg);
      }
      paramInt++;
      break label42;
      m--;
      break label80;
      localObject = (bq[])localLinkedList.toArray(new bq[localLinkedList.size()]);
      break;
    }
  }
  
  public final co c()
  {
    int m = this.d.d(3);
    Object localObject;
    if (m == 0) {
      localObject = null;
    }
    for (;;)
    {
      return (co)localObject;
      localObject = (bt)this.e[3].get(m - 1);
      if (((bt)localObject).h != 250) {
        localObject = null;
      } else {
        localObject = (co)localObject;
      }
    }
  }
  
  public final Object clone()
  {
    au localau = new au();
    for (int m = 0; m < this.e.length; m++) {
      if (this.e[m] != null) {
        localau.e[m] = new LinkedList(this.e[m]);
      }
    }
    localau.d = ((ac)this.d.clone());
    localau.f = this.f;
    return localau;
  }
  
  public final boolean d()
  {
    boolean bool = true;
    if (this.b == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public final bi e()
  {
    Object localObject = a(3);
    int m = 0;
    if (m < localObject.length) {
      if (!(localObject[m] instanceof bi)) {}
    }
    for (localObject = (bi)localObject[m];; localObject = null)
    {
      return (bi)localObject;
      m++;
      break;
    }
  }
  
  public final int f()
  {
    int n = this.d.c();
    bi localbi = e();
    int m = n;
    if (localbi != null) {
      m = n + (localbi.e() << 4);
    }
    return m;
  }
  
  public final byte[] g()
  {
    s locals = new s((byte)0);
    this.d.a(locals);
    l locall = new l();
    for (int m = 0; m < 4; m++) {
      if (this.e[m] != null) {
        for (int n = 0; n < this.e[m].size(); n++) {
          ((bt)this.e[m].get(n)).a(locals, m, locall);
        }
      }
    }
    this.f = locals.a();
    return locals.b();
  }
  
  public final byte[] h()
  {
    s locals = new s((byte)0);
    int m = 65535;
    if (this.g != null) {
      m = 65535 - this.g.a();
    }
    Object localObject1 = e();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject2 = new s((byte)0);
      ((bt)localObject1).a((s)localObject2, 3, null);
      localObject2 = ((s)localObject2).b();
    }
    for (int i6 = m - localObject2.length;; i6 = m)
    {
      int i10 = locals.a();
      this.d.a(locals);
      l locall = new l();
      int i9 = this.d.g();
      m = 0;
      int i7 = 0;
      int i11;
      int i2;
      int i1;
      int n;
      int i3;
      label164:
      int i4;
      bt localbt;
      if (i7 < 4)
      {
        if (this.e[i7] == null) {
          break label591;
        }
        i11 = this.e[i7].size();
        i2 = locals.a();
        i1 = 0;
        n = 0;
        localObject1 = null;
        i3 = 0;
        i4 = n;
        if (i3 < i11)
        {
          localbt = (bt)this.e[i7].get(i3);
          if ((i7 == 3) && ((localbt instanceof bi)))
          {
            i4 = n + 1;
            n = i2;
            i2 = i4;
          }
        }
      }
      for (;;)
      {
        i3++;
        i4 = i2;
        i2 = n;
        n = i4;
        break label164;
        int i5 = i1;
        i4 = i2;
        if (localObject1 != null) {
          if ((localbt.h() != ((bt)localObject1).h()) || (localbt.i() != ((bt)localObject1).i()) || (!localbt.f().equals(((bt)localObject1).f()))) {
            break label431;
          }
        }
        label431:
        for (int i8 = 1;; i8 = 0)
        {
          i5 = i1;
          i4 = i2;
          if (i8 == 0)
          {
            i4 = locals.a();
            i5 = i3;
          }
          localbt.a(locals, i7, locall);
          if (locals.a() <= i6) {
            break label594;
          }
          locals.a(i4);
          i4 = n + (i11 - i5);
          if ((i4 == 0) || (i7 == 3)) {
            break;
          }
          i2 = ac.a(i9, 6);
          locals.a(this.d.d(i7) - i4, i10 + 4 + i7 * 2);
          for (i1 = i7 + 1;; i1++)
          {
            n = i2;
            if (i1 >= 3) {
              break;
            }
            locals.a(0, i10 + 4 + i1 * 2);
          }
        }
        if (i7 == 3) {
          m = this.d.d(i7) - i4;
        }
        label591:
        for (;;)
        {
          i7++;
          break;
          n = i9;
          i1 = m;
          if (localObject2 != null)
          {
            locals.a((byte[])localObject2);
            i1 = m + 1;
          }
          if (n != this.d.g()) {
            locals.a(n, i10 + 2);
          }
          if (i1 != this.d.d(3)) {
            locals.a(i1, i10 + 10);
          }
          if (this.g != null)
          {
            this.g.a(this, locals.b(), this.i, this.h).a(locals, 3, locall);
            locals.a(i1 + 1, i10 + 10);
          }
          this.f = locals.a();
          return locals.b();
        }
        label594:
        i1 = i5;
        localObject1 = localbt;
        i2 = n;
        n = i4;
      }
    }
  }
  
  public final String toString()
  {
    int n = 1;
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int m;
    if (e() != null)
    {
      localStringBuffer.append(this.d.e(f()) + "\n");
      m = n;
      if (this.b != 3)
      {
        m = n;
        if (this.b != 1)
        {
          if (this.b != 4) {
            break label240;
          }
          m = n;
        }
      }
      label85:
      n = i1;
      if (m != 0)
      {
        localStringBuffer.append(";; TSIG ");
        if (!d()) {
          break label245;
        }
        localStringBuffer.append("ok");
        label116:
        localStringBuffer.append('\n');
        n = i1;
      }
      label126:
      if (n >= 4) {
        break label292;
      }
      if (this.d.e() == 5) {
        break label257;
      }
      localStringBuffer.append(";; " + cf.b(n) + ":\n");
    }
    for (;;)
    {
      localStringBuffer.append(c(n) + "\n");
      n++;
      break label126;
      localStringBuffer.append(this.d + "\n");
      break;
      label240:
      m = 0;
      break label85;
      label245:
      localStringBuffer.append("invalid");
      break label116;
      label257:
      localStringBuffer.append(";; " + cf.c(n) + ":\n");
    }
    label292:
    localStringBuffer.append(";; Message size: " + this.f + " bytes");
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */