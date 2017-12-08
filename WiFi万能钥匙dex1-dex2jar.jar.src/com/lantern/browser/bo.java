package com.lantern.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.webkit.ValueCallback;
import java.io.File;
import java.util.ArrayList;

public final class bo
{
  private ValueCallback<Uri> a;
  private String b;
  private boolean c;
  private Context d;
  
  public bo(Context paramContext)
  {
    this.d = paramContext;
  }
  
  private Intent a()
  {
    Intent localIntent1 = new Intent("android.intent.action.GET_CONTENT");
    localIntent1.addCategory("android.intent.category.OPENABLE");
    localIntent1.setType("*/*");
    Intent localIntent2 = new Intent("android.media.action.IMAGE_CAPTURE");
    File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    localFile = new File(localFile.getAbsolutePath() + File.separator + "browser-photos");
    localFile.mkdirs();
    this.b = (localFile.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg");
    localIntent2.putExtra("output", Uri.fromFile(new File(this.b)));
    localIntent2 = a(new Intent[] { localIntent2, b(), c() });
    localIntent2.putExtra("android.intent.extra.INTENT", localIntent1);
    return localIntent2;
  }
  
  private static Intent a(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.setType(paramString);
    return localIntent;
  }
  
  private Intent a(Intent... paramVarArgs)
  {
    Intent localIntent = new Intent("android.intent.action.CHOOSER");
    localIntent.putExtra("android.intent.extra.INITIAL_INTENTS", paramVarArgs);
    localIntent.putExtra("android.intent.extra.TITLE", this.d.getResources().getString(R.string.browser_upload));
    return localIntent;
  }
  
  private void a(Intent paramIntent)
  {
    try
    {
      ((Activity)this.d).startActivityForResult(paramIntent, 1001);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      for (;;)
      {
        try
        {
          this.c = true;
          ((Activity)this.d).startActivityForResult(a(), 1001);
        }
        catch (ActivityNotFoundException paramIntent) {}
      }
    }
  }
  
  private static Intent b()
  {
    return new Intent("android.media.action.VIDEO_CAPTURE");
  }
  
  private static Intent c()
  {
    return new Intent("android.provider.MediaStore.RECORD_SOUND");
  }
  
  final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      if ((paramInt2 != 0) || (!this.c)) {
        break;
      }
      this.c = false;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramIntent != null) && (paramInt2 == -1)) {
      if (paramInt1 == 1000)
      {
        localObject1 = (ArrayList)paramIntent.getSerializableExtra("picker_result");
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
          break label338;
        }
        localObject2 = (String)((ArrayList)localObject1).get(0);
        localObject1 = this.d;
        localObject3 = new File((String)localObject2);
        localObject2 = ((File)localObject3).getAbsolutePath();
        Cursor localCursor = ((Context)localObject1).getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=? ", new String[] { localObject2 }, null);
        if ((localCursor != null) && (localCursor.moveToFirst()))
        {
          paramInt1 = localCursor.getInt(localCursor.getColumnIndex("_id"));
          localObject1 = Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), String.valueOf(paramInt1));
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (paramIntent == null)
        {
          localObject2 = localObject1;
          if (paramInt2 == -1)
          {
            paramIntent = new File(this.b);
            localObject2 = localObject1;
            if (paramIntent.exists())
            {
              localObject2 = Uri.fromFile(paramIntent);
              this.d.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", (Uri)localObject2));
            }
          }
        }
      }
      this.a.onReceiveValue(localObject2);
      this.a = null;
      this.c = false;
      break;
      if (((File)localObject3).exists())
      {
        localObject3 = new ContentValues();
        ((ContentValues)localObject3).put("_data", (String)localObject2);
        localObject1 = ((Context)localObject1).getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject3);
      }
      else
      {
        localObject1 = null;
        continue;
        localObject1 = paramIntent.getData();
        continue;
        label338:
        localObject1 = null;
      }
    }
  }
  
  final void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    String str1 = "filesystem";
    if (this.a != null) {}
    for (;;)
    {
      return;
      this.a = paramValueCallback;
      String[] arrayOfString = paramString1.split(";");
      String str2 = arrayOfString[0];
      paramValueCallback = str1;
      if (paramString2.length() > 0) {
        paramValueCallback = paramString2;
      }
      paramString1 = paramValueCallback;
      if (paramString2.equals("filesystem"))
      {
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          paramString1 = paramValueCallback;
          if (i >= j) {
            break;
          }
          paramString2 = arrayOfString[i].split("=");
          paramString1 = paramValueCallback;
          if (paramString2.length == 2)
          {
            paramString1 = paramValueCallback;
            if ("capture".equals(paramString2[0])) {
              paramString1 = paramString2[1];
            }
          }
          i++;
          paramValueCallback = paramString1;
        }
      }
      this.b = null;
      if (str2.startsWith("image/"))
      {
        paramValueCallback = new Intent("wifi.intent.action.PICKER_IMAGE");
        paramValueCallback.putExtra("select_mode", 0);
        paramValueCallback.putExtra("is_show_camera", true);
        ((Activity)this.d).startActivityForResult(paramValueCallback, 1000);
      }
      else if (str2.startsWith("video/"))
      {
        if (paramString1.equals("camcorder"))
        {
          a(b());
        }
        else
        {
          paramValueCallback = a(new Intent[] { b() });
          paramValueCallback.putExtra("android.intent.extra.INTENT", a(str2));
          a(paramValueCallback);
        }
      }
      else if (str2.startsWith("audio/"))
      {
        if (paramString1.equals("microphone"))
        {
          a(c());
        }
        else
        {
          paramValueCallback = a(new Intent[] { c() });
          paramValueCallback.putExtra("android.intent.extra.INTENT", a(str2));
          a(paramValueCallback);
        }
      }
      else
      {
        a(a());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */