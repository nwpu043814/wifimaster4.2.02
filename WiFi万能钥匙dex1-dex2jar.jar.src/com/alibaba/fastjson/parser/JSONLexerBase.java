package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

public abstract class JSONLexerBase
  implements JSONLexer, Closeable
{
  protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
  protected static final int INT_N_MULTMAX_RADIX_TEN = -214748364;
  protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
  protected static final long N_MULTMAX_RADIX_TEN = -922337203685477580L;
  private static final ThreadLocal<SoftReference<char[]>> SBUF_REF_LOCAL = new ThreadLocal();
  protected static final int[] digits;
  protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
  protected static boolean[] whitespaceFlags;
  protected int bp;
  protected Calendar calendar = null;
  protected char ch;
  protected int eofPos;
  protected int features = JSON.DEFAULT_PARSER_FEATURE;
  protected boolean hasSpecial;
  protected Keywords keywods = Keywords.DEFAULT_KEYWORDS;
  public int matchStat = 0;
  protected int np;
  protected int pos;
  protected char[] sbuf;
  protected int sp;
  protected int token;
  
  static
  {
    boolean[] arrayOfBoolean = new boolean['Ā'];
    whitespaceFlags = arrayOfBoolean;
    arrayOfBoolean[32] = true;
    whitespaceFlags[10] = true;
    whitespaceFlags[13] = true;
    whitespaceFlags[9] = true;
    whitespaceFlags[12] = true;
    whitespaceFlags[8] = true;
    digits = new int[103];
    for (int i = 48; i <= 57; i++) {
      digits[i] = (i - 48);
    }
    for (i = 97; i <= 102; i++) {
      digits[i] = (i - 97 + 10);
    }
    for (i = 65; i <= 70; i++) {
      digits[i] = (i - 65 + 10);
    }
  }
  
  public JSONLexerBase()
  {
    SoftReference localSoftReference = (SoftReference)SBUF_REF_LOCAL.get();
    if (localSoftReference != null)
    {
      this.sbuf = ((char[])localSoftReference.get());
      SBUF_REF_LOCAL.set(null);
    }
    if (this.sbuf == null) {
      this.sbuf = new char[64];
    }
  }
  
  public static final boolean isWhitespace(char paramChar)
  {
    if ((paramChar == ' ') || (paramChar == '\n') || (paramChar == '\r') || (paramChar == '\t') || (paramChar == '\f') || (paramChar == '\b')) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private final void scanStringSingleQuote()
  {
    this.np = this.bp;
    this.hasSpecial = false;
    for (;;)
    {
      char c = next();
      if (c == '\'') {
        break;
      }
      if (c == '\032') {
        throw new JSONException("unclosed single-quote string");
      }
      char[] arrayOfChar;
      int i;
      if (c == '\\')
      {
        if (!this.hasSpecial)
        {
          this.hasSpecial = true;
          if (this.sp > this.sbuf.length)
          {
            arrayOfChar = new char[this.sp * 2];
            System.arraycopy(this.sbuf, 0, arrayOfChar, 0, this.sbuf.length);
            this.sbuf = arrayOfChar;
          }
          copyTo(this.np + 1, this.sp, this.sbuf);
        }
        c = next();
        switch (c)
        {
        default: 
          this.ch = c;
          throw new JSONException("unclosed single-quote string");
        case '0': 
          putChar('\000');
          break;
        case '1': 
          putChar('\001');
          break;
        case '2': 
          putChar('\002');
          break;
        case '3': 
          putChar('\003');
          break;
        case '4': 
          putChar('\004');
          break;
        case '5': 
          putChar('\005');
          break;
        case '6': 
          putChar('\006');
          break;
        case '7': 
          putChar('\007');
          break;
        case 'b': 
          putChar('\b');
          break;
        case 't': 
          putChar('\t');
          break;
        case 'n': 
          putChar('\n');
          break;
        case 'v': 
          putChar('\013');
          break;
        case 'F': 
        case 'f': 
          putChar('\f');
          break;
        case 'r': 
          putChar('\r');
          break;
        case '"': 
          putChar('"');
          break;
        case '\'': 
          putChar('\'');
          break;
        case '/': 
          putChar('/');
          break;
        case '\\': 
          putChar('\\');
          break;
        case 'x': 
          i = next();
          int j = next();
          putChar((char)(digits[i] * 16 + digits[j]));
          break;
        case 'u': 
          putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }), 16));
          break;
        }
      }
      else if (!this.hasSpecial)
      {
        this.sp += 1;
      }
      else if (this.sp == this.sbuf.length)
      {
        putChar(c);
      }
      else
      {
        arrayOfChar = this.sbuf;
        i = this.sp;
        this.sp = (i + 1);
        arrayOfChar[i] = c;
      }
    }
    this.token = 4;
    next();
  }
  
  public abstract String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable);
  
  protected abstract void arrayCopy(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3);
  
  public abstract byte[] bytesValue();
  
  protected abstract boolean charArrayCompare(char[] paramArrayOfChar);
  
  public abstract char charAt(int paramInt);
  
  public void close()
  {
    if (this.sbuf.length <= 8192) {
      SBUF_REF_LOCAL.set(new SoftReference(this.sbuf));
    }
    this.sbuf = null;
  }
  
  public void config(Feature paramFeature, boolean paramBoolean)
  {
    this.features = Feature.config(this.features, paramFeature, paramBoolean);
  }
  
  protected abstract void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfChar);
  
  public final Number decimalValue(boolean paramBoolean)
  {
    int i = charAt(this.np + this.sp - 1);
    Object localObject;
    if (i == 70) {
      localObject = Float.valueOf(Float.parseFloat(numberString()));
    }
    for (;;)
    {
      return (Number)localObject;
      if (i == 68) {
        localObject = Double.valueOf(Double.parseDouble(numberString()));
      } else if (paramBoolean) {
        localObject = decimalValue();
      } else {
        localObject = Double.valueOf(doubleValue());
      }
    }
  }
  
  public final BigDecimal decimalValue()
  {
    return new BigDecimal(numberString());
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(numberString());
  }
  
  public float floatValue()
  {
    return Float.parseFloat(numberString());
  }
  
  public final int getBufferPosition()
  {
    return this.bp;
  }
  
  public Calendar getCalendar()
  {
    return this.calendar;
  }
  
  public final char getCurrent()
  {
    return this.ch;
  }
  
  public abstract int indexOf(char paramChar, int paramInt);
  
  public final int intValue()
  {
    int n = 0;
    int i = this.np;
    int i1 = this.np + this.sp;
    int k;
    int m;
    int j;
    if (charAt(this.np) == '-')
    {
      k = 1;
      m = Integer.MIN_VALUE;
      i++;
      if (i >= i1) {
        break label217;
      }
      int[] arrayOfInt = digits;
      j = i + 1;
      i = -arrayOfInt[charAt(i)];
    }
    for (;;)
    {
      if (j < i1)
      {
        n = j + 1;
        int i2 = charAt(j);
        j = n;
        if (i2 != 76)
        {
          j = n;
          if (i2 != 83)
          {
            j = n;
            if (i2 != 66)
            {
              j = digits[i2];
              if (i < -214748364)
              {
                throw new NumberFormatException(numberString());
                m = -2147483647;
                k = 0;
                break;
              }
              i *= 10;
              if (i < m + j) {
                throw new NumberFormatException(numberString());
              }
              i -= j;
              j = n;
              continue;
            }
          }
        }
      }
      if (k != 0) {
        if (j <= this.np + 1) {}
      }
      for (;;)
      {
        return i;
        throw new NumberFormatException(numberString());
        i = -i;
      }
      label217:
      j = i;
      i = n;
    }
  }
  
  public final Number integerValue()
  {
    long l1 = 0L;
    if (this.np == -1) {
      this.np = 0;
    }
    int k = this.np;
    int i = this.np;
    int j = this.sp + i;
    i = 32;
    int m;
    long l2;
    label100:
    Object localObject;
    int n;
    switch (charAt(j - 1))
    {
    default: 
      if (charAt(this.np) == '-')
      {
        m = 1;
        l2 = Long.MIN_VALUE;
        k++;
        if (k >= j) {
          break label399;
        }
        localObject = digits;
        n = k + 1;
        l1 = -localObject[charAt(k)];
        k = n;
      }
      break;
    }
    label130:
    label399:
    for (;;)
    {
      if (k < j)
      {
        n = digits[charAt(k)];
        if (l1 < -922337203685477580L) {
          localObject = new BigInteger(numberString());
        }
      }
      for (;;)
      {
        return (Number)localObject;
        j--;
        i = 76;
        break;
        j--;
        i = 83;
        break;
        j--;
        i = 66;
        break;
        m = 0;
        l2 = -9223372036854775807L;
        break label100;
        l1 *= 10L;
        if (l1 < n + l2)
        {
          localObject = new BigInteger(numberString());
        }
        else
        {
          l1 -= n;
          k++;
          break label130;
          if (m != 0)
          {
            if (k > this.np + 1)
            {
              if ((l1 >= -2147483648L) && (i != 76)) {
                localObject = Integer.valueOf((int)l1);
              } else {
                localObject = Long.valueOf(l1);
              }
            }
            else {
              throw new NumberFormatException(numberString());
            }
          }
          else
          {
            l1 = -l1;
            if ((l1 <= 2147483647L) && (i != 76))
            {
              if (i == 83) {
                localObject = Short.valueOf((short)(int)l1);
              } else if (i == 66) {
                localObject = Byte.valueOf((byte)(int)l1);
              } else {
                localObject = Integer.valueOf((int)l1);
              }
            }
            else {
              localObject = Long.valueOf(l1);
            }
          }
        }
      }
    }
  }
  
  public final boolean isBlankInput()
  {
    boolean bool = false;
    int i = 0;
    char c = charAt(i);
    if (c != '\032') {
      if (isWhitespace(c)) {}
    }
    for (;;)
    {
      return bool;
      i++;
      break;
      bool = true;
    }
  }
  
  public abstract boolean isEOF();
  
  public final boolean isEnabled(Feature paramFeature)
  {
    return Feature.isEnabled(this.features, paramFeature);
  }
  
  public final boolean isRef()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.sp != 4) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (charAt(this.np + 1) == '$')
      {
        bool1 = bool2;
        if (charAt(this.np + 2) == 'r')
        {
          bool1 = bool2;
          if (charAt(this.np + 3) == 'e')
          {
            bool1 = bool2;
            if (charAt(this.np + 4) == 'f') {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  protected void lexError(String paramString, Object... paramVarArgs)
  {
    this.token = 1;
  }
  
  public final long longValue()
  {
    long l1 = 0L;
    int i = this.np;
    int m = this.np + this.sp;
    int j;
    long l2;
    int k;
    if (charAt(this.np) == '-')
    {
      j = 1;
      l2 = Long.MIN_VALUE;
      i++;
      if (i >= m) {
        break label233;
      }
      int[] arrayOfInt = digits;
      k = i + 1;
      l1 = -arrayOfInt[charAt(i)];
      i = k;
    }
    label233:
    for (;;)
    {
      if (i < m)
      {
        k = i + 1;
        int n = charAt(i);
        i = k;
        if (n != 76)
        {
          i = k;
          if (n != 83)
          {
            i = k;
            if (n != 66)
            {
              i = digits[n];
              if (l1 < -922337203685477580L)
              {
                throw new NumberFormatException(numberString());
                j = 0;
                l2 = -9223372036854775807L;
                break;
              }
              l1 *= 10L;
              if (l1 < i + l2) {
                throw new NumberFormatException(numberString());
              }
              l1 -= i;
              i = k;
              continue;
            }
          }
        }
      }
      if (j != 0) {
        if (i <= this.np + 1) {}
      }
      for (;;)
      {
        return l1;
        throw new NumberFormatException(numberString());
        l1 = -l1;
      }
    }
  }
  
  public final boolean matchField(char[] paramArrayOfChar)
  {
    boolean bool;
    if (!charArrayCompare(paramArrayOfChar))
    {
      bool = false;
      return bool;
    }
    this.bp += paramArrayOfChar.length;
    this.ch = charAt(this.bp);
    if (this.ch == '{')
    {
      next();
      this.token = 12;
    }
    for (;;)
    {
      bool = true;
      break;
      if (this.ch == '[')
      {
        next();
        this.token = 14;
      }
      else
      {
        nextToken();
      }
    }
  }
  
  public final int matchStat()
  {
    return this.matchStat;
  }
  
  public abstract char next();
  
  public final void nextIdent()
  {
    while (isWhitespace(this.ch)) {
      next();
    }
    if ((this.ch == '_') || (Character.isLetter(this.ch))) {
      scanIdent();
    }
    for (;;)
    {
      return;
      nextToken();
    }
  }
  
  public final void nextToken()
  {
    this.sp = 0;
    this.pos = this.bp;
    if (this.ch == '"') {
      scanString();
    }
    for (;;)
    {
      return;
      if (this.ch == ',')
      {
        next();
        this.token = 16;
      }
      else if ((this.ch >= '0') && (this.ch <= '9'))
      {
        scanNumber();
      }
      else if (this.ch == '-')
      {
        scanNumber();
      }
      else
      {
        switch (this.ch)
        {
        default: 
          if (isEOF()) {
            if (this.token == 20) {
              throw new JSONException("EOF error");
            }
          }
        case '\'': 
          if (!isEnabled(Feature.AllowSingleQuotes)) {
            throw new JSONException("Feature.AllowSingleQuotes is false");
          }
          scanStringSingleQuote();
          break;
        case '\b': 
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
          next();
          break;
        case 't': 
          scanTrue();
          break;
        case 'T': 
          scanTreeSet();
          break;
        case 'S': 
          scanSet();
          break;
        case 'f': 
          scanFalse();
          break;
        case 'n': 
          scanNullOrNew();
          break;
        case '(': 
          next();
          this.token = 10;
          break;
        case ')': 
          next();
          this.token = 11;
          break;
        case '[': 
          next();
          this.token = 14;
          break;
        case ']': 
          next();
          this.token = 15;
          break;
        case '{': 
          next();
          this.token = 12;
          break;
        case '}': 
          next();
          this.token = 13;
          break;
        case ':': 
          next();
          this.token = 17;
          continue;
          this.token = 20;
          int i = this.eofPos;
          this.bp = i;
          this.pos = i;
          continue;
          lexError("illegal.char", new Object[] { String.valueOf(this.ch) });
          next();
        }
      }
    }
  }
  
  public final void nextToken(int paramInt)
  {
    this.sp = 0;
    for (;;)
    {
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 13: 
      case 17: 
      case 19: 
      default: 
        if ((this.ch != ' ') && (this.ch != '\n') && (this.ch != '\r') && (this.ch != '\t') && (this.ch != '\f') && (this.ch != '\b')) {
          break label589;
        }
        next();
      }
    }
    if (this.ch == '{')
    {
      this.token = 12;
      next();
    }
    for (;;)
    {
      return;
      if (this.ch != '[') {
        break;
      }
      this.token = 14;
      next();
      continue;
      if (this.ch == ',')
      {
        this.token = 16;
        next();
      }
      else if (this.ch == '}')
      {
        this.token = 13;
        next();
      }
      else if (this.ch == ']')
      {
        this.token = 15;
        next();
      }
      else
      {
        if (this.ch != '\032') {
          break;
        }
        this.token = 20;
        continue;
        if ((this.ch >= '0') && (this.ch <= '9'))
        {
          this.pos = this.bp;
          scanNumber();
        }
        else if (this.ch == '"')
        {
          this.pos = this.bp;
          scanString();
        }
        else if (this.ch == '[')
        {
          this.token = 14;
          next();
        }
        else
        {
          if (this.ch != '{') {
            break;
          }
          this.token = 12;
          next();
          continue;
          if (this.ch == '"')
          {
            this.pos = this.bp;
            scanString();
          }
          else if ((this.ch >= '0') && (this.ch <= '9'))
          {
            this.pos = this.bp;
            scanNumber();
          }
          else if (this.ch == '[')
          {
            this.token = 14;
            next();
          }
          else
          {
            if (this.ch != '{') {
              break;
            }
            this.token = 12;
            next();
            continue;
            if (this.ch == '[')
            {
              this.token = 14;
              next();
            }
            else
            {
              if (this.ch != '{') {
                break;
              }
              this.token = 12;
              next();
              continue;
              if (this.ch == ']')
              {
                this.token = 15;
                next();
              }
              else
              {
                if (this.ch != '\032') {
                  break;
                }
                this.token = 20;
                continue;
                nextIdent();
                continue;
                label589:
                nextToken();
              }
            }
          }
        }
      }
    }
  }
  
  public final void nextTokenWithChar(char paramChar)
  {
    this.sp = 0;
    for (;;)
    {
      if (this.ch == paramChar)
      {
        next();
        nextToken();
        return;
      }
      if ((this.ch != ' ') && (this.ch != '\n') && (this.ch != '\r') && (this.ch != '\t') && (this.ch != '\f') && (this.ch != '\b')) {
        break;
      }
      next();
    }
    throw new JSONException("not match " + paramChar + " - " + this.ch);
  }
  
  public final void nextTokenWithChar(char paramChar, int paramInt)
  {
    this.sp = 0;
    if (this.ch == paramChar)
    {
      next();
      label18:
      if (paramInt != 2) {
        break label134;
      }
      if ((this.ch < '0') || (this.ch > '9')) {
        break label110;
      }
      this.pos = this.bp;
      scanNumber();
    }
    for (;;)
    {
      return;
      if (isWhitespace(this.ch))
      {
        next();
        break;
      }
      throw new JSONException("not match " + paramInt + " - " + this.ch);
      label110:
      if (this.ch == '"')
      {
        this.pos = this.bp;
        scanString();
        continue;
        label134:
        if (paramInt == 4)
        {
          if (this.ch == '"')
          {
            this.pos = this.bp;
            scanString();
            continue;
          }
          if ((this.ch >= '0') && (this.ch <= '9'))
          {
            this.pos = this.bp;
            scanNumber();
          }
        }
        else if (paramInt == 12)
        {
          if (this.ch == '{')
          {
            this.token = 12;
            next();
            continue;
          }
          if (this.ch == '[')
          {
            this.token = 14;
            next();
          }
        }
        else if (paramInt == 14)
        {
          if (this.ch == '[')
          {
            this.token = 14;
            next();
            continue;
          }
          if (this.ch == '{')
          {
            this.token = 12;
            next();
            continue;
          }
        }
      }
      if (isWhitespace(this.ch))
      {
        next();
        break label18;
      }
      nextToken();
    }
  }
  
  public final void nextTokenWithColon()
  {
    nextTokenWithChar(':');
  }
  
  public final void nextTokenWithColon(int paramInt)
  {
    nextTokenWithChar(':');
  }
  
  public final void nextTokenWithComma()
  {
    nextTokenWithChar(':');
  }
  
  public final void nextTokenWithComma(int paramInt)
  {
    nextTokenWithChar(',');
  }
  
  public abstract String numberString();
  
  public final Number numberValue()
  {
    int i = charAt(this.np + this.sp - 1);
    Object localObject = numberString();
    switch (i)
    {
    case 69: 
    default: 
      localObject = new BigDecimal((String)localObject);
    }
    for (;;)
    {
      return (Number)localObject;
      localObject = Double.valueOf(Double.parseDouble((String)localObject));
      continue;
      localObject = Float.valueOf(Float.parseFloat((String)localObject));
    }
  }
  
  public final int pos()
  {
    return this.pos;
  }
  
  protected final void putChar(char paramChar)
  {
    if (this.sp == this.sbuf.length)
    {
      arrayOfChar = new char[this.sbuf.length * 2];
      System.arraycopy(this.sbuf, 0, arrayOfChar, 0, this.sbuf.length);
      this.sbuf = arrayOfChar;
    }
    char[] arrayOfChar = this.sbuf;
    int i = this.sp;
    this.sp = (i + 1);
    arrayOfChar[i] = paramChar;
  }
  
  public final void resetStringPosition()
  {
    this.sp = 0;
  }
  
  public boolean scanBoolean(char paramChar)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    int i;
    if (c == 't') {
      if ((charAt(this.bp + 1) == 'r') && (charAt(this.bp + 1 + 1) == 'u') && (charAt(this.bp + 1 + 2) == 'e'))
      {
        c = this.bp;
        i = 5;
        c = charAt(c + '\004');
        bool1 = true;
      }
    }
    for (;;)
    {
      if (c == paramChar)
      {
        this.bp += i - 1;
        next();
        this.matchStat = 3;
      }
      for (;;)
      {
        return bool1;
        this.matchStat = -1;
        bool1 = bool2;
        continue;
        if (c != 'f') {
          break label248;
        }
        if ((charAt(this.bp + 1) == 'a') && (charAt(this.bp + 1 + 1) == 'l') && (charAt(this.bp + 1 + 2) == 's') && (charAt(this.bp + 1 + 3) == 'e'))
        {
          c = this.bp;
          i = 6;
          c = charAt(c + '\005');
          break;
        }
        this.matchStat = -1;
        bool1 = bool2;
        continue;
        this.matchStat = -1;
      }
      label248:
      i = 1;
    }
  }
  
  public Enum<?> scanEnum(Class<?> paramClass, SymbolTable paramSymbolTable, char paramChar)
  {
    paramSymbolTable = scanSymbolWithSeperator(paramSymbolTable, paramChar);
    if (paramSymbolTable == null) {}
    for (paramClass = null;; paramClass = Enum.valueOf(paramClass, paramSymbolTable)) {
      return paramClass;
    }
  }
  
  public final void scanFalse()
  {
    if (this.ch != 'f') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'a') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'l') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 's') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse false");
    }
    next();
    if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b'))
    {
      this.token = 7;
      return;
    }
    throw new JSONException("scan false error");
  }
  
  public boolean scanFieldBoolean(char[] paramArrayOfChar)
  {
    boolean bool2 = false;
    this.matchStat = 0;
    boolean bool1;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      int k = paramArrayOfChar.length;
      int j = this.bp;
      int i = k + 1;
      j = charAt(k + j);
      if (j == 116)
      {
        j = this.bp;
        k = i + 1;
        if (charAt(j + i) != 'r')
        {
          this.matchStat = -1;
          bool1 = bool2;
          continue;
        }
        i = this.bp;
        j = k + 1;
        if (charAt(i + k) != 'u')
        {
          this.matchStat = -1;
          bool1 = bool2;
          continue;
        }
        k = this.bp;
        i = j + 1;
        if (charAt(k + j) != 'e')
        {
          this.matchStat = -1;
          bool1 = bool2;
          continue;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        k = this.bp;
        j = i + 1;
        i = charAt(i + k);
        if (i != 44) {
          break label381;
        }
        this.bp += j - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        break;
        if (j != 102) {
          break label369;
        }
        k = this.bp;
        j = i + 1;
        if (charAt(k + i) != 'a')
        {
          this.matchStat = -1;
          bool1 = bool2;
          break;
        }
        k = this.bp;
        i = j + 1;
        if (charAt(k + j) != 'l')
        {
          this.matchStat = -1;
          bool1 = bool2;
          break;
        }
        k = this.bp;
        j = i + 1;
        if (charAt(k + i) != 's')
        {
          this.matchStat = -1;
          bool1 = bool2;
          break;
        }
        if (charAt(j + this.bp) != 'e')
        {
          this.matchStat = -1;
          bool1 = bool2;
          break;
        }
        i = j + 1;
      }
      label369:
      this.matchStat = -1;
      bool1 = bool2;
      continue;
      label381:
      if (i == 125)
      {
        k = this.bp;
        i = j + 1;
        j = charAt(k + j);
        if (j == 44)
        {
          this.token = 16;
          this.bp += i - 1;
          next();
        }
        for (;;)
        {
          this.matchStat = 4;
          break;
          if (j == 93)
          {
            this.token = 15;
            this.bp += i - 1;
            next();
          }
          else if (j == 125)
          {
            this.token = 13;
            this.bp += i - 1;
            next();
          }
          else
          {
            if (j != 26) {
              break label540;
            }
            this.token = 20;
            this.bp += i - 1;
            this.ch = '\032';
          }
        }
        label540:
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
  
  public final double scanFieldDouble(char paramChar)
  {
    this.matchStat = 0;
    char c2 = this.bp;
    char c1 = '\001';
    c2 = charAt(c2 + '\000');
    if ((c2 >= '0') && (c2 <= '9')) {}
    for (;;)
    {
      c2 = this.bp;
      char c3 = c1 + '\001';
      char c4 = charAt(c1 + c2);
      if ((c4 < '0') || (c4 > '9'))
      {
        c2 = c4;
        c1 = c3;
        double d;
        if (c4 == '.')
        {
          c2 = this.bp;
          c1 = c3 + '\001';
          c2 = charAt(c3 + c2);
          if ((c2 >= '0') && (c2 <= '9')) {
            for (;;)
            {
              c2 = this.bp;
              c3 = c1 + '\001';
              c4 = charAt(c1 + c2);
              c2 = c4;
              c1 = c3;
              if (c4 < '0') {
                break;
              }
              c2 = c4;
              c1 = c3;
              if (c4 > '9') {
                break;
              }
              c1 = c3;
            }
          }
          this.matchStat = -1;
          d = 0.0D;
        }
        for (;;)
        {
          return d;
          if (c2 != 'e')
          {
            c4 = c2;
            c3 = c1;
            if (c2 != 'E') {}
          }
          else
          {
            c2 = this.bp;
            c3 = c1 + '\001';
            char c5 = charAt(c1 + c2);
            c4 = c3;
            if (c5 != '+')
            {
              c1 = c3;
              c2 = c5;
              if (c5 != '-') {
                break label290;
              }
              c4 = c3;
            }
            label290:
            do
            {
              c2 = charAt(c4 + this.bp);
              c1 = c4 + '\001';
              if (c2 < '0') {
                break;
              }
              c4 = c1;
            } while (c2 <= '9');
            c3 = c1;
            c4 = c2;
          }
          c1 = this.bp;
          d = Double.parseDouble(subString(c1, this.bp + c3 - c1 - 1));
          if (c4 == paramChar)
          {
            this.bp += c3 - '\001';
            next();
            this.matchStat = 3;
            this.token = 16;
            continue;
            this.matchStat = -1;
            d = 0.0D;
          }
          else
          {
            this.matchStat = -1;
          }
        }
      }
      c1 = c3;
    }
  }
  
  public final double scanFieldDouble(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    double d;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      d = 0.0D;
      return d;
    }
    int k = paramArrayOfChar.length;
    int j = this.bp;
    int i = k + 1;
    j = charAt(k + j);
    if ((j >= 48) && (j <= 57)) {}
    for (;;)
    {
      j = this.bp;
      k = i + 1;
      int m = charAt(i + j);
      if ((m < 48) || (m > 57))
      {
        j = m;
        i = k;
        if (m == 46)
        {
          j = this.bp;
          i = k + 1;
          j = charAt(k + j);
          if ((j >= 48) && (j <= 57)) {
            for (;;)
            {
              j = this.bp;
              k = i + 1;
              m = charAt(i + j);
              j = m;
              i = k;
              if (m < 48) {
                break;
              }
              j = m;
              i = k;
              if (m > 57) {
                break;
              }
              i = k;
            }
          }
          this.matchStat = -1;
          d = 0.0D;
          break;
        }
        if (j != 101)
        {
          m = j;
          k = i;
          if (j != 69) {}
        }
        else
        {
          j = this.bp;
          k = i + 1;
          int n = charAt(i + j);
          m = k;
          if (n != 43)
          {
            i = k;
            j = n;
            if (n != 45) {
              break label317;
            }
            m = k;
          }
          label317:
          do
          {
            j = charAt(m + this.bp);
            i = m + 1;
            if (j < 48) {
              break;
            }
            m = i;
          } while (j <= 57);
          k = i;
          m = j;
        }
        i = this.bp + paramArrayOfChar.length;
        d = Double.parseDouble(subString(i, this.bp + k - i - 1));
        if (m == 44)
        {
          this.bp += k - 1;
          next();
          this.matchStat = 3;
          this.token = 16;
          break;
          this.matchStat = -1;
          d = 0.0D;
          break;
        }
        if (m == 125)
        {
          j = this.bp;
          i = k + 1;
          j = charAt(j + k);
          if (j == 44)
          {
            this.token = 16;
            this.bp += i - 1;
            next();
          }
          for (;;)
          {
            this.matchStat = 4;
            break;
            if (j == 93)
            {
              this.token = 15;
              this.bp += i - 1;
              next();
            }
            else if (j == 125)
            {
              this.token = 13;
              this.bp += i - 1;
              next();
            }
            else
            {
              if (j != 26) {
                break label595;
              }
              this.token = 20;
              this.bp += i - 1;
              this.ch = '\032';
            }
          }
          label595:
          this.matchStat = -1;
          d = 0.0D;
          break;
        }
        this.matchStat = -1;
        d = 0.0D;
        break;
      }
      i = k;
    }
  }
  
  public final float scanFieldFloat(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    float f;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      f = 0.0F;
      return f;
    }
    int j = paramArrayOfChar.length;
    int k = this.bp;
    int i = j + 1;
    j = charAt(j + k);
    if ((j >= 48) && (j <= 57)) {}
    for (;;)
    {
      k = this.bp;
      j = i + 1;
      int m = charAt(i + k);
      if ((m < 48) || (m > 57))
      {
        k = m;
        i = j;
        if (m == 46)
        {
          k = this.bp;
          i = j + 1;
          j = charAt(j + k);
          if ((j >= 48) && (j <= 57)) {
            for (;;)
            {
              k = this.bp;
              j = i + 1;
              m = charAt(i + k);
              k = m;
              i = j;
              if (m < 48) {
                break;
              }
              k = m;
              i = j;
              if (m > 57) {
                break;
              }
              i = j;
            }
          }
          this.matchStat = -1;
          f = 0.0F;
          break;
        }
        j = this.bp + paramArrayOfChar.length;
        f = Float.parseFloat(subString(j, this.bp + i - j - 1));
        if (k == 44)
        {
          this.bp += i - 1;
          next();
          this.matchStat = 3;
          this.token = 16;
          break;
          this.matchStat = -1;
          f = 0.0F;
          break;
        }
        if (k == 125)
        {
          k = this.bp;
          j = i + 1;
          i = charAt(k + i);
          if (i == 44)
          {
            this.token = 16;
            this.bp += j - 1;
            next();
          }
          for (;;)
          {
            this.matchStat = 4;
            break;
            if (i == 93)
            {
              this.token = 15;
              this.bp += j - 1;
              next();
            }
            else if (i == 125)
            {
              this.token = 13;
              this.bp += j - 1;
              next();
            }
            else
            {
              if (i != 26) {
                break label456;
              }
              this.bp += j - 1;
              this.token = 20;
              this.ch = '\032';
            }
          }
          label456:
          this.matchStat = -1;
          f = 0.0F;
          break;
        }
        this.matchStat = -1;
        f = 0.0F;
        break;
      }
      i = j;
    }
  }
  
  public int scanFieldInt(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    int i;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      i = 0;
    }
    for (;;)
    {
      return i;
      int k = paramArrayOfChar.length;
      i = this.bp;
      int j = k + 1;
      i = charAt(k + i);
      int m;
      if ((i >= 48) && (i <= 57))
      {
        i = digits[i];
        for (;;)
        {
          m = this.bp;
          k = j + 1;
          j = charAt(j + m);
          if ((j < 48) || (j > 57)) {
            break;
          }
          i = i * 10 + digits[j];
          j = k;
        }
        if (j == 46)
        {
          this.matchStat = -1;
          i = 0;
          continue;
        }
        if (i < 0)
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
      if (j == 44)
      {
        this.bp += k - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
      }
      else if (j == 125)
      {
        m = this.bp;
        j = k + 1;
        k = charAt(m + k);
        if (k == 44)
        {
          this.token = 16;
          this.bp += j - 1;
          next();
        }
        for (;;)
        {
          this.matchStat = 4;
          break;
          if (k == 93)
          {
            this.token = 15;
            this.bp += j - 1;
            next();
          }
          else if (k == 125)
          {
            this.token = 13;
            this.bp += j - 1;
            next();
          }
          else
          {
            if (k != 26) {
              break label357;
            }
            this.token = 20;
            this.bp += j - 1;
            this.ch = '\032';
          }
        }
        label357:
        this.matchStat = -1;
        i = 0;
      }
      else
      {
        this.matchStat = -1;
        i = 0;
      }
    }
  }
  
  public long scanFieldLong(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    long l;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      l = 0L;
    }
    for (;;)
    {
      return l;
      int k = paramArrayOfChar.length;
      int j = this.bp;
      int i = k + 1;
      j = charAt(k + j);
      if ((j >= 48) && (j <= 57))
      {
        l = digits[j];
        for (;;)
        {
          k = this.bp;
          j = i + 1;
          i = charAt(i + k);
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
        if (l < 0L)
        {
          this.matchStat = -1;
          l = 0L;
        }
      }
      else
      {
        this.matchStat = -1;
        l = 0L;
        continue;
      }
      if (i == 44)
      {
        this.bp += j - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
      }
      else if (i == 125)
      {
        k = this.bp;
        i = j + 1;
        j = charAt(k + j);
        if (j == 44)
        {
          this.token = 16;
          this.bp += i - 1;
          next();
        }
        for (;;)
        {
          this.matchStat = 4;
          break;
          if (j == 93)
          {
            this.token = 15;
            this.bp += i - 1;
            next();
          }
          else if (j == 125)
          {
            this.token = 13;
            this.bp += i - 1;
            next();
          }
          else
          {
            if (j != 26) {
              break label361;
            }
            this.token = 20;
            this.bp += i - 1;
            this.ch = '\032';
          }
        }
        label361:
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
  
  public String scanFieldString(char[] paramArrayOfChar)
  {
    int k = 0;
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      paramArrayOfChar = stringDefaultValue();
    }
    for (;;)
    {
      return paramArrayOfChar;
      int n = paramArrayOfChar.length;
      if (charAt(n + this.bp) != '"')
      {
        this.matchStat = -1;
        paramArrayOfChar = stringDefaultValue();
      }
      else
      {
        int m = indexOf('"', this.bp + paramArrayOfChar.length + 1);
        if (m == -1) {
          throw new JSONException("unclosed str");
        }
        int i = this.bp + paramArrayOfChar.length + 1;
        String str = subString(i, m - i);
        for (int j = this.bp + paramArrayOfChar.length + 1;; j++)
        {
          i = k;
          if (j < m)
          {
            if (charAt(j) == '\\') {
              i = 1;
            }
          }
          else
          {
            if (i == 0) {
              break label171;
            }
            this.matchStat = -1;
            paramArrayOfChar = stringDefaultValue();
            break;
          }
        }
        label171:
        k = m - (this.bp + paramArrayOfChar.length + 1) + 1 + (n + 1);
        j = this.bp;
        i = k + 1;
        j = charAt(k + j);
        if (j == 44)
        {
          this.bp += i - 1;
          next();
          this.matchStat = 3;
          paramArrayOfChar = str;
        }
        else if (j == 125)
        {
          k = this.bp;
          j = i + 1;
          i = charAt(k + i);
          if (i == 44)
          {
            this.token = 16;
            this.bp += j - 1;
            next();
          }
          for (;;)
          {
            this.matchStat = 4;
            paramArrayOfChar = str;
            break;
            if (i == 93)
            {
              this.token = 15;
              this.bp += j - 1;
              next();
            }
            else if (i == 125)
            {
              this.token = 13;
              this.bp += j - 1;
              next();
            }
            else
            {
              if (i != 26) {
                break label407;
              }
              this.token = 20;
              this.bp += j - 1;
              this.ch = '\032';
            }
          }
          label407:
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
  
  public Collection<String> scanFieldStringArray(char[] paramArrayOfChar, Class<?> paramClass)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      paramArrayOfChar = null;
    }
    int j;
    int k;
    for (;;)
    {
      return paramArrayOfChar;
      if (paramClass.isAssignableFrom(HashSet.class)) {
        paramClass = new HashSet();
      }
      for (;;)
      {
        j = paramArrayOfChar.length;
        k = this.bp;
        i = j + 1;
        if (charAt(j + k) != '[')
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
      label126:
      k = this.bp;
      j = i + 1;
      if (charAt(i + k) == '"') {
        break;
      }
      this.matchStat = -1;
      paramArrayOfChar = null;
    }
    for (int i = j;; i = k)
    {
      int m = this.bp;
      k = i + 1;
      i = charAt(i + m);
      if (i == 34)
      {
        i = this.bp + j;
        paramClass.add(subString(i, this.bp + k - i - 1));
        i = this.bp;
        j = k + 1;
        k = charAt(i + k);
        i = j;
        if (k == 44) {
          break label126;
        }
        if (k != 93) {
          break label330;
        }
        k = this.bp;
        i = j + 1;
        j = charAt(j + k);
        if (j != 44) {
          break label340;
        }
        this.bp += i - 1;
        next();
        this.matchStat = 3;
        paramArrayOfChar = paramClass;
        break;
      }
      if (i == 92)
      {
        this.matchStat = -1;
        paramArrayOfChar = null;
        break;
        label330:
        this.matchStat = -1;
        paramArrayOfChar = null;
        break;
        label340:
        if (j == 125)
        {
          k = this.bp;
          j = i + 1;
          i = charAt(k + i);
          if (i == 44)
          {
            this.token = 16;
            this.bp += j - 1;
            next();
          }
          for (;;)
          {
            this.matchStat = 4;
            paramArrayOfChar = paramClass;
            break;
            if (i == 93)
            {
              this.token = 15;
              this.bp += j - 1;
              next();
            }
            else if (i == 125)
            {
              this.token = 13;
              this.bp += j - 1;
              next();
            }
            else
            {
              if (i != 26) {
                break label507;
              }
              this.bp += j - 1;
              this.token = 20;
              this.ch = '\032';
            }
          }
          label507:
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
  
  public String scanFieldSymbol(char[] paramArrayOfChar, SymbolTable paramSymbolTable)
  {
    int i = 0;
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      paramArrayOfChar = null;
    }
    for (;;)
    {
      return paramArrayOfChar;
      int m = paramArrayOfChar.length;
      int k = this.bp;
      int j = m + 1;
      if (charAt(m + k) != '"')
      {
        this.matchStat = -1;
        paramArrayOfChar = null;
      }
      else
      {
        do
        {
          j = k;
          m = this.bp;
          k = j + 1;
          j = charAt(j + m);
          if (j == 34)
          {
            j = this.bp + paramArrayOfChar.length + 1;
            paramArrayOfChar = addSymbol(j, this.bp + k - j - 1, i, paramSymbolTable);
            j = this.bp;
            i = k + 1;
            j = charAt(j + k);
            if (j != 44) {
              break label210;
            }
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            break;
          }
          i = i * 31 + j;
        } while (j != 92);
        this.matchStat = -1;
        paramArrayOfChar = null;
        continue;
        label210:
        if (j == 125)
        {
          k = this.bp;
          j = i + 1;
          i = charAt(k + i);
          if (i == 44)
          {
            this.token = 16;
            this.bp += j - 1;
            next();
          }
          for (;;)
          {
            this.matchStat = 4;
            break;
            if (i == 93)
            {
              this.token = 15;
              this.bp += j - 1;
              next();
            }
            else if (i == 125)
            {
              this.token = 13;
              this.bp += j - 1;
              next();
            }
            else
            {
              if (i != 26) {
                break label375;
              }
              this.token = 20;
              this.bp += j - 1;
              this.ch = '\032';
            }
          }
          label375:
          this.matchStat = -1;
          paramArrayOfChar = null;
        }
        else
        {
          this.matchStat = -1;
          paramArrayOfChar = null;
        }
      }
    }
  }
  
  public final float scanFloat(char paramChar)
  {
    this.matchStat = 0;
    char c1 = this.bp;
    char c2 = '\001';
    c1 = charAt(c1 + '\000');
    if ((c1 >= '0') && (c1 <= '9')) {}
    for (;;)
    {
      char c3 = this.bp;
      c1 = c2 + '\001';
      char c4 = charAt(c2 + c3);
      if ((c4 < '0') || (c4 > '9'))
      {
        c2 = c4;
        c3 = c1;
        float f;
        if (c4 == '.')
        {
          c3 = this.bp;
          c2 = c1 + '\001';
          c1 = charAt(c1 + c3);
          if ((c1 >= '0') && (c1 <= '9')) {
            for (;;)
            {
              c3 = this.bp;
              c1 = c2 + '\001';
              c4 = charAt(c2 + c3);
              c2 = c4;
              c3 = c1;
              if (c4 < '0') {
                break;
              }
              c2 = c4;
              c3 = c1;
              if (c4 > '9') {
                break;
              }
              c2 = c1;
            }
          }
          this.matchStat = -1;
          f = 0.0F;
        }
        for (;;)
        {
          return f;
          c1 = this.bp;
          f = Float.parseFloat(subString(c1, this.bp + c3 - c1 - 1));
          if (c2 == paramChar)
          {
            this.bp += c3 - '\001';
            next();
            this.matchStat = 3;
            this.token = 16;
            continue;
            this.matchStat = -1;
            f = 0.0F;
          }
          else
          {
            this.matchStat = -1;
          }
        }
      }
      c2 = c1;
    }
  }
  
  public final void scanIdent()
  {
    this.np = (this.bp - 1);
    this.hasSpecial = false;
    do
    {
      this.sp += 1;
      next();
    } while (Character.isLetterOrDigit(this.ch));
    Object localObject = stringVal();
    localObject = this.keywods.getKeyword((String)localObject);
    if (localObject != null) {}
    for (this.token = ((Integer)localObject).intValue();; this.token = 18) {
      return;
    }
  }
  
  public int scanInt(char paramChar)
  {
    this.matchStat = 0;
    char c1 = this.bp;
    char c2 = '\001';
    c1 = charAt(c1 + '\000');
    char c3;
    if ((c1 >= '0') && (c1 <= '9'))
    {
      c1 = digits[c1];
      for (;;)
      {
        char c4 = this.bp;
        c3 = c2 + '\001';
        c2 = charAt(c2 + c4);
        if ((c2 < '0') || (c2 > '9')) {
          break;
        }
        c1 = c1 * '\n' + digits[c2];
        c2 = c3;
      }
      if (c2 == '.')
      {
        this.matchStat = -1;
        paramChar = '\000';
      }
    }
    for (;;)
    {
      return paramChar;
      if (c1 < 0)
      {
        this.matchStat = -1;
        paramChar = '\000';
        continue;
        this.matchStat = -1;
        paramChar = '\000';
      }
      else if (c2 == paramChar)
      {
        this.bp += c3 - '\001';
        next();
        this.matchStat = 3;
        this.token = 16;
        paramChar = c1;
      }
      else
      {
        this.matchStat = -1;
        paramChar = c1;
      }
    }
  }
  
  public long scanLong(char paramChar)
  {
    this.matchStat = 0;
    char c2 = this.bp;
    char c1 = '\001';
    c2 = charAt(c2 + '\000');
    long l;
    if ((c2 >= '0') && (c2 <= '9'))
    {
      l = digits[c2];
      for (;;)
      {
        char c3 = this.bp;
        c2 = c1 + '\001';
        c1 = charAt(c1 + c3);
        if ((c1 < '0') || (c1 > '9')) {
          break;
        }
        l = l * 10L + digits[c1];
        c1 = c2;
      }
      if (c1 == '.')
      {
        this.matchStat = -1;
        l = 0L;
      }
    }
    for (;;)
    {
      return l;
      if (l < 0L)
      {
        this.matchStat = -1;
        l = 0L;
        continue;
        this.matchStat = -1;
        l = 0L;
      }
      else if (c1 == paramChar)
      {
        this.bp += c2 - '\001';
        next();
        this.matchStat = 3;
        this.token = 16;
      }
      else
      {
        this.matchStat = -1;
      }
    }
  }
  
  public final void scanNullOrNew()
  {
    if (this.ch != 'n') {
      throw new JSONException("error parse null or new");
    }
    next();
    if (this.ch == 'u')
    {
      next();
      if (this.ch != 'l') {
        throw new JSONException("error parse true");
      }
      next();
      if (this.ch != 'l') {
        throw new JSONException("error parse true");
      }
      next();
      if ((this.ch != ' ') && (this.ch != ',') && (this.ch != '}') && (this.ch != ']') && (this.ch != '\n') && (this.ch != '\r') && (this.ch != '\t') && (this.ch != '\032') && (this.ch != '\f') && (this.ch != '\b')) {}
    }
    for (this.token = 8;; this.token = 9)
    {
      return;
      throw new JSONException("scan true error");
      if (this.ch != 'e') {
        throw new JSONException("error parse e");
      }
      next();
      if (this.ch != 'w') {
        throw new JSONException("error parse w");
      }
      next();
      if ((this.ch != ' ') && (this.ch != ',') && (this.ch != '}') && (this.ch != ']') && (this.ch != '\n') && (this.ch != '\r') && (this.ch != '\t') && (this.ch != '\032') && (this.ch != '\f') && (this.ch != '\b')) {
        break;
      }
    }
    throw new JSONException("scan true error");
  }
  
  public final void scanNumber()
  {
    this.np = this.bp;
    if (this.ch == '-')
    {
      this.sp += 1;
      next();
    }
    while ((this.ch >= '0') && (this.ch <= '9'))
    {
      this.sp += 1;
      next();
    }
    int i = 0;
    if (this.ch == '.')
    {
      this.sp += 1;
      next();
      while ((this.ch >= '0') && (this.ch <= '9'))
      {
        this.sp += 1;
        next();
      }
      i = 1;
    }
    if (this.ch == 'L')
    {
      this.sp += 1;
      next();
      if (i == 0) {
        break label414;
      }
    }
    label414:
    for (this.token = 3;; this.token = 2)
    {
      return;
      if (this.ch == 'S')
      {
        this.sp += 1;
        next();
        break;
      }
      if (this.ch == 'B')
      {
        this.sp += 1;
        next();
        break;
      }
      if (this.ch == 'F')
      {
        this.sp += 1;
        next();
      }
      for (;;)
      {
        i = 1;
        break;
        if (this.ch == 'D')
        {
          this.sp += 1;
          next();
        }
        else
        {
          if ((this.ch != 'e') && (this.ch != 'E')) {
            break;
          }
          this.sp += 1;
          next();
          if ((this.ch == '+') || (this.ch == '-'))
          {
            this.sp += 1;
            next();
          }
          while ((this.ch >= '0') && (this.ch <= '9'))
          {
            this.sp += 1;
            next();
          }
          if ((this.ch == 'D') || (this.ch == 'F'))
          {
            this.sp += 1;
            next();
          }
        }
      }
    }
  }
  
  public final void scanSet()
  {
    if (this.ch != 'S') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 't') {
      throw new JSONException("error parse true");
    }
    next();
    if ((this.ch == ' ') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b') || (this.ch == '[') || (this.ch == '('))
    {
      this.token = 21;
      return;
    }
    throw new JSONException("scan set error");
  }
  
  public String scanString(char paramChar)
  {
    int k = 0;
    String str = null;
    this.matchStat = 0;
    int i = charAt(this.bp + 0);
    if (i == 110) {
      if ((charAt(this.bp + 1) == 'u') && (charAt(this.bp + 1 + 1) == 'l') && (charAt(this.bp + 1 + 2) == 'l'))
      {
        if (charAt(this.bp + 4) != paramChar) {
          break label122;
        }
        this.bp += 4;
        next();
        this.matchStat = 3;
      }
    }
    for (;;)
    {
      return str;
      this.matchStat = -1;
      continue;
      label122:
      this.matchStat = -1;
      continue;
      if (i != 34)
      {
        this.matchStat = -1;
        str = stringDefaultValue();
      }
      else
      {
        i = this.bp + 1;
        int m = indexOf('"', i);
        if (m == -1) {
          throw new JSONException("unclosed str");
        }
        str = subString(this.bp + 1, m - i);
        for (int j = this.bp + 1;; j++)
        {
          i = k;
          if (j < m)
          {
            if (charAt(j) == '\\') {
              i = 1;
            }
          }
          else
          {
            if (i == 0) {
              break label251;
            }
            this.matchStat = -1;
            str = stringDefaultValue();
            break;
          }
        }
        label251:
        i = m - (this.bp + 1) + 1 + 1;
        if (charAt(i + this.bp) == paramChar)
        {
          this.bp += i + 1 - 1;
          next();
          this.matchStat = 3;
        }
        else
        {
          this.matchStat = -1;
        }
      }
    }
  }
  
  public final void scanString()
  {
    this.np = this.bp;
    this.hasSpecial = false;
    for (;;)
    {
      char c = next();
      if (c == '"') {
        break;
      }
      if (c == '\032') {
        throw new JSONException("unclosed string : " + c);
      }
      int i;
      char[] arrayOfChar;
      if (c == '\\')
      {
        int j;
        if (!this.hasSpecial)
        {
          this.hasSpecial = true;
          if (this.sp >= this.sbuf.length)
          {
            j = this.sbuf.length * 2;
            i = j;
            if (this.sp > j) {
              i = this.sp;
            }
            arrayOfChar = new char[i];
            System.arraycopy(this.sbuf, 0, arrayOfChar, 0, this.sbuf.length);
            this.sbuf = arrayOfChar;
          }
          copyTo(this.np + 1, this.sp, this.sbuf);
        }
        c = next();
        switch (c)
        {
        default: 
          this.ch = c;
          throw new JSONException("unclosed string : " + c);
        case '0': 
          putChar('\000');
          break;
        case '1': 
          putChar('\001');
          break;
        case '2': 
          putChar('\002');
          break;
        case '3': 
          putChar('\003');
          break;
        case '4': 
          putChar('\004');
          break;
        case '5': 
          putChar('\005');
          break;
        case '6': 
          putChar('\006');
          break;
        case '7': 
          putChar('\007');
          break;
        case 'b': 
          putChar('\b');
          break;
        case 't': 
          putChar('\t');
          break;
        case 'n': 
          putChar('\n');
          break;
        case 'v': 
          putChar('\013');
          break;
        case 'F': 
        case 'f': 
          putChar('\f');
          break;
        case 'r': 
          putChar('\r');
          break;
        case '"': 
          putChar('"');
          break;
        case '\'': 
          putChar('\'');
          break;
        case '/': 
          putChar('/');
          break;
        case '\\': 
          putChar('\\');
          break;
        case 'x': 
          i = next();
          j = next();
          putChar((char)(digits[i] * 16 + digits[j]));
          break;
        case 'u': 
          putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }), 16));
          break;
        }
      }
      else if (!this.hasSpecial)
      {
        this.sp += 1;
      }
      else if (this.sp == this.sbuf.length)
      {
        putChar(c);
      }
      else
      {
        arrayOfChar = this.sbuf;
        i = this.sp;
        this.sp = (i + 1);
        arrayOfChar[i] = c;
      }
    }
    this.token = 4;
    this.ch = next();
  }
  
  public Collection<String> scanStringArray(Class<?> paramClass, char paramChar)
  {
    this.matchStat = 0;
    int i;
    if (paramClass.isAssignableFrom(HashSet.class))
    {
      paramClass = new HashSet();
      i = charAt(this.bp + 0);
      if (i != 110) {
        break label193;
      }
      if ((charAt(this.bp + 1) != 'u') || (charAt(this.bp + 1 + 1) != 'l') || (charAt(this.bp + 1 + 2) != 'l')) {
        break label173;
      }
      if (charAt(this.bp + 4) != paramChar) {
        break label183;
      }
      this.bp += 4;
      next();
      this.matchStat = 3;
      paramClass = null;
    }
    label173:
    label183:
    label193:
    int k;
    for (;;)
    {
      return paramClass;
      if (paramClass.isAssignableFrom(ArrayList.class))
      {
        paramClass = new ArrayList();
        break;
      }
      try
      {
        paramClass = (Collection)paramClass.newInstance();
      }
      catch (Exception paramClass)
      {
        throw new JSONException(paramClass.getMessage(), paramClass);
      }
      this.matchStat = -1;
      paramClass = null;
      continue;
      this.matchStat = -1;
      paramClass = null;
      continue;
      if (i != 91)
      {
        this.matchStat = -1;
        paramClass = null;
      }
      else
      {
        j = this.bp;
        i = 2;
        j = charAt(j + 1);
        while ((j == 110) && (charAt(this.bp + i) == 'u') && (charAt(this.bp + i + 1) == 'l') && (charAt(this.bp + i + 2) == 'l'))
        {
          k = i + 3;
          j = this.bp;
          i = k + 1;
          j = charAt(k + j);
          label310:
          if (j != 44) {
            break label457;
          }
          j = charAt(this.bp + i);
          i++;
        }
        if (j == 34) {
          break label352;
        }
        this.matchStat = -1;
        paramClass = null;
      }
    }
    label352:
    for (int j = i;; j = k)
    {
      int m = this.bp;
      k = j + 1;
      j = charAt(j + m);
      if (j == 34)
      {
        i = this.bp + i;
        paramClass.add(subString(i, this.bp + k - i - 1));
        j = this.bp;
        i = k + 1;
        j = charAt(j + k);
        break label310;
      }
      if (j == 92)
      {
        this.matchStat = -1;
        paramClass = null;
        break;
        label457:
        if (j == 93)
        {
          if (charAt(this.bp + i) != paramChar) {
            break label515;
          }
          this.bp += i + 1 - 1;
          next();
          this.matchStat = 3;
          break;
        }
        this.matchStat = -1;
        paramClass = null;
        break;
        label515:
        this.matchStat = -1;
        break;
      }
    }
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable)
  {
    Object localObject = null;
    skipWhitespace();
    if (this.ch == '"') {
      paramSymbolTable = scanSymbol(paramSymbolTable, '"');
    }
    for (;;)
    {
      return paramSymbolTable;
      if (this.ch == '\'')
      {
        if (!isEnabled(Feature.AllowSingleQuotes)) {
          throw new JSONException("syntax error");
        }
        paramSymbolTable = scanSymbol(paramSymbolTable, '\'');
      }
      else if (this.ch == '}')
      {
        next();
        this.token = 13;
        paramSymbolTable = (SymbolTable)localObject;
      }
      else if (this.ch == ',')
      {
        next();
        this.token = 16;
        paramSymbolTable = (SymbolTable)localObject;
      }
      else if (this.ch == '\032')
      {
        this.token = 20;
        paramSymbolTable = (SymbolTable)localObject;
      }
      else
      {
        if (!isEnabled(Feature.AllowUnQuotedFieldNames)) {
          throw new JSONException("syntax error");
        }
        paramSymbolTable = scanSymbolUnQuoted(paramSymbolTable);
      }
    }
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable, char paramChar)
  {
    this.np = this.bp;
    this.sp = 0;
    int j = 0;
    int i = 0;
    for (;;)
    {
      char c1 = next();
      if (c1 == paramChar) {
        break;
      }
      if (c1 == '\032') {
        throw new JSONException("unclosed.str");
      }
      int k;
      char[] arrayOfChar;
      if (c1 == '\\')
      {
        k = j;
        if (j == 0)
        {
          if (this.sp >= this.sbuf.length)
          {
            k = this.sbuf.length * 2;
            j = k;
            if (this.sp > k) {
              j = this.sp;
            }
            arrayOfChar = new char[j];
            System.arraycopy(this.sbuf, 0, arrayOfChar, 0, this.sbuf.length);
            this.sbuf = arrayOfChar;
          }
          arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
          k = 1;
        }
        c1 = next();
        switch (c1)
        {
        default: 
          this.ch = c1;
          throw new JSONException("unclosed.str.lit");
        case '0': 
          i = i * 31 + c1;
          putChar('\000');
          j = k;
          break;
        case '1': 
          i = i * 31 + c1;
          putChar('\001');
          j = k;
          break;
        case '2': 
          i = i * 31 + c1;
          putChar('\002');
          j = k;
          break;
        case '3': 
          i = i * 31 + c1;
          putChar('\003');
          j = k;
          break;
        case '4': 
          i = i * 31 + c1;
          putChar('\004');
          j = k;
          break;
        case '5': 
          i = i * 31 + c1;
          putChar('\005');
          j = k;
          break;
        case '6': 
          i = i * 31 + c1;
          putChar('\006');
          j = k;
          break;
        case '7': 
          i = i * 31 + c1;
          putChar('\007');
          j = k;
          break;
        case 'b': 
          i = i * 31 + 8;
          putChar('\b');
          j = k;
          break;
        case 't': 
          i = i * 31 + 9;
          putChar('\t');
          j = k;
          break;
        case 'n': 
          i = i * 31 + 10;
          putChar('\n');
          j = k;
          break;
        case 'v': 
          i = i * 31 + 11;
          putChar('\013');
          j = k;
          break;
        case 'F': 
        case 'f': 
          i = i * 31 + 12;
          putChar('\f');
          j = k;
          break;
        case 'r': 
          i = i * 31 + 13;
          putChar('\r');
          j = k;
          break;
        case '"': 
          i = i * 31 + 34;
          putChar('"');
          j = k;
          break;
        case '\'': 
          i = i * 31 + 39;
          putChar('\'');
          j = k;
          break;
        case '/': 
          i = i * 31 + 47;
          putChar('/');
          j = k;
          break;
        case '\\': 
          i = i * 31 + 92;
          putChar('\\');
          j = k;
          break;
        case 'x': 
          c1 = next();
          this.ch = c1;
          char c2 = next();
          this.ch = c2;
          c1 = (char)(digits[c1] * 16 + digits[c2]);
          i = i * 31 + c1;
          putChar(c1);
          j = k;
          break;
        case 'u': 
          j = Integer.parseInt(new String(new char[] { next(), next(), next(), next() }), 16);
          i = i * 31 + j;
          putChar((char)j);
          j = k;
          break;
        }
      }
      else
      {
        i = i * 31 + c1;
        if (j == 0)
        {
          this.sp += 1;
        }
        else if (this.sp == this.sbuf.length)
        {
          putChar(c1);
        }
        else
        {
          arrayOfChar = this.sbuf;
          k = this.sp;
          this.sp = (k + 1);
          arrayOfChar[k] = c1;
        }
      }
    }
    this.token = 4;
    if (j == 0) {
      if (this.np == -1) {
        paramChar = '\000';
      }
    }
    for (paramSymbolTable = addSymbol(paramChar, this.sp, i, paramSymbolTable);; paramSymbolTable = paramSymbolTable.addSymbol(this.sbuf, 0, this.sp, i))
    {
      this.sp = 0;
      next();
      return paramSymbolTable;
      paramChar = this.np + 1;
      break;
    }
  }
  
  public final String scanSymbolUnQuoted(SymbolTable paramSymbolTable)
  {
    boolean[] arrayOfBoolean = CharTypes.firstIdentifierFlags;
    int j = this.ch;
    if ((this.ch >= arrayOfBoolean.length) || (arrayOfBoolean[j] != 0)) {}
    for (int i = 1; i == 0; i = 0) {
      throw new JSONException("illegal identifier : " + this.ch);
    }
    arrayOfBoolean = CharTypes.identifierFlags;
    this.np = this.bp;
    this.sp = 1;
    i = j;
    for (;;)
    {
      j = next();
      if ((j < arrayOfBoolean.length) && (arrayOfBoolean[j] == 0)) {
        break;
      }
      i = i * 31 + j;
      this.sp += 1;
    }
    this.ch = charAt(this.bp);
    this.token = 18;
    if ((this.sp == 4) && (i == 3392903) && (charAt(this.np) == 'n') && (charAt(this.np + 1) == 'u') && (charAt(this.np + 2) == 'l') && (charAt(this.np + 3) == 'l')) {}
    for (paramSymbolTable = null;; paramSymbolTable = addSymbol(this.np, this.sp, i, paramSymbolTable)) {
      return paramSymbolTable;
    }
  }
  
  public String scanSymbolWithSeperator(SymbolTable paramSymbolTable, char paramChar)
  {
    int i = 0;
    this.matchStat = 0;
    int k = this.bp;
    int j = 1;
    k = charAt(k + 0);
    if (k == 110) {
      if ((charAt(this.bp + 1) == 'u') && (charAt(this.bp + 1 + 1) == 'l') && (charAt(this.bp + 1 + 2) == 'l'))
      {
        if (charAt(this.bp + 4) != paramChar) {
          break label130;
        }
        this.bp += 4;
        next();
        this.matchStat = 3;
        paramSymbolTable = null;
      }
    }
    for (;;)
    {
      return paramSymbolTable;
      this.matchStat = -1;
      paramSymbolTable = null;
      continue;
      label130:
      this.matchStat = -1;
      paramSymbolTable = null;
      continue;
      if (k != 34)
      {
        this.matchStat = -1;
        paramSymbolTable = null;
      }
      else
      {
        do
        {
          j = k;
          int m = this.bp;
          k = j + 1;
          j = charAt(j + m);
          if (j == 34)
          {
            j = this.bp + 0 + 1;
            paramSymbolTable = addSymbol(j, this.bp + k - j - 1, i, paramSymbolTable);
            if (charAt(this.bp + k) != paramChar) {
              break label290;
            }
            this.bp += k + 1 - 1;
            next();
            this.matchStat = 3;
            break;
          }
          i = i * 31 + j;
        } while (j != 92);
        this.matchStat = -1;
        paramSymbolTable = null;
        continue;
        label290:
        this.matchStat = -1;
      }
    }
  }
  
  public final void scanTreeSet()
  {
    if (this.ch != 'T') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'r') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'S') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 't') {
      throw new JSONException("error parse true");
    }
    next();
    if ((this.ch == ' ') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b') || (this.ch == '[') || (this.ch == '('))
    {
      this.token = 22;
      return;
    }
    throw new JSONException("scan set error");
  }
  
  public final void scanTrue()
  {
    if (this.ch != 't') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'r') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'u') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b'))
    {
      this.token = 6;
      return;
    }
    throw new JSONException("scan true error");
  }
  
  public int scanType(String paramString)
  {
    int i = 0;
    this.matchStat = 0;
    if (!charArrayCompare(typeFieldName)) {
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
          break label70;
        }
        if (paramString.charAt(i) != charAt(k + i))
        {
          i = -1;
          break;
        }
        i++;
      }
      label70:
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
              break label210;
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
            label210:
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
                break label288;
              }
              this.token = 20;
            }
          }
          label288:
          i = -1;
        }
      }
    }
  }
  
  public final void skipWhitespace()
  {
    while ((this.ch < whitespaceFlags.length) && (whitespaceFlags[this.ch] != 0)) {
      next();
    }
  }
  
  public final String stringDefaultValue()
  {
    if (isEnabled(Feature.InitStringFieldAsEmpty)) {}
    for (String str = "";; str = null) {
      return str;
    }
  }
  
  public abstract String stringVal();
  
  public abstract String subString(int paramInt1, int paramInt2);
  
  public final int token()
  {
    return this.token;
  }
  
  public final String tokenName()
  {
    return JSONToken.name(this.token);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/JSONLexerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */