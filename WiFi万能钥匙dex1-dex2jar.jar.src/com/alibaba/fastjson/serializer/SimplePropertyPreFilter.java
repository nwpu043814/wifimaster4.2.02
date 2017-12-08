package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

public class SimplePropertyPreFilter
  implements PropertyPreFilter
{
  private final Class<?> clazz;
  private final Set<String> excludes = new HashSet();
  private final Set<String> includes = new HashSet();
  
  public SimplePropertyPreFilter(Class<?> paramClass, String... paramVarArgs)
  {
    this.clazz = paramClass;
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
    {
      paramClass = paramVarArgs[i];
      if (paramClass != null) {
        this.includes.add(paramClass);
      }
    }
  }
  
  public SimplePropertyPreFilter(String... paramVarArgs)
  {
    this(null, paramVarArgs);
  }
  
  public boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (this.clazz != null)
      {
        bool1 = bool2;
        if (!this.clazz.isInstance(paramObject)) {}
      }
      else if (this.excludes.contains(paramString))
      {
        bool1 = false;
      }
      else
      {
        bool1 = bool2;
        if (this.includes.size() != 0)
        {
          bool1 = bool2;
          if (!this.includes.contains(paramString)) {
            bool1 = false;
          }
        }
      }
    }
  }
  
  public Class<?> getClazz()
  {
    return this.clazz;
  }
  
  public Set<String> getExcludes()
  {
    return this.excludes;
  }
  
  public Set<String> getIncludes()
  {
    return this.includes;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/SimplePropertyPreFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */