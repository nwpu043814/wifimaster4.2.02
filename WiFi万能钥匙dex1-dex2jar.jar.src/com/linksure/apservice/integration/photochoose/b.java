package com.linksure.apservice.integration.photochoose;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static b a;
  private String b;
  
  public static b a()
  {
    try
    {
      if (a == null)
      {
        localb = new com/linksure/apservice/integration/photochoose/b;
        localb.<init>();
        a = localb;
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  private static ArrayList<String> d()
  {
    String[] arrayOfString = com.bluefay.b.b.a(new File("/etc/vold.fstab"), null).split(" ");
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
    return c() + File.separator + "WifiMasterKey" + File.separator + "temp" + File.separator + "get_image.jpg";
  }
  
  public final String c()
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
                    localObject = d().iterator();
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */