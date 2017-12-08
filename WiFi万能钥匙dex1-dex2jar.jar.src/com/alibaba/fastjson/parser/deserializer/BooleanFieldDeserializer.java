package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Map;

public class BooleanFieldDeserializer
  extends FieldDeserializer
{
  public BooleanFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo);
  }
  
  public int getFastMatchToken()
  {
    return 6;
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    boolean bool = true;
    paramType = paramDefaultJSONParser.getLexer();
    if (paramType.token() == 6)
    {
      paramType.nextToken(16);
      if (paramObject == null) {
        paramMap.put(this.fieldInfo.getName(), Boolean.TRUE);
      }
    }
    for (;;)
    {
      return;
      setValue(paramObject, true);
      continue;
      if (paramType.token() == 2)
      {
        int i = paramType.intValue();
        paramType.nextToken(16);
        if (i == 1) {}
        for (;;)
        {
          if (paramObject != null) {
            break label124;
          }
          paramMap.put(this.fieldInfo.getName(), Boolean.valueOf(bool));
          break;
          bool = false;
        }
        label124:
        setValue(paramObject, bool);
      }
      else if (paramType.token() == 8)
      {
        paramType.nextToken(16);
        if ((getFieldClass() != Boolean.TYPE) && (paramObject != null)) {
          setValue(paramObject, null);
        }
      }
      else if (paramType.token() == 7)
      {
        paramType.nextToken(16);
        if (paramObject == null) {
          paramMap.put(this.fieldInfo.getName(), Boolean.FALSE);
        } else {
          setValue(paramObject, false);
        }
      }
      else
      {
        paramDefaultJSONParser = TypeUtils.castToBoolean(paramDefaultJSONParser.parse());
        if ((paramDefaultJSONParser != null) || (getFieldClass() != Boolean.TYPE)) {
          if (paramObject == null) {
            paramMap.put(this.fieldInfo.getName(), paramDefaultJSONParser);
          } else {
            setValue(paramObject, paramDefaultJSONParser);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/BooleanFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */