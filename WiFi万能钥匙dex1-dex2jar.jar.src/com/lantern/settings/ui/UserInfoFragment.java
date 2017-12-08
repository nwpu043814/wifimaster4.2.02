package com.lantern.settings.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import bluefay.preference.Preference;
import bluefay.preference.PreferenceScreen;
import bluefay.preference.ValuePreference;
import com.bluefay.b.b;
import com.bluefay.b.j;
import com.bluefay.preference.PSPreferenceFragment;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.photochoose.ui.PhotoPickerActivity;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import com.lantern.settings.R.xml;
import com.lantern.settings.a.d;
import com.lantern.settings.a.g;
import com.lantern.settings.widget.UserInfoHeaderPreference;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class UserInfoFragment
  extends PSPreferenceFragment
{
  private UserInfoHeaderPreference j;
  private ValuePreference k;
  private ValuePreference l;
  private ValuePreference m;
  private Dialog n;
  private String o;
  private Boolean p;
  private Handler q;
  private com.lantern.settings.a.h r;
  private g s;
  private com.lantern.auth.utils.f t;
  private Dialog u;
  private int v;
  private com.bluefay.b.a w = new bj(this);
  private com.bluefay.b.a x = new bk(this);
  
  private Dialog a(String paramString)
  {
    com.bluefay.material.f localf = new com.bluefay.material.f(getActivity());
    localf.setCanceledOnTouchOutside(false);
    localf.a(paramString);
    localf.show();
    return localf;
  }
  
  private void a(boolean paramBoolean)
  {
    String str = p.e(this.e);
    if ((j.a(str)) && (!str.equals(this.o))) {
      com.lantern.settings.b.a.a(this.q, str, paramBoolean, new bi(this, str));
    }
  }
  
  private void f()
  {
    if ((TextUtils.isEmpty(com.lantern.settings.b.f.a().b())) || (!b.e(com.lantern.settings.b.f.a().b()))) {
      com.bluefay.a.e.a(R.string.settings_photo_no_sdcard);
    }
    for (;;)
    {
      return;
      Object localObject = new StatFs(new File(com.lantern.settings.b.f.a().b()).getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      if (((StatFs)localObject).getAvailableBlocks() * l1 >= 1048576L) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label98;
        }
        com.bluefay.a.e.a(R.string.settings_user_info_change_avatar_tip);
        break;
      }
      label98:
      localObject = new Intent(this.e, PhotoPickerActivity.class);
      ((Intent)localObject).putExtra("is_show_camera", true);
      ((Intent)localObject).putExtra("select_mode", 0);
      ((Intent)localObject).putExtra("is_crop", true);
      startActivityForResult((Intent)localObject, 1001);
    }
  }
  
  public final boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    boolean bool;
    if (!com.bluefay.a.e.c(this.e))
    {
      com.bluefay.a.e.a(R.string.auth_failed_no_network);
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (paramPreference == this.j)
      {
        f();
        bool = true;
      }
      else
      {
        if (paramPreference == this.m)
        {
          Button localButton;
          if (this.n == null)
          {
            paramPreferenceScreen = LayoutInflater.from(this.e).inflate(R.layout.settings_dialog_user_gender_choice, null);
            paramPreference = (Button)paramPreferenceScreen.findViewById(R.id.userGenderMale);
            localButton = (Button)paramPreferenceScreen.findViewById(R.id.userGenderFemale);
            if (this.p != null)
            {
              if (this.p.booleanValue())
              {
                paramPreference.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.settings_ic_checked, 0);
                localButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
            else
            {
              label126:
              bl localbl = new bl(this, paramPreference, localButton);
              paramPreference.setOnClickListener(localbl);
              localButton.setOnClickListener(localbl);
              paramPreference = new AlertDialog.Builder(this.e);
              paramPreference.setView(paramPreferenceScreen);
              this.n = paramPreference.show();
            }
          }
          for (;;)
          {
            bool = true;
            break;
            localButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.settings_ic_checked, 0);
            paramPreference.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            break label126;
            if (!this.n.isShowing()) {
              this.n.show();
            }
          }
        }
        if (paramPreference == this.l)
        {
          paramPreferenceScreen = new Intent(getActivity(), UserInfoEditActivity.class);
          paramPreferenceScreen.putExtra("INTNET_KEY_EDIT_FRAGMENT_NAME", EditUserNameFragment.class.getName());
          paramPreferenceScreen.putExtra("INTENT_KEY_USER_NAME", this.l.b());
          paramPreferenceScreen.putExtra("from", this.v);
          startActivityForResult(paramPreferenceScreen, 1000);
          bool = true;
        }
        else
        {
          bool = super.a(paramPreferenceScreen, paramPreference);
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      Object localObject1 = paramIntent.getStringExtra("INTENT_KEY_USER_NAME");
      if ((com.lantern.settings.b.e.a((CharSequence)localObject1)) && (!((String)localObject1).equals(this.l.b())))
      {
        this.l.a((String)localObject1);
        continue;
        try
        {
          localObject1 = (ArrayList)paramIntent.getSerializableExtra("picker_result");
          if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
          {
            String str = (String)((ArrayList)localObject1).get(0);
            if ((!TextUtils.isEmpty(str)) && (b.e(str)))
            {
              localObject1 = a(getString(R.string.settings_uploading_avatar));
              Object localObject2 = new com/lantern/settings/ui/bm;
              ((bm)localObject2).<init>(this);
              ((Dialog)localObject1).setOnDismissListener((DialogInterface.OnDismissListener)localObject2);
              localObject2 = new com/lantern/settings/ui/bn;
              ((bn)localObject2).<init>(this, str, (Dialog)localObject1);
              localObject1 = c.getServer().s();
              ((HashMap)localObject1).put("token", p.f(c.getInstance()));
              this.t = com.lantern.auth.utils.f.a(c.getServer().b("05000501", (HashMap)localObject1), (com.bluefay.b.a)localObject2, com.lantern.auth.h.d());
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d(R.xml.settings_user_info);
    a(R.string.settings_user_info_profile);
    this.q = new Handler();
    this.v = ((Activity)this.e).getIntent().getIntExtra("from", 0);
    this.j = ((UserInfoHeaderPreference)b("user_info_avatar"));
    this.k = ((ValuePreference)b("user_info_mobile"));
    this.l = ((ValuePreference)b("user_info_nickname"));
    this.m = ((ValuePreference)b("user_info_gender"));
    this.j.a(new bh(this));
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = p.c(this.e);
    if (((String)localObject).length() > 0) {
      this.k.a(com.lantern.settings.b.e.b((String)localObject));
    }
    localObject = p.d(this.e);
    if (com.lantern.settings.b.e.a((CharSequence)localObject)) {
      this.l.a((String)localObject);
    }
    localObject = p.a(this.e, "sdk_device", "gender", null);
    if (com.lantern.settings.b.e.a((CharSequence)localObject))
    {
      this.p = Boolean.valueOf("M".equals(localObject));
      localObject = this.m;
      if (!this.p.booleanValue()) {
        break label138;
      }
    }
    label138:
    for (int i = R.string.settings_user_info_gender_male;; i = R.string.settings_user_info_gender_female)
    {
      ((ValuePreference)localObject).a(i);
      a(true);
      new d(this.w).execute(new Void[0]);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/UserInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */