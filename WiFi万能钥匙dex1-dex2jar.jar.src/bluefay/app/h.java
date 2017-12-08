package bluefay.app;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

final class h
  extends CursorAdapter
{
  private final int d;
  private final int e;
  
  h(e.a parama, Context paramContext, Cursor paramCursor, ListView paramListView, e parame)
  {
    super(paramContext, paramCursor, false);
    parama = getCursor();
    this.d = parama.getColumnIndexOrThrow(this.c.H);
    this.e = parama.getColumnIndexOrThrow(this.c.I);
  }
  
  public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((CheckedTextView)paramView.findViewById(16908308)).setText(paramCursor.getString(this.d));
    paramView = this.a;
    int i = paramCursor.getPosition();
    if (paramCursor.getInt(this.e) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setItemChecked(i, bool);
      return;
    }
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.c.b.inflate(e.j(this.b), paramViewGroup, false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */