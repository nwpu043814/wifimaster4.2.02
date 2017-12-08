package com.lantern.wifilocating.push.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.j;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  private static final class a
    extends Thread
  {
    String a;
    String b;
    
    public a(String paramString)
    {
      this.a = paramString;
    }
    
    private String a(URLConnection paramURLConnection)
    {
      int i = 0;
      Object localObject = paramURLConnection.getHeaderField(i);
      if (localObject != null) {
        if ("Content-Disposition".equalsIgnoreCase(paramURLConnection.getHeaderFieldKey(i)))
        {
          localObject = Pattern.compile(".*filename=(.*)").matcher((CharSequence)localObject);
          if (((Matcher)localObject).find())
          {
            paramURLConnection = new String(((Matcher)localObject).group(1).getBytes("iso-8859-1"), "utf-8").replaceAll("\"", "").replace("'", "").trim();
            h.b("-----found file name " + paramURLConnection + " from Content-Disposition");
          }
        }
      }
      for (;;)
      {
        return paramURLConnection;
        i++;
        break;
        paramURLConnection = paramURLConnection.getURL().toString();
        h.b("final url:" + paramURLConnection);
        if (!this.a.equals(paramURLConnection))
        {
          localObject = paramURLConnection.substring(paramURLConnection.lastIndexOf('/') + 1);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            i = ((String)localObject).indexOf("?");
            paramURLConnection = (URLConnection)localObject;
            if (i != -1) {
              paramURLConnection = ((String)localObject).substring(0, i);
            }
            localObject = paramURLConnection.trim();
            paramURLConnection = (URLConnection)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              continue;
            }
          }
        }
        paramURLConnection = URLDecoder.decode(this.a, "utf-8");
        localObject = paramURLConnection.substring(paramURLConnection.lastIndexOf('/') + 1);
        if ((localObject == null) || ("".equals(((String)localObject).trim())))
        {
          paramURLConnection = UUID.randomUUID().toString();
          h.b("-----random file name " + paramURLConnection);
        }
        else
        {
          i = ((String)localObject).indexOf("?");
          paramURLConnection = (URLConnection)localObject;
          if (i != -1) {
            paramURLConnection = ((String)localObject).substring(0, i);
          }
          localObject = paramURLConnection.trim();
          h.b("-----found file name " + (String)localObject + " from url " + this.a);
          paramURLConnection = (URLConnection)localObject;
          if (((String)localObject).equals(""))
          {
            h.b("-----file name \"" + (String)localObject + "\" is invalidate,do random UUID----");
            paramURLConnection = UUID.randomUUID().toString();
            h.b("-----random file name " + paramURLConnection);
          }
        }
      }
    }
    
    private boolean a()
    {
      bool2 = false;
      for (;;)
      {
        try
        {
          if ("mounted".equals(Environment.getExternalStorageState())) {
            continue;
          }
          bool1 = bool2;
        }
        catch (Throwable localThrowable)
        {
          Object localObject2;
          Object localObject1;
          Object localObject3;
          StringBuilder localStringBuilder;
          int j;
          int i;
          h.a(localThrowable);
          boolean bool1 = bool2;
          continue;
          ((OutputStream)localObject3).flush();
          ((OutputStream)localObject3).close();
          ((InputStream)localObject2).close();
          bool1 = true;
          continue;
        }
        return bool1;
        localObject2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        bool1 = bool2;
        if (localObject2 != null)
        {
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
          localObject1 = new java/net/URL;
          ((URL)localObject1).<init>(this.a);
          localObject1 = ((URL)localObject1).openConnection();
          ((URLConnection)localObject1).setConnectTimeout(5000);
          ((URLConnection)localObject1).setReadTimeout(5000);
          ((URLConnection)localObject1).connect();
          localObject3 = a((URLConnection)localObject1);
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          this.b = (localObject2 + "/" + (String)localObject3);
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("appPath:");
          h.b(this.b);
          localObject2 = new java/io/File;
          ((File)localObject2).<init>(this.b);
          if (!((File)localObject2).exists()) {
            continue;
          }
          if (c.a().getPackageManager().getPackageArchiveInfo(this.b, 0) == null) {
            continue;
          }
          bool1 = true;
        }
      }
      ((File)localObject2).delete();
      localObject3 = ((URLConnection)localObject1).getInputStream();
      localObject2 = new java/io/BufferedInputStream;
      ((BufferedInputStream)localObject2).<init>((InputStream)localObject3);
      localObject3 = new java/io/FileOutputStream;
      ((FileOutputStream)localObject3).<init>(this.b);
      j = ((URLConnection)localObject1).getContentLength();
      localObject1 = new byte['က'];
      i = 0;
      for (;;)
      {
        int k = ((InputStream)localObject2).read((byte[])localObject1);
        if (k == -1) {
          break;
        }
        i += k;
        if (i * 100 / j % 5 == 0)
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("Download progress:");
          h.b(i * 100 / j + "%");
        }
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("Download progress:");
        h.b(i + "/" + j);
        ((OutputStream)localObject3).write((byte[])localObject1, 0, k);
      }
    }
    
    public final void run()
    {
      if (a()) {}
      try
      {
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        File localFile = new java/io/File;
        localFile.<init>(this.b);
        localIntent.setDataAndType(Uri.fromFile(localFile), "application/vnd.android.package-archive");
        j.a(c.a(), localIntent, 0);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/i/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */