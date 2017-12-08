package c.a.a;

import java.util.HashMap;

class av
{
  private static Integer[] a = new Integer[64];
  private HashMap b;
  private HashMap c;
  private String d;
  private int e;
  private String f;
  private int g;
  private boolean h;
  
  static
  {
    for (int i = 0; i < a.length; i++) {
      a[i] = new Integer(i);
    }
  }
  
  public av(String paramString, int paramInt)
  {
    this.d = paramString;
    this.e = paramInt;
    this.b = new HashMap();
    this.c = new HashMap();
    this.g = Integer.MAX_VALUE;
  }
  
  private String b(String paramString)
  {
    String str;
    if (this.e == 2) {
      str = paramString.toUpperCase();
    }
    for (;;)
    {
      return str;
      str = paramString;
      if (this.e == 3) {
        str = paramString.toLowerCase();
      }
    }
  }
  
  public static Integer c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a.length)) {}
    for (Integer localInteger = a[paramInt];; localInteger = new Integer(paramInt)) {
      return localInteger;
    }
  }
  
  public final void a()
  {
    this.h = true;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.g)) {
      throw new IllegalArgumentException(this.d + " " + paramInt + "is out of range");
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    a(paramInt);
    Integer localInteger = c(paramInt);
    paramString = b(paramString);
    this.b.put(paramString, localInteger);
    this.c.put(localInteger, paramString);
  }
  
  public final void a(av paramav)
  {
    if (this.e != paramav.e) {
      throw new IllegalArgumentException(paramav.d + ": wordcases do not match");
    }
    this.b.putAll(paramav.b);
    this.c.putAll(paramav.c);
  }
  
  public final void a(String paramString)
  {
    this.f = b(paramString);
  }
  
  public final void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void b(int paramInt, String paramString)
  {
    a(paramInt);
    Integer localInteger = c(paramInt);
    paramString = b(paramString);
    this.b.put(paramString, localInteger);
  }
  
  public final String d(int paramInt)
  {
    a(paramInt);
    Object localObject = (String)this.c.get(c(paramInt));
    if (localObject != null) {}
    for (;;)
    {
      return (String)localObject;
      String str = Integer.toString(paramInt);
      localObject = str;
      if (this.f != null) {
        localObject = this.f + str;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */