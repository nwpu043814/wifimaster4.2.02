package com.lantern.auth.utils;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.a;
import com.bluefay.b.d;
import com.bluefay.b.d.a;
import java.util.Map;
import java.util.concurrent.Executors;

public final class f
  extends AsyncTask<Map<String, String>, Integer, String>
{
  private a a;
  private String b;
  private int c = 2;
  private int d = 0;
  private String e = "";
  private d.a f = new g(this);
  
  private f(a parama, String paramString)
  {
    this.b = paramString;
    this.a = parama;
  }
  
  public static f a(Map<String, String> paramMap, a parama, String paramString)
  {
    parama = new f(parama, paramString);
    parama.executeOnExecutor(Executors.newSingleThreadExecutor(), new Map[] { paramMap });
    return parama;
  }
  
  private String a(Map<String, String> paramMap)
  {
    this.d += 1;
    Object localObject = new d(this.b);
    ((d)localObject).a(5000, 5000);
    ((d)localObject).a(this.f);
    String str = ((d)localObject).b(paramMap);
    localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = str;
      if (this.d < this.c) {
        localObject = a(paramMap);
      }
    }
    return (String)localObject;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */