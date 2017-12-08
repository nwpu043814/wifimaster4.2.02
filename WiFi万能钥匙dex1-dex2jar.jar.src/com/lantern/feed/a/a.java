package com.lantern.feed.a;

import android.os.AsyncTask;
import com.bluefay.b.h;
import java.io.UnsupportedEncodingException;

public final class a
  extends AsyncTask<String, Integer, Integer>
{
  private String a;
  private com.bluefay.b.a b;
  private String c;
  private long d = 5000L;
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  private Integer a()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.d > 0L)
        {
          localObject = new com/lantern/feed/a/b;
          ((b)localObject).<init>(this);
          ((Thread)localObject).start();
        }
        localObject = new com/lantern/feed/d/a;
        ((com.lantern.feed.d.a)localObject).<init>(this.a);
        ((com.lantern.feed.d.a)localObject).d();
        localObject = ((com.lantern.feed.d.a)localObject).c();
        if ((localObject != null) && (localObject.length != 0)) {
          continue;
        }
        this.c = "";
        i = 1;
      }
      catch (Exception localException)
      {
        Object localObject;
        h.a(localException);
        continue;
      }
      return Integer.valueOf(i);
      try
      {
        String str = new java/lang/String;
        str.<init>((byte[])localObject, "UTF-8");
        this.c = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        h.a(localUnsupportedEncodingException);
        this.c = "";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */