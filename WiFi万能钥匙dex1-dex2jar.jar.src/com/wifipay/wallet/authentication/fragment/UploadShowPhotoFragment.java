package com.wifipay.wallet.authentication.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.framework.widget.WPTwoTextView;
import com.wifipay.framework.widget.wheel.OnWheelScrollListener;
import com.wifipay.framework.widget.wheel.WPWheelView;
import com.wifipay.wallet.authentication.a;
import com.wifipay.wallet.authentication.activity.UploadResultActivity;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.prod.user.UploadResp;
import com.wifipay.wallet.prod.user.UploadResp.ResultObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UploadShowPhotoFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private WPTwoTextView a;
  private WPTwoTextView b;
  private Button c;
  private String d;
  private Bitmap e;
  private Bitmap f;
  private int g = 1987;
  private int h = 84;
  private int i;
  private WPWheelView j;
  private WPWheelView k;
  private WPWheelView l;
  private PopupWindow m;
  private OnWheelScrollListener n = new f(this);
  
  private View a(int paramInt)
  {
    Object localObject = Calendar.getInstance();
    this.i = (((Calendar)localObject).get(1) + this.h);
    int i2 = ((Calendar)localObject).get(1);
    int i3 = ((Calendar)localObject).get(2) + 1;
    int i1 = ((Calendar)localObject).get(5);
    localObject = ((LayoutInflater)c().getSystemService("layout_inflater")).inflate(R.layout.wifipay_layout_pop_datapick, null);
    this.j = ((WPWheelView)((View)localObject).findViewById(R.id.wifipay_year));
    c(i2);
    this.j.a(this.n);
    this.k = ((WPWheelView)((View)localObject).findViewById(R.id.wifipay_month));
    h();
    this.k.a(this.n);
    this.l = ((WPWheelView)((View)localObject).findViewById(R.id.wifipay_day));
    a(i2, i3);
    this.l.a(this.n);
    this.j.setCurrentItem(i2 - this.g);
    this.k.setCurrentItem(i3 - 1);
    this.l.setCurrentItem(i1 - 1);
    this.j.setVisibleItems(7);
    this.k.setVisibleItems(7);
    this.l.setVisibleItems(7);
    ((Button)((View)localObject).findViewById(R.id.wifipay_set)).setOnClickListener(new d(this, paramInt));
    ((Button)((View)localObject).findViewById(R.id.wifipay_cancel)).setOnClickListener(new e(this));
    return (View)localObject;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1;
    switch (paramInt2)
    {
    case 4: 
    case 6: 
    case 9: 
    case 11: 
    default: 
      if (this.l.getCurrentItem() >= 30) {
        i1 = 1;
      }
      break;
    }
    for (;;)
    {
      a locala = new a(c(), 1, b(paramInt1, paramInt2), "%02d");
      locala.a(com.wifipay.common.a.f.a(R.string.wifipay_personal_day));
      this.l.setViewAdapter(locala);
      this.l.setCyclic(false);
      if (i1 != 0) {
        this.l.setCurrentItem(b(paramInt1, paramInt2) - 1);
      }
      return;
      if (this.l.getCurrentItem() >= 28)
      {
        i1 = 1;
        continue;
        i1 = 0;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  private void a(View paramView)
  {
    this.m = new PopupWindow(paramView, -1, -1, true);
    this.m.setFocusable(false);
    this.m.setTouchable(true);
    this.m.setOutsideTouchable(false);
    this.m.setBackgroundDrawable(new BitmapDrawable());
    this.m.showAtLocation(paramView, 80, 0, 0);
    this.m.setOnDismissListener(new c(this));
  }
  
  private void a(UploadResp paramUploadResp)
  {
    d();
    if (ResponseCode.SUCCESS.getCode().equals(paramUploadResp.resultCode))
    {
      Intent localIntent = new Intent(c(), UploadResultActivity.class);
      localIntent.putExtra("mobile", paramUploadResp.resultObject.mobile);
      localIntent.putExtra("which_fragment", R.id.wifipay_fragment_success);
      c().startActivity(localIntent);
      c().finish();
      this.e.recycle();
      this.f.recycle();
    }
    for (;;)
    {
      return;
      a(paramUploadResp.resultMessage);
    }
  }
  
  private byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int i2 = 1;
    int i1;
    switch (paramInt1 % 4)
    {
    default: 
      i1 = 0;
      switch (paramInt2)
      {
      case 4: 
      case 6: 
      case 9: 
      case 11: 
      default: 
        if (this.j.getCurrentItem() + this.g == this.i) {
          paramInt1 = i2;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      return paramInt1;
      i1 = 1;
      break;
      paramInt1 = i2;
      if (this.j.getCurrentItem() + this.g != this.i)
      {
        paramInt1 = 31;
        continue;
        paramInt1 = i2;
        if (this.j.getCurrentItem() + this.g != this.i) {
          if (i1 != 0)
          {
            paramInt1 = 29;
          }
          else
          {
            paramInt1 = 28;
            continue;
            paramInt1 = 30;
          }
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.j.getCurrentItem() + this.g);
    Object localObject;
    if (this.k.getCurrentItem() + 1 < 10)
    {
      localObject = "0" + (this.k.getCurrentItem() + 1);
      localStringBuilder = localStringBuilder.append(localObject);
      if (this.l.getCurrentItem() + 1 >= 10) {
        break label173;
      }
      localObject = "0" + (this.l.getCurrentItem() + 1);
      label109:
      localObject = localObject;
      if (this.j.getCurrentItem() + this.g >= this.i) {
        break label200;
      }
      if (paramInt != 0) {
        break label189;
      }
      this.a.setText((CharSequence)localObject);
    }
    for (;;)
    {
      this.m.dismiss();
      return;
      localObject = Integer.valueOf(this.k.getCurrentItem() + 1);
      break;
      label173:
      localObject = Integer.valueOf(this.l.getCurrentItem() + 1);
      break label109;
      label189:
      this.b.setText((CharSequence)localObject);
      continue;
      label200:
      if (paramInt == 0) {
        this.a.setText(com.wifipay.common.a.f.a(R.string.wifipay_personal_long_term));
      } else {
        this.b.setText(com.wifipay.common.a.f.a(R.string.wifipay_personal_long_term));
      }
    }
  }
  
  public static Bitmap c(String paramString)
  {
    Bitmap localBitmap = null;
    if (new File(paramString).exists()) {
      localBitmap = BitmapFactory.decodeFile(paramString);
    }
    return localBitmap;
  }
  
  private void c(int paramInt)
  {
    a locala = new a(c(), this.g, this.i, "%02d");
    locala.a(com.wifipay.common.a.f.a(R.string.wifipay_personal_year));
    this.j.setViewAdapter(locala);
    this.j.setCyclic(false);
  }
  
  private boolean d(String paramString)
  {
    paramString = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length()).toLowerCase();
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("png")) || (paramString.equals("jpeg")) || (paramString.equals("bmp"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private List<String> e()
  {
    ArrayList localArrayList = new ArrayList();
    for (File localFile : new File(this.d).listFiles()) {
      if (d(localFile.getPath())) {
        localArrayList.add(localFile.getPath());
      }
    }
    return localArrayList;
  }
  
  private void f()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("path"))) {
      this.d = localBundle.getString("path");
    }
  }
  
  private void g()
  {
    if ((!g.a(this.a.getText(), getString(R.string.wifipay_personal_long_term))) && (!g.a(this.b.getText(), getString(R.string.wifipay_personal_long_term))) && (com.wifipay.wallet.common.utils.d.a(this.a.getText(), this.b.getText()) > 0)) {
      a(getString(R.string.wifipay_check_idcard_isvalid));
    }
    for (;;)
    {
      return;
      b("");
      BackgroundExecutor.a(new b(this));
    }
  }
  
  private void h()
  {
    a locala = new a(c(), 1, 12, "%02d");
    locala.a(com.wifipay.common.a.f.a(R.string.wifipay_personal_month));
    this.k.setViewAdapter(locala);
    this.k.setCyclic(false);
  }
  
  public void onClick(View paramView)
  {
    if ((g.a(this.a.getText())) && (g.a(this.b.getText())))
    {
      this.c.setEnabled(false);
      if (paramView.getId() != R.id.wifipay_btn_commit) {
        break label60;
      }
      g();
    }
    for (;;)
    {
      return;
      this.c.setEnabled(true);
      break;
      label60:
      if (paramView.getId() == R.id.wifipay_identity_expiry_date) {
        a(a(1));
      } else if (paramView.getId() == R.id.wifipay_identity_start_date) {
        a(a(0));
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    f();
    return paramLayoutInflater.inflate(R.layout.wifipay_fragment_show_photo, null);
  }
  
  public void onDestroy()
  {
    System.gc();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.c = ((Button)paramView.findViewById(R.id.wifipay_btn_commit));
    paramBundle = (ImageView)paramView.findViewById(R.id.wifipay_show_photo_front);
    this.b = ((WPTwoTextView)paramView.findViewById(R.id.wifipay_identity_expiry_date));
    this.a = ((WPTwoTextView)paramView.findViewById(R.id.wifipay_identity_start_date));
    ImageView localImageView = (ImageView)paramView.findViewById(R.id.wifipay_show_photo_opposite);
    this.c.setEnabled(false);
    this.c.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramView = e();
    if ((paramView != null) && (paramView.size() > 0)) {}
    try
    {
      this.e = c((String)paramView.get(0));
      this.f = c((String)paramView.get(1));
      paramBundle.setImageBitmap(this.e);
      localImageView.setImageBitmap(this.f);
      paramView = new com.wifipay.framework.api.b();
      paramView.a(this.a.getTextView());
      paramView.a(this.b.getTextView());
      paramView.a(this.c);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/fragment/UploadShowPhotoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */