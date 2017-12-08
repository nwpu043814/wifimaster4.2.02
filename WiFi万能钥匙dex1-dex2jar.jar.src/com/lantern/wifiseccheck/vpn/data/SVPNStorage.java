package com.lantern.wifiseccheck.vpn.data;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.vpn.entity.BaseEntity;
import com.lantern.wifiseccheck.vpn.entity.SVPNDetailEvent;
import com.lantern.wifiseccheck.vpn.entity.SVPNMainEvent;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;
import java.util.List;

public class SVPNStorage
{
  public static final Uri PREFERENCE_URI = Uri.parse("content://com.lantern.wifi.sec.provider/t_preference");
  private static final String TAG = "SVPNStorage";
  
  public static void fillAllEvent(List<SVPNDetailEvent> paramList)
  {
    fillAllEvent(paramList, null);
  }
  
  public static void fillAllEvent(List<SVPNDetailEvent> paramList, List<SVPNMainEvent> paramList1)
  {
    paramList.clear();
    if (paramList1 != null) {
      paramList1.clear();
    }
    Object localObject = VpnUtils.getInstance().getApp().getContentResolver();
    Cursor localCursor = ((ContentResolver)localObject).query(SVPNMainEvent.URI, null, null, null, "create_time DESC");
    localObject = ((ContentResolver)localObject).query(SVPNDetailEvent.URI, null, null, null, "create_time DESC");
    if (localObject != null) {}
    try
    {
      if (((Cursor)localObject).getCount() > 0) {
        ((Cursor)localObject).moveToFirst();
      }
      if ((localCursor != null) && (localCursor.getCount() > 0))
      {
        localCursor.moveToFirst();
        boolean bool;
        do
        {
          int i = localCursor.getInt(localCursor.getColumnIndexOrThrow("type"));
          if ((i <= 6) && (i > 0))
          {
            SVPNMainEvent localSVPNMainEvent = new com/lantern/wifiseccheck/vpn/entity/SVPNMainEvent;
            localSVPNMainEvent.<init>();
            localSVPNMainEvent.setId(localCursor.getInt(localCursor.getColumnIndexOrThrow("id")));
            localSVPNMainEvent.setBssid(localCursor.getString(localCursor.getColumnIndexOrThrow("bssid")));
            localSVPNMainEvent.setCreateTime(localCursor.getLong(localCursor.getColumnIndexOrThrow("create_time")));
            localSVPNMainEvent.setSsid(localCursor.getString(localCursor.getColumnIndexOrThrow("ssid")));
            localSVPNMainEvent.setSummary(localCursor.getString(localCursor.getColumnIndexOrThrow("summary")));
            localSVPNMainEvent.setType(i);
            if (((i == 1) || (i == 3)) && (!((Cursor)localObject).isAfterLast())) {
              do
              {
                if (((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndexOrThrow("create_time")) < localSVPNMainEvent.getCreateTime()) {
                  break;
                }
                SVPNDetailEvent localSVPNDetailEvent = new com/lantern/wifiseccheck/vpn/entity/SVPNDetailEvent;
                localSVPNDetailEvent.<init>();
                localSVPNDetailEvent.setId(((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("id")));
                localSVPNDetailEvent.setCreateTime(((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndexOrThrow("create_time")));
                localSVPNDetailEvent.setParentCreateTime(localSVPNMainEvent.getCreateTime());
                localSVPNDetailEvent.setParentID(localSVPNMainEvent.getId());
                localSVPNDetailEvent.setParentSummary(localSVPNMainEvent.getSummary());
                String str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndexOrThrow("summary"));
                StringBuilder localStringBuilder = new java/lang/StringBuilder;
                localStringBuilder.<init>("summary ===");
                LogUtils.d("SVPNStorage", str);
                localSVPNDetailEvent.setSummary(((Cursor)localObject).getString(((Cursor)localObject).getColumnIndexOrThrow("summary")));
                localSVPNDetailEvent.setType(((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("type")));
                paramList.add(localSVPNDetailEvent);
              } while (((Cursor)localObject).moveToNext());
            }
            if (paramList1 != null) {
              paramList1.add(localSVPNMainEvent);
            }
          }
          bool = localCursor.moveToNext();
        } while (bool);
      }
      return;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        paramList.printStackTrace();
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  public static Cursor getPreference(String paramString)
  {
    localContentResolver = VpnUtils.getInstance().getApp().getContentResolver();
    try
    {
      Cursor localCursor = localContentResolver.query(PREFERENCE_URI, null, "key=?", new String[] { paramString }, null);
      paramString = localCursor;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtils.d("SVPNStorage", "query db got exception");
        localException.printStackTrace();
        try
        {
          paramString = localContentResolver.query(PREFERENCE_URI, null, "key=?", new String[] { paramString }, null);
        }
        catch (Exception paramString)
        {
          LogUtils.d("SVPNStorage", "query db got exception too");
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
    return paramString;
  }
  
  public static SVPNMainEvent getTopMainEvent()
  {
    SVPNMainEvent localSVPNMainEvent = new SVPNMainEvent();
    localCursor = VpnUtils.getInstance().getApp().getContentResolver().query(localSVPNMainEvent.getContentUri(), null, null, null, " create_time desc limit 1 offset 0");
    if (localCursor != null) {
      Log.d("SVPNStorage", "cr.getCount =" + localCursor.getCount());
    }
    try
    {
      if (localCursor.getCount() > 0)
      {
        localCursor.moveToFirst();
        localSVPNMainEvent.setBssid(localCursor.getString(localCursor.getColumnIndexOrThrow("bssid")));
        localSVPNMainEvent.setCreateTime(localCursor.getLong(localCursor.getColumnIndexOrThrow("create_time")));
        localSVPNMainEvent.setId(localCursor.getInt(localCursor.getColumnIndexOrThrow("id")));
        localSVPNMainEvent.setSsid(localCursor.getString(localCursor.getColumnIndexOrThrow("ssid")));
        localSVPNMainEvent.setSummary(localCursor.getString(localCursor.getColumnIndexOrThrow("summary")));
        localSVPNMainEvent.setType(localCursor.getInt(localCursor.getColumnIndexOrThrow("type")));
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
        localCursor.close();
      }
    }
    finally
    {
      localCursor.close();
    }
    return localSVPNMainEvent;
  }
  
  public static long insertEntityToDB(BaseEntity paramBaseEntity)
  {
    long l = 0L;
    ContentValues localContentValues = paramBaseEntity.toContentValues();
    paramBaseEntity = VpnUtils.getInstance().getApp().getContentResolver().insert(paramBaseEntity.getContentUri(), localContentValues);
    if (paramBaseEntity != null) {
      l = ContentUris.parseId(paramBaseEntity);
    }
    return l;
  }
  
  public static boolean setPreference(ContentValues paramContentValues)
  {
    if (ContentUris.parseId(VpnUtils.getInstance().getApp().getContentResolver().insert(PREFERENCE_URI, paramContentValues)) == -1L) {
      LogUtils.d("SVPNStorage", "set preference failed " + paramContentValues);
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/data/SVPNStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */