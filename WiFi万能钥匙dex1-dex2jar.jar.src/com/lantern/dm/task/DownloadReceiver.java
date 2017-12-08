package com.lantern.dm.task;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.NetworkInfo;
import android.net.Uri;
import com.bluefay.b.h;
import com.lantern.core.g.j;
import com.lantern.core.model.a;
import com.qihoo.util.StubApp1053578832;
import java.io.File;

public class DownloadReceiver
  extends BroadcastReceiver
{
  private i a = null;
  private volatile boolean b;
  
  static
  {
    StubApp1053578832.interface11(13);
  }
  
  private static void a(Context paramContext)
  {
    paramContext.startService(new Intent(paramContext, DownloadService.class));
  }
  
  private void a(Context paramContext, Uri paramUri, Cursor paramCursor)
  {
    this.a.a(ContentUris.parseId(paramUri));
    int i = paramCursor.getInt(paramCursor.getColumnIndexOrThrow("status"));
    int j = paramCursor.getInt(paramCursor.getColumnIndexOrThrow("visibility"));
    if ((a.b(i)) && (j == 1))
    {
      paramCursor = new ContentValues();
      paramCursor.put("visibility", Integer.valueOf(0));
      paramContext.getContentResolver().update(paramUri, paramCursor, null, null);
    }
  }
  
  private static void a(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a == null) {
      this.a = new f(paramContext);
    }
    Object localObject1 = paramIntent.getAction();
    if (((String)localObject1).equals("android.intent.action.BOOT_COMPLETED")) {
      a(paramContext);
    }
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (((String)localObject1).equals("android.net.conn.CONNECTIVITY_CHANGE"))
          {
            paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
            if (paramIntent != null)
            {
              if (!paramIntent.isConnected())
              {
                localObject1 = paramContext.getContentResolver().query(a.a, null, "status !='200' ", null, null);
                if ((localObject1 != null) && (((Cursor)localObject1).getCount() > 0))
                {
                  localObject2 = new ContentValues();
                  ((ContentValues)localObject2).put("control", Integer.valueOf(1));
                  ((ContentValues)localObject2).put("status", Integer.valueOf(193));
                  paramContext.getContentResolver().update(a.a, (ContentValues)localObject2, "status!='200'", null);
                }
                a((Cursor)localObject1);
              }
              if (paramIntent.isConnected())
              {
                h.a("--------------DownloadReceiver---------------", new Object[0]);
                localObject1 = paramContext.getContentResolver().query(a.a, null, "status !='200' ", null, null);
                if (paramIntent.getType() == 1)
                {
                  this.b = true;
                  if ((localObject1 != null) && (((Cursor)localObject1).getCount() > 0)) {
                    j.a().a(new c(this, paramContext));
                  }
                }
                for (;;)
                {
                  a((Cursor)localObject1);
                  break;
                  if ((paramIntent.getType() == 0) && (this.b))
                  {
                    this.b = false;
                    if ((localObject1 != null) && (((Cursor)localObject1).getCount() > 0))
                    {
                      paramIntent = new ContentValues();
                      paramIntent.put("control", Integer.valueOf(1));
                      paramIntent.put("status", Integer.valueOf(193));
                      paramContext.getContentResolver().update(a.a, paramIntent, "status!='200'", null);
                    }
                  }
                }
              }
            }
          }
          else
          {
            if (!((String)localObject1).equals("android.intent.action.DOWNLOAD_WAKEUP")) {
              break;
            }
            a(paramContext);
          }
        }
      } while ((!((String)localObject1).equals("android.intent.action.DOWNLOAD_OPEN")) && (!((String)localObject1).equals("android.intent.action.DOWNLOAD_LIST")) && (!((String)localObject1).equals("android.intent.action.DOWNLOAD_HIDE")));
      localObject3 = paramIntent.getData();
      localObject1 = paramIntent.getAction();
      localObject2 = paramContext.getContentResolver().query((Uri)localObject3, null, null, null, null);
    } while (localObject2 == null);
    for (;;)
    {
      try
      {
        boolean bool = ((Cursor)localObject2).moveToFirst();
        if (!bool)
        {
          ((Cursor)localObject2).close();
          break;
        }
        if (((String)localObject1).equals("android.intent.action.DOWNLOAD_OPEN"))
        {
          String str2 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndexOrThrow("_data"));
          String str1 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndexOrThrow("mimetype"));
          localObject1 = Uri.parse(str2);
          paramIntent = (Intent)localObject1;
          if (((Uri)localObject1).getScheme() == null)
          {
            paramIntent = new java/io/File;
            paramIntent.<init>(str2);
            paramIntent = Uri.fromFile(paramIntent);
          }
          localObject1 = new android/content/Intent;
          ((Intent)localObject1).<init>("android.intent.action.VIEW");
          ((Intent)localObject1).setDataAndType(paramIntent, str1);
          ((Intent)localObject1).setFlags(268435456);
          try
          {
            paramContext.startActivity((Intent)localObject1);
            a(paramContext, (Uri)localObject3, (Cursor)localObject2);
          }
          catch (ActivityNotFoundException paramIntent)
          {
            paramIntent.printStackTrace();
            continue;
          }
        }
        if (!((String)localObject1).equals("android.intent.action.DOWNLOAD_LIST")) {
          break label769;
        }
      }
      finally
      {
        ((Cursor)localObject2).close();
      }
      localObject1 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndexOrThrow("notificationpackage"));
      if (localObject1 != null)
      {
        localObject3 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndexOrThrow("notificationclass"));
        int i;
        if (((Cursor)localObject2).getInt(((Cursor)localObject2).getColumnIndex("is_public_api")) != 0)
        {
          i = 1;
          label649:
          if (i == 0) {
            break label688;
          }
          paramContext = new android/content/Intent;
          paramContext.<init>("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
          paramContext.setPackage((String)localObject1);
        }
        for (;;)
        {
          this.a.a(paramContext);
          break;
          i = 0;
          break label649;
          label688:
          if (localObject3 == null) {
            break;
          }
          paramContext = new android/content/Intent;
          paramContext.<init>("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
          paramContext.setClassName((String)localObject1, (String)localObject3);
          if (paramIntent.getBooleanExtra("multiple", true))
          {
            paramContext.setData(a.a);
          }
          else
          {
            long l = ((Cursor)localObject2).getLong(((Cursor)localObject2).getColumnIndexOrThrow("_id"));
            paramContext.setData(ContentUris.withAppendedId(a.a, l));
          }
        }
        label769:
        a(paramContext, (Uri)localObject3, (Cursor)localObject2);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/DownloadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */