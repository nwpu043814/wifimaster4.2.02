package com.lantern.feed.a;

import android.os.AsyncTask;
import com.bluefay.b.a;
import com.bluefay.b.d;

public final class g
  extends AsyncTask<String, Integer, Integer>
{
  private String a;
  private a b;
  private String c;
  private long d = 5000L;
  
  public g(String paramString)
  {
    this.a = paramString;
  }
  
  public g(String paramString, a parama)
  {
    this.a = paramString;
    this.b = parama;
  }
  
  public g(String paramString, a parama, byte paramByte)
  {
    this.a = paramString;
    this.b = parama;
    this.d = -1L;
  }
  
  private Integer a()
  {
    int i = 0;
    try
    {
      if (this.d > 0L)
      {
        h localh = new com/lantern/feed/a/h;
        localh.<init>(this);
        localh.start();
      }
      this.c = d.b(this.a);
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.bluefay.b.h.a(localException);
      }
    }
    return Integer.valueOf(i);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */