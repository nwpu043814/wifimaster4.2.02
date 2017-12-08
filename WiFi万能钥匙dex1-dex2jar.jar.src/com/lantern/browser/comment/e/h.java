package com.lantern.browser.comment.e;

import com.bluefay.b.d;
import com.lantern.core.c;
import com.lantern.core.f;
import com.lantern.core.o;
import java.util.HashMap;

public final class h
  extends Thread
{
  private String a;
  private String b;
  private int c;
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
  }
  
  public final void run()
  {
    HashMap localHashMap = c.getServer().s();
    localHashMap.put("newsId", this.a);
    localHashMap.put("commentId", this.b);
    localHashMap.put("upDown", "1");
    localHashMap.put("sequence", String.valueOf(this.c));
    String str = f.b();
    if (str != null) {}
    for (str = String.format("%s%s", new Object[] { str, "/comment/comment/updown.do" });; str = String.format("%s%s", new Object[] { "http://comment.51y5.net", "/comment/comment/updown.do" }))
    {
      com.bluefay.b.h.a(d.a(str, localHashMap), new Object[0]);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */