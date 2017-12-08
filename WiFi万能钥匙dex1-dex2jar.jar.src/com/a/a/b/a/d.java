package com.a.a.b.a;

import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class d
{
  private static final Object c = new Object();
  private final Object a = new Object();
  private File b;
  private HashMap d = new HashMap();
  
  public d(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.b = new File(paramString);
      return;
    }
    throw new RuntimeException("Directory can not be empty");
  }
  
  private File b()
  {
    synchronized (this.a)
    {
      File localFile = this.b;
      return localFile;
    }
  }
  
  private static File b(File paramFile)
  {
    return new File(paramFile.getPath() + ".bak");
  }
  
  public final b a(String arg1)
  {
    Object localObject1 = b();
    ??? = ??? + ".xml";
    File localFile;
    if (???.indexOf(File.separatorChar) < 0) {
      localFile = new File((File)localObject1, ???);
    }
    synchronized (c)
    {
      localObject1 = (a)this.d.get(localFile);
      if ((localObject1 != null) && (!((a)localObject1).e()))
      {
        return (b)localObject1;
        throw new IllegalArgumentException("File " + ??? + " contains a path separator");
      }
      ??? = b(localFile);
      if (???.exists())
      {
        localFile.delete();
        ???.renameTo(localFile);
      }
      if (localFile.exists()) {
        localFile.canRead();
      }
      if ((!localFile.exists()) || (!localFile.canRead())) {}
    }
    for (;;)
    {
      try
      {
        localObject4 = new java/io/FileInputStream;
        ((FileInputStream)localObject4).<init>(localFile);
        ??? = Xml.newPullParser();
        ???.setInput((InputStream)localObject4, null);
        ??? = (HashMap)e.a(???, new String[1]);
      }
      catch (XmlPullParserException localObject2)
      {
        try
        {
          ((FileInputStream)localObject4).close();
          localObject5 = c;
          if (localObject1 == null) {
            continue;
          }
          try
          {
            ((a)localObject1).a(???);
            break;
          }
          finally {}
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
        catch (Exception localException2)
        {
          Object localObject4;
          Object localObject5;
          a locala;
          Object localObject3;
          continue;
        }
        catch (IOException localIOException3)
        {
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException3)
        {
          continue;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          continue;
        }
        ??? = ???;
        ??? = null;
        try
        {
          localObject5 = new java/io/FileInputStream;
          ((FileInputStream)localObject5).<init>(localFile);
          localObject4 = new byte[((FileInputStream)localObject5).available()];
          ((FileInputStream)localObject5).read((byte[])localObject4);
          new String((byte[])localObject4, 0, localObject4.length, "UTF-8");
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          localFileNotFoundException1.printStackTrace();
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
        continue;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        ??? = null;
        localFileNotFoundException2.printStackTrace();
        continue;
      }
      catch (IOException localIOException2)
      {
        ??? = null;
        localIOException2.printStackTrace();
        continue;
      }
      catch (Exception localException1)
      {
        ??? = null;
        localException1.printStackTrace();
        continue;
        locala = (a)this.d.get(localFile);
        localObject3 = locala;
        if (locala != null) {
          continue;
        }
        localObject3 = new com/a/a/b/a/d$a;
        ((a)localObject3).<init>(localFile, ???);
        this.d.put(localFile, localObject3);
        continue;
      }
      ??? = null;
    }
  }
  
  private static final class a
    implements b
  {
    private static final Object f = new Object();
    private final File a;
    private final File b;
    private final int c;
    private Map d;
    private boolean e = false;
    private WeakHashMap g;
    
    a(File paramFile, Map paramMap)
    {
      this.a = paramFile;
      this.b = d.a(paramFile);
      this.c = 0;
      if (paramMap != null) {}
      for (;;)
      {
        this.d = paramMap;
        this.g = new WeakHashMap();
        return;
        paramMap = new HashMap();
      }
    }
    
    private static FileOutputStream a(File paramFile)
    {
      try
      {
        FileOutputStream localFileOutputStream1 = new java/io/FileOutputStream;
        localFileOutputStream1.<init>(paramFile);
        paramFile = localFileOutputStream1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (!paramFile.getParentFile().mkdir()) {
            paramFile = null;
          } else {
            try
            {
              FileOutputStream localFileOutputStream2 = new java/io/FileOutputStream;
              localFileOutputStream2.<init>(paramFile);
              paramFile = localFileOutputStream2;
            }
            catch (FileNotFoundException paramFile)
            {
              paramFile = null;
            }
          }
        }
      }
      return paramFile;
    }
    
    private boolean f()
    {
      boolean bool2 = false;
      boolean bool1;
      if (this.a.exists()) {
        if (!this.b.exists())
        {
          if (this.a.renameTo(this.b)) {
            break label48;
          }
          bool1 = bool2;
        }
      }
      for (;;)
      {
        return bool1;
        this.a.delete();
        try
        {
          label48:
          FileOutputStream localFileOutputStream = a(this.a);
          bool1 = bool2;
          if (localFileOutputStream == null) {
            continue;
          }
          Map localMap = this.d;
          a locala = new com/a/a/b/a/a;
          locala.<init>();
          locala.setOutput(localFileOutputStream, "utf-8");
          locala.startDocument(null, Boolean.valueOf(true));
          locala.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
          e.a(localMap, null, locala);
          locala.endDocument();
          localFileOutputStream.close();
          this.b.delete();
          bool1 = true;
        }
        catch (IOException localIOException)
        {
          bool1 = bool2;
          if (!this.a.exists()) {
            continue;
          }
          this.a.delete();
          bool1 = bool2;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          for (;;) {}
        }
      }
    }
    
    /* Error */
    public final long a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 45	com/a/a/b/a/d$a:d	Ljava/util/Map;
      //   6: aload_1
      //   7: invokeinterface 137 2 0
      //   12: checkcast 139	java/lang/Long
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull +12 -> 29
      //   20: aload_1
      //   21: invokevirtual 143	java/lang/Long:longValue	()J
      //   24: lstore_2
      //   25: aload_0
      //   26: monitorexit
      //   27: lload_2
      //   28: lreturn
      //   29: lconst_0
      //   30: lstore_2
      //   31: goto -6 -> 25
      //   34: astore_1
      //   35: aload_0
      //   36: monitorexit
      //   37: aload_1
      //   38: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	a
      //   0	39	1	paramString	String
      //   24	7	2	l	long
      // Exception table:
      //   from	to	target	type
      //   2	16	34	finally
      //   20	25	34	finally
      //   25	27	34	finally
      //   35	37	34	finally
    }
    
    /* Error */
    public final String a(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 45	com/a/a/b/a/d$a:d	Ljava/util/Map;
      //   6: aload_1
      //   7: invokeinterface 137 2 0
      //   12: checkcast 146	java/lang/String
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull +9 -> 26
      //   20: aload_1
      //   21: astore_2
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_2
      //   25: areturn
      //   26: goto -4 -> 22
      //   29: astore_1
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_1
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	a
      //   0	34	1	paramString1	String
      //   0	34	2	paramString2	String
      // Exception table:
      //   from	to	target	type
      //   2	16	29	finally
      //   22	24	29	finally
      //   30	32	29	finally
    }
    
    public final void a(Map paramMap)
    {
      if (paramMap != null) {}
      try
      {
        this.d = paramMap;
        return;
      }
      finally {}
    }
    
    public final boolean a()
    {
      if ((this.a != null) && (new File(this.a.getAbsolutePath()).exists())) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final Map b()
    {
      try
      {
        HashMap localHashMap = new java/util/HashMap;
        localHashMap.<init>(this.d);
        return localHashMap;
      }
      finally {}
    }
    
    public final b.a c()
    {
      return new a();
    }
    
    public final void d()
    {
      try
      {
        this.e = true;
        return;
      }
      finally {}
    }
    
    public final boolean e()
    {
      try
      {
        boolean bool = this.e;
        return bool;
      }
      finally {}
    }
    
    public final class a
      implements b.a
    {
      private final Map b = new HashMap();
      private boolean c = false;
      
      public a() {}
      
      public final b.a a()
      {
        try
        {
          this.c = true;
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString)
      {
        try
        {
          this.b.put(paramString, this);
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString, float paramFloat)
      {
        try
        {
          this.b.put(paramString, Float.valueOf(paramFloat));
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString, int paramInt)
      {
        try
        {
          this.b.put(paramString, Integer.valueOf(paramInt));
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString, long paramLong)
      {
        try
        {
          this.b.put(paramString, Long.valueOf(paramLong));
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString1, String paramString2)
      {
        try
        {
          this.b.put(paramString1, paramString2);
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString, boolean paramBoolean)
      {
        try
        {
          this.b.put(paramString, Boolean.valueOf(paramBoolean));
          return this;
        }
        finally {}
      }
      
      public final boolean b()
      {
        for (;;)
        {
          int i;
          Object localObject5;
          String str;
          synchronized ()
          {
            if (d.a.a(d.a.this).size() > 0)
            {
              i = 1;
              if (i == 0) {
                break label311;
              }
              localArrayList = new java/util/ArrayList;
              localArrayList.<init>();
              HashSet localHashSet = new java/util/HashSet;
              localHashSet.<init>(d.a.a(d.a.this).keySet());
            }
            try
            {
              if (this.c)
              {
                d.a.b(d.a.this).clear();
                this.c = false;
              }
              Iterator localIterator = this.b.entrySet().iterator();
              if (!localIterator.hasNext())
              {
                this.b.clear();
                boolean bool = d.a.c(d.a.this);
                if (bool) {
                  d.a.this.d();
                }
                if (i != 0)
                {
                  i = localArrayList.size() - 1;
                  if (i >= 0) {
                    break label267;
                  }
                }
                return bool;
                i = 0;
                continue;
              }
              localObject5 = (Map.Entry)localIterator.next();
              str = (String)((Map.Entry)localObject5).getKey();
              localObject5 = ((Map.Entry)localObject5).getValue();
              if (localObject5 == this)
              {
                d.a.b(d.a.this).remove(str);
                if (i == 0) {
                  continue;
                }
                localArrayList.add(str);
                continue;
                localObject2 = finally;
              }
            }
            finally {}
          }
          d.a.b(d.a.this).put(str, localObject5);
          continue;
          label267:
          localArrayList.get(i);
          ??? = ((Set)localObject2).iterator();
          for (;;)
          {
            if (!((Iterator)???).hasNext())
            {
              i--;
              break;
            }
            ((Iterator)???).next();
          }
          label311:
          Object localObject3 = null;
          ArrayList localArrayList = null;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */