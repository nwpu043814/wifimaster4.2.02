package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
{
  public static final int[] a = { 80, 8080, 14000 };
  public long b;
  private Map c;
  
  public d() {}
  
  public d(al paramal)
  {
    this.b = paramal.b;
    this.c = new HashMap();
    Iterator localIterator1 = paramal.a.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Integer localInteger = (Integer)localIterator1.next();
      if (ba.a(localInteger))
      {
        Object localObject = (ArrayList)paramal.a.get(localInteger);
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          localObject = new s();
          if (((s)localObject).a(str)) {
            localArrayList.add(localObject);
          }
        }
        this.c.put(localInteger, localArrayList);
      }
    }
  }
  
  private static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "access_cm";
    }
    for (;;)
    {
      return str;
      if (paramInt == 2) {
        str = "access_uni";
      } else if (paramInt == 3) {
        str = "access_ct";
      }
    }
  }
  
  public final void a()
  {
    SharedPreferences localSharedPreferences = p.a().getSharedPreferences("Access_Preferences", 0);
    this.b = localSharedPreferences.getLong("timeStamp", 0L);
    this.c = new HashMap();
    label179:
    label219:
    for (int i = 1; i <= 3; i++)
    {
      String str = localSharedPreferences.getString(a(i), "");
      Object localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = "";
        if (i != 1) {
          break label179;
        }
        localObject = "183.61.38.168:14000,117.135.171.182:14000";
      }
      for (;;)
      {
        bb.b("SdkAccessInfo", "getDefaultIpListByOpType:" + (String)localObject);
        String[] arrayOfString = ((String)localObject).split(",");
        if (arrayOfString.length <= 0) {
          break label219;
        }
        localObject = new ArrayList();
        int k = arrayOfString.length;
        for (int j = 0; j < k; j++)
        {
          str = arrayOfString[j];
          s locals = new s();
          if (locals.a(str)) {
            ((ArrayList)localObject).add(locals);
          }
        }
        if (i == 2) {
          localObject = "112.90.140.213:14000,112.90.140.216:14000";
        } else if (i == 3) {
          localObject = "14.17.41.159:14000,140.206.160.242:14000";
        }
      }
      this.c.put(Integer.valueOf(i), localObject);
    }
  }
  
  public final void b()
  {
    SharedPreferences localSharedPreferences = p.a().getSharedPreferences("Access_Preferences", 0);
    if ((this.c != null) && (this.c.size() > 0))
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Integer)localIterator.next();
        if (ba.a((Integer)localObject2))
        {
          String str = a(((Integer)localObject2).intValue());
          Object localObject1 = (ArrayList)this.c.get(localObject2);
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            localObject1 = new StringBuilder();
            localObject2 = ((ArrayList)this.c.get(localObject2)).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              ((StringBuilder)localObject1).append(((s)((Iterator)localObject2).next()).a());
              ((StringBuilder)localObject1).append(",");
            }
            ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
            localSharedPreferences.edit().putString(str, ((StringBuilder)localObject1).toString()).commit();
          }
        }
      }
      localSharedPreferences.edit().putLong("timesStamp", this.b).commit();
    }
  }
  
  public final ArrayList c()
  {
    int k = 0;
    int i = ba.d();
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (ba.a(Integer.valueOf(i)))
    {
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localObject = (ArrayList)this.c.get(localInteger);
        if (i == localInteger.intValue()) {
          localArrayList.addAll(0, (Collection)localObject);
        } else {
          localArrayList.addAll((Collection)localObject);
        }
      }
    }
    Iterator localIterator = this.c.keySet().iterator();
    int j;
    for (i = 0;; i = Math.max(i, ((ArrayList)this.c.get(localObject)).size()))
    {
      j = k;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (Integer)localIterator.next();
    }
    for (;;)
    {
      j++;
      if (j >= i) {
        break;
      }
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        localObject = (ArrayList)this.c.get(localObject);
        if (j < ((ArrayList)localObject).size()) {
          localArrayList.add(((ArrayList)localObject).get(j));
        }
      }
    }
    return localArrayList;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */