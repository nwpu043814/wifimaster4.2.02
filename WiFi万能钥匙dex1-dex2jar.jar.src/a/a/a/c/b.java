package a.a.a.c;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class b
{
  private c a;
  public String h;
  public String i;
  public String j = "WAIT";
  public int k;
  public Map<String, String> l;
  public String m;
  public Map<String, List<String>> n;
  
  public b(c paramc)
  {
    this.a = paramc;
    System.out.println("peter startUPload File Aentity construtor");
    a();
    this.l = new HashMap();
    this.n = new HashMap();
  }
  
  protected abstract void a();
  
  protected abstract void d();
  
  public abstract String e();
  
  public abstract void f();
  
  public final void h()
  {
    if (this.a != null) {
      this.a.a(this);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/a/a/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */