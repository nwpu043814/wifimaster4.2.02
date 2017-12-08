package com.tencent.mm.sdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.c.a.a;
import com.tencent.mm.sdk.c.a.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MMSharedPreferences
  implements SharedPreferences
{
  private final String[] columns = { "_id", "key", "type", "value" };
  private final ContentResolver cr;
  private REditor editor = null;
  private final HashMap<String, Object> values = new HashMap();
  
  public MMSharedPreferences(Context paramContext)
  {
    this.cr = paramContext.getContentResolver();
  }
  
  private Object getValue(String paramString)
  {
    for (;;)
    {
      try
      {
        localCursor = this.cr.query(a.b.CONTENT_URI, this.columns, "key = ?", new String[] { paramString }, null);
        if (localCursor != null) {
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        Cursor localCursor;
        int j;
        int i;
        paramString.printStackTrace();
        paramString = null;
        continue;
        paramString = null;
        continue;
      }
      return paramString;
      j = localCursor.getColumnIndex("type");
      i = localCursor.getColumnIndex("value");
      if (!localCursor.moveToFirst()) {
        continue;
      }
      paramString = a.a.a(localCursor.getInt(j), localCursor.getString(i));
      localCursor.close();
    }
  }
  
  public boolean contains(String paramString)
  {
    if (getValue(paramString) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public SharedPreferences.Editor edit()
  {
    if (this.editor == null) {
      this.editor = new REditor(this.cr);
    }
    return this.editor;
  }
  
  public Map<String, ?> getAll()
  {
    try
    {
      localCursor = this.cr.query(a.b.CONTENT_URI, this.columns, null, null, null);
      if (localCursor != null) {
        break label30;
      }
      localObject = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Cursor localCursor;
        Object localObject;
        label30:
        int k;
        int j;
        int i;
        localException.printStackTrace();
        HashMap localHashMap = this.values;
        continue;
        localCursor.close();
        localHashMap = this.values;
      }
    }
    return (Map<String, ?>)localObject;
    k = localCursor.getColumnIndex("key");
    j = localCursor.getColumnIndex("type");
    i = localCursor.getColumnIndex("value");
    while (localCursor.moveToNext())
    {
      localObject = a.a.a(localCursor.getInt(j), localCursor.getString(i));
      this.values.put(localCursor.getString(k), localObject);
    }
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = getValue(paramString);
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      bool = paramBoolean;
      if ((paramString instanceof Boolean)) {
        bool = ((Boolean)paramString).booleanValue();
      }
    }
    return bool;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    paramString = getValue(paramString);
    float f = paramFloat;
    if (paramString != null)
    {
      f = paramFloat;
      if ((paramString instanceof Float)) {
        f = ((Float)paramString).floatValue();
      }
    }
    return f;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = getValue(paramString);
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if ((paramString instanceof Integer)) {
        i = ((Integer)paramString).intValue();
      }
    }
    return i;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = getValue(paramString);
    long l = paramLong;
    if (paramString != null)
    {
      l = paramLong;
      if ((paramString instanceof Long)) {
        l = ((Long)paramString).longValue();
      }
    }
    return l;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = getValue(paramString1);
    if ((paramString1 != null) && ((paramString1 instanceof String))) {
      paramString2 = (String)paramString1;
    }
    for (;;)
    {
      return paramString2;
    }
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  private static class REditor
    implements SharedPreferences.Editor
  {
    private boolean clear = false;
    private ContentResolver cr;
    private Set<String> remove = new HashSet();
    private Map<String, Object> values = new HashMap();
    
    public REditor(ContentResolver paramContentResolver)
    {
      this.cr = paramContentResolver;
    }
    
    public void apply() {}
    
    public SharedPreferences.Editor clear()
    {
      this.clear = true;
      return this;
    }
    
    public boolean commit()
    {
      ContentValues localContentValues = new ContentValues();
      if (this.clear)
      {
        this.cr.delete(a.b.CONTENT_URI, null, null);
        this.clear = false;
      }
      Object localObject1 = this.remove.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.cr.delete(a.b.CONTENT_URI, "key = ?", new String[] { localObject2 });
      }
      Object localObject2 = this.values.entrySet().iterator();
      label147:
      label302:
      label326:
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = ((Map.Entry)localObject1).getValue();
        if (localObject3 == null)
        {
          a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
          i = 0;
          if (i != 0) {
            break label302;
          }
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label326;
          }
          this.cr.update(a.b.CONTENT_URI, localContentValues, "key = ?", new String[] { (String)((Map.Entry)localObject1).getKey() });
          break;
          if ((localObject3 instanceof Integer))
          {
            i = 1;
            break label147;
          }
          if ((localObject3 instanceof Long))
          {
            i = 2;
            break label147;
          }
          if ((localObject3 instanceof String))
          {
            i = 3;
            break label147;
          }
          if ((localObject3 instanceof Boolean))
          {
            i = 4;
            break label147;
          }
          if ((localObject3 instanceof Float))
          {
            i = 5;
            break label147;
          }
          if ((localObject3 instanceof Double))
          {
            i = 6;
            break label147;
          }
          a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + localObject3.getClass().toString());
          i = 0;
          break label147;
          localContentValues.put("type", Integer.valueOf(i));
          localContentValues.put("value", localObject3.toString());
        }
      }
      return true;
    }
    
    public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      this.values.put(paramString, Boolean.valueOf(paramBoolean));
      this.remove.remove(paramString);
      return this;
    }
    
    public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      this.values.put(paramString, Float.valueOf(paramFloat));
      this.remove.remove(paramString);
      return this;
    }
    
    public SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      this.values.put(paramString, Integer.valueOf(paramInt));
      this.remove.remove(paramString);
      return this;
    }
    
    public SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      this.values.put(paramString, Long.valueOf(paramLong));
      this.remove.remove(paramString);
      return this;
    }
    
    public SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      this.values.put(paramString1, paramString2);
      this.remove.remove(paramString1);
      return this;
    }
    
    public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      return null;
    }
    
    public SharedPreferences.Editor remove(String paramString)
    {
      this.remove.add(paramString);
      return this;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/openapi/MMSharedPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */