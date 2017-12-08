package android.support.v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile
{
  private final File mBackupName;
  private final File mBaseName;
  
  public AtomicFile(File paramFile)
  {
    this.mBaseName = paramFile;
    this.mBackupName = new File(paramFile.getPath() + ".bak");
  }
  
  static boolean sync(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.getFD().sync();
      bool = true;
    }
    catch (IOException paramFileOutputStream)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public void delete()
  {
    this.mBaseName.delete();
    this.mBackupName.delete();
  }
  
  public void failWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {
      sync(paramFileOutputStream);
    }
    try
    {
      paramFileOutputStream.close();
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
      return;
    }
    catch (IOException paramFileOutputStream)
    {
      for (;;)
      {
        Log.w("AtomicFile", "failWrite: Got exception:", paramFileOutputStream);
      }
    }
  }
  
  public void finishWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {
      sync(paramFileOutputStream);
    }
    try
    {
      paramFileOutputStream.close();
      this.mBackupName.delete();
      return;
    }
    catch (IOException paramFileOutputStream)
    {
      for (;;)
      {
        Log.w("AtomicFile", "finishWrite: Got exception:", paramFileOutputStream);
      }
    }
  }
  
  public File getBaseFile()
  {
    return this.mBaseName;
  }
  
  public FileInputStream openRead()
  {
    if (this.mBackupName.exists())
    {
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
    }
    return new FileInputStream(this.mBaseName);
  }
  
  public byte[] readFully()
  {
    int i = 0;
    FileInputStream localFileInputStream = openRead();
    try
    {
      Object localObject1 = new byte[localFileInputStream.available()];
      int j = localFileInputStream.read((byte[])localObject1, i, localObject1.length - i);
      if (j <= 0) {
        return (byte[])localObject1;
      }
      i = j + i;
      j = localFileInputStream.available();
      if (j > localObject1.length - i)
      {
        byte[] arrayOfByte = new byte[j + i];
        System.arraycopy(localObject1, 0, arrayOfByte, 0, i);
        localObject1 = arrayOfByte;
      }
      for (;;)
      {
        break;
      }
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public FileOutputStream startWrite()
  {
    if (this.mBaseName.exists())
    {
      if (this.mBackupName.exists()) {
        break label85;
      }
      if (!this.mBaseName.renameTo(this.mBackupName)) {
        Log.w("AtomicFile", "Couldn't rename file " + this.mBaseName + " to backup file " + this.mBackupName);
      }
    }
    try
    {
      for (;;)
      {
        FileOutputStream localFileOutputStream1 = new java/io/FileOutputStream;
        localFileOutputStream1.<init>(this.mBaseName);
        return localFileOutputStream1;
        label85:
        this.mBaseName.delete();
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        if (!this.mBaseName.getParentFile().mkdir()) {
          throw new IOException("Couldn't create directory " + this.mBaseName);
        }
        try
        {
          FileOutputStream localFileOutputStream2 = new FileOutputStream(this.mBaseName);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          throw new IOException("Couldn't create " + this.mBaseName);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/util/AtomicFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */