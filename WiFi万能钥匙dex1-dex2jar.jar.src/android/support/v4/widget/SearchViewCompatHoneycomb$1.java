package android.support.v4.widget;

import android.widget.SearchView.OnQueryTextListener;

final class SearchViewCompatHoneycomb$1
  implements SearchView.OnQueryTextListener
{
  SearchViewCompatHoneycomb$1(SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge paramOnQueryTextListenerCompatBridge) {}
  
  public final boolean onQueryTextChange(String paramString)
  {
    return this.val$listener.onQueryTextChange(paramString);
  }
  
  public final boolean onQueryTextSubmit(String paramString)
  {
    return this.val$listener.onQueryTextSubmit(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/SearchViewCompatHoneycomb$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */