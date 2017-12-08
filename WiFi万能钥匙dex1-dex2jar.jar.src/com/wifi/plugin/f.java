package com.wifi.plugin;

import com.wifi.plugin.a.a;
import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class f
{
  public static String a = System.getProperty("os.arch");
  
  public static void a(String paramString1, String paramString2)
  {
    b.a("CPU is " + a);
    try
    {
      ZipFile localZipFile = new java/util/zip/ZipFile;
      File localFile = new java/io/File;
      localFile.<init>(paramString1);
      localZipFile.<init>(localFile);
      paramString1 = new java/io/File;
      paramString1.<init>(paramString2);
      if (a(localZipFile, paramString1)) {
        b.a("The plugin is contains .so files.");
      }
      for (;;)
      {
        return;
        b.a("The plugin isn't contain any .so files.");
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        b.b(paramString1.getMessage());
      }
    }
  }
  
  private static boolean a(ZipFile paramZipFile, File paramFile)
  {
    HashMap localHashMap = new HashMap();
    Enumeration localEnumeration = paramZipFile.entries();
    Object localObject2;
    Object localObject1;
    if (!localEnumeration.hasMoreElements())
    {
      localObject2 = (List)localHashMap.get(a.toLowerCase());
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label336;
      }
      localObject2 = (List)localHashMap.get("armeabi");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label336;
      }
      localObject1 = (List)localHashMap.get("armeabi-v7a");
    }
    label336:
    for (;;)
    {
      boolean bool = false;
      if (localObject1 != null)
      {
        if (!paramFile.exists()) {
          paramFile.mkdirs();
        }
        localObject2 = ((List)localObject1).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext())
        {
          bool = true;
          return bool;
          ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
          localObject2 = localZipEntry.getName();
          localObject1 = localObject2;
          if (((String)localObject2).startsWith("/")) {
            localObject1 = ((String)localObject2).substring(1);
          }
          if ((!((String)localObject1).startsWith("lib/")) || (localZipEntry.isDirectory())) {
            break;
          }
          int i = ((String)localObject1).indexOf('/', 4);
          if (i > 0) {}
          for (localObject1 = ((String)localObject1).substring(4, i).toLowerCase();; localObject1 = "armeabi")
          {
            localObject3 = (List)localHashMap.get(localObject1);
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new LinkedList();
              localHashMap.put(localObject1, localObject2);
            }
            ((List)localObject2).add(localZipEntry);
            break;
          }
        }
        localObject1 = (ZipEntry)((Iterator)localObject2).next();
        Object localObject3 = ((ZipEntry)localObject1).getName();
        localObject3 = new File(paramFile, ((String)localObject3).substring(((String)localObject3).lastIndexOf('/') + 1));
        a.a(paramZipFile.getInputStream((ZipEntry)localObject1), (File)localObject3);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */