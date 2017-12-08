package com.b.b;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class w
{
  static String a(u paramu, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ").append(paramString);
    a(paramu, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  private static final String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramString.length(); i++)
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
    }
    return localStringBuilder.toString();
  }
  
  private static void a(u paramu, StringBuilder paramStringBuilder, int paramInt)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = new HashMap();
    Object localObject3 = new TreeSet();
    Object localObject4;
    for (localObject4 : paramu.getClass().getDeclaredMethods())
    {
      ((Map)localObject2).put(((Method)localObject4).getName(), localObject4);
      if (((Method)localObject4).getParameterTypes().length == 0)
      {
        ((Map)localObject1).put(((Method)localObject4).getName(), localObject4);
        if (((Method)localObject4).getName().startsWith("get")) {
          ((Set)localObject3).add(((Method)localObject4).getName());
        }
      }
    }
    localObject3 = ((Set)localObject3).iterator();
    label496:
    label740:
    label765:
    while (((Iterator)localObject3).hasNext())
    {
      ??? = ((String)((Iterator)localObject3).next()).replaceFirst("get", "");
      Object localObject6;
      if ((((String)???).endsWith("List")) && (!((String)???).endsWith("OrBuilderList")))
      {
        localObject6 = ((String)???).substring(0, 1).toLowerCase() + ((String)???).substring(1, ((String)???).length() - 4);
        localObject4 = (Method)((Map)localObject1).get("get" + (String)???);
        if (localObject4 != null)
        {
          a(paramStringBuilder, paramInt, a((String)localObject6), m.a((Method)localObject4, paramu, new Object[0]));
          continue;
        }
      }
      if (((Method)((Map)localObject2).get("set" + (String)???) != null) && ((!((String)???).endsWith("Bytes")) || (!((Map)localObject1).containsKey("get" + ((String)???).substring(0, ((String)???).length() - 5)))))
      {
        localObject4 = ((String)???).substring(0, 1).toLowerCase() + ((String)???).substring(1);
        localObject6 = (Method)((Map)localObject1).get("get" + (String)???);
        ??? = (Method)((Map)localObject1).get("has" + (String)???);
        if (localObject6 != null)
        {
          localObject6 = m.a((Method)localObject6, paramu, new Object[0]);
          boolean bool;
          if (??? == null) {
            if ((localObject6 instanceof Boolean)) {
              if (!((Boolean)localObject6).booleanValue())
              {
                bool = true;
                if (bool) {
                  break label740;
                }
                bool = true;
              }
            }
          }
          for (;;)
          {
            if (!bool) {
              break label765;
            }
            a(paramStringBuilder, paramInt, a((String)localObject4), localObject6);
            break;
            bool = false;
            break label496;
            if ((localObject6 instanceof Integer))
            {
              if (((Integer)localObject6).intValue() == 0)
              {
                bool = true;
                break label496;
              }
              bool = false;
              break label496;
            }
            if ((localObject6 instanceof Float))
            {
              if (((Float)localObject6).floatValue() == 0.0F)
              {
                bool = true;
                break label496;
              }
              bool = false;
              break label496;
            }
            if ((localObject6 instanceof Double))
            {
              if (((Double)localObject6).doubleValue() == 0.0D)
              {
                bool = true;
                break label496;
              }
              bool = false;
              break label496;
            }
            if ((localObject6 instanceof String))
            {
              bool = localObject6.equals("");
              break label496;
            }
            if ((localObject6 instanceof e))
            {
              bool = localObject6.equals(e.a);
              break label496;
            }
            if ((localObject6 instanceof u))
            {
              if (localObject6 == ((u)localObject6).j())
              {
                bool = true;
                break label496;
              }
              bool = false;
              break label496;
            }
            if ((localObject6 instanceof Enum))
            {
              if (((Enum)localObject6).ordinal() == 0)
              {
                bool = true;
                break label496;
              }
              bool = false;
              break label496;
            }
            bool = false;
            break label496;
            bool = false;
            continue;
            bool = ((Boolean)m.a((Method)???, paramu, new Object[0])).booleanValue();
          }
        }
      }
    }
    if ((paramu instanceof m.d))
    {
      localObject2 = ((m.d)paramu).d.b();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        a(paramStringBuilder, paramInt, "[" + ((m.f)((Map.Entry)localObject1).getKey()).a + "]", ((Map.Entry)localObject1).getValue());
      }
    }
    if (((m)paramu).b != null) {
      ((m)paramu).b.a(paramStringBuilder, paramInt);
    }
  }
  
  static final void a(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    int j = 0;
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        a(paramStringBuilder, paramInt, paramString, ((Iterator)paramObject).next());
      }
    }
    paramStringBuilder.append('\n');
    for (int i = 0; i < paramInt; i++) {
      paramStringBuilder.append(' ');
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String)) {
      paramStringBuilder.append(": \"").append(ad.a(e.a((String)paramObject))).append('"');
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof e))
      {
        paramStringBuilder.append(": \"").append(ad.a((e)paramObject)).append('"');
      }
      else if ((paramObject instanceof m))
      {
        paramStringBuilder.append(" {");
        a((m)paramObject, paramStringBuilder, paramInt + 2);
        paramStringBuilder.append("\n");
        for (i = j; i < paramInt; i++) {
          paramStringBuilder.append(' ');
        }
        paramStringBuilder.append("}");
      }
      else
      {
        paramStringBuilder.append(": ").append(paramObject.toString());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */