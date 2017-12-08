package com.linksure.apservice.a.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.linksure.apservice.a.d.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements com.linksure.apservice.a.b.a
{
  private com.linksure.apservice.a.b.a.a.a a;
  
  public a(com.linksure.apservice.a.b.a.a.a parama)
  {
    this.a = parama;
  }
  
  private static final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt3 ^ 0xFFFFFFFF) & paramInt1 | paramInt2 & paramInt3;
  }
  
  private static com.linksure.apservice.a.d.a a(Cursor paramCursor)
  {
    boolean bool2 = true;
    Object localObject = a.a(paramCursor);
    com.linksure.apservice.a.d.a locala = new com.linksure.apservice.a.d.a();
    locala.a = paramCursor.getString(((a)localObject).a);
    int i = paramCursor.getInt(((a)localObject).b);
    boolean bool1;
    if ((i & 0x10) == 16) {
      bool1 = true;
    }
    for (;;)
    {
      locala.h = bool1;
      if ((i & 0x1) == 1)
      {
        bool1 = true;
        label71:
        locala.g = bool1;
        if ((i & 0x100) != 256) {
          break label338;
        }
        bool1 = true;
        label90:
        locala.i = bool1;
        if ((i & 0x1000) != 4096) {
          break label343;
        }
        bool1 = true;
        label109:
        locala.j = bool1;
        if ((i & 0x10000) != 65536) {
          break label348;
        }
        bool1 = bool2;
        locala.k = bool1;
        locala.b = paramCursor.getString(((a)localObject).c);
        locala.c = paramCursor.getInt(((a)localObject).d);
        locala.d = paramCursor.getInt(((a)localObject).g);
        locala.f = paramCursor.getString(((a)localObject).h);
        locala.m = paramCursor.getLong(((a)localObject).e);
        locala.l = paramCursor.getLong(((a)localObject).f);
        locala.n = e(paramCursor.getString(((a)localObject).j));
        localObject = paramCursor.getString(((a)localObject).i);
      }
      try
      {
        paramCursor = new org/json/JSONObject;
        paramCursor.<init>((String)localObject);
        locala.o = paramCursor.optString("logo");
        locala.p = paramCursor.optString("tel");
        locala.q = paramCursor.optString("desc");
        locala.s = paramCursor.optString("account");
        locala.r = paramCursor.optString("industry");
        return locala;
        bool1 = false;
        continue;
        bool1 = false;
        break label71;
        label338:
        bool1 = false;
        break label90;
        label343:
        bool1 = false;
        break label109;
        label348:
        bool1 = false;
      }
      catch (Exception paramCursor)
      {
        for (;;)
        {
          paramCursor.printStackTrace();
        }
      }
    }
  }
  
  private static List<e> a(JSONArray paramJSONArray)
  {
    Object localObject;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      localObject = null;
    }
    int j;
    ArrayList localArrayList;
    int i;
    do
    {
      return (List<e>)localObject;
      j = paramJSONArray.length();
      localArrayList = new ArrayList(j);
      i = 0;
      localObject = localArrayList;
    } while (i >= j);
    JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
    if (localJSONObject == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i++;
      break;
      localObject = new e();
      ((e)localObject).b = localJSONObject.optString("name");
      ((e)localObject).c = localJSONObject.optString("url");
      ((e)localObject).d = a(localJSONObject.optJSONArray("children"));
    }
  }
  
  private static ContentValues b(com.linksure.apservice.a.d.a parama)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("aps_id", d(parama.a));
    localContentValues.put("name", parama.b);
    if (parama.g)
    {
      i = a(0, 1, 1);
      if (!parama.h) {
        break label184;
      }
      i = a(i, 16, 16);
      label61:
      if (!parama.i) {
        break label195;
      }
      i = a(i, 256, 256);
      label79:
      if (!parama.j) {
        break label207;
      }
      i = a(i, 4096, 4096);
      label97:
      if (!parama.k) {
        break label219;
      }
    }
    label184:
    label195:
    label207:
    label219:
    for (int i = a(i, 65536, 65536);; i = a(i, 0, 65536))
    {
      localContentValues.put("stat", Integer.valueOf(i));
      localContentValues.put("create_at", Long.valueOf(parama.m));
      localContentValues.put("type", Integer.valueOf(parama.c));
      localContentValues.put("menu", b(parama.n));
      localContentValues.put("data", c(parama));
      return localContentValues;
      i = a(0, 0, 1);
      break;
      i = a(i, 0, 16);
      break label61;
      i = a(i, 0, 256);
      break label79;
      i = a(i, 0, 4096);
      break label97;
    }
  }
  
  private static String b(List<e> paramList)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramList != null)
    {
      if (paramList.size() != 0) {
        break label21;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (String)localObject1;
      try
      {
        label21:
        localObject1 = c(paramList).toString();
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        localObject1 = localObject2;
      }
    }
  }
  
  private static String c(com.linksure.apservice.a.d.a parama)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("logo", parama.o);
      localJSONObject.put("tel", parama.p);
      localJSONObject.put("desc", parama.q);
      localJSONObject.put("account", parama.s);
      localJSONObject.put("industry", parama.r);
      return localJSONObject.toString();
    }
    catch (Exception parama)
    {
      for (;;)
      {
        parama.printStackTrace();
      }
    }
  }
  
  private static JSONArray c(List<e> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", locale.b);
      localJSONObject.put("url", locale.c);
      if ((locale.d != null) && (locale.d.size() > 0)) {
        localJSONObject.put("children", c(locale.d));
      }
      localJSONArray.put(localJSONObject);
    }
    return localJSONArray;
  }
  
  private static String d(String paramString)
  {
    String str;
    if ((paramString != null) && (!"".equals(paramString)))
    {
      str = paramString;
      if (!"null".equals(paramString)) {}
    }
    else
    {
      str = "1";
    }
    return str;
  }
  
  private static List<e> e(String paramString)
  {
    if (paramString == null) {
      paramString = Collections.EMPTY_LIST;
    }
    for (;;)
    {
      return paramString;
      try
      {
        JSONArray localJSONArray = new org/json/JSONArray;
        localJSONArray.<init>(paramString);
        paramString = a(localJSONArray);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = Collections.EMPTY_LIST;
      }
    }
  }
  
  public final com.linksure.apservice.a.d.a a(String paramString)
  {
    paramString = d(paramString);
    Cursor localCursor = this.a.a().rawQuery("select * from aps_account where aps_id = ?", new String[] { paramString });
    paramString = null;
    if (localCursor.moveToNext()) {
      paramString = a(localCursor);
    }
    return paramString;
  }
  
  public final List<com.linksure.apservice.a.d.a> a()
  {
    Cursor localCursor = this.a.a().rawQuery("select * from aps_account", null);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(a(localCursor));
    }
    return localArrayList;
  }
  
  public final void a(com.linksure.apservice.a.d.a parama)
  {
    Log.e("--->", "dao create account:" + parama);
    try
    {
      this.a.a().insertOrThrow("aps_account", null, b(parama));
      return;
    }
    catch (SQLiteConstraintException parama)
    {
      for (;;)
      {
        Log.e("--->", "db insert err", parama);
      }
    }
    catch (Exception parama)
    {
      throw new com.linksure.apservice.a.d.a.a("db insert err", parama);
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    paramString = d(paramString);
    if (paramInt > 0) {
      this.a.a().execSQL("UPDATE aps_account SET unread=unread + ? WHERE aps_id=?", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    for (;;)
    {
      return;
      if (paramInt < 0) {
        this.a.a().execSQL("UPDATE aps_account SET unread=unread + ? WHERE aps_id=? AND unread >= ?", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(-paramInt) });
      }
    }
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    paramString = d(paramString);
    com.linksure.apservice.a.d.a locala = a(paramString);
    if (paramInt1 != -1)
    {
      if (paramInt1 == 0)
      {
        bool1 = false;
        locala.j = bool1;
      }
    }
    else if (paramInt2 != -1) {
      if (paramInt2 != 0) {
        break label68;
      }
    }
    label68:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      locala.k = bool1;
      a(paramString, locala);
      return;
      bool1 = true;
      break;
    }
  }
  
  public final void a(String paramString, com.linksure.apservice.a.d.a parama)
  {
    paramString = d(paramString);
    this.a.a().update("aps_account", b(parama), "aps_id=?", new String[] { paramString });
  }
  
  public final void a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = d(paramString1);
    paramString1 = this.a.a().rawQuery("UPDATE aps_account SET latest=?,update_at=? WHERE aps_id=?", new String[] { String.valueOf(paramString2), String.valueOf(paramLong), paramString1 });
    paramString1.moveToFirst();
    paramString1.close();
  }
  
  /* Error */
  public final void a(List<com.linksure.apservice.a.d.a> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 390	com/linksure/apservice/a/b/a/a:a	()Ljava/util/List;
    //   4: astore 5
    //   6: new 154	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 312	java/util/ArrayList:<init>	()V
    //   13: astore_2
    //   14: new 154	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 312	java/util/ArrayList:<init>	()V
    //   21: astore_3
    //   22: new 154	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 312	java/util/ArrayList:<init>	()V
    //   29: astore 4
    //   31: aload_2
    //   32: aload_1
    //   33: invokeinterface 394 2 0
    //   38: pop
    //   39: aload_2
    //   40: aload 5
    //   42: invokeinterface 397 2 0
    //   47: pop
    //   48: aload 4
    //   50: aload 5
    //   52: invokeinterface 394 2 0
    //   57: pop
    //   58: aload 4
    //   60: aload_1
    //   61: invokeinterface 397 2 0
    //   66: pop
    //   67: aload_3
    //   68: aload_1
    //   69: invokeinterface 394 2 0
    //   74: pop
    //   75: aload_3
    //   76: aload 5
    //   78: invokeinterface 400 2 0
    //   83: pop
    //   84: aload_0
    //   85: getfield 17	com/linksure/apservice/a/b/a/a:a	Lcom/linksure/apservice/a/b/a/a/a;
    //   88: invokeinterface 295 1 0
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 403	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   98: aload 4
    //   100: invokeinterface 257 1 0
    //   105: astore 4
    //   107: aload 4
    //   109: invokeinterface 263 1 0
    //   114: ifeq +51 -> 165
    //   117: aload_0
    //   118: aload 4
    //   120: invokeinterface 267 1 0
    //   125: checkcast 27	com/linksure/apservice/a/d/a
    //   128: getfield 40	com/linksure/apservice/a/d/a:a	Ljava/lang/String;
    //   131: invokevirtual 405	com/linksure/apservice/a/b/a/a:c	(Ljava/lang/String;)V
    //   134: goto -27 -> 107
    //   137: astore_3
    //   138: new 348	com/linksure/apservice/a/d/a/a
    //   141: astore_2
    //   142: aload_2
    //   143: ldc_w 407
    //   146: aload_3
    //   147: invokespecial 351	com/linksure/apservice/a/d/a/a:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   150: aload_2
    //   151: athrow
    //   152: astore_2
    //   153: aload_1
    //   154: invokevirtual 410	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   157: aload_2
    //   158: athrow
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   164: return
    //   165: aload_3
    //   166: invokeinterface 257 1 0
    //   171: astore 4
    //   173: aload 4
    //   175: invokeinterface 263 1 0
    //   180: ifeq +26 -> 206
    //   183: aload 4
    //   185: invokeinterface 267 1 0
    //   190: checkcast 27	com/linksure/apservice/a/d/a
    //   193: astore_3
    //   194: aload_0
    //   195: aload_3
    //   196: getfield 40	com/linksure/apservice/a/d/a:a	Ljava/lang/String;
    //   199: aload_3
    //   200: invokevirtual 366	com/linksure/apservice/a/b/a/a:a	(Ljava/lang/String;Lcom/linksure/apservice/a/d/a;)V
    //   203: goto -30 -> 173
    //   206: aload_2
    //   207: invokeinterface 257 1 0
    //   212: astore_2
    //   213: aload_2
    //   214: invokeinterface 263 1 0
    //   219: ifeq +19 -> 238
    //   222: aload_0
    //   223: aload_2
    //   224: invokeinterface 267 1 0
    //   229: checkcast 27	com/linksure/apservice/a/d/a
    //   232: invokevirtual 412	com/linksure/apservice/a/b/a/a:a	(Lcom/linksure/apservice/a/d/a;)V
    //   235: goto -22 -> 213
    //   238: aload_1
    //   239: invokevirtual 415	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   242: aload_1
    //   243: invokevirtual 410	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   246: goto -82 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	a
    //   0	249	1	paramList	List<com.linksure.apservice.a.d.a>
    //   13	138	2	localObject1	Object
    //   152	55	2	localObject2	Object
    //   212	12	2	localIterator	Iterator
    //   21	55	3	localArrayList	ArrayList
    //   137	29	3	localException	Exception
    //   193	7	3	locala	com.linksure.apservice.a.d.a
    //   29	155	4	localObject3	Object
    //   4	73	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   98	107	137	java/lang/Exception
    //   107	134	137	java/lang/Exception
    //   165	173	137	java/lang/Exception
    //   173	203	137	java/lang/Exception
    //   206	213	137	java/lang/Exception
    //   213	235	137	java/lang/Exception
    //   238	242	137	java/lang/Exception
    //   98	107	152	finally
    //   107	134	152	finally
    //   138	152	152	finally
    //   165	173	152	finally
    //   173	203	152	finally
    //   206	213	152	finally
    //   213	235	152	finally
    //   238	242	152	finally
    //   31	84	159	java/lang/Exception
  }
  
  public final long b()
  {
    return DatabaseUtils.queryNumEntries(this.a.a(), "aps_account");
  }
  
  public final void b(String paramString)
  {
    paramString = d(paramString);
    paramString = this.a.a().rawQuery("UPDATE aps_account SET unread=? WHERE aps_id=?", new String[] { "0", paramString });
    paramString.moveToFirst();
    paramString.close();
  }
  
  public final void c(String paramString)
  {
    paramString = d(paramString);
    this.a.a().delete("aps_account", "aps_id=?", new String[] { paramString });
  }
  
  static final class a
  {
    private static a k;
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    
    public static a a(Cursor paramCursor)
    {
      if (k == null)
      {
        a locala = new a();
        k = locala;
        locala.a = paramCursor.getColumnIndex("aps_id");
        k.b = paramCursor.getColumnIndex("stat");
        k.c = paramCursor.getColumnIndex("name");
        k.d = paramCursor.getColumnIndex("type");
        k.g = paramCursor.getColumnIndex("unread");
        k.h = paramCursor.getColumnIndex("latest");
        k.e = paramCursor.getColumnIndex("create_at");
        k.f = paramCursor.getColumnIndex("update_at");
        k.i = paramCursor.getColumnIndex("data");
        k.j = paramCursor.getColumnIndex("menu");
      }
      return k;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */