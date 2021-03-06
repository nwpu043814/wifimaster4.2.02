package com.wifi.connect.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluefay.b.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public final class c
{
  private String a;
  private Context b;
  
  public c(Context paramContext)
  {
    this.b = paramContext;
    this.a = "connect_aplocation";
  }
  
  private static b a(String paramString, Object paramObject)
  {
    localObject2 = null;
    localObject1 = localObject2;
    if ((paramObject instanceof String)) {}
    for (;;)
    {
      try
      {
        localObject1 = new org/json/JSONArray;
        ((JSONArray)localObject1).<init>((String)paramObject);
        localObject1 = b.a((JSONArray)localObject1);
        if (localObject1 != null) {
          continue;
        }
        localObject1 = localObject2;
      }
      catch (JSONException paramString)
      {
        h.a(paramString);
        localObject1 = localObject2;
        continue;
      }
      return (b)localObject1;
      ((b)localObject1).e = paramString;
      try
      {
        ((b)localObject1).f = Long.parseLong(paramString);
      }
      catch (NumberFormatException paramString)
      {
        h.a(paramString);
      }
    }
  }
  
  public final List<b> a()
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = this.b.getSharedPreferences(this.a, 0).getAll();
        if (localObject2 != null)
        {
          int i = ((Map)localObject2).size();
          if (i != 0) {}
        }
        else
        {
          localObject1 = null;
          return (List<b>)localObject1;
        }
        Object localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = a((String)((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
          if (localObject3 == null) {
            continue;
          }
          ((List)localObject1).add(localObject3);
          continue;
        }
        localObject2 = new com/wifi/connect/c/d;
      }
      finally {}
      ((d)localObject2).<init>(this);
      Collections.sort(localList, (Comparator)localObject2);
    }
  }
  
  /* Error */
  public final boolean a(b paramb)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc -127
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: invokestatic 132	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_1
    //   18: ifnonnull +7 -> 25
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   28: lstore_3
    //   29: aload_0
    //   30: getfield 15	com/wifi/connect/c/c:b	Landroid/content/Context;
    //   33: aload_0
    //   34: getfield 19	com/wifi/connect/c/c:a	Ljava/lang/String;
    //   37: iconst_0
    //   38: invokevirtual 62	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: invokeinterface 142 1 0
    //   46: astore 5
    //   48: aload 5
    //   50: lload_3
    //   51: invokestatic 146	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aload_1
    //   55: invokevirtual 150	com/wifi/connect/c/b:toString	()Ljava/lang/String;
    //   58: invokeinterface 156 3 0
    //   63: pop
    //   64: aload 5
    //   66: invokeinterface 159 1 0
    //   71: istore_2
    //   72: goto -51 -> 21
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	c
    //   0	80	1	paramb	b
    //   1	71	2	bool	boolean
    //   28	23	3	l	long
    //   46	19	5	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   4	17	75	finally
    //   25	72	75	finally
  }
  
  public final boolean a(String paramString)
  {
    try
    {
      h.a("key:%s", new Object[] { paramString });
      SharedPreferences.Editor localEditor = this.b.getSharedPreferences(this.a, 0).edit();
      localEditor.remove(paramString);
      boolean bool = localEditor.commit();
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */