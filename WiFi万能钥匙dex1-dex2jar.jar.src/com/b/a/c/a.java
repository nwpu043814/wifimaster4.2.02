package com.b.a.c;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements Closeable
{
  private static final char[] a = ")]}'\n".toCharArray();
  private final Reader b;
  private boolean c = false;
  private final char[] d = new char['Ѐ'];
  private int e = 0;
  private int f = 0;
  private final List<b> g = new ArrayList();
  private boolean h;
  private c i;
  private String j;
  private String k;
  private boolean l;
  
  public a(Reader paramReader)
  {
    a(b.f);
    this.l = false;
    if (paramReader == null) {
      throw new NullPointerException("in == null");
    }
    this.b = paramReader;
  }
  
  private IOException a(String paramString)
  {
    throw new e(paramString + " near " + t());
  }
  
  private String a(char paramChar)
  {
    Object localObject1 = null;
    int m = this.e;
    label8:
    Object localObject2;
    char c1;
    if (this.e < this.f)
    {
      localObject2 = this.d;
      char c2 = this.e;
      this.e = (c2 + '\001');
      c2 = localObject2[c2];
      if (c2 == paramChar)
      {
        if (this.l) {
          localObject1 = "skipped!";
        }
        for (;;)
        {
          return (String)localObject1;
          if (localObject1 == null)
          {
            localObject1 = new String(this.d, m, this.e - m - 1);
          }
          else
          {
            ((StringBuilder)localObject1).append(this.d, m, this.e - m - 1);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
      if (c2 != '\\') {
        break label447;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(this.d, m, this.e - m - 1);
      if ((this.e == this.f) && (!a(1))) {
        throw a("Unterminated escape sequence");
      }
      localObject1 = this.d;
      m = this.e;
      this.e = (m + 1);
      c1 = localObject1[m];
      switch (c1)
      {
      default: 
        label276:
        ((StringBuilder)localObject2).append(c1);
        m = this.e;
        localObject1 = localObject2;
      }
    }
    label447:
    for (;;)
    {
      break label8;
      if ((this.e + 4 > this.f) && (!a(4))) {
        throw a("Unterminated escape sequence");
      }
      localObject1 = new String(this.d, this.e, 4);
      this.e += 4;
      c1 = (char)Integer.parseInt((String)localObject1, 16);
      break label276;
      c1 = '\t';
      break label276;
      c1 = '\b';
      break label276;
      c1 = '\n';
      break label276;
      c1 = '\r';
      break label276;
      c1 = '\f';
      break label276;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(this.d, m, this.e - m);
      localObject1 = localObject2;
      if (a(1)) {
        break;
      }
      throw a("Unterminated string");
    }
  }
  
  private void a(b paramb)
  {
    this.g.add(paramb);
  }
  
  private void a(c paramc)
  {
    l();
    if (this.i != paramc) {
      throw new IllegalStateException("Expected " + paramc + " but was " + g());
    }
    m();
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    if (this.f != this.e)
    {
      this.f -= this.e;
      System.arraycopy(this.d, this.e, this.d, 0, this.f);
    }
    for (;;)
    {
      this.e = 0;
      do
      {
        int m = this.b.read(this.d, this.f, this.d.length - this.f);
        bool1 = bool2;
        if (m == -1) {
          break;
        }
        this.f = (m + this.f);
      } while (this.f < paramInt);
      boolean bool1 = true;
      return bool1;
      this.f = 0;
    }
  }
  
  private c b(boolean paramBoolean)
  {
    label11:
    c localc;
    if (paramBoolean)
    {
      b(b.b);
      switch (p())
      {
      default: 
        this.e -= 1;
        localc = o();
      }
    }
    for (;;)
    {
      return localc;
      switch (p())
      {
      case 44: 
      default: 
        throw a("Unterminated array");
      case 93: 
        n();
        this.h = true;
        localc = c.b;
        this.i = localc;
        break;
      case 59: 
        q();
        break label11;
        if (paramBoolean)
        {
          n();
          this.h = true;
          localc = c.b;
          this.i = localc;
        }
        else
        {
          q();
          this.e -= 1;
          this.h = true;
          this.k = "null";
          localc = c.i;
          this.i = localc;
        }
        break;
      }
    }
  }
  
  private void b(b paramb)
  {
    this.g.set(this.g.size() - 1, paramb);
  }
  
  private c c(boolean paramBoolean)
  {
    int m;
    c localc;
    if (paramBoolean) {
      switch (p())
      {
      default: 
        this.e -= 1;
        m = p();
        switch (m)
        {
        default: 
          q();
          this.e -= 1;
          this.j = s();
          if (this.j.length() == 0) {
            throw a("Expected name");
          }
          break;
        }
      case 125: 
        n();
        this.h = true;
        localc = c.d;
        this.i = localc;
      }
    }
    for (;;)
    {
      return localc;
      switch (p())
      {
      case 44: 
      case 59: 
      default: 
        throw a("Unterminated object");
      }
      n();
      this.h = true;
      localc = c.d;
      this.i = localc;
      continue;
      q();
      this.j = a((char)m);
      b(b.d);
      this.h = true;
      localc = c.e;
      this.i = localc;
    }
  }
  
  private c l()
  {
    Object localObject;
    if (this.h) {
      localObject = this.i;
    }
    for (;;)
    {
      return (c)localObject;
      switch (1.a[((b)this.g.get(this.g.size() - 1)).ordinal()])
      {
      default: 
        throw new AssertionError();
      case 1: 
        if (this.c)
        {
          p();
          this.e -= 1;
          if ((this.e + a.length <= this.f) || (a(a.length)))
          {
            for (int m = 0; m < a.length; m++) {
              if (this.d[(this.e + m)] != a[m]) {
                break label197;
              }
            }
            this.e += a.length;
          }
        }
        b(b.g);
        c localc2 = o();
        localObject = localc2;
        if (!this.c)
        {
          localObject = localc2;
          if (localc2 != c.a)
          {
            localObject = localc2;
            if (localc2 != c.c)
            {
              a("Expected JSON document to start with '[' or '{'");
              localObject = localc2;
            }
          }
        }
        break;
      case 2: 
        localObject = b(true);
        break;
      case 3: 
        localObject = b(false);
        break;
      case 4: 
        localObject = c(true);
        break;
      case 5: 
        switch (p())
        {
        case 59: 
        case 60: 
        default: 
          throw a("Expected ':'");
        case 61: 
          q();
          if (((this.e < this.f) || (a(1))) && (this.d[this.e] == '>')) {
            this.e += 1;
          }
          break;
        }
        b(b.e);
        localObject = o();
        break;
      case 6: 
        localObject = c(false);
        break;
      case 7: 
        try
        {
          label197:
          localObject = o();
          if (!this.c) {
            throw a("Expected EOF");
          }
        }
        catch (EOFException localEOFException)
        {
          this.h = true;
          c localc1 = c.j;
          this.i = localc1;
        }
      }
    }
    throw new IllegalStateException("JsonReader is closed");
  }
  
  private c m()
  {
    l();
    c localc = this.i;
    this.h = false;
    this.i = null;
    this.k = null;
    this.j = null;
    return localc;
  }
  
  private b n()
  {
    return (b)this.g.remove(this.g.size() - 1);
  }
  
  private c o()
  {
    int m = p();
    Object localObject;
    switch (m)
    {
    default: 
      this.e -= 1;
      localObject = s();
      if (((String)localObject).length() == 0) {
        throw a("Expected literal value");
      }
      break;
    case 123: 
      a(b.c);
      this.h = true;
      localObject = c.c;
      this.i = ((c)localObject);
    }
    for (;;)
    {
      return (c)localObject;
      a(b.a);
      this.h = true;
      localObject = c.a;
      this.i = ((c)localObject);
      continue;
      q();
      this.k = a((char)m);
      this.h = true;
      localObject = c.f;
      this.i = ((c)localObject);
      continue;
      this.k = ((String)localObject);
      this.h = true;
      localObject = null;
      this.i = null;
    }
  }
  
  private int p()
  {
    while ((this.e < this.f) || (a(1)))
    {
      char[] arrayOfChar = this.d;
      int m = this.e;
      this.e = (m + 1);
      m = arrayOfChar[m];
      switch (m)
      {
      case 9: 
      case 10: 
      case 13: 
      case 32: 
      default: 
      case 47: 
        for (;;)
        {
          return m;
          if ((this.e != this.f) || (a(1)))
          {
            q();
            switch (this.d[this.e])
            {
            }
          }
        }
        this.e += 1;
        if ((this.e + "*/".length() < this.f) || (a("*/".length()))) {
          for (m = 0; m < "*/".length(); m++) {
            if (this.d[(this.e + m)] != "*/".charAt(m)) {
              break label257;
            }
          }
        }
        for (m = 1;; m = 0)
        {
          if (m != 0) {
            break label275;
          }
          throw a("Unterminated comment");
          this.e += 1;
          break;
        }
        this.e += 2;
        continue;
        this.e += 1;
        r();
        break;
      case 35: 
        label257:
        label275:
        q();
        r();
      }
    }
    throw new EOFException("End of input");
  }
  
  private void q()
  {
    if (!this.c) {
      throw a("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
  }
  
  private void r()
  {
    int m;
    do
    {
      if ((this.e >= this.f) && (!a(1))) {
        break;
      }
      char[] arrayOfChar = this.d;
      m = this.e;
      this.e = (m + 1);
      m = arrayOfChar[m];
    } while ((m != 13) && (m != 10));
  }
  
  private String s()
  {
    Object localObject1 = null;
    int n = this.e;
    Object localObject2;
    for (;;)
    {
      if (this.e < this.f)
      {
        localObject2 = this.d;
        int m = this.e;
        this.e = (m + 1);
        switch (localObject2[m])
        {
        default: 
          break;
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          label183:
          this.e -= 1;
          if (this.l) {
            localObject1 = "skipped!";
          }
          break;
        }
      }
    }
    for (;;)
    {
      return (String)localObject1;
      q();
      break label183;
      if (localObject1 == null)
      {
        localObject1 = new String(this.d, n, this.e - n);
      }
      else
      {
        ((StringBuilder)localObject1).append(this.d, n, this.e - n);
        localObject1 = ((StringBuilder)localObject1).toString();
        continue;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new StringBuilder();
        }
        ((StringBuilder)localObject2).append(this.d, n, this.e - n);
        localObject1 = localObject2;
        if (a(1)) {
          break;
        }
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
  }
  
  private CharSequence t()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = Math.min(this.e, 20);
    localStringBuilder.append(this.d, this.e - m, m);
    m = Math.min(this.f - this.e, 20);
    localStringBuilder.append(this.d, this.e, m);
    return localStringBuilder;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  public final void b()
  {
    a(c.a);
  }
  
  public final void c()
  {
    a(c.b);
  }
  
  public final void close()
  {
    this.h = false;
    this.k = null;
    this.i = null;
    this.g.clear();
    this.g.add(b.h);
    this.b.close();
  }
  
  public final void d()
  {
    a(c.c);
  }
  
  public final void e()
  {
    a(c.d);
  }
  
  public final boolean f()
  {
    l();
    if ((this.i != c.d) && (this.i != c.b)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final c g()
  {
    l();
    if (this.i == null)
    {
      if (!this.k.equalsIgnoreCase("null")) {
        break label36;
      }
      this.i = c.i;
    }
    for (;;)
    {
      return this.i;
      label36:
      if ((this.k.equalsIgnoreCase("true")) || (this.k.equalsIgnoreCase("false"))) {
        this.i = c.h;
      } else {
        try
        {
          Double.parseDouble(this.k);
          this.i = c.g;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          q();
          this.i = c.f;
        }
      }
    }
  }
  
  public final String h()
  {
    l();
    if (this.i != c.e) {
      throw new IllegalStateException("Expected a name but was " + g());
    }
    String str = this.j;
    m();
    return str;
  }
  
  public final String i()
  {
    g();
    if ((this.k == null) || ((this.i != c.f) && (this.i != c.g))) {
      throw new IllegalStateException("Expected a string but was " + g());
    }
    String str = this.k;
    m();
    return str;
  }
  
  public final boolean j()
  {
    l();
    if ((this.k == null) || (this.i == c.f)) {
      throw new IllegalStateException("Expected a boolean but was " + g());
    }
    if (this.k.equalsIgnoreCase("true")) {}
    for (boolean bool = true;; bool = false)
    {
      m();
      return bool;
      if (!this.k.equalsIgnoreCase("false")) {
        break;
      }
    }
    throw new IllegalStateException("Not a boolean: " + this.k);
  }
  
  public final void k()
  {
    l();
    if ((this.k == null) || (this.i == c.f)) {
      throw new IllegalStateException("Expected null but was " + g());
    }
    if (!this.k.equalsIgnoreCase("null")) {
      throw new IllegalStateException("Not a null: " + this.k);
    }
    m();
  }
  
  public final String toString()
  {
    return getClass().getSimpleName() + " near " + t();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */