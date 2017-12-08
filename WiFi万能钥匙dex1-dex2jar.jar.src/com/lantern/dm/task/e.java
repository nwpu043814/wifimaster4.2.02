package com.lantern.dm.task;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.webkit.MimeTypeMap;
import com.bluefay.b.h;
import com.lantern.core.model.a;
import java.io.File;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

public final class e
{
  public static Random a = new Random(SystemClock.uptimeMillis());
  private static final Pattern b = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
  
  public static long a(File paramFile)
  {
    paramFile = new StatFs(paramFile.getPath());
    long l = paramFile.getAvailableBlocks();
    return paramFile.getBlockSize() * (l - 4L);
  }
  
  public static File a(String paramString)
  {
    Object localObject = Environment.getDownloadCacheDirectory();
    if (paramString.startsWith(((File)localObject).getPath())) {}
    File localFile;
    do
    {
      return (File)localObject;
      localFile = Environment.getExternalStorageDirectory();
      localObject = localFile;
    } while (paramString.startsWith(localFile.getPath()));
    throw new IllegalArgumentException("Cannot determine filesystem root for " + paramString);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt == 0))
    {
      if (paramString3 == null) {
        throw new a(406, "external download with no mime type not allowed");
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      paramContext = paramContext.getPackageManager();
      localIntent.setDataAndType(Uri.fromParts("file", "", null), paramString3);
      if (paramContext.resolveActivity(localIntent, 65536) == null) {
        throw new a(406, "no handler found for this download type");
      }
    }
    if (paramInt == 4)
    {
      if (!a()) {
        throw new a(499, "external media not mounted");
      }
      paramContext = Uri.parse(paramString2).getPath();
      if (paramContext.endsWith("/")) {}
      for (paramContext = a(paramContext.substring(0, paramContext.length() - 1), paramString1, paramString3);; paramContext = a(paramContext.substring(0, paramContext.lastIndexOf("/")), paramContext, paramString3))
      {
        paramString1 = paramContext;
        if (a(a(paramContext)) >= paramLong) {
          break;
        }
        throw new a(498, "insufficient space on external storage");
      }
    }
    if (!a()) {
      throw new a(499, "external media not mounted");
    }
    paramContext = Environment.getExternalStorageDirectory();
    if (a(paramContext) < paramLong)
    {
      h.a("Helpers", new Object[] { "download aborted - not enough free space" });
      throw new a(498, "insufficient space on external media");
    }
    paramContext = new File(paramContext.getPath() + "/download");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      throw new a(492, "unable to create external downloads directory " + paramContext.getPath());
    }
    paramString1 = a(paramContext.getPath(), paramString1, paramString3);
    return paramString1;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject2 = null;
    paramString2 = Uri.decode(paramString2);
    int i;
    if (paramString2 != null)
    {
      i = paramString2.lastIndexOf('/') + 1;
      if (i <= 0) {}
    }
    for (Object localObject1 = paramString2.substring(i);; localObject1 = null)
    {
      paramString2 = (String)localObject1;
      if (localObject1 == null) {
        paramString2 = "downloadfile";
      }
      int j = paramString2.lastIndexOf('.');
      if (j < 0) {
        paramString3 = a(paramString3, true);
      }
      for (;;)
      {
        boolean bool = "recovery".equalsIgnoreCase(paramString2 + paramString3);
        return a(paramString1 + File.separator + paramString2, paramString3, bool);
        localObject1 = localObject2;
        if (paramString3 != null)
        {
          i = paramString2.lastIndexOf('.');
          String str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString2.substring(i + 1));
          if (str != null)
          {
            localObject1 = localObject2;
            if (str.equalsIgnoreCase(paramString3)) {}
          }
          else
          {
            h.a("--------chooseExtensionFromFilename----------" + str, new Object[0]);
            localObject1 = a(paramString3, false);
          }
        }
        paramString3 = (String)localObject1;
        if (localObject1 == null)
        {
          h.a("--------chooseExtensionFromFilename----------" + (String)localObject1, new Object[0]);
          paramString3 = paramString2.substring(j).split("\\?")[0].split("#")[0].split("@")[0];
        }
        paramString2 = paramString2.substring(0, j);
      }
    }
  }
  
  private static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    String str1 = paramString1 + paramString2;
    if ((!new File(str1).exists()) && (!paramBoolean))
    {
      paramString1 = str1;
      return paramString1;
    }
    String str2 = paramString1 + "-";
    int j = 1;
    for (;;)
    {
      if (j >= 1000000000) {
        break label159;
      }
      for (int k = 0;; k++)
      {
        if (k >= 9) {
          break label149;
        }
        str1 = str2 + i + paramString2;
        paramString1 = str1;
        if (!new File(str1).exists()) {
          break;
        }
        i += a.nextInt(j) + 1;
      }
      label149:
      j *= 10;
    }
    label159:
    throw new a(492, "failed to generate an unused filename on internal download storage");
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramString != null)
    {
      localObject1 = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
      localObject2 = localObject1;
      if (localObject1 != null) {
        localObject2 = "." + (String)localObject1;
      }
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((paramString == null) || (!paramString.toLowerCase().startsWith("text/"))) {
        break label90;
      }
      if (!paramString.equalsIgnoreCase("text/html")) {
        break label77;
      }
      localObject1 = ".html";
    }
    for (;;)
    {
      return (String)localObject1;
      label77:
      localObject1 = localObject2;
      if (paramBoolean)
      {
        localObject1 = ".txt";
        continue;
        label90:
        if ((paramString != null) && (paramString.toLowerCase().startsWith("image/")))
        {
          localObject1 = ".jpg";
        }
        else
        {
          localObject1 = localObject2;
          if (paramBoolean) {
            localObject1 = ".bin";
          }
        }
      }
    }
  }
  
  public static void a(ContentResolver paramContentResolver, long paramLong, String paramString)
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(paramString);
      localFile.delete();
      paramContentResolver.delete(a.b, "_id = ? ", new String[] { String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static void a(b paramb)
  {
    if (paramb.a() == 1)
    {
      paramb.b();
      a(paramb);
      if (paramb.a() != 2) {
        throw new IllegalArgumentException("syntax error, unmatched parenthese");
      }
      paramb.b();
    }
    for (;;)
    {
      if (paramb.a() == 3)
      {
        paramb.b();
        break;
        if (paramb.a() != 4) {
          throw new IllegalArgumentException("syntax error, expected column name");
        }
        paramb.b();
        if (paramb.a() == 5)
        {
          paramb.b();
          if (paramb.a() != 6) {
            throw new IllegalArgumentException("syntax error, expected quoted string");
          }
          paramb.b();
        }
        else if (paramb.a() == 7)
        {
          paramb.b();
          if (paramb.a() != 8) {
            throw new IllegalArgumentException("syntax error, expected NULL");
          }
          paramb.b();
        }
        else
        {
          throw new IllegalArgumentException("syntax error after column name");
        }
      }
    }
  }
  
  public static void a(String paramString, Set<String> paramSet)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() == 0) {}
      b localb;
      do
      {
        return;
        localb = new com/lantern/dm/task/e$b;
        localb.<init>(paramString, paramSet);
        a(localb);
      } while (localb.a() == 9);
      paramString = new java/lang/IllegalArgumentException;
      paramString.<init>("syntax error");
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      paramString.printStackTrace();
      throw paramString;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (!Environment.getExternalStorageState().equals("mounted")) {
      h.a("Helpers", new Object[] { "no external storage" });
    }
    for (;;)
    {
      return bool;
      bool = true;
    }
  }
  
  public static boolean a(i parami)
  {
    if (parami.b() != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(String paramString)
  {
    paramString = paramString.replaceFirst("/+", "/");
    if ((paramString.startsWith(Environment.getDownloadCacheDirectory().toString())) || (paramString.startsWith(Environment.getExternalStorageDirectory().toString()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static final class a
    extends Exception
  {
    public int a;
    public String b;
    
    public a(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
    }
  }
  
  private static final class b
  {
    private final String a;
    private final Set<String> b;
    private int c = 0;
    private int d = 0;
    private final char[] e;
    
    public b(String paramString, Set<String> paramSet)
    {
      this.a = paramString;
      this.b = paramSet;
      this.e = new char[this.a.length()];
      this.a.getChars(0, this.e.length, this.e, 0);
      b();
    }
    
    public final int a()
    {
      return this.d;
    }
    
    public final void b()
    {
      Object localObject = this.e;
      while ((this.c < localObject.length) && (localObject[this.c] == ' ')) {
        this.c += 1;
      }
      if (this.c == localObject.length) {
        this.d = 9;
      }
      for (;;)
      {
        return;
        if (localObject[this.c] == '(')
        {
          this.c += 1;
          this.d = 1;
        }
        else if (localObject[this.c] == ')')
        {
          this.c += 1;
          this.d = 2;
        }
        else if (localObject[this.c] == '?')
        {
          this.c += 1;
          this.d = 6;
        }
        else if (localObject[this.c] == '=')
        {
          this.c += 1;
          this.d = 5;
          if ((this.c < localObject.length) && (localObject[this.c] == '=')) {
            this.c += 1;
          }
        }
        else if (localObject[this.c] == '>')
        {
          this.c += 1;
          this.d = 5;
          if ((this.c < localObject.length) && (localObject[this.c] == '=')) {
            this.c += 1;
          }
        }
        else if (localObject[this.c] == '<')
        {
          this.c += 1;
          this.d = 5;
          if ((this.c < localObject.length) && ((localObject[this.c] == '=') || (localObject[this.c] == '>'))) {
            this.c += 1;
          }
        }
        else if (localObject[this.c] == '!')
        {
          this.c += 1;
          this.d = 5;
          if ((this.c < localObject.length) && (localObject[this.c] == '=')) {
            this.c += 1;
          } else {
            throw new IllegalArgumentException("Unexpected character after !");
          }
        }
        else
        {
          int i = localObject[this.c];
          int j;
          if ((i == 95) || ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)))
          {
            i = 1;
            if (i == 0) {
              break label660;
            }
            j = this.c;
            this.c += 1;
            label457:
            if (this.c >= localObject.length) {
              break label544;
            }
            i = localObject[this.c];
            if ((i != 95) && ((i < 65) || (i > 90)) && ((i < 97) || (i > 122)) && ((i < 48) || (i > 57))) {
              break label539;
            }
          }
          label539:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label544;
            }
            this.c += 1;
            break label457;
            i = 0;
            break;
          }
          label544:
          localObject = this.a.substring(j, this.c);
          if (this.c - j <= 4)
          {
            if (((String)localObject).equals("IS"))
            {
              this.d = 7;
              continue;
            }
            if ((((String)localObject).equals("OR")) || (((String)localObject).equals("AND")))
            {
              this.d = 3;
              continue;
            }
            if (((String)localObject).equals("NULL"))
            {
              this.d = 8;
              continue;
            }
          }
          if (this.b.contains(localObject))
          {
            this.d = 4;
          }
          else
          {
            throw new IllegalArgumentException("unrecognized column or keyword");
            label660:
            if (localObject[this.c] != '\'') {
              break;
            }
            for (this.c += 1; this.c < localObject.length; this.c += 1) {
              if (localObject[this.c] == '\'')
              {
                if ((this.c + 1 >= localObject.length) || (localObject[(this.c + 1)] != '\'')) {
                  break;
                }
                this.c += 1;
              }
            }
            if (this.c == localObject.length) {
              throw new IllegalArgumentException("unterminated string");
            }
            this.c += 1;
            this.d = 6;
          }
        }
      }
      throw new IllegalArgumentException("illegal character: " + localObject[this.c]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */