package com.lantern.favorite.a.a;

import android.content.ContentValues;
import com.lantern.favorite.a.b;
import java.lang.reflect.Field;

public final class a
{
  public static String a = "a0000000000000000000000000000001";
  
  public static <T> ContentValues a(Class<?> paramClass, T paramT)
  {
    ContentValues localContentValues = new ContentValues();
    for (Object localObject : paramClass.getDeclaredFields())
    {
      ((Field)localObject).setAccessible(true);
      String str = ((Field)localObject).getName();
      localObject = ((Field)localObject).get(paramT);
      if (localObject != null) {
        localContentValues.put(str, String.valueOf(localObject));
      }
    }
    return localContentValues;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE IF EXISTS ");
    localStringBuilder.append(b.b);
    return localStringBuilder.toString();
  }
  
  public static String a(Class<?> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ").append(b.b + " (");
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfField[i];
      paramClass = ((Field)localObject).getName();
      String str = ((Field)localObject).getType().getName();
      localObject = localStringBuilder.append(paramClass);
      paramClass = null;
      if (str.contains("String")) {
        paramClass = " text";
      }
      for (;;)
      {
        ((StringBuilder)localObject).append(paramClass).append(", ");
        i++;
        break;
        if (str.contains("int")) {
          paramClass = " integer";
        } else if (str.contains("boolean")) {
          paramClass = " boolean";
        } else if (str.contains("float")) {
          paramClass = " float";
        } else if (str.contains("double")) {
          paramClass = " double";
        } else if (str.contains("char")) {
          paramClass = " varchar";
        } else if (str.contains("long")) {
          paramClass = " long";
        }
      }
    }
    a(localStringBuilder, ")");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT * FROM ");
    localStringBuilder.append("sqlite_master");
    localStringBuilder.append(" WHERE ");
    localStringBuilder.append("type='table'");
    localStringBuilder.append(" AND ");
    localStringBuilder.append("name='" + paramString + "'");
    return localStringBuilder.toString();
  }
  
  public static <T> String a(T... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      localStringBuilder.append("SELECT * FROM ");
      localStringBuilder.append(b.b).append(" WHERE ");
      localStringBuilder.append("syncState");
      localStringBuilder.append("='");
      localStringBuilder.append(0);
      localStringBuilder.append("'");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramVarArgs.length == 1)
      {
        localStringBuilder.append("SELECT * FROM ");
        localStringBuilder.append(b.b).append(" WHERE ");
        localStringBuilder.append("favId='" + paramVarArgs[0] + "'");
        localStringBuilder.append(" AND ");
        localStringBuilder.append("state!=2");
      }
      else if (paramVarArgs.length == 2)
      {
        localStringBuilder.append("SELECT * FROM ");
        localStringBuilder.append(b.b);
        localStringBuilder.append(" WHERE ");
        localStringBuilder.append("state!=2");
        localStringBuilder.append(" ORDER BY favTime DESC ");
        localStringBuilder.append("LIMIT " + paramVarArgs[0] + " OFFSET (" + paramVarArgs[1] + "-1) *  " + paramVarArgs[0]);
      }
      else if (paramVarArgs.length == 3)
      {
        localStringBuilder.append("SELECT * FROM ");
        localStringBuilder.append(b.b);
        localStringBuilder.append(" WHERE ");
        localStringBuilder.append("state!=2");
        localStringBuilder.append(" AND  (");
        localStringBuilder.append(" title LIKE ?  OR ");
        localStringBuilder.append(" content LIKE ?  OR ");
        localStringBuilder.append(" srcName LIKE ?  OR ");
        localStringBuilder.append(" authorName LIKE ? )");
        localStringBuilder.append(" ORDER BY favTime DESC ");
        localStringBuilder.append("LIMIT " + paramVarArgs[0] + " OFFSET (" + paramVarArgs[1] + "-1) *  " + paramVarArgs[0]);
      }
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString)
  {
    int i = paramStringBuilder.length();
    paramStringBuilder.replace(i - 2, i, paramString);
  }
  
  public static <T> ContentValues b(Class<?> paramClass, T paramT)
  {
    ContentValues localContentValues = new ContentValues();
    for (Object localObject : paramClass.getDeclaredFields())
    {
      ((Field)localObject).setAccessible(true);
      paramClass = ((Field)localObject).getName();
      localObject = ((Field)localObject).get(paramT);
      if (localObject != null) {
        localContentValues.put(paramClass, String.valueOf(localObject));
      }
    }
    return localContentValues;
  }
  
  public static <T> String b(T... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      localStringBuilder.append("DELETE FROM ");
      localStringBuilder.append("wkfavorite_");
      localStringBuilder.append(a);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("DELETE FROM ");
      localStringBuilder.append(b.b).append(" WHERE ");
      localStringBuilder.append("favId");
      localStringBuilder.append(" IN (");
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++)
      {
        T ? = paramVarArgs[i];
        localStringBuilder.append("'").append(?).append("', ");
      }
      a(localStringBuilder, ")");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */