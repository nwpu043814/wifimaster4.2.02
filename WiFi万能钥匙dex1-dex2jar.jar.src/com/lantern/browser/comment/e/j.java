package com.lantern.browser.comment.e;

import android.text.TextUtils;
import com.bluefay.a.e;
import com.bluefay.b.d;
import com.lantern.browser.comment.a.a;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private static Object a = new Object();
  private static j c;
  private ExecutorService b = Executors.newSingleThreadExecutor();
  
  public static final j a()
  {
    if (c == null) {}
    synchronized (a)
    {
      if (c == null)
      {
        j localj = new com/lantern/browser/comment/e/j;
        localj.<init>();
        c = localj;
      }
      return c;
    }
  }
  
  public final void b()
  {
    synchronized (a)
    {
      ExecutorService localExecutorService = this.b;
      a locala = new com/lantern/browser/comment/e/j$a;
      locala.<init>((byte)0);
      localExecutorService.submit(locala);
      return;
    }
  }
  
  private static final class a
    implements Runnable
  {
    public final void run()
    {
      if (!e.c(c.getInstance())) {}
      List localList;
      do
      {
        return;
        localList = a.a();
      } while ((localList == null) || (localList.isEmpty()));
      Object localObject2 = c.getServer().s();
      for (int i = 0; i < localList.size(); i++)
      {
        localObject1 = (com.lantern.browser.comment.d.f)localList.get(i);
        String str2 = "list[" + i + "].";
        ((HashMap)localObject2).put(str2 + "nickname", ((com.lantern.browser.comment.d.f)localObject1).f());
        ((HashMap)localObject2).put(str2 + "newsId", ((com.lantern.browser.comment.d.f)localObject1).b());
        ((HashMap)localObject2).put(str2 + "comment", ((com.lantern.browser.comment.d.f)localObject1).h());
        ((HashMap)localObject2).put(str2 + "title", ((com.lantern.browser.comment.d.f)localObject1).d());
        ((HashMap)localObject2).put(str2 + "url", ((com.lantern.browser.comment.d.f)localObject1).c());
        ((HashMap)localObject2).put(str2 + "uhid", ((com.lantern.browser.comment.d.f)localObject1).e());
        ((HashMap)localObject2).put(str2 + "dhid", p.b(""));
        int j = ((com.lantern.browser.comment.d.f)localObject1).i();
        if (j > 0) {
          ((HashMap)localObject2).put(str2 + "sequence", String.valueOf(j));
        }
      }
      Object localObject1 = com.lantern.core.f.b();
      if (localObject1 != null) {}
      String str1;
      for (localObject1 = String.format("%s%s", new Object[] { localObject1, "/comment/comment/writeList.do" });; str1 = String.format("%s%s", new Object[] { "http://comment.51y5.net", "/comment/comment/writeList.do" }))
      {
        localObject2 = d.a((String)localObject1, (Map)localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        try
        {
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>((String)localObject2);
          if (!"0".equals(((JSONObject)localObject1).optString("retCd"))) {
            break;
          }
          a.b();
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        break;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */