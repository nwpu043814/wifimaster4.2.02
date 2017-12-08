package com.a.a.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

final class a
  implements XmlSerializer
{
  private static final String[] a;
  private final char[] b = new char[' '];
  private int c;
  private Writer d;
  private OutputStream e;
  private CharsetEncoder f;
  private ByteBuffer g = ByteBuffer.allocate(8192);
  private boolean h;
  
  static
  {
    String[] arrayOfString = new String[64];
    arrayOfString[34] = "&quot;";
    arrayOfString[38] = "&amp;";
    arrayOfString[60] = "&lt;";
    arrayOfString[62] = "&gt;";
    a = arrayOfString;
  }
  
  private void a()
  {
    int i = this.g.position();
    if (i > 0)
    {
      this.g.flip();
      this.e.write(this.g.array(), 0, i);
      this.g.clear();
    }
  }
  
  private void a(char paramChar)
  {
    int j = this.c;
    int i = j;
    if (j >= 8191)
    {
      flush();
      i = this.c;
    }
    this.b[i] = paramChar;
    this.c = (i + 1);
  }
  
  private void a(String paramString)
  {
    a(paramString, 0, paramString.length());
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    int j;
    if (paramInt2 > 8192)
    {
      j = paramInt1 + paramInt2;
      if (paramInt1 < j) {}
    }
    for (;;)
    {
      return;
      int i = paramInt1 + 8192;
      if (i < j) {}
      for (paramInt2 = 8192;; paramInt2 = j - paramInt1)
      {
        a(paramString, paramInt1, paramInt2);
        paramInt1 = i;
        break;
      }
      j = this.c;
      i = j;
      if (j + paramInt2 > 8192)
      {
        flush();
        i = this.c;
      }
      paramString.getChars(paramInt1, paramInt1 + paramInt2, this.b, i);
      this.c = (i + paramInt2);
    }
  }
  
  private void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j;
    if (paramInt2 > 8192)
    {
      j = paramInt1 + paramInt2;
      if (paramInt1 < j) {}
    }
    for (;;)
    {
      return;
      int i = paramInt1 + 8192;
      if (i < j) {}
      for (paramInt2 = 8192;; paramInt2 = j - paramInt1)
      {
        a(paramArrayOfChar, paramInt1, paramInt2);
        paramInt1 = i;
        break;
      }
      j = this.c;
      i = j;
      if (j + paramInt2 > 8192)
      {
        flush();
        i = this.c;
      }
      System.arraycopy(paramArrayOfChar, paramInt1, this.b, i, paramInt2);
      this.c = (i + paramInt2);
    }
  }
  
  private void b(String paramString)
  {
    int j = 0;
    int n = paramString.length();
    int m = (char)a.length;
    String[] arrayOfString = a;
    int i = 0;
    for (;;)
    {
      if (i >= n)
      {
        if (j < i) {
          a(paramString, j, i - j);
        }
        return;
      }
      int i1 = paramString.charAt(i);
      int k = j;
      if (i1 < m)
      {
        String str = arrayOfString[i1];
        k = j;
        if (str != null)
        {
          if (j < i) {
            a(paramString, j, i - j);
          }
          k = i + 1;
          a(str);
        }
      }
      i++;
      j = k;
    }
  }
  
  public final XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    a(' ');
    if (paramString1 != null)
    {
      a(paramString1);
      a(':');
    }
    a(paramString2);
    a("=\"");
    b(paramString3);
    a('"');
    return this;
  }
  
  public final void cdsect(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void comment(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void docdecl(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void endDocument()
  {
    flush();
  }
  
  public final XmlSerializer endTag(String paramString1, String paramString2)
  {
    if (this.h) {
      a(" />\n");
    }
    for (;;)
    {
      this.h = false;
      return this;
      a("</");
      if (paramString1 != null)
      {
        a(paramString1);
        a(':');
      }
      a(paramString2);
      a(">\n");
    }
  }
  
  public final void entityRef(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void flush()
  {
    if (this.c > 0)
    {
      if (this.e == null) {
        break label105;
      }
      CharBuffer localCharBuffer = CharBuffer.wrap(this.b, 0, this.c);
      for (CoderResult localCoderResult = this.f.encode(localCharBuffer, this.g, true);; localCoderResult = this.f.encode(localCharBuffer, this.g, true))
      {
        if (localCoderResult.isError()) {
          throw new IOException(localCoderResult.toString());
        }
        if (!localCoderResult.isOverflow()) {
          break;
        }
        a();
      }
      a();
      this.e.flush();
    }
    for (;;)
    {
      this.c = 0;
      return;
      label105:
      this.d.write(this.b, 0, this.c);
      this.d.flush();
    }
  }
  
  public final int getDepth()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean getFeature(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final String getName()
  {
    throw new UnsupportedOperationException();
  }
  
  public final String getNamespace()
  {
    throw new UnsupportedOperationException();
  }
  
  public final String getPrefix(String paramString, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object getProperty(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void ignorableWhitespace(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void processingInstruction(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void setFeature(String paramString, boolean paramBoolean)
  {
    if (paramString.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void setOutput(OutputStream paramOutputStream, String paramString)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException();
    }
    try
    {
      this.f = Charset.forName(paramString).newEncoder();
      this.e = paramOutputStream;
      return;
    }
    catch (IllegalCharsetNameException paramOutputStream)
    {
      throw ((UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(paramOutputStream));
    }
    catch (UnsupportedCharsetException paramOutputStream)
    {
      throw ((UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(paramOutputStream));
    }
  }
  
  public final void setOutput(Writer paramWriter)
  {
    this.d = paramWriter;
  }
  
  public final void setPrefix(String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void setProperty(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void startDocument(String paramString, Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
    if (paramBoolean.booleanValue()) {}
    for (paramString = "yes";; paramString = "no")
    {
      a(paramString + "' ?>\n");
      return;
    }
  }
  
  public final XmlSerializer startTag(String paramString1, String paramString2)
  {
    if (this.h) {
      a(">\n");
    }
    a('<');
    if (paramString1 != null)
    {
      a(paramString1);
      a(':');
    }
    a(paramString2);
    this.h = true;
    return this;
  }
  
  public final XmlSerializer text(String paramString)
  {
    if (this.h)
    {
      a(">");
      this.h = false;
    }
    b(paramString);
    return this;
  }
  
  public final XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.h)
    {
      a(">");
      this.h = false;
    }
    int m = (char)a.length;
    String[] arrayOfString = a;
    int j = paramInt1;
    int k;
    for (int i = paramInt1;; i = k)
    {
      k = i;
      if (k >= paramInt1 + paramInt2)
      {
        if (j < k) {
          a(paramArrayOfChar, j, k - j);
        }
        return this;
      }
      int n = paramArrayOfChar[k];
      i = j;
      if (n < m)
      {
        String str = arrayOfString[n];
        i = j;
        if (str != null)
        {
          if (j < k) {
            a(paramArrayOfChar, j, k - j);
          }
          i = k + 1;
          a(str);
        }
      }
      k++;
      j = i;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */