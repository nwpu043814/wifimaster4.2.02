package com.wifipay.wallet.authentication.activity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.common.logging.Logger;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.authentication.tools.d;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class TakePhotoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private final String h = "/finger/";
  private SurfaceView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private Camera m;
  private Camera.Parameters n = null;
  private Bundle o = null;
  private int p = 0;
  private boolean q = true;
  private int r;
  private int s;
  private String t;
  
  static
  {
    StubApp1053578832.interface11(102);
  }
  
  public static int a(Activity paramActivity)
  {
    int i2 = 0;
    int i1 = i2;
    switch (paramActivity.getWindowManager().getDefaultDisplay().getRotation())
    {
    default: 
      i1 = i2;
    }
    for (;;)
    {
      return i1;
      i1 = 90;
      continue;
      i1 = 270;
      continue;
      i1 = 180;
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_1
    //   9: iconst_0
    //   10: aload_1
    //   11: arraylength
    //   12: invokestatic 92	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   15: astore_1
    //   16: aload_1
    //   17: astore_3
    //   18: aload 6
    //   20: astore_2
    //   21: new 94	java/io/File
    //   24: astore 4
    //   26: aload_1
    //   27: astore_3
    //   28: aload 6
    //   30: astore_2
    //   31: aload 4
    //   33: aload_0
    //   34: getfield 96	com/wifipay/wallet/authentication/activity/TakePhotoActivity:t	Ljava/lang/String;
    //   37: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: aload_1
    //   41: astore_3
    //   42: aload 6
    //   44: astore_2
    //   45: aload 4
    //   47: invokestatic 104	com/wifipay/wallet/authentication/tools/b:a	(Ljava/io/File;)Z
    //   50: ifne +54 -> 104
    //   53: aload_1
    //   54: astore_3
    //   55: aload 6
    //   57: astore_2
    //   58: new 106	java/lang/StringBuilder
    //   61: astore 4
    //   63: aload_1
    //   64: astore_3
    //   65: aload 6
    //   67: astore_2
    //   68: aload 4
    //   70: ldc 108
    //   72: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_1
    //   76: astore_3
    //   77: aload 6
    //   79: astore_2
    //   80: ldc 111
    //   82: iconst_1
    //   83: anewarray 113	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload 4
    //   90: aload_0
    //   91: getfield 96	com/wifipay/wallet/authentication/activity/TakePhotoActivity:t	Ljava/lang/String;
    //   94: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 127	com/wifipay/common/logging/Logger:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_1
    //   105: astore_3
    //   106: aload 6
    //   108: astore_2
    //   109: new 106	java/lang/StringBuilder
    //   112: astore 4
    //   114: aload_1
    //   115: astore_3
    //   116: aload 6
    //   118: astore_2
    //   119: aload 4
    //   121: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   124: aload_1
    //   125: astore_3
    //   126: aload 6
    //   128: astore_2
    //   129: aload 4
    //   131: aload_0
    //   132: getfield 96	com/wifipay/wallet/authentication/activity/TakePhotoActivity:t	Ljava/lang/String;
    //   135: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   141: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   144: ldc -117
    //   146: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: astore 7
    //   154: aload_1
    //   155: astore_3
    //   156: aload 6
    //   158: astore_2
    //   159: new 94	java/io/File
    //   162: astore 8
    //   164: aload_1
    //   165: astore_3
    //   166: aload 6
    //   168: astore_2
    //   169: aload 8
    //   171: aload 7
    //   173: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: aload_1
    //   177: astore_3
    //   178: aload 6
    //   180: astore_2
    //   181: aload 8
    //   183: invokestatic 141	com/wifipay/wallet/authentication/tools/b:b	(Ljava/io/File;)Z
    //   186: ifne +52 -> 238
    //   189: aload_1
    //   190: astore_3
    //   191: aload 6
    //   193: astore_2
    //   194: new 106	java/lang/StringBuilder
    //   197: astore 4
    //   199: aload_1
    //   200: astore_3
    //   201: aload 6
    //   203: astore_2
    //   204: aload 4
    //   206: ldc -113
    //   208: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: aload_1
    //   212: astore_3
    //   213: aload 6
    //   215: astore_2
    //   216: ldc 111
    //   218: iconst_1
    //   219: anewarray 113	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload 4
    //   226: aload 7
    //   228: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: aastore
    //   235: invokestatic 127	com/wifipay/common/logging/Logger:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: aload_1
    //   239: astore_3
    //   240: aload 6
    //   242: astore_2
    //   243: new 145	java/io/BufferedOutputStream
    //   246: astore 4
    //   248: aload_1
    //   249: astore_3
    //   250: aload 6
    //   252: astore_2
    //   253: new 147	java/io/FileOutputStream
    //   256: astore 9
    //   258: aload_1
    //   259: astore_3
    //   260: aload 6
    //   262: astore_2
    //   263: aload 9
    //   265: aload 8
    //   267: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   270: aload_1
    //   271: astore_3
    //   272: aload 6
    //   274: astore_2
    //   275: aload 4
    //   277: aload 9
    //   279: invokespecial 153	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   282: aload_1
    //   283: getstatic 159	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   286: bipush 100
    //   288: aload 4
    //   290: invokevirtual 165	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   293: ifeq +22 -> 315
    //   296: aload 8
    //   298: invokestatic 170	com/wifipay/wallet/authentication/tools/a:a	(Ljava/io/File;)Ljava/io/File;
    //   301: pop
    //   302: aload_0
    //   303: getfield 55	com/wifipay/wallet/authentication/activity/TakePhotoActivity:p	I
    //   306: ifne +73 -> 379
    //   309: aload_0
    //   310: ldc -84
    //   312: invokevirtual 174	com/wifipay/wallet/authentication/activity/TakePhotoActivity:a	(Ljava/lang/String;)V
    //   315: new 106	java/lang/StringBuilder
    //   318: astore_2
    //   319: aload_2
    //   320: ldc -80
    //   322: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: ldc 111
    //   327: iconst_1
    //   328: anewarray 113	java/lang/Object
    //   331: dup
    //   332: iconst_0
    //   333: aload_2
    //   334: aload 7
    //   336: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: aastore
    //   343: invokestatic 178	com/wifipay/common/logging/Logger:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: aload 4
    //   348: invokevirtual 181	java/io/BufferedOutputStream:flush	()V
    //   351: aload 4
    //   353: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   356: aload_1
    //   357: ifnull +7 -> 364
    //   360: aload_1
    //   361: invokevirtual 187	android/graphics/Bitmap:recycle	()V
    //   364: aload_0
    //   365: getfield 79	com/wifipay/wallet/authentication/activity/TakePhotoActivity:m	Landroid/hardware/Camera;
    //   368: invokevirtual 192	android/hardware/Camera:stopPreview	()V
    //   371: aload_0
    //   372: getfield 79	com/wifipay/wallet/authentication/activity/TakePhotoActivity:m	Landroid/hardware/Camera;
    //   375: invokevirtual 195	android/hardware/Camera:startPreview	()V
    //   378: return
    //   379: aload_0
    //   380: getfield 55	com/wifipay/wallet/authentication/activity/TakePhotoActivity:p	I
    //   383: iconst_1
    //   384: if_icmpne -69 -> 315
    //   387: aload_0
    //   388: ldc -59
    //   390: invokevirtual 174	com/wifipay/wallet/authentication/activity/TakePhotoActivity:a	(Ljava/lang/String;)V
    //   393: goto -78 -> 315
    //   396: astore_2
    //   397: aload 4
    //   399: astore 5
    //   401: aload_2
    //   402: astore 4
    //   404: aload_1
    //   405: astore_3
    //   406: aload 5
    //   408: astore_2
    //   409: aload 4
    //   411: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   414: aload 5
    //   416: ifnull +13 -> 429
    //   419: aload 5
    //   421: invokevirtual 181	java/io/BufferedOutputStream:flush	()V
    //   424: aload 5
    //   426: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   429: aload_1
    //   430: ifnull +7 -> 437
    //   433: aload_1
    //   434: invokevirtual 187	android/graphics/Bitmap:recycle	()V
    //   437: aload_0
    //   438: getfield 79	com/wifipay/wallet/authentication/activity/TakePhotoActivity:m	Landroid/hardware/Camera;
    //   441: invokevirtual 192	android/hardware/Camera:stopPreview	()V
    //   444: aload_0
    //   445: getfield 79	com/wifipay/wallet/authentication/activity/TakePhotoActivity:m	Landroid/hardware/Camera;
    //   448: invokevirtual 195	android/hardware/Camera:startPreview	()V
    //   451: goto -73 -> 378
    //   454: astore_1
    //   455: aload_1
    //   456: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   459: goto -81 -> 378
    //   462: astore_1
    //   463: aload_1
    //   464: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   467: goto -89 -> 378
    //   470: astore 4
    //   472: aconst_null
    //   473: astore_1
    //   474: aload_2
    //   475: ifnull +11 -> 486
    //   478: aload_2
    //   479: invokevirtual 181	java/io/BufferedOutputStream:flush	()V
    //   482: aload_2
    //   483: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   486: aload_1
    //   487: ifnull +7 -> 494
    //   490: aload_1
    //   491: invokevirtual 187	android/graphics/Bitmap:recycle	()V
    //   494: aload_0
    //   495: getfield 79	com/wifipay/wallet/authentication/activity/TakePhotoActivity:m	Landroid/hardware/Camera;
    //   498: invokevirtual 192	android/hardware/Camera:stopPreview	()V
    //   501: aload_0
    //   502: getfield 79	com/wifipay/wallet/authentication/activity/TakePhotoActivity:m	Landroid/hardware/Camera;
    //   505: invokevirtual 195	android/hardware/Camera:startPreview	()V
    //   508: aload 4
    //   510: athrow
    //   511: astore_1
    //   512: aload_1
    //   513: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   516: goto -8 -> 508
    //   519: astore 4
    //   521: aload_3
    //   522: astore_1
    //   523: goto -49 -> 474
    //   526: astore_3
    //   527: aload 4
    //   529: astore_2
    //   530: aload_3
    //   531: astore 4
    //   533: goto -59 -> 474
    //   536: astore 4
    //   538: aconst_null
    //   539: astore_1
    //   540: goto -136 -> 404
    //   543: astore 4
    //   545: goto -141 -> 404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	548	0	this	TakePhotoActivity
    //   0	548	1	paramArrayOfByte	byte[]
    //   1	333	2	localObject1	Object
    //   396	6	2	localException1	Exception
    //   408	122	2	localObject2	Object
    //   17	505	3	arrayOfByte	byte[]
    //   526	5	3	localObject3	Object
    //   24	386	4	localObject4	Object
    //   470	39	4	localObject5	Object
    //   519	9	4	localObject6	Object
    //   531	1	4	localObject7	Object
    //   536	1	4	localException2	Exception
    //   543	1	4	localException3	Exception
    //   6	419	5	localObject8	Object
    //   3	270	6	localObject9	Object
    //   152	183	7	str	String
    //   162	135	8	localFile	File
    //   256	22	9	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   282	315	396	java/lang/Exception
    //   315	346	396	java/lang/Exception
    //   379	393	396	java/lang/Exception
    //   419	429	454	java/io/IOException
    //   433	437	454	java/io/IOException
    //   437	451	454	java/io/IOException
    //   346	356	462	java/io/IOException
    //   360	364	462	java/io/IOException
    //   364	378	462	java/io/IOException
    //   8	16	470	finally
    //   478	486	511	java/io/IOException
    //   490	494	511	java/io/IOException
    //   494	508	511	java/io/IOException
    //   21	26	519	finally
    //   31	40	519	finally
    //   45	53	519	finally
    //   58	63	519	finally
    //   68	75	519	finally
    //   80	104	519	finally
    //   109	114	519	finally
    //   119	124	519	finally
    //   129	154	519	finally
    //   159	164	519	finally
    //   169	176	519	finally
    //   181	189	519	finally
    //   194	199	519	finally
    //   204	211	519	finally
    //   216	238	519	finally
    //   243	248	519	finally
    //   253	258	519	finally
    //   263	270	519	finally
    //   275	282	519	finally
    //   409	414	519	finally
    //   282	315	526	finally
    //   315	346	526	finally
    //   379	393	526	finally
    //   8	16	536	java/lang/Exception
    //   21	26	543	java/lang/Exception
    //   31	40	543	java/lang/Exception
    //   45	53	543	java/lang/Exception
    //   58	63	543	java/lang/Exception
    //   68	75	543	java/lang/Exception
    //   80	104	543	java/lang/Exception
    //   109	114	543	java/lang/Exception
    //   119	124	543	java/lang/Exception
    //   129	154	543	java/lang/Exception
    //   159	164	543	java/lang/Exception
    //   169	176	543	java/lang/Exception
    //   181	189	543	java/lang/Exception
    //   194	199	543	java/lang/Exception
    //   204	211	543	java/lang/Exception
    //   216	238	543	java/lang/Exception
    //   243	248	543	java/lang/Exception
    //   253	258	543	java/lang/Exception
    //   263	270	543	java/lang/Exception
    //   275	282	543	java/lang/Exception
  }
  
  public static boolean a(File paramFile)
  {
    File localFile;
    if (paramFile != null)
    {
      localFile = new File(paramFile.getParent() + File.separator + System.currentTimeMillis());
      paramFile.renameTo(localFile);
    }
    for (boolean bool = localFile.delete();; bool = false) {
      return bool;
    }
  }
  
  private Camera.Size b(Camera paramCamera)
  {
    List localList = paramCamera.getParameters().getSupportedPreviewSizes();
    Iterator localIterator = localList.iterator();
    paramCamera = null;
    while (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      if (localSize.width > 2000) {
        break label94;
      }
      if (paramCamera == null)
      {
        paramCamera = localSize;
      }
      else
      {
        if (localSize.width <= paramCamera.width) {
          break label94;
        }
        paramCamera = localSize;
      }
    }
    label94:
    for (;;)
    {
      break;
      if (paramCamera == null) {
        paramCamera = (Camera.Size)localList.get(0);
      }
      for (;;)
      {
        return paramCamera;
      }
    }
  }
  
  private Camera.Size b(Camera paramCamera, float paramFloat)
  {
    List localList = paramCamera.getParameters().getSupportedPictureSizes();
    Iterator localIterator = localList.iterator();
    paramCamera = null;
    while (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      if ((localSize.width / localSize.height != paramFloat) || (localSize.width > 2000) || (localSize.height > 2000)) {
        break label123;
      }
      if (paramCamera == null)
      {
        paramCamera = localSize;
      }
      else
      {
        if (localSize.width <= paramCamera.width) {
          break label123;
        }
        paramCamera = localSize;
      }
    }
    label123:
    for (;;)
    {
      break;
      if (paramCamera == null) {
        paramCamera = (Camera.Size)localList.get(0);
      }
      for (;;)
      {
        return paramCamera;
      }
    }
  }
  
  private void b(File paramFile)
  {
    if (paramFile.isFile()) {
      a(paramFile);
    }
    for (;;)
    {
      return;
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if ((arrayOfFile == null) || (arrayOfFile.length == 0))
        {
          a(paramFile);
        }
        else
        {
          for (int i1 = 0; i1 < arrayOfFile.length; i1++) {
            b(arrayOfFile[i1]);
          }
          a(paramFile);
        }
      }
    }
  }
  
  private void i()
  {
    ImageView localImageView1 = (ImageView)findViewById(R.id.wifipay_btn_takepicture);
    ImageView localImageView2 = (ImageView)findViewById(R.id.wifipay_take_photo_back);
    this.j = ((TextView)findViewById(R.id.wifipay_btn_reset));
    this.k = ((TextView)findViewById(R.id.wifipay_btn_next));
    this.l = ((TextView)findViewById(R.id.wifipay_take_photo_content));
    localImageView1.setVisibility(0);
    this.j.setVisibility(4);
    this.k.setVisibility(4);
    localImageView1.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    localImageView2.setOnClickListener(this);
    this.i = ((SurfaceView)findViewById(R.id.wifipay_surfaceView));
    this.i.getHolder().setType(3);
    getWindowManager().getDefaultDisplay();
    this.r = d.b(this);
    this.s = d.a(this);
    this.i.getHolder().addCallback(new b(null));
    this.i.getHolder().setKeepScreenOn(true);
  }
  
  private void j()
  {
    if (this.o == null) {
      b("获取相片失败！请重新拍照");
    }
    for (;;)
    {
      return;
      try
      {
        a(this.o.getByteArray("bytes"));
        this.p += 1;
        if ((this.p == 1) && (this.m != null))
        {
          this.j.setVisibility(4);
          this.k.setVisibility(4);
          this.l.setText(f.a(R.string.wifipay_identity_upload_take_verso));
          k();
          this.q = true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (this.p == 2)
      {
        this.k.setEnabled(false);
        Intent localIntent = new Intent(this, TakePhotoResultActivity.class);
        localIntent.putExtra("path", this.t);
        localIntent.putExtra("which_fragment", R.id.wifipay_fragment_upload_show);
        startActivity(localIntent);
        finish();
      }
    }
  }
  
  private void k()
  {
    this.n = this.m.getParameters();
    this.n.setJpegQuality(100);
    if ((this.n.getSupportedFocusModes().contains("continuous-picture")) && (Build.VERSION.SDK_INT >= 14)) {
      this.n.setFocusMode("continuous-picture");
    }
    this.m.cancelAutoFocus();
    this.m.setParameters(this.n);
    this.m.startPreview();
  }
  
  public void a(Camera paramCamera)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    try
    {
      Camera.Size localSize = b(paramCamera);
      localParameters.setPictureSize(localSize.width, localSize.height);
      paramCamera.setParameters(localParameters);
      paramCamera = new java/lang/StringBuilder;
      paramCamera.<init>("setFitPreSize:");
      Logger.i("TakePhotoActivity == %s", new Object[] { localSize.width + "*" + localSize.height });
      return;
    }
    catch (Exception paramCamera)
    {
      for (;;)
      {
        paramCamera.printStackTrace();
      }
    }
  }
  
  public void a(Camera paramCamera, float paramFloat)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    try
    {
      Camera.Size localSize = b(paramCamera, paramFloat);
      localParameters.setPictureSize(localSize.width, localSize.height);
      paramCamera.setParameters(localParameters);
      paramCamera = new java/lang/StringBuilder;
      paramCamera.<init>("setFitPicSize:");
      Logger.i("TakePhotoActivity == %s", new Object[] { localSize.width + "*" + localSize.height });
      return;
    }
    catch (Exception paramCamera)
    {
      for (;;)
      {
        paramCamera.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_btn_takepicture) {
      if ((this.m != null) && (this.q))
      {
        this.m.takePicture(null, null, new a(null));
        this.q = false;
      }
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifipay_btn_reset)
      {
        this.j.setVisibility(4);
        this.k.setVisibility(4);
        if (this.m != null)
        {
          this.q = true;
          k();
        }
      }
      else if (paramView.getId() == R.id.wifipay_btn_next)
      {
        if (this.p == 0) {
          k();
        }
        j();
      }
      else if ((paramView.getId() == R.id.wifipay_take_photo_back) && (!isFinishing()))
      {
        finish();
      }
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    if (getRequestedOrientation() == 0) {
      setRequestedOrientation(1);
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      if ((this.m != null) && (paramKeyEvent.getRepeatCount() == 0) && (this.q))
      {
        this.m.takePicture(null, null, new a(null));
        this.q = false;
        continue;
        finish();
      }
    }
  }
  
  private final class a
    implements Camera.PictureCallback
  {
    private a() {}
    
    public final void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
    {
      try
      {
        TakePhotoActivity localTakePhotoActivity = TakePhotoActivity.this;
        paramCamera = new android/os/Bundle;
        paramCamera.<init>();
        TakePhotoActivity.a(localTakePhotoActivity, paramCamera);
        TakePhotoActivity.c(TakePhotoActivity.this).putByteArray("bytes", paramArrayOfByte);
        TakePhotoActivity.d(TakePhotoActivity.this).setVisibility(0);
        TakePhotoActivity.e(TakePhotoActivity.this).setVisibility(0);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
  }
  
  private final class b
    implements SurfaceHolder.Callback
  {
    private b() {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      Logger.i("TakePhotoActivity == %s", new Object[] { "surfaceChanged  camera:" + TakePhotoActivity.a(TakePhotoActivity.this) });
      if (TakePhotoActivity.a(TakePhotoActivity.this) != null)
      {
        TakePhotoActivity.this.a(TakePhotoActivity.a(TakePhotoActivity.this));
        paramSurfaceHolder = TakePhotoActivity.a(TakePhotoActivity.this).getParameters().getPreviewSize();
        TakePhotoActivity.this.a(TakePhotoActivity.a(TakePhotoActivity.this), paramSurfaceHolder.width / paramSurfaceHolder.height);
        Logger.i("TakePhotoActivity == %s", new Object[] { "adpterSize Preview-->width:" + paramSurfaceHolder.width + "  height:" + paramSurfaceHolder.height });
        paramSurfaceHolder = TakePhotoActivity.a(TakePhotoActivity.this).getParameters().getPictureSize();
        Logger.i("TakePhotoActivity == %s", new Object[] { "adpterSize Picture-->width:" + paramSurfaceHolder.width + "  height:" + paramSurfaceHolder.height });
        TakePhotoActivity.b(TakePhotoActivity.this);
      }
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      try
      {
        TakePhotoActivity.a(TakePhotoActivity.this, Camera.open());
        TakePhotoActivity.a(TakePhotoActivity.this).setPreviewDisplay(paramSurfaceHolder);
        TakePhotoActivity.a(TakePhotoActivity.this).setDisplayOrientation(TakePhotoActivity.a(TakePhotoActivity.this));
        TakePhotoActivity.a(TakePhotoActivity.this).startPreview();
        TakePhotoActivity.a(TakePhotoActivity.this).autoFocus(null);
        return;
      }
      catch (Exception paramSurfaceHolder)
      {
        for (;;)
        {
          TakePhotoActivity.a(TakePhotoActivity.this, null);
          paramSurfaceHolder.printStackTrace();
        }
      }
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      Logger.i("TakePhotoActivity == %s", new Object[] { "surfaceDestroyed  camera:" + TakePhotoActivity.a(TakePhotoActivity.this) });
      if (TakePhotoActivity.a(TakePhotoActivity.this) != null)
      {
        TakePhotoActivity.a(TakePhotoActivity.this).stopPreview();
        TakePhotoActivity.a(TakePhotoActivity.this).release();
        TakePhotoActivity.a(TakePhotoActivity.this, null);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/activity/TakePhotoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */