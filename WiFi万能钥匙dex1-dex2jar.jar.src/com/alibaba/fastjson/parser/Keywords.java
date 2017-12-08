package com.alibaba.fastjson.parser;

import java.util.HashMap;
import java.util.Map;

public class Keywords
{
  public static Keywords DEFAULT_KEYWORDS;
  private final Map<String, Integer> keywords;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("null", Integer.valueOf(8));
    localHashMap.put("new", Integer.valueOf(9));
    localHashMap.put("true", Integer.valueOf(6));
    localHashMap.put("false", Integer.valueOf(7));
    DEFAULT_KEYWORDS = new Keywords(localHashMap);
  }
  
  public Keywords(Map<String, Integer> paramMap)
  {
    this.keywords = paramMap;
  }
  
  public Integer getKeyword(String paramString)
  {
    return (Integer)this.keywords.get(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/Keywords.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */