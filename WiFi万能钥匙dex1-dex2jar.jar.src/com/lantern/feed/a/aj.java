package com.lantern.feed.a;

import android.util.SparseArray;
import com.lantern.feed.R.drawable;

public final class aj
{
  private static aj a;
  private SparseArray<a> b = new SparseArray();
  
  private aj()
  {
    a(0, -12303292, -10066330);
    a(1, -307894, -96382);
    a(2, -33024, -163840);
    a(1, -307894, -96382);
    a(3, -16348688, -8862978);
    a(5, -1, -1, R.drawable.feed_item_bg_black);
    a(6, 54327, 54327, R.drawable.feed_item_bg_black);
    a(7, -1, -1, R.drawable.feed_item_bg_redwhite);
    a(8, -12303292, -10066330, R.drawable.feed_item_bg_red);
    a(9, -307894, -307894, R.drawable.feed_item_bg_red);
    a(10, -33528, -33528, R.drawable.feed_item_bg_red);
    a(4, -1, -1, R.drawable.feed_item_bg_yellowwhite);
    a(11, -12303292, -10066330, R.drawable.feed_item_bg_yellow);
    a(12, -43179, -43179, R.drawable.feed_item_bg_yellow);
    a(13, -33536, 41728, R.drawable.feed_item_bg_yellowyellow);
    a(14, -16611856, -16611856, R.drawable.feed_item_bg_yellow);
    a(15, -1, -1, R.drawable.feed_item_bg_bluewhite);
    a(16, -12303292, -10066330, R.drawable.feed_item_bg_blue);
    a(17, -39168, -39168, R.drawable.feed_item_bg_blue);
    a(18, -16282895, -16282895, R.drawable.feed_item_bg_blue);
  }
  
  private a a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3, R.drawable.feed_item_bg);
  }
  
  private a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a locala = new a();
    locala.a = paramInt1;
    locala.b = paramInt2;
    locala.c = paramInt3;
    locala.d = paramInt4;
    this.b.put(locala.a, locala);
    return locala;
  }
  
  public static aj a()
  {
    if (a == null) {
      a = new aj();
    }
    return a;
  }
  
  public static int e(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return paramInt;
      paramInt = -90079;
      continue;
      paramInt = -39579;
      continue;
      paramInt = -11561745;
    }
  }
  
  public static int f(int paramInt)
  {
    int i = R.drawable.feed_distance_bg_blue;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return paramInt;
      paramInt = R.drawable.feed_distance_bg_blue;
      continue;
      paramInt = R.drawable.feed_distance_bg_white;
      continue;
      paramInt = R.drawable.feed_distance_bg_red;
      continue;
      paramInt = R.drawable.feed_distance_bg_yellow;
    }
  }
  
  public final int a(int paramInt)
  {
    a locala = (a)this.b.get(paramInt);
    if (locala != null) {}
    for (paramInt = locala.b;; paramInt = -12303292) {
      return paramInt;
    }
  }
  
  public final int b(int paramInt)
  {
    a locala = (a)this.b.get(paramInt);
    if (locala != null) {}
    for (paramInt = locala.b;; paramInt = -52179)
    {
      int i = paramInt;
      if (paramInt == -12303292) {
        i = -52179;
      }
      return i;
    }
  }
  
  public final int c(int paramInt)
  {
    a locala = (a)this.b.get(paramInt);
    if (locala != null) {}
    for (paramInt = locala.c;; paramInt = -10066330) {
      return paramInt;
    }
  }
  
  public final int d(int paramInt)
  {
    int i = R.drawable.feed_item_bg;
    a locala = (a)this.b.get(paramInt);
    if (locala != null) {}
    for (paramInt = locala.d;; paramInt = i) {
      return paramInt;
    }
  }
  
  static final class a
  {
    public int a = 0;
    public int b = -12303292;
    public int c = -10066330;
    public int d = R.drawable.feed_item_bg;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */