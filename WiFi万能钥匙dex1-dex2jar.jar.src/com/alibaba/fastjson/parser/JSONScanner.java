package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.Base64;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public final class JSONScanner
  extends JSONLexerBase
{
  protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
  public final int ISO8601_LEN_0 = 10;
  public final int ISO8601_LEN_1 = 19;
  public final int ISO8601_LEN_2 = 23;
  private final String text;
  
  public JSONScanner(String paramString)
  {
    this(paramString, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONScanner(String paramString, int paramInt)
  {
    this.features = paramInt;
    this.text = paramString;
    this.bp = -1;
    next();
    if (this.ch == 65279) {
      next();
    }
  }
  
  public JSONScanner(char[] paramArrayOfChar, int paramInt)
  {
    this(paramArrayOfChar, paramInt, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONScanner(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this(new String(paramArrayOfChar, 0, paramInt1), paramInt2);
  }
  
  static final boolean charArrayCompare(String paramString, int paramInt, char[] paramArrayOfChar)
  {
    boolean bool2 = false;
    int j = paramArrayOfChar.length;
    boolean bool1;
    if (j + paramInt > paramString.length()) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      for (int i = 0;; i++)
      {
        if (i >= j) {
          break label56;
        }
        bool1 = bool2;
        if (paramArrayOfChar[i] != paramString.charAt(paramInt + i)) {
          break;
        }
      }
      label56:
      bool1 = true;
    }
  }
  
  static boolean checkDate(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramChar1 != '1') && (paramChar1 != '2')) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramChar2 >= '0')
      {
        bool1 = bool2;
        if (paramChar2 <= '9')
        {
          bool1 = bool2;
          if (paramChar3 >= '0')
          {
            bool1 = bool2;
            if (paramChar3 <= '9')
            {
              bool1 = bool2;
              if (paramChar4 >= '0')
              {
                bool1 = bool2;
                if (paramChar4 <= '9')
                {
                  if (paramChar5 == '0')
                  {
                    bool1 = bool2;
                    if (paramChar6 < '1') {
                      continue;
                    }
                    bool1 = bool2;
                    if (paramChar6 > '9') {
                      continue;
                    }
                    label111:
                    if (paramInt1 != 48) {
                      break label185;
                    }
                    bool1 = bool2;
                    if (paramInt2 < 49) {
                      continue;
                    }
                    bool1 = bool2;
                    if (paramInt2 > 57) {
                      continue;
                    }
                  }
                  label185:
                  label224:
                  do
                  {
                    do
                    {
                      bool1 = true;
                      break;
                      bool1 = bool2;
                      if (paramChar5 != '1') {
                        break;
                      }
                      if ((paramChar6 == '0') || (paramChar6 == '1') || (paramChar6 == '2')) {
                        break label111;
                      }
                      bool1 = bool2;
                      break;
                      if ((paramInt1 != 49) && (paramInt1 != 50)) {
                        break label224;
                      }
                      bool1 = bool2;
                      if (paramInt2 < 48) {
                        break;
                      }
                    } while (paramInt2 <= 57);
                    bool1 = bool2;
                    break;
                    bool1 = bool2;
                    if (paramInt1 != 51) {
                      break;
                    }
                  } while ((paramInt2 == 48) || (paramInt2 == 49));
                  bool1 = bool2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean checkTime(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramChar1 == '0')
    {
      bool1 = bool2;
      if (paramChar2 >= '0')
      {
        if (paramChar2 <= '9') {
          break label58;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      if (paramChar1 == '1')
      {
        bool1 = bool2;
        if (paramChar2 < '0') {
          continue;
        }
        bool1 = bool2;
        if (paramChar2 > '9') {
          continue;
        }
        label58:
        if ((paramChar3 < '0') || (paramChar3 > '5')) {
          break label167;
        }
        bool1 = bool2;
        if (paramChar4 < '0') {
          continue;
        }
        bool1 = bool2;
        if (paramChar4 > '9') {
          continue;
        }
        label92:
        if ((paramChar5 < '0') || (paramChar5 > '5')) {
          break label191;
        }
        bool1 = bool2;
        if (paramChar6 < '0') {
          continue;
        }
        bool1 = bool2;
        if (paramChar6 > '9') {
          continue;
        }
      }
      label167:
      label191:
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (paramChar1 != '2') {
          break;
        }
        bool1 = bool2;
        if (paramChar2 < '0') {
          break;
        }
        if (paramChar2 <= '4') {
          break label58;
        }
        bool1 = bool2;
        break;
        bool1 = bool2;
        if (paramChar3 != '6') {
          break;
        }
        if (paramChar4 == '0') {
          break label92;
        }
        bool1 = bool2;
        break;
        bool1 = bool2;
        if (paramChar5 != '6') {
          break;
        }
      } while (paramChar6 == '0');
      bool1 = bool2;
    }
  }
  
  private void setCalendar(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, char paramChar7, char paramChar8)
  {
    Locale localLocale = Locale.getDefault();
    this.calendar = Calendar.getInstance(TimeZone.getDefault(), localLocale);
    paramChar1 = digits[paramChar1];
    paramChar2 = digits[paramChar2];
    paramChar3 = digits[paramChar3];
    paramChar4 = digits[paramChar4];
    paramChar5 = digits[paramChar5];
    paramChar6 = digits[paramChar6];
    paramChar7 = digits[paramChar7];
    paramChar8 = digits[paramChar8];
    this.calendar.set(1, paramChar1 * 'Ϩ' + paramChar2 * 'd' + paramChar3 * '\n' + paramChar4);
    this.calendar.set(2, paramChar5 * '\n' + paramChar6 - 1);
    this.calendar.set(5, paramChar7 * '\n' + paramChar8);
  }
  
  public final String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable)
  {
    return paramSymbolTable.addSymbol(this.text, paramInt1, paramInt2, paramInt3);
  }
  
  protected final void arrayCopy(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    this.text.getChars(paramInt1, paramInt1 + paramInt3, paramArrayOfChar, paramInt2);
  }
  
  public final byte[] bytesValue()
  {
    return Base64.decodeFast(this.text, this.np + 1, this.sp);
  }
  
  public final boolean charArrayCompare(char[] paramArrayOfChar)
  {
    return charArrayCompare(this.text, this.bp, paramArrayOfChar);
  }
  
  public final char charAt(int paramInt)
  {
    if (paramInt >= this.text.length()) {}
    for (char c = '\032';; c = this.text.charAt(paramInt)) {
      return c;
    }
  }
  
  protected final void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    this.text.getChars(paramInt1, paramInt1 + paramInt2, paramArrayOfChar, 0);
  }
  
  public final int indexOf(char paramChar, int paramInt)
  {
    return this.text.indexOf(paramChar, paramInt);
  }
  
  public final boolean isEOF()
  {
    if ((this.bp == this.text.length()) || ((this.ch == '\032') && (this.bp + 1 == this.text.length()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final char next()
  {
    int i = this.bp + 1;
    this.bp = i;
    char c = charAt(i);
    this.ch = c;
    return c;
  }
  
  public final String numberString()
  {
    int k = charAt(this.np + this.sp - 1);
    int j = this.sp;
    int i;
    if ((k != 76) && (k != 83) && (k != 66) && (k != 70))
    {
      i = j;
      if (k != 68) {}
    }
    else
    {
      i = j - 1;
    }
    return this.text.substring(this.np, i + this.np);
  }
  
  public final boolean scanFieldBoolean(char[] paramArrayOfChar)
  {
    boolean bool2 = false;
    this.matchStat = 0;
    boolean bool1;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      int j = this.bp + paramArrayOfChar.length;
      int i = j + 1;
      j = charAt(j);
      if (j == 116)
      {
        j = i + 1;
        if (charAt(i) != 'r')
        {
          this.matchStat = -1;
          bool1 = bool2;
        }
        else
        {
          i = j + 1;
          if (charAt(j) != 'u')
          {
            this.matchStat = -1;
            bool1 = bool2;
          }
          else if (charAt(i) != 'e')
          {
            this.matchStat = -1;
            bool1 = bool2;
          }
          else
          {
            this.bp = (i + 1);
            i = charAt(this.bp);
            bool1 = true;
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i == 44)
          {
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
            this.matchStat = 3;
            this.token = 16;
            break;
            if (j == 102)
            {
              j = i + 1;
              if (charAt(i) != 'a')
              {
                this.matchStat = -1;
                bool1 = bool2;
                break;
              }
              i = j + 1;
              if (charAt(j) != 'l')
              {
                this.matchStat = -1;
                bool1 = bool2;
                break;
              }
              j = i + 1;
              if (charAt(i) != 's')
              {
                this.matchStat = -1;
                bool1 = bool2;
                break;
              }
              if (charAt(j) != 'e')
              {
                this.matchStat = -1;
                bool1 = bool2;
                break;
              }
              this.bp = (j + 1);
              i = charAt(this.bp);
              bool1 = false;
              continue;
            }
            this.matchStat = -1;
            bool1 = bool2;
            break;
          }
        }
        if (i == 125)
        {
          i = this.bp + 1;
          this.bp = i;
          i = charAt(i);
          if (i == 44)
          {
            this.token = 16;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          }
          for (;;)
          {
            this.matchStat = 4;
            break;
            if (i == 93)
            {
              this.token = 15;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else if (i == 125)
            {
              this.token = 13;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else
            {
              if (i != 26) {
                break label486;
              }
              this.token = 20;
            }
          }
          label486:
          this.matchStat = -1;
          bool1 = bool2;
        }
        else
        {
          this.matchStat = -1;
          bool1 = bool2;
        }
      }
    }
  }
  
  public final int scanFieldInt(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    int m = this.bp;
    char c = this.ch;
    int i;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      i = 0;
    }
    for (;;)
    {
      return i;
      int j = this.bp + paramArrayOfChar.length;
      i = j + 1;
      j = charAt(j);
      int n;
      if ((j >= 48) && (j <= 57))
      {
        j = digits[j];
        int k;
        for (;;)
        {
          k = i + 1;
          n = charAt(i);
          if ((n < 48) || (n > 57)) {
            break;
          }
          j = j * 10 + digits[n];
          i = k;
        }
        if (n == 46)
        {
          this.matchStat = -1;
          i = 0;
          continue;
        }
        this.bp = (k - 1);
        if (j < 0)
        {
          this.matchStat = -1;
          i = 0;
        }
      }
      else
      {
        this.matchStat = -1;
        i = 0;
        continue;
      }
      if (n == 44)
      {
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
        this.matchStat = 3;
        this.token = 16;
        i = j;
      }
      else
      {
        i = j;
        if (n == 125)
        {
          i = this.bp + 1;
          this.bp = i;
          i = charAt(i);
          if (i == 44)
          {
            this.token = 16;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          }
          for (;;)
          {
            this.matchStat = 4;
            i = j;
            break;
            if (i == 93)
            {
              this.token = 15;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else if (i == 125)
            {
              this.token = 13;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else
            {
              if (i != 26) {
                break label385;
              }
              this.token = 20;
            }
          }
          label385:
          this.bp = m;
          this.ch = c;
          this.matchStat = -1;
          i = 0;
        }
      }
    }
  }
  
  public final long scanFieldLong(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    int k = this.bp;
    char c = this.ch;
    long l;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      l = 0L;
    }
    for (;;)
    {
      return l;
      int j = this.bp + paramArrayOfChar.length;
      int i = j + 1;
      j = charAt(j);
      if ((j >= 48) && (j <= 57))
      {
        l = digits[j];
        for (;;)
        {
          j = i + 1;
          i = charAt(i);
          if ((i < 48) || (i > 57)) {
            break;
          }
          l = l * 10L + digits[i];
          i = j;
        }
        if (i == 46)
        {
          this.matchStat = -1;
          l = 0L;
          continue;
        }
        this.bp = (j - 1);
        if (l < 0L)
        {
          this.bp = k;
          this.ch = c;
          this.matchStat = -1;
          l = 0L;
        }
      }
      else
      {
        this.bp = k;
        this.ch = c;
        this.matchStat = -1;
        l = 0L;
        continue;
      }
      if (i == 44)
      {
        i = this.bp + 1;
        this.bp = i;
        charAt(i);
        this.matchStat = 3;
        this.token = 16;
      }
      else if (i == 125)
      {
        i = this.bp + 1;
        this.bp = i;
        i = charAt(i);
        if (i == 44)
        {
          this.token = 16;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        }
        for (;;)
        {
          this.matchStat = 4;
          break;
          if (i == 93)
          {
            this.token = 15;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          }
          else if (i == 125)
          {
            this.token = 13;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          }
          else
          {
            if (i != 26) {
              break label398;
            }
            this.token = 20;
          }
        }
        label398:
        this.bp = k;
        this.ch = c;
        this.matchStat = -1;
        l = 0L;
      }
      else
      {
        this.matchStat = -1;
        l = 0L;
      }
    }
  }
  
  public final String scanFieldString(char[] paramArrayOfChar)
  {
    int k = 0;
    this.matchStat = 0;
    int m = this.bp;
    char c2 = this.ch;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      paramArrayOfChar = stringDefaultValue();
    }
    for (;;)
    {
      return paramArrayOfChar;
      int j = this.bp + paramArrayOfChar.length;
      int i = j + 1;
      if (charAt(j) != '"')
      {
        this.matchStat = -1;
        paramArrayOfChar = stringDefaultValue();
      }
      else
      {
        int n = this.text.indexOf('"', i);
        if (n == -1) {
          throw new JSONException("unclosed str");
        }
        paramArrayOfChar = subString(i, n - i);
        for (j = 0;; j++)
        {
          i = k;
          if (j < paramArrayOfChar.length())
          {
            if (paramArrayOfChar.charAt(j) == '\\') {
              i = 1;
            }
          }
          else
          {
            if (i == 0) {
              break label181;
            }
            this.matchStat = -1;
            paramArrayOfChar = stringDefaultValue();
            break;
          }
        }
        label181:
        this.bp = (n + 1);
        char c1 = charAt(this.bp);
        this.ch = c1;
        if (c1 == ',')
        {
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
          this.matchStat = 3;
        }
        else if (c1 == '}')
        {
          i = this.bp + 1;
          this.bp = i;
          i = charAt(i);
          if (i == 44)
          {
            this.token = 16;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          }
          for (;;)
          {
            this.matchStat = 4;
            break;
            if (i == 93)
            {
              this.token = 15;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else if (i == 125)
            {
              this.token = 13;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else
            {
              if (i != 26) {
                break label410;
              }
              this.token = 20;
            }
          }
          label410:
          this.bp = m;
          this.ch = c2;
          this.matchStat = -1;
          paramArrayOfChar = stringDefaultValue();
        }
        else
        {
          this.matchStat = -1;
          paramArrayOfChar = stringDefaultValue();
        }
      }
    }
  }
  
  public final Collection<String> scanFieldStringArray(char[] paramArrayOfChar, Class<?> paramClass)
  {
    this.matchStat = 0;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      paramArrayOfChar = null;
    }
    int j;
    for (;;)
    {
      return paramArrayOfChar;
      if (paramClass.isAssignableFrom(HashSet.class)) {
        paramClass = new HashSet();
      }
      for (;;)
      {
        i = this.bp;
        j = paramArrayOfChar.length + i;
        i = j + 1;
        if (charAt(j) != '[')
        {
          this.matchStat = -1;
          paramArrayOfChar = null;
          break;
          if (paramClass.isAssignableFrom(ArrayList.class))
          {
            paramClass = new ArrayList();
            continue;
          }
          try
          {
            paramClass = (Collection)paramClass.newInstance();
          }
          catch (Exception paramArrayOfChar)
          {
            throw new JSONException(paramArrayOfChar.getMessage(), paramArrayOfChar);
          }
        }
      }
      label132:
      j = i + 1;
      if (charAt(i) == '"') {
        break;
      }
      this.matchStat = -1;
      paramArrayOfChar = null;
    }
    int k;
    for (int i = j;; i = k)
    {
      k = i + 1;
      i = charAt(i);
      if (i == 34)
      {
        paramClass.add(this.text.substring(j, k - 1));
        j = k + 1;
        k = charAt(k);
        i = j;
        if (k == 44) {
          break label132;
        }
        if (k != 93) {
          break label298;
        }
        i = charAt(j);
        this.bp = (j + 1);
        if (i != 44) {
          break label308;
        }
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        paramArrayOfChar = paramClass;
        break;
      }
      if (i == 92)
      {
        this.matchStat = -1;
        paramArrayOfChar = null;
        break;
        label298:
        this.matchStat = -1;
        paramArrayOfChar = null;
        break;
        label308:
        if (i == 125)
        {
          char c = charAt(this.bp);
          if (c == ',')
          {
            this.token = 16;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          }
          for (;;)
          {
            this.matchStat = 4;
            paramArrayOfChar = paramClass;
            break;
            if (c == ']')
            {
              this.token = 15;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else if (c == '}')
            {
              this.token = 13;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else
            {
              if (c != '\032') {
                break label468;
              }
              this.token = 20;
              this.ch = c;
            }
          }
          label468:
          this.matchStat = -1;
          paramArrayOfChar = null;
          break;
        }
        this.matchStat = -1;
        paramArrayOfChar = null;
        break;
      }
    }
  }
  
  public final String scanFieldSymbol(char[] paramArrayOfChar, SymbolTable paramSymbolTable)
  {
    int i = 0;
    this.matchStat = 0;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar)) {
      this.matchStat = -2;
    }
    int k;
    for (paramArrayOfChar = null;; paramArrayOfChar = null)
    {
      return paramArrayOfChar;
      j = this.bp + paramArrayOfChar.length;
      k = j + 1;
      if (charAt(j) == '"') {
        break;
      }
      this.matchStat = -1;
    }
    int m;
    for (int j = k;; j = m)
    {
      m = j + 1;
      j = charAt(j);
      char c;
      if (j == 34)
      {
        this.bp = m;
        c = charAt(this.bp);
        this.ch = c;
        paramArrayOfChar = paramSymbolTable.addSymbol(this.text, k, m - k - 1, i);
        if (c != ',') {
          break label199;
        }
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
        this.matchStat = 3;
        break;
      }
      i = i * 31 + j;
      if (j == 92)
      {
        this.matchStat = -1;
        paramArrayOfChar = null;
        break;
        label199:
        if (c == '}')
        {
          i = this.bp + 1;
          this.bp = i;
          i = charAt(i);
          if (i == 44)
          {
            this.token = 16;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          }
          for (;;)
          {
            this.matchStat = 4;
            break;
            if (i == 93)
            {
              this.token = 15;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else if (i == 125)
            {
              this.token = 13;
              i = this.bp + 1;
              this.bp = i;
              this.ch = charAt(i);
            }
            else
            {
              if (i != 26) {
                break label368;
              }
              this.token = 20;
            }
          }
          label368:
          this.matchStat = -1;
          paramArrayOfChar = null;
          break;
        }
        this.matchStat = -1;
        paramArrayOfChar = null;
        break;
      }
    }
  }
  
  public final boolean scanISO8601DateIfMatch()
  {
    return scanISO8601DateIfMatch(true);
  }
  
  public final boolean scanISO8601DateIfMatch(boolean paramBoolean)
  {
    int m = this.text.length() - this.bp;
    int i;
    int n;
    int i2;
    int k;
    int j;
    int i1;
    if ((!paramBoolean) && (m > 13))
    {
      i = charAt(this.bp);
      int i4 = charAt(this.bp + 1);
      n = charAt(this.bp + 2);
      i2 = charAt(this.bp + 3);
      k = charAt(this.bp + 4);
      j = charAt(this.bp + 5);
      i1 = charAt(this.bp + m - 1);
      int i3 = charAt(this.bp + m - 2);
      if ((i == 47) && (i4 == 68) && (n == 97) && (i2 == 116) && (k == 101) && (j == 40) && (i1 == 47) && (i3 == 41))
      {
        j = -1;
        i = 6;
        if (i < m)
        {
          n = charAt(this.bp + i);
          if (n == 43) {
            k = i;
          }
          do
          {
            i++;
            j = k;
            break;
            if (n < 48) {
              break label247;
            }
            k = j;
          } while (n <= 57);
        }
        label247:
        if (j == -1) {
          paramBoolean = false;
        }
      }
    }
    for (;;)
    {
      return paramBoolean;
      i = this.bp + 6;
      long l = Long.parseLong(subString(i, j - i));
      Locale localLocale = Locale.getDefault();
      this.calendar = Calendar.getInstance(TimeZone.getDefault(), localLocale);
      this.calendar.setTimeInMillis(l);
      this.token = 5;
      paramBoolean = true;
      continue;
      char c7;
      char c2;
      char c5;
      char c6;
      char c4;
      char c3;
      char c1;
      char c8;
      if ((m == 8) || (m == 14) || (m == 17))
      {
        if (paramBoolean)
        {
          paramBoolean = false;
        }
        else
        {
          c7 = charAt(this.bp);
          c2 = charAt(this.bp + 1);
          c5 = charAt(this.bp + 2);
          c6 = charAt(this.bp + 3);
          c4 = charAt(this.bp + 4);
          c3 = charAt(this.bp + 5);
          c1 = charAt(this.bp + 6);
          c8 = charAt(this.bp + 7);
          if (!checkDate(c7, c2, c5, c6, c4, c3, c1, c8))
          {
            paramBoolean = false;
          }
          else
          {
            setCalendar(c7, c2, c5, c6, c4, c3, c1, c8);
            if (m != 8)
            {
              c5 = charAt(this.bp + 8);
              c3 = charAt(this.bp + 9);
              c6 = charAt(this.bp + 10);
              c4 = charAt(this.bp + 11);
              c2 = charAt(this.bp + 12);
              c1 = charAt(this.bp + 13);
              if (!checkTime(c5, c3, c6, c4, c2, c1))
              {
                paramBoolean = false;
                continue;
              }
              if (m == 17)
              {
                k = charAt(this.bp + 14);
                j = charAt(this.bp + 15);
                i = charAt(this.bp + 16);
                if ((k < 48) || (k > 57))
                {
                  paramBoolean = false;
                  continue;
                }
                if ((j < 48) || (j > 57))
                {
                  paramBoolean = false;
                  continue;
                }
                if ((i < 48) || (i > 57))
                {
                  paramBoolean = false;
                  continue;
                }
                i = digits[k] * 100 + digits[j] * 10 + digits[i];
                label721:
                j = digits[c5];
                j = digits[c3] + j * 10;
                k = digits[c6];
                m = digits[c4] + k * 10;
                k = digits[c2] * 10 + digits[c1];
              }
            }
            for (;;)
            {
              this.calendar.set(11, j);
              this.calendar.set(12, m);
              this.calendar.set(13, k);
              this.calendar.set(14, i);
              this.token = 5;
              paramBoolean = true;
              break;
              i = 0;
              break label721;
              j = 0;
              m = 0;
              k = 0;
              i = 0;
            }
          }
        }
      }
      else if (m < this.ISO8601_LEN_0)
      {
        paramBoolean = false;
      }
      else if (charAt(this.bp + 4) != '-')
      {
        paramBoolean = false;
      }
      else if (charAt(this.bp + 7) != '-')
      {
        paramBoolean = false;
      }
      else
      {
        c2 = charAt(this.bp);
        c4 = charAt(this.bp + 1);
        c6 = charAt(this.bp + 2);
        c1 = charAt(this.bp + 3);
        c7 = charAt(this.bp + 5);
        c3 = charAt(this.bp + 6);
        c8 = charAt(this.bp + 8);
        c5 = charAt(this.bp + 9);
        if (!checkDate(c2, c4, c6, c1, c7, c3, c8, c5))
        {
          paramBoolean = false;
        }
        else
        {
          setCalendar(c2, c4, c6, c1, c7, c3, c8, c5);
          i = charAt(this.bp + 10);
          if ((i == 84) || ((i == 32) && (!paramBoolean)))
          {
            if (m < this.ISO8601_LEN_1) {
              paramBoolean = false;
            }
          }
          else
          {
            if ((i == 34) || (i == 26))
            {
              this.calendar.set(11, 0);
              this.calendar.set(12, 0);
              this.calendar.set(13, 0);
              this.calendar.set(14, 0);
              i = this.bp + 10;
              this.bp = i;
              this.ch = charAt(i);
              this.token = 5;
              paramBoolean = true;
              continue;
            }
            paramBoolean = false;
            continue;
          }
          if (charAt(this.bp + 13) != ':')
          {
            paramBoolean = false;
          }
          else if (charAt(this.bp + 16) != ':')
          {
            paramBoolean = false;
          }
          else
          {
            c6 = charAt(this.bp + 11);
            c5 = charAt(this.bp + 12);
            c3 = charAt(this.bp + 14);
            c4 = charAt(this.bp + 15);
            c1 = charAt(this.bp + 17);
            c2 = charAt(this.bp + 18);
            if (!checkTime(c6, c5, c3, c4, c1, c2))
            {
              paramBoolean = false;
            }
            else
            {
              i1 = digits[c6];
              n = digits[c5];
              i2 = digits[c3];
              k = digits[c4];
              j = digits[c1];
              i = digits[c2];
              this.calendar.set(11, i1 * 10 + n);
              this.calendar.set(12, i2 * 10 + k);
              this.calendar.set(13, j * 10 + i);
              if (charAt(this.bp + 19) == '.')
              {
                if (m < this.ISO8601_LEN_2) {
                  paramBoolean = false;
                }
              }
              else
              {
                this.calendar.set(14, 0);
                i = this.bp + 19;
                this.bp = i;
                this.ch = charAt(i);
                this.token = 5;
                paramBoolean = true;
                continue;
              }
              i = charAt(this.bp + 20);
              k = charAt(this.bp + 21);
              j = charAt(this.bp + 22);
              if ((i < 48) || (i > 57))
              {
                paramBoolean = false;
              }
              else if ((k < 48) || (k > 57))
              {
                paramBoolean = false;
              }
              else if ((j < 48) || (j > 57))
              {
                paramBoolean = false;
              }
              else
              {
                i = digits[i];
                k = digits[k];
                j = digits[j];
                this.calendar.set(14, i * 100 + k * 10 + j);
                i = this.bp + 23;
                this.bp = i;
                this.ch = charAt(i);
                this.token = 5;
                paramBoolean = true;
              }
            }
          }
        }
      }
    }
  }
  
  public final int scanType(String paramString)
  {
    int i = 0;
    this.matchStat = 0;
    if (!charArrayCompare(this.text, this.bp, typeFieldName)) {
      i = -2;
    }
    for (;;)
    {
      return i;
      int k = this.bp + typeFieldName.length;
      int j = paramString.length();
      for (;;)
      {
        if (i >= j) {
          break label77;
        }
        if (paramString.charAt(i) != charAt(k + i))
        {
          i = -1;
          break;
        }
        i++;
      }
      label77:
      i = k + j;
      if (charAt(i) != '"')
      {
        i = -1;
      }
      else
      {
        j = i + 1;
        this.ch = charAt(j);
        if (this.ch == ',')
        {
          i = j + 1;
          this.ch = charAt(i);
          this.bp = i;
          this.token = 16;
          i = 3;
        }
        else
        {
          i = j;
          if (this.ch == '}')
          {
            i = j + 1;
            this.ch = charAt(i);
            if (this.ch != ',') {
              break label217;
            }
            this.token = 16;
            i++;
            this.ch = charAt(i);
          }
          for (;;)
          {
            this.matchStat = 4;
            this.bp = i;
            i = this.matchStat;
            break;
            label217:
            if (this.ch == ']')
            {
              this.token = 15;
              i++;
              this.ch = charAt(i);
            }
            else if (this.ch == '}')
            {
              this.token = 13;
              i++;
              this.ch = charAt(i);
            }
            else
            {
              if (this.ch != '\032') {
                break label295;
              }
              this.token = 20;
            }
          }
          label295:
          i = -1;
        }
      }
    }
  }
  
  public final String stringVal()
  {
    if (!this.hasSpecial) {}
    for (String str = this.text.substring(this.np + 1, this.np + 1 + this.sp);; str = new String(this.sbuf, 0, this.sp)) {
      return str;
    }
  }
  
  public final String subString(int paramInt1, int paramInt2)
  {
    return this.text.substring(paramInt1, paramInt1 + paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/JSONScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */