package com.linksure.apservice.a.d.a;

public class b
  extends RuntimeException
{
  private int a;
  
  public b(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public b(Exception paramException) {}
  
  public b(String paramString)
  {
    super(paramString);
  }
  
  public b(String paramString, Exception paramException)
  {
    super(paramString, paramException);
    if ((paramException instanceof b)) {
      this.a = ((b)paramException).a;
    }
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/d/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */