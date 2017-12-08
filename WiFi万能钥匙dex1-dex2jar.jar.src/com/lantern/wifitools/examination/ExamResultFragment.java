package com.lantern.wifitools.examination;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bluefay.app.Fragment;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.core.config.WifiExamConf;
import com.lantern.wifiseccheck.protocol.ApMarkResult;
import com.lantern.wifiseccheck.protocol.ApMarkerResultDescription;
import com.lantern.wifiseccheck.protocol.ApMarkerResultDescription.Reason;
import com.lantern.wifiseccheck.protocol.ApMarkerResultDescription.ReasonType;
import com.lantern.wifiseccheck.protocol.ApNeighbourRes;
import com.lantern.wifitools.R.anim;
import com.lantern.wifitools.R.color;
import com.lantern.wifitools.R.drawable;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.string;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExamResultFragment
  extends Fragment
{
  private Bundle g;
  private RelativeLayout h;
  private TextView i;
  private TextView j;
  private boolean k = false;
  
  private static void b(RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout)
  {
    View localView = paramRelativeLayout.findViewById(R.id.result_view);
    paramRelativeLayout.removeView(localView);
    paramLinearLayout.addView(localView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.g = getArguments();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    b(getResources().getColor(R.color.white));
    b().a(null);
    if (this.h != null)
    {
      paramLayoutInflater = (ViewGroup)this.h.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.h);
      }
      this.h.findViewById(R.id.anim_view).setVisibility(8);
      m = this.g.getInt("security", -1);
      com.bluefay.b.h.a("securityLevel=" + m, new Object[0]);
      this.j.setText(String.format(getString(R.string.exam_result_device), new Object[] { Integer.valueOf(this.g.getInt("neighbors")) }));
      return this.h;
    }
    this.h = ((RelativeLayout)paramLayoutInflater.inflate(R.layout.wifitools_exam_result, paramViewGroup, false));
    Object localObject1 = (LinearLayout)this.h.findViewById(R.id.result_bg);
    Object localObject6 = this.h.findViewById(R.id.detail_container);
    Object localObject4 = this.h.findViewById(R.id.offline);
    paramBundle = (LinearLayout)this.h.findViewById(R.id.anim_view);
    Object localObject2 = (RelativeLayout)this.h.findViewById(R.id.result_parent);
    Object localObject3 = (TextView)this.h.findViewById(R.id.exam_result_title);
    this.i = ((TextView)this.h.findViewById(R.id.exam_result_tip));
    Object localObject5 = (ImageView)this.h.findViewById(R.id.exam_result_icon);
    this.j = ((TextView)this.h.findViewById(R.id.device_text));
    int m = this.g.getInt("status", 0);
    int n;
    if (m == 1)
    {
      ((View)localObject6).setVisibility(0);
      ((View)localObject4).setVisibility(8);
      n = this.g.getInt("security", -1);
      if (n == 0)
      {
        ((TextView)localObject3).setText(getString(R.string.exam_result_title_security_none));
        this.i.setText(getString(R.string.exam_resulttip_risk));
        c(R.color.exam_yellow);
        b().a(getResources().getColor(R.color.actionbar_divider));
        ((LinearLayout)localObject1).setBackgroundColor(getResources().getColor(R.color.exam_yellow));
        paramBundle.setBackgroundColor(getResources().getColor(R.color.exam_yellow));
        ((ImageView)localObject5).setImageResource(R.drawable.wifi_unusual);
        ((TextView)this.h.findViewById(R.id.talk)).setText(this.e.getString(R.string.exam_result_talk));
        this.h.findViewById(R.id.find_devices).setOnClickListener(new b(this));
        this.k = this.g.getBoolean("showInsurance");
        if (this.k)
        {
          this.h.findViewById(R.id.speed_view).setVisibility(0);
          this.h.findViewById(R.id.retest).setOnClickListener(new c(this));
        }
        this.h.findViewById(R.id.open_network).setOnClickListener(new d(this));
        this.j.setText(String.format(getString(R.string.exam_result_device), new Object[] { Integer.valueOf(this.g.getInt("neighbors")) }));
        localObject3 = (LinearLayout)this.h.findViewById(R.id.item_container);
        localObject4 = ((ExaminationActivity)getActivity()).f().getDescription().getReasons();
        m = 0;
        localObject5 = ((List)localObject4).iterator();
      }
    }
    label632:
    label690:
    label944:
    label982:
    label1590:
    label1825:
    for (;;)
    {
      View localView;
      if (((Iterator)localObject5).hasNext())
      {
        m++;
        if (getString(R.string.wifi_can_not_reach_server).equals(((ApMarkerResultDescription.Reason)((Iterator)localObject5).next()).getReason())) {
          ((Iterator)localObject5).remove();
        }
      }
      else
      {
        m = 0;
        localObject6 = ((List)localObject4).iterator();
        if (!((Iterator)localObject6).hasNext()) {
          break label982;
        }
        ApMarkerResultDescription.Reason localReason = (ApMarkerResultDescription.Reason)((Iterator)localObject6).next();
        localView = paramLayoutInflater.inflate(R.layout.wifitools_exam_item, (ViewGroup)localObject3, false);
        ((TextView)localView.findViewById(R.id.check_item)).setText(localReason.getReason());
        localObject4 = (TextView)localView.findViewById(R.id.type_text);
        localObject5 = (ImageView)localView.findViewById(R.id.type_icon);
        if (ApMarkerResultDescription.ReasonType.WARNING != localReason.getType()) {
          break label944;
        }
        ((TextView)localObject4).setTextColor(getResources().getColor(R.color.exam_yellow));
        ((TextView)localObject4).setText(getString(R.string.exam_result_safe_type_unusual));
        ((ImageView)localObject5).setImageResource(R.drawable.safecheck_unusual);
        m++;
      }
      for (;;)
      {
        ((LinearLayout)localObject3).addView(localView);
        break label690;
        ((TextView)localObject3).setText(getString(R.string.exam_result_title_normal));
        this.i.setText(getString(R.string.exam_resulttip_safe));
        c(R.color.exam_blue);
        ((LinearLayout)localObject1).setBackgroundColor(getResources().getColor(R.color.exam_blue));
        paramBundle.setBackgroundColor(getResources().getColor(R.color.exam_blue));
        ((ImageView)localObject5).setImageResource(R.drawable.wifi_normal);
        ((TextView)this.h.findViewById(R.id.talk)).setText(this.e.getString(R.string.exam_insurance_safe));
        break;
        if (m <= 6) {
          break label1825;
        }
        ((Iterator)localObject5).remove();
        break label632;
        ((TextView)localObject4).setTextColor(getResources().getColor(R.color.exam_gray));
        ((TextView)localObject4).setText(getString(R.string.exam_result_safe_type_nomarl));
        ((ImageView)localObject5).setImageResource(R.drawable.safecheck_normal);
      }
      if ((((WifiExamConf)com.lantern.core.config.d.a(this.e).a(WifiExamConf.class)).d() == 1) && (m > 0) && (Build.VERSION.SDK_INT >= 16))
      {
        this.h.findViewById(R.id.open_viewbar).setVisibility(0);
        paramLayoutInflater = (Button)this.h.findViewById(R.id.open_protect);
        paramLayoutInflater.setVisibility(0);
        paramLayoutInflater.setOnClickListener(new e(this, n));
      }
      paramLayoutInflater = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 0, ((int)TypedValue.applyDimension(1, 159.0F, getResources().getDisplayMetrics()) - paramViewGroup.getHeight()) / 2);
      paramLayoutInflater.setFillAfter(false);
      paramLayoutInflater.setDuration(410L);
      paramLayoutInflater.setAnimationListener(new i(this, paramBundle, (RelativeLayout)localObject2, (LinearLayout)localObject1));
      ((RelativeLayout)localObject2).startAnimation(paramLayoutInflater);
      paramBundle.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.scale_up_and_fade_out));
      paramViewGroup = this.h.findViewById(R.id.speed_view);
      paramLayoutInflater = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, getActivity().getWindow().getDecorView().getHeight(), 1, 0.0F);
      paramLayoutInflater.setDuration(400L);
      paramViewGroup.startAnimation(paramLayoutInflater);
      paramLayoutInflater = this.h.findViewById(R.id.device_view);
      paramViewGroup = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, getActivity().getWindow().getDecorView().getHeight(), 1, 0.0F);
      paramViewGroup.setDuration(400L);
      paramViewGroup.setStartOffset(300L);
      paramLayoutInflater.startAnimation(paramViewGroup);
      paramViewGroup = this.h.findViewById(R.id.safe_view);
      paramLayoutInflater = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, getActivity().getWindow().getDecorView().getHeight(), 1, 0.0F);
      paramLayoutInflater.setDuration(400L);
      paramLayoutInflater.setStartOffset(600L);
      paramViewGroup.startAnimation(paramLayoutInflater);
      paramLayoutInflater = this.h.findViewById(R.id.container);
      paramViewGroup = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, getActivity().getWindow().getDecorView().getHeight(), 1, 0.0F);
      paramViewGroup.setDuration(1500L);
      paramLayoutInflater.startAnimation(paramViewGroup);
      paramBundle = ((ExaminationActivity)getActivity()).f().getNeighbourRes();
      paramLayoutInflater = "http://eval.swaqds.com:8080/" + paramBundle.getLogoRelativePath();
      paramViewGroup = (LinearLayout)this.h.findViewById(R.id.icon_view);
      m = (int)(24.0F * getResources().getDisplayMetrics().density + 0.5F);
      if ((paramBundle.getVendorLogo() == null) || (paramBundle.getVendorLogo().isEmpty())) {
        break;
      }
      localObject1 = paramBundle.getVendorLogo().entrySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1590;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        paramBundle = (ImageView)LayoutInflater.from(getActivity()).inflate(R.layout.wifitools_exam_icon, paramViewGroup, false);
        paramViewGroup.addView(paramBundle);
        if (paramViewGroup.getChildCount() >= 6)
        {
          com.lantern.core.imageloader.c.a(getActivity(), R.drawable.more_devices, paramBundle);
          break;
        }
        com.lantern.core.imageloader.c.a(getActivity(), paramLayoutInflater + (String)((Map.Entry)localObject2).getValue(), paramBundle, null, null, m, m);
      }
      break;
      b((RelativeLayout)localObject2, (LinearLayout)localObject1);
      ((View)localObject6).setVisibility(8);
      ((View)localObject4).setVisibility(0);
      c(R.color.exam_offline);
      b().a(getResources().getColor(R.color.actionbar_divider));
      ((LinearLayout)localObject1).setBackgroundColor(getResources().getColor(R.color.exam_offline));
      ((ImageView)localObject5).setImageResource(R.drawable.wifi_broken);
      paramLayoutInflater = (TextView)((View)localObject4).findViewById(R.id.auth);
      if (m == 0)
      {
        ((TextView)localObject3).setText(getString(R.string.exam_result_title_offline));
        this.i.setText(getString(R.string.exam_result_tip_offline));
        paramLayoutInflater.setText(getString(R.string.exam_result_change_network));
        paramLayoutInflater.setOnClickListener(new f(this));
        break;
      }
      if (m != 256) {
        break;
      }
      ((TextView)localObject3).setText(getString(R.string.exam_result_title_security_web));
      this.i.setText(getString(R.string.exam_result_tip_security_web));
      paramLayoutInflater.setText(getString(R.string.exam_result_auth));
      paramViewGroup = (TextView)this.h.findViewById(R.id.change_wifi);
      paramViewGroup.setText(getString(R.string.exam_result_change_network));
      paramViewGroup.setOnClickListener(new g(this));
      paramLayoutInflater.setOnClickListener(new h(this));
      break;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.g.getInt("status", 0) != 1) {
      c(R.color.exam_offline);
    }
    for (;;)
    {
      a(getString(R.string.exam_title));
      return;
      if (this.g.getInt("security", -1) == 0) {
        c(R.color.exam_yellow);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/ExamResultFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */