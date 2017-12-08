package c.a.a;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class bx
{
  private static bx d;
  private String[] a = null;
  private bg[] b = null;
  private int c = -1;
  
  static
  {
    bx localbx = new bx();
    try
    {
      d = localbx;
      return;
    }
    finally {}
  }
  
  public bx()
  {
    if (f()) {}
    for (;;)
    {
      return;
      if ((!g()) && ((this.a == null) || (this.b == null)))
      {
        Object localObject1 = System.getProperty("os.name");
        Object localObject2 = System.getProperty("java.vendor");
        if (((String)localObject1).indexOf("Windows") != -1)
        {
          if ((((String)localObject1).indexOf("95") != -1) || (((String)localObject1).indexOf("98") != -1) || (((String)localObject1).indexOf("ME") != -1)) {
            try
            {
              localObject1 = Runtime.getRuntime();
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>("winipcfg /all /batch ");
              ((Runtime)localObject1).exec("winipcfg.out").waitFor();
              localObject2 = new java/io/File;
              ((File)localObject2).<init>("winipcfg.out");
              localObject1 = new java/io/FileInputStream;
              ((FileInputStream)localObject1).<init>((File)localObject2);
              a((InputStream)localObject1);
              localObject1 = new java/io/File;
              ((File)localObject1).<init>("winipcfg.out");
              ((File)localObject1).delete();
            }
            catch (Exception localException1) {}
          } else {
            try
            {
              Process localProcess = Runtime.getRuntime().exec("ipconfig /all");
              a(localProcess.getInputStream());
              localProcess.destroy();
            }
            catch (Exception localException2) {}
          }
        }
        else if (localException2.indexOf("NetWare") != -1) {
          b("sys:/etc/resolv.cfg");
        } else if (((String)localObject2).indexOf("Android") != -1) {
          h();
        } else {
          b("/etc/resolv.conf");
        }
      }
    }
  }
  
  private static int a(String paramString)
  {
    String str = paramString.substring(6);
    try
    {
      int j = Integer.parseInt(str);
      if (j < 0) {
        break label59;
      }
      i = j;
      if (bk.a("verbose"))
      {
        PrintStream localPrintStream = System.out;
        paramString = new java/lang/StringBuilder;
        paramString.<init>("setting ndots ");
        localPrintStream.println(str);
        i = j;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    return i;
  }
  
  private void a(InputStream paramInputStream)
  {
    int i = Integer.getInteger("org.xbill.DNS.windows.parse.buffer", 8192).intValue();
    paramInputStream = new BufferedInputStream(paramInputStream, i);
    paramInputStream.mark(i);
    a(paramInputStream, null);
    if (this.a == null) {}
    try
    {
      paramInputStream.reset();
      a(paramInputStream, new Locale("", ""));
      return;
    }
    catch (IOException paramInputStream)
    {
      for (;;) {}
    }
  }
  
  private void a(InputStream paramInputStream, Locale paramLocale)
  {
    String str1 = bx.class.getPackage().getName();
    str1 = str1 + ".windows.DNSServer";
    String str3;
    String str2;
    String str4;
    BufferedReader localBufferedReader;
    if (paramLocale != null)
    {
      paramLocale = ResourceBundle.getBundle(str1, paramLocale);
      str3 = paramLocale.getString("host_name");
      str2 = paramLocale.getString("primary_dns_suffix");
      str1 = paramLocale.getString("dns_suffix");
      str4 = paramLocale.getString("dns_servers");
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    }
    for (;;)
    {
      try
      {
        localArrayList2 = new java/util/ArrayList;
        localArrayList2.<init>();
        localArrayList1 = new java/util/ArrayList;
        localArrayList1.<init>();
        j = 0;
        i = 0;
      }
      catch (IOException paramInputStream)
      {
        ArrayList localArrayList2;
        ArrayList localArrayList1;
        String str5;
        StringTokenizer localStringTokenizer;
        boolean bool;
        continue;
        int k = i;
        int i = j;
        int j = k;
        continue;
        k = j;
        j = i;
        i = k;
        continue;
      }
      str5 = localBufferedReader.readLine();
      if (str5 == null) {
        continue;
      }
      localStringTokenizer = new java/util/StringTokenizer;
      localStringTokenizer.<init>(str5);
      bool = localStringTokenizer.hasMoreTokens();
      if (!bool)
      {
        j = 0;
        i = 0;
        continue;
        paramLocale = ResourceBundle.getBundle(str1);
        break;
      }
      paramInputStream = localStringTokenizer.nextToken();
      if (str5.indexOf(":") == -1) {
        continue;
      }
      i = 0;
      j = 0;
      if (str5.indexOf(str3) != -1)
      {
        if (localStringTokenizer.hasMoreTokens()) {
          paramInputStream = localStringTokenizer.nextToken();
        } else {
          try
          {
            paramLocale = bg.a(paramInputStream, null);
            if (paramLocale.c() == 1) {
              continue;
            }
            b(paramInputStream, localArrayList1);
            k = i;
            i = j;
            j = k;
          }
          catch (cs paramInputStream)
          {
            k = i;
            i = j;
            j = k;
          }
        }
      }
      else if (str5.indexOf(str2) != -1)
      {
        if (localStringTokenizer.hasMoreTokens())
        {
          paramInputStream = localStringTokenizer.nextToken();
        }
        else
        {
          if (paramInputStream.equals(":")) {
            continue;
          }
          b(paramInputStream, localArrayList1);
          j = i;
          i = 1;
        }
      }
      else
      {
        paramLocale = paramInputStream;
        if (j == 0)
        {
          if (str5.indexOf(str1) != -1) {
            paramLocale = paramInputStream;
          }
        }
        else
        {
          if (localStringTokenizer.hasMoreTokens())
          {
            paramLocale = localStringTokenizer.nextToken();
            continue;
          }
          if (paramLocale.equals(":")) {
            continue;
          }
          b(paramLocale, localArrayList1);
          j = i;
          i = 1;
          continue;
        }
        paramLocale = paramInputStream;
        if (i == 0)
        {
          k = i;
          if (str5.indexOf(str4) != -1) {
            paramLocale = paramInputStream;
          }
        }
        else
        {
          if (localStringTokenizer.hasMoreTokens())
          {
            paramLocale = localStringTokenizer.nextToken();
            continue;
          }
          if (paramLocale.equals(":")) {
            continue;
          }
          a(paramLocale, localArrayList2);
          k = 1;
        }
        i = j;
        j = k;
      }
    }
    a(localArrayList2, localArrayList1);
  }
  
  private static void a(String paramString, List paramList)
  {
    if (paramList.contains(paramString)) {}
    for (;;)
    {
      return;
      if (bk.a("verbose")) {
        System.out.println("adding server " + paramString);
      }
      paramList.add(paramString);
    }
  }
  
  private void a(List paramList1, List paramList2)
  {
    if ((this.a == null) && (paramList1.size() > 0)) {
      this.a = ((String[])paramList1.toArray(new String[0]));
    }
    if ((this.b == null) && (paramList2.size() > 0)) {
      this.b = ((bg[])paramList2.toArray(new bg[0]));
    }
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = new java/io/FileInputStream;
        ((FileInputStream)localObject).<init>(paramString);
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader((InputStream)localObject));
        localObject = new ArrayList(0);
        paramString = new ArrayList(0);
        i = -1;
        j = i;
        try
        {
          str = localBufferedReader.readLine();
          if (str == null) {
            continue;
          }
          j = i;
          if (!str.startsWith("nameserver")) {
            continue;
          }
          j = i;
          localStringTokenizer = new java/util/StringTokenizer;
          j = i;
          localStringTokenizer.<init>(str);
          j = i;
          localStringTokenizer.nextToken();
          j = i;
          a(localStringTokenizer.nextToken(), (List)localObject);
        }
        catch (IOException localIOException)
        {
          i = j;
        }
        a((List)localObject, paramString);
        if ((this.c < 0) && (i > 0)) {
          this.c = i;
        }
        return;
      }
      catch (FileNotFoundException paramString)
      {
        int i;
        int j;
        String str;
        StringTokenizer localStringTokenizer;
        int k;
        continue;
      }
      j = i;
      if (str.startsWith("domain"))
      {
        j = i;
        localStringTokenizer = new java/util/StringTokenizer;
        j = i;
        localStringTokenizer.<init>(str);
        j = i;
        localStringTokenizer.nextToken();
        j = i;
        if (localStringTokenizer.hasMoreTokens())
        {
          j = i;
          if (paramString.isEmpty())
          {
            j = i;
            b(localStringTokenizer.nextToken(), paramString);
          }
        }
      }
      else
      {
        j = i;
        if (str.startsWith("search"))
        {
          j = i;
          if (!paramString.isEmpty())
          {
            j = i;
            paramString.clear();
          }
          j = i;
          localStringTokenizer = new java/util/StringTokenizer;
          j = i;
          localStringTokenizer.<init>(str);
          j = i;
          localStringTokenizer.nextToken();
          j = i;
          if (localStringTokenizer.hasMoreTokens())
          {
            j = i;
            b(localStringTokenizer.nextToken(), paramString);
          }
        }
        else
        {
          j = i;
          if (str.startsWith("options"))
          {
            j = i;
            localStringTokenizer = new java/util/StringTokenizer;
            j = i;
            localStringTokenizer.<init>(str);
            j = i;
            localStringTokenizer.nextToken();
            k = i;
            i = k;
            j = k;
            if (localStringTokenizer.hasMoreTokens())
            {
              j = k;
              str = localStringTokenizer.nextToken();
              j = k;
              if (str.startsWith("ndots:"))
              {
                j = k;
                k = a(str);
                continue;
                j = i;
                localIOException.close();
              }
            }
          }
        }
      }
    }
  }
  
  private static void b(String paramString, List paramList)
  {
    if (bk.a("verbose")) {
      System.out.println("adding search " + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = bg.a(paramString, bg.a);
        if (paramList.contains(paramString)) {
          return;
        }
      }
      catch (cs paramString)
      {
        continue;
      }
      paramList.add(paramString);
    }
  }
  
  public static bx e()
  {
    try
    {
      bx localbx = d;
      return localbx;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    ArrayList localArrayList1 = new ArrayList(0);
    ArrayList localArrayList2 = new ArrayList(0);
    Object localObject = System.getProperty("dns.server");
    if (localObject != null)
    {
      localObject = new StringTokenizer((String)localObject, ",");
      while (((StringTokenizer)localObject).hasMoreTokens()) {
        a(((StringTokenizer)localObject).nextToken(), localArrayList1);
      }
    }
    localObject = System.getProperty("dns.search");
    if (localObject != null)
    {
      localObject = new StringTokenizer((String)localObject, ",");
      while (((StringTokenizer)localObject).hasMoreTokens()) {
        b(((StringTokenizer)localObject).nextToken(), localArrayList2);
      }
    }
    a(localArrayList1, localArrayList2);
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.b != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean g()
  {
    localArrayList2 = new ArrayList(0);
    ArrayList localArrayList1 = new ArrayList(0);
    try
    {
      Class[] arrayOfClass = new Class[0];
      Object[] arrayOfObject = new Object[0];
      Class localClass = Class.forName("sun.net.dns.ResolverConfiguration");
      localObject2 = localClass.getDeclaredMethod("open", arrayOfClass).invoke(null, arrayOfObject);
      localObject1 = (List)localClass.getMethod("nameservers", arrayOfClass).invoke(localObject2, arrayOfObject);
      localObject2 = (List)localClass.getMethod("searchlist", arrayOfClass).invoke(localObject2, arrayOfObject);
      if (((List)localObject1).size() != 0) {
        break label120;
      }
      bool = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        boolean bool = false;
        continue;
        if (((List)localObject1).size() > 0)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            a((String)((Iterator)localObject1).next(), localArrayList2);
          }
        }
        if (((List)localObject2).size() > 0)
        {
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext()) {
            b((String)((Iterator)localObject1).next(), localException);
          }
        }
        a(localArrayList2, localException);
        bool = true;
      }
    }
    return bool;
  }
  
  private void h()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      for (int i = 0; i < 4; i++)
      {
        String str = (String)localMethod.invoke(null, new Object[] { new String[] { "net.dns1", "net.dns2", "net.dns3", "net.dns4" }[i] });
        if ((str != null) && ((str.matches("^\\d+(\\.\\d+){3}$")) || (str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$"))) && (!localArrayList1.contains(str))) {
          localArrayList1.add(str);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      a(localArrayList1, localArrayList2);
    }
  }
  
  public final String[] a()
  {
    return this.a;
  }
  
  public final String b()
  {
    if (this.a == null) {}
    for (String str = null;; str = this.a[0]) {
      return str;
    }
  }
  
  public final bg[] c()
  {
    return this.b;
  }
  
  public final int d()
  {
    if (this.c < 0) {}
    for (int i = 1;; i = this.c) {
      return i;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */