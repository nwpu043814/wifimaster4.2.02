package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class g
{
  private static g bg = null;
  private List<String> bc = null;
  private volatile HttpHost bd = null;
  private f be = null;
  private int bf = 0;
  private Context bh = null;
  private b bi = null;
  private volatile String c = "";
  private volatile int g = 2;
  
  private g(Context paramContext)
  {
    this.bh = paramContext.getApplicationContext();
    this.be = new f();
    ak.j(paramContext);
    this.bi = l.av();
    Y();
    this.bc = new ArrayList(10);
    this.bc.add("117.135.169.101");
    this.bc.add("140.207.54.125");
    this.bc.add("180.153.8.53");
    this.bc.add("120.198.203.175");
    this.bc.add("14.17.43.18");
    this.bc.add("163.177.71.186");
    this.bc.add("111.30.131.31");
    this.bc.add("123.126.121.167");
    this.bc.add("123.151.152.111");
    this.bc.add("113.142.45.79");
    this.bc.add("123.138.162.90");
    this.bc.add("103.7.30.94");
    Z();
  }
  
  private String O()
  {
    try
    {
      if (!d("pingma.qq.com"))
      {
        String str1 = InetAddress.getByName("pingma.qq.com").getHostAddress();
        return str1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.bi.b(localException);
        String str2 = "";
      }
    }
  }
  
  private void Y()
  {
    this.g = 0;
    this.bd = null;
    this.c = null;
  }
  
  private static boolean d(String paramString)
  {
    return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(paramString).matches();
  }
  
  public static g r(Context paramContext)
  {
    if (bg == null) {}
    try
    {
      if (bg == null)
      {
        g localg = new com/tencent/wxop/stat/g;
        localg.<init>(paramContext);
        bg = localg;
      }
      return bg;
    }
    finally {}
  }
  
  public final int D()
  {
    return this.g;
  }
  
  public final void I()
  {
    this.bf = ((this.bf + 1) % this.bc.size());
  }
  
  public final HttpHost V()
  {
    return this.bd;
  }
  
  public final boolean W()
  {
    boolean bool = true;
    if (this.g == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public final boolean X()
  {
    if (this.g != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  final void Z()
  {
    String str1;
    Object localObject;
    if (r.W(this.bh))
    {
      if (c.ad)
      {
        str1 = O();
        if (c.k()) {
          this.bi.b("remoteIp ip is " + str1);
        }
        if (l.e(str1))
        {
          if (!this.bc.contains(str1)) {
            break label191;
          }
          localObject = str1;
          c.o("http://" + (String)localObject + ":80/mstat/report");
        }
      }
      this.c = l.E(this.bh);
      if (c.k()) {
        this.bi.b("NETWORK name:" + this.c);
      }
      if (l.e(this.c))
      {
        if ("WIFI".equalsIgnoreCase(this.c))
        {
          this.g = 1;
          label166:
          this.bd = l.v(this.bh);
        }
      }
      else if (e.a()) {
        e.n(this.bh);
      }
    }
    for (;;)
    {
      return;
      label191:
      String str2 = (String)this.bc.get(this.bf);
      localObject = str2;
      if (!c.k()) {
        break;
      }
      this.bi.c(str1 + " not in ip list, change to:" + str2);
      localObject = str2;
      break;
      this.g = 2;
      break label166;
      if (c.k()) {
        this.bi.b("NETWORK TYPE: network is close.");
      }
      Y();
    }
  }
  
  public final void aa()
  {
    this.bh.getApplicationContext().registerReceiver(new z(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final void b(String paramString)
  {
    if (c.k()) {
      this.bi.b("updateIpList " + paramString);
    }
    try
    {
      if (l.e(paramString))
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        if (localJSONObject.length() > 0)
        {
          paramString = localJSONObject.keys();
          while (paramString.hasNext())
          {
            Object localObject1 = localJSONObject.getString((String)paramString.next());
            if (l.e((String)localObject1)) {
              for (Object localObject2 : ((String)localObject1).split(";")) {
                if (l.e((String)localObject2))
                {
                  localObject2 = ((String)localObject2).split(":");
                  if (localObject2.length > 1)
                  {
                    String str = localObject2[0];
                    if ((d(str)) && (!this.bc.contains(str)))
                    {
                      if (c.k())
                      {
                        localObject2 = this.bi;
                        StringBuilder localStringBuilder = new java/lang/StringBuilder;
                        localStringBuilder.<init>("add new ip:");
                        ((b)localObject2).b(str);
                      }
                      this.bc.add(str);
                    }
                  }
                }
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      this.bi.b(paramString);
      this.bf = new Random().nextInt(this.bc.size());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */