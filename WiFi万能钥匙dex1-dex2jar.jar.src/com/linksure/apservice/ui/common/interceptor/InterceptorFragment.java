package com.linksure.apservice.ui.common.interceptor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import bluefay.app.Fragment;
import com.lantern.core.o;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;

public class InterceptorFragment
  extends Fragment
  implements a.b
{
  private Dialog g;
  a.a h;
  
  private void h()
  {
    if ((this.g != null) && (this.g.isShowing()))
    {
      this.g.hide();
      this.g.dismiss();
    }
  }
  
  public Dialog a(String paramString)
  {
    com.bluefay.material.f localf = new com.bluefay.material.f(this.e);
    localf.a(paramString);
    localf.setCancelable(false);
    return localf;
  }
  
  public final void a(a.a parama)
  {
    this.h = parama;
  }
  
  public final void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      Toast.makeText(getActivity(), getString(R.string.aps_follow_success), 0).show();
    }
    for (;;)
    {
      return;
      Toast.makeText(getActivity(), getString(R.string.aps_follow_fail, new Object[] { paramString }), 0).show();
    }
  }
  
  public final void c()
  {
    Log.e("--->", "show follow dialog!!");
    h();
    View localView = LayoutInflater.from(getActivity()).inflate(R.layout.aps_dialog_follow, null);
    AlertDialog localAlertDialog = new AlertDialog.Builder(getActivity()).setView(localView).create();
    localView.findViewById(R.id.aps_dialog_cancel).setOnClickListener(new d(this, localAlertDialog));
    localView.findViewById(R.id.aps_dialog_ok).setOnClickListener(new e(this, localAlertDialog));
    localAlertDialog.show();
    this.g = localAlertDialog;
  }
  
  public final void d()
  {
    h();
    Object localObject = getActivity();
    View localView = LayoutInflater.from((Context)localObject).inflate(R.layout.aps_dialog_token_expire, null);
    localObject = new AlertDialog.Builder((Context)localObject).setView(localView).create();
    localView.findViewById(R.id.aps_dialog_cancel).setOnClickListener(new f(this, (Dialog)localObject));
    localView.findViewById(R.id.aps_dialog_ok).setOnClickListener(new g(this, (Dialog)localObject));
    ((Dialog)localObject).setCancelable(false);
    ((Dialog)localObject).show();
    this.g = ((Dialog)localObject);
  }
  
  public final void e()
  {
    h();
    Dialog localDialog = a(getString(R.string.aps_following));
    localDialog.show();
    this.g = localDialog;
  }
  
  public final void f()
  {
    if ((this.g != null) && (this.g.isShowing()))
    {
      this.g.hide();
      this.g.dismiss();
    }
  }
  
  public final void j_()
  {
    Log.e("--->", "show login dialog!!");
    h();
    View localView = LayoutInflater.from(getActivity()).inflate(R.layout.aps_dialog_login, null);
    AlertDialog localAlertDialog = new AlertDialog.Builder(getActivity()).setView(localView).create();
    localView.findViewById(R.id.aps_dialog_cancel).setOnClickListener(new b(this, localAlertDialog));
    localView.findViewById(R.id.aps_dialog_ok).setOnClickListener(new c(this, localAlertDialog));
    localAlertDialog.show();
    this.g = localAlertDialog;
  }
  
  public void k_()
  {
    Toast.makeText(getActivity(), R.string.aps_black, 0).show();
  }
  
  public void onPause()
  {
    super.onPause();
    this.h.b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.h.a();
  }
  
  final void t_()
  {
    com.lantern.core.c.getServer().p();
    com.linksure.apservice.a.b.f.a(getActivity());
    Intent localIntent = new Intent("wifi.intent.action.ADD_ACCOUNT_MAIN");
    localIntent.setPackage(getActivity().getPackageName());
    localIntent.putExtra("OON", "2");
    com.bluefay.a.e.a(getActivity(), localIntent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/interceptor/InterceptorFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */