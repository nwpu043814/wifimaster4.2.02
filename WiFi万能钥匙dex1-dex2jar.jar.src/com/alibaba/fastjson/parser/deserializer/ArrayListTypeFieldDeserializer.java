package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArrayListTypeFieldDeserializer
  extends FieldDeserializer
{
  private ObjectDeserializer deserializer;
  private int itemFastMatchToken;
  private final Type itemType;
  
  public ArrayListTypeFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo);
    if ((getFieldType() instanceof ParameterizedType)) {}
    for (this.itemType = ((ParameterizedType)getFieldType()).getActualTypeArguments()[0];; this.itemType = Object.class) {
      return;
    }
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
  
  public final void parseArray(DefaultJSONParser paramDefaultJSONParser, Type paramType, Collection paramCollection)
  {
    Object localObject2 = this.itemType;
    Object localObject3 = this.deserializer;
    Object localObject1 = localObject2;
    TypeVariable localTypeVariable;
    ParameterizedType localParameterizedType;
    if ((localObject2 instanceof TypeVariable))
    {
      localObject1 = localObject2;
      if ((paramType instanceof ParameterizedType))
      {
        localTypeVariable = (TypeVariable)localObject2;
        localParameterizedType = (ParameterizedType)paramType;
        if (!(localParameterizedType.getRawType() instanceof Class)) {
          break label443;
        }
      }
    }
    label443:
    for (localObject1 = (Class)localParameterizedType.getRawType();; localObject1 = null)
    {
      int i;
      if (localObject1 != null)
      {
        int j = ((Class)localObject1).getTypeParameters().length;
        i = 0;
        if (i < j) {
          if (!localObject1.getTypeParameters()[i].getName().equals(localTypeVariable.getName())) {}
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (i != -1)
        {
          localObject2 = localParameterizedType.getActualTypeArguments()[i];
          localObject1 = localObject2;
          if (!localObject2.equals(this.itemType))
          {
            localObject3 = paramDefaultJSONParser.getConfig().getDeserializer((Type)localObject2);
            localObject1 = localObject2;
          }
        }
        for (localObject2 = localObject3;; localObject2 = localObject3)
        {
          localObject3 = paramDefaultJSONParser.getLexer();
          if (((JSONLexer)localObject3).token() != 14)
          {
            paramCollection = "exepct '[', but " + JSONToken.name(((JSONLexer)localObject3).token());
            paramDefaultJSONParser = paramCollection;
            if (paramType != null) {
              paramDefaultJSONParser = paramCollection + ", type : " + paramType;
            }
            throw new JSONException(paramDefaultJSONParser);
            i++;
            break;
          }
          paramType = (Type)localObject2;
          if (localObject2 == null)
          {
            paramType = paramDefaultJSONParser.getConfig().getDeserializer((Type)localObject1);
            this.deserializer = paramType;
            this.itemFastMatchToken = this.deserializer.getFastMatchToken();
          }
          ((JSONLexer)localObject3).nextToken(this.itemFastMatchToken);
          for (i = 0;; i++)
          {
            if (((JSONLexer)localObject3).isEnabled(Feature.AllowArbitraryCommas)) {
              while (((JSONLexer)localObject3).token() == 16) {
                ((JSONLexer)localObject3).nextToken();
              }
            }
            if (((JSONLexer)localObject3).token() == 15) {
              break;
            }
            paramCollection.add(paramType.deserialze(paramDefaultJSONParser, (Type)localObject1, Integer.valueOf(i)));
            paramDefaultJSONParser.checkListResolve(paramCollection);
            if (((JSONLexer)localObject3).token() == 16) {
              ((JSONLexer)localObject3).nextToken(this.itemFastMatchToken);
            }
          }
          ((JSONLexer)localObject3).nextToken(16);
          return;
        }
        i = -1;
      }
    }
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    if (paramDefaultJSONParser.getLexer().token() == 8) {
      setValue(paramObject, null);
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      ParseContext localParseContext = paramDefaultJSONParser.getContext();
      paramDefaultJSONParser.setContext(localParseContext, paramObject, this.fieldInfo.getName());
      parseArray(paramDefaultJSONParser, paramType, localArrayList);
      paramDefaultJSONParser.setContext(localParseContext);
      if (paramObject == null) {
        paramMap.put(this.fieldInfo.getName(), localArrayList);
      } else {
        setValue(paramObject, localArrayList);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ArrayListTypeFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */