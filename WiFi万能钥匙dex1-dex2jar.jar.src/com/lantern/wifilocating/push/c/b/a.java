package com.lantern.wifilocating.push.c.b;

import android.text.TextUtils;
import com.lantern.wifilocating.push.c.b;
import com.lantern.wifilocating.push.c.d;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static a a;
  private static Map<String, Class<? extends com.lantern.wifilocating.push.c.a.a>> b;
  private Object c = new Object();
  private JSONObject d;
  private Map<String, com.lantern.wifilocating.push.c.a.a> e;
  private Map<String, JSONObject> f;
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put("sync.trigger", d.class);
    b.put("push.dc", com.lantern.wifilocating.push.c.a.class);
    b.put("socket.connection", com.lantern.wifilocating.push.c.c.class);
    b.put("push.loc", b.class);
  }
  
  private a()
  {
    b();
  }
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a locala = new com/lantern/wifilocating/push/c/b/a;
        locala.<init>();
        a = locala;
      }
      return a;
    }
    finally {}
  }
  
  private static com.lantern.wifilocating.push.c.a.a b(Class<? extends com.lantern.wifilocating.push.c.a.a> paramClass)
  {
    if (paramClass != null) {}
    try
    {
      paramClass = (com.lantern.wifilocating.push.c.a.a)paramClass.newInstance();
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    this.e = new HashMap();
    this.f = new HashMap();
    Object localObject1 = i.b(com.lantern.wifilocating.push.c.a());
    if (localObject1 != null) {}
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>((String)localObject1);
      this.d = localJSONObject;
      if (this.d == null) {
        this.d = new JSONObject();
      }
      if (this.d.length() > 0)
      {
        localObject1 = b.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          Object localObject3 = this.d.optString((String)localObject2, null);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            try
            {
              localJSONObject = new org/json/JSONObject;
              localJSONObject.<init>((String)localObject3);
              this.f.put(localObject2, localJSONObject);
              localObject3 = (Class)b.get(localObject2);
              localObject2 = b((Class)localObject3);
              if (localObject2 != null)
              {
                ((com.lantern.wifilocating.push.c.a.a)localObject2).b(localJSONObject);
                this.e.put(((Class)localObject3).getName(), localObject2);
              }
            }
            catch (JSONException localJSONException2)
            {
              localJSONException2.printStackTrace();
            }
          }
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        h.a(localJSONException1);
      }
    }
  }
  
  public final <T extends com.lantern.wifilocating.push.c.a.a> T a(Class<T> paramClass)
  {
    String str = paramClass.getName();
    if (this.e.containsKey(str)) {
      paramClass = (com.lantern.wifilocating.push.c.a.a)this.e.get(str);
    }
    for (;;)
    {
      return paramClass;
      com.lantern.wifilocating.push.c.a.a locala = b(paramClass);
      paramClass = locala;
      if (locala != null)
      {
        this.e.put(str, locala);
        paramClass = locala;
      }
    }
  }
  
  /* Error */
  public final void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/lantern/wifilocating/push/c/b/a:c	Ljava/lang/Object;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnonnull +7 -> 17
    //   13: aload 6
    //   15: monitorexit
    //   16: return
    //   17: iconst_0
    //   18: istore_2
    //   19: aload_1
    //   20: invokevirtual 163	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   23: astore 7
    //   25: aload 7
    //   27: invokeinterface 121 1 0
    //   32: ifeq +287 -> 319
    //   35: aload 7
    //   37: invokeinterface 124 1 0
    //   42: checkcast 126	java/lang/String
    //   45: astore 9
    //   47: aload_1
    //   48: aload 9
    //   50: aconst_null
    //   51: invokevirtual 130	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 8
    //   56: aload_0
    //   57: getfield 100	com/lantern/wifilocating/push/c/b/a:d	Lorg/json/JSONObject;
    //   60: aload 9
    //   62: aconst_null
    //   63: invokevirtual 130	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 11
    //   68: aload 8
    //   70: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   73: ifne +241 -> 314
    //   76: aload 11
    //   78: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: istore 5
    //   83: iload 5
    //   85: ifeq +150 -> 235
    //   88: iconst_1
    //   89: istore_3
    //   90: iload_3
    //   91: ifle +264 -> 355
    //   94: iload_2
    //   95: istore 4
    //   97: aload_0
    //   98: getfield 100	com/lantern/wifilocating/push/c/b/a:d	Lorg/json/JSONObject;
    //   101: aload 9
    //   103: aload 8
    //   105: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   108: pop
    //   109: iload_2
    //   110: istore_3
    //   111: iload_2
    //   112: ifne +5 -> 117
    //   115: iconst_1
    //   116: istore_3
    //   117: iload_3
    //   118: istore 4
    //   120: new 95	org/json/JSONObject
    //   123: astore 10
    //   125: iload_3
    //   126: istore 4
    //   128: aload 10
    //   130: aload 8
    //   132: invokespecial 98	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   135: iload_3
    //   136: istore 4
    //   138: aload_0
    //   139: getfield 83	com/lantern/wifilocating/push/c/b/a:f	Ljava/util/Map;
    //   142: aload 9
    //   144: aload 10
    //   146: invokeinterface 36 3 0
    //   151: pop
    //   152: iload_3
    //   153: istore 4
    //   155: getstatic 26	com/lantern/wifilocating/push/c/b/a:b	Ljava/util/Map;
    //   158: aload 9
    //   160: invokeinterface 140 2 0
    //   165: checkcast 65	java/lang/Class
    //   168: astore 8
    //   170: iload_3
    //   171: istore 4
    //   173: aload 8
    //   175: invokestatic 142	com/lantern/wifilocating/push/c/b/a:b	(Ljava/lang/Class;)Lcom/lantern/wifilocating/push/c/a/a;
    //   178: astore 9
    //   180: iload_3
    //   181: istore_2
    //   182: aload 9
    //   184: ifnull -159 -> 25
    //   187: iload_3
    //   188: istore 4
    //   190: aload 9
    //   192: aload 10
    //   194: invokevirtual 145	com/lantern/wifilocating/push/c/a/a:b	(Lorg/json/JSONObject;)V
    //   197: iload_3
    //   198: istore 4
    //   200: aload_0
    //   201: getfield 81	com/lantern/wifilocating/push/c/b/a:e	Ljava/util/Map;
    //   204: aload 8
    //   206: invokevirtual 149	java/lang/Class:getName	()Ljava/lang/String;
    //   209: aload 9
    //   211: invokeinterface 36 3 0
    //   216: pop
    //   217: iload_3
    //   218: istore_2
    //   219: goto -194 -> 25
    //   222: astore 8
    //   224: iload 4
    //   226: istore_2
    //   227: aload 8
    //   229: invokevirtual 150	org/json/JSONException:printStackTrace	()V
    //   232: goto -207 -> 25
    //   235: aload 8
    //   237: invokestatic 171	com/lantern/wifilocating/push/util/j:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   240: astore 10
    //   242: aload 10
    //   244: ifnull +11 -> 255
    //   247: aload 10
    //   249: invokevirtual 105	org/json/JSONObject:length	()I
    //   252: ifne +8 -> 260
    //   255: iconst_m1
    //   256: istore_3
    //   257: goto -167 -> 90
    //   260: aload 11
    //   262: invokestatic 171	com/lantern/wifilocating/push/util/j:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   265: astore 11
    //   267: aload 11
    //   269: ifnull +11 -> 280
    //   272: aload 11
    //   274: invokevirtual 105	org/json/JSONObject:length	()I
    //   277: ifne +8 -> 285
    //   280: iconst_1
    //   281: istore_3
    //   282: goto -192 -> 90
    //   285: aload 10
    //   287: ldc -83
    //   289: ldc2_w 174
    //   292: invokevirtual 179	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   295: aload 11
    //   297: ldc -83
    //   299: ldc2_w 174
    //   302: invokevirtual 179	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   305: lcmp
    //   306: ifle +8 -> 314
    //   309: iconst_1
    //   310: istore_3
    //   311: goto -221 -> 90
    //   314: iconst_m1
    //   315: istore_3
    //   316: goto -226 -> 90
    //   319: iload_2
    //   320: ifeq +23 -> 343
    //   323: aload_0
    //   324: getfield 100	com/lantern/wifilocating/push/c/b/a:d	Lorg/json/JSONObject;
    //   327: ifnull +16 -> 343
    //   330: invokestatic 88	com/lantern/wifilocating/push/c:a	()Landroid/content/Context;
    //   333: aload_0
    //   334: getfield 100	com/lantern/wifilocating/push/c/b/a:d	Lorg/json/JSONObject;
    //   337: invokevirtual 182	org/json/JSONObject:toString	()Ljava/lang/String;
    //   340: invokestatic 185	com/lantern/wifilocating/push/util/i:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   343: aload 6
    //   345: monitorexit
    //   346: goto -330 -> 16
    //   349: astore_1
    //   350: aload 6
    //   352: monitorexit
    //   353: aload_1
    //   354: athrow
    //   355: goto -123 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	a
    //   0	358	1	paramJSONObject	JSONObject
    //   18	302	2	i	int
    //   89	227	3	j	int
    //   95	130	4	k	int
    //   81	3	5	bool	boolean
    //   4	347	6	localObject1	Object
    //   23	13	7	localIterator	Iterator
    //   54	151	8	localObject2	Object
    //   222	14	8	localJSONException	JSONException
    //   45	165	9	localObject3	Object
    //   123	163	10	localJSONObject	JSONObject
    //   66	230	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   97	109	222	org/json/JSONException
    //   120	125	222	org/json/JSONException
    //   128	135	222	org/json/JSONException
    //   138	152	222	org/json/JSONException
    //   155	170	222	org/json/JSONException
    //   173	180	222	org/json/JSONException
    //   190	197	222	org/json/JSONException
    //   200	217	222	org/json/JSONException
    //   13	16	349	finally
    //   19	25	349	finally
    //   25	83	349	finally
    //   97	109	349	finally
    //   120	125	349	finally
    //   128	135	349	finally
    //   138	152	349	finally
    //   155	170	349	finally
    //   173	180	349	finally
    //   190	197	349	finally
    //   200	217	349	finally
    //   227	232	349	finally
    //   235	242	349	finally
    //   247	255	349	finally
    //   260	267	349	finally
    //   272	280	349	finally
    //   285	309	349	finally
    //   323	343	349	finally
    //   343	346	349	finally
    //   350	353	349	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */