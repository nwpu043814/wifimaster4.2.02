package com.linksure.apservice.ui.home.keyboard;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import bluefay.support.annotation.Nullable;
import com.linksure.apservice.R.anim;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.a.i;
import com.linksure.apservice.b.h;
import com.linksure.apservice.integration.photochoose.ui.PhotoPickerActivity;
import com.linksure.apservice.ui.common.interceptor.InterceptorFragment;
import com.linksure.apservice.ui.home.ApServiceActivity;
import com.linksure.apservice.ui.views.integration.CircleIndicator;
import com.linksure.apservice.utils.f;
import com.linksure.apservice.utils.f.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardFragment
  extends InterceptorFragment
  implements View.OnClickListener, a.a, b.b, f.a
{
  private View.OnClickListener A;
  private int g = 0;
  private Map<Integer, f> i = new HashMap();
  private InputMethodManager j;
  private ViewFlipper k;
  private View l;
  private EditText m;
  private View n;
  private View o;
  private View p;
  private View q;
  private View r;
  private ViewPager s;
  private CircleIndicator t;
  private LinearLayout u;
  private b.a v;
  private View w;
  private boolean x;
  private String y;
  private com.linksure.apservice.ui.home.b.a z;
  
  public KeyboardFragment()
  {
    this.i.put(Integer.valueOf(0), new d());
    this.i.put(Integer.valueOf(1), new c());
    this.i.put(Integer.valueOf(2), new e());
    this.i.put(Integer.valueOf(3), new g());
    this.i.put(Integer.valueOf(4), new b());
    this.x = false;
    this.A = new d(this);
  }
  
  public static KeyboardFragment a(com.linksure.apservice.b.a parama)
  {
    KeyboardFragment localKeyboardFragment = new KeyboardFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key aps account", parama);
    if ((parama.a() != null) && (!parama.a().isEmpty())) {
      localBundle.putSerializable("key_dynamic_menu", new ArrayList(parama.a()));
    }
    localKeyboardFragment.setArguments(localBundle);
    return localKeyboardFragment;
  }
  
  private static boolean a(int paramInt1, int paramInt2, View paramView)
  {
    boolean bool = true;
    if ((paramView.getVisibility() == 8) || (paramView.getVisibility() == 4)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      int[] arrayOfInt = new int[2];
      int[] tmp33_31 = arrayOfInt;
      tmp33_31[0] = 0;
      int[] tmp37_33 = tmp33_31;
      tmp37_33[1] = 0;
      tmp37_33;
      paramView.getLocationInWindow(arrayOfInt);
      int i1 = arrayOfInt[0];
      int i3 = arrayOfInt[1];
      int i2 = paramView.getHeight();
      if (!new Rect(i1, i3, paramView.getWidth() + i1, i2 + i3).contains(paramInt1, paramInt2)) {
        bool = false;
      }
    }
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    EditText localEditText = this.m;
    return a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), localEditText);
  }
  
  private void d(int paramInt)
  {
    ((f)this.i.get(Integer.valueOf(paramInt))).a(this);
    if (paramInt == 4) {
      this.n.setBackgroundResource(R.drawable.aps_emoji_kb_switcher);
    }
    for (;;)
    {
      return;
      this.n.setBackgroundResource(R.drawable.aps_emoji_switcher);
    }
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    View localView = this.r;
    return a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), localView);
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    View localView = this.o;
    return a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), localView);
  }
  
  private boolean f(MotionEvent paramMotionEvent)
  {
    View localView = this.n;
    return a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), localView);
  }
  
  private void w()
  {
    if ((getActivity() instanceof ApServiceActivity)) {
      ((ApServiceActivity)getActivity()).f();
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    int i1;
    if (paramInt == 1)
    {
      i1 = Math.max(this.m.getSelectionStart(), 0);
      int i2 = Math.max(this.m.getSelectionEnd(), 0);
      this.m.getText().replace(Math.min(i1, i2), Math.max(i1, i2), paramString, 0, paramString.length());
    }
    if ((paramInt == 2) && ("delete".equals(paramString)))
    {
      i1 = Math.max(this.m.getSelectionStart(), 0);
      if (i1 > 0)
      {
        if (this.m.getText().charAt(i1 - 1) != ']') {
          break label185;
        }
        paramInt = i1 - 2;
        if (paramInt >= 0)
        {
          if ((this.m.getText().charAt(paramInt) != '[') || (!com.linksure.apservice.utils.c.b(this.m.getText().subSequence(paramInt, i1).toString()))) {
            break label179;
          }
          this.m.getText().delete(paramInt, i1);
        }
      }
    }
    for (;;)
    {
      return;
      label179:
      paramInt--;
      break;
      label185:
      this.m.getText().delete(i1 - 1, i1);
    }
  }
  
  public final void a(Object paramObject, List<h> paramList)
  {
    if ((this.z != null) && (this.z.isShowing())) {
      this.z.dismiss();
    }
    this.z = new com.linksure.apservice.ui.home.b.a(getActivity(), paramList);
    this.z.a(this.u.findViewWithTag(paramObject));
    this.z.a(this.A);
  }
  
  public final void a(List<h> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      this.u.removeAllViews();
      int i2 = paramList.size();
      for (int i1 = 0; i1 < i2; i1++)
      {
        h localh = (h)paramList.get(i1);
        View localView = LayoutInflater.from(getActivity()).inflate(R.layout.aps_menu_item, null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0F);
        localView.setTag(localh);
        localView.setOnClickListener(this);
        TextView localTextView = (TextView)localView.findViewById(R.id.aps_menu_item_txt);
        localTextView.setText(localh.c);
        if (localh.a().size() == 0) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        this.u.addView(localView, localLayoutParams);
      }
    }
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.l;
    boolean bool5 = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), localView);
    boolean bool2 = c(paramMotionEvent);
    boolean bool4 = d(paramMotionEvent);
    boolean bool3 = f(paramMotionEvent);
    boolean bool1 = e(paramMotionEvent);
    if ((bool5) || (bool4) || (bool3) || (bool1) || (bool2)) {}
    for (bool1 = false;; bool1 = true) {
      return bool1;
    }
  }
  
  public final boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    if ((paramView != null) && ((paramView instanceof EditText)))
    {
      int[] arrayOfInt = new int[2];
      int[] tmp21_19 = arrayOfInt;
      tmp21_19[0] = 0;
      int[] tmp25_21 = tmp21_19;
      tmp25_21[1] = 0;
      tmp25_21;
      paramView.getLocationInWindow(arrayOfInt);
      int i1 = arrayOfInt[0];
      int i2 = arrayOfInt[1];
      int i3 = paramView.getHeight();
      boolean bool5 = new Rect(i1, i2, paramView.getWidth() + i1, i3 + i2).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      boolean bool3 = d(paramMotionEvent);
      boolean bool4 = f(paramMotionEvent);
      boolean bool2 = e(paramMotionEvent);
      if ((!bool5) && (!bool3) && (!bool4) && (!bool2)) {}
    }
    for (bool1 = false;; bool1 = false) {
      return bool1;
    }
  }
  
  public final void a_(String paramString)
  {
    Log.e("--->", "open link:" + paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramString = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramString));
      paramString.setPackage(getActivity().getPackageName());
      try
      {
        startActivity(paramString);
      }
      catch (ActivityNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      w();
      com.linksure.apservice.utils.b.a("saidinp", this.y);
    }
  }
  
  public final void b(String paramString)
  {
    this.m.setText(paramString);
    if (paramString != null) {
      this.m.setSelection(paramString.length());
    }
  }
  
  public final boolean b(MotionEvent paramMotionEvent)
  {
    View localView = this.q;
    boolean bool3 = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), localView);
    boolean bool1 = c(paramMotionEvent);
    boolean bool5 = d(paramMotionEvent);
    boolean bool2 = f(paramMotionEvent);
    boolean bool4 = e(paramMotionEvent);
    if ((bool3) || (bool5) || (bool2) || (bool4) || (bool1)) {}
    for (bool1 = false;; bool1 = true) {
      return bool1;
    }
  }
  
  public final void f_(int paramInt)
  {
    Toast.makeText(getActivity(), paramInt, 0).show();
  }
  
  public final void h()
  {
    Intent localIntent = new Intent(getActivity(), PhotoPickerActivity.class);
    localIntent.putExtra("is_show_camera", false);
    localIntent.putExtra("select_mode", 0);
    localIntent.putExtra("is_crop", false);
    startActivityForResult(localIntent, 201601209);
  }
  
  public final boolean i()
  {
    boolean bool = false;
    if ((this.g == 4) || (this.g == 3))
    {
      d(0);
      bool = true;
    }
    return bool;
  }
  
  final void j()
  {
    this.l.setVisibility(0);
    w();
  }
  
  final void k()
  {
    this.l.setVisibility(8);
  }
  
  public final boolean l()
  {
    if (this.g == 4) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean m()
  {
    if (this.g == 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean n()
  {
    if (this.g == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void o()
  {
    if ((this.g == 4) || (this.g == 3)) {
      d(0);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.e("--->", "aps keyboard get camera data:" + paramInt1 + " code:" + paramInt2);
    if (paramInt2 != -1) {
      return;
    }
    if ((paramInt1 == 201601209) || (paramInt1 == 20161212))
    {
      paramIntent = (ArrayList)paramIntent.getSerializableExtra("picker_result");
      if ((paramIntent == null) || (paramIntent.isEmpty())) {}
    }
    for (paramIntent = (String)paramIntent.get(0);; paramIntent = null)
    {
      if ((!TextUtils.isEmpty(paramIntent)) && (new File(paramIntent).exists()))
      {
        this.v.b(paramIntent);
        break;
      }
      Toast.makeText(getActivity(), R.string.aps_picker_img_err, 0).show();
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.aps_keyboard_menu_switcher) {
      if (this.x) {
        d(1);
      }
    }
    for (;;)
    {
      return;
      if (this.g == 0)
      {
        d(2);
      }
      else
      {
        d(0);
        continue;
        if (i1 == R.id.aps_keyboard_normal_switcher)
        {
          d(0);
        }
        else if (i1 == R.id.aps_keyboard_input)
        {
          d(2);
        }
        else if (i1 == R.id.aps_keyboard_input)
        {
          d(2);
        }
        else if (i1 == R.id.aps_keyboard_emoji_switcher)
        {
          if (this.g == 4) {
            d(2);
          } else {
            d(4);
          }
        }
        else if (i1 == R.id.aps_keyboard_tools_switcher)
        {
          if (this.g == 3) {
            d(2);
          } else {
            d(3);
          }
        }
        else if (i1 == R.id.aps_keyboard_send)
        {
          paramView = this.m.getText().toString();
          this.m.getText().clear();
          this.v.a(paramView);
          com.linksure.apservice.utils.b.a("saidsbcli", this.y);
        }
        else if (i1 == R.id.aps_menu_item)
        {
          this.v.a((h)paramView.getTag());
        }
        else if (i1 == R.id.aps_keyboard_item_text)
        {
          i1 = ((Integer)paramView.getTag()).intValue();
          if (i1 == R.id.aps_keyboard_extend_camera) {
            this.v.c();
          } else if (i1 == R.id.aps_keyboard_extend_photo) {
            this.v.d();
          }
        }
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    boolean bool = true;
    super.onCreate(paramBundle);
    Object localObject = new e(this, i.d(getActivity()), i.a(getActivity()), i.b(getActivity()));
    super.a((com.linksure.apservice.ui.common.interceptor.a.a)localObject);
    this.v = ((b.a)localObject);
    Log.e("--->", "on create keyboard");
    a.a(this);
    if (com.bluefay.a.c.b())
    {
      localObject = getActivity().findViewById(R.id.aps_keyboard_placeholder);
      f.a(getActivity(), this, (View)localObject);
      this.j = ((InputMethodManager)getActivity().getSystemService("input_method"));
      localObject = getArguments();
      if (paramBundle == null) {
        break label180;
      }
      localObject = (com.linksure.apservice.b.a)paramBundle.getSerializable("key aps account");
      paramBundle = (ArrayList)paramBundle.getSerializable("key_dynamic_menu");
      this.v.a((com.linksure.apservice.b.a)localObject, paramBundle);
      if (paramBundle == null) {
        break label175;
      }
    }
    label175:
    for (bool = true;; bool = false)
    {
      this.x = bool;
      this.y = ((com.linksure.apservice.b.a)localObject).k;
      return;
      f.a(getActivity(), this);
      break;
    }
    label180:
    paramBundle = (com.linksure.apservice.b.a)((Bundle)localObject).getSerializable("key aps account");
    localObject = (ArrayList)((Bundle)localObject).getSerializable("key_dynamic_menu");
    this.v.a(paramBundle, (List)localObject);
    if (localObject != null) {}
    for (;;)
    {
      this.x = bool;
      this.y = paramBundle.k;
      break;
      bool = false;
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.aps_fragment_keyboard, null);
    paramLayoutInflater.findViewById(R.id.aps_keyboard_normal_switcher).setOnClickListener(this);
    paramLayoutInflater.findViewById(R.id.aps_keyboard_tools_switcher).setOnClickListener(this);
    paramLayoutInflater.findViewById(R.id.aps_keyboard_emoji_switcher).setOnClickListener(this);
    paramLayoutInflater.findViewById(R.id.aps_keyboard_input).setOnClickListener(this);
    paramLayoutInflater.findViewById(R.id.aps_keyboard_menu_switcher).setOnClickListener(this);
    this.k = ((ViewFlipper)paramLayoutInflater.findViewById(R.id.aps_keyboard_flipper));
    this.k.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.aps_push_bottom_in));
    this.k.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.aps_push_buttom_out));
    this.m = ((EditText)paramLayoutInflater.findViewById(R.id.aps_keyboard_input));
    this.l = paramLayoutInflater.findViewById(R.id.aps_keyboard_extend_menu);
    this.n = paramLayoutInflater.findViewById(R.id.aps_keyboard_emoji_switcher);
    this.o = paramLayoutInflater.findViewById(R.id.aps_keyboard_tools_switcher);
    this.r = paramLayoutInflater.findViewById(R.id.aps_keyboard_send);
    this.p = paramLayoutInflater.findViewById(R.id.aps_keyboard_extend_emoji);
    this.q = paramLayoutInflater.findViewById(R.id.aps_keyboard_extends_tools);
    this.s = ((ViewPager)paramLayoutInflater.findViewById(R.id.aps_keyboard_emoji_viewpager));
    this.s.setAdapter(new com.linksure.apservice.ui.home.a.a(getActivity()).a(com.linksure.apservice.utils.c.b).a());
    this.t = ((CircleIndicator)paramLayoutInflater.findViewById(R.id.aps_keyboard_emoji_indicator));
    this.u = ((LinearLayout)paramLayoutInflater.findViewById(R.id.aps_dynamic_menu));
    this.t.a(this.s);
    this.m.addTextChangedListener(new c(this));
    this.r.setOnClickListener(this);
    this.w = paramLayoutInflater.findViewById(R.id.aps_menu_switcher_divider);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(R.id.aps_keyboard_extend_camera).findViewById(R.id.aps_keyboard_item_text);
    paramViewGroup.setText(R.string.aps_keyboard_camera);
    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.aps_camera_selector, 0, 0);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setTag(Integer.valueOf(R.id.aps_keyboard_extend_camera));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(R.id.aps_keyboard_extend_photo).findViewById(R.id.aps_keyboard_item_text);
    paramViewGroup.setText(R.string.aps_keyboard_photo);
    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.aps_photo_selector, 0, 0);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setTag(Integer.valueOf(R.id.aps_keyboard_extend_photo));
    int i1 = com.linksure.apservice.a.b.b.c(getActivity()).a("key_keyboard_height");
    if (i1 > 0)
    {
      paramViewGroup = this.l.getLayoutParams();
      paramViewGroup.height = i1;
      this.l.setLayoutParams(paramViewGroup);
      this.l.requestLayout();
    }
    if (this.x) {
      d(1);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.e("--->", "on destroy! keyboard");
    a.b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.z != null) {
      this.z.dismiss();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("key aps account", getArguments().getSerializable("key aps account"));
    paramBundle.putSerializable("key_dynamic_menu", getArguments().getSerializable("key_dynamic_menu"));
  }
  
  final void p()
  {
    this.j.hideSoftInputFromWindow(this.l.getWindowToken(), 0);
    getActivity().getWindow().setSoftInputMode(32);
    this.w.requestFocusFromTouch();
  }
  
  public final void q()
  {
    this.j.hideSoftInputFromWindow(this.l.getWindowToken(), 0);
    getActivity().getWindow().setSoftInputMode(16);
    this.w.requestFocusFromTouch();
  }
  
  public final void q_()
  {
    Intent localIntent = new Intent(getActivity(), PhotoPickerActivity.class);
    localIntent.putExtra("is_show_camera", false);
    localIntent.putExtra("select_mode", 0);
    localIntent.putExtra("is_crop", false);
    localIntent.putExtra("goto camera directly", true);
    startActivityForResult(localIntent, 20161212);
  }
  
  final void r()
  {
    this.j.showSoftInput(this.m, 0);
    getActivity().getWindow().setSoftInputMode(16);
    w();
  }
  
  final void s()
  {
    this.p.setVisibility(0);
    this.q.setVisibility(8);
  }
  
  final void t()
  {
    this.q.setVisibility(0);
    this.p.setVisibility(8);
  }
  
  final void u()
  {
    this.m.setFocusable(false);
  }
  
  final void v()
  {
    this.m.setFocusable(true);
    this.m.setFocusableInTouchMode(true);
    this.m.requestFocus();
  }
  
  static abstract class a
    implements TextWatcher
  {
    abstract void a(int paramInt);
    
    public void afterTextChanged(Editable paramEditable)
    {
      if ((paramEditable == null) || (paramEditable.length() == 0)) {
        a(0);
      }
      for (;;)
      {
        return;
        a(paramEditable.length());
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  static final class b
    extends KeyboardFragment.f
  {
    final void a(KeyboardFragment paramKeyboardFragment)
    {
      paramKeyboardFragment.u();
      switch (KeyboardFragment.b(paramKeyboardFragment))
      {
      case 1: 
      default: 
        KeyboardFragment.b(paramKeyboardFragment, 4);
        return;
      case 0: 
        paramKeyboardFragment.j();
      }
      for (;;)
      {
        paramKeyboardFragment.s();
        break;
        paramKeyboardFragment.p();
        paramKeyboardFragment.j();
      }
    }
  }
  
  static final class c
    extends KeyboardFragment.f
  {
    final void a(KeyboardFragment paramKeyboardFragment)
    {
      paramKeyboardFragment.u();
      switch (KeyboardFragment.b(paramKeyboardFragment))
      {
      }
      for (;;)
      {
        KeyboardFragment.b(paramKeyboardFragment, 1);
        return;
        KeyboardFragment.c(paramKeyboardFragment).showNext();
        continue;
        KeyboardFragment.d(paramKeyboardFragment).setVisibility(8);
        KeyboardFragment.c(paramKeyboardFragment).showNext();
        continue;
        paramKeyboardFragment.p();
        KeyboardFragment.c(paramKeyboardFragment).showNext();
      }
    }
  }
  
  static final class d
    extends KeyboardFragment.f
  {
    final void a(KeyboardFragment paramKeyboardFragment)
    {
      paramKeyboardFragment.u();
      switch (KeyboardFragment.b(paramKeyboardFragment))
      {
      }
      for (;;)
      {
        KeyboardFragment.b(paramKeyboardFragment, 0);
        return;
        KeyboardFragment.c(paramKeyboardFragment).showNext();
        continue;
        KeyboardFragment.d(paramKeyboardFragment).setVisibility(8);
        continue;
        paramKeyboardFragment.p();
      }
    }
  }
  
  static final class e
    extends KeyboardFragment.f
  {
    final void a(KeyboardFragment paramKeyboardFragment)
    {
      paramKeyboardFragment.v();
      switch (KeyboardFragment.b(paramKeyboardFragment))
      {
      }
      for (;;)
      {
        KeyboardFragment.b(paramKeyboardFragment, 2);
        return;
        paramKeyboardFragment.r();
        continue;
        paramKeyboardFragment.k();
        paramKeyboardFragment.r();
      }
    }
  }
  
  static abstract class f
  {
    abstract void a(KeyboardFragment paramKeyboardFragment);
  }
  
  static final class g
    extends KeyboardFragment.f
  {
    final void a(KeyboardFragment paramKeyboardFragment)
    {
      paramKeyboardFragment.u();
      switch (KeyboardFragment.b(paramKeyboardFragment))
      {
      case 1: 
      case 3: 
      default: 
        KeyboardFragment.b(paramKeyboardFragment, 3);
        return;
      case 0: 
        paramKeyboardFragment.j();
      }
      for (;;)
      {
        paramKeyboardFragment.t();
        break;
        paramKeyboardFragment.p();
        paramKeyboardFragment.j();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/keyboard/KeyboardFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */