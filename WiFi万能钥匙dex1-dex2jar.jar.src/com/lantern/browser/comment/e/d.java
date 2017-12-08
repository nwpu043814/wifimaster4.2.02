package com.lantern.browser.comment.e;

import android.os.AsyncTask;
import com.lantern.browser.comment.d.f;
import com.lantern.browser.comment.d.h;
import com.lantern.browser.comment.d.i;
import com.lantern.browser.comment.d.j;
import com.lantern.browser.comment.d.l;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends AsyncTask<Void, Void, Void>
{
  private String a;
  private int b;
  private com.bluefay.b.a c;
  private int d;
  private String e;
  private Object f;
  
  public d(String paramString, int paramInt, com.bluefay.b.a parama)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = parama;
  }
  
  private Void a()
  {
    Object localObject1 = c.getServer().s();
    ((HashMap)localObject1).put("newsId", this.a);
    ((HashMap)localObject1).put("pageSize", "20");
    if (c.getServer().j())
    {
      ((HashMap)localObject1).put("from", "reply");
      if (this.b > 0) {
        ((HashMap)localObject1).put("pos", String.valueOf(this.b));
      }
    }
    Object localObject3 = com.bluefay.b.d.a(com.lantern.browser.a.a(), (Map)localObject1);
    this.d = 0;
    try
    {
      localObject1 = new org/json/JSONObject;
      ((JSONObject)localObject1).<init>((String)localObject3);
      if (!"0".equals(((JSONObject)localObject1).optString("retCd"))) {
        break label299;
      }
      this.d = 1;
      localObject3 = new com/lantern/browser/comment/d/h;
      ((h)localObject3).<init>();
      ((h)localObject3).a(this.a);
      localObject1 = ((JSONObject)localObject1).optJSONObject("result");
      ((h)localObject3).a(((JSONObject)localObject1).optInt("replyCount"));
      List localList = l.a((JSONObject)localObject1, "replyComments", this.a);
      if ((localList != null) && (!localList.isEmpty())) {
        ((h)localObject3).a(localList);
      }
      localList = l.a((JSONObject)localObject1, "hotComments", this.a);
      if ((localList != null) && (!localList.isEmpty())) {
        ((h)localObject3).c(localList);
      }
      localObject1 = l.a((JSONObject)localObject1, "recentComments", this.a);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        ((h)localObject3).b((List)localObject1);
      }
      localObject1 = com.lantern.browser.comment.a.a.a(this.a);
      if (localObject1 == null) {
        break label312;
      }
      localObject1 = a((List)localObject1, this.a);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label287:
        continue;
        this.e = localException.getString("retMsg");
        continue;
        Object localObject2 = null;
      }
    }
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (((h)localObject3).c() == null) {
        break label287;
      }
      ((h)localObject3).c().addAll(0, (Collection)localObject1);
    }
    for (;;)
    {
      this.f = localObject3;
      return null;
      ((h)localObject3).b((List)localObject1);
    }
  }
  
  private static List<i> a(List<f> paramList, String paramString)
  {
    i locali = null;
    Object localObject1 = locali;
    if (paramList != null)
    {
      localObject1 = locali;
      if (!paramList.isEmpty())
      {
        localObject1 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject3 = (f)paramList.next();
          locali = new i();
          String str = ((f)localObject3).j();
          try
          {
            ArrayList localArrayList = new java/util/ArrayList;
            localArrayList.<init>();
            Object localObject2 = new org/json/JSONArray;
            ((JSONArray)localObject2).<init>(str);
            int j = ((JSONArray)localObject2).length();
            if (j > 0) {
              for (int i = 0; i < j; i++)
              {
                localObject3 = new org/json/JSONObject;
                ((JSONObject)localObject3).<init>(((JSONArray)localObject2).optString(i));
                localArrayList.add(l.a((JSONObject)localObject3));
              }
            }
            localObject2 = new com/lantern/browser/comment/d/j;
            ((j)localObject2).<init>();
            ((j)localObject2).f(((f)localObject3).g());
            ((j)localObject2).b(((f)localObject3).h());
            ((j)localObject2).e(p.b(null));
            ((j)localObject2).d(((f)localObject3).e());
            ((j)localObject2).c(((f)localObject3).f());
            ((j)localObject2).e(2);
            ((j)localObject2).d(-1);
            ((j)localObject2).a(System.currentTimeMillis());
            localArrayList.add(localObject2);
            locali.a(paramString);
            locali.a(localArrayList);
            ((List)localObject1).add(locali);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return (List<i>)localObject1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */