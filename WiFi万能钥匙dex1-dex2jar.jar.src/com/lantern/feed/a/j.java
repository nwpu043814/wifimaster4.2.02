package com.lantern.feed.a;

import android.os.AsyncTask;
import com.bluefay.b.a;
import com.bluefay.b.d;
import com.bluefay.b.h;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends AsyncTask<String, Integer, Integer>
{
  private String a;
  private Map<String, String> b;
  private a c;
  private String d;
  private long e = 10000L;
  
  public j(String paramString, Map<String, String> paramMap)
  {
    this.a = paramString;
    this.b = paramMap;
  }
  
  public j(String paramString, Map<String, String> paramMap, a parama)
  {
    this.a = paramString;
    this.b = paramMap;
    this.c = parama;
  }
  
  public j(String paramString, Map<String, String> paramMap, a parama, byte paramByte)
  {
    this.a = paramString;
    this.b = paramMap;
    this.c = parama;
    this.e = 30000L;
  }
  
  private Integer a()
  {
    int i = 0;
    try
    {
      if (this.e > 0L)
      {
        k localk = new com/lantern/feed/a/k;
        localk.<init>(this);
        localk.start();
      }
      this.d = d.a(this.a, this.b);
      h.a("WkFeedHttpPostTask data received", new Object[0]);
      new JSONObject(this.d);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */