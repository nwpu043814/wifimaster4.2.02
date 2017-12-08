package com.linksure.apservice.ui.profile.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.k.a;
import bluefay.app.u;
import bluefay.support.annotation.Nullable;
import com.bluefay.material.f;
import com.lantern.core.c;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.a.i;
import com.linksure.apservice.ui.apslist.ApsListActivity;
import com.linksure.apservice.ui.common.interceptor.InterceptorFragment;
import com.linksure.apservice.ui.home.ApServiceActivity;
import com.linksure.apservice.ui.profile.ProfileActivity;
import com.linksure.apservice.ui.profile.widget.BottomDialog;
import com.linksure.apservice.ui.profile.widget.PhotoDialog;
import java.util.Iterator;
import java.util.List;

public class ProfileFragment
  extends InterceptorFragment
  implements View.OnClickListener, a.b
{
  private static final int[] u = { 128202 };
  private ImageView g;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private CheckBox n;
  private CheckBox o;
  private View p;
  private Dialog q;
  private a.a r;
  private com.linksure.apservice.b.a s;
  private Button t;
  private com.bluefay.d.b v = new g(this, u);
  
  private void a(TextView paramTextView, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramTextView.setVisibility(8);
      this.p.findViewById(paramInt).setVisibility(8);
    }
    for (;;)
    {
      return;
      paramTextView.setText(String.valueOf(paramString));
    }
  }
  
  public final Dialog a(String paramString)
  {
    f localf = new f(this.e);
    localf.a(paramString);
    localf.setCancelable(true);
    return localf;
  }
  
  public final void a(com.linksure.apservice.b.a parama)
  {
    a(String.valueOf(parama.l));
    com.linksure.apservice.utils.e.a(this.g, parama.n, R.drawable.aps_dft_logo);
    this.i.setText(String.valueOf(parama.l));
    a(this.j, parama.o, R.id.ll_profile_desc);
    a(this.k, parama.r, R.id.ll_profile_company);
    a(this.l, parama.p, R.id.ll_profile_phone);
    a(this.m, parama.q, R.id.ll_type_scope);
    this.n.setChecked(parama.h);
    this.o.setChecked(parama.i);
    if (!this.s.e)
    {
      this.p.findViewById(R.id.aps_setting_group).setVisibility(8);
      this.t.setText(R.string.aps_profile_follow);
      if (this.l.getVisibility() == 8)
      {
        if (this.k.getVisibility() != 8) {
          break label223;
        }
        this.p.findViewById(R.id.line_desc).setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      this.t.setText(R.string.aps_profile_goto_home);
      this.p.findViewById(R.id.aps_setting_group).setVisibility(0);
      break;
      label223:
      this.p.findViewById(R.id.line_company).setVisibility(8);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = ((ProfileActivity)getActivity()).f();
    if ("home".equals(localObject)) {
      getActivity().finish();
    }
    for (;;)
    {
      return;
      if ("router".equals(localObject))
      {
        paramString2 = new Intent(getActivity(), ApServiceActivity.class);
        paramString2.putExtra("aps_id", paramString1);
        startActivity(paramString2);
      }
      else
      {
        localObject = new Intent(getActivity(), ApServiceActivity.class);
        ((Intent)localObject).putExtra("aps_id", paramString1);
        startActivity((Intent)localObject);
        getActivity().finish();
        if ("0".equals(paramString2)) {
          com.bluefay.a.e.a(R.string.aps_follow_success);
        } else if ("3001".equals(paramString2)) {
          com.bluefay.b.h.a("已关注", new Object[0]);
        } else {
          com.bluefay.a.e.a(R.string.aps_follow_fail2);
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.n.setChecked(paramBoolean);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.q != null) && (this.q.isShowing()))
    {
      this.q.hide();
      this.q.dismiss();
    }
    if (paramBoolean1) {
      if (!paramBoolean2) {
        break label62;
      }
    }
    label62:
    for (this.q = a(getString(R.string.aps_following));; this.q = a(getString(R.string.aps_unfollowing)))
    {
      this.q.show();
      return;
    }
  }
  
  public final void b(String paramString)
  {
    Toast.makeText(getActivity(), paramString, 0).show();
  }
  
  public final void b(boolean paramBoolean)
  {
    this.o.setChecked(paramBoolean);
  }
  
  public final void g()
  {
    if ("search".equals(((ProfileActivity)getActivity()).f())) {
      getActivity().finish();
    }
    for (;;)
    {
      return;
      Object localObject = com.linksure.apservice.utils.a.b();
      try
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Activity)((Iterator)localObject).next()).finish();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a();
        getActivity().finishActivity(100);
        ProfileActivity.e = true;
        Intent localIntent = new Intent(getActivity(), ApsListActivity.class);
        localIntent.setFlags(67108864);
        startActivity(localIntent);
      }
    }
  }
  
  public final void g_(int paramInt)
  {
    Toast.makeText(getActivity(), paramInt, 0).show();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.aps_profile_tel)
    {
      paramView = new k.a(this.e);
      View localView = LayoutInflater.from(this.e).inflate(R.layout.aps_pushmsg_dialog, null, false);
      ((TextView)localView.findViewById(R.id.tv_alert)).setText(this.l.getText().toString());
      paramView.a(localView);
      paramView.a(17039370, new h(this));
      paramView.b(17039360, null);
      paramView.d();
      if (i1 != R.id.aps_setting_push) {
        break label328;
      }
      this.r.a(this.n.isChecked());
    }
    for (;;)
    {
      return;
      if (i1 == R.id.aps_history)
      {
        paramView = new StringBuilder();
        paramView.append("https://static.51y5.net/wifiservice/mobile/history/history.html?serviceAccountId=").append(String.valueOf(this.s.k));
        paramView = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramView.toString()));
        paramView.setPackage(getActivity().getPackageName());
        com.bluefay.a.e.a(getActivity(), paramView);
        break;
      }
      if (i1 == R.id.aps_profile_goto_home)
      {
        if (this.s.e)
        {
          a(this.s.k, "3001");
          com.linksure.apservice.utils.b.a("saifencli", this.s.k);
          break;
        }
        this.r.e();
        break;
      }
      if (i1 == R.id.aps_complaints)
      {
        ((ProfileActivity)getActivity()).c(this.s);
        com.linksure.apservice.utils.b.b(this.s.k);
        break;
      }
      if (i1 != R.id.aps_profile_logo) {
        break;
      }
      PhotoDialog.a().a(this.s.n).show(getFragmentManager(), "PhotoDialog");
      break;
      label328:
      if (i1 == R.id.aps_setting_top_check) {
        this.r.b(this.o.isChecked());
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c.addListener(this.v);
    paramBundle = new b(this, i.d(getActivity()), i.a(getActivity()), i.c(getActivity()));
    this.s = ((com.linksure.apservice.b.a)getArguments().getSerializable("aps"));
    super.a(paramBundle);
    this.r = paramBundle;
    paramBundle.b(this.s);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (this.p != null)
    {
      paramLayoutInflater = this.p;
      return paramLayoutInflater;
    }
    this.p = paramLayoutInflater.inflate(R.layout.aps_fragment_profile, paramViewGroup, false);
    this.g = ((ImageView)this.p.findViewById(R.id.aps_profile_logo));
    this.i = ((TextView)this.p.findViewById(R.id.aps_profile_name));
    this.j = ((TextView)this.p.findViewById(R.id.aps_profile_desc));
    this.k = ((TextView)this.p.findViewById(R.id.aps_profile_company));
    this.l = ((TextView)this.p.findViewById(R.id.aps_profile_tel));
    this.m = ((TextView)this.p.findViewById(R.id.aps_type_scope));
    this.n = ((CheckBox)this.p.findViewById(R.id.aps_setting_push));
    this.o = ((CheckBox)this.p.findViewById(R.id.aps_setting_top_check));
    this.p.findViewById(R.id.aps_history).setOnClickListener(this);
    this.p.findViewById(R.id.aps_complaints).setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.t = ((Button)this.p.findViewById(R.id.aps_profile_goto_home));
    this.t.setOnClickListener(this);
    if (!this.s.g) {
      this.p.findViewById(R.id.aps_page_violcation).setVisibility(4);
    }
    for (;;)
    {
      paramLayoutInflater = this.p;
      break;
      this.p.findViewById(R.id.aps_profile_detail).setVisibility(4);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c.removeListener(this.v);
    if ((this.q != null) && (this.q.isShowing()))
    {
      this.q.hide();
      this.q.dismiss();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 1002) {
      BottomDialog.a().a(this.e, this.r, this.s).show(getFragmentManager(), "BottomDialog");
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.r.b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.r.a();
    if (this.s.e)
    {
      u localu = new u(getActivity());
      localu.add(101, 1002, 0, "Setting").setIcon(R.drawable.aps_more_connect);
      a(a, localu);
      if (this.s.e) {
        break label114;
      }
      com.linksure.apservice.utils.b.a("saifnsh", this.s.k);
    }
    for (;;)
    {
      return;
      a(a, new u(getActivity()));
      break;
      label114:
      com.linksure.apservice.utils.b.a("saifsh", this.s.k);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/detail/ProfileFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */