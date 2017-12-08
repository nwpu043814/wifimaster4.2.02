package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class DefaultFieldDeserializer
  extends FieldDeserializer
{
  private ObjectDeserializer fieldValueDeserilizer;
  
  public DefaultFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo);
  }
  
  public int getFastMatchToken()
  {
    if (this.fieldValueDeserilizer != null) {}
    for (int i = this.fieldValueDeserilizer.getFastMatchToken();; i = 2) {
      return i;
    }
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    if (this.fieldValueDeserilizer == null) {
      this.fieldValueDeserilizer = paramDefaultJSONParser.getConfig().getDeserializer(this.fieldInfo);
    }
    if ((paramType instanceof ParameterizedType)) {
      paramDefaultJSONParser.getContext().setType(paramType);
    }
    paramType = this.fieldValueDeserilizer.deserialze(paramDefaultJSONParser, getFieldType(), this.fieldInfo.getName());
    if (paramDefaultJSONParser.getResolveStatus() == 1)
    {
      paramObject = paramDefaultJSONParser.getLastResolveTask();
      ((DefaultJSONParser.ResolveTask)paramObject).setFieldDeserializer(this);
      ((DefaultJSONParser.ResolveTask)paramObject).setOwnerContext(paramDefaultJSONParser.getContext());
      paramDefaultJSONParser.setResolveStatus(0);
    }
    for (;;)
    {
      return;
      if (paramObject == null) {
        paramMap.put(this.fieldInfo.getName(), paramType);
      } else {
        setValue(paramObject, paramType);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */