package com.lantern.wifilocating.push.g.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.lantern.wifilocating.push.util.d;
import com.lantern.wifilocating.push.util.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONObject;

public class a
{
  private static a a;
  private Object b = new Object();
  private Vector<Integer> c = new Vector();
  private Vector<Integer> d = new Vector();
  private SharedPreferences e;
  private Comparator<Integer> f = new b(this);
  
  private a()
  {
    a(d.c());
  }
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a locala = new com/lantern/wifilocating/push/g/b/a;
        locala.<init>();
        a = locala;
      }
      return a;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.e = com.lantern.wifilocating.push.c.a().getSharedPreferences("has_show_sequence", 0);
      paramString = this.e.getString("user_has_show_sequence_" + paramString, "");
      int k;
      int i;
      label86:
      CharSequence localCharSequence;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split(",");
        if (paramString != null)
        {
          this.c = new Vector();
          k = paramString.length;
          i = 0;
          if (i < k) {
            localCharSequence = paramString[i];
          }
        }
      }
      try
      {
        if (!TextUtils.isEmpty(localCharSequence))
        {
          int m = Integer.parseInt(localCharSequence);
          this.c.add(Integer.valueOf(m));
        }
        i++;
        break label86;
        paramString = this.e.getString("global_has_show_sequence", "");
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        paramString = paramString.split(",");
        if (paramString == null) {
          continue;
        }
        this.d = new Vector();
        k = paramString.length;
        i = j;
        while (i < k)
        {
          localCharSequence = paramString[i];
          try
          {
            if (!TextUtils.isEmpty(localCharSequence))
            {
              j = Integer.parseInt(localCharSequence);
              this.d.add(Integer.valueOf(j));
            }
            i++;
          }
          catch (Exception localException1)
          {
            for (;;) {}
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  private void b(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (this.e == null) {
        this.e = com.lantern.wifilocating.push.c.a().getSharedPreferences("has_show_sequence", 0);
      }
      int k;
      int i;
      if (!this.c.isEmpty())
      {
        Collections.sort(this.c, this.f);
        StringBuilder localStringBuilder = new StringBuilder();
        k = this.c.size();
        for (i = 0; (i < k) && (i < 10); i++) {
          localStringBuilder.append(this.c.get(i)).append(",");
        }
        if (localStringBuilder.length() > 0)
        {
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          this.e.edit().putString("user_has_show_sequence_" + paramString, localStringBuilder.toString()).commit();
        }
      }
      if (!this.d.isEmpty())
      {
        Collections.sort(this.d, this.f);
        paramString = new StringBuilder();
        k = this.d.size();
        for (i = j; (i < k) && (i < 10); i++) {
          paramString.append(this.d.get(i)).append(",");
        }
        if (paramString.length() > 0)
        {
          paramString.deleteCharAt(paramString.length() - 1);
          this.e.edit().putString("global_has_show_sequence", paramString.toString()).commit();
        }
      }
    }
  }
  
  public final void a(List<? extends Object> paramList)
  {
    Object localObject2 = this.b;
    if (paramList != null) {}
    int i;
    label176:
    label185:
    label436:
    label456:
    for (;;)
    {
      Object localObject3;
      int j;
      int i1;
      Object localObject1;
      try
      {
        if (!paramList.isEmpty())
        {
          localObject3 = new java/util/ArrayList;
          ((ArrayList)localObject3).<init>();
          Iterator localIterator = paramList.iterator();
          i = 0;
          if (localIterator.hasNext())
          {
            paramList = localIterator.next();
            if (paramList == null) {
              continue;
            }
            try
            {
              if ((paramList instanceof JSONObject))
              {
                paramList = (JSONObject)paramList;
                j = paramList.optInt("sequence");
                i1 = paramList.optInt("sequenceType");
                if (i1 != 0) {
                  break label176;
                }
                localObject1 = this.c;
                if (!((Vector)localObject1).isEmpty()) {
                  break label185;
                }
                ((Vector)localObject1).add(Integer.valueOf(j));
                j = 0;
                if (j != 0) {
                  break label456;
                }
              }
            }
            catch (Exception paramList) {}
          }
        }
      }
      finally {}
      try
      {
        ((List)localObject3).add(paramList);
        i = 1;
      }
      catch (Exception paramList)
      {
        String str;
        int k;
        int m;
        int n;
        i = 1;
        continue;
      }
      if ((paramList instanceof String))
      {
        paramList = new JSONObject(paramList.toString());
        continue;
        paramList.printStackTrace();
        continue;
        localObject1 = this.d;
        continue;
        if (((Vector)localObject1).contains(Integer.valueOf(j)))
        {
          str = paramList.optString("requestId");
          k = paramList.optInt("status");
          m = paramList.optInt("syt");
          n = paramList.optInt("dc");
          localObject1 = new com/lantern/wifilocating/push/a/b/a;
          ((com.lantern.wifilocating.push.a.b.a)localObject1).<init>();
          ((com.lantern.wifilocating.push.a.b.a)localObject1).a(i1);
          ((com.lantern.wifilocating.push.a.b.a)localObject1).b(j);
          ((com.lantern.wifilocating.push.a.b.a)localObject1).c(str);
          ((com.lantern.wifilocating.push.a.b.a)localObject1).c(k);
          ((com.lantern.wifilocating.push.a.b.a)localObject1).d(2);
          ((com.lantern.wifilocating.push.a.b.a)localObject1).e(4);
          ((com.lantern.wifilocating.push.a.b.a)localObject1).f(m);
          com.lantern.wifilocating.push.f.a.a("012003", ((com.lantern.wifilocating.push.a.b.a)localObject1).a(), m, n);
          j = 1;
        }
        else
        {
          ((Vector)localObject1).add(Integer.valueOf(j));
          j = 0;
          continue;
          if (i != 0) {
            b(d.c());
          }
          if (!((List)localObject3).isEmpty())
          {
            paramList = ((List)localObject3).iterator();
            while (paramList.hasNext())
            {
              localObject3 = (JSONObject)paramList.next();
              if (localObject3 != null)
              {
                i = -1;
                if (localObject3 != null) {}
                try
                {
                  i = ((JSONObject)localObject3).optInt("msgType");
                  localObject1 = com.lantern.wifilocating.push.g.c.b.a(i);
                  if (localObject1 != null) {
                    break label436;
                  }
                  localObject1 = new java/lang/StringBuilder;
                  ((StringBuilder)localObject1).<init>("not found processor for type:");
                  com.lantern.wifilocating.push.util.b.c(i);
                }
                catch (Exception localException)
                {
                  h.a(localException);
                }
                continue;
                localException.a((JSONObject)localObject3);
              }
            }
          }
          return;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/g/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */