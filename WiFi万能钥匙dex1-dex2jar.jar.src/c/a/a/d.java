package c.a.a;

import c.a.a.a.b;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends bt
{
  private List a;
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt2 >= 0)
    {
      if (paramInt2 < 256) {
        break label19;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label19:
      if (paramInt1 == 1)
      {
        bool1 = bool2;
        if (paramInt2 > 32) {}
      }
      else if (paramInt1 == 2)
      {
        bool1 = bool2;
        if (paramInt2 > 128) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  final bt a()
  {
    return new d();
  }
  
  final void a(q paramq)
  {
    this.a = new ArrayList(1);
    if (paramq.b() != 0)
    {
      int k = paramq.h();
      int i = paramq.g();
      int j = paramq.g();
      if ((j & 0x80) != 0) {}
      byte[] arrayOfByte;
      for (boolean bool = true;; bool = false)
      {
        arrayOfByte = paramq.d(j & 0xFF7F);
        if (b(k, i)) {
          break;
        }
        throw new db("invalid prefix length");
      }
      if ((k == 1) || (k == 2))
      {
        j = f.a(k);
        if (arrayOfByte.length > j) {
          throw new db("invalid address length");
        }
        if (arrayOfByte.length == j) {
          localObject = arrayOfByte;
        }
      }
      label128:
      for (Object localObject = new a(bool, InetAddress.getByAddress((byte[])localObject), i);; localObject = new a(k, bool, arrayOfByte, i, (byte)0))
      {
        this.a.add(localObject);
        break;
        localObject = new byte[j];
        System.arraycopy(arrayOfByte, 0, localObject, 0, arrayOfByte.length);
        break label128;
      }
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    a locala;
    int i;
    if (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if ((locala.a == 1) || (locala.a == 2))
      {
        paraml = ((InetAddress)locala.d).getAddress();
        i = paraml.length - 1;
        label69:
        if (i >= 0) {
          if (paraml[i] != 0)
          {
            i++;
            label84:
            if (!locala.b) {
              break label164;
            }
          }
        }
      }
    }
    label164:
    for (int j = i | 0x80;; j = i)
    {
      params.c(locala.a);
      params.b(locala.c);
      params.b(j);
      params.a(paraml, 0, i);
      break;
      i--;
      break label69;
      i = 0;
      break label84;
      paraml = (byte[])locala.d;
      i = paraml.length;
      break label84;
      return;
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append((a)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuffer.append(" ");
      }
    }
    return localStringBuffer.toString();
  }
  
  public static final class a
  {
    public final int a;
    public final boolean b;
    public final int c;
    public final Object d;
    
    private a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramBoolean;
      this.d = paramObject;
      this.c = paramInt2;
      if (!d.a(paramInt1, paramInt2)) {
        throw new IllegalArgumentException("invalid prefix length");
      }
    }
    
    public a(boolean paramBoolean, InetAddress paramInetAddress, int paramInt)
    {
      this(f.a(paramInetAddress), paramBoolean, paramInetAddress, paramInt);
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        if ((paramObject instanceof a)) {
          break label19;
        }
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        label19:
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.a == ((a)paramObject).a)
        {
          bool1 = bool2;
          if (this.b == ((a)paramObject).b)
          {
            bool1 = bool2;
            if (this.c == ((a)paramObject).c)
            {
              bool1 = bool2;
              if (this.d.equals(((a)paramObject).d)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    
    public final int hashCode()
    {
      int j = this.d.hashCode();
      int k = this.c;
      if (this.b) {}
      for (int i = 1;; i = 0) {
        return i + (k + j);
      }
    }
    
    public final String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (this.b) {
        localStringBuffer.append("!");
      }
      localStringBuffer.append(this.a);
      localStringBuffer.append(":");
      if ((this.a == 1) || (this.a == 2)) {
        localStringBuffer.append(((InetAddress)this.d).getHostAddress());
      }
      for (;;)
      {
        localStringBuffer.append("/");
        localStringBuffer.append(this.c);
        return localStringBuffer.toString();
        localStringBuffer.append(b.a((byte[])this.d));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */