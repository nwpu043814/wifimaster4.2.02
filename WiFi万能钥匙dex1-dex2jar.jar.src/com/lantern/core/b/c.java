package com.lantern.core.b;

import java.io.File;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class c
{
  private final AtomicLong a;
  private final AtomicInteger b;
  private final long c;
  private final int d;
  private final Map<File, Long> e = Collections.synchronizedMap(new Hashtable());
  private File f;
  
  public c(File paramFile)
  {
    this.f = paramFile;
    this.c = 5242880L;
    this.d = 3000;
    this.a = new AtomicLong();
    this.b = new AtomicInteger();
    new Thread(new d(this)).start();
  }
  
  private long a()
  {
    File localFile = null;
    long l;
    if (this.e.isEmpty())
    {
      l = 0L;
      return l;
    }
    Object localObject1 = this.e.entrySet();
    for (;;)
    {
      synchronized (this.e)
      {
        Iterator localIterator = ((Set)localObject1).iterator();
        localObject1 = null;
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localFile == null)
          {
            localFile = (File)localEntry.getKey();
            localObject1 = (Long)localEntry.getValue();
          }
          else
          {
            Long localLong = (Long)localEntry.getValue();
            if (localLong.longValue() < ((Long)localObject1).longValue())
            {
              localFile = (File)localEntry.getKey();
              localObject1 = localLong;
            }
          }
        }
        else
        {
          l = localFile.length();
          if (localFile.delete()) {
            this.e.remove(localFile);
          }
        }
      }
    }
  }
  
  protected final File a(String paramString)
  {
    File localFile = b(paramString);
    paramString = Long.valueOf(System.currentTimeMillis());
    localFile.setLastModified(paramString.longValue());
    this.e.put(localFile, paramString);
    return localFile;
  }
  
  protected final void a(File paramFile)
  {
    for (int i = this.b.get(); i + 1 > this.d; i = this.b.addAndGet(-1))
    {
      l1 = a();
      this.a.addAndGet(-l1);
    }
    this.b.addAndGet(1);
    long l2 = paramFile.length();
    for (long l1 = this.a.get(); l1 + l2 > this.c; l1 = this.a.addAndGet(-l1)) {
      l1 = a();
    }
    this.a.addAndGet(l2);
    l1 = System.currentTimeMillis();
    paramFile.setLastModified(l1);
    this.e.put(paramFile, Long.valueOf(l1));
  }
  
  protected final File b(String paramString)
  {
    return new File(this.f, String.valueOf(paramString.hashCode()));
  }
  
  protected final boolean c(String paramString)
  {
    return a(paramString).delete();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */