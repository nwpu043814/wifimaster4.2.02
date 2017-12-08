package a.a.a;

public final class a
  extends Exception
{
  private Throwable a;
  
  public a(String paramString)
  {
    super(paramString);
  }
  
  public a(Throwable paramThrowable)
  {
    super(paramThrowable.getMessage());
    this.a = paramThrowable;
  }
  
  public final Throwable getCause()
  {
    return this.a;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */