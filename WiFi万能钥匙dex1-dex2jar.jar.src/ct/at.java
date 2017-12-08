package ct;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class at
{
  private static int a = 2;
  private static int b = 15;
  private static List c;
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    p.a();
    paramString = j.a(paramString);
    a(paramHashMap);
    paramString.a(paramHashMap);
    if (c == null) {
      c = new ArrayList();
    }
    c.add(paramString);
    if (ap.b(p.a()))
    {
      p.a();
      paramHashMap = j.a("rqd_applaunched");
      paramString = new HashMap();
      a(paramString);
      if (!ap.b(p.a())) {
        break label129;
      }
      paramString.put("A21", "Y");
    }
    for (;;)
    {
      paramHashMap.a(paramString);
      c.add(paramHashMap);
      if (c.size() >= a) {
        a(c);
      }
      return;
      label129:
      paramString.put("A21", "N");
    }
  }
  
  private static void a(HashMap paramHashMap)
  {
    aq localaq = aq.k();
    if (localaq != null)
    {
      paramHashMap.put("A1", p.e());
      paramHashMap.put("A2", localaq.d());
      paramHashMap.put("A4", localaq.f());
      paramHashMap.put("A6", localaq.g());
      paramHashMap.put("A7", localaq.h());
      paramHashMap.put("A23", p.g());
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = p.a();
      Object localObject1 = "null";
      if (ar.a((Context)localObject2) != null)
      {
        localObject2 = ar.f((Context)localObject2);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
      }
      paramHashMap.put("A33", (String)localObject1);
      paramHashMap.put("A10", localaq.j());
      paramHashMap.put("A9", localaq.i());
      paramHashMap.put("A19", ba.a);
      paramHashMap.put("A20", ba.b);
    }
  }
  
  /* Error */
  private static void a(List paramList)
  {
    // Byte code:
    //   0: new 85	java/lang/StringBuilder
    //   3: astore_3
    //   4: aload_3
    //   5: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8: new 39	java/util/ArrayList
    //   11: astore_2
    //   12: aload_2
    //   13: invokespecial 42	java/util/ArrayList:<init>	()V
    //   16: aload_2
    //   17: aload_0
    //   18: invokeinterface 161 2 0
    //   23: pop
    //   24: aload_2
    //   25: invokeinterface 165 1 0
    //   30: astore_0
    //   31: aload_0
    //   32: invokeinterface 171 1 0
    //   37: ifeq +29 -> 66
    //   40: aload_3
    //   41: aload_0
    //   42: invokeinterface 175 1 0
    //   47: checkcast 32	ct/as
    //   50: invokestatic 178	ct/j:a	(Lct/as;)Ljava/lang/String;
    //   53: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -26 -> 31
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   65: return
    //   66: aload_3
    //   67: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 187	java/lang/String:getBytes	()[B
    //   73: invokestatic 190	ct/j:a	([B)[B
    //   76: astore_0
    //   77: new 192	ct/ao
    //   80: astore_3
    //   81: aload_3
    //   82: ldc -62
    //   84: invokevirtual 187	java/lang/String:getBytes	()[B
    //   87: invokespecial 197	ct/ao:<init>	([B)V
    //   90: aload_3
    //   91: aload_0
    //   92: invokevirtual 198	ct/ao:a	([B)[B
    //   95: astore 4
    //   97: aload 4
    //   99: arraylength
    //   100: ifle +167 -> 267
    //   103: new 200	org/apache/http/params/BasicHttpParams
    //   106: astore_3
    //   107: aload_3
    //   108: invokespecial 201	org/apache/http/params/BasicHttpParams:<init>	()V
    //   111: aload_3
    //   112: sipush 30000
    //   115: invokestatic 207	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   118: aload_3
    //   119: sipush 30000
    //   122: invokestatic 210	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   125: new 212	org/apache/http/impl/client/DefaultHttpClient
    //   128: astore_0
    //   129: aload_0
    //   130: aload_3
    //   131: invokespecial 215	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   134: new 217	org/apache/http/entity/ByteArrayEntity
    //   137: astore 6
    //   139: aload 6
    //   141: aload 4
    //   143: invokespecial 218	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   146: new 220	org/apache/http/client/methods/HttpPost
    //   149: astore_3
    //   150: new 85	java/lang/StringBuilder
    //   153: astore 5
    //   155: aload 5
    //   157: ldc -34
    //   159: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: aload_3
    //   163: aload 5
    //   165: aload 4
    //   167: arraylength
    //   168: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 229	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   177: aload_3
    //   178: checkcast 220	org/apache/http/client/methods/HttpPost
    //   181: aload 6
    //   183: invokevirtual 233	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   186: getstatic 236	ct/ba:c	Z
    //   189: ifeq +39 -> 228
    //   192: invokestatic 241	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   195: astore 4
    //   197: invokestatic 244	android/net/Proxy:getDefaultPort	()I
    //   200: istore_1
    //   201: new 246	org/apache/http/HttpHost
    //   204: astore 5
    //   206: aload 5
    //   208: aload 4
    //   210: iload_1
    //   211: invokespecial 249	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   214: aload_0
    //   215: invokevirtual 253	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   218: ldc -1
    //   220: aload 5
    //   222: invokeinterface 261 3 0
    //   227: pop
    //   228: aload_0
    //   229: aload_3
    //   230: invokevirtual 265	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   233: astore_0
    //   234: aload_0
    //   235: invokeinterface 271 1 0
    //   240: invokeinterface 276 1 0
    //   245: istore_1
    //   246: aload_0
    //   247: ifnull +20 -> 267
    //   250: iload_1
    //   251: sipush 200
    //   254: if_icmpne +13 -> 267
    //   257: getstatic 37	ct/at:c	Ljava/util/List;
    //   260: aload_2
    //   261: invokeinterface 279 2 0
    //   266: pop
    //   267: getstatic 37	ct/at:c	Ljava/util/List;
    //   270: invokeinterface 70 1 0
    //   275: getstatic 15	ct/at:b	I
    //   278: if_icmplt -213 -> 65
    //   281: getstatic 37	ct/at:c	Ljava/util/List;
    //   284: invokeinterface 282 1 0
    //   289: goto -224 -> 65
    //   292: astore_0
    //   293: getstatic 37	ct/at:c	Ljava/util/List;
    //   296: invokeinterface 282 1 0
    //   301: goto -236 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramList	List
    //   200	55	1	i	int
    //   11	250	2	localArrayList	ArrayList
    //   3	227	3	localObject1	Object
    //   95	114	4	localObject2	Object
    //   153	68	5	localObject3	Object
    //   137	45	6	localByteArrayEntity	org.apache.http.entity.ByteArrayEntity
    // Exception table:
    //   from	to	target	type
    //   0	31	60	java/lang/Exception
    //   31	57	60	java/lang/Exception
    //   66	228	60	java/lang/Exception
    //   228	246	60	java/lang/Exception
    //   257	267	60	java/lang/Exception
    //   267	289	60	java/lang/Exception
    //   0	31	292	java/lang/OutOfMemoryError
    //   31	57	292	java/lang/OutOfMemoryError
    //   66	228	292	java/lang/OutOfMemoryError
    //   228	246	292	java/lang/OutOfMemoryError
    //   257	267	292	java/lang/OutOfMemoryError
    //   267	289	292	java/lang/OutOfMemoryError
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */