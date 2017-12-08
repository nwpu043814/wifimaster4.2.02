package com.lantern.mailbox.e;

import android.content.Context;
import android.content.Intent;
import com.lantern.core.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static String a(com.lantern.mailbox.d.a parama, List<String> paramList, boolean paramBoolean)
  {
    Object localObject;
    int i;
    if (paramBoolean)
    {
      localObject = parama.r();
      localObject = new StringBuilder((String)localObject);
      i = parama.d();
      if (i >= 3) {
        break label118;
      }
      if (paramList.size() + i <= 3) {
        break label102;
      }
      i = 3 - i;
      label47:
      if (!paramBoolean) {
        break label112;
      }
    }
    label102:
    label112:
    for (parama = "、";; parama = ",")
    {
      for (int j = 0; j < i; j++)
      {
        ((StringBuilder)localObject).append(parama);
        ((StringBuilder)localObject).append((String)paramList.get(j));
      }
      localObject = parama.n();
      break;
      i = paramList.size();
      break label47;
    }
    label118:
    return ((StringBuilder)localObject).toString();
  }
  
  public static List<com.lantern.mailbox.d.a> a(String paramString, JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      com.lantern.mailbox.d.a locala = new com.lantern.mailbox.d.a();
      locala.d(localJSONObject.optString("lid"));
      locala.e(localJSONObject.optString("mSource"));
      locala.f(localJSONObject.optString("cContent"));
      locala.g(localJSONObject.optString("cUhid"));
      locala.h(localJSONObject.optString("cHeadImg"));
      locala.i(localJSONObject.optString("type"));
      locala.j(localJSONObject.optString("bizId"));
      locala.k(localJSONObject.optString("cUrl"));
      locala.l(localJSONObject.optString("cNickName"));
      locala.a(Long.parseLong(localJSONObject.optString("time")));
      locala.b(localJSONObject.optString("cNickName"));
      locala.b(localJSONObject.optString("before"));
      locala.c(localJSONObject.optString("after"));
      locala.c(true);
      locala.a(true);
      locala.b(true);
      locala.a(1);
      locala.a(localJSONObject.optString("bar"));
      localArrayList.add(locala);
    }
    return a(com.lantern.mailbox.c.a.a().a(paramString, true, false), localArrayList);
  }
  
  private static List<com.lantern.mailbox.d.a> a(List<com.lantern.mailbox.d.a> paramList1, List<com.lantern.mailbox.d.a> paramList2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(paramList1);
    localArrayList2.addAll(paramList2);
    com.lantern.mailbox.d.a locala1;
    for (int i = 0; i < localArrayList2.size(); i++)
    {
      com.lantern.mailbox.d.a locala2 = (com.lantern.mailbox.d.a)localArrayList2.get(i);
      if (locala2.g())
      {
        localObject = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        for (int j = i + 1; j < localArrayList2.size(); j++)
        {
          locala1 = (com.lantern.mailbox.d.a)localArrayList2.get(j);
          if ((locala2.o().equals(locala1.o())) && (locala2.k().equals(locala1.k())) && (!"11".equals(locala2.o())) && (!"12".equals(locala2.o())))
          {
            ((List)localObject).add(locala1.r());
            localArrayList3.add(locala1.n());
            locala1.b(false);
          }
        }
        if (((List)localObject).size() > 0)
        {
          locala2.l(a(locala2, (List)localObject, true));
          locala2.h(a(locala2, localArrayList3, false));
          if ((locala2.e() != null) && (locala2.d() < 3)) {
            locala2.a(null);
          }
          locala2.a(locala2.d() + ((List)localObject).size());
          locala2.a(true);
          localArrayList1.add(locala2);
        }
      }
    }
    Object localObject = paramList2.iterator();
    while (((Iterator)localObject).hasNext())
    {
      locala1 = (com.lantern.mailbox.d.a)((Iterator)localObject).next();
      if (locala1.g()) {
        localArrayList1.add(locala1);
      }
    }
    com.lantern.mailbox.c.a.a().a(paramList1, paramList2);
    a(localArrayList1);
    return localArrayList1;
  }
  
  private static void a(List<com.lantern.mailbox.d.a> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.lantern.mailbox.d.a)paramList.next();
      if (("11".equals(((com.lantern.mailbox.d.a)localObject).o())) || ("12".equals(((com.lantern.mailbox.d.a)localObject).o())))
      {
        String str = ((com.lantern.mailbox.d.a)localObject).p();
        localObject = new Intent();
        ((Intent)localObject).setAction("com.lantern.chat.action.MSG_COUNT");
        ((Intent)localObject).setPackage(c.getAppContext().getPackageName());
        ((Intent)localObject).putExtra("msg_id", str);
        c.getAppContext().sendBroadcast((Intent)localObject);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */