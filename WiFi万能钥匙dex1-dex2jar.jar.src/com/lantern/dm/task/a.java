package com.lantern.dm.task;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.net.Uri;
import android.util.Pair;
import com.bluefay.b.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class a
{
  public String A;
  public String B;
  public boolean C;
  public String D;
  public int E;
  public int F;
  public volatile boolean G;
  private List<Pair<String, String>> H = new ArrayList();
  private i I;
  private Context J;
  public long a;
  public String b;
  public boolean c;
  public String d;
  public String e;
  public String f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public long m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public long t;
  public long u;
  public String v;
  public boolean w;
  public boolean x;
  public int y;
  public boolean z;
  
  private a(Context paramContext, i parami)
  {
    this.J = paramContext;
    this.I = parami;
    this.F = e.a.nextInt(1001);
  }
  
  public final long a(long paramLong)
  {
    if (this.k == 0) {}
    for (;;)
    {
      return paramLong;
      if (this.l > 0) {
        paramLong = this.m + this.l;
      } else {
        paramLong = this.m + (this.F + 1000) * 30 * (1 << this.k - 1);
      }
    }
  }
  
  public final Collection<Pair<String, String>> a()
  {
    return Collections.unmodifiableList(this.H);
  }
  
  public final void b()
  {
    if (this.n == null) {
      return;
    }
    Intent localIntent;
    if (this.x)
    {
      localIntent = new Intent("android.intent.action.DOWNLOAD_COMPLETE");
      localIntent.setPackage(this.n);
      localIntent.putExtra("extra_download_id", this.a);
    }
    for (;;)
    {
      h.a("DownloadInfo", new Object[] { this.n });
      this.I.a(localIntent);
      break;
      if (this.o == null) {
        break;
      }
      localIntent = new Intent("android.intent.action.DOWNLOAD_COMPLETED");
      localIntent.setClassName(this.n, this.o);
      if (this.p != null) {
        localIntent.putExtra("notificationextras", this.p);
      }
      localIntent.setData(ContentUris.withAppendedId(com.lantern.core.model.a.a, this.a));
    }
  }
  
  public final void b(long paramLong)
  {
    int i2 = 1;
    for (;;)
    {
      try
      {
        if ((!this.G) && (this.i != 1)) {
          i1 = i2;
        }
        switch (this.j)
        {
        default: 
          i1 = 0;
        case 0: 
        case 190: 
        case 192: 
          if (i1 != 0) {
            continue;
          }
          return;
        case 195: 
        case 196: 
          i1 = i2;
          if (c() == 1) {
            continue;
          }
          i1 = 0;
          break;
        }
        int i1 = i2;
        if (a(paramLong) <= paramLong) {
          continue;
        }
        i1 = 0;
        continue;
        if (this.G) {
          continue;
        }
        if (this.j == 192) {
          break label206;
        }
      }
      finally {}
      this.j = 192;
      Object localObject2 = new android/content/ContentValues;
      ((ContentValues)localObject2).<init>();
      ((ContentValues)localObject2).put("status", Integer.valueOf(this.j));
      this.J.getContentResolver().update(d(), (ContentValues)localObject2, null, null);
      label206:
      localObject2 = new com/lantern/dm/task/d;
      ((d)localObject2).<init>(this.J, this.I, this);
      this.G = true;
      this.I.a((Thread)localObject2);
    }
  }
  
  public final int c()
  {
    int i1 = 2;
    Object localObject = this.I.b();
    if (localObject == null) {}
    for (;;)
    {
      return i1;
      if (this.x) {}
      for (boolean bool = this.z;; bool = true)
      {
        if ((bool) || (!this.I.c())) {
          break label58;
        }
        i1 = 5;
        break;
      }
      label58:
      int i2 = ((Integer)localObject).intValue();
      if (this.x)
      {
        switch (i2)
        {
        }
        for (i1 = 0;; i1 = 1)
        {
          if ((i1 & this.y) != 0) {
            break label118;
          }
          i1 = 6;
          break;
        }
      }
      label118:
      if ((this.t > 0L) && (i2 != 1))
      {
        localObject = this.I.d();
        if ((localObject != null) && (this.t > ((Long)localObject).longValue()))
        {
          i1 = 3;
          continue;
        }
        if (this.E == 0)
        {
          localObject = this.I.e();
          if ((localObject != null) && (this.t > ((Long)localObject).longValue()))
          {
            i1 = 4;
            continue;
          }
        }
      }
      i1 = 1;
    }
  }
  
  public final Uri d()
  {
    return ContentUris.withAppendedId(com.lantern.core.model.a.b, this.a);
  }
  
  public static final class a
  {
    private Cursor a;
    private CharArrayBuffer b;
    private CharArrayBuffer c;
    
    public a(Cursor paramCursor)
    {
      this.a = paramCursor;
    }
    
    private Integer a(String paramString)
    {
      return Integer.valueOf(this.a.getInt(this.a.getColumnIndexOrThrow(paramString)));
    }
    
    private String a(String paramString1, String paramString2)
    {
      int i = this.a.getColumnIndexOrThrow(paramString2);
      if (paramString1 == null) {}
      int j;
      for (paramString2 = this.a.getString(i);; paramString2 = new String(this.c.data, 0, j))
      {
        return paramString2;
        if (this.c == null) {
          this.c = new CharArrayBuffer(128);
        }
        this.a.copyStringToBuffer(i, this.c);
        j = this.c.sizeCopied;
        if (j == paramString1.length()) {
          break;
        }
      }
      if ((this.b == null) || (this.b.sizeCopied < j)) {
        this.b = new CharArrayBuffer(j);
      }
      char[] arrayOfChar1 = this.b.data;
      char[] arrayOfChar2 = this.c.data;
      paramString1.getChars(0, j, arrayOfChar1, 0);
      for (i = j - 1;; i--)
      {
        paramString2 = paramString1;
        if (i < 0) {
          break;
        }
        if (arrayOfChar1[i] != arrayOfChar2[i])
        {
          paramString2 = new String(arrayOfChar2, 0, j);
          break;
        }
      }
    }
    
    private Long b(String paramString)
    {
      return Long.valueOf(this.a.getLong(this.a.getColumnIndexOrThrow(paramString)));
    }
    
    public final a a(Context paramContext, i parami)
    {
      paramContext = new a(paramContext, parami, (byte)0);
      a(paramContext);
      return paramContext;
    }
    
    public final void a(a parama)
    {
      boolean bool2 = true;
      parama.a = b("_id").longValue();
      parama.b = a(parama.b, "uri");
      if (a("no_integrity").intValue() == 1)
      {
        bool1 = true;
        parama.c = bool1;
        parama.d = a(parama.d, "hint");
        parama.e = a(parama.e, "_data");
        parama.f = a(parama.f, "mimetype");
        parama.g = a("destination").intValue();
        parama.h = a("visibility").intValue();
        parama.j = a("status").intValue();
        parama.k = a("numfailed").intValue();
        parama.l = (a("method").intValue() & 0xFFFFFFF);
        parama.m = b("lastmod").longValue();
        parama.n = a(parama.n, "notificationpackage");
        parama.o = a(parama.o, "notificationclass");
        parama.p = a(parama.p, "notificationextras");
        parama.q = a(parama.q, "cookiedata");
        parama.r = a(parama.r, "useragent");
        parama.s = a(parama.s, "referer");
        parama.t = b("total_bytes").longValue();
        parama.u = b("current_bytes").longValue();
        parama.v = a(parama.v, "etag");
        if (a("deleted").intValue() != 1) {
          break label465;
        }
        bool1 = true;
        label311:
        parama.w = bool1;
        if (a("is_public_api").intValue() == 0) {
          break label470;
        }
        bool1 = true;
        label330:
        parama.x = bool1;
        parama.y = a("allowed_network_types").intValue();
        if (a("allow_roaming").intValue() == 0) {
          break label475;
        }
        bool1 = true;
        label362:
        parama.z = bool1;
        parama.A = a(parama.A, "title");
        parama.B = a(parama.B, "icon");
        if (a("is_visible_in_downloads_ui").intValue() == 0) {
          break label480;
        }
      }
      label465:
      label470:
      label475:
      label480:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        parama.C = bool1;
        parama.D = a(parama.D, "description");
        parama.E = a("bypass_recommended_size_limit").intValue();
        try
        {
          parama.i = a("control").intValue();
          return;
        }
        finally {}
        bool1 = false;
        break;
        bool1 = false;
        break label311;
        bool1 = false;
        break label330;
        bool1 = false;
        break label362;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */