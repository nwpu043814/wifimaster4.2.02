package com.b.a.c;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class d
  implements Closeable
{
  private final Writer a;
  private final List<b> b = new ArrayList();
  private String c;
  private String d;
  private boolean e;
  private boolean f;
  
  public d(Writer paramWriter)
  {
    this.b.add(b.f);
    this.d = ":";
    if (paramWriter == null) {
      throw new NullPointerException("out == null");
    }
    this.a = paramWriter;
  }
  
  private d a(b paramb1, b paramb2, String paramString)
  {
    b localb = h();
    if ((localb != paramb2) && (localb != paramb1)) {
      throw new IllegalStateException("Nesting problem: " + this.b);
    }
    this.b.remove(this.b.size() - 1);
    if (localb == paramb2) {
      i();
    }
    this.a.write(paramString);
    return this;
  }
  
  private d a(b paramb, String paramString)
  {
    d(true);
    this.b.add(paramb);
    this.a.write(paramString);
    return this;
  }
  
  private void a(b paramb)
  {
    this.b.set(this.b.size() - 1, paramb);
  }
  
  private void d(String paramString)
  {
    this.a.write("\"");
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      int k = paramString.charAt(i);
      switch (k)
      {
      default: 
        if (k <= 31) {
          this.a.write(String.format("\\u%04x", new Object[] { Integer.valueOf(k) }));
        }
        break;
      }
      for (;;)
      {
        i++;
        break;
        this.a.write(92);
        this.a.write(k);
        continue;
        this.a.write("\\t");
        continue;
        this.a.write("\\b");
        continue;
        this.a.write("\\n");
        continue;
        this.a.write("\\r");
        continue;
        this.a.write("\\f");
        continue;
        if (this.f) {
          this.a.write(String.format("\\u%04x", new Object[] { Integer.valueOf(k) }));
        } else {
          this.a.write(k);
        }
      }
    }
    this.a.write("\"");
  }
  
  private void d(boolean paramBoolean)
  {
    switch (1.a[h().ordinal()])
    {
    default: 
      throw new IllegalStateException("Nesting problem: " + this.b);
    case 1: 
      if ((!this.e) && (!paramBoolean)) {
        throw new IllegalStateException("JSON must start with an array or an object.");
      }
      a(b.g);
    case 2: 
    case 3: 
    case 4: 
      for (;;)
      {
        return;
        a(b.b);
        i();
        continue;
        this.a.append(',');
        i();
        continue;
        this.a.append(this.d);
        a(b.e);
      }
    }
    throw new IllegalStateException("JSON must have only one top-level value.");
  }
  
  private b h()
  {
    return (b)this.b.get(this.b.size() - 1);
  }
  
  private void i()
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      this.a.write("\n");
      for (int i = 1; i < this.b.size(); i++) {
        this.a.write(this.c);
      }
    }
  }
  
  public final d a(Number paramNumber)
  {
    if (paramNumber == null) {}
    for (paramNumber = g();; paramNumber = this)
    {
      return paramNumber;
      String str = paramNumber.toString();
      if ((!this.e) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN")))) {
        throw new IllegalArgumentException("Numeric values must be finite, but was " + paramNumber);
      }
      d(false);
      this.a.append(str);
    }
  }
  
  public final void a(String paramString)
  {
    if (paramString.length() == 0) {
      this.c = null;
    }
    for (this.d = ":";; this.d = ": ")
    {
      return;
      this.c = paramString;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  public final d b(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    b localb = h();
    if (localb == b.e) {
      this.a.write(44);
    }
    while (localb == b.c)
    {
      i();
      a(b.d);
      d(paramString);
      return this;
    }
    throw new IllegalStateException("Nesting problem: " + this.b);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.f;
  }
  
  public final d c()
  {
    return a(b.a, "[");
  }
  
  public final d c(String paramString)
  {
    if (paramString == null) {}
    for (paramString = g();; paramString = this)
    {
      return paramString;
      d(false);
      d(paramString);
    }
  }
  
  public final d c(boolean paramBoolean)
  {
    d(false);
    Writer localWriter = this.a;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      return this;
    }
  }
  
  public final void close()
  {
    this.a.close();
    if (h() != b.g) {
      throw new IOException("Incomplete document");
    }
  }
  
  public final d d()
  {
    return a(b.a, b.b, "]");
  }
  
  public final d e()
  {
    return a(b.c, "{");
  }
  
  public final d f()
  {
    return a(b.c, b.e, "}");
  }
  
  public final d g()
  {
    d(false);
    this.a.write("null");
    return this;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */