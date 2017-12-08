package com.lantern.browser.c;

import android.os.AsyncTask;
import com.bluefay.b.a;
import com.bluefay.b.h;
import java.util.Map;

public final class c
  extends AsyncTask<String, Integer, Integer>
{
  private String a;
  private Map<String, String> b;
  private a c;
  private String d;
  private long e = 10000L;
  
  public c(String paramString, Map<String, String> paramMap, a parama)
  {
    this.a = paramString;
    this.b = paramMap;
    this.c = parama;
  }
  
  private Integer a()
  {
    int i = 0;
    try
    {
      d locald = new com/lantern/browser/c/d;
      locald.<init>(this);
      locald.start();
      this.d = com.bluefay.b.d.a(this.a, this.b);
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
    return Integer.valueOf(i);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */