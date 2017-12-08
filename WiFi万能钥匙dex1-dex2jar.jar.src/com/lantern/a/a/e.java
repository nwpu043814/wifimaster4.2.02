package com.lantern.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import com.lantern.core.d.b.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static volatile e f;
  public boolean a = false;
  public boolean b = false;
  private final String c = "data_channel";
  private final String d = "origin_data_loop_1";
  private final String e = "showd_images";
  private Context g = com.lantern.core.c.getApplication();
  private c h;
  private ArrayList<a> i;
  private ArrayList<a> j = new ArrayList();
  private String k = "";
  private String l;
  private boolean m;
  private boolean n;
  private boolean o = false;
  private boolean p = true;
  private com.bluefay.b.a q;
  private com.bluefay.b.a r = new f(this);
  private com.bluefay.b.a s = new i(this);
  
  private e()
  {
    com.bluefay.b.h.a("start loadPref", new Object[0]);
    SharedPreferences localSharedPreferences = g();
    if (localSharedPreferences != null)
    {
      this.l = localSharedPreferences.getString("data_channel", "");
      Object localObject = localSharedPreferences.getString("origin_data_loop_1", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = j.a((String)localObject);
        this.b = true;
        a((d)localObject, localSharedPreferences);
      }
    }
  }
  
  public static e a()
  {
    if (f == null) {}
    try
    {
      if (f == null)
      {
        e locale = new com/lantern/a/a/e;
        locale.<init>();
        f = locale;
      }
      return f;
    }
    finally {}
  }
  
  private void a(d paramd, SharedPreferences paramSharedPreferences)
  {
    this.i = paramd.a;
    this.m = paramd.b;
    this.k = paramd.c;
    com.bluefay.b.h.a("splash initdate 1111", new Object[0]);
    if ((this.i == null) || (this.i.size() == 0)) {}
    for (;;)
    {
      return;
      com.bluefay.b.h.a("splash initdate 2222", new Object[0]);
      if (paramSharedPreferences != null)
      {
        paramd = paramSharedPreferences.getString("showd_images", "");
        com.bluefay.b.h.a("splash initdate 3333 showedImageStr " + paramd, new Object[0]);
        paramSharedPreferences = j.b(paramd);
        if (paramSharedPreferences != null)
        {
          i1 = paramSharedPreferences.size();
          com.bluefay.b.h.a("splash initdate 4444 showImageSize " + i1, new Object[0]);
        }
        boolean bool = f();
        com.bluefay.b.h.a("splash initdate 555", new Object[0]);
        for (int i1 = 0; i1 < this.i.size(); i1++)
        {
          Iterator localIterator = ((a)this.i.get(i1)).a.iterator();
          while (localIterator.hasNext())
          {
            paramd = (c)localIterator.next();
            paramd.c(b(paramd));
            if ((!bool) && (paramSharedPreferences != null) && (!TextUtils.isEmpty(paramd.c())) && (paramSharedPreferences.contains(com.lantern.core.g.a(paramd.c()))))
            {
              com.bluefay.b.h.a("splash showed item " + paramd.c(), new Object[0]);
              paramd.a(true);
            }
          }
        }
      }
    }
  }
  
  private void a(ArrayList<a> paramArrayList)
  {
    String str = "";
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    int i1 = 0;
    if (i1 < paramArrayList.size())
    {
      a locala = (a)paramArrayList.get(i1);
      str = locala.d;
      if (str.startsWith("Wifi"))
      {
        localStringBuffer1.append(locala.b);
        if (!TextUtils.isEmpty(locala.e)) {
          localStringBuffer2.append(locala.e);
        }
        this.o = true;
        if (i1 != paramArrayList.size() - 1)
        {
          localStringBuffer1.append("_");
          localStringBuffer2.append("_");
        }
      }
      for (;;)
      {
        i1++;
        break;
        this.o = false;
      }
    }
    if (!com.bluefay.a.a.c(this.g)) {}
    for (;;)
    {
      return;
      com.lantern.analytics.a.e().onEvent("vad");
      new l(this.g, this.s, str, localStringBuffer1.toString(), localStringBuffer2.toString()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }
  }
  
  private static String b(c paramc)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/WifiMasterKey/splash/";
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      paramc = str + com.lantern.core.g.a(paramc.c());
      return paramc;
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramc);
        paramc = "";
      }
    }
  }
  
  private void c(c paramc)
  {
    if ((paramc == null) || (TextUtils.isEmpty(paramc.c()))) {
      com.bluefay.b.h.a("image url is null", new Object[0]);
    }
    for (;;)
    {
      return;
      com.lantern.analytics.a.e().onEvent("kpAD_dlpic");
      com.bluefay.b.h.a("-------splash config downloadImage start-------", new Object[0]);
      try
      {
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        String str3 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/WifiMasterKey/splash/";
        String str1 = com.lantern.core.g.a(paramc.c());
        String str2 = paramc.c();
        localObject = new com/lantern/a/a/h;
        ((h)localObject).<init>(this, paramc);
        com.lantern.core.d.b.a(str2, str3, str1, (b.a)localObject);
      }
      catch (Exception paramc)
      {
        com.bluefay.b.h.a("download image failed", paramc);
      }
    }
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.m)
    {
      Object localObject = j.b(g().getString("showd_images", ""));
      int i1;
      if (localObject != null)
      {
        i1 = ((List)localObject).size();
        long l1 = System.currentTimeMillis();
        for (int i2 = 0;; i2++)
        {
          i3 = i1;
          if (i2 >= this.i.size()) {
            break;
          }
          localObject = ((a)this.i.get(i2)).a.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (l1 > ((c)((Iterator)localObject).next()).e() * 1000L)
            {
              com.bluefay.b.h.a("cleanReuseShowedImage splash getCurrentSplashItem now > endtime ", new Object[0]);
              i1++;
            }
          }
        }
      }
      int i3 = 0;
      com.bluefay.b.h.a("splash  cleanReuseShowedImage showedImgSize " + i3 + "  mCandidateList.size() " + this.i.size(), new Object[0]);
      bool1 = bool2;
      if (this.i != null)
      {
        bool1 = bool2;
        if (i3 != 0)
        {
          bool1 = bool2;
          if (i3 == this.i.size())
          {
            localObject = g();
            if (localObject != null)
            {
              localObject = ((SharedPreferences)localObject).edit();
              ((SharedPreferences.Editor)localObject).remove("showd_images");
              ((SharedPreferences.Editor)localObject).apply();
            }
            for (i1 = 0; i1 < this.i.size(); i1++)
            {
              localObject = ((a)this.i.get(i1)).a.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((c)((Iterator)localObject).next()).a(false);
              }
            }
            com.bluefay.b.h.a("splash cleanShowedImage ", new Object[0]);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private SharedPreferences g()
  {
    return this.g.getSharedPreferences("splash_ad_data", 0);
  }
  
  public final c a(com.bluefay.b.a parama)
  {
    this.q = parama;
    if ((this.i == null) || (!com.bluefay.a.a.c(this.g))) {
      parama = null;
    }
    for (;;)
    {
      return parama;
      com.bluefay.b.h.a("splash getCurrentSplashItem candidatelist size " + this.i.size(), new Object[0]);
      f();
      long l1 = System.currentTimeMillis();
      this.p = true;
      com.bluefay.b.h.a("splash getCurrentSplashItem nowTime " + l1, new Object[0]);
      for (int i1 = 0; i1 < this.i.size(); i1++)
      {
        ArrayList localArrayList = new ArrayList();
        parama = (a)this.i.get(i1);
        int i2 = 0;
        if (i2 < parama.a.size())
        {
          c localc = (c)parama.a.get(i2);
          com.bluefay.b.h.a("splash getCurrentSplashItem  i= +" + i1 + "+startTime " + localc.d() + " endTime " + localc.e(), new Object[0]);
          if (!localc.a())
          {
            if ((l1 < localc.d() * 1000L) || (l1 >= localc.e() * 1000L)) {
              break label288;
            }
            com.bluefay.b.h.a("splash getCurrentSplashItem now < starttime ", new Object[0]);
            if (this.h == null) {
              this.h = localc;
            }
            localArrayList.add(localc);
            this.p = false;
          }
          for (;;)
          {
            i2++;
            break;
            label288:
            if (l1 < localc.e() * 1000L) {
              this.p = false;
            }
          }
        }
        if ((localArrayList.size() > 0) && (parama != null))
        {
          parama.a = localArrayList;
          this.j.add(parama);
        }
      }
      com.bluefay.b.h.a("mValidAdList start", new Object[0]);
      if ((this.h != null) && (this.j != null) && (this.j.size() > 0))
      {
        com.bluefay.b.h.a("mValidAdList =" + this.j.size(), new Object[0]);
        if (this.b) {
          a(this.j);
        }
        com.bluefay.b.h.a("splash getCurrentSplashItem  222222", new Object[0]);
        parama = this.h;
      }
      else
      {
        parama = null;
      }
    }
  }
  
  public final void a(c paramc)
  {
    int i1 = 0;
    if (i1 < this.i.size())
    {
      a locala = (a)this.i.get(i1);
      for (int i2 = 0;; i2++) {
        if (i2 < locala.a.size())
        {
          if (paramc.equals(locala.a.get(i2))) {
            ((c)locala.a.get(i2)).a(true);
          }
        }
        else
        {
          i1++;
          break;
        }
      }
    }
    if (!this.m)
    {
      paramc = g();
      if (paramc != null)
      {
        paramc = j.b(paramc.getString("showd_images", ""));
        if ((paramc != null) && (paramc.size() == this.i.size())) {
          e();
        }
      }
    }
  }
  
  public final void a(String paramString)
  {
    if (!com.bluefay.a.a.c(this.g)) {
      com.bluefay.b.h.a("network is not connected", new Object[0]);
    }
    for (;;)
    {
      return;
      new g(this, paramString).start();
    }
  }
  
  public final void b(String paramString)
  {
    com.bluefay.b.h.a("splash add showedImage111", new Object[0]);
    if (TextUtils.isEmpty(paramString)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = g();
    } while (localSharedPreferences == null);
    com.bluefay.b.h.a("splash add showedImage222", new Object[0]);
    Object localObject = localSharedPreferences.getString("showd_images", "");
    if ("".equals(localObject)) {}
    for (;;)
    {
      com.bluefay.b.h.a("splash add showedImage333 str " + paramString, new Object[0]);
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putString("showd_images", paramString);
      ((SharedPreferences.Editor)localObject).apply();
      break;
      if (!((String)localObject).contains(paramString)) {
        paramString = (String)localObject + ";" + paramString;
      } else {
        paramString = (String)localObject;
      }
    }
  }
  
  public final boolean b()
  {
    boolean bool2 = false;
    boolean bool1;
    if (!com.bluefay.a.a.c(this.g)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (this.p)
      {
        com.bluefay.b.h.a("no can use ad", new Object[0]);
        e();
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        if (this.h != null) {
          if ("1".equals(this.k))
          {
            bool1 = bool2;
            if (this.a) {}
          }
          else
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.h.c()))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(this.h.j()))
              {
                try
                {
                  File localFile = new java/io/File;
                  localFile.<init>(this.h.j());
                  if (localFile.exists()) {
                    break label162;
                  }
                  com.bluefay.b.h.b("local splash image has not exists");
                  c(this.h);
                  bool1 = bool2;
                }
                catch (Exception localException)
                {
                  com.bluefay.b.h.a(localException);
                  c(this.h);
                  bool1 = bool2;
                }
                continue;
                label162:
                String str = this.h.h();
                if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase(com.lantern.core.g.a(localException))))
                {
                  com.bluefay.b.h.b("local splash image has been changed.(md5 verify failed)");
                  c(this.h);
                  bool1 = bool2;
                }
                else
                {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean c()
  {
    return this.n;
  }
  
  public final void d()
  {
    this.n = true;
  }
  
  public final void e()
  {
    if (!com.bluefay.a.a.c(this.g)) {}
    for (;;)
    {
      return;
      com.lantern.analytics.a.e().onEvent("uad");
      new b(this.g, this.r).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */