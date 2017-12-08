package com.linksure.apservice.ui.home.keyboard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static List<a> a = new ArrayList();
  
  private static void a(int paramInt, String paramString)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt, paramString);
    }
  }
  
  public static void a(a parama)
  {
    a.add(parama);
  }
  
  public static void a(String paramString)
  {
    a(1, paramString);
  }
  
  public static void b(a parama)
  {
    a.remove(parama);
  }
  
  public static void b(String paramString)
  {
    a(2, paramString);
  }
  
  static abstract interface a
  {
    public abstract void a(int paramInt, String paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/keyboard/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */