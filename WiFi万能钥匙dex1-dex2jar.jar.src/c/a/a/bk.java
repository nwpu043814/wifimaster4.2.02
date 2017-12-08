package c.a.a;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public final class bk
{
  private static Map a;
  
  static
  {
    for (;;)
    {
      Object localObject2;
      int i;
      try
      {
        localObject1 = System.getProperty("dnsjava.options");
        if (localObject1 != null)
        {
          StringTokenizer localStringTokenizer = new java/util/StringTokenizer;
          localStringTokenizer.<init>((String)localObject1, ",");
          if (localStringTokenizer.hasMoreTokens())
          {
            localObject2 = localStringTokenizer.nextToken();
            i = ((String)localObject2).indexOf('=');
            if (i != -1) {
              break label83;
            }
            if (a == null)
            {
              localObject1 = new java/util/HashMap;
              ((HashMap)localObject1).<init>();
              a = (Map)localObject1;
            }
            a.put(((String)localObject2).toLowerCase(), "true");
            continue;
          }
        }
        return;
      }
      catch (SecurityException localSecurityException) {}
      label83:
      Object localObject1 = ((String)localObject2).substring(0, i);
      String str = ((String)localObject2).substring(i + 1);
      if (a == null)
      {
        localObject2 = new java/util/HashMap;
        ((HashMap)localObject2).<init>();
        a = (Map)localObject2;
      }
      a.put(((String)localObject1).toLowerCase(), str.toLowerCase());
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    if (a == null) {}
    for (;;)
    {
      return bool;
      if (a.get(paramString.toLowerCase()) != null) {
        bool = true;
      }
    }
  }
  
  public static int b(String paramString)
  {
    if (a == null)
    {
      paramString = null;
      if (paramString == null) {
        break label43;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString);
        if (i <= 0) {
          break label43;
        }
        return i;
      }
      catch (NumberFormatException paramString) {}
      paramString = (String)a.get(paramString.toLowerCase());
      break;
      label43:
      int i = -1;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */