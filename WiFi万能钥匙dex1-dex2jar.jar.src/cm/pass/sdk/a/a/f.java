package cm.pass.sdk.a.a;

import android.util.Xml;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class f
{
  private static final Object a(XmlPullParser paramXmlPullParser, String paramString)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (paramString.equals("int"))
        {
          localObject = Integer.valueOf(Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "value")));
          return localObject;
        }
        if (paramString.equals("long"))
        {
          localObject = Long.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
          continue;
        }
        if (paramString.equals("float"))
        {
          localObject = new Float(paramXmlPullParser.getAttributeValue(null, "value"));
          continue;
        }
      }
      catch (NullPointerException paramXmlPullParser)
      {
        throw new XmlPullParserException("Need value attribute in <" + paramString + ">");
        if (paramString.equals("double"))
        {
          localObject = new Double(paramXmlPullParser.getAttributeValue(null, "value"));
          continue;
        }
      }
      catch (NumberFormatException paramXmlPullParser)
      {
        throw new XmlPullParserException("Not a number in value attribute in <" + paramString + ">");
      }
      if (paramString.equals("boolean")) {
        localObject = Boolean.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
      }
    }
  }
  
  public static final Object a(XmlPullParser paramXmlPullParser, String[] paramArrayOfString)
  {
    int i = paramXmlPullParser.getEventType();
    int j;
    do
    {
      if (i == 2) {
        return a(paramXmlPullParser, paramArrayOfString, null);
      }
      if (i == 3) {
        throw new XmlPullParserException("Unexpected end tag at: " + paramXmlPullParser.getName());
      }
      if (i == 4) {
        throw new XmlPullParserException("Unexpected text: " + paramXmlPullParser.getText());
      }
      j = paramXmlPullParser.next();
      i = j;
    } while (j != 1);
    throw new XmlPullParserException("Unexpected end of document");
  }
  
  private static final Object a(XmlPullParser paramXmlPullParser, String[] paramArrayOfString, a parama)
  {
    String str1 = paramXmlPullParser.getAttributeValue(null, "name");
    String str2 = paramXmlPullParser.getName();
    Object localObject1;
    if (str2.equals("null")) {
      localObject1 = null;
    }
    int i;
    label188:
    label222:
    label474:
    do
    {
      i = paramXmlPullParser.next();
      if (i == 1) {
        break;
      }
      if (i == 3)
      {
        if (paramXmlPullParser.getName().equals(str2))
        {
          paramArrayOfString[0] = str1;
          paramXmlPullParser = (XmlPullParser)localObject1;
          for (;;)
          {
            return paramXmlPullParser;
            if (str2.equals("string"))
            {
              parama = "";
              do
              {
                for (;;)
                {
                  i = paramXmlPullParser.next();
                  if (i == 1) {
                    break label222;
                  }
                  if (i == 3)
                  {
                    if (paramXmlPullParser.getName().equals("string"))
                    {
                      paramArrayOfString[0] = str1;
                      paramXmlPullParser = parama;
                      break;
                    }
                    throw new XmlPullParserException("Unexpected end tag in <string>: " + paramXmlPullParser.getName());
                  }
                  if (i != 4) {
                    break label188;
                  }
                  parama = parama + paramXmlPullParser.getText();
                }
              } while (i != 2);
              throw new XmlPullParserException("Unexpected start tag in <string>: " + paramXmlPullParser.getName());
              throw new XmlPullParserException("Unexpected end of document in <string>");
            }
            Object localObject2 = a(paramXmlPullParser, str2);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            if (str2.equals("int-array"))
            {
              paramXmlPullParser = d(paramXmlPullParser, "int-array", paramArrayOfString);
              paramArrayOfString[0] = str1;
            }
            else if (str2.equals("long-array"))
            {
              paramXmlPullParser = e(paramXmlPullParser, "long-array", paramArrayOfString);
              paramArrayOfString[0] = str1;
            }
            else if (str2.equals("double-array"))
            {
              paramXmlPullParser = f(paramXmlPullParser, "double-array", paramArrayOfString);
              paramArrayOfString[0] = str1;
            }
            else if (str2.equals("string-array"))
            {
              paramXmlPullParser = g(paramXmlPullParser, "string-array", paramArrayOfString);
              paramArrayOfString[0] = str1;
            }
            else if (str2.equals("map"))
            {
              paramXmlPullParser.next();
              paramXmlPullParser = a(paramXmlPullParser, "map", paramArrayOfString);
              paramArrayOfString[0] = str1;
            }
            else if (str2.equals("list"))
            {
              paramXmlPullParser.next();
              paramXmlPullParser = b(paramXmlPullParser, "list", paramArrayOfString);
              paramArrayOfString[0] = str1;
            }
            else if (str2.equals("set"))
            {
              paramXmlPullParser.next();
              paramXmlPullParser = c(paramXmlPullParser, "set", paramArrayOfString);
              paramArrayOfString[0] = str1;
            }
            else
            {
              if (parama == null) {
                break label474;
              }
              paramXmlPullParser = parama.a(paramXmlPullParser, str2);
              paramArrayOfString[0] = str1;
            }
          }
          throw new XmlPullParserException("Unknown tag: " + str2);
        }
        throw new XmlPullParserException("Unexpected end tag in <" + str2 + ">: " + paramXmlPullParser.getName());
      }
      if (i == 4) {
        throw new XmlPullParserException("Unexpected text in <" + str2 + ">: " + paramXmlPullParser.getName());
      }
    } while (i != 2);
    throw new XmlPullParserException("Unexpected start tag in <" + str2 + ">: " + paramXmlPullParser.getName());
    throw new XmlPullParserException("Unexpected end of document in <" + str2 + ">");
  }
  
  public static final HashMap<String, ?> a(InputStream paramInputStream)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    localXmlPullParser.setInput(paramInputStream, null);
    return (HashMap)a(localXmlPullParser, new String[1]);
  }
  
  public static final HashMap<String, ?> a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    return a(paramXmlPullParser, paramString, paramArrayOfString, null);
  }
  
  public static final HashMap<String, ?> a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString, a parama)
  {
    HashMap localHashMap = new HashMap();
    int i = paramXmlPullParser.getEventType();
    if (i == 2)
    {
      localObject = a(paramXmlPullParser, paramArrayOfString, parama);
      localHashMap.put(paramArrayOfString[0], localObject);
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
    }
    if (paramXmlPullParser.getName().equals(paramString)) {
      return localHashMap;
    }
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
  
  public static final void a(Object paramObject, String paramString, XmlSerializer paramXmlSerializer)
  {
    a(paramObject, paramString, paramXmlSerializer, null);
  }
  
  private static final void a(Object paramObject, String paramString, XmlSerializer paramXmlSerializer, b paramb)
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
        if ((paramObject instanceof Integer)) {
          paramb = "int";
        }
        for (;;)
        {
          paramXmlSerializer.startTag(null, paramb);
          if (paramString != null) {
            paramXmlSerializer.attribute(null, "name", paramString);
          }
          paramXmlSerializer.attribute(null, "value", paramObject.toString());
          paramXmlSerializer.endTag(null, paramb);
          break;
          if ((paramObject instanceof Long))
          {
            paramb = "long";
          }
          else if ((paramObject instanceof Float))
          {
            paramb = "float";
          }
          else if ((paramObject instanceof Double))
          {
            paramb = "double";
          }
          else
          {
            if (!(paramObject instanceof Boolean)) {
              break label208;
            }
            paramb = "boolean";
          }
        }
        label208:
        if ((paramObject instanceof byte[]))
        {
          a((byte[])paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof int[]))
        {
          a((int[])paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof long[]))
        {
          a((long[])paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof double[]))
        {
          a((double[])paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof String[]))
        {
          a((String[])paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof Map))
        {
          a((Map)paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof List))
        {
          a((List)paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof Set))
        {
          a((Set)paramObject, paramString, paramXmlSerializer);
        }
        else if ((paramObject instanceof CharSequence))
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
          if (paramb == null) {
            break;
          }
          paramb.a(paramObject, paramString, paramXmlSerializer);
        }
      }
    }
    throw new RuntimeException("writeValueXml: unable to write value " + paramObject);
  }
  
  public static final void a(List paramList, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramList == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
    }
    for (;;)
    {
      return;
      paramXmlSerializer.startTag(null, "list");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      int j = paramList.size();
      for (int i = 0; i < j; i++) {
        a(paramList.get(i), null, paramXmlSerializer);
      }
      paramXmlSerializer.endTag(null, "list");
    }
  }
  
  public static final void a(Map paramMap, OutputStream paramOutputStream)
  {
    b localb = new b();
    localb.setOutput(paramOutputStream, "utf-8");
    localb.startDocument(null, Boolean.valueOf(true));
    localb.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
    a(paramMap, null, localb);
    localb.endDocument();
  }
  
  public static final void a(Map paramMap, String paramString, XmlSerializer paramXmlSerializer)
  {
    a(paramMap, paramString, paramXmlSerializer, null);
  }
  
  public static final void a(Map paramMap, String paramString, XmlSerializer paramXmlSerializer, b paramb)
  {
    if (paramMap == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
    }
    for (;;)
    {
      return;
      paramXmlSerializer.startTag(null, "map");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      a(paramMap, paramXmlSerializer, paramb);
      paramXmlSerializer.endTag(null, "map");
    }
  }
  
  public static final void a(Map paramMap, XmlSerializer paramXmlSerializer, b paramb)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        a(paramMap.getValue(), (String)paramMap.getKey(), paramXmlSerializer, paramb);
      }
    }
  }
  
  public static final void a(Set paramSet, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramSet == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
    }
    for (;;)
    {
      return;
      paramXmlSerializer.startTag(null, "set");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        a(paramSet.next(), null, paramXmlSerializer);
      }
      paramXmlSerializer.endTag(null, "set");
    }
  }
  
  public static final void a(byte[] paramArrayOfByte, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramArrayOfByte == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
    }
    for (;;)
    {
      return;
      paramXmlSerializer.startTag(null, "byte-array");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      int k = paramArrayOfByte.length;
      paramXmlSerializer.attribute(null, "num", Integer.toString(k));
      paramString = new StringBuilder(paramArrayOfByte.length * 2);
      int i = 0;
      if (i < k)
      {
        int m = paramArrayOfByte[i];
        int j = m >> 4;
        if (j >= 10)
        {
          j = j + 97 - 10;
          label119:
          paramString.append(j);
          j = m & 0xFF;
          if (j < 10) {
            break label170;
          }
        }
        label170:
        for (j = j + 97 - 10;; j += 48)
        {
          paramString.append(j);
          i++;
          break;
          j += 48;
          break label119;
        }
      }
      paramXmlSerializer.text(paramString.toString());
      paramXmlSerializer.endTag(null, "byte-array");
    }
  }
  
  public static final void a(double[] paramArrayOfDouble, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramArrayOfDouble == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
    }
    for (;;)
    {
      return;
      paramXmlSerializer.startTag(null, "double-array");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      int j = paramArrayOfDouble.length;
      paramXmlSerializer.attribute(null, "num", Integer.toString(j));
      for (int i = 0; i < j; i++)
      {
        paramXmlSerializer.startTag(null, "item");
        paramXmlSerializer.attribute(null, "value", Double.toString(paramArrayOfDouble[i]));
        paramXmlSerializer.endTag(null, "item");
      }
      paramXmlSerializer.endTag(null, "double-array");
    }
  }
  
  public static final void a(int[] paramArrayOfInt, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramArrayOfInt == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
    }
    for (;;)
    {
      return;
      paramXmlSerializer.startTag(null, "int-array");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      int j = paramArrayOfInt.length;
      paramXmlSerializer.attribute(null, "num", Integer.toString(j));
      for (int i = 0; i < j; i++)
      {
        paramXmlSerializer.startTag(null, "item");
        paramXmlSerializer.attribute(null, "value", Integer.toString(paramArrayOfInt[i]));
        paramXmlSerializer.endTag(null, "item");
      }
      paramXmlSerializer.endTag(null, "int-array");
    }
  }
  
  public static final void a(long[] paramArrayOfLong, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramArrayOfLong == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
    }
    for (;;)
    {
      return;
      paramXmlSerializer.startTag(null, "long-array");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      int j = paramArrayOfLong.length;
      paramXmlSerializer.attribute(null, "num", Integer.toString(j));
      for (int i = 0; i < j; i++)
      {
        paramXmlSerializer.startTag(null, "item");
        paramXmlSerializer.attribute(null, "value", Long.toString(paramArrayOfLong[i]));
        paramXmlSerializer.endTag(null, "item");
      }
      paramXmlSerializer.endTag(null, "long-array");
    }
  }
  
  public static final void a(String[] paramArrayOfString, String paramString, XmlSerializer paramXmlSerializer)
  {
    if (paramArrayOfString == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
    }
    for (;;)
    {
      return;
      paramXmlSerializer.startTag(null, "string-array");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      int j = paramArrayOfString.length;
      paramXmlSerializer.attribute(null, "num", Integer.toString(j));
      for (int i = 0; i < j; i++)
      {
        paramXmlSerializer.startTag(null, "item");
        paramXmlSerializer.attribute(null, "value", paramArrayOfString[i]);
        paramXmlSerializer.endTag(null, "item");
      }
      paramXmlSerializer.endTag(null, "string-array");
    }
  }
  
  public static final ArrayList b(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    return b(paramXmlPullParser, paramString, paramArrayOfString, null);
  }
  
  private static final ArrayList b(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString, a parama)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramXmlPullParser.getEventType();
    if (i == 2) {
      localArrayList.add(a(paramXmlPullParser, paramArrayOfString, parama));
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
  
  public static final HashSet c(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    return c(paramXmlPullParser, paramString, paramArrayOfString, null);
  }
  
  private static final HashSet c(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString, a parama)
  {
    HashSet localHashSet = new HashSet();
    int i = paramXmlPullParser.getEventType();
    if (i == 2) {
      localHashSet.add(a(paramXmlPullParser, paramArrayOfString, parama));
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
      return localHashSet;
    }
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
  
  public static final int[] d(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    int i;
    int j;
    try
    {
      i = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "num"));
      paramXmlPullParser.next();
      paramArrayOfString = new int[i];
      i = paramXmlPullParser.getEventType();
      j = 0;
    }
    catch (NullPointerException paramXmlPullParser)
    {
      try
      {
        do
        {
          paramArrayOfString[j] = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "value"));
          k = j;
          m = paramXmlPullParser.next();
          j = k;
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
      int k = j;
      if (i == 3)
      {
        if (paramXmlPullParser.getName().equals(paramString)) {
          return paramArrayOfString;
        }
        if (!paramXmlPullParser.getName().equals("item")) {
          break;
        }
        k = j + 1;
      }
    }
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
  
  public static final long[] e(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    int i;
    int j;
    try
    {
      i = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "num"));
      paramXmlPullParser.next();
      paramArrayOfString = new long[i];
      i = paramXmlPullParser.getEventType();
      j = 0;
    }
    catch (NullPointerException paramXmlPullParser)
    {
      try
      {
        do
        {
          paramArrayOfString[j] = Long.parseLong(paramXmlPullParser.getAttributeValue(null, "value"));
          k = j;
          m = paramXmlPullParser.next();
          j = k;
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
      throw new XmlPullParserException("Need num attribute in long-array");
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      throw new XmlPullParserException("Not a number in num attribute in long-array");
    }
    if (i == 2) {
      if (!paramXmlPullParser.getName().equals("item")) {}
    }
    for (;;)
    {
      int m;
      throw new XmlPullParserException("Expected item tag at: " + paramXmlPullParser.getName());
      int k = j;
      if (i == 3)
      {
        if (paramXmlPullParser.getName().equals(paramString)) {
          return paramArrayOfString;
        }
        if (!paramXmlPullParser.getName().equals("item")) {
          break;
        }
        k = j + 1;
      }
    }
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
  
  public static final double[] f(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    int i;
    int j;
    try
    {
      i = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "num"));
      paramXmlPullParser.next();
      paramArrayOfString = new double[i];
      i = paramXmlPullParser.getEventType();
      j = 0;
    }
    catch (NullPointerException paramXmlPullParser)
    {
      try
      {
        do
        {
          paramArrayOfString[j] = Double.parseDouble(paramXmlPullParser.getAttributeValue(null, "value"));
          k = j;
          m = paramXmlPullParser.next();
          j = k;
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
      throw new XmlPullParserException("Need num attribute in double-array");
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      throw new XmlPullParserException("Not a number in num attribute in double-array");
    }
    if (i == 2) {
      if (!paramXmlPullParser.getName().equals("item")) {}
    }
    for (;;)
    {
      int m;
      throw new XmlPullParserException("Expected item tag at: " + paramXmlPullParser.getName());
      int k = j;
      if (i == 3)
      {
        if (paramXmlPullParser.getName().equals(paramString)) {
          return paramArrayOfString;
        }
        if (!paramXmlPullParser.getName().equals("item")) {
          break;
        }
        k = j + 1;
      }
    }
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
  
  public static final String[] g(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    int i;
    int j;
    try
    {
      i = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "num"));
      paramXmlPullParser.next();
      paramArrayOfString = new String[i];
      i = paramXmlPullParser.getEventType();
      j = 0;
    }
    catch (NullPointerException paramXmlPullParser)
    {
      try
      {
        do
        {
          paramArrayOfString[j] = paramXmlPullParser.getAttributeValue(null, "value");
          k = j;
          m = paramXmlPullParser.next();
          j = k;
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
      throw new XmlPullParserException("Need num attribute in string-array");
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      throw new XmlPullParserException("Not a number in num attribute in string-array");
    }
    if (i == 2) {
      if (!paramXmlPullParser.getName().equals("item")) {}
    }
    for (;;)
    {
      int m;
      throw new XmlPullParserException("Expected item tag at: " + paramXmlPullParser.getName());
      int k = j;
      if (i == 3)
      {
        if (paramXmlPullParser.getName().equals(paramString)) {
          return paramArrayOfString;
        }
        if (!paramXmlPullParser.getName().equals("item")) {
          break;
        }
        k = j + 1;
      }
    }
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
  
  public static abstract interface a
  {
    public abstract Object a(XmlPullParser paramXmlPullParser, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void a(Object paramObject, String paramString, XmlSerializer paramXmlSerializer);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */