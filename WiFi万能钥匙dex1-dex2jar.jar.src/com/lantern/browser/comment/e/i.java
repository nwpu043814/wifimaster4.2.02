package com.lantern.browser.comment.e;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.a.e;
import com.bluefay.b.d;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends AsyncTask<Void, Integer, Void>
{
  private int a;
  private String b;
  private String c;
  private String d;
  private com.lantern.browser.comment.d.j e;
  private List<com.lantern.browser.comment.d.j> f;
  private a g;
  private int h;
  private String i;
  
  public i(String paramString1, String paramString2, String paramString3, int paramInt, com.lantern.browser.comment.d.j paramj, List<com.lantern.browser.comment.d.j> paramList, a parama)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.a = paramInt;
    this.e = paramj;
    this.f = paramList;
    this.g = parama;
  }
  
  public i(String paramString1, String paramString2, String paramString3, com.lantern.browser.comment.d.j paramj, a parama)
  {
    this(paramString1, paramString2, paramString3, -1, paramj, null, parama);
  }
  
  private Void a()
  {
    Object localObject2 = new com.lantern.browser.comment.d.f();
    ((com.lantern.browser.comment.d.f)localObject2).g(this.e.k());
    ((com.lantern.browser.comment.d.f)localObject2).h(this.e.b());
    ((com.lantern.browser.comment.d.f)localObject2).b(this.e.d());
    ((com.lantern.browser.comment.d.f)localObject2).b(this.b);
    ((com.lantern.browser.comment.d.f)localObject2).c(this.d);
    ((com.lantern.browser.comment.d.f)localObject2).d(this.c);
    ((com.lantern.browser.comment.d.f)localObject2).f(this.e.c());
    ((com.lantern.browser.comment.d.f)localObject2).a(this.a);
    ((com.lantern.browser.comment.d.f)localObject2).e(this.e.i());
    String str = UUID.randomUUID().toString();
    ((com.lantern.browser.comment.d.f)localObject2).a(str);
    Object localObject1 = new JSONArray();
    if (this.f != null)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject1).put(((com.lantern.browser.comment.d.j)localIterator.next()).r());
      }
    }
    ((JSONArray)localObject1).put(this.e.r());
    ((com.lantern.browser.comment.d.f)localObject2).i(((JSONArray)localObject1).toString());
    com.lantern.browser.comment.a.a.a((com.lantern.browser.comment.d.f)localObject2);
    publishProgress(new Integer[] { Integer.valueOf(50) });
    if (!e.c(c.getInstance())) {
      this.h = 10;
    }
    for (;;)
    {
      return null;
      localObject2 = c.getServer().s();
      ((HashMap)localObject2).put("nickname", p.d(c.getAppContext()));
      ((HashMap)localObject2).put("newsId", this.b);
      ((HashMap)localObject2).put("comment", this.e.b());
      ((HashMap)localObject2).put("title", this.c);
      ((HashMap)localObject2).put("url", this.d);
      if (this.a > 0) {
        ((HashMap)localObject2).put("sequence", String.valueOf(this.a));
      }
      localObject1 = com.lantern.core.f.b();
      if (localObject1 != null)
      {
        localObject1 = String.format("%s%s", new Object[] { localObject1, "/comment/comment/write.do" });
        label337:
        localObject1 = d.a((String)localObject1, (Map)localObject2);
        this.h = 0;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>((String)localObject1);
        com.lantern.browser.comment.a.a.c(str);
        if ("0".equals(((JSONObject)localObject2).optString("retCd")))
        {
          this.h = 1;
          localObject1 = ((JSONObject)localObject2).optString("commentId");
          this.e.a((String)localObject1);
        }
        while (this.h == 1)
        {
          j.a().b();
          break;
          localObject1 = String.format("%s%s", new Object[] { "http://comment.51y5.net", "/comment/comment/write.do" });
          break label337;
          this.i = ((JSONObject)localObject2).getString("retMsg");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public static abstract interface a
    extends com.bluefay.b.a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */