package cm.pass.sdk.a.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

public class b
  implements XmlSerializer
{
  private static final String[] a = { "&#0;", "&#1;", "&#2;", "&#3;", "&#4;", "&#5;", "&#6;", "&#7;", "&#8;", "&#9;", "&#10;", "&#11;", "&#12;", "&#13;", "&#14;", "&#15;", "&#16;", "&#17;", "&#18;", "&#19;", "&#20;", "&#21;", "&#22;", "&#23;", "&#24;", "&#25;", "&#26;", "&#27;", "&#28;", "&#29;", "&#30;", "&#31;", null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null };
  private static String b = "                                                              ";
  private final char[] c = new char[' '];
  private int d;
  private Writer e;
  private OutputStream f;
  private CharsetEncoder g;
  private ByteBuffer h = ByteBuffer.allocate(8192);
  private boolean i = false;
  private boolean j;
  private int k = 0;
  private boolean l = true;
  
  private void a()
  {
    int m = this.h.position();
    if (m > 0)
    {
      this.h.flip();
      this.f.write(this.h.array(), 0, m);
      this.h.clear();
    }
  }
  
  private void a(char paramChar)
  {
    int n = this.d;
    int m = n;
    if (n >= 8191)
    {
      flush();
      m = this.d;
    }
    this.c[m] = paramChar;
    this.d = (m + 1);
  }
  
  private void a(int paramInt)
  {
    int m = paramInt * 4;
    paramInt = m;
    if (m > b.length()) {
      paramInt = b.length();
    }
    a(b, 0, paramInt);
  }
  
  private void a(String paramString)
  {
    a(paramString, 0, paramString.length());
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    int n;
    int m;
    if (paramInt2 > 8192)
    {
      n = paramInt1 + paramInt2;
      if (paramInt1 < n)
      {
        m = paramInt1 + 8192;
        if (m < n) {}
        for (paramInt2 = 8192;; paramInt2 = n - paramInt1)
        {
          a(paramString, paramInt1, paramInt2);
          paramInt1 = m;
          break;
        }
      }
    }
    else
    {
      n = this.d;
      m = n;
      if (n + paramInt2 > 8192)
      {
        flush();
        m = this.d;
      }
      paramString.getChars(paramInt1, paramInt1 + paramInt2, this.c, m);
      this.d = (m + paramInt2);
    }
  }
  
  private void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int n;
    int m;
    if (paramInt2 > 8192)
    {
      n = paramInt1 + paramInt2;
      if (paramInt1 < n)
      {
        m = paramInt1 + 8192;
        if (m < n) {}
        for (paramInt2 = 8192;; paramInt2 = n - paramInt1)
        {
          a(paramArrayOfChar, paramInt1, paramInt2);
          paramInt1 = m;
          break;
        }
      }
    }
    else
    {
      n = this.d;
      m = n;
      if (n + paramInt2 > 8192)
      {
        flush();
        m = this.d;
      }
      System.arraycopy(paramArrayOfChar, paramInt1, this.c, m, paramInt2);
      this.d = (m + paramInt2);
    }
  }
  
  private void b(String paramString)
  {
    int i1 = 0;
    int i2 = paramString.length();
    int i3 = (char)a.length;
    String[] arrayOfString = a;
    int m = 0;
    while (m < i2)
    {
      int i4 = paramString.charAt(m);
      int n = i1;
      if (i4 < i3)
      {
        String str = arrayOfString[i4];
        n = i1;
        if (str != null)
        {
          if (i1 < m) {
            a(paramString, i1, m - i1);
          }
          n = m + 1;
          a(str);
        }
      }
      m++;
      i1 = n;
    }
    if (i1 < m) {
      a(paramString, i1, m - i1);
    }
  }
  
  private void b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i2 = (char)a.length;
    String[] arrayOfString = a;
    int n = paramInt1;
    int i1;
    for (int m = paramInt1;; m = i1)
    {
      i1 = m;
      if (i1 >= paramInt1 + paramInt2) {
        break;
      }
      int i3 = paramArrayOfChar[i1];
      m = n;
      if (i3 < i2)
      {
        String str = arrayOfString[i3];
        m = n;
        if (str != null)
        {
          if (n < i1) {
            a(paramArrayOfChar, n, i1 - n);
          }
          m = i1 + 1;
          a(str);
        }
      }
      i1++;
      n = m;
    }
    if (n < i1) {
      a(paramArrayOfChar, n, i1 - n);
    }
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
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
    this.l = false;
    return this;
  }
  
  public void cdsect(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void comment(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void docdecl(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void endDocument()
  {
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
  {
    this.k -= 1;
    if (this.j) {
      a(" />\n");
    }
    for (;;)
    {
      this.l = true;
      this.j = false;
      return this;
      if ((this.i) && (this.l)) {
        a(this.k);
      }
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
  
  public void entityRef(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void flush()
  {
    if (this.d > 0)
    {
      if (this.f == null) {
        break label105;
      }
      CharBuffer localCharBuffer = CharBuffer.wrap(this.c, 0, this.d);
      for (CoderResult localCoderResult = this.g.encode(localCharBuffer, this.h, true);; localCoderResult = this.g.encode(localCharBuffer, this.h, true))
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
      this.f.flush();
    }
    for (;;)
    {
      this.d = 0;
      return;
      label105:
      this.e.write(this.c, 0, this.d);
      this.e.flush();
    }
  }
  
  public int getDepth()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean getFeature(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String getName()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getNamespace()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object getProperty(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void ignorableWhitespace(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void processingInstruction(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    if (paramString.equals("http://xmlpull.org/v1/doc/features.html#indent-output"))
    {
      this.i = true;
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException();
    }
    try
    {
      this.g = Charset.forName(paramString).newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      this.f = paramOutputStream;
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
  
  public void setOutput(Writer paramWriter)
  {
    this.e = paramWriter;
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
    if (paramBoolean.booleanValue()) {}
    for (paramString = "yes";; paramString = "no")
    {
      a(paramString + "' ?>\n");
      this.l = true;
      return;
    }
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
  {
    if (this.j) {
      a(">\n");
    }
    if (this.i) {
      a(this.k);
    }
    this.k += 1;
    a('<');
    if (paramString1 != null)
    {
      a(paramString1);
      a(':');
    }
    a(paramString2);
    this.j = true;
    this.l = false;
    return this;
  }
  
  public XmlSerializer text(String paramString)
  {
    boolean bool2 = false;
    if (this.j)
    {
      a(">");
      this.j = false;
    }
    b(paramString);
    if (this.i)
    {
      boolean bool1 = bool2;
      if (paramString.length() > 0)
      {
        bool1 = bool2;
        if (paramString.charAt(paramString.length() - 1) == '\n') {
          bool1 = true;
        }
      }
      this.l = bool1;
    }
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (this.j)
    {
      a(">");
      this.j = false;
    }
    b(paramArrayOfChar, paramInt1, paramInt2);
    if (this.i)
    {
      if (paramArrayOfChar[(paramInt1 + paramInt2 - 1)] == '\n') {
        bool = true;
      }
      this.l = bool;
    }
    return this;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */