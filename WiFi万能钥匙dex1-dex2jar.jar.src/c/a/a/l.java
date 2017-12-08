package c.a.a;

import java.io.PrintStream;

public final class l
{
  private a[] a = new a[17];
  private boolean b = bk.a("verbosecompression");
  
  public final int a(bg parambg)
  {
    int j = parambg.hashCode();
    int i = -1;
    for (a locala = this.a[((j & 0x7FFFFFFF) % 17)]; locala != null; locala = locala.c) {
      if (locala.a.equals(parambg)) {
        i = locala.b;
      }
    }
    if (this.b) {
      System.err.println("Looking for " + parambg + ", found " + i);
    }
    return i;
  }
  
  public final void a(int paramInt, bg parambg)
  {
    if (paramInt > 16383) {}
    for (;;)
    {
      return;
      int i = (parambg.hashCode() & 0x7FFFFFFF) % 17;
      a locala = new a((byte)0);
      locala.a = parambg;
      locala.b = paramInt;
      locala.c = this.a[i];
      this.a[i] = locala;
      if (this.b) {
        System.err.println("Adding " + parambg + " at " + paramInt);
      }
    }
  }
  
  private static final class a
  {
    bg a;
    int b;
    a c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */