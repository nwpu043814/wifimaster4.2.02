package com.a.a.b.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

final class e
{
  public static final Object a(XmlPullParser paramXmlPullParser, String[] paramArrayOfString)
  {
    int j = paramXmlPullParser.getEventType();
    for (;;)
    {
      if (j == 2) {
        return b(paramXmlPullParser, paramArrayOfString);
      }
      if (j == 3) {
        throw new XmlPullParserException("Unexpected end tag at: " + paramXmlPullParser.getName());
      }
      if (j == 4) {
        throw new XmlPullParserException("Unexpected text: " + paramXmlPullParser.getText());
      }
      try
      {
        int i = paramXmlPullParser.next();
        j = i;
        if (i != 1) {
          continue;
        }
        throw new XmlPullParserException("Unexpected end of document");
      }
      catch (Exception paramArrayOfString)
      {
        throw new XmlPullParserException("Unexpected call next(): " + paramXmlPullParser.getName());
      }
    }
  }
  
  private static HashMap a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    int i = paramXmlPullParser.getEventType();
    if (i == 2)
    {
      localObject = b(paramXmlPullParser, paramArrayOfString);
      if (paramArrayOfString[0] != null) {
        localHashMap.put(paramArrayOfString[0], localObject);
      }
    }
    while (i != 3)
    {
      Object localObject;
      int j = paramXmlPullParser.next();
      i = j;
      if (j != 1) {
        break;
      }
      throw new XmlPullParserException("Document ended before " + paramString + " end tag");
      throw new XmlPullParserException("Map value without name attribute: " + paramXmlPullParser.getName());
    }
    if (paramXmlPullParser.getName().equals(paramString)) {
      return localHashMap;
    }
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
  
  private static void a(Object paramObject, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramObject == null)
    {
      paramXmlSerializer.startTag(null, "null");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      paramXmlSerializer.endTag(null, "null");
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof String))
      {
        paramXmlSerializer.startTag(null, "string");
        if (paramString != null) {
          paramXmlSerializer.attribute(null, "name", paramString);
        }
        paramXmlSerializer.text(paramObject.toString());
        paramXmlSerializer.endTag(null, "string");
      }
      else
      {
        String str;
        if ((paramObject instanceof Integer)) {
          str = "int";
        }
        for (;;)
        {
          paramXmlSerializer.startTag(null, str);
          if (paramString != null) {
            paramXmlSerializer.attribute(null, "name", paramString);
          }
          paramXmlSerializer.attribute(null, "value", paramObject.toString());
          paramXmlSerializer.endTag(null, str);
          break;
          if ((paramObject instanceof Long))
          {
            str = "long";
          }
          else if ((paramObject instanceof Float))
          {
            str = "float";
          }
          else if ((paramObject instanceof Double))
          {
            str = "double";
          }
          else
          {
            if (!(paramObject instanceof Boolean)) {
              break label215;
            }
            str = "boolean";
          }
        }
        label215:
        if ((paramObject instanceof byte[]))
        {
          paramObject = (byte[])paramObject;
          if (paramObject == null)
          {
            paramXmlSerializer.startTag(null, "null");
            paramXmlSerializer.endTag(null, "null");
          }
          else
          {
            paramXmlSerializer.startTag(null, "byte-array");
            if (paramString != null) {
              paramXmlSerializer.attribute(null, "name", paramString);
            }
            int k = paramObject.length;
            paramXmlSerializer.attribute(null, "num", Integer.toString(k));
            paramString = new StringBuilder(paramObject.length * 2);
            int i = 0;
            if (i >= k)
            {
              paramXmlSerializer.text(paramString.toString());
              paramXmlSerializer.endTag(null, "byte-array");
            }
            else
            {
              int m = paramObject[i];
              int j = m >> 4;
              if (j >= 10)
              {
                j = j + 97 - 10;
                label370:
                paramString.append(j);
                j = m & 0xFF;
                if (j < 10) {
                  break label421;
                }
              }
              label421:
              for (j = j + 97 - 10;; j += 48)
              {
                paramString.append(j);
                i++;
                break;
                j += 48;
                break label370;
              }
            }
          }
        }
        else if ((paramObject instanceof int[]))
        {
          a((int[])paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof Map))
        {
          a((Map)paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof List))
        {
          a((List)paramObject, paramString, paramXmlSerializer);
        }
        else
        {
          if (!(paramObject instanceof CharSequence)) {
            break;
          }
          paramXmlSerializer.startTag(null, "string");
          if (paramString != null) {
            paramXmlSerializer.attribute(null, "name", paramString);
          }
          paramXmlSerializer.text(paramObject.toString());
          paramXmlSerializer.endTag(null, "string");
        }
      }
    }
    throw new RuntimeException("writeValueXml: unable to write value " + paramObject);
  }
  
  private static void a(List paramList, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramList == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    }
    paramXmlSerializer.startTag(null, "list");
    if (paramString != null) {
      paramXmlSerializer.attribute(null, "name", paramString);
    }
    int j = paramList.size();
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        paramXmlSerializer.endTag(null, "list");
        break;
      }
      a(paramList.get(i), null, paramXmlSerializer);
    }
  }
  
  public static final void a(Map paramMap, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramMap == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    paramXmlSerializer.startTag(null, "map");
    if (paramString != null) {
      paramXmlSerializer.attribute(null, "name", paramString);
    }
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        paramXmlSerializer.endTag(null, "map");
        break;
      }
      paramString = (Map.Entry)paramMap.next();
      a(paramString.getValue(), (String)paramString.getKey(), paramXmlSerializer);
    }
  }
  
  private static void a(int[] paramArrayOfInt, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramArrayOfInt == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    }
    paramXmlSerializer.startTag(null, "int-array");
    if (paramString != null) {
      paramXmlSerializer.attribute(null, "name", paramString);
    }
    int j = paramArrayOfInt.length;
    paramXmlSerializer.attribute(null, "num", Integer.toString(j));
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        paramXmlSerializer.endTag(null, "int-array");
        break;
      }
      paramXmlSerializer.startTag(null, "item");
      paramXmlSerializer.attribute(null, "value", Integer.toString(paramArrayOfInt[i]));
      paramXmlSerializer.endTag(null, "item");
    }
  }
  
  private static int[] a(XmlPullParser paramXmlPullParser, String paramString)
  {
    int i;
    int[] arrayOfInt;
    int k;
    try
    {
      i = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "num"));
      arrayOfInt = new int[i];
      i = paramXmlPullParser.getEventType();
      k = 0;
    }
    catch (NullPointerException paramXmlPullParser)
    {
      try
      {
        do
        {
          arrayOfInt[k] = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "value"));
          j = k;
          m = paramXmlPullParser.next();
          k = j;
          i = m;
        } while (m != 1);
        throw new XmlPullParserException("Document ended before " + paramString + " end tag");
      }
      catch (NullPointerException paramXmlPullParser)
      {
        throw new XmlPullParserException("Need value attribute in item");
      }
      catch (NumberFormatException paramXmlPullParser)
      {
        throw new XmlPullParserException("Not a number in value attribute in item");
      }
      paramXmlPullParser = paramXmlPullParser;
      throw new XmlPullParserException("Need num attribute in byte-array");
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      throw new XmlPullParserException("Not a number in num attribute in byte-array");
    }
    if (i == 2) {
      if (!paramXmlPullParser.getName().equals("item")) {}
    }
    for (;;)
    {
      int m;
      throw new XmlPullParserException("Expected item tag at: " + paramXmlPullParser.getName());
      int j = k;
      if (i == 3)
      {
        if (paramXmlPullParser.getName().equals(paramString)) {
          return arrayOfInt;
        }
        if (!paramXmlPullParser.getName().equals("item")) {
          break;
        }
        j = k + 1;
      }
    }
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
  
  private static final Object b(XmlPullParser paramXmlPullParser, String[] paramArrayOfString)
  {
    Object localObject = null;
    String str1 = paramXmlPullParser.getAttributeValue(null, "name");
    String str2 = paramXmlPullParser.getName();
    if (str2.equals("null")) {}
    int i;
    label86:
    label521:
    label562:
    do
    {
      i = paramXmlPullParser.next();
      if (i == 1)
      {
        throw new XmlPullParserException("Unexpected end of document in <" + str2 + ">");
        if (str2.equals("string"))
        {
          localObject = "";
          i = paramXmlPullParser.next();
          if (i == 1) {
            throw new XmlPullParserException("Unexpected end of document in <string>");
          }
          if (i == 3) {
            if (paramXmlPullParser.getName().equals("string")) {
              paramArrayOfString[0] = str1;
            }
          }
        }
      }
      for (;;)
      {
        return localObject;
        throw new XmlPullParserException("Unexpected end tag in <string>: " + paramXmlPullParser.getName());
        if (i == 4)
        {
          localObject = localObject + paramXmlPullParser.getText();
          break label86;
        }
        if (i != 2) {
          break label86;
        }
        throw new XmlPullParserException("Unexpected start tag in <string>: " + paramXmlPullParser.getName());
        if (str2.equals("int"))
        {
          localObject = Integer.valueOf(Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "value")));
          break;
        }
        if (str2.equals("long"))
        {
          localObject = Long.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
          break;
        }
        if (str2.equals("float"))
        {
          localObject = new Float(paramXmlPullParser.getAttributeValue(null, "value"));
          break;
        }
        if (str2.equals("double"))
        {
          localObject = new Double(paramXmlPullParser.getAttributeValue(null, "value"));
          break;
        }
        if (str2.equals("boolean"))
        {
          localObject = Boolean.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
          break;
        }
        if (str2.equals("int-array"))
        {
          paramXmlPullParser.next();
          localObject = a(paramXmlPullParser, "int-array");
          paramArrayOfString[0] = str1;
        }
        else if (str2.equals("map"))
        {
          paramXmlPullParser.next();
          localObject = a(paramXmlPullParser, "map", paramArrayOfString);
          paramArrayOfString[0] = str1;
        }
        else if (str2.equals("list"))
        {
          paramXmlPullParser.next();
          localObject = b(paramXmlPullParser, "list", paramArrayOfString);
          paramArrayOfString[0] = str1;
        }
        else
        {
          throw new XmlPullParserException("Unknown tag: " + str2);
          if (i != 3) {
            break label562;
          }
          if (!paramXmlPullParser.getName().equals(str2)) {
            break label521;
          }
          paramArrayOfString[0] = str1;
        }
      }
      throw new XmlPullParserException("Unexpected end tag in <" + str2 + ">: " + paramXmlPullParser.getName());
      if (i == 4) {
        throw new XmlPullParserException("Unexpected text in <" + str2 + ">: " + paramXmlPullParser.getName());
      }
    } while (i != 2);
    throw new XmlPullParserException("Unexpected start tag in <" + str2 + ">: " + paramXmlPullParser.getName());
  }
  
  private static ArrayList b(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramXmlPullParser.getEventType();
    if (i == 2) {
      localArrayList.add(b(paramXmlPullParser, paramArrayOfString));
    }
    while (i != 3)
    {
      int j = paramXmlPullParser.next();
      i = j;
      if (j != 1) {
        break;
      }
      throw new XmlPullParserException("Document ended before " + paramString + " end tag");
    }
    if (paramXmlPullParser.getName().equals(paramString)) {
      return localArrayList;
    }
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */