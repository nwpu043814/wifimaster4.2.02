package com.linksure.apservice.ui.common.preview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.Fragment;
import bluefay.support.annotation.Nullable;
import com.lantern.core.imageloader.a.aa;
import com.lantern.core.imageloader.a.ah;
import com.lantern.core.imageloader.a.an;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.a.f.f;
import com.linksure.apservice.a.i;
import com.linksure.apservice.ui.views.integration.ClipZoomImageView;
import com.linksure.apservice.utils.j;
import java.io.File;

public class PreviewFragment
  extends Fragment
  implements View.OnClickListener, a.b
{
  aa g;
  private ViewGroup h;
  private View i;
  private TextView j;
  private TextView k;
  private TextView l;
  private ImageView m;
  private boolean n;
  private a.a o;
  private int p;
  private int q;
  private an r = new b(this);
  
  private void a(Bitmap paramBitmap)
  {
    if (this.h.getChildCount() > 0) {
      this.h.removeAllViews();
    }
    ClipZoomImageView localClipZoomImageView = new ClipZoomImageView(getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.h.addView(localClipZoomImageView, localLayoutParams);
    localClipZoomImageView.setImageBitmap(paramBitmap);
    if (this.m != null) {
      this.m.setImageDrawable(null);
    }
    this.m = localClipZoomImageView;
  }
  
  private void d(int paramInt)
  {
    int i2 = 0;
    if (paramInt == 3)
    {
      this.i.setVisibility(4);
      return;
    }
    this.i.setVisibility(0);
    TextView localTextView = this.k;
    int i1;
    if (paramInt == 1)
    {
      i1 = 0;
      label37:
      localTextView.setVisibility(i1);
      localTextView = this.j;
      if (paramInt != 0) {
        break label88;
      }
      i1 = 0;
      label55:
      localTextView.setVisibility(i1);
      localTextView = this.l;
      if (paramInt != 2) {
        break label93;
      }
    }
    label88:
    label93:
    for (paramInt = i2;; paramInt = 4)
    {
      localTextView.setVisibility(paramInt);
      break;
      i1 = 4;
      break label37;
      i1 = 4;
      break label55;
    }
  }
  
  public final void a(long paramLong)
  {
    String str2 = getString(R.string.aps_download_hint);
    String str1 = str2;
    if (paramLong > 0L) {
      str1 = str2 + " " + f.c(paramLong);
    }
    this.j.setText(str1);
    d(0);
  }
  
  public final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.startsWith("http:")) {}
    for (ah localah = this.g.a(paramString);; localah = this.g.a(new File(paramString)))
    {
      localah.a(this.r);
      Log.e("--->", "show thumb:" + paramString);
      break;
    }
  }
  
  public final void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramString = com.linksure.apservice.a.f.c.a(paramString, this.q, this.p);
      if (paramString != null) {
        a(paramString);
      }
    }
  }
  
  public final void c()
  {
    d(3);
  }
  
  public final void c(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.fromFile(new File(paramString)));
    try
    {
      getActivity().sendBroadcast(localIntent);
      d_(R.string.aps_save_ok);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        d_(R.string.aps_save_fail);
      }
    }
  }
  
  public final void c_(int paramInt)
  {
    this.k.setText(getString(R.string.aps_progress_hint, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public final void d_(int paramInt)
  {
    Toast.makeText(getActivity(), paramInt, 0).show();
  }
  
  public final void n_()
  {
    d(1);
  }
  
  public final void o_()
  {
    d(2);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.aps_preview_progress) {
      this.o.e();
    }
    for (;;)
    {
      return;
      if (i1 == R.id.aps_preview_download) {
        this.o.d();
      } else if (i1 == R.id.aps_preview_save) {
        this.o.c();
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = aa.a(getActivity());
    this.p = j.b(getActivity());
    this.q = j.a(getActivity());
    this.o = new c(this, i.e(getActivity()));
    Object localObject = getArguments();
    paramBundle = ((Bundle)localObject).getString("preview image");
    localObject = ((Bundle)localObject).getString("origin image");
    this.o.a(paramBundle, (String)localObject);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.aps_fragment_zoom, null);
    this.h = ((ViewGroup)paramLayoutInflater.findViewById(R.id.aps_view_container));
    this.i = paramLayoutInflater.findViewById(R.id.aps_preview_bottom_button);
    this.j = ((TextView)paramLayoutInflater.findViewById(R.id.aps_preview_download));
    this.k = ((TextView)paramLayoutInflater.findViewById(R.id.aps_preview_progress));
    this.l = ((TextView)paramLayoutInflater.findViewById(R.id.aps_preview_save));
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.k.setOnClickListener(this);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.m != null) {
      this.m.setImageDrawable(null);
    }
    System.gc();
  }
  
  public void onPause()
  {
    super.onPause();
    this.n = false;
    this.o.b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.n = true;
    this.o.a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/preview/PreviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */