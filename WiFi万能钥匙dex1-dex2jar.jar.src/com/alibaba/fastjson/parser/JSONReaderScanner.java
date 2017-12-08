package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.Base64;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.SoftReference;

public final class JSONReaderScanner
  extends JSONLexerBase
{
  public static int BUF_INIT_LEN = 8192;
  private static final ThreadLocal<SoftReference<char[]>> BUF_REF_LOCAL = new ThreadLocal();
  private char[] buf;
  private int bufLength;
  private Reader reader;
  
  public JSONReaderScanner(Reader paramReader)
  {
    this(paramReader, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONReaderScanner(Reader paramReader, int paramInt)
  {
    this.reader = paramReader;
    this.features = paramInt;
    SoftReference localSoftReference = (SoftReference)BUF_REF_LOCAL.get();
    if (localSoftReference != null)
    {
      this.buf = ((char[])localSoftReference.get());
      BUF_REF_LOCAL.set(null);
    }
    if (this.buf == null) {
      this.buf = new char[BUF_INIT_LEN];
    }
    try
    {
      this.bufLength = paramReader.read(this.buf);
      this.bp = -1;
      next();
      if (this.ch == 65279) {
        next();
      }
      return;
    }
    catch (IOException paramReader)
    {
      throw new JSONException(paramReader.getMessage(), paramReader);
    }
  }
  
  public JSONReaderScanner(String paramString)
  {
    this(paramString, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONReaderScanner(String paramString, int paramInt)
  {
    this(new StringReader(paramString), paramInt);
  }
  
  public JSONReaderScanner(char[] paramArrayOfChar, int paramInt)
  {
    this(paramArrayOfChar, paramInt, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONReaderScanner(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this(new CharArrayReader(paramArrayOfChar, 0, paramInt1), paramInt2);
  }
  
  public final String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable)
  {
    return paramSymbolTable.addSymbol(this.buf, paramInt1, paramInt2, paramInt3);
  }
  
  protected final void arrayCopy(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.buf, paramInt1, paramArrayOfChar, paramInt2, paramInt3);
  }
  
  public final byte[] bytesValue()
  {
    return Base64.decodeFast(this.buf, this.np + 1, this.sp);
  }
  
  public final boolean charArrayCompare(char[] paramArrayOfChar)
  {
    boolean bool = false;
    int i = 0;
    if (i < paramArrayOfChar.length) {
      if (charAt(this.bp + i) == paramArrayOfChar[i]) {}
    }
    for (;;)
    {
      return bool;
      i++;
      break;
      bool = true;
    }
  }
  
  public final char charAt(int paramInt)
  {
    char c = '\032';
    int i = paramInt;
    if (paramInt >= this.bufLength) {
      if (this.bufLength == -1) {
        if (paramInt < this.sp) {
          c = this.buf[paramInt];
        }
      }
    }
    for (;;)
    {
      return c;
      i = this.bufLength - this.bp;
      if (i > 0) {
        System.arraycopy(this.buf, this.bp, this.buf, 0, i);
      }
      try
      {
        this.bufLength = this.reader.read(this.buf, i, this.buf.length - i);
        if (this.bufLength == 0) {
          throw new JSONException("illegal stat, textLength is zero");
        }
      }
      catch (IOException localIOException)
      {
        throw new JSONException(localIOException.getMessage(), localIOException);
      }
      if (this.bufLength != -1)
      {
        this.bufLength += i;
        i = paramInt - this.bp;
        this.np -= this.bp;
        this.bp = 0;
        c = this.buf[i];
      }
    }
  }
  
  public final void close()
  {
    super.close();
    BUF_REF_LOCAL.set(new SoftReference(this.buf));
    this.buf = null;
    IOUtils.close(this.reader);
  }
  
  protected final void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    System.arraycopy(this.buf, paramInt1, paramArrayOfChar, 0, paramInt2);
  }
  
  public final int indexOf(char paramChar, int paramInt)
  {
    paramInt -= this.bp;
    for (;;)
    {
      if (paramChar == charAt(this.bp + paramInt)) {}
      for (paramChar = paramInt + this.bp;; paramChar = '￿')
      {
        return paramChar;
        if (paramChar != '\032') {
          break;
        }
      }
      paramInt++;
    }
  }
  
  public final boolean isEOF()
  {
    if ((this.bufLength == -1) || (this.bp == this.buf.length) || ((this.ch == '\032') && (this.bp + 1 == this.buf.length))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final char next()
  {
    int j = this.bp + 1;
    this.bp = j;
    int i = j;
    char c;
    if (j >= this.bufLength) {
      if (this.bufLength == -1) {
        c = '\032';
      }
    }
    for (;;)
    {
      return c;
      if (this.sp > 0)
      {
        j = this.bufLength - this.sp;
        i = j;
        if (this.ch == '"') {
          i = j - 1;
        }
        System.arraycopy(this.buf, i, this.buf, 0, this.sp);
      }
      this.np = -1;
      i = this.sp;
      this.bp = i;
      try
      {
        j = this.bp;
        int k = this.buf.length;
        this.bufLength = this.reader.read(this.buf, this.bp, k - j);
        if (this.bufLength == 0) {
          throw new JSONException("illegal stat, textLength is zero");
        }
      }
      catch (IOException localIOException)
      {
        throw new JSONException(localIOException.getMessage(), localIOException);
      }
      if (this.bufLength == -1)
      {
        this.ch = '\032';
        c = '\032';
      }
      else
      {
        this.bufLength += this.bp;
        c = this.buf[i];
        this.ch = c;
      }
    }
  }
  
  public final String numberString()
  {
    int j = this.np;
    int i = j;
    if (j == -1) {
      i = 0;
    }
    int m = charAt(this.sp + i - 1);
    int k = this.sp;
    if ((m != 76) && (m != 83) && (m != 66) && (m != 70))
    {
      j = k;
      if (m != 68) {}
    }
    else
    {
      j = k - 1;
    }
    return new String(this.buf, i, j);
  }
  
  public final String stringVal()
  {
    int i;
    if (!this.hasSpecial)
    {
      i = this.np + 1;
      if (i < 0) {
        throw new IllegalStateException();
      }
      if (i > this.buf.length - this.sp) {
        throw new IllegalStateException();
      }
    }
    for (String str = new String(this.buf, i, this.sp);; str = new String(this.sbuf, 0, this.sp)) {
      return str;
    }
  }
  
  public final String subString(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      throw new StringIndexOutOfBoundsException(paramInt2);
    }
    return new String(this.buf, paramInt1, paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/JSONReaderScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */