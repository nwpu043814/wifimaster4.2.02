package com.lantern.c;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Window;
import bluefay.app.k.a;
import com.bluefay.b.h;
import com.lantern.core.R.string;
import com.lantern.core.d.a.b;
import com.lantern.core.d.a.c;
import com.lantern.core.p;
import java.io.File;
import java.security.MessageDigest;
import java.util.Locale;

public class a
{
  private static a f;
  private static long i = 7200000L;
  private Context a;
  private String b;
  private long c = 0L;
  private com.lantern.core.d.a d;
  private com.lantern.c.a.a e;
  private boolean g;
  private long h;
  private a j;
  private boolean k = false;
  private String l = null;
  private String m = null;
  private BroadcastReceiver n = new b(this);
  private com.bluefay.b.a o = new c(this);
  private DialogInterface.OnClickListener p = new d(this);
  private DialogInterface.OnClickListener q = new e(this);
  private DialogInterface.OnCancelListener r = new f(this);
  
  private a(Context paramContext)
  {
    this.a = paramContext;
    this.g = false;
    this.c = p.a(this.a, "sdk_upgrade", "upgrade_download_id", 0L);
    this.d = new com.lantern.core.d.a(this.a);
    this.a.registerReceiver(this.n, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    this.b = this.a.getString(R.string.upgrade_dialog_title);
  }
  
  private long a(Uri paramUri, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a.c localc = new a.c(paramUri);
    if (paramBoolean2) {
      localc.a();
    }
    localc.b();
    localc.a(Environment.DIRECTORY_DOWNLOADS, paramString);
    localc.a(paramBoolean1);
    localc.b(false);
    long l1 = this.d.a(localc);
    h.b("Start download uri:%s id:%s", new Object[] { paramUri, Long.valueOf(this.c) });
    return l1;
  }
  
  public static a a(Context paramContext)
  {
    if (f == null) {}
    try
    {
      if (f == null)
      {
        a locala = new com/lantern/c/a;
        locala.<init>(paramContext.getApplicationContext());
        f = locala;
      }
      return f;
    }
    finally {}
  }
  
  private String a(long paramLong)
  {
    h.a("queryDownloadStatus:" + paramLong);
    Object localObject = new a.b();
    ((a.b)localObject).a(new long[] { paramLong });
    Cursor localCursor = this.d.a((a.b)localObject);
    String str = "";
    localObject = str;
    if (localCursor != null)
    {
      localObject = str;
      if (localCursor.moveToFirst())
      {
        int i1 = localCursor.getInt(localCursor.getColumnIndex("status"));
        localObject = localCursor.getString(localCursor.getColumnIndex("title"));
        switch (i1)
        {
        default: 
          localObject = str;
        }
      }
    }
    for (;;)
    {
      return (String)localObject;
      h.a("STATUS_PAUSED", new Object[0]);
      localObject = "paused";
      continue;
      h.a("STATUS_PENDING", new Object[0]);
      localObject = "pending";
      continue;
      h.a("STATUS_RUNNING", new Object[0]);
      localObject = "running";
      continue;
      h.a("STATUS_SUCCESSFUL", new Object[0]);
      localObject = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), (String)localObject);
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).getAbsolutePath();
      }
      else
      {
        localObject = "failed";
        continue;
        h.a("STATUS_FAILED", new Object[0]);
        localObject = "failed";
      }
    }
  }
  
  private static String a(PackageInfo paramPackageInfo)
  {
    try
    {
      Object localObject = paramPackageInfo.signatures;
      paramPackageInfo = MessageDigest.getInstance("SHA-1");
      int i2 = localObject.length;
      for (int i1 = 0; i1 < i2; i1++) {
        paramPackageInfo.update(localObject[i1].toByteArray());
      }
      byte[] arrayOfByte = paramPackageInfo.digest();
      localObject = "";
      i1 = 0;
      if (i1 < arrayOfByte.length)
      {
        paramPackageInfo = Integer.toHexString(arrayOfByte[i1] & 0xFF);
        StringBuilder localStringBuilder;
        if (paramPackageInfo.length() == 1)
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
        }
        for (paramPackageInfo = (String)localObject + "0" + paramPackageInfo;; paramPackageInfo = (String)localObject + paramPackageInfo)
        {
          localObject = paramPackageInfo;
          if (i1 < arrayOfByte.length - 1)
          {
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            localObject = paramPackageInfo + ":";
          }
          i1++;
          break;
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
        }
      }
      paramPackageInfo = ((String)localObject).toUpperCase(Locale.getDefault());
    }
    catch (Exception paramPackageInfo)
    {
      for (;;)
      {
        h.a(paramPackageInfo);
        paramPackageInfo = "";
      }
    }
    return paramPackageInfo;
  }
  
  private void a(Uri paramUri, String paramString)
  {
    if (this.c == 0L)
    {
      this.c = a(paramUri, paramString, true, false);
      com.lantern.analytics.a.e().onEvent("upd1s");
      b(this.c);
    }
    for (;;)
    {
      return;
      String str = a(this.c);
      if ((str.startsWith("/")) && (a(this.a, str)))
      {
        a(str);
      }
      else
      {
        if (str.equals("failed"))
        {
          this.d.a(new long[] { this.c });
          this.c = 0L;
          break;
        }
        h.a("status is:" + str);
        this.d.c(new long[] { this.c });
      }
    }
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    localIntent.setDataAndType(Uri.parse("file://" + paramString), "application/vnd.android.package-archive");
    this.a.startActivity(localIntent);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramString = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 64);
    boolean bool1;
    if (paramString == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      String str = a(paramString);
      h.a("the apk signatures is:%s", new Object[] { str });
      paramString = paramContext.getPackageName();
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = null;
      try
      {
        paramString = localPackageManager.getPackageInfo(paramString, 64);
        paramContext = paramString;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        for (;;) {}
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        paramContext = a(paramContext);
        h.a("the self signatures is:%s", new Object[] { paramContext });
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramContext))
        {
          bool1 = bool2;
          if (TextUtils.equals(paramContext, str)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void b(long paramLong)
  {
    p.b(this.a, "sdk_upgrade", "upgrade_download_id", paramLong);
  }
  
  public final void a()
  {
    Object localObject = a(this.c);
    if (((String)localObject).startsWith("/"))
    {
      b(0L);
      if (a(this.a, (String)localObject))
      {
        a((String)localObject);
        com.lantern.analytics.a.e().onEvent("upd1f");
      }
    }
    for (;;)
    {
      return;
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        ((File)localObject).delete();
        continue;
        if (((String)localObject).equals("failed"))
        {
          this.d.a(new long[] { this.c });
          this.c = 0L;
          b(0L);
        }
        else
        {
          h.a("status is:" + (String)localObject);
        }
      }
    }
  }
  
  public final void a(Context paramContext, com.lantern.c.a.a parama, String paramString1, String paramString2)
  {
    this.l = paramString1;
    this.m = paramString2;
    this.e = parama;
    if ((paramContext != null) && ((paramContext instanceof bluefay.app.b)) && (!((bluefay.app.b)paramContext).c()))
    {
      paramString1 = this.b;
      parama = parama.e;
      paramString2 = this.p;
      DialogInterface.OnClickListener localOnClickListener = this.q;
      paramContext = new k.a(paramContext);
      paramContext.a(paramString1);
      if ((parama != null) && (parama.length() > 0)) {
        paramContext.b(parama);
      }
      paramContext.a(17039370, paramString2);
      paramContext.b(17039360, localOnClickListener);
      paramContext.a(this.r);
      paramContext = paramContext.c();
      paramContext.setCanceledOnTouchOutside(false);
      paramContext.show();
      this.k = true;
    }
  }
  
  public final void a(com.lantern.c.a.a parama)
  {
    if (parama == null) {
      h.c("response is null");
    }
    for (;;)
    {
      return;
      if (parama.g == null)
      {
        h.c("response.mPath is null");
      }
      else
      {
        String str = null;
        if (parama.g.startsWith("market://")) {
          if (com.bluefay.a.b.a(this.a, "com.android.vending"))
          {
            parama = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.a.getPackageName()));
            parama.setPackage("com.android.vending");
            parama.setFlags(268435456);
            com.bluefay.a.e.a(this.a, parama);
            continue;
          }
        }
        for (str = "http://get.geakmobi.com/redirect/get_geakos/";; str = parama.g) {
          do
          {
            if (str != null) {
              break label187;
            }
            h.c("response.mPath is invalid:" + parama.g);
            break;
          } while ((!parama.g.startsWith("http://")) && (!parama.g.startsWith("https://")));
        }
        label187:
        File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        if (!localFile.exists())
        {
          com.bluefay.a.e.a(R.string.upgrade_phone_card_not_exist);
        }
        else
        {
          parama = String.format("%s-%s.apk", new Object[] { this.a.getPackageName(), parama.f });
          localFile = new File(localFile, parama);
          if ((localFile.exists()) && (a(this.a, localFile.getAbsolutePath())))
          {
            a(localFile.getAbsolutePath());
            com.lantern.analytics.a.e().onEvent("uphas1");
          }
          else
          {
            if (this.h != 0L)
            {
              this.d.a(new long[] { this.h });
              this.h = 0L;
              h.a("cancel background download", new Object[0]);
            }
            a(Uri.parse(str), parama);
          }
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean, com.bluefay.b.a parama)
  {
    label285:
    for (;;)
    {
      try
      {
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("update:");
        h.a(paramBoolean, new Object[0]);
        long l1 = p.a(this.a, "sdk_upgrade", "timestamp", 0L);
        if ((System.currentTimeMillis() - l1 > i) || (paramBoolean))
        {
          localObject = parama;
          if (this.g)
          {
            localObject = parama;
            if (!paramBoolean)
            {
              localObject = new com/lantern/c/a$a;
              ((a)localObject).<init>(this, parama);
              this.j = ((a)localObject);
              localObject = this.j;
            }
          }
          paramBoolean = com.bluefay.a.a.c(com.bluefay.d.a.getAppContext());
          parama = ((ConnectivityManager)com.bluefay.d.a.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
          if (parama != null)
          {
            int i2 = parama.getType();
            i1 = i2;
            if (i2 == 0) {
              i1 = parama.getSubtype() + 1000;
            }
            h.a("isNetworkConnected:%s network_type:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i1) });
            if ((!paramBoolean) || (i1 == -1)) {
              break label285;
            }
            String str = com.lantern.analytics.e.a.a(com.bluefay.d.a.getAppContext());
            parama = new java/lang/StringBuilder;
            parama.<init>("version_info:");
            h.a(str);
            if (str != null) {
              continue;
            }
            h.c("device_info id is null, can't update");
            ((com.bluefay.b.a)localObject).a(0, null, null);
            p.g(this.a);
          }
        }
        else
        {
          return;
        }
        int i1 = -1;
        continue;
        parama = new com/lantern/c/b/a;
        parama.<init>((com.bluefay.b.a)localObject);
        parama.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        continue;
        ((com.bluefay.b.a)localObject).a(11, null, null);
      }
      finally {}
    }
  }
  
  public final void b()
  {
    this.g = true;
  }
  
  public final void b(com.lantern.c.a.a parama)
  {
    this.e = parama;
    String str = this.b;
    parama = parama.e;
    DialogInterface.OnClickListener localOnClickListener1 = this.p;
    DialogInterface.OnClickListener localOnClickListener2 = this.q;
    k.a locala = new k.a(this.a);
    locala.a(str);
    if ((parama != null) && (parama.length() > 0)) {
      locala.b(parama);
    }
    locala.a(17039370, localOnClickListener1);
    locala.b(17039360, localOnClickListener2);
    parama = locala.c();
    parama.setCanceledOnTouchOutside(false);
    parama.getWindow().setType(2010);
    parama.show();
  }
  
  private static final class a
    implements com.bluefay.b.a
  {
    private a a;
    private com.bluefay.b.a b;
    private int c;
    private String d;
    private Object e;
    
    a(a parama, com.bluefay.b.a parama1)
    {
      this.a = parama;
      this.b = parama1;
    }
    
    public final void a()
    {
      if (this.b != null) {
        this.b.a(this.c, this.d, this.e);
      }
    }
    
    public final void a(int paramInt, String paramString, Object paramObject)
    {
      this.c = paramInt;
      this.d = paramString;
      this.e = paramObject;
      if (paramInt == 1) {}
      for (;;)
      {
        try
        {
          localFile1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
          str = a.e(this.a).getPackageName();
          locala = (com.lantern.c.a.a)paramObject;
          if (locala == null)
          {
            if (this.b != null) {
              this.b.a(paramInt, paramString, paramObject);
            }
            return;
          }
        }
        catch (Exception paramString)
        {
          File localFile1;
          String str;
          com.lantern.c.a.a locala;
          File localFile2;
          h.a("parse info failed", paramString);
          continue;
          if (locala.c) {
            continue;
          }
          if (this.b == null) {
            continue;
          }
          this.b.a(paramInt, paramString, paramObject);
          continue;
          h.a("need background download", new Object[0]);
          a.a(this.a, a.a(this.a, Uri.parse(locala.g), str));
          com.lantern.analytics.a.e().onEvent("upd0s");
          continue;
        }
        str = String.format("%s-%s.apk", new Object[] { str, locala.f });
        localFile2 = new java/io/File;
        localFile2.<init>(localFile1, str);
        if ((!localFile2.exists()) || (!a.a(a.e(this.a), localFile2.getAbsolutePath()))) {
          continue;
        }
        if (this.b != null) {
          this.b.a(paramInt, paramString, paramObject);
        }
        com.lantern.analytics.a.e().onEvent("uphas0");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */