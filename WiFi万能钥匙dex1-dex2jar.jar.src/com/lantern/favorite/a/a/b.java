package com.lantern.favorite.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bluefay.b.h;
import com.lantern.core.favorite.WkSceneFavorite;

public final class b
  extends SQLiteOpenHelper
{
  public b(Context paramContext)
  {
    super(paramContext, "wkfavorite.db", null, 1);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramSQLiteDatabase.execSQL(a.a(WkSceneFavorite.class));
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        paramSQLiteDatabase.endTransaction();
      }
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramSQLiteDatabase.execSQL(a.a());
      paramSQLiteDatabase.execSQL(a.a(WkSceneFavorite.class));
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        paramSQLiteDatabase.endTransaction();
      }
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */