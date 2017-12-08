package com.alibaba.fastjson.parser;

public class JSONToken
{
  public static final int COLON = 17;
  public static final int COMMA = 16;
  public static final int EOF = 20;
  public static final int ERROR = 1;
  public static final int FALSE = 7;
  public static final int FIELD_NAME = 19;
  public static final int IDENTIFIER = 18;
  public static final int LBRACE = 12;
  public static final int LBRACKET = 14;
  public static final int LITERAL_FLOAT = 3;
  public static final int LITERAL_INT = 2;
  public static final int LITERAL_ISO8601_DATE = 5;
  public static final int LITERAL_STRING = 4;
  public static final int LPAREN = 10;
  public static final int NEW = 9;
  public static final int NULL = 8;
  public static final int RBRACE = 13;
  public static final int RBRACKET = 15;
  public static final int RPAREN = 11;
  public static final int SET = 21;
  public static final int TREE_SET = 22;
  public static final int TRUE = 6;
  
  public static String name(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "Unkown";
    }
    for (;;)
    {
      return str;
      str = "error";
      continue;
      str = "int";
      continue;
      str = "float";
      continue;
      str = "string";
      continue;
      str = "iso8601";
      continue;
      str = "true";
      continue;
      str = "false";
      continue;
      str = "null";
      continue;
      str = "new";
      continue;
      str = "(";
      continue;
      str = ")";
      continue;
      str = "{";
      continue;
      str = "}";
      continue;
      str = "[";
      continue;
      str = "]";
      continue;
      str = ",";
      continue;
      str = ":";
      continue;
      str = "ident";
      continue;
      str = "fieldName";
      continue;
      str = "EOF";
      continue;
      str = "Set";
      continue;
      str = "TreeSet";
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/JSONToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */