package cm.pass.sdk.utils;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class n
{
  public static <E> String a(List<E> paramList)
  {
    if (paramList == null) {
      paramList = "";
    }
    for (;;)
    {
      return paramList;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramList);
      paramList = new String(b.c(localByteArrayOutputStream.toByteArray(), 0));
      localObjectOutputStream.close();
    }
  }
  
  public static <E> List<E> a(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      paramString = new ObjectInputStream(new ByteArrayInputStream(b.a(paramString.getBytes(), 0)));
      try
      {
        paramString = (List)paramString.readObject();
      }
      catch (ClassNotFoundException paramString)
      {
        for (;;)
        {
          paramString = null;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */