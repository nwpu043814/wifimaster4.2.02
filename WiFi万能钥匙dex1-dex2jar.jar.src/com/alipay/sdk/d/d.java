package com.alipay.sdk.d;

public final class d
{
  /* Error */
  public static byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 15	com/alipay/sdk/d/a:a	(Ljava/lang/String;)[B
    //   7: astore 6
    //   9: new 17	java/security/spec/X509EncodedKeySpec
    //   12: astore_1
    //   13: aload_1
    //   14: aload 6
    //   16: invokespecial 21	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   19: ldc 23
    //   21: invokestatic 29	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   24: aload_1
    //   25: invokevirtual 33	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   28: astore 6
    //   30: ldc 35
    //   32: invokestatic 40	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   35: astore_1
    //   36: aload_1
    //   37: iconst_1
    //   38: aload 6
    //   40: invokevirtual 44	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   43: aload_0
    //   44: ldc 46
    //   46: invokevirtual 51	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   49: astore 6
    //   51: aload_1
    //   52: invokevirtual 55	javax/crypto/Cipher:getBlockSize	()I
    //   55: istore 4
    //   57: new 57	java/io/ByteArrayOutputStream
    //   60: astore_0
    //   61: aload_0
    //   62: invokespecial 60	java/io/ByteArrayOutputStream:<init>	()V
    //   65: iconst_0
    //   66: istore_2
    //   67: iload_2
    //   68: aload 6
    //   70: arraylength
    //   71: if_icmpge +45 -> 116
    //   74: aload 6
    //   76: arraylength
    //   77: iload_2
    //   78: isub
    //   79: iload 4
    //   81: if_icmpge +29 -> 110
    //   84: aload 6
    //   86: arraylength
    //   87: iload_2
    //   88: isub
    //   89: istore_3
    //   90: aload_0
    //   91: aload_1
    //   92: aload 6
    //   94: iload_2
    //   95: iload_3
    //   96: invokevirtual 64	javax/crypto/Cipher:doFinal	([BII)[B
    //   99: invokevirtual 67	java/io/ByteArrayOutputStream:write	([B)V
    //   102: iload_2
    //   103: iload 4
    //   105: iadd
    //   106: istore_2
    //   107: goto -40 -> 67
    //   110: iload 4
    //   112: istore_3
    //   113: goto -23 -> 90
    //   116: aload_0
    //   117: invokevirtual 71	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   120: astore_1
    //   121: aload_0
    //   122: invokevirtual 74	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_1
    //   126: areturn
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_0
    //   130: aload 5
    //   132: astore_1
    //   133: aload_0
    //   134: ifnull -9 -> 125
    //   137: aload_0
    //   138: invokevirtual 74	java/io/ByteArrayOutputStream:close	()V
    //   141: aload 5
    //   143: astore_1
    //   144: goto -19 -> 125
    //   147: astore_0
    //   148: aload 5
    //   150: astore_1
    //   151: goto -26 -> 125
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_0
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 74	java/io/ByteArrayOutputStream:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_0
    //   168: goto -43 -> 125
    //   171: astore_0
    //   172: goto -7 -> 165
    //   175: astore_1
    //   176: goto -19 -> 157
    //   179: astore_1
    //   180: goto -50 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString1	String
    //   0	183	1	paramString2	String
    //   66	41	2	i	int
    //   89	24	3	j	int
    //   55	56	4	k	int
    //   1	148	5	localObject1	Object
    //   7	86	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	65	127	java/lang/Exception
    //   137	141	147	java/io/IOException
    //   3	65	154	finally
    //   121	125	167	java/io/IOException
    //   161	165	171	java/io/IOException
    //   67	90	175	finally
    //   90	102	175	finally
    //   116	121	175	finally
    //   67	90	179	java/lang/Exception
    //   90	102	179	java/lang/Exception
    //   116	121	179	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */