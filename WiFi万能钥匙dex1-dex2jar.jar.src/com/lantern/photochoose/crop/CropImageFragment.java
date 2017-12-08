package com.lantern.photochoose.crop;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import bluefay.app.Fragment;
import com.lantern.photochoose.crop.view.CropImageLayout;
import java.io.InputStream;

public class CropImageFragment
  extends Fragment
{
  private CropImageLayout g;
  private Uri h;
  private int i;
  
  private int a(Uri paramUri)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      InputStream localInputStream = this.e.getContentResolver().openInputStream(paramUri);
      int j;
      int k;
      return k;
    }
    finally
    {
      for (;;)
      {
        try
        {
          BitmapFactory.decodeStream(localInputStream, null, localOptions);
          b.a(localInputStream);
          paramUri = new DisplayMetrics();
          ((WindowManager)this.e.getSystemService("window")).getDefaultDisplay().getMetrics(paramUri);
          j = paramUri.heightPixels;
          if (j != 0) {
            continue;
          }
          j = 2048;
          k = 1;
          if ((localOptions.outHeight / k <= j) && (localOptions.outWidth / k <= j)) {
            continue;
          }
          k <<= 1;
          continue;
          paramUri = finally;
          localInputStream = null;
        }
        finally
        {
          continue;
        }
        b.a(localInputStream);
        throw paramUri;
        j = Math.min(j, 2048);
      }
    }
  }
  
  /* Error */
  public android.view.View onCreateView(android.view.LayoutInflater paramLayoutInflater, android.view.ViewGroup paramViewGroup, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: getstatic 96	com/lantern/settings/R$layout:settings_crop_image	I
    //   6: aconst_null
    //   7: invokevirtual 102	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   10: astore 6
    //   12: aload_0
    //   13: aload 6
    //   15: getstatic 107	com/lantern/settings/R$id:clip	I
    //   18: invokevirtual 113	android/view/View:findViewById	(I)Landroid/view/View;
    //   21: checkcast 115	com/lantern/photochoose/crop/view/CropImageLayout
    //   24: putfield 117	com/lantern/photochoose/crop/CropImageFragment:g	Lcom/lantern/photochoose/crop/view/CropImageLayout;
    //   27: aload_0
    //   28: getstatic 122	com/lantern/settings/R$string:settings_photo_set_avatar	I
    //   31: invokevirtual 125	com/lantern/photochoose/crop/CropImageFragment:a	(I)V
    //   34: aload_0
    //   35: iconst_m1
    //   36: invokevirtual 128	com/lantern/photochoose/crop/CropImageFragment:b	(I)V
    //   39: new 130	bluefay/app/u
    //   42: dup
    //   43: aload_0
    //   44: invokevirtual 134	com/lantern/photochoose/crop/CropImageFragment:getActivity	()Landroid/app/Activity;
    //   47: invokespecial 137	bluefay/app/u:<init>	(Landroid/content/Context;)V
    //   50: astore_1
    //   51: aload_1
    //   52: bipush 101
    //   54: sipush 1001
    //   57: iconst_0
    //   58: getstatic 140	com/lantern/settings/R$string:settings_photo_use_crop	I
    //   61: invokeinterface 146 5 0
    //   66: getstatic 140	com/lantern/settings/R$string:settings_photo_use_crop	I
    //   69: invokeinterface 152 2 0
    //   74: pop
    //   75: aload_0
    //   76: getstatic 154	com/lantern/photochoose/crop/CropImageFragment:a	I
    //   79: aload_1
    //   80: invokevirtual 157	com/lantern/photochoose/crop/CropImageFragment:a	(ILandroid/view/Menu;)Z
    //   83: pop
    //   84: aload_0
    //   85: getfield 28	com/lantern/photochoose/crop/CropImageFragment:e	Landroid/content/Context;
    //   88: checkcast 159	bluefay/app/b
    //   91: invokevirtual 163	bluefay/app/b:getIntent	()Landroid/content/Intent;
    //   94: astore_2
    //   95: aload_2
    //   96: invokevirtual 169	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +26 -> 127
    //   104: aload_0
    //   105: aload_1
    //   106: ldc -85
    //   108: invokevirtual 177	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   111: putfield 179	com/lantern/photochoose/crop/CropImageFragment:i	I
    //   114: aload_0
    //   115: aload_1
    //   116: ldc -75
    //   118: invokevirtual 185	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   121: checkcast 187	android/net/Uri
    //   124: putfield 189	com/lantern/photochoose/crop/CropImageFragment:h	Landroid/net/Uri;
    //   127: aload_2
    //   128: invokevirtual 193	android/content/Intent:getData	()Landroid/net/Uri;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnonnull +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 195	com/lantern/photochoose/crop/CropImageFragment:a	()V
    //   140: aload_0
    //   141: aload_2
    //   142: invokespecial 197	com/lantern/photochoose/crop/CropImageFragment:a	(Landroid/net/Uri;)I
    //   145: istore 4
    //   147: new 19	android/graphics/BitmapFactory$Options
    //   150: astore 5
    //   152: aload 5
    //   154: invokespecial 20	android/graphics/BitmapFactory$Options:<init>	()V
    //   157: aload 5
    //   159: iload 4
    //   161: putfield 200	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   164: aload_0
    //   165: getfield 28	com/lantern/photochoose/crop/CropImageFragment:e	Landroid/content/Context;
    //   168: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   171: aload_2
    //   172: invokevirtual 40	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   175: astore_1
    //   176: aload_1
    //   177: aconst_null
    //   178: aload 5
    //   180: invokestatic 46	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   183: astore_3
    //   184: aload_2
    //   185: invokevirtual 204	android/net/Uri:getPath	()Ljava/lang/String;
    //   188: invokestatic 208	com/lantern/photochoose/b/f:b	(Ljava/lang/String;)I
    //   191: istore 4
    //   193: aload_3
    //   194: astore_2
    //   195: iload 4
    //   197: ifeq +66 -> 263
    //   200: new 210	android/graphics/Matrix
    //   203: astore_2
    //   204: aload_2
    //   205: invokespecial 211	android/graphics/Matrix:<init>	()V
    //   208: iload 4
    //   210: ifeq +10 -> 220
    //   213: aload_2
    //   214: iload 4
    //   216: i2f
    //   217: invokevirtual 215	android/graphics/Matrix:setRotate	(F)V
    //   220: aload_3
    //   221: iconst_0
    //   222: iconst_0
    //   223: aload_3
    //   224: invokevirtual 221	android/graphics/Bitmap:getWidth	()I
    //   227: aload_3
    //   228: invokevirtual 224	android/graphics/Bitmap:getHeight	()I
    //   231: aload_2
    //   232: iconst_1
    //   233: invokestatic 228	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   236: astore 5
    //   238: aload_3
    //   239: astore_2
    //   240: aload 5
    //   242: ifnull +21 -> 263
    //   245: aload_3
    //   246: astore_2
    //   247: aload_3
    //   248: aload 5
    //   250: if_acmpeq +13 -> 263
    //   253: aload_3
    //   254: invokevirtual 231	android/graphics/Bitmap:recycle	()V
    //   257: aload 5
    //   259: astore_2
    //   260: invokestatic 236	java/lang/System:gc	()V
    //   263: aload_0
    //   264: getfield 117	com/lantern/photochoose/crop/CropImageFragment:g	Lcom/lantern/photochoose/crop/view/CropImageLayout;
    //   267: aload_2
    //   268: invokevirtual 239	com/lantern/photochoose/crop/view/CropImageLayout:a	(Landroid/graphics/Bitmap;)V
    //   271: aload_1
    //   272: invokestatic 51	com/lantern/photochoose/crop/b:a	(Ljava/io/Closeable;)V
    //   275: aload 6
    //   277: areturn
    //   278: astore_2
    //   279: aload_3
    //   280: astore_1
    //   281: aload_2
    //   282: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   285: aload_1
    //   286: invokestatic 51	com/lantern/photochoose/crop/b:a	(Ljava/io/Closeable;)V
    //   289: goto -14 -> 275
    //   292: astore_2
    //   293: aconst_null
    //   294: astore_1
    //   295: aload_1
    //   296: invokestatic 51	com/lantern/photochoose/crop/b:a	(Ljava/io/Closeable;)V
    //   299: aload_2
    //   300: athrow
    //   301: astore_2
    //   302: goto -7 -> 295
    //   305: astore_2
    //   306: goto -11 -> 295
    //   309: astore_2
    //   310: goto -29 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	CropImageFragment
    //   0	313	1	paramLayoutInflater	android.view.LayoutInflater
    //   0	313	2	paramViewGroup	android.view.ViewGroup
    //   0	313	3	paramBundle	android.os.Bundle
    //   145	70	4	j	int
    //   150	108	5	localObject	Object
    //   10	266	6	localView	android.view.View
    // Exception table:
    //   from	to	target	type
    //   140	176	278	java/lang/Exception
    //   140	176	292	finally
    //   176	193	301	finally
    //   200	208	301	finally
    //   213	220	301	finally
    //   220	238	301	finally
    //   253	257	301	finally
    //   260	263	301	finally
    //   263	271	301	finally
    //   281	285	305	finally
    //   176	193	309	java/lang/Exception
    //   200	208	309	java/lang/Exception
    //   213	220	309	java/lang/Exception
    //   220	238	309	java/lang/Exception
    //   253	257	309	java/lang/Exception
    //   260	263	309	java/lang/Exception
    //   263	271	309	java/lang/Exception
  }
  
  /* Error */
  public boolean onOptionsItemSelected(android.view.MenuItem paramMenuItem)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 249 1 0
    //   6: tableswitch	default:+18->24, 1001:+24->30
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 251	bluefay/app/Fragment:onOptionsItemSelected	(Landroid/view/MenuItem;)Z
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 189	com/lantern/photochoose/crop/CropImageFragment:h	Landroid/net/Uri;
    //   34: ifnull +131 -> 165
    //   37: aconst_null
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 28	com/lantern/photochoose/crop/CropImageFragment:e	Landroid/content/Context;
    //   43: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   46: aload_0
    //   47: getfield 189	com/lantern/photochoose/crop/CropImageFragment:h	Landroid/net/Uri;
    //   50: invokevirtual 255	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   53: astore 4
    //   55: aload 4
    //   57: astore_2
    //   58: aload 4
    //   60: astore_3
    //   61: aload_0
    //   62: getfield 117	com/lantern/photochoose/crop/CropImageFragment:g	Lcom/lantern/photochoose/crop/view/CropImageLayout;
    //   65: invokevirtual 258	com/lantern/photochoose/crop/view/CropImageLayout:a	()Landroid/graphics/Bitmap;
    //   68: astore 6
    //   70: aload 4
    //   72: ifnull +88 -> 160
    //   75: aload 6
    //   77: ifnull +83 -> 160
    //   80: aload 6
    //   82: astore 5
    //   84: aload 4
    //   86: astore_2
    //   87: aload 4
    //   89: astore_3
    //   90: aload_0
    //   91: getfield 179	com/lantern/photochoose/crop/CropImageFragment:i	I
    //   94: ifle +47 -> 141
    //   97: aload 6
    //   99: astore 5
    //   101: aload 4
    //   103: astore_2
    //   104: aload 4
    //   106: astore_3
    //   107: aload 6
    //   109: invokevirtual 221	android/graphics/Bitmap:getWidth	()I
    //   112: aload_0
    //   113: getfield 179	com/lantern/photochoose/crop/CropImageFragment:i	I
    //   116: if_icmple +25 -> 141
    //   119: aload 4
    //   121: astore_2
    //   122: aload 4
    //   124: astore_3
    //   125: aload 6
    //   127: aload_0
    //   128: getfield 179	com/lantern/photochoose/crop/CropImageFragment:i	I
    //   131: aload_0
    //   132: getfield 179	com/lantern/photochoose/crop/CropImageFragment:i	I
    //   135: iconst_1
    //   136: invokestatic 262	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   139: astore 5
    //   141: aload 4
    //   143: astore_2
    //   144: aload 4
    //   146: astore_3
    //   147: aload 5
    //   149: getstatic 268	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   152: bipush 80
    //   154: aload 4
    //   156: invokevirtual 272	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   159: pop
    //   160: aload 4
    //   162: invokestatic 51	com/lantern/photochoose/crop/b:a	(Ljava/io/Closeable;)V
    //   165: aload_0
    //   166: getfield 28	com/lantern/photochoose/crop/CropImageFragment:e	Landroid/content/Context;
    //   169: checkcast 159	bluefay/app/b
    //   172: invokevirtual 163	bluefay/app/b:getIntent	()Landroid/content/Intent;
    //   175: astore_2
    //   176: aload_0
    //   177: getfield 28	com/lantern/photochoose/crop/CropImageFragment:e	Landroid/content/Context;
    //   180: checkcast 159	bluefay/app/b
    //   183: iconst_m1
    //   184: aload_2
    //   185: invokevirtual 276	bluefay/app/b:setResult	(ILandroid/content/Intent;)V
    //   188: aload_0
    //   189: getfield 28	com/lantern/photochoose/crop/CropImageFragment:e	Landroid/content/Context;
    //   192: checkcast 159	bluefay/app/b
    //   195: iconst_m1
    //   196: iconst_m1
    //   197: invokevirtual 280	bluefay/app/b:overridePendingTransition	(II)V
    //   200: aload_0
    //   201: invokevirtual 195	com/lantern/photochoose/crop/CropImageFragment:a	()V
    //   204: goto -180 -> 24
    //   207: astore_3
    //   208: aload_2
    //   209: astore_3
    //   210: new 282	java/lang/StringBuilder
    //   213: astore 4
    //   215: aload_2
    //   216: astore_3
    //   217: aload 4
    //   219: ldc_w 284
    //   222: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: aload_2
    //   226: astore_3
    //   227: aload 4
    //   229: aload_0
    //   230: getfield 189	com/lantern/photochoose/crop/CropImageFragment:h	Landroid/net/Uri;
    //   233: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 299	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   242: aload_2
    //   243: invokestatic 51	com/lantern/photochoose/crop/b:a	(Ljava/io/Closeable;)V
    //   246: goto -81 -> 165
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_3
    //   252: aload_3
    //   253: invokestatic 51	com/lantern/photochoose/crop/b:a	(Ljava/io/Closeable;)V
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: goto -7 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	CropImageFragment
    //   0	262	1	paramMenuItem	android.view.MenuItem
    //   38	205	2	localObject1	Object
    //   60	87	3	localObject2	Object
    //   207	1	3	localIOException	java.io.IOException
    //   209	44	3	localObject3	Object
    //   53	175	4	localObject4	Object
    //   82	66	5	localBitmap1	android.graphics.Bitmap
    //   68	58	6	localBitmap2	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   39	55	207	java/io/IOException
    //   61	70	207	java/io/IOException
    //   90	97	207	java/io/IOException
    //   107	119	207	java/io/IOException
    //   125	141	207	java/io/IOException
    //   147	160	207	java/io/IOException
    //   39	55	249	finally
    //   61	70	258	finally
    //   90	97	258	finally
    //   107	119	258	finally
    //   125	141	258	finally
    //   147	160	258	finally
    //   210	215	258	finally
    //   217	225	258	finally
    //   227	242	258	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/crop/CropImageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */