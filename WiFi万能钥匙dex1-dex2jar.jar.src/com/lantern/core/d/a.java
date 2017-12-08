package com.lantern.core.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a
{
  private static final String[] a = { "_id", "title", "icon", "description", "uri", "media_type", "total_size", "local_uri", "status", "reason", "bytes_so_far", "last_modified_timestamp", "item", "_data" };
  private static final String[] b = { "_id", "title", "icon", "description", "uri", "mimetype", "total_bytes", "status", "current_bytes", "lastmod", "destination", "hint", "_data", "item" };
  private static final Set<String> c = new HashSet(Arrays.asList(new String[] { "_id", "total_size", "status", "reason", "bytes_so_far", "last_modified_timestamp" }));
  private ContentResolver d;
  private String e;
  private Context f;
  private Uri g = com.lantern.core.model.a.a;
  
  public a(Context paramContext)
  {
    this.f = paramContext;
    this.d = paramContext.getContentResolver();
    this.e = paramContext.getPackageName();
  }
  
  static String d(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    for (int i = 0; i < paramArrayOfLong.length; i++)
    {
      if (i > 0) {
        localStringBuilder.append("OR ");
      }
      localStringBuilder.append("_id");
      localStringBuilder.append(" = ? ");
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  static String[] e(long[] paramArrayOfLong)
  {
    String[] arrayOfString = new String[paramArrayOfLong.length];
    for (int i = 0; i < paramArrayOfLong.length; i++) {
      arrayOfString[i] = Long.toString(paramArrayOfLong[i]);
    }
    return arrayOfString;
  }
  
  public final int a(long... paramVarArgs)
  {
    b localb = new b();
    for (int i = 0; i <= 0; i++)
    {
      Object localObject = new Intent("android.intent.action.DOWNLOAD_REMOVE");
      ((Intent)localObject).putExtra("extra_download_id", paramVarArgs[0]);
      ((Intent)localObject).setPackage(this.f.getPackageName());
      this.f.sendBroadcast((Intent)localObject);
      localb.a(new long[] { paramVarArgs[0] });
      localObject = a(localb);
      if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
      {
        int j = ((Cursor)localObject).getColumnIndex("_data");
        if (j != -1)
        {
          localObject = ((Cursor)localObject).getString(j);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Uri.parse((String)localObject) != null)) {
            new File(Uri.parse((String)localObject).getPath()).delete();
          }
        }
      }
    }
    return this.d.delete(this.g, d(paramVarArgs), e(paramVarArgs));
  }
  
  public final long a(c paramc)
  {
    paramc = paramc.b(this.e);
    long l = Long.parseLong(this.d.insert(com.lantern.core.model.a.a, paramc).getLastPathSegment());
    Log.i("enqueue=", String.valueOf(l));
    return l;
  }
  
  public final Cursor a(b paramb)
  {
    paramb = paramb.a(this.d, b, this.g);
    if (paramb == null) {}
    for (paramb = null;; paramb = new a(paramb)) {
      return paramb;
    }
  }
  
  public final void b(long... paramVarArgs)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("control", Integer.valueOf(1));
    localContentValues.put("status", Integer.valueOf(193));
    this.d.update(this.g, localContentValues, d(paramVarArgs), e(paramVarArgs));
  }
  
  public final void c(long... paramVarArgs)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("numfailed", "0");
    localContentValues.put("control", Integer.valueOf(0));
    localContentValues.put("status", Integer.valueOf(190));
    this.d.update(this.g, localContentValues, " status != '192' AND " + d(paramVarArgs), e(paramVarArgs));
  }
  
  private static final class a
    extends CursorWrapper
  {
    static
    {
      if (!a.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    public a(Cursor paramCursor)
    {
      super();
    }
    
    private static int a(int paramInt)
    {
      switch (paramInt)
      {
      case 191: 
      case 197: 
      case 198: 
      case 199: 
      default: 
        if ((!a) && (!com.lantern.core.model.a.a(paramInt))) {
          throw new AssertionError();
        }
        break;
      case 190: 
        paramInt = 1;
      }
      for (;;)
      {
        return paramInt;
        paramInt = 2;
        continue;
        paramInt = 4;
        continue;
        paramInt = 8;
        continue;
        paramInt = 16;
      }
    }
    
    private static boolean a(String paramString)
    {
      return a.b().contains(paramString);
    }
    
    private String b(String paramString)
    {
      if (a(paramString)) {
        paramString = Long.toString(c(paramString));
      }
      for (;;)
      {
        return paramString;
        if (paramString.equals("title"))
        {
          paramString = e("title");
        }
        else if (paramString.equals("icon"))
        {
          paramString = e("icon");
        }
        else if (paramString.equals("description"))
        {
          paramString = e("description");
        }
        else if (paramString.equals("uri"))
        {
          paramString = e("uri");
        }
        else if (paramString.equals("media_type"))
        {
          paramString = e("mimetype");
        }
        else if (paramString.equals("item"))
        {
          paramString = e("item");
        }
        else
        {
          if ((!a) && (!paramString.equals("local_uri"))) {
            throw new AssertionError();
          }
          paramString = e("_data");
          if (paramString == null) {
            paramString = null;
          } else {
            paramString = Uri.fromFile(new File(paramString)).toString();
          }
        }
      }
    }
    
    private long c(String paramString)
    {
      long l;
      if (!a(paramString)) {
        l = Long.valueOf(b(paramString)).longValue();
      }
      for (;;)
      {
        return l;
        if (paramString.equals("_id"))
        {
          l = d("_id");
        }
        else if (paramString.equals("total_size"))
        {
          l = d("total_bytes");
        }
        else if (paramString.equals("status"))
        {
          l = a((int)d("status"));
        }
        else if (paramString.equals("reason"))
        {
          int i = (int)d("status");
          switch (a(i))
          {
          default: 
            l = 0L;
            break;
          case 16: 
            if (((400 <= i) && (i < 488)) || ((500 <= i) && (i < 600)))
            {
              l = i;
              continue;
            }
            switch (i)
            {
            case 490: 
            case 491: 
            case 496: 
            default: 
              l = 1000L;
              break;
            case 492: 
              l = 1001L;
              break;
            case 493: 
            case 494: 
              l = 1002L;
              break;
            case 495: 
              l = 1004L;
              break;
            case 497: 
              l = 1005L;
              break;
            case 498: 
              l = 1006L;
              break;
            case 499: 
              l = 1007L;
              break;
            case 489: 
              l = 1008L;
              break;
            case 488: 
              l = 1009L;
            }
            break;
          case 4: 
            switch (i)
            {
            default: 
              l = 4L;
              break;
            case 194: 
              l = 1L;
              break;
            case 195: 
              l = 2L;
              break;
            case 196: 
              l = 3L;
            }
            break;
          }
        }
        else if (paramString.equals("bytes_so_far"))
        {
          l = d("current_bytes");
        }
        else
        {
          if ((!a) && (!paramString.equals("last_modified_timestamp"))) {
            throw new AssertionError();
          }
          l = d("lastmod");
        }
      }
    }
    
    private long d(String paramString)
    {
      return super.getLong(super.getColumnIndex(paramString));
    }
    
    private String e(String paramString)
    {
      return super.getString(super.getColumnIndex(paramString));
    }
    
    public final byte[] getBlob(int paramInt)
    {
      throw new UnsupportedOperationException();
    }
    
    public final int getColumnCount()
    {
      return a.a().length;
    }
    
    public final int getColumnIndex(String paramString)
    {
      return Arrays.asList(a.a()).indexOf(paramString);
    }
    
    public final int getColumnIndexOrThrow(String paramString)
    {
      int i = getColumnIndex(paramString);
      if (i == -1) {
        throw new IllegalArgumentException("No such column: " + paramString);
      }
      return i;
    }
    
    public final String getColumnName(int paramInt)
    {
      int i = a.a().length;
      if ((paramInt < 0) || (paramInt >= i)) {
        throw new IllegalArgumentException("Invalid column index " + paramInt + ", " + i + " columns exist");
      }
      return a.a()[paramInt];
    }
    
    public final String[] getColumnNames()
    {
      String[] arrayOfString = new String[a.a().length];
      System.arraycopy(a.a(), 0, arrayOfString, 0, a.a().length);
      return arrayOfString;
    }
    
    public final double getDouble(int paramInt)
    {
      return getLong(paramInt);
    }
    
    public final float getFloat(int paramInt)
    {
      return (float)getDouble(paramInt);
    }
    
    public final int getInt(int paramInt)
    {
      return (int)getLong(paramInt);
    }
    
    public final long getLong(int paramInt)
    {
      return c(getColumnName(paramInt));
    }
    
    public final short getShort(int paramInt)
    {
      return (short)(int)getLong(paramInt);
    }
    
    public final String getString(int paramInt)
    {
      return b(getColumnName(paramInt));
    }
  }
  
  public static final class b
  {
    private long[] a = null;
    private Integer b = null;
    private String c = "lastmod";
    private int d = 2;
    private boolean e = false;
    private int f = 0;
    
    private static String a(String paramString)
    {
      return "status" + paramString + "'200'";
    }
    
    private static String a(String paramString, Iterable<String> paramIterable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramIterable.iterator();
      for (int i = 1; localIterator.hasNext(); i = 0)
      {
        paramIterable = (String)localIterator.next();
        if (i == 0) {
          localStringBuilder.append(paramString);
        }
        localStringBuilder.append(paramIterable);
      }
      return localStringBuilder.toString();
    }
    
    public final Cursor a(ContentResolver paramContentResolver, String[] paramArrayOfString, Uri paramUri)
    {
      Object localObject = new ArrayList();
      if (this.a != null) {
        ((List)localObject).add(a.d(this.a));
      }
      for (String[] arrayOfString = a.e(this.a);; arrayOfString = null)
      {
        String str;
        if (this.b != null)
        {
          if (this.b.intValue() == 200) {
            ((List)localObject).add(a("="));
          }
        }
        else
        {
          if (this.e) {
            ((List)localObject).add("is_visible_in_downloads_ui != '0'");
          }
          ((List)localObject).add("deleted != '1'");
          if (this.f != 0) {
            ((List)localObject).add("item == '0'");
          }
          str = a(" AND ", (Iterable)localObject);
          if (this.d != 1) {
            break label204;
          }
        }
        label204:
        for (localObject = "ASC";; localObject = "DESC")
        {
          Log.i("orderBy=", this.c + " " + (String)localObject);
          this.b = null;
          return paramContentResolver.query(paramUri, paramArrayOfString, str, arrayOfString, null);
          ((List)localObject).add(a("!="));
          break;
        }
      }
    }
    
    public final b a(long... paramVarArgs)
    {
      this.a = paramVarArgs;
      return this;
    }
  }
  
  public static final class c
  {
    private Uri b;
    private Uri c;
    private List<Pair<String, String>> d = new ArrayList();
    private CharSequence e;
    private CharSequence f;
    private CharSequence g;
    private boolean h = true;
    private String i;
    private boolean j = true;
    private int k = -1;
    private boolean l = true;
    private int m = 0;
    private CharSequence n;
    
    static
    {
      if (!a.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    public c(Uri paramUri)
    {
      if (paramUri == null) {
        throw new NullPointerException();
      }
      String str = paramUri.getScheme();
      if ((str == null) || ((!str.equals("http")) && (!str.equals("https")))) {
        throw new IllegalArgumentException("Can only download HTTP URIs: " + paramUri);
      }
      this.b = paramUri;
    }
    
    private static void a(ContentValues paramContentValues, String paramString, Object paramObject)
    {
      if (paramObject != null) {
        paramContentValues.put(paramString, paramObject.toString());
      }
    }
    
    private void a(File paramFile, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("subPath cannot be null");
      }
      this.c = Uri.withAppendedPath(Uri.fromFile(paramFile), paramString);
    }
    
    public final c a()
    {
      this.k = 2;
      return this;
    }
    
    public final c a(CharSequence paramCharSequence)
    {
      this.f = paramCharSequence;
      return this;
    }
    
    public final c a(String paramString)
    {
      this.i = paramString;
      return this;
    }
    
    public final c a(String paramString1, String paramString2)
    {
      a(Environment.getExternalStoragePublicDirectory(paramString1), paramString2);
      return this;
    }
    
    public final c a(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }
    
    final ContentValues b(String paramString)
    {
      int i1 = 0;
      ContentValues localContentValues = new ContentValues();
      if ((!a) && (this.b == null)) {
        throw new AssertionError();
      }
      localContentValues.put("uri", this.b.toString());
      localContentValues.put("is_public_api", Boolean.valueOf(true));
      localContentValues.put("notificationpackage", paramString);
      if (this.c != null)
      {
        localContentValues.put("destination", Integer.valueOf(4));
        localContentValues.put("hint", this.c.toString());
        a(localContentValues, "item", Integer.valueOf(this.m));
        a(localContentValues, "title", this.e);
        a(localContentValues, "icon", this.f);
        a(localContentValues, "description", this.g);
        a(localContentValues, "mimetype", this.i);
        a(localContentValues, "useragent", this.n);
        if (!this.h) {
          break label235;
        }
      }
      for (;;)
      {
        localContentValues.put("visibility", Integer.valueOf(i1));
        localContentValues.put("allowed_network_types", Integer.valueOf(this.k));
        localContentValues.put("allow_roaming", Boolean.valueOf(this.j));
        localContentValues.put("is_visible_in_downloads_ui", Boolean.valueOf(this.l));
        localContentValues.put("no_integrity", Integer.valueOf(1));
        return localContentValues;
        localContentValues.put("destination", Integer.valueOf(0));
        break;
        label235:
        i1 = 2;
      }
    }
    
    public final c b()
    {
      this.j = false;
      return this;
    }
    
    public final c b(CharSequence paramCharSequence)
    {
      this.g = paramCharSequence;
      return this;
    }
    
    public final c b(String paramString1, String paramString2)
    {
      paramString1 = new File(Environment.getExternalStorageDirectory() + "/" + paramString1 + "/");
      if (!paramString1.exists()) {
        paramString1.mkdirs();
      }
      a(paramString1, paramString2);
      this.e = paramString2;
      return this;
    }
    
    public final c b(boolean paramBoolean)
    {
      this.l = paramBoolean;
      return this;
    }
    
    public final c c(CharSequence paramCharSequence)
    {
      this.n = paramCharSequence;
      return this;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */