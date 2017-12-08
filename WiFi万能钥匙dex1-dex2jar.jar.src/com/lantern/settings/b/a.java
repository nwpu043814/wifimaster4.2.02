package com.lantern.settings.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bluefay.b.d;
import java.io.File;

public final class a
{
  public static void a(Handler paramHandler, String paramString1, String paramString2, com.bluefay.b.a parama)
  {
    new Thread(new c(paramHandler, paramString1, paramString2, parama)).start();
  }
  
  public static void a(Handler paramHandler, String paramString, boolean paramBoolean, com.bluefay.b.a parama)
  {
    new Thread(new a(paramHandler, paramString, paramBoolean, parama)).start();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    new Thread(new b(paramString1, paramString2)).start();
  }
  
  private static final class a
    implements Runnable
  {
    private Handler a;
    private String b;
    private com.bluefay.b.a c;
    private int d;
    private Bitmap e;
    private boolean f;
    
    public a(Handler paramHandler, String paramString, boolean paramBoolean, com.bluefay.b.a parama)
    {
      this.a = paramHandler;
      this.b = paramString;
      this.c = parama;
      this.f = paramBoolean;
    }
    
    public final void run()
    {
      if ((TextUtils.isEmpty(this.b)) || (!URLUtil.isNetworkUrl(this.b)))
      {
        this.d = 0;
        return;
      }
      File localFile = a.a(this.b);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localFile.exists())
      {
        localObject1 = localObject2;
        if (localFile.isFile())
        {
          localObject1 = localObject2;
          if (localFile.canRead()) {
            localObject1 = com.bluefay.b.b.a(localFile.getAbsolutePath());
          }
        }
      }
      if ((!this.f) && ((localObject1 == null) || (localObject1.length == 0))) {
        localObject1 = d.a(this.b);
      }
      for (int i = 1;; i = 0)
      {
        if ((localObject1 == null) || (localObject1.length == 0)) {
          this.d = 0;
        }
        for (;;)
        {
          if ((this.c == null) || (this.a == null)) {
            break label196;
          }
          this.a.post(new b(this));
          break;
          try
          {
            this.e = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
            if (this.e != null) {
              this.d = 1;
            }
            if (i != 0) {
              com.bluefay.b.b.a(localFile.getAbsolutePath(), (byte[])localObject1);
            }
          }
          catch (Throwable localThrowable)
          {
            this.d = 0;
          }
        }
        label196:
        break;
      }
    }
  }
  
  private static final class b
    implements Runnable
  {
    private String a;
    private String b;
    
    public b(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public final void run()
    {
      if ((TextUtils.isEmpty(this.a)) || (!URLUtil.isNetworkUrl(this.a))) {}
      for (;;)
      {
        return;
        byte[] arrayOfByte = com.bluefay.b.b.a(this.b);
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
          try
          {
            com.bluefay.b.b.a(a.a(this.a).getAbsolutePath(), arrayOfByte);
          }
          catch (Throwable localThrowable) {}
        }
      }
    }
  }
  
  private static final class c
    implements Runnable
  {
    private Handler a;
    private String b;
    private String c;
    private com.bluefay.b.a d;
    private int e;
    
    public c(Handler paramHandler, String paramString1, String paramString2, com.bluefay.b.a parama)
    {
      this.a = paramHandler;
      this.b = paramString1;
      this.d = parama;
      this.c = paramString2;
    }
    
    public final void run()
    {
      int i = 1;
      if ((TextUtils.isEmpty(this.b)) || (!URLUtil.isNetworkUrl(this.b)))
      {
        this.e = 0;
        return;
      }
      File localFile = a.a(this.b);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localFile.exists())
      {
        localObject1 = localObject2;
        if (localFile.isFile())
        {
          localObject1 = localObject2;
          if (localFile.canRead()) {
            localObject1 = com.bluefay.b.b.a(localFile.getAbsolutePath());
          }
        }
      }
      if ((localObject1 == null) || (localObject1.length == 0)) {
        localObject1 = d.a(this.b);
      }
      for (;;)
      {
        if ((localObject1 == null) || (localObject1.length == 0)) {
          this.e = 0;
        }
        for (;;)
        {
          if ((this.d == null) || (this.a == null)) {
            break label180;
          }
          this.a.post(new c(this));
          break;
          if (i != 0) {}
          try
          {
            com.bluefay.b.b.a(localFile.getAbsolutePath(), (byte[])localObject1);
            com.bluefay.b.b.a(this.c, (byte[])localObject1);
            this.e = 1;
          }
          catch (Throwable localThrowable)
          {
            this.e = 0;
          }
        }
        label180:
        break;
        i = 0;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */