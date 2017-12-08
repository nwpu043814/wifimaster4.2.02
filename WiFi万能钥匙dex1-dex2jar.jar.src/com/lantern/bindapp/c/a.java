package com.lantern.bindapp.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bluefay.a.b;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static com.lantern.bindapp.a.a a(Context paramContext, List<com.lantern.bindapp.a.a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      h.a("list is empty", new Object[0]);
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label141;
        }
        com.lantern.bindapp.a.a locala = (com.lantern.bindapp.a.a)localIterator.next();
        long l = locala.j;
        if ((l == 0L) || (l >= System.currentTimeMillis()))
        {
          paramList = locala;
          if (!b.a(paramContext, locala.b)) {
            break;
          }
          h.a("is isntalled:%s", new Object[] { locala.b });
          continue;
        }
        h.a("end time, item is not best." + locala.toString(), new Object[0]);
      }
      label141:
      paramList = null;
    }
  }
  
  public static com.lantern.bindapp.a.a a(ArrayList<com.lantern.bindapp.a.a> paramArrayList, com.lantern.bindapp.a.a parama)
  {
    if ((parama == null) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      paramArrayList = null;
      return paramArrayList;
    }
    for (;;)
    {
      com.lantern.bindapp.a.a locala;
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          locala = (com.lantern.bindapp.a.a)localIterator.next();
          paramArrayList = locala;
          if (locala.equals(parama)) {
            break;
          }
          if (!parama.a.equals(locala.a)) {
            break label101;
          }
          paramArrayList = locala;
          if (parama.k <= 0L) {
            break;
          }
          locala.k = parama.k;
          paramArrayList = locala;
        }
      }
      catch (Exception paramArrayList)
      {
        h.a(paramArrayList);
        paramArrayList = null;
      }
      break;
      label101:
      locala.b.equalsIgnoreCase(parama.b);
    }
  }
  
  public static ArrayList<com.lantern.bindapp.a.a> a()
  {
    Object localObject1 = null;
    Object localObject2 = p.a("bind_app", "item_list", "");
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      return (ArrayList<com.lantern.bindapp.a.a>)localObject1;
      try
      {
        JSONArray localJSONArray = new org/json/JSONArray;
        localJSONArray.<init>((String)localObject2);
        localObject2 = a(localJSONArray);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        h.a(localException);
      }
    }
  }
  
  public static ArrayList<com.lantern.bindapp.a.a> a(ArrayList<com.lantern.bindapp.a.a> paramArrayList1, ArrayList<com.lantern.bindapp.a.a> paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    for (;;)
    {
      return paramArrayList2;
      Object localObject1;
      Object localObject3;
      try
      {
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>(paramArrayList1);
        if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
        {
          Iterator localIterator = paramArrayList2.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label138;
            }
            com.lantern.bindapp.a.a locala = (com.lantern.bindapp.a.a)localIterator.next();
            localObject3 = paramArrayList1.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject2 = (com.lantern.bindapp.a.a)((Iterator)localObject3).next();
              if ((!locala.a.equals(((com.lantern.bindapp.a.a)localObject2).a)) || (((com.lantern.bindapp.a.a)localObject2).k <= 0L)) {
                break;
              }
              locala.k = ((com.lantern.bindapp.a.a)localObject2).k;
              ((ArrayList)localObject1).remove(localObject2);
            }
          }
        }
      }
      catch (Exception paramArrayList1)
      {
        h.a(paramArrayList1);
      }
      label138:
      paramArrayList1 = null;
      Object localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.lantern.bindapp.a.a)((Iterator)localObject2).next();
        localObject1 = paramArrayList1;
        if (((com.lantern.bindapp.a.a)localObject3).k > 0L)
        {
          localObject1 = paramArrayList1;
          if (paramArrayList1 == null)
          {
            localObject1 = new com/lantern/core/d/a;
            ((com.lantern.core.d.a)localObject1).<init>(c.getAppContext());
          }
          ((com.lantern.core.d.a)localObject1).a(new long[] { ((com.lantern.bindapp.a.a)localObject3).k });
          ((com.lantern.bindapp.a.a)localObject3).k = -1L;
        }
        paramArrayList1 = (ArrayList<com.lantern.bindapp.a.a>)localObject1;
      }
    }
  }
  
  private static ArrayList<com.lantern.bindapp.a.a> a(JSONArray paramJSONArray)
  {
    return a(paramJSONArray, false);
  }
  
  private static ArrayList<com.lantern.bindapp.a.a> a(JSONArray paramJSONArray, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      com.lantern.bindapp.a.a locala = new com.lantern.bindapp.a.a();
      locala.a = localJSONObject.getString("id");
      locala.e = localJSONObject.getString("apk");
      locala.f = localJSONObject.optString("apkmd5");
      locala.c = localJSONObject.getString("img");
      locala.d = localJSONObject.optString("imgmd5");
      locala.b = localJSONObject.getString("pkg");
      locala.g = localJSONObject.optString("slogan_man");
      locala.h = localJSONObject.optString("slogan_sen");
      locala.i = localJSONObject.optString("dcUrl");
      locala.j = Long.valueOf(localJSONObject.optString("end_time", "0")).longValue();
      locala.k = Long.valueOf(localJSONObject.optString("downloadId", "-1")).longValue();
      locala.l = paramBoolean;
      locala.m = Integer.parseInt(localJSONObject.getString("order"));
      localArrayList.add(locala);
    }
    if (localArrayList.size() > 0) {
      Collections.sort(localArrayList);
    }
    return localArrayList;
  }
  
  public static ArrayList<com.lantern.bindapp.a.a> a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    return a(paramJSONObject.getJSONArray("list"), paramBoolean);
  }
  
  public static JSONObject a(com.lantern.bindapp.a.a parama)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", parama.a);
      localJSONObject.put("apk", parama.e);
      localJSONObject.put("id", parama.a);
      localJSONObject.put("apk", parama.e);
      localJSONObject.put("apkmd5", parama.f);
      localJSONObject.put("img", parama.c);
      localJSONObject.put("imgmd5", parama.d);
      localJSONObject.put("pkg", parama.b);
      localJSONObject.put("slogan_man", parama.g);
      localJSONObject.put("slogan_sen", parama.h);
      localJSONObject.put("dcUrl", parama.i);
      localJSONObject.put("end_time", String.valueOf(parama.j));
      localJSONObject.put("order", parama.m);
      localJSONObject.put("downloadId", String.valueOf(parama.k));
      return localJSONObject;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        h.a(parama);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    if (c.getInstance().getPackageManager().getPackageArchiveInfo(paramString, 0) != null) {
      bool = true;
    }
    return bool;
  }
  
  public static String b()
  {
    String str2 = c.getServer().d();
    Object localObject = str2;
    String str3;
    if (TextUtils.isEmpty(str2))
    {
      str3 = p.a("wk_sdk_loc", "");
      localObject = str2;
      if (TextUtils.isEmpty(str3)) {}
    }
    try
    {
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(str3);
      localObject = ((JSONObject)localObject).optString("lati");
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        String str1 = str2;
      }
    }
  }
  
  public static String c()
  {
    String str2 = c.getServer().e();
    Object localObject = str2;
    String str3;
    if (TextUtils.isEmpty(str2))
    {
      str3 = p.a("wk_sdk_loc", "");
      localObject = str2;
      if (TextUtils.isEmpty(str3)) {}
    }
    try
    {
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(str3);
      localObject = ((JSONObject)localObject).optString("longi");
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        String str1 = str2;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/bindapp/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */