package a.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class d
{
  private int a;
  private Reader b;
  private char c;
  private boolean d;
  
  private d(Reader paramReader)
  {
    if (paramReader.markSupported()) {}
    for (;;)
    {
      this.b = paramReader;
      this.d = false;
      this.a = 0;
      return;
      paramReader = new BufferedReader(paramReader);
    }
  }
  
  public d(String paramString)
  {
    this(new StringReader(paramString));
  }
  
  private String a(int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {}
    String str;
    for (Object localObject = "";; str = new String(localIOException))
    {
      return (String)localObject;
      localObject = new char[paramInt];
      if (this.d)
      {
        this.d = false;
        localObject[0] = this.c;
        i = 1;
      }
      while (i < paramInt) {
        try
        {
          int j = this.b.read((char[])localObject, i, paramInt - i);
          if (j != -1) {
            i += j;
          }
        }
        catch (IOException localIOException)
        {
          throw new a(localIOException);
        }
      }
      this.a += i;
      if (i < paramInt) {
        throw a("Substring bounds error");
      }
      this.c = localIOException[(paramInt - 1)];
    }
  }
  
  public final a a(String paramString)
  {
    return new a(paramString + toString());
  }
  
  public final void a()
  {
    if ((this.d) || (this.a <= 0)) {
      throw new a("Stepping back two steps is not supported");
    }
    this.a -= 1;
    this.d = true;
  }
  
  public final char b()
  {
    char c1 = '\000';
    if (this.d)
    {
      this.d = false;
      if (this.c != 0) {
        this.a += 1;
      }
    }
    for (c1 = this.c;; c1 = this.c)
    {
      int i;
      for (;;)
      {
        return c1;
        try
        {
          i = this.b.read();
          if (i <= 0) {
            this.c = '\000';
          }
        }
        catch (IOException localIOException)
        {
          throw new a(localIOException);
        }
      }
      this.a += 1;
      this.c = ((char)i);
    }
  }
  
  public final char c()
  {
    char c1 = '/';
    char c2 = b();
    if (c2 == '/') {
      switch (b())
      {
      default: 
        a();
      }
    }
    for (;;)
    {
      return c1;
      int i;
      do
      {
        i = b();
        if ((i == 10) || (i == 13)) {
          break;
        }
      } while (i != 0);
      break;
      do
      {
        if (i == 42)
        {
          if (b() == '/') {
            break;
          }
          a();
        }
        i = b();
      } while (i != 0);
      throw a("Unclosed comment");
      if (c2 == '#')
      {
        do
        {
          i = b();
          if ((i == 10) || (i == 13)) {
            break;
          }
        } while (i != 0);
        break;
      }
      if ((c2 != 0) && (c2 <= ' ')) {
        break;
      }
      c1 = c2;
    }
  }
  
  public final Object d()
  {
    char c2 = c();
    Object localObject;
    char c1;
    switch (c2)
    {
    default: 
      localObject = new StringBuffer();
      c1 = c2;
    case '"': 
    case '\'': 
      for (;;)
      {
        if ((c1 >= ' ') && (",:]}/\\\"[{;=#".indexOf(c1) < 0))
        {
          ((StringBuffer)localObject).append(c1);
          c1 = b();
          continue;
          localObject = new StringBuffer();
          c1 = b();
          switch (c1)
          {
          default: 
            if (c1 == c2) {
              localObject = ((StringBuffer)localObject).toString();
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      return localObject;
      throw a("Unterminated string");
      c1 = b();
      switch (c1)
      {
      default: 
        ((StringBuffer)localObject).append(c1);
        break;
      case 'b': 
        ((StringBuffer)localObject).append('\b');
        break;
      case 't': 
        ((StringBuffer)localObject).append('\t');
        break;
      case 'n': 
        ((StringBuffer)localObject).append('\n');
        break;
      case 'f': 
        ((StringBuffer)localObject).append('\f');
        break;
      case 'r': 
        ((StringBuffer)localObject).append('\r');
        break;
      case 'u': 
        ((StringBuffer)localObject).append((char)Integer.parseInt(a(4), 16));
        break;
      case 'x': 
        ((StringBuffer)localObject).append((char)Integer.parseInt(a(2), 16));
        break;
        ((StringBuffer)localObject).append(c1);
        break;
        a();
        localObject = new c(this);
        continue;
        a();
        localObject = new b(this);
        continue;
        a();
        localObject = ((StringBuffer)localObject).toString().trim();
        if (((String)localObject).equals("")) {
          throw a("Missing value");
        }
        if (((String)localObject).equalsIgnoreCase("true"))
        {
          localObject = Boolean.TRUE;
        }
        else if (((String)localObject).equalsIgnoreCase("false"))
        {
          localObject = Boolean.FALSE;
        }
        else if (((String)localObject).equalsIgnoreCase("null"))
        {
          localObject = c.a;
        }
        else if (((c2 >= '0') && (c2 <= '9')) || (c2 == '.') || (c2 == '-') || (c2 == '+'))
        {
          if (c2 == '0')
          {
            if ((((String)localObject).length() <= 2) || ((((String)localObject).charAt(1) != 'x') && (((String)localObject).charAt(1) != 'X'))) {
              break label610;
            }
            try
            {
              Integer localInteger1 = new java/lang/Integer;
              localInteger1.<init>(Integer.parseInt(((String)localObject).substring(2), 16));
              localObject = localInteger1;
            }
            catch (Exception localException1) {}
          }
          for (;;)
          {
            try
            {
              Integer localInteger2 = new java/lang/Integer;
              localInteger2.<init>((String)localObject);
              localObject = localInteger2;
            }
            catch (Exception localException2)
            {
              try
              {
                Long localLong = new java/lang/Long;
                localLong.<init>((String)localObject);
                localObject = localLong;
              }
              catch (Exception localException3)
              {
                try
                {
                  Double localDouble = new java/lang/Double;
                  localDouble.<init>((String)localObject);
                  localObject = localDouble;
                }
                catch (Exception localException4) {}
              }
            }
            break;
            try
            {
              label610:
              Integer localInteger3 = new Integer(Integer.parseInt((String)localObject, 8));
              localObject = localInteger3;
            }
            catch (Exception localException5) {}
          }
        }
        break;
      }
    }
  }
  
  public final String toString()
  {
    return " at character " + this.a;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */