package com.linksure.apservice.integration.photochoose.ui;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import bluefay.app.u;
import com.bluefay.a.e;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.integration.photochoose.BaseFragment;
import com.linksure.apservice.integration.photochoose.b.f;
import com.linksure.apservice.integration.photochoose.ui.a.b.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhotoPickerFragment
  extends BaseFragment
  implements b.a
{
  private static String k;
  boolean g = false;
  boolean h = false;
  AnimatorSet i = new AnimatorSet();
  AnimatorSet j = new AnimatorSet();
  private boolean l = false;
  private int m = 0;
  private int n;
  private boolean o = false;
  private View p;
  private GridView q;
  private Map<String, com.linksure.apservice.integration.photochoose.a.b> r;
  private List<com.linksure.apservice.integration.photochoose.a.a> s = new ArrayList();
  private ArrayList<String> t = new ArrayList();
  private com.linksure.apservice.integration.photochoose.ui.a.b u;
  private ListView v;
  private TextView w;
  private TextView x;
  private File y;
  
  private void f()
  {
    u localu = new u(this.e);
    a(a, localu);
  }
  
  private void g()
  {
    Object localObject;
    if ((this.m == 0) && (this.o))
    {
      localObject = new File((String)this.t.get(0));
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        localObject = Uri.fromFile((File)localObject);
        Uri localUri = h();
        new com.linksure.apservice.integration.photochoose.crop.a((Uri)localObject).a(localUri).a().a(this.e, this);
      }
    }
    for (;;)
    {
      return;
      localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra("picker_result", this.t);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
    }
  }
  
  private static Uri h()
  {
    Object localObject1 = com.linksure.apservice.integration.photochoose.b.a();
    localObject1 = new File(((com.linksure.apservice.integration.photochoose.b)localObject1).c() + File.separator + "WifiMasterKey" + File.separator + "temp" + File.separator + "crop_image.cache");
    File localFile = ((File)localObject1).getParentFile();
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    try
    {
      ((File)localObject1).createNewFile();
      localObject1 = Uri.fromFile((File)localObject1);
      return (Uri)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private void i()
  {
    if (this.g) {
      this.j.start();
    }
    for (this.g = false;; this.g = true)
    {
      return;
      this.i.start();
    }
  }
  
  public final void d()
  {
    Object localObject = this.u.b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i1 = ((List)localObject).size();
      localObject = new u(this.e);
      ((Menu)localObject).add(100, 1, 0, f.a(this.e, R.string.settings_photo_commit_num, new Object[] { Integer.valueOf(i1), Integer.valueOf(this.n) }));
      a(a, (Menu)localObject);
    }
    for (;;)
    {
      return;
      f();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1357) {
      if (paramInt2 == -1) {
        if (this.y != null)
        {
          this.t.add(this.y.getAbsolutePath());
          g();
        }
      }
    }
    for (;;)
    {
      return;
      if ((this.y != null) && (this.y.exists()))
      {
        this.y.delete();
        continue;
        if (paramInt1 == 6709) {
          if (paramInt2 == -1)
          {
            paramIntent = paramIntent.getExtras();
            if (paramIntent == null)
            {
              e.a("参数错误！");
              a();
            }
            else
            {
              paramIntent = (Uri)paramIntent.getParcelable("output");
              if (paramIntent == null)
              {
                e.a("响应参数错误！");
                a();
              }
              else
              {
                Object localObject = paramIntent.getPath();
                paramIntent = new ArrayList();
                paramIntent.add(localObject);
                localObject = new Intent();
                ((Intent)localObject).putStringArrayListExtra("picker_result", paramIntent);
                getActivity().setResult(-1, (Intent)localObject);
                getActivity().finish();
              }
            }
          }
          else
          {
            a();
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    k = getString(R.string.settings_photo_all_photo);
    this.p = paramLayoutInflater.inflate(R.layout.settings_photo_activity_photo_picker, null);
    paramLayoutInflater = getActivity().getIntent();
    this.l = paramLayoutInflater.getBooleanExtra("is_show_camera", false);
    this.m = paramLayoutInflater.getIntExtra("select_mode", 0);
    this.n = paramLayoutInflater.getIntExtra("max_num", 9);
    this.o = paramLayoutInflater.getBooleanExtra("is_crop", false);
    if (this.m == 1) {
      f();
    }
    paramLayoutInflater = this.p;
    this.q = ((GridView)paramLayoutInflater.findViewById(R.id.photo_gridview));
    this.w = ((TextView)paramLayoutInflater.findViewById(R.id.photo_num));
    this.x = ((TextView)paramLayoutInflater.findViewById(R.id.floder_name));
    a(R.string.settings_photo_choose_photo);
    if (!com.bluefay.b.b.e(com.linksure.apservice.integration.photochoose.b.a().c())) {
      e.a(R.string.settings_photo_no_sdcard);
    }
    for (paramLayoutInflater = this.p;; paramLayoutInflater = this.p)
    {
      return paramLayoutInflater;
      new a((byte)0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 1)
    {
      this.t.addAll(this.u.b());
      g();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  private final class a
    extends AsyncTask<Void, Void, Void>
  {
    private a() {}
    
    protected final void onPreExecute()
    {
      PhotoPickerFragment.a(PhotoPickerFragment.this, PhotoPickerFragment.this.getString(R.string.settings_photo_loading_photos));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/ui/PhotoPickerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */