package com.wifipay.common.logging;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class d
  implements e
{
  private String a;
  private final ThreadLocal b = new ThreadLocal();
  private final ThreadLocal c = new ThreadLocal();
  private final f d = new f();
  
  public d(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
    a("wifipay");
  }
  
  private int a(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    int i = 3;
    if (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if ((!str.equals(d.class.getName())) && (!str.equals(Logger.class.getName()))) {
        i--;
      }
    }
    for (;;)
    {
      return i;
      i++;
      break;
      i = -1;
    }
  }
  
  static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      paramThrowable = "";
    }
    for (;;)
    {
      return paramThrowable;
      for (Object localObject = paramThrowable;; localObject = ((Throwable)localObject).getCause())
      {
        if (localObject == null) {
          break label36;
        }
        if ((localObject instanceof UnknownHostException))
        {
          paramThrowable = "";
          break;
        }
      }
      label36:
      StringWriter localStringWriter = new StringWriter();
      localObject = new PrintWriter(localStringWriter);
      paramThrowable.printStackTrace((PrintWriter)localObject);
      ((PrintWriter)localObject).flush();
      paramThrowable = localStringWriter.toString();
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    b(paramInt, paramString, "╔════════════════════════════════════════════════════════════════════════════════════════");
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (this.d.b())
    {
      b(paramInt1, paramString, "║ Thread: " + Thread.currentThread().getName());
      c(paramInt1, paramString);
    }
    Object localObject2 = "";
    int j = a(arrayOfStackTraceElement) + this.d.d();
    Object localObject1 = localObject2;
    int i = paramInt2;
    if (paramInt2 + j > arrayOfStackTraceElement.length) {
      i = arrayOfStackTraceElement.length - j - 1;
    }
    for (localObject1 = localObject2; i > 0; localObject1 = localObject2)
    {
      paramInt2 = i + j;
      localObject2 = localObject1;
      if (paramInt2 < arrayOfStackTraceElement.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("║ ").append((String)localObject1).append(d(arrayOfStackTraceElement[paramInt2].getClassName())).append(".").append(arrayOfStackTraceElement[paramInt2].getMethodName()).append("  (").append(arrayOfStackTraceElement[paramInt2].getFileName()).append(":").append(arrayOfStackTraceElement[paramInt2].getLineNumber()).append(")");
        localObject2 = (String)localObject1 + "   ";
        b(paramInt1, paramString, localStringBuilder.toString());
      }
      i--;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    for (paramString2 : paramString2.split(System.getProperty("line.separator"))) {
      b(paramInt, paramString1, "║ " + paramString2);
    }
  }
  
  private void a(int paramInt, String paramString, Object... paramVarArgs)
  {
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        localObject = this.d.c();
        c localc = c.b;
        if (localObject == localc) {
          return;
        }
        localObject = d();
        paramVarArgs = g(paramString, paramVarArgs);
        i = e();
        paramString = paramVarArgs;
        if (TextUtils.isEmpty(paramVarArgs)) {
          paramString = "Empty/NULL log message";
        }
        a(paramInt, (String)localObject);
        a(paramInt, (String)localObject, i);
        paramVarArgs = paramString.getBytes();
        j = paramVarArgs.length;
        if (j <= 4000)
        {
          if (i > 0) {
            c(paramInt, (String)localObject);
          }
          a(paramInt, (String)localObject, paramString);
          b(paramInt, (String)localObject);
          continue;
        }
        if (i <= 0) {
          break label137;
        }
      }
      finally {}
      c(paramInt, (String)localObject);
      label137:
      for (int i = 0; i < j; i += 4000)
      {
        int k = Math.min(j - i, 4000);
        paramString = new java/lang/String;
        paramString.<init>(paramVarArgs, i, k);
        a(paramInt, (String)localObject, paramString);
      }
      b(paramInt, (String)localObject);
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    b(paramInt, paramString, "╚════════════════════════════════════════════════════════════════════════════════════════");
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = e(paramString1);
    switch (paramInt)
    {
    case 3: 
    default: 
      this.d.e().a(paramString1, paramString2);
    }
    for (;;)
    {
      return;
      this.d.e().b(paramString1, paramString2);
      continue;
      this.d.e().d(paramString1, paramString2);
      continue;
      this.d.e().e(paramString1, paramString2);
      continue;
      this.d.e().c(paramString1, paramString2);
      continue;
      this.d.e().f(paramString1, paramString2);
    }
  }
  
  private void c(int paramInt, String paramString)
  {
    b(paramInt, paramString, "╟────────────────────────────────────────────────────────────────────────────────────────");
  }
  
  private String d()
  {
    String str = (String)this.b.get();
    if (str != null) {
      this.b.remove();
    }
    for (;;)
    {
      return str;
      str = this.a;
    }
  }
  
  private String d(String paramString)
  {
    return paramString.substring(paramString.lastIndexOf(".") + 1);
  }
  
  private int e()
  {
    Integer localInteger = (Integer)this.c.get();
    int i = this.d.a();
    if (localInteger != null)
    {
      this.c.remove();
      i = localInteger.intValue();
    }
    for (;;)
    {
      if (i < 0) {
        throw new IllegalStateException("methodCount cannot be negative");
      }
      return i;
    }
  }
  
  private String e(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.a))) {}
    for (paramString = this.a + "-" + paramString;; paramString = this.a) {
      return paramString;
    }
  }
  
  private String g(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null) {
      if (paramVarArgs.length != 0) {
        break label15;
      }
    }
    label15:
    for (str = paramString;; str = String.format(paramString, paramVarArgs)) {
      return str;
    }
  }
  
  public final e a(String paramString, int paramInt)
  {
    if (paramString != null) {
      this.b.set(paramString);
    }
    this.c.set(Integer.valueOf(paramInt));
    return this;
  }
  
  public final f a()
  {
    return this.d;
  }
  
  public final f a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("tag may not be null");
    }
    if (paramString.trim().length() == 0) {
      throw new IllegalStateException("tag may not be empty");
    }
    this.a = paramString;
    return this.d;
  }
  
  public final void a(String paramString, Object... paramVarArgs)
  {
    a(3, paramString, paramVarArgs);
  }
  
  public final void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if ((paramThrowable != null) && (paramString != null)) {}
    for (String str = paramString + " : " + a(paramThrowable);; str = paramString)
    {
      paramString = str;
      if (paramThrowable != null)
      {
        paramString = str;
        if (str == null) {
          paramString = a(paramThrowable);
        }
      }
      paramThrowable = paramString;
      if (paramString == null) {
        paramThrowable = "No message/exception is set";
      }
      a(6, paramThrowable, paramVarArgs);
      return;
    }
  }
  
  public final void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      a("Empty/Null json content", new Object[0]);
    }
    for (;;)
    {
      return;
      Object localObject;
      try
      {
        paramString = paramString.trim();
        if (!paramString.startsWith("{")) {
          break label74;
        }
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        a(((JSONObject)localObject).toString(2), new Object[0]);
      }
      catch (JSONException paramString)
      {
        b("Invalid Json", new Object[0]);
      }
      continue;
      label74:
      if (paramString.startsWith("["))
      {
        localObject = new org/json/JSONArray;
        ((JSONArray)localObject).<init>(paramString);
        a(((JSONArray)localObject).toString(2), new Object[0]);
      }
      else
      {
        b("Invalid Json", new Object[0]);
      }
    }
  }
  
  public final void b(String paramString, Object... paramVarArgs)
  {
    a(null, paramString, paramVarArgs);
  }
  
  public final boolean b()
  {
    if (this.d.c() == c.b) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void c()
  {
    this.d.f();
  }
  
  public final void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      a("Empty/Null xml content", new Object[0]);
    }
    for (;;)
    {
      return;
      try
      {
        StreamSource localStreamSource = new javax/xml/transform/stream/StreamSource;
        Object localObject1 = new java/io/StringReader;
        ((StringReader)localObject1).<init>(paramString);
        localStreamSource.<init>((Reader)localObject1);
        localObject1 = new javax/xml/transform/stream/StreamResult;
        Object localObject2 = new java/io/StringWriter;
        ((StringWriter)localObject2).<init>();
        ((StreamResult)localObject1).<init>((Writer)localObject2);
        localObject2 = TransformerFactory.newInstance().newTransformer();
        ((Transformer)localObject2).setOutputProperty("indent", "yes");
        ((Transformer)localObject2).setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        ((Transformer)localObject2).transform(localStreamSource, (Result)localObject1);
        a(((StreamResult)localObject1).getWriter().toString().replaceFirst(">", ">\n"), new Object[0]);
      }
      catch (TransformerException localTransformerException)
      {
        b(localTransformerException.getCause().getMessage() + "\n" + paramString, new Object[0]);
      }
    }
  }
  
  public final void c(String paramString, Object... paramVarArgs)
  {
    a(5, paramString, paramVarArgs);
  }
  
  public final void d(String paramString, Object... paramVarArgs)
  {
    a(4, paramString, paramVarArgs);
  }
  
  public final void e(String paramString, Object... paramVarArgs)
  {
    a(2, paramString, paramVarArgs);
  }
  
  public final void f(String paramString, Object... paramVarArgs)
  {
    a(7, paramString, paramVarArgs);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/logging/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */