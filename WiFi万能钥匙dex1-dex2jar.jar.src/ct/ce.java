package ct;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.FileEntity;

public final class ce
  implements cf
{
  private final bi a;
  private final File b;
  private final File c;
  
  public ce(bi parambi)
  {
    this.a = parambi;
    this.b = parambi.a.getDir("abcdef", 0);
    this.c = new File(this.b, "abcdef");
  }
  
  private Pair<Integer, File> a()
  {
    int j = 0;
    Object localObject = this.b.listFiles(new ce.1());
    if ((localObject != null) && (localObject.length > 0))
    {
      long l1 = localObject[0].lastModified();
      int i = 1;
      while (i < localObject.length)
      {
        long l3 = localObject[i].lastModified();
        long l2 = l1;
        if (l3 < l1)
        {
          l2 = l3;
          j = i;
        }
        i++;
        l1 = l2;
      }
    }
    for (localObject = Pair.create(Integer.valueOf(localObject.length), localObject[j]);; localObject = Pair.create(Integer.valueOf(0), null)) {
      return (Pair<Integer, File>)localObject;
    }
  }
  
  public final void b(String paramString)
  {
    paramString = b.a.a(paramString.getBytes());
    if (this.c.length() > 30720L)
    {
      Object localObject = a();
      if (((Integer)((Pair)localObject).first).intValue() > 5)
      {
        localObject = (File)((Pair)localObject).second;
        if (localObject != null) {
          ((File)localObject).delete();
        }
      }
      localObject = new File(this.b, "abcdef." + UUID.randomUUID().toString());
      this.c.renameTo((File)localObject);
    }
    try
    {
      b.a.a(paramString, this.c);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        b.a.a("TxOfflineDataManager", paramString.getMessage(), paramString);
      }
    }
  }
  
  public final void d()
  {
    localFile = (File)a().second;
    if (localFile != null) {}
    for (;;)
    {
      try
      {
        localAndroidHttpClient = AndroidHttpClient.newInstance("tencent");
        localObject2 = new org/apache/http/client/methods/HttpPost;
        Object localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>();
        StringBuilder localStringBuilder = ((StringBuilder)localObject4).append("http://111.161.52.33:10001//DataWarehouse/UploadFile?type=log&path=_gps_").append(this.a.h().a()).append("_");
        localObject4 = new java/util/Date;
        ((Date)localObject4).<init>();
        ((HttpPost)localObject2).<init>(((Date)localObject4).getTime() + "_" + (int)(Math.random() * 100000.0D));
        localObject4 = new org/apache/http/entity/FileEntity;
        ((FileEntity)localObject4).<init>(localFile, "application/octet-stream");
        ((HttpPost)localObject2).setEntity((HttpEntity)localObject4);
      }
      catch (IOException localIOException1)
      {
        AndroidHttpClient localAndroidHttpClient;
        Object localObject2;
        b.a.a("TxOfflineDataManager", localIOException1.getMessage(), localIOException1);
        localFile.delete();
        continue;
      }
      finally
      {
        localFile.delete();
      }
      try
      {
        localObject2 = localAndroidHttpClient.execute((HttpUriRequest)localObject2);
        if (((HttpResponse)localObject2).getStatusLine().getStatusCode() == 200)
        {
          localObject2 = ((HttpResponse)localObject2).getEntity();
          if (localObject2 != null) {
            ((HttpEntity)localObject2).consumeContent();
          }
          if (localAndroidHttpClient != null) {
            localAndroidHttpClient.close();
          }
          localFile.delete();
          return;
        }
        localObject2 = new java/io/IOException;
        ((IOException)localObject2).<init>();
        throw ((Throwable)localObject2);
      }
      catch (IOException localIOException2)
      {
        throw localIOException2;
      }
      finally
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
        if (localAndroidHttpClient != null) {
          localAndroidHttpClient.close();
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */