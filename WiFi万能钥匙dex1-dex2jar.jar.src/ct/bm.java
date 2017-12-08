package ct;

import android.os.Bundle;

public abstract class bm
{
  private String a;
  private String b;
  private boolean c;
  
  public bm(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = true;
  }
  
  public void a() {}
  
  protected abstract boolean a(Bundle paramBundle);
  
  public final boolean b(Bundle paramBundle)
  {
    if (!this.c) {}
    for (boolean bool = false;; bool = a(paramBundle)) {
      return bool;
    }
  }
  
  public String toString()
  {
    return "[name=" + this.a + ",desc=" + this.b + ",enabled=" + this.c + "]";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */