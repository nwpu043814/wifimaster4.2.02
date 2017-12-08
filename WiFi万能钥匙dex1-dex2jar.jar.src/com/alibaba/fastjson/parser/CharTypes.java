package com.alibaba.fastjson.parser;

public final class CharTypes
{
  public static final char[] ASCII_CHARS = { 48, 48, 48, 49, 48, 50, 48, 51, 48, 52, 48, 53, 48, 54, 48, 55, 48, 56, 48, 57, 48, 65, 48, 66, 48, 67, 48, 68, 48, 69, 48, 70, 49, 48, 49, 49, 49, 50, 49, 51, 49, 52, 49, 53, 49, 54, 49, 55, 49, 56, 49, 57, 49, 65, 49, 66, 49, 67, 49, 68, 49, 69, 49, 70, 50, 48, 50, 49, 50, 50, 50, 51, 50, 52, 50, 53, 50, 54, 50, 55, 50, 56, 50, 57, 50, 65, 50, 66, 50, 67, 50, 68, 50, 69, 50, 70 };
  public static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final boolean[] firstIdentifierFlags = new boolean['Ā'];
  public static final boolean[] identifierFlags;
  public static final char[] replaceChars;
  public static final byte[] specicalFlags_doubleQuotes;
  public static final byte[] specicalFlags_singleQuotes;
  
  static
  {
    int i = 0;
    if (i < firstIdentifierFlags.length)
    {
      if ((i >= 65) && (i <= 90)) {
        firstIdentifierFlags[i] = true;
      }
      for (;;)
      {
        i = (char)(i + 1);
        break;
        if ((i >= 97) && (i <= 122)) {
          firstIdentifierFlags[i] = true;
        } else if (i == 95) {
          firstIdentifierFlags[i] = true;
        }
      }
    }
    identifierFlags = new boolean['Ā'];
    i = 0;
    if (i < identifierFlags.length)
    {
      if ((i >= 65) && (i <= 90)) {
        identifierFlags[i] = true;
      }
      for (;;)
      {
        i = (char)(i + 1);
        break;
        if ((i >= 97) && (i <= 122)) {
          identifierFlags[i] = true;
        } else if (i == 95) {
          identifierFlags[i] = true;
        } else if ((i >= 48) && (i <= 57)) {
          identifierFlags[i] = true;
        }
      }
    }
    specicalFlags_doubleQuotes = new byte['Ā'];
    specicalFlags_singleQuotes = new byte['Ā'];
    replaceChars = new char[''];
    specicalFlags_doubleQuotes[0] = 1;
    specicalFlags_doubleQuotes[1] = 1;
    specicalFlags_doubleQuotes[2] = 1;
    specicalFlags_doubleQuotes[3] = 1;
    specicalFlags_doubleQuotes[4] = 1;
    specicalFlags_doubleQuotes[5] = 1;
    specicalFlags_doubleQuotes[6] = 1;
    specicalFlags_doubleQuotes[7] = 1;
    specicalFlags_doubleQuotes[8] = 1;
    specicalFlags_doubleQuotes[9] = 1;
    specicalFlags_doubleQuotes[10] = 1;
    specicalFlags_doubleQuotes[11] = 1;
    specicalFlags_doubleQuotes[12] = 1;
    specicalFlags_doubleQuotes[13] = 1;
    specicalFlags_doubleQuotes[34] = 1;
    specicalFlags_doubleQuotes[92] = 1;
    specicalFlags_singleQuotes[0] = 1;
    specicalFlags_singleQuotes[1] = 1;
    specicalFlags_singleQuotes[2] = 1;
    specicalFlags_singleQuotes[3] = 1;
    specicalFlags_singleQuotes[4] = 1;
    specicalFlags_singleQuotes[5] = 1;
    specicalFlags_singleQuotes[6] = 1;
    specicalFlags_singleQuotes[7] = 1;
    specicalFlags_singleQuotes[8] = 1;
    specicalFlags_singleQuotes[9] = 1;
    specicalFlags_singleQuotes[10] = 1;
    specicalFlags_singleQuotes[11] = 1;
    specicalFlags_singleQuotes[12] = 1;
    specicalFlags_singleQuotes[13] = 1;
    specicalFlags_singleQuotes[14] = 4;
    specicalFlags_singleQuotes[15] = 4;
    specicalFlags_singleQuotes[16] = 4;
    specicalFlags_singleQuotes[17] = 4;
    specicalFlags_singleQuotes[18] = 4;
    specicalFlags_singleQuotes[19] = 4;
    specicalFlags_singleQuotes[20] = 4;
    specicalFlags_singleQuotes[21] = 4;
    specicalFlags_singleQuotes[22] = 4;
    specicalFlags_singleQuotes[23] = 4;
    specicalFlags_singleQuotes[24] = 4;
    specicalFlags_singleQuotes[25] = 4;
    specicalFlags_singleQuotes[32] = 4;
    specicalFlags_singleQuotes[92] = 1;
    specicalFlags_singleQuotes[39] = 1;
    for (i = 127; i <= 160; i++)
    {
      specicalFlags_doubleQuotes[i] = 4;
      specicalFlags_singleQuotes[i] = 4;
    }
    replaceChars[0] = '0';
    replaceChars[1] = '1';
    replaceChars[2] = '2';
    replaceChars[3] = '3';
    replaceChars[4] = '4';
    replaceChars[5] = '5';
    replaceChars[6] = '6';
    replaceChars[7] = '7';
    replaceChars[8] = 'b';
    replaceChars[9] = 't';
    replaceChars[10] = 'n';
    replaceChars[11] = 'v';
    replaceChars[12] = 'f';
    replaceChars[13] = 'r';
    replaceChars[34] = '"';
    replaceChars[39] = '\'';
    replaceChars[47] = '/';
    replaceChars[92] = '\\';
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/CharTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */