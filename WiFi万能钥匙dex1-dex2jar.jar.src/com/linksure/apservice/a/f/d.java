package com.linksure.apservice.a.f;

import com.linksure.apservice.b.e.a;
import com.linksure.apservice.b.g;
import com.linksure.apservice.b.h;
import com.linksure.apservice.b.i;
import com.linksure.apservice.b.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  public static com.linksure.apservice.b.a a(com.linksure.apservice.a.d.a parama)
  {
    com.linksure.apservice.b.a locala = new com.linksure.apservice.b.a();
    locala.a = parama.c;
    locala.k = parama.a;
    locala.l = parama.b;
    locala.e = parama.g;
    locala.f = parama.h;
    locala.g = parama.i;
    locala.h = parama.j;
    locala.i = parama.k;
    locala.c = parama.e;
    locala.n = parama.o;
    locala.p = parama.p;
    locala.o = parama.q;
    locala.d = parama.l;
    locala.j = parama.f;
    locala.b = parama.d;
    locala.q = parama.r;
    locala.r = parama.s;
    locala.s = parama.t;
    if ((parama.n != null) && (parama.n.size() > 0))
    {
      int j = parama.n.size();
      for (int i = 0; i < j; i++) {
        locala.a(a((com.linksure.apservice.a.d.e)parama.n.get(i), -1, i));
      }
    }
    return locala;
  }
  
  private static h a(com.linksure.apservice.a.d.e parame, int paramInt1, int paramInt2)
  {
    if (parame == null) {}
    h localh;
    for (parame = null;; parame = localh)
    {
      return parame;
      localh = new h();
      localh.c = parame.b;
      localh.d = parame.c;
      localh.a = paramInt1;
      localh.b = paramInt2;
      if ((parame.d != null) && (parame.d.size() > 0))
      {
        int i = parame.d.size();
        for (paramInt1 = 0; paramInt1 < i; paramInt1++) {
          localh.a(a((com.linksure.apservice.a.d.e)parame.d.get(paramInt1), paramInt2, paramInt1));
        }
      }
    }
  }
  
  public static i a(com.linksure.apservice.a.d.f paramf)
  {
    Object localObject;
    boolean bool;
    if (paramf.b == 2)
    {
      localObject = new com.linksure.apservice.b.f();
      ((i)localObject).e = paramf.a;
      ((i)localObject).g = paramf.b;
      ((i)localObject).f = paramf.c;
      if (paramf.f != 1) {
        break label187;
      }
      bool = true;
      label50:
      ((i)localObject).h = bool;
      ((i)localObject).j = paramf.d;
      ((i)localObject).i = paramf.g;
      if (paramf.b == 1) {
        break label355;
      }
      if (paramf.b != 2) {
        break label192;
      }
      paramf = a(paramf.d);
      ((com.linksure.apservice.b.f)localObject).a = paramf[0];
      ((com.linksure.apservice.b.f)localObject).b = paramf[1];
    }
    for (;;)
    {
      return (i)localObject;
      if (paramf.b == 5)
      {
        localObject = new g();
        break;
      }
      if (paramf.b == 7)
      {
        localObject = new com.linksure.apservice.b.e();
        break;
      }
      if (paramf.b == 8)
      {
        localObject = new j();
        break;
      }
      localObject = new i();
      break;
      label187:
      bool = false;
      break label50;
      label192:
      if (paramf.b == 5)
      {
        paramf = b(paramf.d);
        ((g)localObject).a = paramf[0];
        ((g)localObject).b = paramf[1];
        ((g)localObject).c = paramf[2];
        ((g)localObject).d = paramf[3];
      }
      else if (paramf.b == 7)
      {
        paramf = d(paramf.d);
        if ((paramf != null) && (paramf.length == 1)) {
          ((i)localObject).g = 14;
        }
        ((com.linksure.apservice.b.e)localObject).b = paramf;
      }
      else if (paramf.b == 8)
      {
        paramf = c(paramf.d);
        ((j)localObject).a = paramf[0];
        ((j)localObject).b = paramf[1];
        ((j)localObject).c = paramf[2];
        ((j)localObject).d = paramf[3];
      }
      else
      {
        label355:
        ((i)localObject).j = paramf.d;
      }
    }
  }
  
  public static <T, F> List<T> a(List<F> paramList)
  {
    if (paramList.isEmpty()) {}
    ArrayList localArrayList;
    for (paramList = Collections.EMPTY_LIST;; paramList = localArrayList)
    {
      return paramList;
      localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = paramList.next();
        if ((localObject1 instanceof com.linksure.apservice.a.d.a))
        {
          localArrayList.add(a((com.linksure.apservice.a.d.a)localObject1));
        }
        else if ((localObject1 instanceof com.linksure.apservice.a.d.f))
        {
          localArrayList.add(a((com.linksure.apservice.a.d.f)localObject1));
        }
        else
        {
          Object localObject2;
          if ((localObject1 instanceof com.linksure.apservice.a.d.b))
          {
            localObject2 = (com.linksure.apservice.a.d.b)localObject1;
            localObject1 = new com.linksure.apservice.b.b();
            ((com.linksure.apservice.b.b)localObject1).a = ((com.linksure.apservice.a.d.b)localObject2).a;
            ((com.linksure.apservice.b.b)localObject1).b = ((com.linksure.apservice.a.d.b)localObject2).b;
            ((com.linksure.apservice.b.b)localObject1).c = ((com.linksure.apservice.a.d.b)localObject2).c;
            ((com.linksure.apservice.b.b)localObject1).d = ((com.linksure.apservice.a.d.b)localObject2).d;
            localArrayList.add(localObject1);
          }
          else if ((localObject1 instanceof com.linksure.apservice.a.d.c))
          {
            localObject2 = (com.linksure.apservice.a.d.c)localObject1;
            localObject1 = new com.linksure.apservice.b.c();
            ((com.linksure.apservice.b.c)localObject1).a = ((com.linksure.apservice.a.d.c)localObject2).a;
            ((com.linksure.apservice.b.c)localObject1).b = ((com.linksure.apservice.a.d.c)localObject2).b;
            ((com.linksure.apservice.b.c)localObject1).c = ((com.linksure.apservice.a.d.c)localObject2).c;
            ((com.linksure.apservice.b.c)localObject1).d = ((com.linksure.apservice.a.d.c)localObject2).d;
            ((com.linksure.apservice.b.c)localObject1).e = ((com.linksure.apservice.a.d.c)localObject2).e;
            ((com.linksure.apservice.b.c)localObject1).f = ((com.linksure.apservice.a.d.c)localObject2).f;
            ((com.linksure.apservice.b.c)localObject1).g = ((com.linksure.apservice.a.d.c)localObject2).g;
            ((com.linksure.apservice.b.c)localObject1).h = ((com.linksure.apservice.a.d.c)localObject2).h;
            ((com.linksure.apservice.b.c)localObject1).i = ((com.linksure.apservice.a.d.c)localObject2).i;
            ((com.linksure.apservice.b.c)localObject1).j = ((com.linksure.apservice.a.d.c)localObject2).j;
            ((com.linksure.apservice.b.c)localObject1).k = ((com.linksure.apservice.a.d.c)localObject2).k;
            localArrayList.add(localObject1);
          }
          else
          {
            throw new RuntimeException("don't support type :" + localObject1.getClass());
          }
        }
      }
    }
  }
  
  private static String[] a(String paramString)
  {
    String[] arrayOfString = new String[2];
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      arrayOfString[0] = localJSONObject.optString("thumb");
      arrayOfString[1] = localJSONObject.optString("origin");
      return arrayOfString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static String[] b(String paramString)
  {
    String[] arrayOfString = new String[4];
    for (;;)
    {
      try
      {
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        arrayOfString[0] = localJSONObject.optString("title");
        arrayOfString[1] = localJSONObject.optString("image");
        arrayOfString[2] = localJSONObject.optString("link");
        if (!localJSONObject.isNull("pageId")) {
          continue;
        }
        arrayOfString[3] = "0";
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        continue;
      }
      return arrayOfString;
      arrayOfString[3] = localJSONObject.optString("pageId");
    }
  }
  
  private static String[] c(String paramString)
  {
    String[] arrayOfString = new String[4];
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      arrayOfString[0] = localJSONObject.optString("title");
      arrayOfString[1] = localJSONObject.optString("content");
      arrayOfString[2] = localJSONObject.optString("summary");
      arrayOfString[3] = localJSONObject.optString("url");
      return arrayOfString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static e.a[] d(String paramString)
  {
    Object localObject2 = null;
    e.a locala = null;
    localObject1 = locala;
    try
    {
      Object localObject3 = new org/json/JSONObject;
      localObject1 = locala;
      ((JSONObject)localObject3).<init>(paramString);
      localObject1 = locala;
      localObject3 = ((JSONObject)localObject3).optJSONArray("pageList");
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = locala;
        int j = ((JSONArray)localObject3).length();
        localObject1 = locala;
        paramString = new e.a[j];
        for (int i = 0;; i++)
        {
          localObject1 = paramString;
          if (i >= j) {
            break;
          }
          localObject1 = paramString;
          locala = new com/linksure/apservice/b/e$a;
          localObject1 = paramString;
          locala.<init>();
          localObject1 = paramString;
          locala.a = ((JSONArray)localObject3).getJSONObject(i).optString("content");
          localObject1 = paramString;
          locala.b = ((JSONArray)localObject3).getJSONObject(i).optString("coverImg");
          localObject1 = paramString;
          locala.c = ((JSONArray)localObject3).getJSONObject(i).optString("pageId");
          localObject1 = paramString;
          locala.d = ((JSONArray)localObject3).getJSONObject(i).optString("summary");
          localObject1 = paramString;
          locala.e = ((JSONArray)localObject3).getJSONObject(i).optString("title");
          paramString[i] = locala;
        }
      }
      return (e.a[])localObject1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */