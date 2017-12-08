package com.lantern.wifilocating.push.i;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.lantern.wifilocating.push.service.PushService;
import com.lantern.wifilocating.push.util.g;
import com.lantern.wifilocating.push.util.i;
import com.lantern.wifilocating.push.util.l;
import com.lantern.wifilocating.push.util.process.models.AndroidAppProcess;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class b
  extends com.lantern.wifilocating.push.g.c.c
{
  private static Notification a(Context paramContext, com.lantern.wifilocating.push.h.b paramb, int paramInt)
  {
    boolean bool = true;
    int i = 1;
    Notification localNotification = new Notification();
    localNotification.audioStreamType = -1;
    localNotification.icon = com.lantern.wifilocating.push.c.a().getApplicationInfo().icon;
    localNotification.flags |= 0x10;
    localNotification.flags |= 0x80;
    label93:
    Intent localIntent;
    Object localObject;
    if (paramb.J > 0L)
    {
      localNotification.when = paramb.J;
      if (paramb.D != 1) {
        break label485;
      }
      localNotification.defaults = 1;
      localIntent = new Intent(com.lantern.wifilocating.push.c.a(), PushService.class);
      localIntent.putExtra("PUSH_START_TYPE", "PUSH_START_TYPE_NOTIFICATION_DISPATCH");
      localIntent.addFlags(268435456);
      switch (paramb.p)
      {
      default: 
        localObject = null;
        if (localObject != null)
        {
          com.lantern.wifilocating.push.util.b.c("targetIntent:" + localObject);
          localIntent.putExtra("target_intent", (Parcelable)localObject);
          localIntent.putExtra("push_id", paramb.c);
          localIntent.putExtra("push_sequence", paramb.a);
          localIntent.putExtra("push_sequence_type", paramb.b);
          localIntent.putExtra("push_status", String.valueOf(paramb.H));
          localIntent.putExtra("push_syt", paramb.I);
          localIntent.putExtra("push_dc_level", paramb.L);
          localIntent.putExtra("push_content_misc", paramb.o);
          localObject = PendingIntent.getService(com.lantern.wifilocating.push.c.a(), paramInt, localIntent, 134217728);
          com.lantern.wifilocating.push.util.b.c("intent:" + localIntent);
          com.lantern.wifilocating.push.util.b.c("pendingIntent:" + localObject);
        }
        break;
      }
    }
    for (;;)
    {
      localNotification.setLatestEventInfo(paramContext, paramb.h, paramb.l, (PendingIntent)localObject);
      localObject = new Intent(com.lantern.wifilocating.push.c.a(), PushService.class);
      ((Intent)localObject).putExtra("PUSH_START_TYPE", "PUSH_START_TYPE_NOTIFICATION_DISPATCH");
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("intent_type", 6);
      ((Intent)localObject).putExtra("push_id", paramb.c);
      ((Intent)localObject).putExtra("push_sequence", paramb.a);
      ((Intent)localObject).putExtra("push_sequence_type", paramb.b);
      ((Intent)localObject).putExtra("push_status", String.valueOf(paramb.H));
      ((Intent)localObject).putExtra("push_syt", paramb.I);
      localNotification.deleteIntent = PendingIntent.getService(paramContext, paramInt << 1, (Intent)localObject, 134217728);
      return localNotification;
      localNotification.when = System.currentTimeMillis();
      break;
      label485:
      if (paramb.D != 2) {
        break label93;
      }
      localNotification.defaults = 2;
      break label93;
      String str = g.g();
      if ((paramb.q == 1) && (a(str)))
      {
        localObject = new Intent(g.h(), Uri.parse(paramb.r));
        ((Intent)localObject).setPackage(str);
      }
      for (;;)
      {
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("from", "wkpush");
        ((Intent)localObject).putExtra("push_id", paramb.c);
        localIntent.putExtra("intent_type", i);
        break;
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramb.r));
        i = 2;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("down_url", paramb.u);
      if (paramb.w == 1) {}
      for (;;)
      {
        ((Intent)localObject).putExtra("need_tips", bool);
        ((Intent)localObject).putExtra("app_name", paramb.x);
        ((Intent)localObject).putExtra("dialog_title", paramb.y);
        ((Intent)localObject).putExtra("dialog_content", paramb.z);
        ((Intent)localObject).putExtra("dialog_icon", paramb.A);
        ((Intent)localObject).putExtra("push_id", paramb.c);
        localIntent.putExtra("intent_type", 5);
        break;
        bool = false;
      }
      if (!TextUtils.isEmpty(paramb.t))
      {
        localObject = new Intent();
        ((Intent)localObject).setAction(paramb.t);
        ((Intent)localObject).setPackage(paramb.s);
      }
      for (;;)
      {
        ((Intent)localObject).addFlags(268435456);
        localIntent.putExtra("intent_type", 2);
        break;
        localObject = com.lantern.wifilocating.push.c.a().getPackageManager().getLaunchIntentForPackage(paramb.s);
      }
      localObject = null;
    }
  }
  
  private static Notification a(com.lantern.wifilocating.push.h.b paramb, int paramInt)
  {
    for (;;)
    {
      try
      {
        localNotification = a(com.lantern.wifilocating.push.c.a(), paramb, paramInt);
        Bitmap localBitmap;
        try
        {
          localBitmap = a(paramb.e, true);
          paramb = localNotification;
          if (localBitmap != null) {
            a(localBitmap);
          }
          try
          {
            localNotification.contentView.setImageViewBitmap(16908294, localBitmap);
            paramb = localNotification;
          }
          catch (Throwable paramb)
          {
            com.lantern.wifilocating.push.util.h.a(paramb);
            try
            {
              localNotification.largeIcon = localBitmap;
              paramb = localNotification;
            }
            catch (Throwable paramb)
            {
              com.lantern.wifilocating.push.util.h.a(paramb);
              paramb = localNotification;
            }
            continue;
          }
          return paramb;
        }
        catch (Exception paramb) {}
      }
      catch (Exception paramb)
      {
        Notification localNotification = null;
        continue;
      }
      com.lantern.wifilocating.push.util.h.a(paramb);
      paramb = localNotification;
    }
  }
  
  private static Notification a(com.lantern.wifilocating.push.h.b paramb, int paramInt, boolean paramBoolean)
  {
    Bitmap localBitmap2 = null;
    Context localContext = com.lantern.wifilocating.push.c.a();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        i = l.a(localContext, "push_sdk_noti_txt_big");
        if (i == 0)
        {
          paramb = a(paramb, paramInt);
          return paramb;
          i = l.a(localContext, "push_sdk_noti_txt");
          continue;
        }
        localRemoteViews = new android/widget/RemoteViews;
        localRemoteViews.<init>(localContext.getPackageName(), i);
        localNotification = a(com.lantern.wifilocating.push.c.a(), paramb, paramInt);
      }
      catch (Exception localException2)
      {
        int i;
        RemoteViews localRemoteViews;
        Notification localNotification;
        Object localObject1;
        String str;
        paramb = null;
        continue;
        Bitmap localBitmap1 = null;
        continue;
        localBitmap1 = null;
        continue;
        Object localObject2 = null;
        continue;
      }
      try
      {
        localObject1 = a(paramb.e, true);
        if (localObject1 != null) {
          a((Bitmap)localObject1);
        }
        if (localObject1 == null) {
          continue;
        }
        localRemoteViews.setImageViewBitmap(l.c(localContext, "push_iv_logo"), (Bitmap)localObject1);
        if (TextUtils.isEmpty(paramb.f)) {
          continue;
        }
        localObject1 = a(paramb.f, false);
        if (TextUtils.isEmpty(paramb.g)) {
          continue;
        }
        localBitmap1 = a(paramb.g, false);
        if ((!TextUtils.isEmpty(paramb.h)) || (localObject1 != null) || (localBitmap1 != null)) {
          continue;
        }
        localRemoteViews.setViewVisibility(l.c(localContext, "push_tv_title_layout"), 8);
        if (!paramBoolean) {
          continue;
        }
        localObject1 = paramb.k;
        if (TextUtils.isEmpty(paramb.i)) {
          continue;
        }
        localBitmap1 = a(paramb.i, false);
        if (!TextUtils.isEmpty(paramb.j)) {
          localBitmap2 = a(paramb.j, false);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (localBitmap1 != null) || (localBitmap2 != null)) {
          continue;
        }
        localRemoteViews.setViewVisibility(l.c(localContext, "push_tv_sub_title_layout"), 8);
        if (paramBoolean)
        {
          if (!TextUtils.isEmpty(paramb.l)) {
            continue;
          }
          localRemoteViews.setViewVisibility(l.c(localContext, "push_tv_content"), 8);
        }
        if (!TextUtils.isEmpty(paramb.m)) {
          continue;
        }
        localRemoteViews.setViewVisibility(l.c(localContext, "push_layout_btn"), 8);
        localNotification.contentView = localRemoteViews;
        paramb = localNotification;
        if (!paramBoolean) {
          continue;
        }
        paramInt = Build.VERSION.SDK_INT;
        paramb = localNotification;
        if (paramInt < 16) {
          continue;
        }
        try
        {
          Notification.class.getDeclaredField("bigContentView").set(localNotification, localRemoteViews);
          paramb = localNotification;
        }
        catch (Throwable paramb)
        {
          com.lantern.wifilocating.push.util.h.a(paramb);
          paramb = localNotification;
        }
      }
      catch (Exception localException1)
      {
        paramb = localNotification;
        com.lantern.wifilocating.push.util.h.a(localException1);
      }
      continue;
      localRemoteViews.setImageViewResource(l.c(localContext, "push_iv_logo"), localContext.getApplicationInfo().icon);
      continue;
      paramInt = l.c(localContext, "push_tv_title");
      if (!TextUtils.isEmpty(paramb.h))
      {
        localRemoteViews.setTextViewText(paramInt, Html.fromHtml(paramb.h));
        i = Build.VERSION.SDK_INT;
        if (i >= 21) {}
        try
        {
          if (localContext.getApplicationInfo().targetSdkVersion >= 21) {
            localRemoteViews.setInt(paramInt, "setTextColor", -11711155);
          }
          if (localException1 == null) {
            continue;
          }
          localRemoteViews.setImageViewBitmap(l.c(localContext, "push_tv_title_img_1"), localException1);
          if (localBitmap1 == null) {
            continue;
          }
          localRemoteViews.setImageViewBitmap(l.c(localContext, "push_tv_title_img_2"), localBitmap1);
        }
        catch (Throwable localThrowable)
        {
          com.lantern.wifilocating.push.util.h.a(localThrowable);
          continue;
        }
      }
      else
      {
        localRemoteViews.setViewVisibility(paramInt, 8);
        continue;
        localRemoteViews.setViewVisibility(l.c(localContext, "push_tv_title_img_1"), 8);
        continue;
        localRemoteViews.setViewVisibility(l.c(localContext, "push_tv_title_img_2"), 8);
        continue;
        str = paramb.l;
        continue;
        if (!TextUtils.isEmpty(str))
        {
          localRemoteViews.setTextViewText(l.c(localContext, "push_tv_sub_title"), Html.fromHtml(str));
          if (localBitmap1 != null)
          {
            localRemoteViews.setImageViewBitmap(l.c(localContext, "push_tv_sub_title_img_1"), localBitmap1);
            if (localBitmap2 == null) {
              continue;
            }
            localRemoteViews.setImageViewBitmap(l.c(localContext, "push_tv_sub_title_img_2"), localBitmap2);
          }
        }
        else
        {
          localRemoteViews.setViewVisibility(l.c(localContext, "push_tv_sub_title"), 8);
          continue;
        }
        localRemoteViews.setViewVisibility(l.c(localContext, "push_tv_sub_title_img_1"), 8);
        continue;
        localRemoteViews.setViewVisibility(l.c(localContext, "push_tv_sub_title_img_2"), 8);
        continue;
        localRemoteViews.setTextViewText(l.c(localContext, "push_tv_content"), Html.fromHtml(paramb.l));
        continue;
        localRemoteViews.setTextViewText(l.c(localContext, "push_btn"), paramb.m);
      }
    }
  }
  
  /* Error */
  private static Bitmap a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: fconst_1
    //   1: fstore_3
    //   2: aconst_null
    //   3: astore 14
    //   5: aconst_null
    //   6: astore 13
    //   8: aload_0
    //   9: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +1059 -> 1071
    //   15: invokestatic 25	com/lantern/wifilocating/push/c:a	()Landroid/content/Context;
    //   18: invokevirtual 417	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   21: astore 9
    //   23: aload 9
    //   25: ifnull +1043 -> 1068
    //   28: new 419	java/io/File
    //   31: astore 10
    //   33: aload 10
    //   35: aload 9
    //   37: ldc_w 421
    //   40: invokespecial 424	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: aload 10
    //   45: invokevirtual 428	java/io/File:exists	()Z
    //   48: ifeq +15 -> 63
    //   51: aload 10
    //   53: astore 9
    //   55: aload 10
    //   57: invokevirtual 431	java/io/File:isDirectory	()Z
    //   60: ifne +13 -> 73
    //   63: aload 10
    //   65: invokevirtual 434	java/io/File:mkdirs	()Z
    //   68: pop
    //   69: aload 10
    //   71: astore 9
    //   73: aload 9
    //   75: ifnull +31 -> 106
    //   78: aload 9
    //   80: astore 11
    //   82: aload 9
    //   84: invokevirtual 428	java/io/File:exists	()Z
    //   87: ifeq +19 -> 106
    //   90: aload 9
    //   92: astore 10
    //   94: aload 9
    //   96: astore 11
    //   98: aload 9
    //   100: invokevirtual 431	java/io/File:isDirectory	()Z
    //   103: ifne +77 -> 180
    //   106: aload 9
    //   108: astore 11
    //   110: invokestatic 25	com/lantern/wifilocating/push/c:a	()Landroid/content/Context;
    //   113: invokevirtual 437	android/content/Context:getCacheDir	()Ljava/io/File;
    //   116: astore 9
    //   118: aload 9
    //   120: ifnull +941 -> 1061
    //   123: new 419	java/io/File
    //   126: astore 12
    //   128: aload 12
    //   130: aload 9
    //   132: ldc_w 421
    //   135: invokespecial 424	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   138: aload 12
    //   140: astore 11
    //   142: aload 12
    //   144: invokevirtual 428	java/io/File:exists	()Z
    //   147: ifeq +19 -> 166
    //   150: aload 12
    //   152: astore 10
    //   154: aload 12
    //   156: astore 11
    //   158: aload 12
    //   160: invokevirtual 431	java/io/File:isDirectory	()Z
    //   163: ifne +17 -> 180
    //   166: aload 12
    //   168: astore 11
    //   170: aload 12
    //   172: invokevirtual 434	java/io/File:mkdirs	()Z
    //   175: pop
    //   176: aload 12
    //   178: astore 10
    //   180: aload 10
    //   182: ifnull +590 -> 772
    //   185: aload 14
    //   187: astore 11
    //   189: aload 10
    //   191: invokevirtual 428	java/io/File:exists	()Z
    //   194: ifeq +578 -> 772
    //   197: aload 14
    //   199: astore 11
    //   201: aload 10
    //   203: invokevirtual 431	java/io/File:isDirectory	()Z
    //   206: ifeq +566 -> 772
    //   209: aload 14
    //   211: astore 11
    //   213: aload 10
    //   215: invokevirtual 440	java/io/File:canWrite	()Z
    //   218: ifeq +554 -> 772
    //   221: aload 14
    //   223: astore 11
    //   225: new 419	java/io/File
    //   228: astore 15
    //   230: aload 14
    //   232: astore 11
    //   234: new 79	java/lang/StringBuilder
    //   237: astore 9
    //   239: aload 14
    //   241: astore 11
    //   243: aload 9
    //   245: invokespecial 441	java/lang/StringBuilder:<init>	()V
    //   248: aload 14
    //   250: astore 11
    //   252: aload 15
    //   254: aload 10
    //   256: aload 9
    //   258: aload_0
    //   259: invokestatic 446	com/lantern/wifilocating/push/d/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 451
    //   268: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokespecial 424	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   277: aload 14
    //   279: astore 11
    //   281: aload 15
    //   283: invokevirtual 454	java/io/File:isFile	()Z
    //   286: ifeq +237 -> 523
    //   289: aload 14
    //   291: astore 11
    //   293: aload 15
    //   295: invokevirtual 428	java/io/File:exists	()Z
    //   298: ifeq +225 -> 523
    //   301: aload 14
    //   303: astore 11
    //   305: aload 15
    //   307: invokevirtual 457	java/io/File:length	()J
    //   310: lstore 7
    //   312: lload 7
    //   314: lconst_0
    //   315: lcmp
    //   316: ifle +207 -> 523
    //   319: aload 14
    //   321: astore 11
    //   323: aload 15
    //   325: invokevirtual 460	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   328: invokestatic 466	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   331: astore_0
    //   332: aconst_null
    //   333: astore 9
    //   335: aload_0
    //   336: astore 10
    //   338: iload_1
    //   339: ifeq +158 -> 497
    //   342: aload_0
    //   343: astore 10
    //   345: aload_0
    //   346: ifnull +151 -> 497
    //   349: aload_0
    //   350: invokevirtual 472	android/graphics/Bitmap:getWidth	()I
    //   353: istore 5
    //   355: aload_0
    //   356: invokevirtual 475	android/graphics/Bitmap:getHeight	()I
    //   359: istore 6
    //   361: iload 5
    //   363: ifeq +670 -> 1033
    //   366: iload 6
    //   368: ifeq +665 -> 1033
    //   371: iload 5
    //   373: iload 6
    //   375: if_icmpeq +471 -> 846
    //   378: iload 5
    //   380: iload 6
    //   382: if_icmpge +434 -> 816
    //   385: iload 5
    //   387: i2f
    //   388: iload 6
    //   390: i2f
    //   391: fdiv
    //   392: fstore_2
    //   393: iload 5
    //   395: sipush 192
    //   398: if_icmple +657 -> 1055
    //   401: ldc_w 476
    //   404: iload 5
    //   406: i2f
    //   407: fdiv
    //   408: fstore_3
    //   409: fconst_1
    //   410: fstore 4
    //   412: fload 4
    //   414: fload_3
    //   415: fmul
    //   416: fstore 4
    //   418: fload_3
    //   419: fload_2
    //   420: fmul
    //   421: fstore_2
    //   422: fload 4
    //   424: fconst_0
    //   425: fcmpl
    //   426: ifle +618 -> 1044
    //   429: fload_2
    //   430: fconst_0
    //   431: fcmpl
    //   432: ifle +612 -> 1044
    //   435: new 478	android/graphics/Matrix
    //   438: astore 10
    //   440: aload 10
    //   442: invokespecial 479	android/graphics/Matrix:<init>	()V
    //   445: aload 10
    //   447: fload 4
    //   449: fload_2
    //   450: invokevirtual 483	android/graphics/Matrix:postScale	(FF)Z
    //   453: pop
    //   454: aload 10
    //   456: astore 11
    //   458: aload_0
    //   459: astore 10
    //   461: aload 11
    //   463: ifnull +34 -> 497
    //   466: aload_0
    //   467: iconst_0
    //   468: iconst_0
    //   469: iload 5
    //   471: iload 6
    //   473: aload 11
    //   475: iconst_0
    //   476: invokestatic 487	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   479: astore 11
    //   481: aload_0
    //   482: astore 10
    //   484: aload 11
    //   486: ifnull +11 -> 497
    //   489: aload_0
    //   490: invokevirtual 490	android/graphics/Bitmap:recycle	()V
    //   493: aload 11
    //   495: astore 10
    //   497: aload 9
    //   499: invokestatic 495	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   502: aload 10
    //   504: astore_0
    //   505: aload_0
    //   506: areturn
    //   507: astore_0
    //   508: aload 14
    //   510: astore 11
    //   512: invokestatic 498	java/lang/System:gc	()V
    //   515: aconst_null
    //   516: astore 9
    //   518: aconst_null
    //   519: astore_0
    //   520: goto -185 -> 335
    //   523: aload 14
    //   525: astore 11
    //   527: new 500	java/net/URL
    //   530: astore 10
    //   532: aload 14
    //   534: astore 11
    //   536: aload 10
    //   538: aload_0
    //   539: invokespecial 501	java/net/URL:<init>	(Ljava/lang/String;)V
    //   542: new 503	java/io/FileOutputStream
    //   545: astore 9
    //   547: aload 9
    //   549: aload 15
    //   551: invokespecial 506	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   554: aload 10
    //   556: invokevirtual 510	java/net/URL:openStream	()Ljava/io/InputStream;
    //   559: astore_0
    //   560: aload 9
    //   562: astore 10
    //   564: aload_0
    //   565: astore 11
    //   567: sipush 1024
    //   570: newarray <illegal type>
    //   572: astore 12
    //   574: aload 9
    //   576: astore 10
    //   578: aload_0
    //   579: astore 11
    //   581: aload_0
    //   582: aload 12
    //   584: invokevirtual 516	java/io/InputStream:read	([B)I
    //   587: istore 5
    //   589: iload 5
    //   591: ifle +85 -> 676
    //   594: aload 9
    //   596: astore 10
    //   598: aload_0
    //   599: astore 11
    //   601: aload 9
    //   603: aload 12
    //   605: iconst_0
    //   606: iload 5
    //   608: invokevirtual 522	java/io/OutputStream:write	([BII)V
    //   611: aload 9
    //   613: astore 10
    //   615: aload_0
    //   616: astore 11
    //   618: aload 9
    //   620: invokevirtual 525	java/io/OutputStream:flush	()V
    //   623: goto -49 -> 574
    //   626: astore 10
    //   628: aload 9
    //   630: astore 10
    //   632: aload_0
    //   633: astore 11
    //   635: aload 15
    //   637: invokevirtual 528	java/io/File:delete	()Z
    //   640: pop
    //   641: aload 9
    //   643: astore 10
    //   645: aload_0
    //   646: astore 11
    //   648: invokestatic 498	java/lang/System:gc	()V
    //   651: aload 14
    //   653: astore 11
    //   655: aload 9
    //   657: invokestatic 495	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   660: aload 14
    //   662: astore 11
    //   664: aload_0
    //   665: invokestatic 495	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   668: aconst_null
    //   669: astore 9
    //   671: aconst_null
    //   672: astore_0
    //   673: goto -338 -> 335
    //   676: aload 9
    //   678: astore 10
    //   680: aload_0
    //   681: astore 11
    //   683: aload 15
    //   685: invokevirtual 460	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   688: invokestatic 466	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   691: astore 12
    //   693: aload 14
    //   695: astore 11
    //   697: aload 9
    //   699: invokestatic 495	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   702: aload 14
    //   704: astore 11
    //   706: aload_0
    //   707: invokestatic 495	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   710: aconst_null
    //   711: astore 9
    //   713: aload 12
    //   715: astore_0
    //   716: goto -381 -> 335
    //   719: astore_0
    //   720: aconst_null
    //   721: astore 9
    //   723: aconst_null
    //   724: astore 10
    //   726: aload 14
    //   728: astore 11
    //   730: aload 9
    //   732: invokestatic 495	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   735: aload 14
    //   737: astore 11
    //   739: aload 10
    //   741: invokestatic 495	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   744: aload 14
    //   746: astore 11
    //   748: aload_0
    //   749: athrow
    //   750: astore_0
    //   751: aconst_null
    //   752: astore_0
    //   753: aload 13
    //   755: astore 9
    //   757: aload 9
    //   759: astore 11
    //   761: invokestatic 498	java/lang/System:gc	()V
    //   764: aload 9
    //   766: invokestatic 495	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   769: goto -264 -> 505
    //   772: aload 14
    //   774: astore 11
    //   776: new 500	java/net/URL
    //   779: astore 9
    //   781: aload 14
    //   783: astore 11
    //   785: aload 9
    //   787: aload_0
    //   788: invokespecial 501	java/net/URL:<init>	(Ljava/lang/String;)V
    //   791: aload 14
    //   793: astore 11
    //   795: aload 9
    //   797: invokevirtual 510	java/net/URL:openStream	()Ljava/io/InputStream;
    //   800: astore_0
    //   801: aload_0
    //   802: invokestatic 532	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   805: astore 10
    //   807: aload_0
    //   808: astore 9
    //   810: aload 10
    //   812: astore_0
    //   813: goto -478 -> 335
    //   816: iload 6
    //   818: i2f
    //   819: iload 5
    //   821: i2f
    //   822: fdiv
    //   823: fstore 4
    //   825: iload 6
    //   827: sipush 192
    //   830: if_icmple +220 -> 1050
    //   833: ldc_w 476
    //   836: iload 6
    //   838: i2f
    //   839: fdiv
    //   840: fstore_3
    //   841: fconst_1
    //   842: fstore_2
    //   843: goto -431 -> 412
    //   846: iload 5
    //   848: sipush 192
    //   851: if_icmple +182 -> 1033
    //   854: iload 5
    //   856: sipush 192
    //   859: if_icmple +180 -> 1039
    //   862: ldc_w 476
    //   865: iload 5
    //   867: i2f
    //   868: fdiv
    //   869: fstore_2
    //   870: fload_2
    //   871: fconst_0
    //   872: fcmpl
    //   873: ifle +160 -> 1033
    //   876: new 478	android/graphics/Matrix
    //   879: astore 11
    //   881: aload 11
    //   883: invokespecial 479	android/graphics/Matrix:<init>	()V
    //   886: aload 11
    //   888: fload_2
    //   889: fload_2
    //   890: invokevirtual 483	android/graphics/Matrix:postScale	(FF)Z
    //   893: pop
    //   894: goto -436 -> 458
    //   897: astore_0
    //   898: aload 11
    //   900: invokestatic 495	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   903: aload_0
    //   904: athrow
    //   905: astore 10
    //   907: goto -266 -> 641
    //   910: astore 9
    //   912: aload_0
    //   913: astore 11
    //   915: aload 9
    //   917: astore_0
    //   918: goto -20 -> 898
    //   921: astore_0
    //   922: aload 9
    //   924: astore 11
    //   926: goto -28 -> 898
    //   929: astore_0
    //   930: aload 12
    //   932: astore_0
    //   933: aload 13
    //   935: astore 9
    //   937: goto -180 -> 757
    //   940: astore 9
    //   942: aconst_null
    //   943: astore 10
    //   945: aload_0
    //   946: astore 9
    //   948: aload 10
    //   950: astore_0
    //   951: goto -194 -> 757
    //   954: astore 10
    //   956: goto -199 -> 757
    //   959: astore_0
    //   960: aconst_null
    //   961: astore 10
    //   963: goto -237 -> 726
    //   966: astore_0
    //   967: aload 10
    //   969: astore 9
    //   971: aload 11
    //   973: astore 10
    //   975: goto -249 -> 726
    //   978: astore_0
    //   979: aconst_null
    //   980: astore 9
    //   982: aconst_null
    //   983: astore_0
    //   984: goto -356 -> 628
    //   987: astore_0
    //   988: aconst_null
    //   989: astore_0
    //   990: goto -362 -> 628
    //   993: astore 9
    //   995: aload 11
    //   997: astore 10
    //   999: goto -819 -> 180
    //   1002: astore 10
    //   1004: aload 9
    //   1006: astore 10
    //   1008: goto -828 -> 180
    //   1011: astore 9
    //   1013: aconst_null
    //   1014: astore 9
    //   1016: goto -943 -> 73
    //   1019: astore 10
    //   1021: goto -948 -> 73
    //   1024: astore 9
    //   1026: aload 10
    //   1028: astore 9
    //   1030: goto -957 -> 73
    //   1033: aconst_null
    //   1034: astore 11
    //   1036: goto -578 -> 458
    //   1039: fconst_1
    //   1040: fstore_2
    //   1041: goto -171 -> 870
    //   1044: aconst_null
    //   1045: astore 10
    //   1047: goto -593 -> 454
    //   1050: fconst_1
    //   1051: fstore_2
    //   1052: goto -640 -> 412
    //   1055: fconst_1
    //   1056: fstore 4
    //   1058: goto -646 -> 412
    //   1061: aload 9
    //   1063: astore 10
    //   1065: goto -885 -> 180
    //   1068: goto -995 -> 73
    //   1071: aconst_null
    //   1072: astore_0
    //   1073: goto -568 -> 505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1076	0	paramString	String
    //   0	1076	1	paramBoolean	boolean
    //   392	660	2	f1	float
    //   1	840	3	f2	float
    //   410	647	4	f3	float
    //   353	513	5	i	int
    //   359	478	6	j	int
    //   310	3	7	l	long
    //   21	788	9	localObject1	Object
    //   910	13	9	localObject2	Object
    //   935	1	9	localObject3	Object
    //   940	1	9	localThrowable1	Throwable
    //   946	35	9	localObject4	Object
    //   993	12	9	localException1	Exception
    //   1011	1	9	localException2	Exception
    //   1014	1	9	localObject5	Object
    //   1024	1	9	localException3	Exception
    //   1028	34	9	localObject6	Object
    //   31	583	10	localObject7	Object
    //   626	1	10	localThrowable2	Throwable
    //   630	181	10	localObject8	Object
    //   905	1	10	localException4	Exception
    //   943	6	10	localObject9	Object
    //   954	1	10	localThrowable3	Throwable
    //   961	37	10	localObject10	Object
    //   1002	1	10	localException5	Exception
    //   1006	1	10	localException6	Exception
    //   1019	8	10	localException7	Exception
    //   1045	19	10	localObject11	Object
    //   80	955	11	localObject12	Object
    //   126	805	12	localObject13	Object
    //   6	928	13	localObject14	Object
    //   3	789	14	localObject15	Object
    //   228	456	15	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   323	332	507	java/lang/Throwable
    //   567	574	626	java/lang/Throwable
    //   581	589	626	java/lang/Throwable
    //   601	611	626	java/lang/Throwable
    //   618	623	626	java/lang/Throwable
    //   683	693	626	java/lang/Throwable
    //   542	554	719	finally
    //   189	197	750	java/lang/Throwable
    //   201	209	750	java/lang/Throwable
    //   213	221	750	java/lang/Throwable
    //   225	230	750	java/lang/Throwable
    //   234	239	750	java/lang/Throwable
    //   243	248	750	java/lang/Throwable
    //   252	277	750	java/lang/Throwable
    //   281	289	750	java/lang/Throwable
    //   293	301	750	java/lang/Throwable
    //   305	312	750	java/lang/Throwable
    //   512	515	750	java/lang/Throwable
    //   527	532	750	java/lang/Throwable
    //   536	542	750	java/lang/Throwable
    //   655	660	750	java/lang/Throwable
    //   664	668	750	java/lang/Throwable
    //   730	735	750	java/lang/Throwable
    //   739	744	750	java/lang/Throwable
    //   748	750	750	java/lang/Throwable
    //   776	781	750	java/lang/Throwable
    //   785	791	750	java/lang/Throwable
    //   795	801	750	java/lang/Throwable
    //   189	197	897	finally
    //   201	209	897	finally
    //   213	221	897	finally
    //   225	230	897	finally
    //   234	239	897	finally
    //   243	248	897	finally
    //   252	277	897	finally
    //   281	289	897	finally
    //   293	301	897	finally
    //   305	312	897	finally
    //   323	332	897	finally
    //   512	515	897	finally
    //   527	532	897	finally
    //   536	542	897	finally
    //   655	660	897	finally
    //   664	668	897	finally
    //   697	702	897	finally
    //   706	710	897	finally
    //   730	735	897	finally
    //   739	744	897	finally
    //   748	750	897	finally
    //   761	764	897	finally
    //   776	781	897	finally
    //   785	791	897	finally
    //   795	801	897	finally
    //   635	641	905	java/lang/Exception
    //   801	807	910	finally
    //   349	361	921	finally
    //   435	454	921	finally
    //   466	481	921	finally
    //   489	493	921	finally
    //   876	894	921	finally
    //   697	702	929	java/lang/Throwable
    //   706	710	929	java/lang/Throwable
    //   801	807	940	java/lang/Throwable
    //   349	361	954	java/lang/Throwable
    //   435	454	954	java/lang/Throwable
    //   466	481	954	java/lang/Throwable
    //   489	493	954	java/lang/Throwable
    //   876	894	954	java/lang/Throwable
    //   554	560	959	finally
    //   567	574	966	finally
    //   581	589	966	finally
    //   601	611	966	finally
    //   618	623	966	finally
    //   635	641	966	finally
    //   648	651	966	finally
    //   683	693	966	finally
    //   542	554	978	java/lang/Throwable
    //   554	560	987	java/lang/Throwable
    //   82	90	993	java/lang/Exception
    //   98	106	993	java/lang/Exception
    //   110	118	993	java/lang/Exception
    //   142	150	993	java/lang/Exception
    //   158	166	993	java/lang/Exception
    //   170	176	993	java/lang/Exception
    //   123	138	1002	java/lang/Exception
    //   15	23	1011	java/lang/Exception
    //   28	43	1019	java/lang/Exception
    //   43	51	1024	java/lang/Exception
    //   55	63	1024	java/lang/Exception
    //   63	69	1024	java/lang/Exception
  }
  
  private static void a(Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    if (j < i) {}
    for (;;)
    {
      if (i <= 36) {
        i = 120;
      }
      for (;;)
      {
        if (i != -1) {
          paramBitmap.setDensity(i);
        }
        return;
        if (i <= 48) {
          i = 160;
        } else if (i <= 72) {
          i = 240;
        } else if (i <= 96) {
          i = 320;
        } else if (i <= 144) {
          i = 480;
        } else if (i <= 192) {
          i = 640;
        } else {
          i = -1;
        }
      }
      i = j;
    }
  }
  
  private static boolean a(String paramString)
  {
    boolean bool = false;
    PackageManager localPackageManager = com.lantern.wifilocating.push.c.a().getPackageManager();
    try
    {
      paramString = localPackageManager.getPackageInfo(paramString, 0);
      if (paramString != null) {
        bool = true;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;) {}
    }
    return bool;
  }
  
  private static Notification b(com.lantern.wifilocating.push.h.b paramb, int paramInt)
  {
    Notification localNotification = null;
    RemoteViews localRemoteViews = null;
    Object localObject;
    if (TextUtils.isEmpty(paramb.n)) {
      localObject = localRemoteViews;
    }
    for (;;)
    {
      return (Notification)localObject;
      localObject = localNotification;
      try
      {
        int i = l.a(com.lantern.wifilocating.push.c.a(), "push_sdk_noti_img");
        localObject = localRemoteViews;
        if (i != 0)
        {
          localObject = localNotification;
          localNotification = a(com.lantern.wifilocating.push.c.a(), paramb, paramInt);
          localObject = localNotification;
          localRemoteViews = new android/widget/RemoteViews;
          localObject = localNotification;
          localRemoteViews.<init>(com.lantern.wifilocating.push.c.a().getPackageName(), i);
          localObject = localNotification;
          paramb = a(paramb.n, false);
          localObject = localNotification;
          localRemoteViews.setBitmap(l.c(com.lantern.wifilocating.push.c.a(), "iv_logo"), "setImageBitmap", paramb);
          localObject = localNotification;
          localNotification.contentView = localRemoteViews;
          localObject = localNotification;
        }
      }
      catch (Exception paramb)
      {
        com.lantern.wifilocating.push.util.h.a(paramb);
      }
    }
  }
  
  private static void b(Context paramContext, int paramInt, Notification paramNotification, com.lantern.wifilocating.push.h.b paramb, JSONObject paramJSONObject)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, paramNotification);
    com.lantern.wifilocating.push.g.a.a.a().a(paramb.c, paramJSONObject);
    paramContext = new com.lantern.wifilocating.push.a.b.a();
    paramContext.a(paramb.b);
    paramContext.b(paramb.a);
    paramContext.c(paramb.c);
    paramContext.c(paramb.H);
    paramContext.d(2);
    paramContext.e(1);
    paramContext.f(paramb.I);
    com.lantern.wifilocating.push.f.a.a("012003", paramContext.a(), paramb.I, paramb.L);
  }
  
  private static boolean b(String paramString)
  {
    Object localObject1;
    try
    {
      localObject1 = com.lantern.wifilocating.push.c.a();
      if (Build.VERSION.SDK_INT < 21) {
        break label139;
      }
      Object localObject2 = com.lantern.wifilocating.push.util.process.a.a();
      localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AndroidAppProcess localAndroidAppProcess = (AndroidAppProcess)((Iterator)localObject2).next();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new android/app/ActivityManager$RunningAppProcessInfo;
        localRunningAppProcessInfo.<init>(localAndroidAppProcess.c, localAndroidAppProcess.d, null);
        localRunningAppProcessInfo.uid = localAndroidAppProcess.b;
        ((List)localObject1).add(localRunningAppProcessInfo);
      }
      bool = false;
    }
    catch (Exception paramString) {}
    break label106;
    label95:
    boolean bool;
    label97:
    return bool;
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      label106:
      if (!((Iterator)localObject1).hasNext()) {
        break label95;
      }
      if (!paramString.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).processName)) {
        break;
      }
      bool = true;
      break label97;
      label139:
      localObject1 = ((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningAppProcesses();
    }
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    com.lantern.wifilocating.push.h.b localb = com.lantern.wifilocating.push.h.b.a(paramJSONObject);
    Context localContext = com.lantern.wifilocating.push.c.a();
    Object localObject = localb.G;
    int j;
    int i;
    label50:
    boolean bool1;
    boolean bool2;
    boolean bool3;
    label101:
    int k;
    if ((localObject != null) && (localObject.length > 0))
    {
      j = localObject.length;
      i = 0;
      if (i < j) {
        if (localObject[i] == 1)
        {
          i = 1;
          bool1 = i.d(localContext);
          bool2 = i.e(localContext);
          bool3 = com.lantern.wifilocating.push.util.j.l(localContext);
          if ((i == 0) || (!bool3) || (((!bool1) || (!bool2)) && (localb.K != 1))) {
            break label219;
          }
          j = 1;
          k = com.lantern.wifilocating.push.util.a.a(localb.b, localb.a);
          if (j != 0) {
            break label296;
          }
          paramJSONObject = new com.lantern.wifilocating.push.a.b.a();
          paramJSONObject.a(localb.b);
          paramJSONObject.b(localb.a);
          paramJSONObject.c(localb.c);
          paramJSONObject.c(localb.H);
          paramJSONObject.d(2);
          paramJSONObject.f(localb.I);
          if (i != 0) {
            break label224;
          }
          paramJSONObject.e(2);
          com.lantern.wifilocating.push.f.a.a("012003", paramJSONObject.a(), localb.I, localb.L);
        }
      }
    }
    for (;;)
    {
      return;
      i++;
      break;
      i = 0;
      break label50;
      label219:
      j = 0;
      break label101;
      label224:
      if (!bool3)
      {
        paramJSONObject.e(6);
        com.lantern.wifilocating.push.f.a.a("012003", paramJSONObject.a(), localb.I, localb.L);
      }
      else if ((!bool1) || (!bool2))
      {
        paramJSONObject.e(5);
        com.lantern.wifilocating.push.f.a.a("012003", paramJSONObject.a(), localb.I, localb.L);
        continue;
        label296:
        if (!TextUtils.isEmpty(localb.E)) {
          if (!a(localb.E)) {
            i = 0;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label575;
          }
          paramJSONObject = new com.lantern.wifilocating.push.a.b.a();
          paramJSONObject.a(localb.b);
          paramJSONObject.b(localb.a);
          paramJSONObject.c(localb.c);
          paramJSONObject.c(localb.H);
          paramJSONObject.d(2);
          paramJSONObject.e(2);
          paramJSONObject.f(localb.I);
          com.lantern.wifilocating.push.f.a.a("012003", paramJSONObject.a(), localb.I, localb.L);
          break;
          if (b(localb.E))
          {
            i = 0;
          }
          else
          {
            if (localb.C == 2)
            {
              localObject = ((ConnectivityManager)com.lantern.wifilocating.push.c.a().getSystemService("connectivity")).getNetworkInfo(1);
              if (localObject == null) {}
              for (bool1 = false;; bool1 = ((NetworkInfo)localObject).isConnected())
              {
                if (bool1) {
                  break label481;
                }
                i = 0;
                break;
              }
            }
            label481:
            if (localb.p != 2)
            {
              if ((localb.p != 3) || (!a(localb.s))) {
                break label550;
              }
              if (localb.v == 2)
              {
                i = 0;
                continue;
              }
              if (localb.v != 1) {
                break label550;
              }
              localb.p = 1;
              com.lantern.wifilocating.push.util.b.c("App already installed,set action to open app");
            }
            label550:
            while ((localb.p != 1) || (a(localb.s)))
            {
              i = 1;
              break;
            }
            i = 0;
          }
        }
        label575:
        if (localb.d == 2) {
          localObject = b(localb, k);
        }
        for (;;)
        {
          if (localObject == null) {
            break label727;
          }
          if (!TextUtils.isEmpty(localb.o)) {
            h.a(localb.o);
          }
          if (localb.B != 1) {
            break label729;
          }
          b(localContext, k, (Notification)localObject, localb, paramJSONObject);
          break;
          if (localb.F == 0) {
            localObject = a(localb, k);
          } else if ((localb.F == 1) || (localb.F == 4)) {
            localObject = a(localb, k, false);
          } else if ((localb.F == 2) || (localb.F == 3)) {
            localObject = a(localb, k, true);
          } else {
            localObject = null;
          }
        }
        label727:
        continue;
        label729:
        if (localb.B == 2) {
          if (((PowerManager)localContext.getSystemService("power")).isScreenOn())
          {
            b(localContext, k, (Notification)localObject, localb, paramJSONObject);
          }
          else
          {
            paramJSONObject = new a(localContext, k, (Notification)localObject, localb, paramJSONObject);
            com.lantern.wifilocating.push.f.j.a().a(paramJSONObject);
          }
        }
      }
    }
  }
  
  private final class a
    implements Runnable
  {
    private Context b;
    private Notification c;
    private int d;
    private com.lantern.wifilocating.push.h.b e;
    private JSONObject f;
    
    public a(Context paramContext, int paramInt, Notification paramNotification, com.lantern.wifilocating.push.h.b paramb, JSONObject paramJSONObject)
    {
      this.b = paramContext;
      this.c = paramNotification;
      this.d = paramInt;
      this.e = paramb;
      this.f = paramJSONObject;
    }
    
    public final void run()
    {
      b.a(this.b, this.d, this.c, this.e, this.f);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */