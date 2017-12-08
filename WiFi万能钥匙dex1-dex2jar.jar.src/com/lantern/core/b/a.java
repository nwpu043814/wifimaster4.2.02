package com.lantern.core.b;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static Map<String, a> a = new HashMap();
  private c b;
  
  private a(File paramFile)
  {
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    this.b = new c(paramFile);
  }
  
  public static a a(Context paramContext, String paramString)
  {
    File localFile = new File(paramContext.getFilesDir(), paramString);
    paramString = (a)a.get(localFile.getAbsolutePath() + a());
    paramContext = paramString;
    if (paramString == null)
    {
      paramContext = new a(localFile);
      a.put(localFile.getAbsolutePath() + a(), paramContext);
    }
    return paramContext;
  }
  
  private static String a()
  {
    return "_" + Process.myPid();
  }
  
  /* Error */
  private byte[] b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 36	com/lantern/core/b/a:b	Lcom/lantern/core/b/c;
    //   7: aload_1
    //   8: invokevirtual 93	com/lantern/core/b/c:a	(Ljava/lang/String;)Ljava/io/File;
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 27	java/io/File:exists	()Z
    //   16: ifne +8 -> 24
    //   19: aload 5
    //   21: astore_2
    //   22: aload_2
    //   23: areturn
    //   24: new 95	java/io/RandomAccessFile
    //   27: astore_3
    //   28: aload_3
    //   29: aload_2
    //   30: ldc 97
    //   32: invokespecial 98	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: invokevirtual 102	java/io/RandomAccessFile:length	()J
    //   41: l2i
    //   42: newarray <illegal type>
    //   44: astore 4
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: aload 4
    //   51: invokevirtual 106	java/io/RandomAccessFile:read	([B)I
    //   54: pop
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: invokestatic 111	com/lantern/core/b/b:a	([B)Z
    //   62: ifne +28 -> 90
    //   65: aload_3
    //   66: astore_2
    //   67: aload 4
    //   69: invokestatic 114	com/lantern/core/b/b:b	([B)[B
    //   72: astore_1
    //   73: aload_1
    //   74: astore_2
    //   75: aload_3
    //   76: invokevirtual 117	java/io/RandomAccessFile:close	()V
    //   79: goto -57 -> 22
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   87: goto -65 -> 22
    //   90: aload_3
    //   91: invokevirtual 117	java/io/RandomAccessFile:close	()V
    //   94: aload_0
    //   95: getfield 36	com/lantern/core/b/a:b	Lcom/lantern/core/b/c;
    //   98: aload_1
    //   99: invokevirtual 124	com/lantern/core/b/c:c	(Ljava/lang/String;)Z
    //   102: pop
    //   103: aload 5
    //   105: astore_2
    //   106: goto -84 -> 22
    //   109: astore_2
    //   110: aload_2
    //   111: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   114: goto -20 -> 94
    //   117: astore 4
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_2
    //   123: aload 4
    //   125: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   128: aload 5
    //   130: astore_2
    //   131: aload_1
    //   132: ifnull -110 -> 22
    //   135: aload_1
    //   136: invokevirtual 117	java/io/RandomAccessFile:close	()V
    //   139: aload 5
    //   141: astore_2
    //   142: goto -120 -> 22
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   150: aload 5
    //   152: astore_2
    //   153: goto -131 -> 22
    //   156: astore_1
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: ifnull +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 117	java/io/RandomAccessFile:close	()V
    //   167: aload_1
    //   168: athrow
    //   169: astore_2
    //   170: aload_2
    //   171: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   174: goto -7 -> 167
    //   177: astore_1
    //   178: goto -19 -> 159
    //   181: astore 4
    //   183: aload_3
    //   184: astore_1
    //   185: goto -64 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	a
    //   0	188	1	paramString	String
    //   11	95	2	localObject1	Object
    //   109	2	2	localException1	Exception
    //   122	42	2	localObject2	Object
    //   169	2	2	localException2	Exception
    //   27	157	3	localRandomAccessFile	java.io.RandomAccessFile
    //   44	24	4	arrayOfByte	byte[]
    //   117	7	4	localException3	Exception
    //   181	1	4	localException4	Exception
    //   1	150	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   75	79	82	java/lang/Exception
    //   90	94	109	java/lang/Exception
    //   3	19	117	java/lang/Exception
    //   24	35	117	java/lang/Exception
    //   135	139	145	java/lang/Exception
    //   3	19	156	finally
    //   24	35	156	finally
    //   163	167	169	java/lang/Exception
    //   37	46	177	finally
    //   48	55	177	finally
    //   57	65	177	finally
    //   67	73	177	finally
    //   123	128	177	finally
    //   37	46	181	java/lang/Exception
    //   48	55	181	java/lang/Exception
    //   57	65	181	java/lang/Exception
    //   67	73	181	java/lang/Exception
  }
  
  /* Error */
  public final Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 127	com/lantern/core/b/a:b	(Ljava/lang/String;)[B
    //   8: astore_1
    //   9: aload 6
    //   11: astore_3
    //   12: aload_1
    //   13: ifnull +43 -> 56
    //   16: new 129	java/io/ByteArrayInputStream
    //   19: astore_2
    //   20: aload_2
    //   21: aload_1
    //   22: invokespecial 132	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: new 134	java/io/ObjectInputStream
    //   28: astore_1
    //   29: aload_1
    //   30: aload_2
    //   31: invokespecial 137	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: aload_1
    //   35: astore 4
    //   37: aload_2
    //   38: astore_3
    //   39: aload_1
    //   40: invokevirtual 141	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: astore 5
    //   45: aload 5
    //   47: astore_3
    //   48: aload_2
    //   49: invokevirtual 142	java/io/ByteArrayInputStream:close	()V
    //   52: aload_1
    //   53: invokevirtual 143	java/io/ObjectInputStream:close	()V
    //   56: aload_3
    //   57: areturn
    //   58: astore_2
    //   59: aload_2
    //   60: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   63: goto -11 -> 52
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   71: goto -15 -> 56
    //   74: astore 5
    //   76: aconst_null
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_2
    //   80: aload_1
    //   81: astore 4
    //   83: aload_2
    //   84: astore_3
    //   85: aload 5
    //   87: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 142	java/io/ByteArrayInputStream:close	()V
    //   98: aload 6
    //   100: astore_3
    //   101: aload_1
    //   102: ifnull -46 -> 56
    //   105: aload_1
    //   106: invokevirtual 143	java/io/ObjectInputStream:close	()V
    //   109: aload 6
    //   111: astore_3
    //   112: goto -56 -> 56
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   120: aload 6
    //   122: astore_3
    //   123: goto -67 -> 56
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   131: goto -33 -> 98
    //   134: astore_1
    //   135: aconst_null
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 142	java/io/ByteArrayInputStream:close	()V
    //   148: aload 4
    //   150: ifnull +8 -> 158
    //   153: aload 4
    //   155: invokevirtual 143	java/io/ObjectInputStream:close	()V
    //   158: aload_1
    //   159: athrow
    //   160: astore_2
    //   161: aload_2
    //   162: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   165: goto -17 -> 148
    //   168: astore_2
    //   169: aload_2
    //   170: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   173: goto -15 -> 158
    //   176: astore_1
    //   177: aconst_null
    //   178: astore 4
    //   180: goto -40 -> 140
    //   183: astore_1
    //   184: aload_3
    //   185: astore_2
    //   186: goto -46 -> 140
    //   189: astore 5
    //   191: aconst_null
    //   192: astore_1
    //   193: goto -113 -> 80
    //   196: astore 5
    //   198: goto -118 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	a
    //   0	201	1	paramString	String
    //   19	30	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   58	2	2	localException1	Exception
    //   79	16	2	localObject1	Object
    //   126	2	2	localException2	Exception
    //   139	6	2	localObject2	Object
    //   160	2	2	localException3	Exception
    //   168	2	2	localException4	Exception
    //   185	1	2	localObject3	Object
    //   11	174	3	localObject4	Object
    //   35	144	4	str	String
    //   43	3	5	localObject5	Object
    //   74	12	5	localException5	Exception
    //   189	1	5	localException6	Exception
    //   196	1	5	localException7	Exception
    //   1	120	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   48	52	58	java/lang/Exception
    //   52	56	66	java/lang/Exception
    //   16	25	74	java/lang/Exception
    //   105	109	115	java/lang/Exception
    //   94	98	126	java/lang/Exception
    //   16	25	134	finally
    //   144	148	160	java/lang/Exception
    //   153	158	168	java/lang/Exception
    //   25	34	176	finally
    //   39	45	183	finally
    //   85	90	183	finally
    //   25	34	189	java/lang/Exception
    //   39	45	196	java/lang/Exception
  }
  
  /* Error */
  public final void a(String paramString, java.io.Serializable paramSerializable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 146	java/io/ByteArrayOutputStream
    //   6: astore 5
    //   8: aload 5
    //   10: invokespecial 147	java/io/ByteArrayOutputStream:<init>	()V
    //   13: new 149	java/io/ObjectOutputStream
    //   16: astore_3
    //   17: aload_3
    //   18: aload 5
    //   20: invokespecial 152	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: aload_3
    //   24: aload_2
    //   25: invokevirtual 156	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   28: aload 5
    //   30: invokevirtual 160	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   33: astore 4
    //   35: aload_0
    //   36: getfield 36	com/lantern/core/b/a:b	Lcom/lantern/core/b/c;
    //   39: aload_1
    //   40: invokevirtual 162	com/lantern/core/b/c:b	(Ljava/lang/String;)Ljava/io/File;
    //   43: astore 5
    //   45: new 164	java/io/FileOutputStream
    //   48: astore_2
    //   49: aload_2
    //   50: aload 5
    //   52: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload 4
    //   60: invokevirtual 168	java/io/FileOutputStream:write	([B)V
    //   63: aload_2
    //   64: invokevirtual 171	java/io/FileOutputStream:flush	()V
    //   67: aload_2
    //   68: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   71: aload_0
    //   72: getfield 36	com/lantern/core/b/a:b	Lcom/lantern/core/b/c;
    //   75: aload 5
    //   77: invokevirtual 174	com/lantern/core/b/c:a	(Ljava/io/File;)V
    //   80: aload_3
    //   81: invokevirtual 175	java/io/ObjectOutputStream:close	()V
    //   84: return
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   90: goto -19 -> 71
    //   93: astore_2
    //   94: aload_3
    //   95: astore_1
    //   96: aload_2
    //   97: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   100: aload_1
    //   101: invokevirtual 175	java/io/ObjectOutputStream:close	()V
    //   104: goto -20 -> 84
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   112: goto -28 -> 84
    //   115: astore 4
    //   117: aconst_null
    //   118: astore_2
    //   119: aload_2
    //   120: astore_1
    //   121: aload 4
    //   123: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   126: aload_2
    //   127: ifnull +11 -> 138
    //   130: aload_2
    //   131: invokevirtual 171	java/io/FileOutputStream:flush	()V
    //   134: aload_2
    //   135: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   138: aload_0
    //   139: getfield 36	com/lantern/core/b/a:b	Lcom/lantern/core/b/c;
    //   142: aload 5
    //   144: invokevirtual 174	com/lantern/core/b/c:a	(Ljava/io/File;)V
    //   147: goto -67 -> 80
    //   150: astore_1
    //   151: aload_3
    //   152: astore_2
    //   153: aload_2
    //   154: invokevirtual 175	java/io/ObjectOutputStream:close	()V
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   164: goto -26 -> 138
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +11 -> 182
    //   174: aload_1
    //   175: invokevirtual 171	java/io/FileOutputStream:flush	()V
    //   178: aload_1
    //   179: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   182: aload_0
    //   183: getfield 36	com/lantern/core/b/a:b	Lcom/lantern/core/b/c;
    //   186: aload 5
    //   188: invokevirtual 174	com/lantern/core/b/c:a	(Ljava/io/File;)V
    //   191: aload_2
    //   192: athrow
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   198: goto -16 -> 182
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   206: goto -122 -> 84
    //   209: astore_2
    //   210: aload_2
    //   211: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   214: goto -57 -> 157
    //   217: astore_1
    //   218: aconst_null
    //   219: astore_2
    //   220: goto -67 -> 153
    //   223: astore_3
    //   224: aload_1
    //   225: astore_2
    //   226: aload_3
    //   227: astore_1
    //   228: goto -75 -> 153
    //   231: astore_2
    //   232: aload 4
    //   234: astore_1
    //   235: goto -139 -> 96
    //   238: astore_2
    //   239: goto -69 -> 170
    //   242: astore 4
    //   244: goto -125 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	a
    //   0	247	1	paramString	String
    //   0	247	2	paramSerializable	java.io.Serializable
    //   16	136	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   223	4	3	localObject1	Object
    //   1	58	4	arrayOfByte	byte[]
    //   115	118	4	localException1	Exception
    //   242	1	4	localException2	Exception
    //   6	181	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   63	71	85	java/lang/Exception
    //   23	45	93	java/lang/Exception
    //   71	80	93	java/lang/Exception
    //   86	90	93	java/lang/Exception
    //   138	147	93	java/lang/Exception
    //   160	164	93	java/lang/Exception
    //   182	193	93	java/lang/Exception
    //   194	198	93	java/lang/Exception
    //   100	104	107	java/lang/Exception
    //   45	55	115	java/lang/Exception
    //   23	45	150	finally
    //   63	71	150	finally
    //   71	80	150	finally
    //   86	90	150	finally
    //   130	138	150	finally
    //   138	147	150	finally
    //   160	164	150	finally
    //   174	182	150	finally
    //   182	193	150	finally
    //   194	198	150	finally
    //   130	138	159	java/lang/Exception
    //   45	55	167	finally
    //   174	182	193	java/lang/Exception
    //   80	84	201	java/lang/Exception
    //   153	157	209	java/lang/Exception
    //   3	23	217	finally
    //   96	100	223	finally
    //   3	23	231	java/lang/Exception
    //   57	63	238	finally
    //   121	126	238	finally
    //   57	63	242	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */