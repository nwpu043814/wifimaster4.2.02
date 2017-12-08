package com.linksure.apservice.integration.photochoose.ui;

import android.content.Intent;
import android.os.Bundle;
import bluefay.app.m;
import com.linksure.apservice.integration.photochoose.b.f;
import com.qihoo.util.StubApp1053578832;
import java.io.File;
import java.util.ArrayList;

public class PhotoPickerActivity
  extends m
{
  private String e;
  
  static
  {
    StubApp1053578832.interface11(71);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1357)
    {
      if ((paramInt2 != -1) || (!new File(this.e).exists())) {
        break label82;
      }
      paramIntent = this.e;
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramIntent);
      localIntent.putStringArrayListExtra("picker_result", localArrayList);
      setResult(-1, localIntent);
      finish();
    }
    for (;;)
    {
      return;
      label82:
      f.a(this.e);
      setResult(0);
      finish();
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("goto camera directly", getIntent().getBooleanExtra("goto camera directly", false));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/ui/PhotoPickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */