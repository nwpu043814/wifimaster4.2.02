package com.lantern.settings.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.lantern.settings.R.id;
import com.lantern.settings.diagnose.AutoScrollTextView;
import com.qihoo.util.StubApp1053578832;

public class UrlTestActivity
  extends Activity
{
  private static boolean b = false;
  ArrayAdapter<String> a;
  private AutoScrollTextView c;
  private Handler d = new Handler();
  private boolean e = false;
  private int f;
  private int g;
  private int h;
  private Button i;
  private EditText j;
  private Spinner k;
  
  static
  {
    StubApp1053578832.interface11(54);
  }
  
  public void beginTest(View paramView)
  {
    int m = 0;
    this.i = ((Button)paramView);
    this.i.setEnabled(false);
    b = true;
    paramView = ((EditText)findViewById(R.id.settings_diagnonse_urltest_editText0)).getText().toString();
    int i2 = Integer.parseInt(((EditText)findViewById(R.id.settings_diagnose_urltest_editText1)).getText().toString());
    int n = Integer.parseInt(((EditText)findViewById(R.id.settings_diagnose_urltest_editText2)).getText().toString());
    int i1 = Integer.parseInt(((EditText)findViewById(R.id.settings_diagnose_urltest_editText3)).getText().toString());
    this.f = 0;
    this.g = 0;
    this.h = i2;
    this.c.append("\n********************\n" + i2 + "," + n + "," + i1 + "\n" + paramView);
    new ba(this).start();
    while (m < i2)
    {
      new bd(this, m, paramView, n, i1).start();
      m++;
    }
  }
  
  public void clearMessage(View paramView)
  {
    this.c.setText("");
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    this.e = true;
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.e = false;
  }
  
  public void pauseTest(View paramView)
  {
    b = false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/UrlTestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */