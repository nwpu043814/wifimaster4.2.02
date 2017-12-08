package ct;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.Deflater;

public final class j
{
  public static as a(String paramString)
  {
    Object localObject1 = null;
    if (paramString == null) {}
    for (;;)
    {
      return (as)localObject1;
      aq localaq = aq.k();
      if (localaq != null)
      {
        long l = SystemClock.elapsedRealtime();
        Object localObject2 = ba.a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("A23", d(localaq.e()));
        localObject2 = new as();
        ((as)localObject2).c(paramString);
        ((as)localObject2).a(l);
        ((as)localObject2).a(localHashMap);
        ((as)localObject2).b(localaq.a());
        ((as)localObject2).a((String)localObject1);
        localObject1 = localObject2;
      }
    }
  }
  
  public static au a(bg parambg)
  {
    az localaz = new az(parambg);
    try
    {
      localaz.j();
      return localaz;
    }
    catch (Exception parambg)
    {
      for (;;)
      {
        localaz.b = -2;
        localaz.c = bc.a(parambg);
      }
    }
  }
  
  public static String a(as paramas)
  {
    localStringBuilder = new StringBuilder();
    Object localObject1 = new StringBuilder();
    long l = System.currentTimeMillis();
    Object localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(l);
    localStringBuilder.append(((SimpleDateFormat)localObject3).format(((Calendar)localObject2).getTime()) + "|");
    localStringBuilder.append("INFO|");
    localStringBuilder.append(p.b() + "|");
    localObject3 = aq.k();
    if (localObject3 != null) {
      localStringBuilder.append(aq.k().c() + "|");
    }
    for (;;)
    {
      localStringBuilder.append("beacon|");
      localStringBuilder.append("1.8.1|");
      localObject1 = paramas.e();
      try
      {
        localObject2 = URLEncoder.encode(paramas.e(), "utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          continue;
          localStringBuilder.append("unknow\n");
        }
      }
      localStringBuilder.append((String)localObject1 + "|");
      localStringBuilder.append("qua|");
      localStringBuilder.append("upload_ip|");
      localStringBuilder.append("unknown|");
      localStringBuilder.append(paramas.d() + "|");
      localStringBuilder.append(paramas.g() + "|");
      localStringBuilder.append(paramas.a() + "|");
      localStringBuilder.append(as.c() + "|");
      localStringBuilder.append(as.b() + "|");
      localObject1 = a(paramas.h());
      localStringBuilder.append((String)localObject1 + "|");
      localObject1 = new StringBuilder();
      l = paramas.f();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      paramas = Calendar.getInstance();
      paramas.setTimeInMillis(l);
      localStringBuilder.append(((SimpleDateFormat)localObject2).format(paramas.getTime()) + "|");
      localStringBuilder.append("upload_time|");
      if (localObject3 == null) {
        break;
      }
      localStringBuilder.append(((aq)localObject3).b() + "\n");
      return localStringBuilder.toString();
      localStringBuilder.append("unknow|");
    }
  }
  
  private static String a(Map paramMap)
  {
    if (paramMap == null) {
      paramMap = "";
    }
    for (;;)
    {
      return paramMap;
      Object localObject = paramMap.keySet();
      if (localObject == null)
      {
        paramMap = "";
      }
      else
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localStringBuffer.append("&");
          localStringBuffer.append(str);
          localStringBuffer.append("=");
          localStringBuffer.append((String)paramMap.get(str));
        }
        paramMap = localStringBuffer.substring(1);
        localStringBuffer.setLength(0);
      }
    }
  }
  
  public static HashMap a(an paraman)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("B50", paraman.d);
    localHashMap.put("B51", c(paraman.g));
    localHashMap.put("B69", c(paraman.e));
    localHashMap.put("B52", paraman.h);
    localHashMap.put("B53", c(paraman.j));
    localHashMap.put("B54", paraman.k);
    localHashMap.put("B55", paraman.m);
    localHashMap.put("B56", paraman.n);
    if (!TextUtils.isEmpty(paraman.o)) {
      localHashMap.put("B57", c(paraman.o));
    }
    if ((!TextUtils.isEmpty(paraman.p)) && (!paraman.p.equals("null"))) {
      localHashMap.put("B58", c(paraman.p));
    }
    localHashMap.put("B59", paraman.q);
    localHashMap.put("B63", paraman.z);
    localHashMap.put("B60", paraman.r);
    localHashMap.put("B61", paraman.s);
    localHashMap.put("B62", paraman.t);
    localHashMap.put("B71", paraman.w);
    localHashMap.put("B76", paraman.x);
    return localHashMap;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length != 0) {
        break label15;
      }
    }
    label15:
    ByteArrayOutputStream localByteArrayOutputStream;
    for (localObject = paramArrayOfByte;; localObject = localByteArrayOutputStream.toByteArray())
    {
      return (byte[])localObject;
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new Deflater();
      ((Deflater)localObject).setInput(paramArrayOfByte);
      ((Deflater)localObject).finish();
      paramArrayOfByte = new byte['Ā'];
      while (!((Deflater)localObject).finished()) {
        localByteArrayOutputStream.write(paramArrayOfByte, 0, ((Deflater)localObject).deflate(paramArrayOfByte));
      }
      ((Deflater)localObject).finish();
    }
  }
  
  /* Error */
  public static boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 378	java/net/Socket
    //   5: astore 4
    //   7: aload 4
    //   9: invokespecial 379	java/net/Socket:<init>	()V
    //   12: aload 4
    //   14: astore_3
    //   15: new 381	java/net/InetSocketAddress
    //   18: astore 5
    //   20: aload 4
    //   22: astore_3
    //   23: aload 5
    //   25: aload_0
    //   26: bipush 80
    //   28: invokespecial 384	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   31: aload 4
    //   33: astore_3
    //   34: aload 4
    //   36: aload 5
    //   38: sipush 15000
    //   41: invokevirtual 388	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   44: iconst_1
    //   45: istore_1
    //   46: aload 4
    //   48: invokevirtual 391	java/net/Socket:close	()V
    //   51: iload_1
    //   52: ireturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   58: goto -7 -> 51
    //   61: astore 5
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_0
    //   66: astore_3
    //   67: aload 5
    //   69: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   72: iload_2
    //   73: istore_1
    //   74: aload_0
    //   75: ifnull -24 -> 51
    //   78: aload_0
    //   79: invokevirtual 391	java/net/Socket:close	()V
    //   82: iload_2
    //   83: istore_1
    //   84: goto -33 -> 51
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   92: iload_2
    //   93: istore_1
    //   94: goto -43 -> 51
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_3
    //   100: aload_3
    //   101: ifnull +7 -> 108
    //   104: aload_3
    //   105: invokevirtual 391	java/net/Socket:close	()V
    //   108: aload_0
    //   109: athrow
    //   110: astore_3
    //   111: aload_3
    //   112: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   115: goto -7 -> 108
    //   118: astore_0
    //   119: goto -19 -> 100
    //   122: astore 5
    //   124: aload 4
    //   126: astore_0
    //   127: goto -62 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramString	String
    //   45	49	1	bool1	boolean
    //   1	92	2	bool2	boolean
    //   14	91	3	localObject	Object
    //   110	2	3	localThrowable1	Throwable
    //   5	120	4	localSocket	java.net.Socket
    //   18	19	5	localInetSocketAddress	java.net.InetSocketAddress
    //   61	7	5	localThrowable2	Throwable
    //   122	1	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   46	51	53	java/lang/Throwable
    //   2	12	61	java/lang/Throwable
    //   78	82	87	java/lang/Throwable
    //   2	12	97	finally
    //   104	108	110	java/lang/Throwable
    //   15	20	118	finally
    //   23	31	118	finally
    //   34	44	118	finally
    //   67	72	118	finally
    //   15	20	122	java/lang/Throwable
    //   23	31	122	java/lang/Throwable
    //   34	44	122	java/lang/Throwable
  }
  
  private static String c(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
    }
    return str;
  }
  
  private static String d(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str1 = URLEncoder.encode(paramString, "utf-8");
      return str1;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        str1 = str2;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */