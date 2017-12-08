package com.alipay.android.a.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

public final class y
  extends ad
{
  private String b;
  private byte[] c;
  private String d;
  private ArrayList e;
  private Map f;
  private boolean g;
  
  public y(String paramString)
  {
    this.b = paramString;
    this.e = new ArrayList();
    this.f = new HashMap();
    this.d = "application/x-www-form-urlencoded";
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final void a(String paramString)
  {
    this.d = paramString;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    this.f.put(paramString1, paramString2);
  }
  
  public final void a(Header paramHeader)
  {
    this.e.add(paramHeader);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public final String b(String paramString)
  {
    if (this.f == null) {}
    for (paramString = null;; paramString = (String)this.f.get(paramString)) {
      return paramString;
    }
  }
  
  public final byte[] b()
  {
    return this.c;
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final ArrayList d()
  {
    return this.e;
  }
  
  public final boolean e()
  {
    return this.g;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (paramObject == null)
      {
        bool = false;
      }
      else if (getClass() != paramObject.getClass())
      {
        bool = false;
      }
      else
      {
        paramObject = (y)paramObject;
        if (this.c == null)
        {
          if (((y)paramObject).c != null) {
            bool = false;
          }
        }
        else if (!this.c.equals(((y)paramObject).c))
        {
          bool = false;
          continue;
        }
        if (this.b == null)
        {
          if (((y)paramObject).b != null) {
            bool = false;
          }
        }
        else if (!this.b.equals(((y)paramObject).b)) {
          bool = false;
        }
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = j;
    if (this.f != null)
    {
      i = j;
      if (this.f.containsKey("id")) {
        i = ((String)this.f.get("id")).hashCode() + 31;
      }
    }
    if (this.b == null) {}
    for (j = 0;; j = this.b.hashCode()) {
      return j + i * 31;
    }
  }
  
  public final String toString()
  {
    return String.format("Url : %s,HttpHeader: %s", new Object[] { this.b, this.e });
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */