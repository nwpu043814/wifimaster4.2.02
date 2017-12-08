package com.linksure.apservice.utils;

import bluefay.support.annotation.NonNull;
import com.lantern.analytics.a;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  static a a = ;
  
  @NonNull
  private static String a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    for (paramMap = "";; paramMap = paramMap.toString())
    {
      return paramMap;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("{");
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        String str = (String)paramMap.get(localObject);
        StringBuilder localStringBuilder2 = localStringBuilder1.append("\"" + (String)localObject + "\":\"");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localStringBuilder2.append((String)localObject).append("\"");
        localStringBuilder1.append(",");
      }
      paramMap = localStringBuilder1.delete(localStringBuilder1.length() - 1, localStringBuilder1.length());
      paramMap.append("}");
    }
  }
  
  public static void a(String paramString)
  {
    a locala = a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    locala.onEvent("infcli", str);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("{\"sid\":\"");
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localStringBuilder2.append(str).append("\",\"mnu1\":").append(paramInt1).append(",\"mnu2\":").append(paramInt2).append("}");
    a.onEvent("mnucli", localStringBuilder1.toString());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    int i;
    String str;
    if (("saadnbkcli_key".equals(paramString1)) || ("saadbkcli_key".equals(paramString1)) || ("salsbkcli_key".equals(paramString1)) || ("sasrbkcli_key".equals(paramString1)) || ("saifnbkcli_key".equals(paramString1)) || ("saidbkcli_key".equals(paramString1)) || ("saifbkcli_key".equals(paramString1)) || ("acifbkcli_key".equals(paramString1)))
    {
      i = 0;
      System.out.println("---DC---logEvent---backEvent is " + i);
      if (i != 0) {
        break label255;
      }
      str = paramString1.substring(0, paramString1.indexOf("_"));
      localHashMap.put("clkType", "key");
      label133:
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        localHashMap.put("sid", paramString2);
      }
      paramString1 = a(localHashMap);
      if ((str != null) && (str.length() != 0)) {
        break label289;
      }
    }
    for (;;)
    {
      return;
      if (("saadnbkcli_btn".equals(paramString1)) || ("saadbkcli_btn".equals(paramString1)) || ("salsbkcli_btn".equals(paramString1)) || ("sasrbkcli_btn".equals(paramString1)) || ("saifnbkcli_btn".equals(paramString1)) || ("saidbkcli_btn".equals(paramString1)) || ("saifbkcli_btn".equals(paramString1)) || ("acifbkcli_btn".equals(paramString1)))
      {
        i = 1;
        break;
      }
      i = -1;
      break;
      label255:
      str = paramString1;
      if (i != 1) {
        break label133;
      }
      str = paramString1.substring(0, paramString1.indexOf("_"));
      localHashMap.put("clkType", "btn");
      break label133;
      label289:
      a.onEvent(str, paramString1);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sid", paramString2);
    localHashMap.put("actid", paramString3);
    a(paramString1, localHashMap);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("{\"sid\":\"");
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    localObject = localStringBuilder2.append((String)localObject).append("\",\"src\":\"");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((StringBuilder)localObject).append(paramString1).append("\",\"rst\":").append(paramBoolean).append("}");
    a.onEvent("seridxshow", localStringBuilder1.toString());
  }
  
  private static void a(String paramString, Map<String, String> paramMap)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      paramMap = a(paramMap);
      a.onEvent(paramString, paramMap);
    }
  }
  
  public static void b(String paramString)
  {
    a locala = a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    locala.onEvent("repcli", str);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("{\"sid\":\"");
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localStringBuilder2.append(str).append("\",\"src\":\"").append(paramString2).append("\",\"atstu\":").append(paramBoolean).append("}");
    a.onEvent("intcli", localStringBuilder1.toString());
  }
  
  public static void c(String paramString)
  {
    a locala = a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    locala.onEvent("calint", str);
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sid", paramString2);
    if (paramBoolean) {}
    for (paramString2 = "true";; paramString2 = "false")
    {
      localHashMap.put("atstu", paramString2);
      a(paramString1, localHashMap);
      return;
    }
  }
  
  public static void d(String paramString)
  {
    a(paramString, "");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */