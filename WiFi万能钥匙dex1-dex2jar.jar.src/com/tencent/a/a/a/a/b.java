package com.tencent.a.a.a.a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

final class b
  extends f
{
  b(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final boolean a()
  {
    if ((h.a(this.e, "android.permission.WRITE_EXTERNAL_STORAGE")) && (Environment.getExternalStorageState().equals("mounted"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected final String b()
  {
    for (;;)
    {
      try
      {
        Log.i("MID", "read mid from InternalStorage");
        localObject1 = new java/io/File;
        ((File)localObject1).<init>(Environment.getExternalStorageDirectory(), h.f("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="));
        try
        {
          Object localObject4 = a.a((File)localObject1).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject1 = ((String)((Iterator)localObject4).next()).split(",");
          if ((localObject1.length != 2) || (!localObject1[0].equals(h.f("4kU71lN96TJUomD1vOU9lgj9Tw==")))) {
            continue;
          }
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>("read mid from InternalStorage:");
          Log.i("MID", localObject1[1]);
          localObject1 = localObject1[1];
        }
        catch (IOException localIOException)
        {
          Log.w("MID", localIOException);
          Object localObject2 = null;
          continue;
        }
        return (String)localObject1;
      }
      finally {}
      Object localObject1 = null;
    }
  }
  
  /* Error */
  protected final void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 41
    //   4: ldc 114
    //   6: invokestatic 49	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: new 94	java/lang/StringBuilder
    //   13: astore_2
    //   14: aload_2
    //   15: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   18: aload_2
    //   19: invokestatic 55	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   22: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc 122
    //   27: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 124
    //   32: invokestatic 61	com/tencent/a/a/a/a/h:f	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 127	com/tencent/a/a/a/a/a:a	(Ljava/lang/String;)Ljava/io/File;
    //   44: pop
    //   45: new 51	java/io/File
    //   48: astore_2
    //   49: aload_2
    //   50: invokestatic 55	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   53: ldc 57
    //   55: invokestatic 61	com/tencent/a/a/a/a/h:f	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 64	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: new 129	java/io/FileWriter
    //   64: astore_3
    //   65: aload_3
    //   66: aload_2
    //   67: invokespecial 132	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   70: new 134	java/io/BufferedWriter
    //   73: astore_2
    //   74: aload_2
    //   75: aload_3
    //   76: invokespecial 137	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   79: new 94	java/lang/StringBuilder
    //   82: astore_3
    //   83: aload_3
    //   84: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   87: aload_2
    //   88: aload_3
    //   89: ldc 92
    //   91: invokestatic 61	com/tencent/a/a/a/a/h:f	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 86
    //   99: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokevirtual 140	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   112: aload_2
    //   113: ldc -114
    //   115: invokevirtual 140	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   118: aload_2
    //   119: invokevirtual 145	java/io/BufferedWriter:close	()V
    //   122: aload_0
    //   123: monitorexit
    //   124: return
    //   125: astore_1
    //   126: ldc 41
    //   128: aload_1
    //   129: invokestatic 110	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   132: pop
    //   133: goto -11 -> 122
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	b
    //   0	141	1	paramString	String
    //   13	106	2	localObject1	Object
    //   64	25	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   61	122	125	java/lang/Exception
    //   2	61	136	finally
    //   61	122	136	finally
    //   122	124	136	finally
    //   126	133	136	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */