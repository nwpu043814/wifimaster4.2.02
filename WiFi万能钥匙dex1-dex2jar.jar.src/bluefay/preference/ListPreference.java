package bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bluefay.app.k.a;
import com.bluefay.framework.R.id;

public class ListPreference
  extends DialogPreference
{
  private CharSequence[] b;
  private CharSequence[] c;
  private String d;
  private String e;
  private int f;
  private boolean g;
  
  public ListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject = com.bluefay.a.e.a("com.android.internal.R$styleable", "ListPreference");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, 0, 0);
      int j = ((Integer)com.bluefay.a.e.a("com.android.internal.R$styleable", "ListPreference_entries")).intValue();
      int i = ((Integer)com.bluefay.a.e.a("com.android.internal.R$styleable", "ListPreference_entryValues")).intValue();
      this.b = paramContext.getTextArray(j);
      this.c = paramContext.getTextArray(i);
      paramContext.recycle();
    }
  }
  
  private CharSequence F()
  {
    int i = G();
    if ((i >= 0) && (this.b != null)) {}
    for (CharSequence localCharSequence = this.b[i];; localCharSequence = null) {
      return localCharSequence;
    }
  }
  
  private int G()
  {
    String str = this.d;
    int i;
    if ((str != null) && (this.c != null))
    {
      i = this.c.length - 1;
      if (i >= 0) {
        if (!this.c[i].equals(str)) {}
      }
    }
    for (;;)
    {
      return i;
      i--;
      break;
      i = -1;
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.equals(this.d, paramString)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (!this.g))
      {
        this.d = paramString;
        this.g = true;
        c(paramString);
        if (i != 0) {
          z();
        }
      }
      return;
    }
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getString(paramInt);
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
      a(paramParcelable.a);
    }
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    paramView = paramView.findViewById(R.id.right_value);
    if (paramView != null) {
      ((TextView)paramView).setText(F());
    }
  }
  
  protected final void a(k.a parama)
  {
    super.a(parama);
    if ((this.b == null) || (this.c == null)) {
      throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
    }
    this.f = G();
    parama.a(this.b, this.f, new e(this));
    parama.a(null, null);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    super.a(paramCharSequence);
    if ((paramCharSequence == null) && (this.e != null)) {
      this.e = null;
    }
    for (;;)
    {
      return;
      if ((paramCharSequence != null) && (!paramCharSequence.equals(this.e))) {
        this.e = paramCharSequence.toString();
      }
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((paramBoolean) && (this.f >= 0) && (this.c != null))
    {
      String str = this.c[this.f].toString();
      if (x()) {
        a(str);
      }
    }
  }
  
  protected final void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (paramObject = d(this.d);; paramObject = (String)paramObject)
    {
      a((String)paramObject);
      return;
    }
  }
  
  protected final Parcelable h()
  {
    Object localObject = super.h();
    if (w()) {}
    for (;;)
    {
      return (Parcelable)localObject;
      localObject = new SavedState((Parcelable)localObject);
      ((SavedState)localObject).a = this.d;
    }
  }
  
  public final CharSequence j()
  {
    Object localObject = F();
    if ((this.e == null) || (localObject == null)) {}
    for (localObject = super.j();; localObject = String.format(this.e, new Object[] { localObject })) {
      return (CharSequence)localObject;
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new f();
    String a;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readString();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/ListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */