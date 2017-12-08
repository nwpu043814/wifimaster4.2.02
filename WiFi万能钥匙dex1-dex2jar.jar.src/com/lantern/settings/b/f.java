package com.lantern.settings.b;

import android.os.Environment;
import android.text.TextUtils;
import com.bluefay.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class f
{
  private static f a;
  private String b;
  
  public static f a()
  {
    try
    {
      if (a == null)
      {
        localf = new com/lantern/settings/b/f;
        localf.<init>();
        a = localf;
      }
      f localf = a;
      return localf;
    }
    finally {}
  }
  
  private static ArrayList<String> c()
  {
    String[] arrayOfString = b.a(new File("/etc/vold.fstab"), null).split(" ");
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < arrayOfString.length; i++) {
      if ((arrayOfString[i].contains("dev_mount")) && (new File(arrayOfString[(i + 2)]).exists())) {
        localArrayList.add(arrayOfString[(i + 2)]);
      }
    }
    return localArrayList;
  }
  
  public final String b()
  {
    Object localObject;
    File localFile;
    if (TextUtils.isEmpty(this.b))
    {
      if (!"mounted".equals(Environment.getExternalStorageState())) {
        break label82;
      }
      localObject = Environment.getExternalStorageDirectory().getPath();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label82;
      }
      localFile = new File((String)localObject);
      if ((!localFile.exists()) || (!localFile.isDirectory()) || (!localFile.canRead()) || (!localFile.canWrite())) {
        break label82;
      }
    }
    for (;;)
    {
      this.b = ((String)localObject);
      return this.b;
      label82:
      localObject = new File("/storage/sdcard");
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).canRead()) && (((File)localObject).canWrite()))
      {
        localObject = ((File)localObject).getPath();
      }
      else
      {
        localObject = new File("/storage/sdcard0");
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).canRead()) && (((File)localObject).canWrite()))
        {
          localObject = ((File)localObject).getPath();
        }
        else
        {
          localObject = new File("/storage/sdcard1");
          if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).canRead()) && (((File)localObject).canWrite()))
          {
            localObject = ((File)localObject).getPath();
          }
          else
          {
            localObject = new File("/storage/sdcard2");
            if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).canRead()) && (((File)localObject).canWrite()))
            {
              localObject = ((File)localObject).getPath();
            }
            else
            {
              localObject = new File("/mnt/sdcard2");
              if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).canRead()) && (((File)localObject).canWrite()))
              {
                localObject = ((File)localObject).getPath();
              }
              else
              {
                localObject = new File("/mnt/sdcard");
                if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).canRead()) && (((File)localObject).canWrite()))
                {
                  localObject = ((File)localObject).getPath();
                }
                else
                {
                  localObject = new File("/mnt/internal");
                  if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).canRead()) && (((File)localObject).canWrite()))
                  {
                    localObject = ((File)localObject).getPath();
                  }
                  else
                  {
                    localObject = c().iterator();
                    for (;;)
                    {
                      if (((Iterator)localObject).hasNext())
                      {
                        localFile = new File((String)((Iterator)localObject).next());
                        if ((localFile.exists()) && (localFile.isDirectory()) && (localFile.canRead()) && (localFile.canWrite()))
                        {
                          localObject = localFile.getAbsolutePath();
                          break;
                        }
                      }
                    }
                    localObject = null;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */