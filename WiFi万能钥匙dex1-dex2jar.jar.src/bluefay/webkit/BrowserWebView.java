package bluefay.webkit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserWebView
  extends WebView
{
  private WebChromeClient a;
  private WebViewClient b;
  
  public BrowserWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BrowserWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BrowserWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    this.a = paramWebChromeClient;
    super.setWebChromeClient(paramWebChromeClient);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    this.b = paramWebViewClient;
    super.setWebViewClient(paramWebViewClient);
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/webkit/BrowserWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */