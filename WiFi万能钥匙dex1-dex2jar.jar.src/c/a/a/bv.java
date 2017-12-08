package c.a.a;

final class bv
  extends Thread
{
  private au a;
  private Object b;
  private by c;
  private bw d;
  
  public bv(bw parambw, au paramau, Object paramObject, by paramby)
  {
    this.d = parambw;
    this.a = paramau;
    this.b = paramObject;
    this.c = paramby;
  }
  
  public final void run()
  {
    try
    {
      au localau = this.d.a(this.a);
      this.c.a(localau);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.c.a(this.b, localException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */