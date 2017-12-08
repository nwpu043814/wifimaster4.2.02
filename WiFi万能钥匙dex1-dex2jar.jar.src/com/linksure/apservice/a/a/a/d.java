package com.linksure.apservice.a.a.a;

public abstract class d<T>
{
  private static final d d = new e();
  public int a = -1;
  public String b;
  public T c;
  
  private static d a(Class<? extends d> paramClass)
  {
    try
    {
      paramClass = (d)paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = d;
      }
    }
  }
  
  public static d a(String paramString, Class<? extends d> paramClass)
  {
    paramClass = a(paramClass);
    paramClass.a(paramString);
    return paramClass;
  }
  
  public abstract void a(String paramString);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */