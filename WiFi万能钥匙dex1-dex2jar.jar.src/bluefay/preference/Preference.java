package bluefay.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bluefay.a.e;
import com.bluefay.framework.R.layout;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Preference
  implements Comparable<Preference>
{
  private boolean A = true;
  private a B;
  private List<Preference> C;
  private boolean D;
  PreferenceGroup a;
  private Context b;
  private r c;
  private long d;
  private b e;
  private c f;
  private int g = Integer.MAX_VALUE;
  private CharSequence h;
  private int i;
  private CharSequence j;
  private int k;
  private Drawable l;
  private String m;
  private Intent n;
  private String o;
  private Bundle p;
  private boolean q = true;
  private boolean r = true;
  private boolean s = true;
  private String t;
  private Object u;
  private boolean v = true;
  private boolean w = true;
  private boolean x = true;
  private int y = R.layout.framework_preference;
  private int z;
  
  public Preference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Preference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842894);
  }
  
  public Preference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.b = paramContext;
    Object localObject = e.a("com.android.internal.R$styleable", "Preference");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
      int i3 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_icon")).intValue();
      int i2 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_key")).intValue();
      int i11 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_title")).intValue();
      int i14 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_summary")).intValue();
      int i1 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_order")).intValue();
      int i8 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_fragment")).intValue();
      int i10 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_layout")).intValue();
      int i7 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_widgetLayout")).intValue();
      int i9 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_enabled")).intValue();
      int i12 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_selectable")).intValue();
      int i13 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_persistent")).intValue();
      int i5 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_dependency")).intValue();
      int i4 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_defaultValue")).intValue();
      int i6 = ((Integer)e.a("com.android.internal.R$styleable", "Preference_shouldDisableView")).intValue();
      paramInt = paramContext.getIndexCount();
      if (paramInt >= 0)
      {
        int i15 = paramContext.getIndex(paramInt);
        if (i15 == i3) {
          this.k = paramContext.getResourceId(i15, 0);
        }
        for (;;)
        {
          paramInt--;
          break;
          if (i15 == i2)
          {
            this.m = paramContext.getString(i15);
          }
          else if (i15 == i11)
          {
            this.i = paramContext.getResourceId(i15, 0);
            this.h = paramContext.getString(i15);
          }
          else if (i15 == i14)
          {
            this.j = paramContext.getString(i15);
          }
          else if (i15 == i1)
          {
            this.g = paramContext.getInt(i15, this.g);
          }
          else if (i15 == i8)
          {
            this.o = paramContext.getString(i15);
          }
          else if (i15 == i10)
          {
            this.y = paramContext.getResourceId(i15, this.y);
          }
          else if (i15 == i7)
          {
            this.z = paramContext.getResourceId(i15, this.z);
          }
          else if (i15 == i9)
          {
            this.q = paramContext.getBoolean(i15, true);
          }
          else if (i15 == i12)
          {
            this.r = paramContext.getBoolean(i15, true);
          }
          else if (i15 == i13)
          {
            this.s = paramContext.getBoolean(i15, this.s);
          }
          else if (i15 == i5)
          {
            this.t = paramContext.getString(i15);
          }
          else if (i15 == i4)
          {
            this.u = a(paramContext, i15);
          }
          else if (i15 == i6)
          {
            this.x = paramContext.getBoolean(i15, this.x);
          }
        }
      }
      paramContext.recycle();
      if ((!getClass().getName().startsWith("android.preference")) && (!getClass().getName().startsWith("com.android"))) {
        this.A = false;
      }
    }
  }
  
  private Preference a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.c == null)) {}
    for (paramString = null;; paramString = this.c.a(paramString)) {
      return paramString;
    }
  }
  
  private void a(SharedPreferences.Editor paramEditor)
  {
    if (this.c.f()) {}
    try
    {
      paramEditor.apply();
      return;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      for (;;)
      {
        paramEditor.commit();
      }
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      for (int i1 = paramView.getChildCount() - 1; i1 >= 0; i1--) {
        a(paramView.getChildAt(i1), paramBoolean);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.v == paramBoolean) {
      if (paramBoolean) {
        break label32;
      }
    }
    label32:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.v = paramBoolean;
      c(i());
      z();
      return;
    }
  }
  
  private boolean b()
  {
    if (!TextUtils.isEmpty(this.m)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean c()
  {
    if ((this.c != null) && (this.s) && (b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected final void A()
  {
    if (this.B != null) {
      this.B.b();
    }
  }
  
  public final r B()
  {
    return this.c;
  }
  
  protected void C()
  {
    if (!TextUtils.isEmpty(this.t))
    {
      Preference localPreference = a(this.t);
      if (localPreference != null)
      {
        if (localPreference.C == null) {
          localPreference.C = new ArrayList();
        }
        localPreference.C.add(this);
        a(localPreference.i());
      }
    }
    else
    {
      return;
    }
    throw new IllegalStateException("Dependency \"" + this.t + "\" not found for preference \"" + this.m + "\" (title: \"" + this.h + "\"");
  }
  
  protected void D()
  {
    if (this.t != null)
    {
      Preference localPreference = a(this.t);
      if ((localPreference != null) && (localPreference.C != null)) {
        localPreference.C.remove(this);
      }
    }
  }
  
  final boolean E()
  {
    return this.A;
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramViewGroup);
    }
    a(localView);
    return localView;
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.b.getSystemService("layout_inflater");
    View localView = localLayoutInflater.inflate(this.y, paramViewGroup, false);
    paramViewGroup = (ViewGroup)localView.findViewById(16908312);
    if (paramViewGroup != null)
    {
      if (this.z == 0) {
        break label59;
      }
      localLayoutInflater.inflate(this.z, paramViewGroup);
    }
    for (;;)
    {
      return localView;
      label59:
      paramViewGroup.setVisibility(8);
    }
  }
  
  protected Object a(TypedArray paramTypedArray, int paramInt)
  {
    return null;
  }
  
  public final void a(Intent paramIntent)
  {
    this.n = paramIntent;
  }
  
  public final void a(Drawable paramDrawable)
  {
    if (((paramDrawable == null) && (this.l != null)) || ((paramDrawable != null) && (this.l != paramDrawable)))
    {
      this.l = paramDrawable;
      z();
    }
  }
  
  void a(Bundle paramBundle)
  {
    if (b())
    {
      this.D = false;
      Parcelable localParcelable = h();
      if (!this.D) {
        throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
      }
      if (localParcelable != null) {
        paramBundle.putParcelable(this.m, localParcelable);
      }
    }
  }
  
  protected void a(Parcelable paramParcelable)
  {
    this.D = true;
    if ((paramParcelable != BaseSavedState.EMPTY_STATE) && (paramParcelable != null)) {
      throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
    }
  }
  
  protected void a(View paramView)
  {
    int i1 = 0;
    Object localObject = (TextView)paramView.findViewById(16908310);
    CharSequence localCharSequence;
    if (localObject != null)
    {
      localCharSequence = this.h;
      if (!TextUtils.isEmpty(localCharSequence))
      {
        ((TextView)localObject).setText(localCharSequence);
        ((TextView)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = (TextView)paramView.findViewById(16908304);
      if (localObject != null)
      {
        localCharSequence = j();
        if (TextUtils.isEmpty(localCharSequence)) {
          break label203;
        }
        ((TextView)localObject).setText(localCharSequence);
        ((TextView)localObject).setVisibility(0);
      }
      label82:
      localObject = (ImageView)paramView.findViewById(16908294);
      if (localObject != null)
      {
        if ((this.k != 0) || (this.l != null))
        {
          if (this.l == null) {
            this.l = this.b.getResources().getDrawable(this.k);
          }
          if (this.l != null)
          {
            ((ImageView)localObject).setImageDrawable(this.l);
            if (this.q) {
              break label212;
            }
            ((ImageView)localObject).setAlpha(0.5F);
          }
        }
        label165:
        if (this.l == null) {
          break label220;
        }
      }
    }
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i1);
      if (this.x) {
        a(paramView, a());
      }
      return;
      ((TextView)localObject).setVisibility(8);
      break;
      label203:
      ((TextView)localObject).setVisibility(8);
      break label82;
      label212:
      ((ImageView)localObject).setAlpha(1.0F);
      break label165;
      label220:
      i1 = 8;
    }
  }
  
  final void a(a parama)
  {
    this.B = parama;
  }
  
  public final void a(PreferenceScreen paramPreferenceScreen)
  {
    if (!a()) {}
    for (;;)
    {
      return;
      d();
      if ((this.f == null) || (!this.f.a()))
      {
        Object localObject = this.c;
        if (localObject != null)
        {
          localObject = ((r)localObject).k();
          if ((paramPreferenceScreen != null) && (localObject != null) && (((r.d)localObject).a(paramPreferenceScreen, this))) {}
        }
        else if (this.n != null)
        {
          this.b.startActivity(this.n);
        }
      }
    }
  }
  
  protected void a(r paramr)
  {
    this.c = paramr;
    this.d = paramr.b();
    if (c())
    {
      if (this.c == null)
      {
        paramr = null;
        if (paramr.contains(this.m)) {
          break label70;
        }
      }
    }
    else if (this.u != null) {
      a(false, this.u);
    }
    for (;;)
    {
      return;
      paramr = this.c.c();
      break;
      label70:
      a(true, null);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (((paramCharSequence == null) && (this.j != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.j))))
    {
      this.j = paramCharSequence;
      z();
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  public boolean a()
  {
    if ((this.q) && (this.v) && (this.w)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected final boolean a(Set<String> paramSet)
  {
    boolean bool = true;
    if (c()) {
      if (!paramSet.equals(b(null))) {}
    }
    for (;;)
    {
      return bool;
      SharedPreferences.Editor localEditor = this.c.e();
      localEditor.putStringSet(this.m, paramSet);
      a(localEditor);
      continue;
      bool = false;
    }
  }
  
  protected final Set<String> b(Set<String> paramSet)
  {
    if (!c()) {}
    for (;;)
    {
      return paramSet;
      paramSet = this.c.c().getStringSet(this.m, paramSet);
    }
  }
  
  void b(Bundle paramBundle)
  {
    if (b())
    {
      paramBundle = paramBundle.getParcelable(this.m);
      if (paramBundle != null)
      {
        this.D = false;
        a(paramBundle);
        if (!this.D) {
          throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
      }
    }
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    if (((paramCharSequence == null) && (this.h != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.h))))
    {
      this.i = 0;
      this.h = paramCharSequence;
      z();
    }
  }
  
  public final void b(String paramString)
  {
    this.o = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.q != paramBoolean)
    {
      this.q = paramBoolean;
      c(i());
      z();
    }
  }
  
  public final void c(int paramInt)
  {
    if (paramInt != this.y) {
      this.A = false;
    }
    this.y = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    List localList = this.C;
    if (localList == null) {}
    for (;;)
    {
      return;
      int i2 = localList.size();
      for (int i1 = 0; i1 < i2; i1++) {
        ((Preference)localList.get(i1)).a(paramBoolean);
      }
    }
  }
  
  protected final boolean c(String paramString)
  {
    boolean bool = true;
    if (c()) {
      if (paramString != d(null)) {}
    }
    for (;;)
    {
      return bool;
      SharedPreferences.Editor localEditor = this.c.e();
      localEditor.putString(this.m, paramString);
      a(localEditor);
      continue;
      bool = false;
    }
  }
  
  protected final String d(String paramString)
  {
    if (!c()) {}
    for (;;)
    {
      return paramString;
      paramString = this.c.c().getString(this.m, paramString);
    }
  }
  
  protected void d() {}
  
  public final void d(int paramInt)
  {
    if (paramInt != this.g)
    {
      this.g = paramInt;
      A();
    }
  }
  
  public final void d(boolean paramBoolean)
  {
    if (this.w == paramBoolean) {
      if (paramBoolean) {
        break label32;
      }
    }
    label32:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.w = paramBoolean;
      c(i());
      z();
      return;
    }
  }
  
  public final void e(int paramInt)
  {
    b(this.b.getString(paramInt));
    this.i = paramInt;
  }
  
  protected final boolean e(boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (c())
    {
      if (!paramBoolean) {
        bool1 = true;
      }
      if (paramBoolean == f(bool1)) {
        paramBoolean = bool2;
      }
    }
    for (;;)
    {
      return paramBoolean;
      SharedPreferences.Editor localEditor = this.c.e();
      localEditor.putBoolean(this.m, paramBoolean);
      a(localEditor);
      paramBoolean = bool2;
      continue;
      paramBoolean = false;
    }
  }
  
  public final void f(int paramInt)
  {
    this.k = paramInt;
    a(this.b.getResources().getDrawable(paramInt));
  }
  
  protected final boolean f(boolean paramBoolean)
  {
    if (!c()) {}
    for (;;)
    {
      return paramBoolean;
      paramBoolean = this.c.c().getBoolean(this.m, paramBoolean);
    }
  }
  
  public final void g(int paramInt)
  {
    a(this.b.getString(paramInt));
  }
  
  protected Parcelable h()
  {
    this.D = true;
    return BaseSavedState.EMPTY_STATE;
  }
  
  protected final boolean h(int paramInt)
  {
    boolean bool = true;
    if (c()) {
      if (paramInt != i(paramInt ^ 0xFFFFFFFF)) {}
    }
    for (;;)
    {
      return bool;
      SharedPreferences.Editor localEditor = this.c.e();
      localEditor.putInt(this.m, paramInt);
      a(localEditor);
      continue;
      bool = false;
    }
  }
  
  protected final int i(int paramInt)
  {
    if (!c()) {}
    for (;;)
    {
      return paramInt;
      paramInt = this.c.c().getInt(this.m, paramInt);
    }
  }
  
  public boolean i()
  {
    if (!a()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public CharSequence j()
  {
    return this.j;
  }
  
  public final Intent k()
  {
    return this.n;
  }
  
  public final String l()
  {
    return this.o;
  }
  
  public final Bundle m()
  {
    if (this.p == null) {
      this.p = new Bundle();
    }
    return this.p;
  }
  
  public final int n()
  {
    return this.y;
  }
  
  public final void o()
  {
    if (this.z != 0) {
      this.A = false;
    }
    this.z = 0;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final int p()
  {
    return this.z;
  }
  
  public final int q()
  {
    return this.g;
  }
  
  public final CharSequence r()
  {
    return this.h;
  }
  
  public final Drawable s()
  {
    return this.l;
  }
  
  public final boolean t()
  {
    return this.r;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharSequence localCharSequence = this.h;
    if (!TextUtils.isEmpty(localCharSequence)) {
      localStringBuilder.append(localCharSequence).append(' ');
    }
    localCharSequence = j();
    if (!TextUtils.isEmpty(localCharSequence)) {
      localStringBuilder.append(localCharSequence).append(' ');
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  final long u()
  {
    return this.d;
  }
  
  public final String v()
  {
    return this.m;
  }
  
  public final boolean w()
  {
    return this.s;
  }
  
  protected final boolean x()
  {
    if (this.e == null) {}
    for (boolean bool = true;; bool = this.e.b_()) {
      return bool;
    }
  }
  
  public final Context y()
  {
    return this.b;
  }
  
  protected final void z()
  {
    if (this.B != null) {
      this.B.a();
    }
  }
  
  public static class BaseSavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<BaseSavedState> CREATOR = new k();
    
    public BaseSavedState(Parcel paramParcel)
    {
      super();
    }
    
    public BaseSavedState(Parcelable paramParcelable)
    {
      super();
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface b
  {
    public abstract boolean b_();
  }
  
  public static abstract interface c
  {
    public abstract boolean a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/Preference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */