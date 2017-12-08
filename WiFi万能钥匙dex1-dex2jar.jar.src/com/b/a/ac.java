package com.b.a;

import com.b.a.b.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ac
  extends z
{
  private final Map<String, z> a = new LinkedHashMap();
  
  public final z a(String paramString)
  {
    if (this.a.containsKey(paramString))
    {
      z localz = (z)this.a.get(paramString);
      paramString = localz;
      if (localz != null) {}
    }
    for (paramString = ab.a();; paramString = null) {
      return paramString;
    }
  }
  
  public final Set<Map.Entry<String, z>> a()
  {
    return this.a.entrySet();
  }
  
  protected final void a(Appendable paramAppendable, h paramh)
  {
    paramAppendable.append('{');
    Iterator localIterator = this.a.entrySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        paramAppendable.append('"');
        paramAppendable.append(paramh.a((CharSequence)localEntry.getKey()));
        paramAppendable.append("\":");
        ((z)localEntry.getValue()).a(paramAppendable, paramh);
        break;
        paramAppendable.append(',');
      }
    }
    paramAppendable.append('}');
  }
  
  public final void a(String paramString, z paramz)
  {
    Object localObject = paramz;
    if (paramz == null) {
      localObject = ab.a();
    }
    this.a.put(a.a(paramString), localObject);
  }
  
  public final void a(String paramString, Number paramNumber)
  {
    if (paramNumber == null) {}
    for (paramNumber = ab.a();; paramNumber = new ag(paramNumber))
    {
      a(paramString, paramNumber);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == this) || (((paramObject instanceof ac)) && (((ac)paramObject).a.equals(this.a)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */