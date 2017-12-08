package com.linksure.apservice.a.a.a.a;

import com.bluefay.b.h;
import com.lantern.core.g;
import com.lantern.core.n;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  private String a(String paramString)
  {
    return n.a(b(paramString), this.g, this.h);
  }
  
  private String a(Map<String, String> paramMap)
  {
    return g.a(paramMap, this.i);
  }
  
  private static String b(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private static String b(Map paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramMap.keySet().iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      if (j > 0) {
        localStringBuffer.append("&");
      }
      Object localObject = (String)localIterator.next();
      String str1 = (String)paramMap.get(localObject);
      try
      {
        String str2 = URLEncoder.encode((String)localObject, "UTF-8");
        localObject = str1;
        if (str1 == null) {
          localObject = "";
        }
        localObject = URLEncoder.encode((String)localObject, "UTF-8");
        localStringBuffer.append(str2);
        localStringBuffer.append("=");
        localStringBuffer.append((String)localObject);
        j++;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          h.a(localUnsupportedEncodingException);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public final String a(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("pid", paramString1);
    localHashMap.put("ed", paramString2);
    localHashMap.put("appId", this.c);
    localHashMap.put("et", this.a);
    localHashMap.put("st", this.b);
    localHashMap.put("dhid", this.d);
    localHashMap.put("verCode", this.e);
    localHashMap.put("sign", a(new HashMap(localHashMap)));
    return b(localHashMap);
  }
  
  final Map<String, String> b(String paramString1, String paramString2)
  {
    String str = a(paramString2);
    paramString2 = new HashMap();
    paramString2.put("pid", paramString1);
    paramString2.put("ed", str);
    paramString2.put("appId", this.c);
    paramString2.put("et", this.a);
    paramString2.put("st", this.b);
    paramString2.put("dhid", this.d);
    paramString2.put("verCode", this.e);
    paramString2.put("bizId", this.f);
    paramString2.put("sign", a(new HashMap(paramString2)));
    return paramString2;
  }
  
  public static final class a
  {
    private b a = new b((byte)0);
    
    public final a a(String paramString)
    {
      b.a(this.a, paramString);
      return this;
    }
    
    public final b a()
    {
      return this.a;
    }
    
    public final a b(String paramString)
    {
      b.b(this.a, paramString);
      return this;
    }
    
    public final a c(String paramString)
    {
      b.c(this.a, paramString);
      return this;
    }
    
    public final a d(String paramString)
    {
      b.d(this.a, paramString);
      return this;
    }
    
    public final a e(String paramString)
    {
      b.e(this.a, paramString);
      return this;
    }
    
    public final a f(String paramString)
    {
      b.f(this.a, paramString);
      return this;
    }
    
    public final a g(String paramString)
    {
      b.g(this.a, paramString);
      return this;
    }
    
    public final a h(String paramString)
    {
      b.h(this.a, paramString);
      return this;
    }
    
    public final a i(String paramString)
    {
      b.i(this.a, paramString);
      return this;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */