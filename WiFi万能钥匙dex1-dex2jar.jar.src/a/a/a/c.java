package a.a.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c
{
  public static final Object a = new a((byte)0);
  private Map b;
  
  public c()
  {
    this.b = new HashMap();
  }
  
  public c(d paramd)
  {
    this();
    if (paramd.c() != '{') {
      throw paramd.a("A JSONObject text must begin with '{'");
    }
    do
    {
      paramd.a();
      String str;
      int i;
      switch (paramd.c())
      {
      default: 
        paramd.a();
        str = paramd.d().toString();
        i = paramd.c();
        if (i == 61) {
          if (paramd.b() != '>') {
            paramd.a();
          }
        }
      case '\000': 
        Object localObject;
        while (i == 58)
        {
          localObject = paramd.d();
          if (str != null) {
            break;
          }
          throw new a("Null key.");
          throw paramd.a("A JSONObject text must end with '}'");
        }
        throw paramd.a("Expected a ':' after a key");
        if (localObject != null)
        {
          b(localObject);
          this.b.put(str, localObject);
        }
        for (;;)
        {
          switch (paramd.c())
          {
          default: 
            throw paramd.a("Expected a ',' or '}'");
            this.b.remove(str);
          }
        }
      }
    } while (paramd.c() != '}');
  }
  
  public c(String paramString)
  {
    this(new d(paramString));
  }
  
  public c(Map paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    this.b = ((Map)localObject);
  }
  
  static String a(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.equals(null))) {
      paramObject = "null";
    }
    for (;;)
    {
      return (String)paramObject;
      if ((paramObject instanceof Number))
      {
        paramObject = (Number)paramObject;
        if (paramObject == null) {
          throw new a("Null pointer");
        }
        b(paramObject);
        String str = paramObject.toString();
        paramObject = str;
        if (str.indexOf('.') > 0)
        {
          paramObject = str;
          if (str.indexOf('e') < 0)
          {
            paramObject = str;
            if (str.indexOf('E') < 0)
            {
              while (str.endsWith("0")) {
                str = str.substring(0, str.length() - 1);
              }
              paramObject = str;
              if (str.endsWith(".")) {
                paramObject = str.substring(0, str.length() - 1);
              }
            }
          }
        }
      }
      else if (((paramObject instanceof Boolean)) || ((paramObject instanceof c)) || ((paramObject instanceof b)))
      {
        paramObject = paramObject.toString();
      }
      else if ((paramObject instanceof Map))
      {
        paramObject = new c((Map)paramObject).toString();
      }
      else if ((paramObject instanceof Collection))
      {
        paramObject = new b((Collection)paramObject).toString();
      }
      else if (paramObject.getClass().isArray())
      {
        paramObject = new b(paramObject).toString();
      }
      else
      {
        paramObject = c(paramObject.toString());
      }
    }
  }
  
  private static void b(Object paramObject)
  {
    if (paramObject != null) {
      if ((paramObject instanceof Double))
      {
        if ((((Double)paramObject).isInfinite()) || (((Double)paramObject).isNaN())) {
          throw new a("JSON does not allow non-finite numbers.");
        }
      }
      else if (((paramObject instanceof Float)) && ((((Float)paramObject).isInfinite()) || (((Float)paramObject).isNaN()))) {
        throw new a("JSON does not allow non-finite numbers.");
      }
    }
  }
  
  public static String c(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0)) {}
    StringBuffer localStringBuffer;
    for (paramString = "\"\"";; paramString = localStringBuffer.toString())
    {
      return paramString;
      int k = paramString.length();
      localStringBuffer = new StringBuffer(k + 4);
      localStringBuffer.append('"');
      int j = 0;
      if (i < k)
      {
        char c = paramString.charAt(i);
        switch (c)
        {
        default: 
          if ((c < ' ') || ((c >= '') && (c < ' ')) || ((c >= ' ') && (c < '℀')))
          {
            String str = "000" + Integer.toHexString(c);
            localStringBuffer.append("\\u" + str.substring(str.length() - 4));
          }
          break;
        }
        for (;;)
        {
          i++;
          j = c;
          break;
          localStringBuffer.append('\\');
          localStringBuffer.append(c);
          continue;
          if (j == 60) {
            localStringBuffer.append('\\');
          }
          localStringBuffer.append(c);
          continue;
          localStringBuffer.append("\\b");
          continue;
          localStringBuffer.append("\\t");
          continue;
          localStringBuffer.append("\\n");
          continue;
          localStringBuffer.append("\\f");
          continue;
          localStringBuffer.append("\\r");
          continue;
          localStringBuffer.append(c);
        }
      }
      localStringBuffer.append('"');
    }
  }
  
  public final Object a(String paramString)
  {
    if (paramString == null) {}
    for (Object localObject = null; localObject == null; localObject = this.b.get(paramString)) {
      throw new a("JSONObject[" + c(paramString) + "] not found.");
    }
    return localObject;
  }
  
  public final Iterator a()
  {
    return this.b.keySet().iterator();
  }
  
  public final boolean b(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public String toString()
  {
    String str;
    try
    {
      Iterator localIterator = a();
      StringBuffer localStringBuffer = new java/lang/StringBuffer;
      localStringBuffer.<init>("{");
      while (localIterator.hasNext())
      {
        if (localStringBuffer.length() > 1) {
          localStringBuffer.append(',');
        }
        Object localObject = localIterator.next();
        localStringBuffer.append(c(localObject.toString()));
        localStringBuffer.append(':');
        localStringBuffer.append(a(this.b.get(localObject)));
        continue;
        return str;
      }
    }
    catch (Exception localException)
    {
      str = null;
    }
    for (;;)
    {
      str.append('}');
      str = str.toString();
    }
  }
  
  private static final class a
  {
    protected final Object clone()
    {
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (paramObject == this)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final String toString()
    {
      return "null";
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */