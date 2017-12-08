package com.bluefay.c.a;

import org.xmlpull.v1.XmlPullParser;

public final class a
{
  public static void a(XmlPullParser paramXmlPullParser)
  {
    int i = paramXmlPullParser.getDepth();
    int j;
    do
    {
      j = paramXmlPullParser.next();
    } while ((j != 1) && ((j != 3) || (paramXmlPullParser.getDepth() > i)));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */