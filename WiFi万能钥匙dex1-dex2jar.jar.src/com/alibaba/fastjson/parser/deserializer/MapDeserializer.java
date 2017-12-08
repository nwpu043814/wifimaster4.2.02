package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapDeserializer
  implements ObjectDeserializer
{
  public static final MapDeserializer instance = new MapDeserializer();
  
  public static Object parseMap(DefaultJSONParser paramDefaultJSONParser, Map<Object, Object> paramMap, Type paramType1, Type paramType2, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if ((localJSONLexer.token() != 12) && (localJSONLexer.token() != 16)) {
      throw new JSONException("syntax error, expect {, actual " + localJSONLexer.tokenName());
    }
    ObjectDeserializer localObjectDeserializer1 = paramDefaultJSONParser.getConfig().getDeserializer(paramType1);
    ObjectDeserializer localObjectDeserializer2 = paramDefaultJSONParser.getConfig().getDeserializer(paramType2);
    localJSONLexer.nextToken(localObjectDeserializer1.getFastMatchToken());
    paramObject = paramDefaultJSONParser.getContext();
    for (;;)
    {
      try
      {
        if (localJSONLexer.token() == 13)
        {
          localJSONLexer.nextToken(16);
          return paramMap;
        }
        if ((localJSONLexer.token() != 4) || (!localJSONLexer.isRef())) {
          break label353;
        }
        localJSONLexer.nextTokenWithColon(4);
        if (localJSONLexer.token() != 4) {
          break label298;
        }
        paramType1 = localJSONLexer.stringVal();
        if ("..".equals(paramType1))
        {
          paramMap = ((ParseContext)paramObject).getParentContext().getObject();
          localJSONLexer.nextToken(13);
          if (localJSONLexer.token() == 13) {
            break label335;
          }
          paramMap = new com/alibaba/fastjson/JSONException;
          paramMap.<init>("illegal ref");
          throw paramMap;
        }
      }
      finally
      {
        paramDefaultJSONParser.setContext((ParseContext)paramObject);
      }
      if ("$".equals(paramType1))
      {
        for (paramMap = (Map<Object, Object>)paramObject; paramMap.getParentContext() != null; paramMap = paramMap.getParentContext()) {}
        paramMap = paramMap.getObject();
      }
      else
      {
        paramMap = new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;
        paramMap.<init>((ParseContext)paramObject, paramType1);
        paramDefaultJSONParser.addResolveTask(paramMap);
        paramDefaultJSONParser.setResolveStatus(1);
        paramMap = null;
        continue;
        label298:
        paramMap = new com/alibaba/fastjson/JSONException;
        paramType1 = new java/lang/StringBuilder;
        paramType1.<init>("illegal ref, ");
        paramMap.<init>(JSONToken.name(localJSONLexer.token()));
        throw paramMap;
        label335:
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser.setContext((ParseContext)paramObject);
        continue;
        label353:
        if ((paramMap.size() == 0) && (localJSONLexer.token() == 4) && (JSON.DEFAULT_TYPE_KEY.equals(localJSONLexer.stringVal())))
        {
          localJSONLexer.nextTokenWithColon(4);
          localJSONLexer.nextToken(16);
          if (localJSONLexer.token() == 13)
          {
            localJSONLexer.nextToken();
            paramDefaultJSONParser.setContext((ParseContext)paramObject);
          }
          else
          {
            localJSONLexer.nextToken(localObjectDeserializer1.getFastMatchToken());
          }
        }
        else
        {
          Object localObject = localObjectDeserializer1.deserialze(paramDefaultJSONParser, paramType1, null);
          if (localJSONLexer.token() != 17)
          {
            paramMap = new com/alibaba/fastjson/JSONException;
            paramType1 = new java/lang/StringBuilder;
            paramType1.<init>("syntax error, expect :, actual ");
            paramMap.<init>(localJSONLexer.token());
            throw paramMap;
          }
          localJSONLexer.nextToken(localObjectDeserializer2.getFastMatchToken());
          paramMap.put(localObject, localObjectDeserializer2.deserialze(paramDefaultJSONParser, paramType2, localObject));
          if (localJSONLexer.token() == 16) {
            localJSONLexer.nextToken(localObjectDeserializer1.getFastMatchToken());
          }
        }
      }
    }
  }
  
  public static Map parseMap(DefaultJSONParser paramDefaultJSONParser, Map<String, Object> paramMap, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() != 12) {
      throw new JSONException("syntax error, expect {, actual " + localJSONLexer.token());
    }
    ParseContext localParseContext = paramDefaultJSONParser.getContext();
    int i;
    int j;
    Object localObject1;
    try
    {
      localJSONLexer.skipWhitespace();
      i = localJSONLexer.getCurrent();
      j = i;
      if (paramDefaultJSONParser.isEnabled(Feature.AllowArbitraryCommas)) {
        for (;;)
        {
          j = i;
          if (i != 44) {
            break;
          }
          localJSONLexer.next();
          localJSONLexer.skipWhitespace();
          i = localJSONLexer.getCurrent();
        }
      }
      if (j == 34)
      {
        localObject1 = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable(), '"');
        localJSONLexer.skipWhitespace();
        if (localJSONLexer.getCurrent() == ':') {
          break label444;
        }
        paramType = new com/alibaba/fastjson/JSONException;
        paramMap = new java/lang/StringBuilder;
        paramMap.<init>("expect ':' at ");
        paramType.<init>(localJSONLexer.pos());
        throw paramType;
      }
    }
    finally
    {
      paramDefaultJSONParser.setContext(localParseContext);
    }
    if (j == 125)
    {
      localJSONLexer.next();
      localJSONLexer.resetStringPosition();
      localJSONLexer.nextToken(16);
      paramDefaultJSONParser.setContext(localParseContext);
    }
    for (;;)
    {
      return paramMap;
      if (j == 39)
      {
        if (!paramDefaultJSONParser.isEnabled(Feature.AllowSingleQuotes))
        {
          paramMap = new com/alibaba/fastjson/JSONException;
          paramMap.<init>("syntax error");
          throw paramMap;
        }
        localObject1 = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable(), '\'');
        localJSONLexer.skipWhitespace();
        if (localJSONLexer.getCurrent() != ':')
        {
          paramMap = new com/alibaba/fastjson/JSONException;
          paramType = new java/lang/StringBuilder;
          paramType.<init>("expect ':' at ");
          paramMap.<init>(localJSONLexer.pos());
          throw paramMap;
        }
      }
      else
      {
        if (!paramDefaultJSONParser.isEnabled(Feature.AllowUnQuotedFieldNames))
        {
          paramMap = new com/alibaba/fastjson/JSONException;
          paramMap.<init>("syntax error");
          throw paramMap;
        }
        localObject1 = localJSONLexer.scanSymbolUnQuoted(paramDefaultJSONParser.getSymbolTable());
        localJSONLexer.skipWhitespace();
        char c = localJSONLexer.getCurrent();
        if (c != ':')
        {
          paramMap = new com/alibaba/fastjson/JSONException;
          paramType = new java/lang/StringBuilder;
          paramType.<init>("expect ':' at ");
          paramMap.<init>(localJSONLexer.pos() + ", actual " + c);
          throw paramMap;
        }
      }
      label444:
      localJSONLexer.next();
      localJSONLexer.skipWhitespace();
      localJSONLexer.getCurrent();
      localJSONLexer.resetStringPosition();
      if (localObject1 == JSON.DEFAULT_TYPE_KEY)
      {
        localObject1 = TypeUtils.loadClass(localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable(), '"'));
        if (localObject1 == paramMap.getClass())
        {
          localJSONLexer.nextToken(16);
          if (localJSONLexer.token() != 13) {
            break;
          }
          localJSONLexer.nextToken(16);
          paramDefaultJSONParser.setContext(localParseContext);
          continue;
        }
        paramMap = paramDefaultJSONParser.getConfig().getDeserializer((Type)localObject1);
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser.setResolveStatus(2);
        if ((localParseContext != null) && (!(paramObject instanceof Integer))) {
          paramDefaultJSONParser.popContext();
        }
        paramMap = (Map)paramMap.deserialze(paramDefaultJSONParser, (Type)localObject1, paramObject);
        paramDefaultJSONParser.setContext(localParseContext);
        continue;
      }
      localJSONLexer.nextToken();
      Object localObject2;
      if (localJSONLexer.token() == 8)
      {
        localObject2 = null;
        localJSONLexer.nextToken();
      }
      for (;;)
      {
        paramMap.put(localObject1, localObject2);
        paramDefaultJSONParser.checkMapResolve(paramMap, (String)localObject1);
        paramDefaultJSONParser.setContext(localParseContext, localObject2, localObject1);
        i = localJSONLexer.token();
        if ((i != 20) && (i != 15)) {
          break label711;
        }
        paramDefaultJSONParser.setContext(localParseContext);
        break;
        localObject2 = paramDefaultJSONParser.parseObject(paramType);
      }
      label711:
      if (i != 13) {
        break;
      }
      localJSONLexer.nextToken();
      paramDefaultJSONParser.setContext(localParseContext);
    }
  }
  
  protected Map<Object, Object> createMap(Type paramType)
  {
    if (paramType == Properties.class) {
      paramType = new Properties();
    }
    for (;;)
    {
      return paramType;
      if (paramType == Hashtable.class)
      {
        paramType = new Hashtable();
        continue;
      }
      if (paramType == IdentityHashMap.class)
      {
        paramType = new IdentityHashMap();
        continue;
      }
      if ((paramType == SortedMap.class) || (paramType == TreeMap.class))
      {
        paramType = new TreeMap();
        continue;
      }
      if ((paramType == ConcurrentMap.class) || (paramType == ConcurrentHashMap.class))
      {
        paramType = new ConcurrentHashMap();
        continue;
      }
      if ((paramType == Map.class) || (paramType == HashMap.class))
      {
        paramType = new HashMap();
        continue;
      }
      if (paramType == LinkedHashMap.class)
      {
        paramType = new LinkedHashMap();
        continue;
      }
      if ((paramType instanceof ParameterizedType))
      {
        paramType = createMap(((ParameterizedType)paramType).getRawType());
        continue;
      }
      Object localObject = (Class)paramType;
      if (((Class)localObject).isInterface()) {
        throw new JSONException("unsupport type " + paramType);
      }
      try
      {
        localObject = (Map)((Class)localObject).newInstance();
        paramType = (Type)localObject;
      }
      catch (Exception localException)
      {
        throw new JSONException("unsupport type " + paramType, localException);
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    Object localObject = paramDefaultJSONParser.getLexer();
    if (((JSONLexer)localObject).token() == 8)
    {
      ((JSONLexer)localObject).nextToken(16);
      paramType = null;
    }
    for (;;)
    {
      return paramType;
      Map localMap = createMap(paramType);
      localObject = paramDefaultJSONParser.getContext();
      try
      {
        paramDefaultJSONParser.setContext((ParseContext)localObject, localMap, paramObject);
        paramType = deserialze(paramDefaultJSONParser, paramType, paramObject, localMap);
        paramDefaultJSONParser.setContext((ParseContext)localObject);
      }
      finally
      {
        paramDefaultJSONParser.setContext((ParseContext)localObject);
      }
    }
  }
  
  protected Object deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject, Map paramMap)
  {
    Object localObject;
    if ((paramType instanceof ParameterizedType))
    {
      localObject = (ParameterizedType)paramType;
      paramType = localObject.getActualTypeArguments()[0];
      localObject = localObject.getActualTypeArguments()[1];
      if (String.class == paramType) {
        paramDefaultJSONParser = parseMap(paramDefaultJSONParser, paramMap, (Type)localObject, paramObject);
      }
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      paramDefaultJSONParser = parseMap(paramDefaultJSONParser, paramMap, paramType, (Type)localObject, paramObject);
      continue;
      paramDefaultJSONParser = paramDefaultJSONParser.parseObject(paramMap, paramObject);
    }
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/MapDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */