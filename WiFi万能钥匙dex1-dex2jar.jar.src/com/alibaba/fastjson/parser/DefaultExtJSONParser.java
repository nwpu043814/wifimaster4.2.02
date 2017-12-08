package com.alibaba.fastjson.parser;

@Deprecated
public class DefaultExtJSONParser
  extends DefaultJSONParser
{
  public DefaultExtJSONParser(String paramString)
  {
    this(paramString, ParserConfig.getGlobalInstance());
  }
  
  public DefaultExtJSONParser(String paramString, ParserConfig paramParserConfig)
  {
    super(paramString, paramParserConfig);
  }
  
  public DefaultExtJSONParser(String paramString, ParserConfig paramParserConfig, int paramInt)
  {
    super(paramString, paramParserConfig, paramInt);
  }
  
  public DefaultExtJSONParser(char[] paramArrayOfChar, int paramInt1, ParserConfig paramParserConfig, int paramInt2)
  {
    super(paramArrayOfChar, paramInt1, paramParserConfig, paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/DefaultExtJSONParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */