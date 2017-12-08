package com.alipay.sdk.d;

public final class c
{
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 10	java/io/ByteArrayInputStream
    //   6: astore_2
    //   7: aload_2
    //   8: aload_0
    //   9: invokespecial 14	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: new 16	java/io/ByteArrayOutputStream
    //   15: astore_0
    //   16: aload_0
    //   17: invokespecial 19	java/io/ByteArrayOutputStream:<init>	()V
    //   20: new 21	java/util/zip/GZIPOutputStream
    //   23: astore 6
    //   25: aload 6
    //   27: aload_0
    //   28: invokespecial 24	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: sipush 4096
    //   34: newarray <illegal type>
    //   36: astore_3
    //   37: aload_2
    //   38: aload_3
    //   39: invokevirtual 28	java/io/ByteArrayInputStream:read	([B)I
    //   42: istore_1
    //   43: iload_1
    //   44: iconst_m1
    //   45: if_icmpeq +55 -> 100
    //   48: aload 6
    //   50: aload_3
    //   51: iconst_0
    //   52: iload_1
    //   53: invokevirtual 32	java/util/zip/GZIPOutputStream:write	([BII)V
    //   56: goto -19 -> 37
    //   59: astore 5
    //   61: aload_2
    //   62: astore_3
    //   63: aload_0
    //   64: astore 4
    //   66: aload 6
    //   68: astore_2
    //   69: aload 5
    //   71: astore_0
    //   72: aload_3
    //   73: ifnull +7 -> 80
    //   76: aload_3
    //   77: invokevirtual 35	java/io/ByteArrayInputStream:close	()V
    //   80: aload 4
    //   82: ifnull +8 -> 90
    //   85: aload 4
    //   87: invokevirtual 36	java/io/ByteArrayOutputStream:close	()V
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 37	java/util/zip/GZIPOutputStream:close	()V
    //   98: aload_0
    //   99: athrow
    //   100: aload 6
    //   102: invokevirtual 40	java/util/zip/GZIPOutputStream:flush	()V
    //   105: aload 6
    //   107: invokevirtual 43	java/util/zip/GZIPOutputStream:finish	()V
    //   110: aload_0
    //   111: invokevirtual 47	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   114: astore_3
    //   115: aload_2
    //   116: invokevirtual 35	java/io/ByteArrayInputStream:close	()V
    //   119: aload_0
    //   120: invokevirtual 36	java/io/ByteArrayOutputStream:close	()V
    //   123: aload 6
    //   125: invokevirtual 37	java/util/zip/GZIPOutputStream:close	()V
    //   128: aload_3
    //   129: areturn
    //   130: astore_2
    //   131: goto -12 -> 119
    //   134: astore_0
    //   135: goto -12 -> 123
    //   138: astore_0
    //   139: goto -11 -> 128
    //   142: astore_3
    //   143: goto -63 -> 80
    //   146: astore_3
    //   147: goto -57 -> 90
    //   150: astore_2
    //   151: goto -53 -> 98
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_2
    //   157: aconst_null
    //   158: astore_3
    //   159: goto -87 -> 72
    //   162: astore_0
    //   163: aconst_null
    //   164: astore 5
    //   166: aload_2
    //   167: astore_3
    //   168: aload 5
    //   170: astore_2
    //   171: goto -99 -> 72
    //   174: astore 5
    //   176: aconst_null
    //   177: astore 6
    //   179: aload_0
    //   180: astore 4
    //   182: aload_2
    //   183: astore_3
    //   184: aload 5
    //   186: astore_0
    //   187: aload 6
    //   189: astore_2
    //   190: goto -118 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramArrayOfByte	byte[]
    //   42	11	1	i	int
    //   6	110	2	localObject1	Object
    //   130	1	2	localException1	Exception
    //   150	1	2	localException2	Exception
    //   156	34	2	localObject2	Object
    //   36	93	3	localObject3	Object
    //   142	1	3	localException3	Exception
    //   146	1	3	localException4	Exception
    //   158	26	3	localObject4	Object
    //   1	180	4	arrayOfByte	byte[]
    //   59	11	5	localObject5	Object
    //   164	5	5	localObject6	Object
    //   174	11	5	localObject7	Object
    //   23	165	6	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	37	59	finally
    //   37	43	59	finally
    //   48	56	59	finally
    //   100	115	59	finally
    //   115	119	130	java/lang/Exception
    //   119	123	134	java/lang/Exception
    //   123	128	138	java/lang/Exception
    //   76	80	142	java/lang/Exception
    //   85	90	146	java/lang/Exception
    //   94	98	150	java/lang/Exception
    //   3	12	154	finally
    //   12	20	162	finally
    //   20	31	174	finally
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 10	java/io/ByteArrayInputStream
    //   6: astore_2
    //   7: aload_2
    //   8: aload_0
    //   9: invokespecial 14	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: new 51	java/util/zip/GZIPInputStream
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: invokespecial 54	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: sipush 4096
    //   24: newarray <illegal type>
    //   26: astore_0
    //   27: new 16	java/io/ByteArrayOutputStream
    //   30: astore 5
    //   32: aload 5
    //   34: invokespecial 19	java/io/ByteArrayOutputStream:<init>	()V
    //   37: aload_3
    //   38: aload_0
    //   39: iconst_0
    //   40: sipush 4096
    //   43: invokevirtual 57	java/util/zip/GZIPInputStream:read	([BII)I
    //   46: istore_1
    //   47: iload_1
    //   48: iconst_m1
    //   49: if_icmpeq +34 -> 83
    //   52: aload 5
    //   54: aload_0
    //   55: iconst_0
    //   56: iload_1
    //   57: invokevirtual 58	java/io/ByteArrayOutputStream:write	([BII)V
    //   60: goto -23 -> 37
    //   63: astore_0
    //   64: aload 5
    //   66: astore 4
    //   68: aload 4
    //   70: invokevirtual 36	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_3
    //   74: invokevirtual 59	java/util/zip/GZIPInputStream:close	()V
    //   77: aload_2
    //   78: invokevirtual 35	java/io/ByteArrayInputStream:close	()V
    //   81: aload_0
    //   82: athrow
    //   83: aload 5
    //   85: invokevirtual 60	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload 5
    //   90: invokevirtual 47	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   93: astore_0
    //   94: aload 5
    //   96: invokevirtual 36	java/io/ByteArrayOutputStream:close	()V
    //   99: aload_3
    //   100: invokevirtual 59	java/util/zip/GZIPInputStream:close	()V
    //   103: aload_2
    //   104: invokevirtual 35	java/io/ByteArrayInputStream:close	()V
    //   107: aload_0
    //   108: areturn
    //   109: astore 4
    //   111: goto -12 -> 99
    //   114: astore_3
    //   115: goto -12 -> 103
    //   118: astore_2
    //   119: goto -12 -> 107
    //   122: astore 4
    //   124: goto -51 -> 73
    //   127: astore_3
    //   128: goto -51 -> 77
    //   131: astore_2
    //   132: goto -51 -> 81
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_3
    //   138: aconst_null
    //   139: astore_2
    //   140: goto -72 -> 68
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_3
    //   146: goto -78 -> 68
    //   149: astore_0
    //   150: goto -82 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramArrayOfByte	byte[]
    //   46	11	1	i	int
    //   6	98	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   118	1	2	localException1	Exception
    //   131	1	2	localException2	Exception
    //   139	1	2	localObject1	Object
    //   15	85	3	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   114	1	3	localException3	Exception
    //   127	1	3	localException4	Exception
    //   137	9	3	localObject2	Object
    //   1	68	4	localObject3	Object
    //   109	1	4	localException5	Exception
    //   122	1	4	localException6	Exception
    //   30	65	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	47	63	finally
    //   52	60	63	finally
    //   83	94	63	finally
    //   94	99	109	java/lang/Exception
    //   99	103	114	java/lang/Exception
    //   103	107	118	java/lang/Exception
    //   68	73	122	java/lang/Exception
    //   73	77	127	java/lang/Exception
    //   77	81	131	java/lang/Exception
    //   3	12	135	finally
    //   12	21	143	finally
    //   21	37	149	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */