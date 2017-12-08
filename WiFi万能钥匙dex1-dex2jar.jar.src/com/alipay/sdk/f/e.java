package com.alipay.sdk.f;

import com.alipay.sdk.b.a;
import com.alipay.sdk.d.d;
import com.alipay.sdk.j.k;

public final class e
{
  private boolean a;
  private String b;
  
  public e(boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.b = k.d();
  }
  
  /* Error */
  private static byte[] a(byte[]... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: arraylength
    //   7: ifne +8 -> 15
    //   10: aload 5
    //   12: astore_3
    //   13: aload_3
    //   14: areturn
    //   15: new 29	java/io/ByteArrayOutputStream
    //   18: astore 4
    //   20: aload 4
    //   22: invokespecial 30	java/io/ByteArrayOutputStream:<init>	()V
    //   25: new 32	java/io/DataOutputStream
    //   28: astore_3
    //   29: aload_3
    //   30: aload 4
    //   32: invokespecial 35	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: iload_1
    //   36: aload_0
    //   37: arraylength
    //   38: if_icmpge +47 -> 85
    //   41: aload_0
    //   42: iload_1
    //   43: aaload
    //   44: arraylength
    //   45: istore_2
    //   46: aload_3
    //   47: invokestatic 41	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   50: ldc 43
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: iload_2
    //   59: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 55	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   66: invokevirtual 59	java/lang/String:getBytes	()[B
    //   69: invokevirtual 63	java/io/DataOutputStream:write	([B)V
    //   72: aload_3
    //   73: aload_0
    //   74: iload_1
    //   75: aaload
    //   76: invokevirtual 63	java/io/DataOutputStream:write	([B)V
    //   79: iinc 1 1
    //   82: goto -47 -> 35
    //   85: aload_3
    //   86: invokevirtual 66	java/io/DataOutputStream:flush	()V
    //   89: aload 4
    //   91: invokevirtual 69	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: astore_0
    //   95: aload 4
    //   97: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   100: aload_3
    //   101: invokevirtual 73	java/io/DataOutputStream:close	()V
    //   104: aload_0
    //   105: astore_3
    //   106: goto -93 -> 13
    //   109: astore_3
    //   110: aload_0
    //   111: astore_3
    //   112: goto -99 -> 13
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_0
    //   118: aconst_null
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull +8 -> 131
    //   126: aload 4
    //   128: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   131: aload 5
    //   133: astore_3
    //   134: aload_0
    //   135: ifnull -122 -> 13
    //   138: aload_0
    //   139: invokevirtual 73	java/io/DataOutputStream:close	()V
    //   142: aload 5
    //   144: astore_3
    //   145: goto -132 -> 13
    //   148: astore_0
    //   149: aload 5
    //   151: astore_3
    //   152: goto -139 -> 13
    //   155: astore_0
    //   156: aconst_null
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_3
    //   161: aload 4
    //   163: ifnull +8 -> 171
    //   166: aload 4
    //   168: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 73	java/io/DataOutputStream:close	()V
    //   179: aload_0
    //   180: athrow
    //   181: astore 4
    //   183: goto -83 -> 100
    //   186: astore_3
    //   187: goto -56 -> 131
    //   190: astore 4
    //   192: goto -21 -> 171
    //   195: astore_3
    //   196: goto -17 -> 179
    //   199: astore_0
    //   200: aconst_null
    //   201: astore_3
    //   202: goto -41 -> 161
    //   205: astore_0
    //   206: goto -45 -> 161
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_0
    //   212: goto -91 -> 121
    //   215: astore_0
    //   216: aload_3
    //   217: astore_0
    //   218: goto -97 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramVarArgs	byte[][]
    //   1	79	1	i	int
    //   45	14	2	j	int
    //   12	94	3	localObject1	Object
    //   109	1	3	localException1	Exception
    //   111	65	3	localObject2	Object
    //   186	1	3	localException2	Exception
    //   195	1	3	localException3	Exception
    //   201	16	3	localObject3	Object
    //   18	149	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   181	1	4	localException4	Exception
    //   190	1	4	localException5	Exception
    //   3	147	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   100	104	109	java/lang/Exception
    //   15	25	115	java/lang/Exception
    //   138	142	148	java/lang/Exception
    //   15	25	155	finally
    //   95	100	181	java/lang/Exception
    //   126	131	186	java/lang/Exception
    //   166	171	190	java/lang/Exception
    //   175	179	195	java/lang/Exception
    //   25	35	199	finally
    //   35	79	205	finally
    //   85	95	205	finally
    //   25	35	209	java/lang/Exception
    //   35	79	215	java/lang/Exception
    //   85	95	215	java/lang/Exception
  }
  
  /* Error */
  public final b a(c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 76	java/io/ByteArrayInputStream
    //   6: astore 4
    //   8: aload 4
    //   10: aload_1
    //   11: getfield 81	com/alipay/sdk/f/c:b	[B
    //   14: invokespecial 83	java/io/ByteArrayInputStream:<init>	([B)V
    //   17: iconst_5
    //   18: newarray <illegal type>
    //   20: astore_3
    //   21: aload 4
    //   23: aload_3
    //   24: invokevirtual 87	java/io/ByteArrayInputStream:read	([B)I
    //   27: pop
    //   28: new 51	java/lang/String
    //   31: astore 5
    //   33: aload 5
    //   35: aload_3
    //   36: invokespecial 88	java/lang/String:<init>	([B)V
    //   39: aload 5
    //   41: invokestatic 92	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   44: newarray <illegal type>
    //   46: astore_3
    //   47: aload 4
    //   49: aload_3
    //   50: invokevirtual 87	java/io/ByteArrayInputStream:read	([B)I
    //   53: pop
    //   54: new 51	java/lang/String
    //   57: astore 5
    //   59: aload 5
    //   61: aload_3
    //   62: invokespecial 88	java/lang/String:<init>	([B)V
    //   65: iconst_5
    //   66: newarray <illegal type>
    //   68: astore_3
    //   69: aload 4
    //   71: aload_3
    //   72: invokevirtual 87	java/io/ByteArrayInputStream:read	([B)I
    //   75: pop
    //   76: new 51	java/lang/String
    //   79: astore 7
    //   81: aload 7
    //   83: aload_3
    //   84: invokespecial 88	java/lang/String:<init>	([B)V
    //   87: aload 7
    //   89: invokestatic 92	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   92: istore_2
    //   93: iload_2
    //   94: ifle +173 -> 267
    //   97: iload_2
    //   98: newarray <illegal type>
    //   100: astore 7
    //   102: aload 4
    //   104: aload 7
    //   106: invokevirtual 87	java/io/ByteArrayInputStream:read	([B)I
    //   109: pop
    //   110: aload 7
    //   112: astore_3
    //   113: aload_0
    //   114: getfield 15	com/alipay/sdk/f/e:a	Z
    //   117: ifeq +13 -> 130
    //   120: aload_0
    //   121: getfield 23	com/alipay/sdk/f/e:b	Ljava/lang/String;
    //   124: aload 7
    //   126: invokestatic 97	com/alipay/sdk/d/e:b	(Ljava/lang/String;[B)[B
    //   129: astore_3
    //   130: aload_1
    //   131: getfield 98	com/alipay/sdk/f/c:a	Z
    //   134: ifeq +128 -> 262
    //   137: aload_3
    //   138: invokestatic 103	com/alipay/sdk/d/c:b	([B)[B
    //   141: astore_1
    //   142: new 51	java/lang/String
    //   145: astore_3
    //   146: aload_3
    //   147: aload_1
    //   148: invokespecial 88	java/lang/String:<init>	([B)V
    //   151: aload_3
    //   152: astore_1
    //   153: aload 4
    //   155: invokevirtual 104	java/io/ByteArrayInputStream:close	()V
    //   158: aload_1
    //   159: astore_3
    //   160: aload 5
    //   162: astore_1
    //   163: aload_1
    //   164: ifnonnull +64 -> 228
    //   167: aload_3
    //   168: ifnonnull +60 -> 228
    //   171: aload 6
    //   173: astore_1
    //   174: aload_1
    //   175: areturn
    //   176: astore_3
    //   177: aload_1
    //   178: astore_3
    //   179: aload 5
    //   181: astore_1
    //   182: goto -19 -> 163
    //   185: astore_1
    //   186: aconst_null
    //   187: astore 4
    //   189: aconst_null
    //   190: astore_1
    //   191: aload 4
    //   193: ifnull +14 -> 207
    //   196: aload 4
    //   198: invokevirtual 104	java/io/ByteArrayInputStream:close	()V
    //   201: aconst_null
    //   202: astore_3
    //   203: goto -40 -> 163
    //   206: astore_3
    //   207: aconst_null
    //   208: astore_3
    //   209: goto -46 -> 163
    //   212: astore_1
    //   213: aconst_null
    //   214: astore 4
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 104	java/io/ByteArrayInputStream:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: new 106	com/alipay/sdk/f/b
    //   231: dup
    //   232: aload_1
    //   233: aload_3
    //   234: invokespecial 109	com/alipay/sdk/f/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: astore_1
    //   238: goto -64 -> 174
    //   241: astore_3
    //   242: goto -16 -> 226
    //   245: astore_1
    //   246: goto -30 -> 216
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_1
    //   252: goto -61 -> 191
    //   255: astore_1
    //   256: aload 5
    //   258: astore_1
    //   259: goto -68 -> 191
    //   262: aload_3
    //   263: astore_1
    //   264: goto -122 -> 142
    //   267: aconst_null
    //   268: astore_1
    //   269: goto -116 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	e
    //   0	272	1	paramc	c
    //   92	6	2	i	int
    //   20	148	3	localObject1	Object
    //   176	1	3	localException1	Exception
    //   178	25	3	localc	c
    //   206	1	3	localException2	Exception
    //   208	26	3	str1	String
    //   241	22	3	localException3	Exception
    //   6	216	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   31	226	5	str2	String
    //   1	171	6	localObject2	Object
    //   79	46	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   153	158	176	java/lang/Exception
    //   3	17	185	java/lang/Exception
    //   196	201	206	java/lang/Exception
    //   3	17	212	finally
    //   221	226	241	java/lang/Exception
    //   17	65	245	finally
    //   65	93	245	finally
    //   97	110	245	finally
    //   113	130	245	finally
    //   130	142	245	finally
    //   142	151	245	finally
    //   17	65	249	java/lang/Exception
    //   65	93	255	java/lang/Exception
    //   97	110	255	java/lang/Exception
    //   113	130	255	java/lang/Exception
    //   130	142	255	java/lang/Exception
    //   142	151	255	java/lang/Exception
  }
  
  public final c a(b paramb, boolean paramBoolean)
  {
    arrayOfByte2 = paramb.a.getBytes();
    arrayOfByte1 = paramb.b.getBytes();
    paramb = arrayOfByte1;
    bool = paramBoolean;
    if (paramBoolean) {}
    try
    {
      paramb = com.alipay.sdk.d.c.a(arrayOfByte1);
      bool = paramBoolean;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        bool = false;
        paramb = arrayOfByte1;
        continue;
        paramb = a(new byte[][] { arrayOfByte2, paramb });
      }
    }
    if (this.a)
    {
      paramb = a(new byte[][] { arrayOfByte2, d.a(this.b, a.b), com.alipay.sdk.d.e.a(this.b, paramb) });
      return new c(bool, paramb);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */