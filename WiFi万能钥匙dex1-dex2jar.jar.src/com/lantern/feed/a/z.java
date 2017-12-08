package com.lantern.feed.a;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.bluefay.b.h;
import com.lantern.feed.ui.WkFeedTextureView;

public final class z
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener
{
  private static z a;
  private MediaPlayer b = new MediaPlayer();
  private a c;
  private a d;
  private int e;
  private int f;
  private HandlerThread g = new HandlerThread("mediaPlayer");
  private Handler h;
  private Handler i = new Handler(Looper.getMainLooper(), new aa(this));
  private WkFeedTextureView j;
  private SurfaceTexture k;
  private String l;
  private int m;
  private int n;
  
  public z()
  {
    this.g.start();
    this.h = new Handler(this.g.getLooper(), new ab(this));
  }
  
  public static z a()
  {
    if (a == null) {
      a = new z();
    }
    return a;
  }
  
  public final void a(int paramInt)
  {
    h.a("seekTo", new Object[0]);
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        this.b.seekTo(paramInt);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        h.a(localIllegalStateException);
        continue;
      }
      h.a("seekTo no mediaplayer", new Object[0]);
    }
  }
  
  public final void a(a parama)
  {
    this.c = parama;
  }
  
  public final void a(WkFeedTextureView paramWkFeedTextureView)
  {
    this.j = paramWkFeedTextureView;
    this.j.setKeepScreenOn(true);
    this.j.setSurfaceTextureListener(this);
  }
  
  public final void a(String paramString)
  {
    this.l = paramString;
    this.i.removeMessages(2);
    new Message().what = 2;
    this.i.sendEmptyMessageDelayed(2, 15000L);
  }
  
  public final void b()
  {
    this.h.sendEmptyMessage(1);
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void b(a parama)
  {
    this.d = parama;
  }
  
  public final void c()
  {
    h.a("start", new Object[0]);
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        this.b.start();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        h.a(localIllegalStateException);
        continue;
      }
      h.a("start no mediaplayer", new Object[0]);
    }
  }
  
  public final void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void d()
  {
    h.a("pause", new Object[0]);
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        this.b.pause();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        h.a(localIllegalStateException);
        continue;
      }
      h.a("pause no mediaplayer", new Object[0]);
    }
  }
  
  public final int e()
  {
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        i1 = this.b.getCurrentPosition();
        return i1;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        h.a(localIllegalStateException);
      }
      int i1 = 0;
    }
  }
  
  public final int f()
  {
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        i1 = this.b.getDuration();
        return i1;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        h.a(localIllegalStateException);
      }
      int i1 = 0;
    }
  }
  
  public final a g()
  {
    return this.c;
  }
  
  public final a h()
  {
    return this.d;
  }
  
  public final int i()
  {
    return this.e;
  }
  
  public final int j()
  {
    return this.f;
  }
  
  public final void k()
  {
    this.k = null;
  }
  
  public final WkFeedTextureView l()
  {
    return this.j;
  }
  
  public final Point m()
  {
    if ((this.m != 0) && (this.n != 0)) {}
    for (Point localPoint = new Point(this.m, this.n);; localPoint = null) {
      return localPoint;
    }
  }
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.i.post(new ae(this, paramInt));
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    h.a("onCompletion", new Object[0]);
    b();
    this.i.post(new ad(this));
  }
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.i.post(new ag(this, paramInt1, paramInt2));
    return false;
  }
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    h.a("onInfo what:" + paramInt1 + " extra:" + paramInt2, new Object[0]);
    this.i.post(new ai(this, paramInt1, paramInt2));
    return false;
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.i.removeMessages(2);
    if (this.b != null) {}
    try
    {
      this.b.start();
      this.i.post(new ac(this));
      return;
    }
    catch (IllegalStateException paramMediaPlayer)
    {
      for (;;)
      {
        h.a(paramMediaPlayer);
      }
    }
  }
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    this.i.post(new af(this));
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.k == null)
    {
      this.k = paramSurfaceTexture;
      this.h.sendEmptyMessage(3);
    }
    for (;;)
    {
      return;
      this.k = paramSurfaceTexture;
      if (this.b != null) {
        try
        {
          paramSurfaceTexture = this.b;
          Surface localSurface = new android/view/Surface;
          localSurface.<init>(this.k);
          paramSurfaceTexture.setSurface(localSurface);
        }
        catch (IllegalStateException paramSurfaceTexture)
        {
          h.a(paramSurfaceTexture);
        }
      }
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.k == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.n = paramInt2;
    this.i.post(new ah(this));
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void b();
    
    public abstract void b(int paramInt);
    
    public abstract void c();
    
    public abstract void c(int paramInt);
    
    public abstract void d();
    
    public abstract void d(int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */