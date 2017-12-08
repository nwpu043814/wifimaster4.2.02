package bluefay.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.bluefay.framework.R.layout;
import com.bluefay.framework.R.style;

public final class PreferenceScreen
  extends PreferenceGroup
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener
{
  private ListAdapter b;
  private Dialog c;
  private ListView d;
  private boolean e = true;
  private int f;
  
  public PreferenceScreen(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842891);
    this.f = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0);
    this.e = paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "windowActionBar", true);
  }
  
  private ListAdapter F()
  {
    if (this.b == null) {
      this.b = new o(this);
    }
    return this.b;
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject = y();
    if (this.d != null) {
      this.d.setAdapter(null);
    }
    View localView = ((LayoutInflater)((Context)localObject).getSystemService("layout_inflater")).inflate(R.layout.framework_preference_list_fragment, null);
    this.d = ((ListView)localView.findViewById(16908298));
    a(this.d);
    CharSequence localCharSequence = r();
    TextUtils.isEmpty(localCharSequence);
    localObject = new Dialog((Context)localObject, R.style.BL_Theme);
    this.c = ((Dialog)localObject);
    if (TextUtils.isEmpty(localCharSequence)) {
      ((Dialog)localObject).getWindow().requestFeature(1);
    }
    for (;;)
    {
      ((Dialog)localObject).setContentView(localView);
      ((Dialog)localObject).setOnDismissListener(this);
      if (paramBundle != null) {
        ((Dialog)localObject).onRestoreInstanceState(paramBundle);
      }
      B().a((DialogInterface)localObject);
      ((Dialog)localObject).show();
      return;
      ((Dialog)localObject).setTitle(localCharSequence);
    }
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(SavedState.class))) {
      super.a(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.a(paramParcelable.getSuperState());
      if (paramParcelable.a) {
        c(paramParcelable.b);
      }
    }
  }
  
  public final void a(ListView paramListView)
  {
    paramListView.setOnItemClickListener(this);
    paramListView.setAdapter(F());
    ListAdapter localListAdapter = paramListView.getAdapter();
    if ((localListAdapter != null) && (localListAdapter.getCount() > 0) && ((localListAdapter.getItem(0) instanceof PreferenceCategory))) {
      paramListView.setPadding(paramListView.getPaddingLeft(), 0, paramListView.getPaddingRight(), paramListView.getPaddingBottom());
    }
    C();
  }
  
  protected final boolean c()
  {
    return false;
  }
  
  protected final void d()
  {
    if ((k() != null) || (l() != null) || (b() == 0)) {}
    for (;;)
    {
      return;
      c(null);
    }
  }
  
  public final int f()
  {
    return this.f;
  }
  
  public final boolean g()
  {
    return this.e;
  }
  
  protected final Parcelable h()
  {
    Object localObject = super.h();
    Dialog localDialog = this.c;
    if ((localDialog == null) || (!localDialog.isShowing())) {}
    for (;;)
    {
      return (Parcelable)localObject;
      localObject = new SavedState((Parcelable)localObject);
      ((SavedState)localObject).a = true;
      ((SavedState)localObject).b = localDialog.onSaveInstanceState();
    }
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    this.c = null;
    B().b(paramDialogInterface);
  }
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt;
    if ((paramAdapterView instanceof ListView)) {
      i = paramInt - ((ListView)paramAdapterView).getHeaderViewsCount();
    }
    paramAdapterView = F().getItem(i);
    if (!(paramAdapterView instanceof Preference)) {}
    for (;;)
    {
      return;
      ((Preference)paramAdapterView).a(this);
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new s();
    boolean a;
    Bundle b;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.a = bool;
        this.b = paramParcel.readBundle();
        return;
        bool = false;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.a) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeBundle(this.b);
        return;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/PreferenceScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */