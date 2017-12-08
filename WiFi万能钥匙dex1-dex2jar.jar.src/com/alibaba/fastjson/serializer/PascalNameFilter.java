package com.alibaba.fastjson.serializer;

public class PascalNameFilter
  implements NameFilter
{
  public String process(Object paramObject1, String paramString, Object paramObject2)
  {
    paramObject1 = paramString;
    if (paramString != null) {
      if (paramString.length() != 0) {
        break label17;
      }
    }
    for (paramObject1 = paramString;; paramObject1 = new String((char[])paramObject1))
    {
      return (String)paramObject1;
      label17:
      paramObject1 = paramString.toCharArray();
      paramObject1[0] = Character.toUpperCase(paramObject1[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/PascalNameFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */