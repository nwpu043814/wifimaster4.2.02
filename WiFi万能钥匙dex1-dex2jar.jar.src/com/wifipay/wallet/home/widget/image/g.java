package com.wifipay.wallet.home.widget.image;

import android.graphics.Bitmap;

class g
  implements Runnable
{
  g(f paramf, String paramString, Bitmap paramBitmap) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/wifipay/wallet/home/widget/image/g:c	Lcom/wifipay/wallet/home/widget/image/f;
    //   4: invokestatic 34	com/wifipay/wallet/home/widget/image/f:a	(Lcom/wifipay/wallet/home/widget/image/f;)Z
    //   7: ifeq +79 -> 86
    //   10: aconst_null
    //   11: astore_3
    //   12: new 36	java/io/BufferedOutputStream
    //   15: astore_2
    //   16: new 38	java/io/FileOutputStream
    //   19: astore 4
    //   21: new 40	java/io/File
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 16	com/wifipay/wallet/home/widget/image/g:c	Lcom/wifipay/wallet/home/widget/image/f;
    //   30: invokestatic 43	com/wifipay/wallet/home/widget/image/f:b	(Lcom/wifipay/wallet/home/widget/image/f;)Ljava/lang/String;
    //   33: aload_0
    //   34: getfield 16	com/wifipay/wallet/home/widget/image/g:c	Lcom/wifipay/wallet/home/widget/image/f;
    //   37: aload_0
    //   38: getfield 18	com/wifipay/wallet/home/widget/image/g:a	Ljava/lang/String;
    //   41: invokestatic 46	com/wifipay/wallet/home/widget/image/f:a	(Lcom/wifipay/wallet/home/widget/image/f;Ljava/lang/String;)Ljava/lang/String;
    //   44: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload 4
    //   49: aload_1
    //   50: invokespecial 52	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: aload_2
    //   54: aload 4
    //   56: sipush 2048
    //   59: invokespecial 55	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 20	com/wifipay/wallet/home/widget/image/g:b	Landroid/graphics/Bitmap;
    //   68: getstatic 61	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   71: bipush 100
    //   73: aload_2
    //   74: invokevirtual 67	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   77: pop
    //   78: aload_2
    //   79: invokevirtual 70	java/io/BufferedOutputStream:flush	()V
    //   82: aload_2
    //   83: invokevirtual 73	java/io/BufferedOutputStream:close	()V
    //   86: return
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: aload_3
    //   93: invokevirtual 76	java/io/FileNotFoundException:printStackTrace	()V
    //   96: aload_2
    //   97: ifnull -11 -> 86
    //   100: aload_2
    //   101: invokevirtual 70	java/io/BufferedOutputStream:flush	()V
    //   104: aload_2
    //   105: invokevirtual 73	java/io/BufferedOutputStream:close	()V
    //   108: goto -22 -> 86
    //   111: astore_1
    //   112: goto -26 -> 86
    //   115: astore_1
    //   116: aload_3
    //   117: astore_2
    //   118: aload_2
    //   119: ifnull +11 -> 130
    //   122: aload_2
    //   123: invokevirtual 70	java/io/BufferedOutputStream:flush	()V
    //   126: aload_2
    //   127: invokevirtual 73	java/io/BufferedOutputStream:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_2
    //   133: goto -3 -> 130
    //   136: astore_3
    //   137: aload_1
    //   138: astore_2
    //   139: aload_3
    //   140: astore_1
    //   141: goto -23 -> 118
    //   144: astore_3
    //   145: goto -55 -> 90
    //   148: astore_1
    //   149: goto -63 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	g
    //   24	68	1	localObject1	Object
    //   111	1	1	localIOException1	java.io.IOException
    //   115	23	1	localObject2	Object
    //   140	1	1	localObject3	Object
    //   148	1	1	localIOException2	java.io.IOException
    //   15	112	2	localObject4	Object
    //   132	1	2	localIOException3	java.io.IOException
    //   138	1	2	localObject5	Object
    //   11	1	3	localObject6	Object
    //   87	30	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   136	4	3	localObject7	Object
    //   144	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   19	36	4	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   12	62	87	java/io/FileNotFoundException
    //   100	108	111	java/io/IOException
    //   12	62	115	finally
    //   122	130	132	java/io/IOException
    //   64	78	136	finally
    //   92	96	136	finally
    //   64	78	144	java/io/FileNotFoundException
    //   78	86	148	java/io/IOException
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/image/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */