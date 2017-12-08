package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Map;

public class IntegerFieldDeserializer
  extends FieldDeserializer
{
  public IntegerFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo);
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    paramType = paramDefaultJSONParser.getLexer();
    int i;
    if (paramType.token() == 2)
    {
      i = paramType.intValue();
      paramType.nextToken(16);
      if (paramObject == null) {
        paramMap.put(this.fieldInfo.getName(), Integer.valueOf(i));
      }
    }
    for (;;)
    {
      return;
      setValue(paramObject, i);
      continue;
      if (paramType.token() == 8)
      {
        paramDefaultJSONParser = null;
        paramType.nextToken(16);
      }
      for (;;)
      {
        if ((paramDefaultJSONParser == null) && (getFieldClass() == Integer.TYPE)) {
          break label133;
        }
        if (paramObject != null) {
          break label135;
        }
        paramMap.put(this.fieldInfo.getName(), paramDefaultJSONParser);
        break;
        paramDefaultJSONParser = TypeUtils.castToInt(paramDefaultJSONParser.parse());
      }
      label133:
      continue;
      label135:
      setValue(paramObject, paramDefaultJSONParser);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/IntegerFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */