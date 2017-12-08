package com.lantern.browser;

import android.widget.ProgressBar;

public final class bd
{
  private static boolean a;
  private static boolean b;
  private static int c = 0;
  private static ProgressBar d;
  private static a e;
  
  public static void a()
  {
    c = 0;
    b = false;
    if (!a)
    {
      a = true;
      new be().start();
    }
  }
  
  public static void a(ProgressBar paramProgressBar, a parama)
  {
    d = paramProgressBar;
    e = parama;
  }
  
  public static void b()
  {
    b = true;
    d.setVisibility(4);
  }
  
  public static abstract class a
  {
    public void a(int paramInt) {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */