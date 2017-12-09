package com.wifi.connect.plugin.magickey.d;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.c.a.a.a.c.c.a.a.a.a;
import com.c.a.a.a.c.c.a.a.a.a.a;
import com.c.a.a.a.c.c.a.a.a.a.b;
import com.c.a.a.a.c.c.a.a.a.a.b.a;
import com.c.a.a.a.c.c.a.a.b.a;
import com.c.a.a.a.c.c.a.a.b.a.b;
import com.lantern.core.WkSecretKeyNative;
import com.lantern.core.e;
import com.lantern.core.f;
import com.lantern.core.k;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import com.wifi.connect.plugin.magickey.b.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

//和老版本分析的等效关键类是这个,网络
public final class c
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private String b;
  private WkAccessPoint c;
  private ArrayList<WkAccessPoint> d;
  private boolean e;
  private boolean f;
  private String g = "";
  private String h;
  private String i;
  private b j;
  
  public c(String paramString1, WkAccessPoint paramWkAccessPoint, ArrayList<WkAccessPoint> paramArrayList, String paramString2, String paramString3, com.bluefay.b.a parama)
  {
    this.b = paramString1;
    this.c = paramWkAccessPoint;
    this.d = paramArrayList;
    this.a = parama;
    this.f = f.e();
    this.e = f.f();
    this.h = paramString2;
    this.i = paramString3;
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = 1;
    h.a("queryApPwdPB:" + paramBoolean1 + " " + paramBoolean2);
    int k;
    if (!com.lantern.core.c.getServer().a("00302002", paramBoolean1)) {
      if (paramBoolean2)
      {
        this.g = "refresh Error";
        h.c(this.g);
        k = 0;
      }
    }
    for (;;)
    {
      return k;
      this.g = "initDev Error";
      break;
      String str = com.lantern.core.c.getServer().v();
      com.bluefay.d.a.getAppContext();
      Object localObject = a(this.b, this.c, this.d, this.h, this.i);
      com.lantern.core.c.getServer();
      localObject = e.a(str, o.a("00302002", (byte[])localObject), 30000, 30000);
      if ((localObject == null) || (localObject.length == 0))
      {
        k = 10;
      }
      else
      {
        h.a(com.bluefay.b.c.a((byte[])localObject), new Object[0]);
        try
        {
          this.j = a((byte[])localObject, "00302002");
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          h.a(this.j, new Object[0]);
          k = m;
          if (paramBoolean1)
          {
            k = m;
            if (!paramBoolean2) {
              if (!this.j.d())
              {
                k = m;
                if (!this.j.e()) {}
              }
              else
              {
                com.lantern.core.c.getServer().b("00302002", this.j.b());
                k = a(true, true);
              }
            }
          }
        }
        catch (Exception localException)
        {
          h.a(localException);
          k = 30;
          this.j = null;
        }
      }
    }
  }
  
  private static b a(byte[] paramArrayOfByte, String paramString)
  {
    com.lantern.core.c.getServer();
    Object localObject = o.b(paramString, paramArrayOfByte);
    if (!((com.lantern.core.h.a)localObject).c())
    {
      paramArrayOfByte = new b();
      paramArrayOfByte.a(((com.lantern.core.h.a)localObject).a());
      paramArrayOfByte.b(((com.lantern.core.h.a)localObject).b());
    }
    for (;;)
    {
      return paramArrayOfByte;
      localObject = b.a.a(((com.lantern.core.h.a)localObject).g());
      paramArrayOfByte = new b();
      if (!TextUtils.isEmpty(((b.a)localObject).n())) {
        paramArrayOfByte.a = ((b.a)localObject).n();
      }
      if (!TextUtils.isEmpty(((b.a)localObject).o())) {}
      try
      {
        paramArrayOfByte.b = Long.parseLong(((b.a)localObject).o());
        if (TextUtils.isEmpty(((b.a)localObject).m())) {}
      }
      catch (Exception localException1)
      {
        try
        {
          paramArrayOfByte.c = Boolean.parseBoolean(((b.a)localObject).m());
          paramArrayOfByte.a("0");
          if (((b.a)localObject).l() != null)
          {
            int k = 0;
            for (;;)
            {
              if (k < ((b.a)localObject).l().size())
              {//VIM
                JSONObject localJSONObject = new JSONObject(((b.a.b)((b.a)localObject).l().get(k)).l());
                locala = new com.wifi.connect.plugin.magickey.b.a();
                locala.a = localJSONObject.getString("pwdId");
                if (localJSONObject.has("apId"))
                {
                  locala.c = localJSONObject.getString("apId");
                  if (localJSONObject.has("ccId")) {
                    locala.d = localJSONObject.getString("ccId");
                  }
                  locala.b = a(WkSecretKeyNative.a(localJSONObject.getString("pwd"), paramString));//decrypt
                  locala.b = Uri.decode(locala.b);
                  locala.e = localJSONObject.optInt("keyStatus");
                  locala.f = localJSONObject.optInt("authType");
                  locala.g = localJSONObject.optInt("seclvl");
                  paramArrayOfByte.d.add(locala);
                  k++;
                  continue;
                  localException1 = localException1;
                  paramArrayOfByte.b = 0L;
                  localException1.printStackTrace();
                }
              }
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            com.wifi.connect.plugin.magickey.b.a locala;
            paramArrayOfByte.c = false;
            localException2.printStackTrace();
            continue;
            if (localException2.has("apRefId")) {
              locala.c = localException2.getString("apRefId");
            }
          }
        }
      }
    }
  }
  
  private static String a(String paramString)
  {
    try
    {
      String str = paramString.substring(3, Integer.parseInt(paramString.substring(0, 3)) + 3);
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return paramString;
  }
  
  private static byte[] a(String paramString1, WkAccessPoint paramWkAccessPoint, ArrayList<WkAccessPoint> paramArrayList, String paramString2, String paramString3)
  {
    a.a.a locala = a.a.l();
    for (int k = 0; k < paramArrayList.size(); k++)
    {
      a.a.b.a locala1 = a.a.b.l();
      locala1.b(((WkAccessPoint)paramArrayList.get(k)).b());
      locala1.c(((WkAccessPoint)paramArrayList.get(k)).d);
      locala1.a(((WkAccessPoint)paramArrayList.get(k)).c);
      locala1.a(((WkAccessPoint)paramArrayList.get(k)).a());
      locala.a((a.a.b)locala1.c());
    }
    locala.c(paramWkAccessPoint.a());
    locala.b(paramWkAccessPoint.b());
    paramArrayList = paramString2;
    if (paramString2 == null) {
      paramArrayList = "";
    }
    locala.a(paramArrayList);
    paramArrayList = paramString1;
    if (paramString1 == null) {
      paramArrayList = "";
    }
    locala.d(paramArrayList);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    locala.h(paramString1);
    locala.g(k.i(com.bluefay.d.a.getAppContext()));
    locala.f(k.h(com.bluefay.d.a.getAppContext()));
    locala.e(k.f(com.bluefay.d.a.getAppContext()));
    locala.i(String.valueOf(paramWkAccessPoint.c));
    locala.j(String.valueOf(paramWkAccessPoint.d));
    h.a("srssi QueryApPwdTask " + paramWkAccessPoint.d, new Object[0]);
    return ((a.a)locala.c()).b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */