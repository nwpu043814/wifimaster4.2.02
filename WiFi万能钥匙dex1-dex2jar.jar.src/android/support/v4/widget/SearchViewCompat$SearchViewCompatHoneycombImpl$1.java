package android.support.v4.widget;

class SearchViewCompat$SearchViewCompatHoneycombImpl$1
  implements SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge
{
  SearchViewCompat$SearchViewCompatHoneycombImpl$1(SearchViewCompat.SearchViewCompatHoneycombImpl paramSearchViewCompatHoneycombImpl, SearchViewCompat.OnQueryTextListenerCompat paramOnQueryTextListenerCompat) {}
  
  public boolean onQueryTextChange(String paramString)
  {
    return this.val$listener.onQueryTextChange(paramString);
  }
  
  public boolean onQueryTextSubmit(String paramString)
  {
    return this.val$listener.onQueryTextSubmit(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/SearchViewCompat$SearchViewCompatHoneycombImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */