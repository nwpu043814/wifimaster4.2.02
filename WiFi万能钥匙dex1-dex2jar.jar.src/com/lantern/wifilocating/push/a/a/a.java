package com.lantern.wifilocating.push.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.lantern.wifilocating.push.util.h;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private String a;
  private Context b;
  private File c;
  private FilenameFilter d = new b(this);
  
  public a(Context paramContext, String paramString)
  {
    this.b = paramContext;
    paramContext = this.b.getFilesDir();
    if ((paramContext != null) && (paramContext.exists()))
    {
      this.c = new File(paramContext.getParentFile(), "shared_prefs");
      h.a("SharedPreferenceDir:" + this.c);
      if (paramString == null) {
        break label147;
      }
    }
    label147:
    for (this.a = ("push_sdk_dc_" + paramString + "_");; this.a = "push_sdk_dc_")
    {
      return;
      this.c = new File("/data/data/" + this.b.getPackageName(), "shared_prefs");
      break;
    }
  }
  
  private static com.lantern.wifilocating.push.a.b.b a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof String)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>((String)paramObject);
        paramObject = new com/lantern/wifilocating/push/a/b/b;
        ((com.lantern.wifilocating.push.a.b.b)paramObject).<init>();
        ((com.lantern.wifilocating.push.a.b.b)paramObject).a = paramString;
        if (localJSONObject.has("cts"))
        {
          ((com.lantern.wifilocating.push.a.b.b)paramObject).b = localJSONObject.getLong("cts");
          ((com.lantern.wifilocating.push.a.b.b)paramObject).c = localJSONObject.toString();
          paramString = (String)paramObject;
          return paramString;
        }
        try
        {
          ((com.lantern.wifilocating.push.a.b.b)paramObject).b = Long.parseLong(paramString);
        }
        catch (NumberFormatException paramString)
        {
          h.a(paramString);
        }
        continue;
        paramString = null;
      }
      catch (JSONException paramString)
      {
        h.a(paramString);
      }
    }
  }
  
  public final List<String> a()
  {
    try
    {
      File[] arrayOfFile = this.c.listFiles(this.d);
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        int j = arrayOfFile.length;
        for (int i = 0;; i++)
        {
          localObject1 = localArrayList;
          if (i >= j) {
            break;
          }
          localObject1 = arrayOfFile[i].getName();
          int k = ((String)localObject1).lastIndexOf('.');
          if (k > 0) {
            localArrayList.add(((String)localObject1).substring(this.a.length(), k));
          }
        }
      }
      Object localObject1 = null;
      return (List<String>)localObject1;
    }
    finally {}
  }
  
  public final List<com.lantern.wifilocating.push.a.b.b> a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        int i = paramString.length();
        if (i != 6)
        {
          localObject1 = localObject2;
          return (List<com.lantern.wifilocating.push.a.b.b>)localObject1;
        }
        Context localContext = this.b;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        paramString = localContext.getSharedPreferences(this.a + paramString, 0).getAll();
        localObject1 = localObject2;
        if (paramString == null) {
          continue;
        }
        localObject1 = localObject2;
        if (paramString.size() == 0) {
          continue;
        }
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        paramString = paramString.entrySet().iterator();
        if (paramString.hasNext())
        {
          localObject2 = (Map.Entry)paramString.next();
          localObject2 = a((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
          if (localObject2 == null) {
            continue;
          }
          ((List)localObject1).add(localObject2);
          continue;
        }
        paramString = new com/lantern/wifilocating/push/a/a/c;
      }
      finally {}
      paramString.<init>(this);
      Collections.sort((List)localObject1, paramString);
    }
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    try
    {
      h.a("dcType:%s key:%s", new Object[] { paramString1, paramString2 });
      Context localContext = this.b;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      paramString1 = localContext.getSharedPreferences(this.a + paramString1, 0).edit();
      paramString1.remove(paramString2);
      boolean bool = paramString1.commit();
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final boolean a(String paramString, JSONArray paramJSONArray)
  {
    boolean bool2 = false;
    if (paramJSONArray == null) {}
    label75:
    for (boolean bool1 = bool2;; bool1 = true) {
      for (;;)
      {
        return bool1;
        try
        {
          int j = paramJSONArray.length();
          bool1 = bool2;
          if (j > 0)
          {
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label75;
              }
              try
              {
                a(paramString, paramJSONArray.getJSONObject(i));
                i++;
              }
              catch (JSONException paramString)
              {
                h.a(paramString);
                bool1 = bool2;
              }
            }
          }
        }
        finally {}
      }
    }
  }
  
  /* Error */
  public final boolean a(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc -12
    //   6: iconst_2
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_2
    //   17: aastore
    //   18: invokestatic 218	com/lantern/wifilocating/push/util/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_2
    //   22: ifnonnull +7 -> 29
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_3
    //   28: ireturn
    //   29: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   32: lstore 4
    //   34: aload_0
    //   35: getfield 26	com/lantern/wifilocating/push/a/a/a:b	Landroid/content/Context;
    //   38: astore 6
    //   40: new 50	java/lang/StringBuilder
    //   43: astore 7
    //   45: aload 7
    //   47: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   50: aload 6
    //   52: aload 7
    //   54: aload_0
    //   55: getfield 76	com/lantern/wifilocating/push/a/a/a:a	Ljava/lang/String;
    //   58: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: iconst_0
    //   69: invokevirtual 159	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   72: invokeinterface 222 1 0
    //   77: astore_1
    //   78: aload_1
    //   79: lload 4
    //   81: invokestatic 254	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   84: aload_2
    //   85: invokevirtual 113	org/json/JSONObject:toString	()Ljava/lang/String;
    //   88: invokeinterface 258 3 0
    //   93: pop
    //   94: aload_1
    //   95: invokeinterface 231 1 0
    //   100: istore_3
    //   101: goto -76 -> 25
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	a
    //   0	109	1	paramString	String
    //   0	109	2	paramJSONObject	JSONObject
    //   1	100	3	bool	boolean
    //   32	48	4	l	long
    //   38	13	6	localContext	Context
    //   43	10	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	21	104	finally
    //   29	101	104	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */