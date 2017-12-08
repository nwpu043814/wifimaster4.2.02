package com.lantern.browser.comment.c;

import com.lantern.browser.comment.b.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class l
  implements a.a
{
  l(a parama) {}
  
  public final void a()
  {
    a.o(this.a);
  }
  
  public final void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("newsId", a.a(this.a));
    com.lantern.analytics.a.e().onEvent("cmticocli", new JSONObject(localHashMap).toString());
    a.i(this.a);
  }
  
  public final void c()
  {
    a.n(this.a).show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */