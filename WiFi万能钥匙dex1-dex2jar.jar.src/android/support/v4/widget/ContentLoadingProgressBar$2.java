package android.support.v4.widget;

class ContentLoadingProgressBar$2
  implements Runnable
{
  ContentLoadingProgressBar$2(ContentLoadingProgressBar paramContentLoadingProgressBar) {}
  
  public void run()
  {
    ContentLoadingProgressBar.access$202(this.this$0, false);
    if (!ContentLoadingProgressBar.access$300(this.this$0))
    {
      ContentLoadingProgressBar.access$102(this.this$0, System.currentTimeMillis());
      this.this$0.setVisibility(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/ContentLoadingProgressBar$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */