package com.lantern.core.imageloader.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;

final class w
  extends n
{
  private static final String[] b = { "orientation" };
  
  w(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  private static int a(ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: getstatic 17	com/lantern/core/imageloader/a/w:b	[Ljava/lang/String;
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: invokevirtual 31	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: invokeinterface 37 1 0
    //   22: istore 4
    //   24: iload 4
    //   26: ifne +17 -> 43
    //   29: aload_0
    //   30: ifnull +9 -> 39
    //   33: aload_0
    //   34: invokeinterface 40 1 0
    //   39: iconst_0
    //   40: istore_2
    //   41: iload_2
    //   42: ireturn
    //   43: aload_0
    //   44: iconst_0
    //   45: invokeinterface 44 2 0
    //   50: istore_3
    //   51: iload_3
    //   52: istore_2
    //   53: aload_0
    //   54: ifnull -13 -> 41
    //   57: aload_0
    //   58: invokeinterface 40 1 0
    //   63: iload_3
    //   64: istore_2
    //   65: goto -24 -> 41
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +9 -> 81
    //   75: aload_0
    //   76: invokeinterface 40 1 0
    //   81: iconst_0
    //   82: istore_2
    //   83: goto -42 -> 41
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +9 -> 99
    //   93: aload_0
    //   94: invokeinterface 40 1 0
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: goto -13 -> 89
    //   105: astore_1
    //   106: goto -35 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramContentResolver	ContentResolver
    //   0	109	1	paramUri	Uri
    //   40	43	2	i	int
    //   50	14	3	j	int
    //   22	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	12	68	java/lang/RuntimeException
    //   0	12	86	finally
    //   16	24	101	finally
    //   43	51	101	finally
    //   16	24	105	java/lang/RuntimeException
    //   43	51	105	java/lang/RuntimeException
  }
  
  public final boolean a(ag paramag)
  {
    paramag = paramag.a;
    if (("content".equals(paramag.getScheme())) && ("media".equals(paramag.getAuthority()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final ai.a b(ag paramag)
  {
    int j = 1;
    ContentResolver localContentResolver = this.a.getContentResolver();
    int k = a(localContentResolver, paramag.a);
    Object localObject = localContentResolver.getType(paramag.a);
    int i;
    int n;
    int m;
    if ((localObject != null) && (((String)localObject).startsWith("video/")))
    {
      i = 1;
      if (!paramag.c()) {
        break label295;
      }
      n = paramag.e;
      m = paramag.f;
      if ((n > a.a.e) || (m > a.a.f)) {
        break label134;
      }
      localObject = a.a;
      label96:
      if ((i != 0) || (localObject != a.c)) {
        break label172;
      }
      paramag = new ai.a(null, c(paramag), aa.d.b, k);
    }
    for (;;)
    {
      return paramag;
      i = 0;
      break;
      label134:
      if ((n <= a.b.e) && (m <= a.b.f))
      {
        localObject = a.b;
        break label96;
      }
      localObject = a.c;
      break label96;
      label172:
      long l = ContentUris.parseId(paramag.a);
      BitmapFactory.Options localOptions = d(paramag);
      localOptions.inJustDecodeBounds = true;
      a(paramag.e, paramag.f, ((a)localObject).e, ((a)localObject).f, localOptions, paramag);
      if (i != 0) {
        if (localObject == a.c) {
          i = j;
        }
      }
      label231:
      for (localObject = MediaStore.Video.Thumbnails.getThumbnail(localContentResolver, l, i, localOptions);; localObject = MediaStore.Images.Thumbnails.getThumbnail(localContentResolver, l, ((a)localObject).d, localOptions))
      {
        if (localObject == null) {
          break label295;
        }
        paramag = new ai.a((Bitmap)localObject, null, aa.d.b, k);
        break;
        i = ((a)localObject).d;
        break label231;
      }
      label295:
      paramag = new ai.a(null, c(paramag), aa.d.b, k);
    }
  }
  
  static enum a
  {
    final int d;
    final int e;
    final int f;
    
    private a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.d = paramInt1;
      this.e = paramInt2;
      this.f = paramInt3;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */