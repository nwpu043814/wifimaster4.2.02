package com.linksure.apservice.a.a.b;

import com.linksure.apservice.a.a.g;

public final class f
  implements g
{
  /* Error */
  public final com.linksure.apservice.a.d.f a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_1
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokevirtual 21	java/lang/String:length	()I
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 23	org/json/JSONObject
    //   22: astore 4
    //   24: aload 4
    //   26: aload_1
    //   27: invokespecial 26	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: aload_3
    //   31: astore_2
    //   32: ldc 28
    //   34: aload 4
    //   36: ldc 30
    //   38: invokevirtual 34	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokevirtual 38	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   44: ifeq -27 -> 17
    //   47: aload 4
    //   49: invokestatic 44	com/linksure/apservice/a/a/c/c:b	(Lorg/json/JSONObject;)Lcom/linksure/apservice/a/d/f;
    //   52: astore_2
    //   53: goto -36 -> 17
    //   56: astore_1
    //   57: new 46	com/linksure/apservice/a/d/a/c
    //   60: dup
    //   61: ldc 48
    //   63: aload_1
    //   64: invokespecial 51	com/linksure/apservice/a/d/a/c:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	f
    //   0	68	1	paramString	String
    //   3	50	2	localObject1	Object
    //   1	30	3	localObject2	Object
    //   22	26	4	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   8	15	56	java/lang/Exception
    //   19	30	56	java/lang/Exception
    //   32	53	56	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */