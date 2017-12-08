package com.lantern.dynamictab.e;

import com.lantern.core.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class d
{
  public static final String a = new File(c.getInstance().getFilesDir(), "friendconfig").getAbsolutePath();
  
  public static Object a(String paramString)
  {
    ObjectInputStream localObjectInputStream = new ObjectInputStream(new FileInputStream(paramString));
    paramString = localObjectInputStream.readObject();
    localObjectInputStream.close();
    return paramString;
  }
  
  public static void a(Object paramObject, String paramString)
  {
    paramString = new ObjectOutputStream(new FileOutputStream(paramString));
    paramString.writeObject(paramObject);
    paramString.close();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */