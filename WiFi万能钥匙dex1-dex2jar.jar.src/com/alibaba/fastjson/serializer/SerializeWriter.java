package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.CharTypes;
import com.alibaba.fastjson.util.Base64;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.nio.charset.Charset;

public final class SerializeWriter
  extends Writer
{
  private static final ThreadLocal<SoftReference<char[]>> bufLocal = new ThreadLocal();
  protected char[] buf;
  protected int count;
  private int features;
  private final Writer writer;
  
  public SerializeWriter()
  {
    this(null);
  }
  
  public SerializeWriter(int paramInt)
  {
    this(null, paramInt);
  }
  
  public SerializeWriter(Writer paramWriter)
  {
    this.writer = paramWriter;
    this.features = JSON.DEFAULT_GENERATE_FEATURE;
    paramWriter = (SoftReference)bufLocal.get();
    if (paramWriter != null)
    {
      this.buf = ((char[])paramWriter.get());
      bufLocal.set(null);
    }
    if (this.buf == null) {
      this.buf = new char['Ѐ'];
    }
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt)
  {
    this.writer = paramWriter;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Negative initial size: " + paramInt);
    }
    this.buf = new char[paramInt];
  }
  
  public SerializeWriter(Writer paramWriter, SerializerFeature... paramVarArgs)
  {
    this.writer = paramWriter;
    paramWriter = (SoftReference)bufLocal.get();
    if (paramWriter != null)
    {
      this.buf = ((char[])paramWriter.get());
      bufLocal.set(null);
    }
    if (this.buf == null) {
      this.buf = new char['Ѐ'];
    }
    int k = paramVarArgs.length;
    for (int i = 0; i < k; i++) {
      j |= paramVarArgs[i].getMask();
    }
    this.features = j;
  }
  
  public SerializeWriter(SerializerFeature... paramVarArgs)
  {
    this(null, paramVarArgs);
  }
  
  static final boolean isSpecial(char paramChar, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramChar == ' ') {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramChar == '/') && (SerializerFeature.isEnabled(paramInt, SerializerFeature.WriteSlashAsSpecial)))
      {
        bool1 = true;
      }
      else if (paramChar > '#')
      {
        bool1 = bool2;
        if (paramChar != '\\') {}
      }
      else if ((paramChar > '\r') && (paramChar != '\\'))
      {
        bool1 = bool2;
        if (paramChar != '"') {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  private void writeFieldValueStringWithDoubleQuote(char paramChar, String paramString1, String paramString2, boolean paramBoolean)
  {
    int k = paramString1.length();
    int i = this.count;
    int j;
    if (paramString2 == null)
    {
      j = 4;
      i += k + 8;
      if (i <= this.buf.length) {
        break label97;
      }
      if (this.writer == null) {
        break label91;
      }
      write(paramChar);
      writeStringWithDoubleQuote(paramString1, ':', paramBoolean);
      writeStringWithDoubleQuote(paramString2, '\000', paramBoolean);
    }
    label91:
    label97:
    int m;
    int n;
    for (;;)
    {
      return;
      j = paramString2.length();
      i += k + j + 6;
      break;
      expandCapacity(i);
      this.buf[this.count] = paramChar;
      m = this.count + 2;
      n = m + k;
      this.buf[(this.count + 1)] = '"';
      paramString1.getChars(0, k, this.buf, m);
      this.count = i;
      this.buf[n] = '"';
      m = n + 1;
      paramString1 = this.buf;
      k = m + 1;
      paramString1[m] = 58;
      if (paramString2 != null) {
        break label247;
      }
      paramString1 = this.buf;
      i = k + 1;
      paramString1[k] = 110;
      paramString1 = this.buf;
      j = i + 1;
      paramString1[i] = 117;
      this.buf[j] = 'l';
      this.buf[(j + 1)] = 'l';
    }
    label247:
    paramString1 = this.buf;
    int i4 = k + 1;
    paramString1[k] = 34;
    int i5 = i4 + j;
    paramString2.getChars(0, j, this.buf, i4);
    int i2;
    int i1;
    if ((paramBoolean) && (!isEnabled(SerializerFeature.DisableCheckSpecialChar)))
    {
      m = 0;
      n = -1;
      i2 = -1;
      i1 = 0;
      j = i4;
      k = i;
      i = j;
      j = i2;
      label327:
      if (i < i5)
      {
        paramChar = this.buf[i];
        if (paramChar != ' ') {
          break label938;
        }
        i1 = m + 1;
        k += 4;
        if (j != -1) {
          break label928;
        }
        n = paramChar;
        m = i;
        j = i;
      }
    }
    for (;;)
    {
      if ((paramChar < ']') && (isSpecial(paramChar, this.features)))
      {
        m = i1 + 1;
        if (j == -1)
        {
          n = i;
          j = i;
          i1 = paramChar;
        }
      }
      for (;;)
      {
        i++;
        break label327;
        if (m > 0)
        {
          i = k + m;
          if (i > this.buf.length) {
            expandCapacity(i);
          }
          this.count = i;
          if (m != 1) {
            break label644;
          }
          if (i1 != 8232) {
            break label591;
          }
          System.arraycopy(this.buf, n + 1, this.buf, n + 6, i5 - n - 1);
          this.buf[n] = '\\';
          paramString1 = this.buf;
          i = n + 1;
          paramString1[i] = 117;
          paramString1 = this.buf;
          i++;
          paramString1[i] = 50;
          paramString1 = this.buf;
          i++;
          paramString1[i] = 48;
          paramString1 = this.buf;
          i++;
          paramString1[i] = 50;
          this.buf[(i + 1)] = '8';
        }
        label591:
        label644:
        while (m <= 1) {
          for (;;)
          {
            this.buf[(this.count - 1)] = '"';
            break;
            System.arraycopy(this.buf, n + 1, this.buf, n + 2, i5 - n - 1);
            this.buf[n] = '\\';
            this.buf[(n + 1)] = CharTypes.replaceChars[i1];
          }
        }
        k = j - i4;
        i = j;
        j = k;
        label665:
        if (j < paramString2.length())
        {
          paramChar = paramString2.charAt(j);
          if (((paramChar >= CharTypes.specicalFlags_doubleQuotes.length) || (CharTypes.specicalFlags_doubleQuotes[paramChar] == 0)) && ((paramChar != '/') || (!isEnabled(SerializerFeature.WriteSlashAsSpecial)))) {
            break label885;
          }
          paramString1 = this.buf;
          k = i + 1;
          paramString1[i] = 92;
          if (CharTypes.specicalFlags_doubleQuotes[paramChar] != 1) {
            break label765;
          }
          paramString1 = this.buf;
          i = k + 1;
          paramString1[k] = CharTypes.replaceChars[paramChar];
        }
        for (;;)
        {
          j++;
          break label665;
          break;
          label765:
          paramString1 = this.buf;
          i = k + 1;
          paramString1[k] = 117;
          paramString1 = this.buf;
          k = i + 1;
          paramString1[i] = CharTypes.digits[(paramChar >>> '\f' & 0xF)];
          paramString1 = this.buf;
          i = k + 1;
          paramString1[k] = CharTypes.digits[(paramChar >>> '\b' & 0xF)];
          paramString1 = this.buf;
          k = i + 1;
          paramString1[i] = CharTypes.digits[(paramChar >>> '\004' & 0xF)];
          paramString1 = this.buf;
          i = k + 1;
          paramString1[k] = CharTypes.digits[(paramChar & 0xF)];
          continue;
          label885:
          this.buf[i] = paramChar;
          i++;
        }
        n = i;
        i1 = paramChar;
        continue;
        i2 = m;
        m = i1;
        i1 = n;
        n = i2;
      }
      label928:
      m = i;
      n = paramChar;
      continue;
      label938:
      int i3 = i1;
      i2 = n;
      i1 = m;
      n = i3;
      m = i2;
    }
  }
  
  private void writeKeyWithDoubleQuoteIfHasSpecial(String paramString)
  {
    byte[] arrayOfByte = CharTypes.specicalFlags_doubleQuotes;
    int m = paramString.length();
    int i4 = this.count + m + 1;
    int k;
    if (i4 > this.buf.length) {
      if (this.writer != null)
      {
        if (m == 0)
        {
          write('"');
          write('"');
          write(':');
          return;
        }
        j = 0;
        if (j >= m) {
          break label653;
        }
        k = paramString.charAt(j);
        if ((k >= arrayOfByte.length) || (arrayOfByte[k] == 0)) {}
      }
    }
    label109:
    label547:
    label653:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        write('"');
      }
      k = 0;
      if (k < m)
      {
        int i = paramString.charAt(k);
        if ((i < arrayOfByte.length) && (arrayOfByte[i] != 0))
        {
          write('\\');
          write(CharTypes.replaceChars[i]);
        }
        for (;;)
        {
          k++;
          break label109;
          j++;
          break;
          write(i);
        }
      }
      if (j != 0) {
        write('"');
      }
      write(':');
      break;
      expandCapacity(i4);
      if (m == 0)
      {
        if (this.count + 3 > this.buf.length) {
          expandCapacity(this.count + 3);
        }
        paramString = this.buf;
        j = this.count;
        this.count = (j + 1);
        paramString[j] = 34;
        paramString = this.buf;
        j = this.count;
        this.count = (j + 1);
        paramString[j] = 34;
        paramString = this.buf;
        j = this.count;
        this.count = (j + 1);
        paramString[j] = 58;
        break;
      }
      int i5 = this.count;
      int i1 = i5 + m;
      paramString.getChars(0, m, this.buf, i5);
      this.count = i4;
      int i2 = 0;
      j = i5;
      if (j < i1)
      {
        int i6 = this.buf[j];
        int i3 = i2;
        k = i1;
        m = i4;
        int n = j;
        if (i6 < arrayOfByte.length)
        {
          i3 = i2;
          k = i1;
          m = i4;
          n = j;
          if (arrayOfByte[i6] != 0)
          {
            if (i2 != 0) {
              break label547;
            }
            m = i4 + 3;
            if (m > this.buf.length) {
              expandCapacity(m);
            }
            this.count = m;
            System.arraycopy(this.buf, j + 1, this.buf, j + 3, i1 - j - 1);
            System.arraycopy(this.buf, 0, this.buf, 1, j);
            this.buf[i5] = '"';
            paramString = this.buf;
            j++;
            paramString[j] = 92;
            paramString = this.buf;
            n = j + 1;
            paramString[n] = CharTypes.replaceChars[i6];
            k = i1 + 2;
            this.buf[(this.count - 2)] = '"';
          }
        }
        for (i3 = 1;; i3 = i2)
        {
          j = n + 1;
          i2 = i3;
          i1 = k;
          i4 = m;
          break;
          m = i4 + 1;
          if (m > this.buf.length) {
            expandCapacity(m);
          }
          this.count = m;
          System.arraycopy(this.buf, j + 1, this.buf, j + 2, i1 - j);
          this.buf[j] = '\\';
          paramString = this.buf;
          n = j + 1;
          paramString[n] = CharTypes.replaceChars[i6];
          k = i1 + 1;
        }
      }
      this.buf[(this.count - 1)] = ':';
      break;
    }
  }
  
  private void writeKeyWithSingleQuoteIfHasSpecial(String paramString)
  {
    byte[] arrayOfByte = CharTypes.specicalFlags_singleQuotes;
    int m = paramString.length();
    int i4 = this.count + m + 1;
    int k;
    if (i4 > this.buf.length) {
      if (this.writer != null)
      {
        if (m == 0)
        {
          write('\'');
          write('\'');
          write(':');
          return;
        }
        j = 0;
        if (j >= m) {
          break label651;
        }
        k = paramString.charAt(j);
        if ((k >= arrayOfByte.length) || (arrayOfByte[k] == 0)) {}
      }
    }
    label109:
    label547:
    label651:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        write('\'');
      }
      k = 0;
      if (k < m)
      {
        int i = paramString.charAt(k);
        if ((i < arrayOfByte.length) && (arrayOfByte[i] != 0))
        {
          write('\\');
          write(CharTypes.replaceChars[i]);
        }
        for (;;)
        {
          k++;
          break label109;
          j++;
          break;
          write(i);
        }
      }
      if (j != 0) {
        write('\'');
      }
      write(':');
      break;
      expandCapacity(i4);
      if (m == 0)
      {
        if (this.count + 3 > this.buf.length) {
          expandCapacity(this.count + 3);
        }
        paramString = this.buf;
        j = this.count;
        this.count = (j + 1);
        paramString[j] = 39;
        paramString = this.buf;
        j = this.count;
        this.count = (j + 1);
        paramString[j] = 39;
        paramString = this.buf;
        j = this.count;
        this.count = (j + 1);
        paramString[j] = 58;
        break;
      }
      int i5 = this.count;
      int i1 = i5 + m;
      paramString.getChars(0, m, this.buf, i5);
      this.count = i4;
      int i2 = 0;
      j = i5;
      if (j < i1)
      {
        int i6 = this.buf[j];
        int i3 = i2;
        m = i1;
        k = i4;
        int n = j;
        if (i6 < arrayOfByte.length)
        {
          i3 = i2;
          m = i1;
          k = i4;
          n = j;
          if (arrayOfByte[i6] != 0)
          {
            if (i2 != 0) {
              break label547;
            }
            k = i4 + 3;
            if (k > this.buf.length) {
              expandCapacity(k);
            }
            this.count = k;
            System.arraycopy(this.buf, j + 1, this.buf, j + 3, i1 - j - 1);
            System.arraycopy(this.buf, 0, this.buf, 1, j);
            this.buf[i5] = '\'';
            paramString = this.buf;
            j++;
            paramString[j] = 92;
            paramString = this.buf;
            n = j + 1;
            paramString[n] = CharTypes.replaceChars[i6];
            m = i1 + 2;
            this.buf[(this.count - 2)] = '\'';
          }
        }
        for (i3 = 1;; i3 = i2)
        {
          j = n + 1;
          i2 = i3;
          i1 = m;
          i4 = k;
          break;
          k = i4 + 1;
          if (k > this.buf.length) {
            expandCapacity(k);
          }
          this.count = k;
          System.arraycopy(this.buf, j + 1, this.buf, j + 2, i1 - j);
          this.buf[j] = '\\';
          paramString = this.buf;
          n = j + 1;
          paramString[n] = CharTypes.replaceChars[i6];
          m = i1 + 1;
        }
      }
      this.buf[(i4 - 1)] = ':';
      break;
    }
  }
  
  private void writeStringWithDoubleQuote(String paramString, char paramChar)
  {
    writeStringWithDoubleQuote(paramString, paramChar, true);
  }
  
  private void writeStringWithDoubleQuote(String paramString, char paramChar, boolean paramBoolean)
  {
    if (paramString == null)
    {
      writeNull();
      if (paramChar != 0) {
        write(paramChar);
      }
    }
    int n;
    int k;
    int m;
    int i5;
    int i10;
    int j;
    for (;;)
    {
      return;
      n = paramString.length();
      k = this.count + n + 2;
      m = k;
      if (paramChar != 0) {
        m = k + 1;
      }
      if (m > this.buf.length)
      {
        if (this.writer != null)
        {
          write('"');
          k = 0;
          if (k < paramString.length())
          {
            int i = paramString.charAt(k);
            if (isEnabled(SerializerFeature.BrowserCompatible)) {
              if ((i == 8) || (i == 12) || (i == 10) || (i == 13) || (i == 9) || (i == 34) || (i == 47) || (i == 92))
              {
                write('\\');
                write(CharTypes.replaceChars[i]);
              }
            }
            for (;;)
            {
              k++;
              break;
              if (i < 32)
              {
                write('\\');
                write('u');
                write('0');
                write('0');
                write(CharTypes.ASCII_CHARS[(i * 2)]);
                write(CharTypes.ASCII_CHARS[(i * 2 + 1)]);
              }
              else
              {
                if (i >= 127)
                {
                  write('\\');
                  write('u');
                  write(CharTypes.digits[(i >>> 12 & 0xF)]);
                  write(CharTypes.digits[(i >>> 8 & 0xF)]);
                  write(CharTypes.digits[(i >>> 4 & 0xF)]);
                  write(CharTypes.digits[(i & 0xF)]);
                  continue;
                  if (((i < CharTypes.specicalFlags_doubleQuotes.length) && (CharTypes.specicalFlags_doubleQuotes[i] != 0)) || ((i == 47) && (isEnabled(SerializerFeature.WriteSlashAsSpecial))))
                  {
                    write('\\');
                    write(CharTypes.replaceChars[i]);
                    continue;
                  }
                }
                write(i);
              }
            }
          }
          write('"');
          if (paramChar != 0) {
            write(paramChar);
          }
        }
        else
        {
          expandCapacity(m);
        }
      }
      else
      {
        i5 = this.count + 1;
        i10 = i5 + n;
        this.buf[this.count] = '"';
        paramString.getChars(0, n, this.buf, i5);
        this.count = m;
        if (!isEnabled(SerializerFeature.BrowserCompatible)) {
          break;
        }
        n = -1;
        k = i5;
        i1 = m;
        if (k < i10)
        {
          i2 = this.buf[k];
          if ((i2 == 34) || (i2 == 47) || (i2 == 92))
          {
            m = i1 + 1;
            n = k;
          }
          for (;;)
          {
            k++;
            i1 = m;
            break;
            if ((i2 == 8) || (i2 == 12) || (i2 == 10) || (i2 == 13) || (i2 == 9))
            {
              m = i1 + 1;
              n = k;
            }
            else if (i2 < 32)
            {
              m = i1 + 5;
              n = k;
            }
            else
            {
              m = i1;
              if (i2 >= 127)
              {
                m = i1 + 5;
                n = k;
              }
            }
          }
        }
        if (i1 > this.buf.length) {
          expandCapacity(i1);
        }
        this.count = i1;
        m = i10;
        if (n >= i5)
        {
          j = this.buf[n];
          if ((j == 8) || (j == 12) || (j == 10) || (j == 13) || (j == 9))
          {
            System.arraycopy(this.buf, n + 1, this.buf, n + 2, m - n - 1);
            this.buf[n] = '\\';
            this.buf[(n + 1)] = CharTypes.replaceChars[j];
            k = m + 1;
          }
          for (;;)
          {
            n--;
            m = k;
            break;
            if ((j == 34) || (j == 47) || (j == 92))
            {
              System.arraycopy(this.buf, n + 1, this.buf, n + 2, m - n - 1);
              this.buf[n] = '\\';
              this.buf[(n + 1)] = j;
              k = m + 1;
            }
            else if (j < 32)
            {
              System.arraycopy(this.buf, n + 1, this.buf, n + 6, m - n - 1);
              this.buf[n] = '\\';
              this.buf[(n + 1)] = 'u';
              this.buf[(n + 2)] = '0';
              this.buf[(n + 3)] = '0';
              this.buf[(n + 4)] = CharTypes.ASCII_CHARS[(j * 2)];
              this.buf[(n + 5)] = CharTypes.ASCII_CHARS[(j * 2 + 1)];
              k = m + 5;
            }
            else
            {
              k = m;
              if (j >= 127)
              {
                System.arraycopy(this.buf, n + 1, this.buf, n + 6, m - n - 1);
                this.buf[n] = '\\';
                this.buf[(n + 1)] = 'u';
                this.buf[(n + 2)] = CharTypes.digits[(j >>> 12 & 0xF)];
                this.buf[(n + 3)] = CharTypes.digits[(j >>> 8 & 0xF)];
                this.buf[(n + 4)] = CharTypes.digits[(j >>> 4 & 0xF)];
                this.buf[(n + 5)] = CharTypes.digits[(j & 0xF)];
                k = m + 5;
              }
            }
          }
        }
        if (paramChar != 0)
        {
          this.buf[(this.count - 2)] = '"';
          this.buf[(this.count - 1)] = paramChar;
        }
        else
        {
          this.buf[(this.count - 1)] = '"';
        }
      }
    }
    int i6 = 0;
    int i1 = 0;
    int i2 = -1;
    int i4 = -1;
    int i9 = 0;
    int i3 = 0;
    label1193:
    int i8;
    int i7;
    if (paramBoolean)
    {
      k = i5;
      n = m;
      m = i4;
      i9 = i3;
      i4 = m;
      i8 = i2;
      i7 = n;
      i6 = i1;
      if (k >= i10) {
        break label1399;
      }
      i6 = this.buf[k];
      if (i6 >= 93)
      {
        if (i6 != 8232) {
          break label1796;
        }
        i2 = i1 + 1;
        i1 = n + 4;
        if (m != -1) {
          break label1819;
        }
        n = k;
        m = k;
        i3 = i6;
      }
    }
    for (;;)
    {
      k++;
      i4 = i2;
      i2 = n;
      n = i1;
      i1 = i4;
      break label1193;
      if ((i6 != 32) && ((i6 < 48) || (i6 == 92)) && (((i6 < CharTypes.specicalFlags_doubleQuotes.length) && (CharTypes.specicalFlags_doubleQuotes[i6] != 0)) || ((i6 == 47) && (isEnabled(SerializerFeature.WriteSlashAsSpecial)))))
      {
        i2 = i1 + 1;
        if (m == -1)
        {
          i1 = k;
          i4 = n;
          m = k;
          i3 = i6;
          n = i1;
          i1 = i4;
          continue;
          i7 = m;
          i8 = i2;
          label1399:
          k = i7 + i6;
          if (k > this.buf.length) {
            expandCapacity(k);
          }
          this.count = k;
          if (i6 == 1) {
            if (i9 == 8232)
            {
              System.arraycopy(this.buf, i8 + 1, this.buf, i8 + 6, i10 - i8 - 1);
              this.buf[i8] = '\\';
              paramString = this.buf;
              k = i8 + 1;
              paramString[k] = 117;
              paramString = this.buf;
              k++;
              paramString[k] = 50;
              paramString = this.buf;
              k++;
              paramString[k] = 48;
              paramString = this.buf;
              k++;
              paramString[k] = 50;
              this.buf[(k + 1)] = '8';
            }
          }
          for (;;)
          {
            if (paramChar != 0)
            {
              this.buf[(this.count - 2)] = '"';
              this.buf[(this.count - 1)] = paramChar;
              break;
              System.arraycopy(this.buf, i8 + 1, this.buf, i8 + 2, i10 - i8 - 1);
              this.buf[i8] = '\\';
              this.buf[(i8 + 1)] = CharTypes.replaceChars[i9];
              continue;
              if (i6 > 1)
              {
                m = i4 - i5;
                k = i4;
                label1650:
                if (m < paramString.length())
                {
                  j = paramString.charAt(m);
                  if (((j >= CharTypes.specicalFlags_doubleQuotes.length) || (CharTypes.specicalFlags_doubleQuotes[j] == 0)) && ((j != 47) || (!isEnabled(SerializerFeature.WriteSlashAsSpecial)))) {
                    break label1750;
                  }
                  char[] arrayOfChar = this.buf;
                  n = k + 1;
                  arrayOfChar[k] = '\\';
                  arrayOfChar = this.buf;
                  k = n + 1;
                  arrayOfChar[n] = CharTypes.replaceChars[j];
                }
                for (;;)
                {
                  m++;
                  break label1650;
                  break;
                  label1750:
                  this.buf[k] = j;
                  k++;
                }
              }
            }
          }
          this.buf[(this.count - 1)] = '"';
          break;
        }
        i1 = n;
        n = k;
        i3 = i6;
        continue;
      }
      label1796:
      i4 = i2;
      i6 = n;
      i2 = i1;
      n = i4;
      i1 = i6;
      continue;
      label1819:
      n = k;
      i3 = i6;
    }
  }
  
  private void writeStringWithSingleQuote(String paramString)
  {
    int m = 0;
    int i = 0;
    if (paramString == null)
    {
      i = this.count + 4;
      if (i > this.buf.length) {
        expandCapacity(i);
      }
      "null".getChars(0, 4, this.buf, this.count);
      this.count = i;
    }
    int i3;
    for (;;)
    {
      return;
      j = paramString.length();
      i3 = this.count + j + 2;
      if (i3 <= this.buf.length) {
        break label183;
      }
      if (this.writer == null) {
        break;
      }
      write('\'');
      if (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((c <= '\r') || (c == '\\') || (c == '\'') || ((c == '/') && (isEnabled(SerializerFeature.WriteSlashAsSpecial))))
        {
          write('\\');
          write(CharTypes.replaceChars[c]);
        }
        for (;;)
        {
          i++;
          break;
          write(c);
        }
      }
      write('\'');
    }
    expandCapacity(i3);
    label183:
    int i1 = this.count + 1;
    int i2 = i1 + j;
    this.buf[this.count] = '\'';
    paramString.getChars(0, j, this.buf, i1);
    this.count = i3;
    int k = -1;
    i = i1;
    int j = 0;
    label237:
    int n;
    if (i < i2)
    {
      n = this.buf[i];
      if ((n > 13) && (n != 92) && (n != 39) && ((n != 47) || (!isEnabled(SerializerFeature.WriteSlashAsSpecial)))) {
        break label607;
      }
      k = j + 1;
      m = n;
    }
    for (j = i;; j = n)
    {
      i++;
      n = k;
      k = j;
      j = n;
      break label237;
      i = i3 + j;
      if (i > this.buf.length) {
        expandCapacity(i);
      }
      this.count = i;
      if (j == 1)
      {
        System.arraycopy(this.buf, k + 1, this.buf, k + 2, i2 - k - 1);
        this.buf[k] = '\\';
        this.buf[(k + 1)] = CharTypes.replaceChars[m];
      }
      for (;;)
      {
        this.buf[(this.count - 1)] = '\'';
        break;
        if (j > 1)
        {
          System.arraycopy(this.buf, k + 1, this.buf, k + 2, i2 - k - 1);
          this.buf[k] = '\\';
          paramString = this.buf;
          i = k + 1;
          paramString[i] = CharTypes.replaceChars[m];
          j = i2 + 1;
          i -= 2;
          while (i >= i1)
          {
            m = this.buf[i];
            if ((m > 13) && (m != 92) && (m != 39))
            {
              k = j;
              if (m == 47)
              {
                k = j;
                if (!isEnabled(SerializerFeature.WriteSlashAsSpecial)) {}
              }
            }
            else
            {
              System.arraycopy(this.buf, i + 1, this.buf, i + 2, j - i - 1);
              this.buf[i] = '\\';
              this.buf[(i + 1)] = CharTypes.replaceChars[m];
              k = j + 1;
            }
            i--;
            j = k;
          }
        }
      }
      label607:
      n = k;
      k = j;
    }
  }
  
  public final SerializeWriter append(char paramChar)
  {
    write(paramChar);
    return this;
  }
  
  public final SerializeWriter append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (paramCharSequence = "null";; paramCharSequence = paramCharSequence.toString())
    {
      write(paramCharSequence, 0, paramCharSequence.length());
      return this;
    }
  }
  
  public final SerializeWriter append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "null";
    }
    paramCharSequence = ((CharSequence)localObject).subSequence(paramInt1, paramInt2).toString();
    write(paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public final void close()
  {
    if ((this.writer != null) && (this.count > 0)) {
      flush();
    }
    if (this.buf.length <= 8192) {
      bufLocal.set(new SoftReference(this.buf));
    }
    this.buf = null;
  }
  
  public final void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.features |= paramSerializerFeature.getMask();; this.features &= (paramSerializerFeature.getMask() ^ 0xFFFFFFFF)) {
      return;
    }
  }
  
  public final void expandCapacity(int paramInt)
  {
    int i = this.buf.length * 3 / 2 + 1;
    if (i < paramInt) {}
    for (;;)
    {
      char[] arrayOfChar = new char[paramInt];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
      this.buf = arrayOfChar;
      return;
      paramInt = i;
    }
  }
  
  public final void flush()
  {
    if (this.writer == null) {}
    for (;;)
    {
      return;
      try
      {
        this.writer.write(this.buf, 0, this.count);
        this.writer.flush();
        this.count = 0;
      }
      catch (IOException localIOException)
      {
        throw new JSONException(localIOException.getMessage(), localIOException);
      }
    }
  }
  
  public final int getBufferLength()
  {
    return this.buf.length;
  }
  
  public final boolean isEnabled(SerializerFeature paramSerializerFeature)
  {
    return SerializerFeature.isEnabled(this.features, paramSerializerFeature);
  }
  
  public final void reset()
  {
    this.count = 0;
  }
  
  public final int size()
  {
    return this.count;
  }
  
  public final byte[] toBytes(String paramString)
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    String str = paramString;
    if (paramString == null) {
      str = "UTF-8";
    }
    return new SerialWriterStringEncoder(Charset.forName(str)).encode(this.buf, 0, this.count);
  }
  
  public final char[] toCharArray()
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    char[] arrayOfChar = new char[this.count];
    System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
    return arrayOfChar;
  }
  
  public final String toString()
  {
    return new String(this.buf, 0, this.count);
  }
  
  public final void write(char paramChar)
  {
    int j = this.count + 1;
    int i = j;
    if (j > this.buf.length)
    {
      if (this.writer != null) {
        break label48;
      }
      expandCapacity(j);
    }
    for (i = j;; i = 1)
    {
      this.buf[this.count] = paramChar;
      this.count = i;
      return;
      label48:
      flush();
    }
  }
  
  public final void write(int paramInt)
  {
    int j = this.count + 1;
    int i = j;
    if (j > this.buf.length)
    {
      if (this.writer != null) {
        break label49;
      }
      expandCapacity(j);
    }
    for (i = j;; i = 1)
    {
      this.buf[this.count] = ((char)paramInt);
      this.count = i;
      return;
      label49:
      flush();
    }
  }
  
  public final void write(String paramString)
  {
    if (paramString == null) {
      writeNull();
    }
    for (;;)
    {
      return;
      write(paramString, 0, paramString.length());
    }
  }
  
  public final void write(String paramString, int paramInt1, int paramInt2)
  {
    int k = this.count + paramInt2;
    int i;
    int j;
    if (k > this.buf.length)
    {
      i = paramInt1;
      j = paramInt2;
      if (this.writer == null)
      {
        expandCapacity(k);
        i = k;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramString.getChars(j, paramInt2 + j, this.buf, this.count);
      this.count = i;
      return;
      do
      {
        paramInt2 = this.buf.length - this.count;
        paramString.getChars(i, i + paramInt2, this.buf, this.count);
        this.count = this.buf.length;
        flush();
        paramInt1 = j - paramInt2;
        k = i + paramInt2;
        i = k;
        j = paramInt1;
      } while (paramInt1 > this.buf.length);
      paramInt2 = paramInt1;
      j = k;
      i = paramInt1;
      continue;
      i = k;
      j = paramInt1;
    }
  }
  
  public final void write(boolean paramBoolean)
  {
    if (paramBoolean) {
      write("true");
    }
    for (;;)
    {
      return;
      write("false");
    }
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length) || (paramInt1 + paramInt2 < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return;
    }
    int k = this.count + paramInt2;
    int j;
    int i;
    if (k > this.buf.length)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.writer == null)
      {
        expandCapacity(k);
        i = k;
        j = paramInt1;
      }
    }
    for (;;)
    {
      System.arraycopy(paramArrayOfChar, j, this.buf, this.count, paramInt2);
      this.count = i;
      break;
      do
      {
        paramInt2 = this.buf.length - this.count;
        System.arraycopy(paramArrayOfChar, j, this.buf, this.count, paramInt2);
        this.count = this.buf.length;
        flush();
        paramInt1 = i - paramInt2;
        k = j + paramInt2;
        j = k;
        i = paramInt1;
      } while (paramInt1 > this.buf.length);
      paramInt2 = paramInt1;
      j = k;
      i = paramInt1;
      continue;
      i = k;
      j = paramInt1;
    }
  }
  
  public final void writeBooleanAndChar(boolean paramBoolean, char paramChar)
  {
    if (paramBoolean) {
      if (paramChar == ',') {
        write("true,");
      }
    }
    for (;;)
    {
      return;
      if (paramChar == ']')
      {
        write("true]");
      }
      else
      {
        write("true");
        write(paramChar);
        continue;
        if (paramChar == ',')
        {
          write("false,");
        }
        else if (paramChar == ']')
        {
          write("false]");
        }
        else
        {
          write("false");
          write(paramChar);
        }
      }
    }
  }
  
  public final void writeByteArray(byte[] paramArrayOfByte)
  {
    int k = 0;
    int j = 0;
    int m = paramArrayOfByte.length;
    if (m == 0)
    {
      write("\"\"");
      return;
    }
    char[] arrayOfChar1 = Base64.CA;
    int n = m / 3 * 3;
    int i1 = (m - 1) / 3;
    int i = this.count;
    i1 = (i1 + 1 << 2) + this.count + 2;
    int i2;
    if (i1 > this.buf.length)
    {
      if (this.writer != null)
      {
        write('"');
        i = 0;
        while (i < n)
        {
          i2 = i + 1;
          k = paramArrayOfByte[i];
          i1 = i2 + 1;
          i2 = paramArrayOfByte[i2];
          i = i1 + 1;
          k = (i2 & 0xFF) << 8 | (k & 0xFF) << 16 | paramArrayOfByte[i1] & 0xFF;
          write(arrayOfChar1[(k >>> 18 & 0x3F)]);
          write(arrayOfChar1[(k >>> 12 & 0x3F)]);
          write(arrayOfChar1[(k >>> 6 & 0x3F)]);
          write(arrayOfChar1[(k & 0x3F)]);
        }
        k = m - n;
        if (k > 0)
        {
          n = paramArrayOfByte[n];
          i = j;
          if (k == 2) {
            i = (paramArrayOfByte[(m - 1)] & 0xFF) << 2;
          }
          i |= (n & 0xFF) << 10;
          write(arrayOfChar1[(i >> 12)]);
          write(arrayOfChar1[(i >>> 6 & 0x3F)]);
          if (k != 2) {
            break label323;
          }
        }
        label323:
        for (c = arrayOfChar1[(i & 0x3F)];; c = '=')
        {
          write(c);
          write('=');
          write('"');
          break;
        }
      }
      expandCapacity(i1);
    }
    this.count = i1;
    this.buf[i] = '"';
    i++;
    j = 0;
    while (j < n)
    {
      int i4 = j + 1;
      int i3 = paramArrayOfByte[j];
      i2 = i4 + 1;
      i4 = paramArrayOfByte[i4];
      j = i2 + 1;
      i2 = (i4 & 0xFF) << 8 | (i3 & 0xFF) << 16 | paramArrayOfByte[i2] & 0xFF;
      char[] arrayOfChar2 = this.buf;
      i3 = i + 1;
      arrayOfChar2[i] = arrayOfChar1[(i2 >>> 18 & 0x3F)];
      arrayOfChar2 = this.buf;
      i = i3 + 1;
      arrayOfChar2[i3] = arrayOfChar1[(i2 >>> 12 & 0x3F)];
      arrayOfChar2 = this.buf;
      i3 = i + 1;
      arrayOfChar2[i] = arrayOfChar1[(i2 >>> 6 & 0x3F)];
      arrayOfChar2 = this.buf;
      i = i3 + 1;
      arrayOfChar2[i3] = arrayOfChar1[(i2 & 0x3F)];
    }
    j = m - n;
    if (j > 0)
    {
      n = paramArrayOfByte[n];
      i = k;
      if (j == 2) {
        i = (paramArrayOfByte[(m - 1)] & 0xFF) << 2;
      }
      i |= (n & 0xFF) << 10;
      this.buf[(i1 - 5)] = arrayOfChar1[(i >> 12)];
      this.buf[(i1 - 4)] = arrayOfChar1[(i >>> 6 & 0x3F)];
      paramArrayOfByte = this.buf;
      if (j != 2) {
        break label666;
      }
    }
    label666:
    for (char c = arrayOfChar1[(i & 0x3F)];; c = '=')
    {
      paramArrayOfByte[(i1 - 3)] = c;
      this.buf[(i1 - 2)] = '=';
      this.buf[(i1 - 1)] = '"';
      break;
    }
  }
  
  public final void writeCharacterAndChar(char paramChar1, char paramChar2)
  {
    writeString(Character.toString(paramChar1));
    write(paramChar2);
  }
  
  public final void writeDoubleAndChar(double paramDouble, char paramChar)
  {
    String str2 = Double.toString(paramDouble);
    String str1 = str2;
    if (str2.endsWith(".0")) {
      str1 = str2.substring(0, str2.length() - 2);
    }
    write(str1);
    write(paramChar);
  }
  
  public final void writeEnum(Enum<?> paramEnum, char paramChar)
  {
    if (paramEnum == null)
    {
      writeNull();
      write(',');
    }
    for (;;)
    {
      return;
      if (isEnabled(SerializerFeature.WriteEnumUsingToString))
      {
        if (isEnabled(SerializerFeature.UseSingleQuotes))
        {
          write('\'');
          write(paramEnum.name());
          write('\'');
          write(paramChar);
        }
        else
        {
          write('"');
          write(paramEnum.name());
          write('"');
          write(paramChar);
        }
      }
      else {
        writeIntAndChar(paramEnum.ordinal(), paramChar);
      }
    }
  }
  
  public final void writeFieldEmptyList(char paramChar, String paramString)
  {
    write(paramChar);
    writeFieldName(paramString);
    write("[]");
  }
  
  public final void writeFieldName(String paramString)
  {
    writeFieldName(paramString, false);
  }
  
  public final void writeFieldName(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      write("null:");
    }
    for (;;)
    {
      return;
      if (isEnabled(SerializerFeature.UseSingleQuotes))
      {
        if (isEnabled(SerializerFeature.QuoteFieldNames))
        {
          writeStringWithSingleQuote(paramString);
          write(':');
        }
        else
        {
          writeKeyWithSingleQuoteIfHasSpecial(paramString);
        }
      }
      else if (isEnabled(SerializerFeature.QuoteFieldNames)) {
        writeStringWithDoubleQuote(paramString, ':', paramBoolean);
      } else {
        writeKeyWithDoubleQuoteIfHasSpecial(paramString);
      }
    }
  }
  
  public final void writeFieldNull(char paramChar, String paramString)
  {
    write(paramChar);
    writeFieldName(paramString);
    writeNull();
  }
  
  public final void writeFieldNullBoolean(char paramChar, String paramString)
  {
    write(paramChar);
    writeFieldName(paramString);
    if (isEnabled(SerializerFeature.WriteNullBooleanAsFalse)) {
      write("false");
    }
    for (;;)
    {
      return;
      writeNull();
    }
  }
  
  public final void writeFieldNullList(char paramChar, String paramString)
  {
    write(paramChar);
    writeFieldName(paramString);
    if (isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
      write("[]");
    }
    for (;;)
    {
      return;
      writeNull();
    }
  }
  
  public final void writeFieldNullNumber(char paramChar, String paramString)
  {
    write(paramChar);
    writeFieldName(paramString);
    if (isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
      write('0');
    }
    for (;;)
    {
      return;
      writeNull();
    }
  }
  
  public final void writeFieldNullString(char paramChar, String paramString)
  {
    write(paramChar);
    writeFieldName(paramString);
    if (isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
      writeString("");
    }
    for (;;)
    {
      return;
      writeNull();
    }
  }
  
  public final void writeFieldValue(char paramChar1, String paramString, char paramChar2)
  {
    write(paramChar1);
    writeFieldName(paramString);
    if (paramChar2 == 0) {
      writeString("\000");
    }
    for (;;)
    {
      return;
      writeString(Character.toString(paramChar2));
    }
  }
  
  public final void writeFieldValue(char paramChar, String paramString, double paramDouble)
  {
    write(paramChar);
    writeFieldName(paramString);
    if (paramDouble == 0.0D) {
      write('0');
    }
    for (;;)
    {
      return;
      if (Double.isNaN(paramDouble))
      {
        writeNull();
      }
      else if (Double.isInfinite(paramDouble))
      {
        writeNull();
      }
      else
      {
        String str = Double.toString(paramDouble);
        paramString = str;
        if (str.endsWith(".0")) {
          paramString = str.substring(0, str.length() - 2);
        }
        write(paramString);
      }
    }
  }
  
  public final void writeFieldValue(char paramChar, String paramString, float paramFloat)
  {
    write(paramChar);
    writeFieldName(paramString);
    if (paramFloat == 0.0F) {
      write('0');
    }
    for (;;)
    {
      return;
      if (Float.isNaN(paramFloat))
      {
        writeNull();
      }
      else if (Float.isInfinite(paramFloat))
      {
        writeNull();
      }
      else
      {
        String str = Float.toString(paramFloat);
        paramString = str;
        if (str.endsWith(".0")) {
          paramString = str.substring(0, str.length() - 2);
        }
        write(paramString);
      }
    }
  }
  
  public final void writeFieldValue(char paramChar, String paramString, int paramInt)
  {
    if ((paramInt == Integer.MIN_VALUE) || (!isEnabled(SerializerFeature.QuoteFieldNames))) {
      writeFieldValue1(paramChar, paramString, paramInt);
    }
    for (;;)
    {
      return;
      int i;
      if (isEnabled(SerializerFeature.UseSingleQuotes))
      {
        i = 39;
        label39:
        if (paramInt >= 0) {
          break label106;
        }
      }
      int k;
      label106:
      for (int j = IOUtils.stringSize(-paramInt) + 1;; j = IOUtils.stringSize(paramInt))
      {
        k = paramString.length();
        m = j + (this.count + k + 4);
        if (m <= this.buf.length) {
          break label121;
        }
        if (this.writer == null) {
          break label115;
        }
        writeFieldValue1(paramChar, paramString, paramInt);
        break;
        i = 34;
        break label39;
      }
      label115:
      expandCapacity(m);
      label121:
      j = this.count;
      this.count = m;
      this.buf[j] = paramChar;
      int m = j + k + 1;
      this.buf[(j + 1)] = i;
      paramString.getChars(0, k, this.buf, j + 2);
      this.buf[(m + 1)] = i;
      this.buf[(m + 2)] = ':';
      IOUtils.getChars(paramInt, this.count, this.buf);
    }
  }
  
  public final void writeFieldValue(char paramChar, String paramString, long paramLong)
  {
    if ((paramLong == Long.MIN_VALUE) || (!isEnabled(SerializerFeature.QuoteFieldNames))) {
      writeFieldValue1(paramChar, paramString, paramLong);
    }
    for (;;)
    {
      return;
      int i;
      if (isEnabled(SerializerFeature.UseSingleQuotes))
      {
        i = 39;
        label40:
        if (paramLong >= 0L) {
          break label117;
        }
      }
      int k;
      label117:
      for (int j = IOUtils.stringSize(-paramLong) + 1;; j = IOUtils.stringSize(paramLong))
      {
        k = paramString.length();
        m = j + (this.count + k + 4);
        if (m <= this.buf.length) {
          break label132;
        }
        if (this.writer == null) {
          break label126;
        }
        write(paramChar);
        writeFieldName(paramString);
        writeLong(paramLong);
        break;
        i = 34;
        break label40;
      }
      label126:
      expandCapacity(m);
      label132:
      j = this.count;
      this.count = m;
      this.buf[j] = paramChar;
      int m = j + k + 1;
      this.buf[(j + 1)] = i;
      paramString.getChars(0, k, this.buf, j + 2);
      this.buf[(m + 1)] = i;
      this.buf[(m + 2)] = ':';
      IOUtils.getChars(paramLong, this.count, this.buf);
    }
  }
  
  public final void writeFieldValue(char paramChar, String paramString, Enum<?> paramEnum)
  {
    if (paramEnum == null)
    {
      write(paramChar);
      writeFieldName(paramString);
      writeNull();
    }
    for (;;)
    {
      return;
      if (isEnabled(SerializerFeature.WriteEnumUsingToString))
      {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
          writeFieldValue(paramChar, paramString, paramEnum.name());
        } else {
          writeFieldValueStringWithDoubleQuote(paramChar, paramString, paramEnum.name(), false);
        }
      }
      else {
        writeFieldValue(paramChar, paramString, paramEnum.ordinal());
      }
    }
  }
  
  public final void writeFieldValue(char paramChar, String paramString1, String paramString2)
  {
    if (isEnabled(SerializerFeature.QuoteFieldNames)) {
      if (isEnabled(SerializerFeature.UseSingleQuotes))
      {
        write(paramChar);
        writeFieldName(paramString1);
        if (paramString2 == null) {
          writeNull();
        }
      }
    }
    for (;;)
    {
      return;
      writeString(paramString2);
      continue;
      if (isEnabled(SerializerFeature.BrowserCompatible))
      {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, '\000');
      }
      else
      {
        writeFieldValueStringWithDoubleQuote(paramChar, paramString1, paramString2, true);
        continue;
        write(paramChar);
        writeFieldName(paramString1);
        if (paramString2 == null) {
          writeNull();
        } else {
          writeString(paramString2);
        }
      }
    }
  }
  
  public final void writeFieldValue(char paramChar, String paramString, BigDecimal paramBigDecimal)
  {
    write(paramChar);
    writeFieldName(paramString);
    if (paramBigDecimal == null) {
      writeNull();
    }
    for (;;)
    {
      return;
      write(paramBigDecimal.toString());
    }
  }
  
  public final void writeFieldValue(char paramChar, String paramString, boolean paramBoolean)
  {
    int i;
    int j;
    label21:
    int k;
    int m;
    if (isEnabled(SerializerFeature.UseSingleQuotes))
    {
      i = 39;
      if (!paramBoolean) {
        break label87;
      }
      j = 4;
      k = paramString.length();
      m = j + (this.count + k + 4);
      if (m <= this.buf.length) {
        break label99;
      }
      if (this.writer == null) {
        break label93;
      }
      write(paramChar);
      writeString(paramString);
      write(':');
      write(paramBoolean);
    }
    for (;;)
    {
      return;
      i = 34;
      break;
      label87:
      j = 5;
      break label21;
      label93:
      expandCapacity(m);
      label99:
      j = this.count;
      this.count = m;
      this.buf[j] = paramChar;
      m = j + k + 1;
      this.buf[(j + 1)] = i;
      paramString.getChars(0, k, this.buf, j + 2);
      this.buf[(m + 1)] = i;
      if (paramBoolean) {
        System.arraycopy(":true".toCharArray(), 0, this.buf, m + 2, 5);
      } else {
        System.arraycopy(":false".toCharArray(), 0, this.buf, m + 2, 6);
      }
    }
  }
  
  public final void writeFieldValue1(char paramChar, String paramString, int paramInt)
  {
    write(paramChar);
    writeFieldName(paramString);
    writeInt(paramInt);
  }
  
  public final void writeFieldValue1(char paramChar, String paramString, long paramLong)
  {
    write(paramChar);
    writeFieldName(paramString);
    writeLong(paramLong);
  }
  
  public final void writeFloatAndChar(float paramFloat, char paramChar)
  {
    String str2 = Float.toString(paramFloat);
    String str1 = str2;
    if (str2.endsWith(".0")) {
      str1 = str2.substring(0, str2.length() - 2);
    }
    write(str1);
    write(paramChar);
  }
  
  public final void writeInt(int paramInt)
  {
    if (paramInt == Integer.MIN_VALUE) {
      write("-2147483648");
    }
    for (;;)
    {
      return;
      if (paramInt < 0) {}
      for (int i = IOUtils.stringSize(-paramInt) + 1;; i = IOUtils.stringSize(paramInt))
      {
        int j = this.count + i;
        if (j > this.buf.length)
        {
          if (this.writer != null) {
            break label80;
          }
          expandCapacity(j);
        }
        IOUtils.getChars(paramInt, j, this.buf);
        this.count = j;
        break;
      }
      label80:
      char[] arrayOfChar = new char[i];
      IOUtils.getChars(paramInt, i, arrayOfChar);
      write(arrayOfChar, 0, arrayOfChar.length);
    }
  }
  
  public final void writeIntAndChar(int paramInt, char paramChar)
  {
    if (paramInt == Integer.MIN_VALUE)
    {
      write("-2147483648");
      write(paramChar);
    }
    for (;;)
    {
      return;
      if (paramInt < 0) {}
      int j;
      for (int i = IOUtils.stringSize(-paramInt) + 1;; i = IOUtils.stringSize(paramInt))
      {
        i += this.count;
        j = i + 1;
        if (j <= this.buf.length) {
          break label88;
        }
        if (this.writer == null) {
          break label82;
        }
        writeInt(paramInt);
        write(paramChar);
        break;
      }
      label82:
      expandCapacity(j);
      label88:
      IOUtils.getChars(paramInt, i, this.buf);
      this.buf[i] = paramChar;
      this.count = j;
    }
  }
  
  public final void writeLong(long paramLong)
  {
    if (paramLong == Long.MIN_VALUE) {
      write("-9223372036854775808");
    }
    for (;;)
    {
      return;
      if (paramLong < 0L) {}
      for (int i = IOUtils.stringSize(-paramLong) + 1;; i = IOUtils.stringSize(paramLong))
      {
        int j = this.count + i;
        if (j > this.buf.length)
        {
          if (this.writer != null) {
            break label88;
          }
          expandCapacity(j);
        }
        IOUtils.getChars(paramLong, j, this.buf);
        this.count = j;
        break;
      }
      label88:
      char[] arrayOfChar = new char[i];
      IOUtils.getChars(paramLong, i, arrayOfChar);
      write(arrayOfChar, 0, arrayOfChar.length);
    }
  }
  
  public final void writeLongAndChar(long paramLong, char paramChar)
  {
    if (paramLong == Long.MIN_VALUE)
    {
      write("-9223372036854775808");
      write(paramChar);
    }
    for (;;)
    {
      return;
      if (paramLong < 0L) {}
      int j;
      for (int i = IOUtils.stringSize(-paramLong) + 1;; i = IOUtils.stringSize(paramLong))
      {
        j = i + this.count;
        i = j + 1;
        if (i <= this.buf.length) {
          break label96;
        }
        if (this.writer == null) {
          break label90;
        }
        writeLong(paramLong);
        write(paramChar);
        break;
      }
      label90:
      expandCapacity(i);
      label96:
      IOUtils.getChars(paramLong, j, this.buf);
      this.buf[j] = paramChar;
      this.count = i;
    }
  }
  
  public final void writeNull()
  {
    write("null");
  }
  
  public final void writeString(String paramString)
  {
    if (isEnabled(SerializerFeature.UseSingleQuotes)) {
      writeStringWithSingleQuote(paramString);
    }
    for (;;)
    {
      return;
      writeStringWithDoubleQuote(paramString, '\000');
    }
  }
  
  public final void writeString(String paramString, char paramChar)
  {
    if (isEnabled(SerializerFeature.UseSingleQuotes))
    {
      writeStringWithSingleQuote(paramString);
      write(paramChar);
    }
    for (;;)
    {
      return;
      writeStringWithDoubleQuote(paramString, paramChar);
    }
  }
  
  public final void writeTo(OutputStream paramOutputStream, String paramString)
  {
    writeTo(paramOutputStream, Charset.forName(paramString));
  }
  
  public final void writeTo(OutputStream paramOutputStream, Charset paramCharset)
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    paramOutputStream.write(new String(this.buf, 0, this.count).getBytes(paramCharset));
  }
  
  public final void writeTo(Writer paramWriter)
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    paramWriter.write(this.buf, 0, this.count);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/SerializeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */