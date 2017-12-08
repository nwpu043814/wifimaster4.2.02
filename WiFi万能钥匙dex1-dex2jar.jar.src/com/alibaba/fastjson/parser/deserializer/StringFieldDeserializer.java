package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Type;
import java.util.Map;

public class StringFieldDeserializer
  extends FieldDeserializer
{
  private final ObjectDeserializer fieldValueDeserilizer;
  
  public StringFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo);
    this.fieldValueDeserilizer = paramParserConfig.getDeserializer(paramFieldInfo);
  }
  
  public int getFastMatchToken()
  {
    return this.fieldValueDeserilizer.getFastMatchToken();
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    paramType = paramDefaultJSONParser.getLexer();
    if (paramType.token() == 4)
    {
      paramDefaultJSONParser = paramType.stringVal();
      paramType.nextToken(16);
      if (paramObject != null) {
        break label73;
      }
      paramMap.put(this.fieldInfo.getName(), paramDefaultJSONParser);
    }
    for (;;)
    {
      return;
      paramDefaultJSONParser = paramDefaultJSONParser.parse();
      if (paramDefaultJSONParser == null)
      {
        paramDefaultJSONParser = null;
        break;
      }
      paramDefaultJSONParser = paramDefaultJSONParser.toString();
      break;
      label73:
      setValue(paramObject, paramDefaultJSONParser);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/StringFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */