package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Map;

public class LongFieldDeserializer
  extends FieldDeserializer
{
  private final ObjectDeserializer fieldValueDeserilizer;
  
  public LongFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
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
    long l;
    if (paramType.token() == 2)
    {
      l = paramType.longValue();
      paramType.nextToken(16);
      if (paramObject == null) {
        paramMap.put(this.fieldInfo.getName(), Long.valueOf(l));
      }
    }
    for (;;)
    {
      return;
      setValue(paramObject, l);
      continue;
      if (paramType.token() == 8)
      {
        paramDefaultJSONParser = null;
        paramType.nextToken(16);
      }
      for (;;)
      {
        if ((paramDefaultJSONParser == null) && (getFieldClass() == Long.TYPE)) {
          break label133;
        }
        if (paramObject != null) {
          break label135;
        }
        paramMap.put(this.fieldInfo.getName(), paramDefaultJSONParser);
        break;
        paramDefaultJSONParser = TypeUtils.castToLong(paramDefaultJSONParser.parse());
      }
      label133:
      continue;
      label135:
      setValue(paramObject, paramDefaultJSONParser);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/LongFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */