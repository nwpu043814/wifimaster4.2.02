package bluefay.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

public final class b
{
  ByteArrayInputStream a;
  private Context b;
  private InputStream c;
  private String d;
  private Uri e;
  private ZipFile f;
  private String g;
  
  public b(String paramString)
  {
    this.d = paramString;
  }
  
  public final void a()
  {
    try
    {
      if (this.c != null) {
        this.c.close();
      }
      if (this.f != null) {
        this.f.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public final InputStream b()
  {
    a();
    if (this.e != null)
    {
      this.c = this.b.getContentResolver().openInputStream(this.e);
      if ((this.c != null) && (!(this.c instanceof ByteArrayInputStream))) {
        this.c = new BufferedInputStream(this.c, 16384);
      }
    }
    for (;;)
    {
      return this.c;
      try
      {
        if (this.g == null) {
          break label122;
        }
        ZipFile localZipFile = new java/util/zip/ZipFile;
        localZipFile.<init>(this.g);
        this.f = localZipFile;
        this.c = this.f.getInputStream(this.f.getEntry(this.d));
      }
      catch (Exception localException) {}
      continue;
      label122:
      if (this.d != null)
      {
        FileInputStream localFileInputStream = new java/io/FileInputStream;
        localFileInputStream.<init>(this.d);
        this.c = localFileInputStream;
      }
      else if (this.a != null)
      {
        this.a.reset();
        this.c = this.a;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */