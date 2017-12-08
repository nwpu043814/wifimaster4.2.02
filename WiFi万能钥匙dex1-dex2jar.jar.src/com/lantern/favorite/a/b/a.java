package com.lantern.favorite.a.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.lantern.core.favorite.WkSceneFavorite;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class a
  extends SQLiteClosable
  implements com.lantern.favorite.a.a
{
  private Context a;
  private com.lantern.favorite.a.a.b b;
  
  public a(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = new com.lantern.favorite.a.a.b(this.a);
    if (!paramString.equals(com.lantern.favorite.a.b.a))
    {
      com.lantern.favorite.a.b.a(paramString);
      if (!b(com.lantern.favorite.a.b.b)) {
        this.b.onCreate(b());
      }
    }
  }
  
  private static void a(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  private SQLiteDatabase b()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        acquireReference();
        paramString = this.b.getWritableDatabase().rawQuery(com.lantern.favorite.a.a.a.a(paramString), null);
        if (paramString != null)
        {
          int i = paramString.getCount();
          if (i > 0)
          {
            releaseReference();
            bool = true;
            return bool;
          }
        }
        a(paramString);
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString.printStackTrace();
        releaseReference();
        continue;
      }
      finally
      {
        releaseReference();
      }
      bool = false;
    }
  }
  
  private SQLiteDatabase c()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getReadableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int a(String paramString)
  {
    for (;;)
    {
      try
      {
        acquireReference();
        SQLiteDatabase localSQLiteDatabase = this.b.getReadableDatabase();
        StringBuilder localStringBuilder1 = new java/lang/StringBuilder;
        localStringBuilder1.<init>();
        localStringBuilder1.append("SELECT syncState FROM ");
        localStringBuilder1.append(com.lantern.favorite.a.b.b).append(" WHERE ");
        StringBuilder localStringBuilder2 = new java/lang/StringBuilder;
        localStringBuilder2.<init>("favId='");
        localStringBuilder1.append(paramString + "'");
        paramString = localSQLiteDatabase.rawQuery(localStringBuilder1.toString(), null);
        if ((paramString != null) && (paramString.moveToNext()))
        {
          i = paramString.getInt(paramString.getColumnIndex("syncState"));
          return i;
        }
        a(paramString);
      }
      catch (Exception paramString)
      {
        int i;
        paramString.printStackTrace();
        releaseReference();
        continue;
      }
      finally
      {
        releaseReference();
      }
      i = -1;
    }
  }
  
  public final void a()
  {
    try
    {
      releaseReference();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final <T> boolean a(T paramT)
  {
    try
    {
      acquireReference();
      this.b.getWritableDatabase().insert(com.lantern.favorite.a.b.b, null, com.lantern.favorite.a.a.a.a(WkSceneFavorite.class, paramT));
      releaseReference();
      bool = true;
    }
    catch (Exception paramT)
    {
      for (;;)
      {
        paramT.printStackTrace();
        releaseReference();
        boolean bool = false;
      }
    }
    finally
    {
      releaseReference();
    }
    return bool;
  }
  
  public final <T> boolean a(T... paramVarArgs)
  {
    try
    {
      acquireReference();
      this.b.getWritableDatabase().execSQL(com.lantern.favorite.a.a.a.b(paramVarArgs));
      releaseReference();
      bool = true;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        releaseReference();
        boolean bool = false;
      }
    }
    finally
    {
      releaseReference();
    }
    return bool;
  }
  
  public final <T> ArrayList<WkSceneFavorite> b(T... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    WkSceneFavorite localWkSceneFavorite;
    for (;;)
    {
      try
      {
        acquireReference();
        localObject2 = this.b.getReadableDatabase();
        localObject1 = null;
        if (paramVarArgs.length == 3)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("%");
          localObject3 = String.valueOf(paramVarArgs[2]) + "%";
          localObject1 = new String[4];
          localObject1[0] = localObject3;
          localObject1[1] = localObject3;
          localObject1[2] = localObject3;
          localObject1[3] = localObject3;
        }
        localObject1 = ((SQLiteDatabase)localObject2).rawQuery(com.lantern.favorite.a.a.a.a(paramVarArgs), (String[])localObject1);
        paramVarArgs = WkSceneFavorite.class.getDeclaredFields();
        if ((localObject1 == null) || (!((Cursor)localObject1).moveToNext())) {
          break label325;
        }
        localWkSceneFavorite = (WkSceneFavorite)WkSceneFavorite.class.newInstance();
        int j = paramVarArgs.length;
        int i = 0;
        if (i >= j) {
          break label314;
        }
        localObject3 = paramVarArgs[i];
        ((Field)localObject3).setAccessible(true);
        localObject2 = ((Field)localObject3).getType().getName();
        if (!((String)localObject2).contains("String")) {
          continue;
        }
        ((Field)localObject3).set(localWkSceneFavorite, ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex(((Field)localObject3).getName())));
        i++;
      }
      catch (Exception paramVarArgs)
      {
        Object localObject2;
        Object localObject3;
        paramVarArgs.printStackTrace();
        return localArrayList;
        if (!((String)localObject2).contains("long")) {
          continue;
        }
        ((Field)localObject3).set(localWkSceneFavorite, Long.valueOf(((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex(((Field)localObject3).getName()))));
        continue;
      }
      finally
      {
        releaseReference();
      }
      continue;
      if (!((String)localObject2).contains("int")) {
        continue;
      }
      ((Field)localObject3).set(localWkSceneFavorite, Integer.valueOf(((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex(((Field)localObject3).getName()))));
    }
    for (;;)
    {
      label314:
      localArrayList.add(localWkSceneFavorite);
      break;
      label325:
      a((Cursor)localObject1);
      releaseReference();
    }
  }
  
  public final <T> boolean b(T paramT)
  {
    bool = true;
    try
    {
      acquireReference();
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      paramT = com.lantern.favorite.a.a.a.b(WkSceneFavorite.class, paramT);
      String str = paramT.getAsString("favId");
      localSQLiteDatabase.update(com.lantern.favorite.a.b.b, paramT, "favId=?", new String[] { str });
    }
    catch (Exception paramT)
    {
      for (;;)
      {
        paramT.printStackTrace();
        releaseReference();
        bool = false;
      }
    }
    finally
    {
      releaseReference();
    }
    return bool;
  }
  
  public final void onAllReferencesReleased()
  {
    if (this.b != null)
    {
      Log.i("king", "onAllReferencesReleased");
      b().close();
      c().close();
      this.b.close();
      this.b = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */