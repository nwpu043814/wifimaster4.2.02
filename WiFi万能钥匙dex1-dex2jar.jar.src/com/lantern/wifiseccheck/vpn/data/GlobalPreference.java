package com.lantern.wifiseccheck.vpn.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;

public class GlobalPreference
{
  private static final String SYNC = "sync";
  private static GlobalPreference mInstance = null;
  
  private GlobalPreference(Context paramContext) {}
  
  public static GlobalPreference getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
      {
        GlobalPreference localGlobalPreference = new com/lantern/wifiseccheck/vpn/data/GlobalPreference;
        localGlobalPreference.<init>(paramContext);
        mInstance = localGlobalPreference;
      }
      return mInstance;
    }
    finally {}
  }
  
  /* Error */
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 33	com/lantern/wifiseccheck/vpn/data/SVPNStorage:getPreference	(Ljava/lang/String;)Landroid/database/Cursor;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +52 -> 58
    //   9: aload_1
    //   10: invokeinterface 39 1 0
    //   15: ifeq +37 -> 52
    //   18: aload_1
    //   19: aload_1
    //   20: ldc 41
    //   22: invokeinterface 45 2 0
    //   27: invokeinterface 49 2 0
    //   32: istore_3
    //   33: iload_3
    //   34: ifeq +13 -> 47
    //   37: iconst_1
    //   38: istore_2
    //   39: aload_1
    //   40: invokeinterface 52 1 0
    //   45: iload_2
    //   46: ireturn
    //   47: iconst_0
    //   48: istore_2
    //   49: goto -10 -> 39
    //   52: aload_1
    //   53: invokeinterface 52 1 0
    //   58: goto -13 -> 45
    //   61: astore 4
    //   63: aload 4
    //   65: invokevirtual 55	java/lang/IllegalArgumentException:printStackTrace	()V
    //   68: aload_1
    //   69: invokeinterface 52 1 0
    //   74: goto -16 -> 58
    //   77: astore 4
    //   79: aload_1
    //   80: invokeinterface 52 1 0
    //   85: aload 4
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	GlobalPreference
    //   0	88	1	paramString	String
    //   0	88	2	paramBoolean	boolean
    //   32	2	3	i	int
    //   61	3	4	localIllegalArgumentException	IllegalArgumentException
    //   77	9	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	33	61	java/lang/IllegalArgumentException
    //   9	33	77	finally
    //   63	68	77	finally
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    paramString = SVPNStorage.getPreference(paramString);
    d = paramDouble;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (!paramString.moveToFirst()) {
          continue;
        }
        d = paramString.getDouble(paramString.getColumnIndexOrThrow("value"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramString.close();
        d = paramDouble;
        continue;
      }
      finally
      {
        paramString.close();
      }
      return d;
      paramString.close();
      d = paramDouble;
    }
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    paramString = SVPNStorage.getPreference(paramString);
    f = paramFloat;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (!paramString.moveToFirst()) {
          continue;
        }
        f = paramString.getFloat(paramString.getColumnIndexOrThrow("value"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramString.close();
        f = paramFloat;
        continue;
      }
      finally
      {
        paramString.close();
      }
      return f;
      paramString.close();
      f = paramFloat;
    }
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = SVPNStorage.getPreference(paramString);
    i = paramInt;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (!paramString.moveToFirst()) {
          continue;
        }
        i = paramString.getInt(paramString.getColumnIndexOrThrow("value"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramString.close();
        i = paramInt;
        continue;
      }
      finally
      {
        paramString.close();
      }
      return i;
      paramString.close();
      i = paramInt;
    }
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = SVPNStorage.getPreference(paramString);
    l = paramLong;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (!paramString.moveToFirst()) {
          continue;
        }
        l = paramString.getLong(paramString.getColumnIndexOrThrow("value"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramString.close();
        l = paramLong;
        continue;
      }
      finally
      {
        paramString.close();
      }
      return l;
      paramString.close();
      l = paramLong;
    }
  }
  
  public String getString(String paramString1, String paramString2)
  {
    localCursor = SVPNStorage.getPreference(paramString1);
    paramString1 = paramString2;
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          continue;
        }
        paramString1 = localCursor.getString(localCursor.getColumnIndexOrThrow("value"));
        boolean bool = TextUtils.isEmpty(paramString1);
        if (!bool) {
          continue;
        }
        localCursor.close();
        paramString1 = paramString2;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        localCursor.close();
        paramString1 = paramString2;
        continue;
      }
      finally
      {
        localCursor.close();
      }
      return paramString1;
      localCursor.close();
      continue;
      localCursor.close();
      paramString1 = paramString2;
    }
  }
  
  public boolean setBoolean(String paramString, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString);
    localContentValues.put("value", Boolean.valueOf(paramBoolean));
    return SVPNStorage.setPreference(localContentValues);
  }
  
  public boolean setDouble(String paramString, double paramDouble)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString);
    localContentValues.put("value", Double.valueOf(paramDouble));
    return SVPNStorage.setPreference(localContentValues);
  }
  
  public boolean setFloat(String paramString, Float paramFloat)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString);
    localContentValues.put("value", paramFloat);
    return SVPNStorage.setPreference(localContentValues);
  }
  
  public boolean setInt(String paramString, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString);
    localContentValues.put("value", Integer.valueOf(paramInt));
    return SVPNStorage.setPreference(localContentValues);
  }
  
  public boolean setLong(String paramString, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString);
    localContentValues.put("value", Long.valueOf(paramLong));
    return SVPNStorage.setPreference(localContentValues);
  }
  
  public boolean setString(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString1);
    localContentValues.put("value", paramString2);
    return SVPNStorage.setPreference(localContentValues);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/data/GlobalPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */