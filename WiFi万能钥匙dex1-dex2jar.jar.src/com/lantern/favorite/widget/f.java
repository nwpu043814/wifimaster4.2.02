package com.lantern.favorite.widget;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.widget.OverScroller;

final class f
  extends GestureDetector.SimpleOnGestureListener
{
  f(PhotoView paramPhotoView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    PhotoView.n(this.a).b();
    float f2 = PhotoView.o(this.a).left + PhotoView.o(this.a).width() / 2.0F;
    float f1 = PhotoView.o(this.a).top + PhotoView.o(this.a).height() / 2.0F;
    PhotoView.u(this.a).set(f2, f1);
    PhotoView.v(this.a).set(f2, f1);
    PhotoView.w(this.a);
    PhotoView.x(this.a);
    if (PhotoView.y(this.a))
    {
      f1 = PhotoView.z(this.a);
      f2 = 1.0F;
      PhotoView.B(this.a).reset();
      PhotoView.B(this.a).postTranslate(-PhotoView.C(this.a).left, -PhotoView.C(this.a).top);
      PhotoView.B(this.a).postTranslate(PhotoView.v(this.a).x, PhotoView.v(this.a).y);
      PhotoView.B(this.a).postTranslate(-PhotoView.D(this.a), -PhotoView.E(this.a));
      PhotoView.B(this.a).postRotate(PhotoView.q(this.a), PhotoView.v(this.a).x, PhotoView.v(this.a).y);
      PhotoView.B(this.a).postScale(f2, f2, PhotoView.u(this.a).x, PhotoView.u(this.a).y);
      PhotoView.B(this.a).postTranslate(PhotoView.F(this.a), PhotoView.G(this.a));
      PhotoView.B(this.a).mapRect(PhotoView.H(this.a), PhotoView.C(this.a));
      PhotoView.a(this.a, PhotoView.H(this.a));
      paramMotionEvent = this.a;
      if (PhotoView.y(this.a)) {
        break label442;
      }
    }
    label442:
    for (boolean bool = true;; bool = false)
    {
      PhotoView.c(paramMotionEvent, bool);
      PhotoView.n(this.a).a(f1, f2);
      PhotoView.n(this.a).a();
      return false;
      f1 = PhotoView.z(this.a);
      f2 = PhotoView.A(this.a);
      PhotoView.u(this.a).set(paramMotionEvent.getX(), paramMotionEvent.getY());
      break;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    PhotoView.b(this.a, false);
    PhotoView.i(this.a);
    PhotoView.a(this.a, false);
    this.a.removeCallbacks(PhotoView.j(this.a));
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if (PhotoView.k(this.a)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((!PhotoView.l(this.a)) && (!PhotoView.m(this.a)))
      {
        bool = false;
      }
      else
      {
        if (!PhotoView.n(this.a).a) {
          break;
        }
        bool = false;
      }
    }
    if ((Math.round(PhotoView.o(this.a).left) >= PhotoView.p(this.a).left) || (Math.round(PhotoView.o(this.a).right) <= PhotoView.p(this.a).right)) {}
    for (float f2 = 0.0F;; f2 = paramFloat1)
    {
      if ((Math.round(PhotoView.o(this.a).top) >= PhotoView.p(this.a).top) || (Math.round(PhotoView.o(this.a).bottom) <= PhotoView.p(this.a).bottom)) {}
      for (float f3 = 0.0F;; f3 = paramFloat2)
      {
        float f4;
        float f5;
        float f1;
        label248:
        PhotoView.f localf;
        label313:
        label343:
        int j;
        label377:
        int k;
        label388:
        int i1;
        label402:
        label413:
        label443:
        int m;
        label477:
        int n;
        label488:
        label502:
        OverScroller localOverScroller;
        int i5;
        int i4;
        int i3;
        int i2;
        if ((PhotoView.a(this.a)) || (PhotoView.q(this.a) % 90.0F != 0.0F))
        {
          f4 = (int)(PhotoView.q(this.a) / 90.0F) * 90;
          f5 = PhotoView.q(this.a) % 90.0F;
          if (f5 > 45.0F)
          {
            f1 = f4 + 90.0F;
            PhotoView.n(this.a).b((int)PhotoView.q(this.a), (int)f1);
            PhotoView.d(this.a, f1);
          }
        }
        else
        {
          PhotoView.a(this.a, PhotoView.o(this.a));
          localf = PhotoView.n(this.a);
          if (f2 >= 0.0F) {
            break label672;
          }
          i = Integer.MAX_VALUE;
          localf.h = i;
          if (f2 <= 0.0F) {
            break label678;
          }
          f1 = Math.abs(PhotoView.o(localf.n).left);
          j = (int)f1;
          i = j;
          if (f2 < 0.0F) {
            i = Integer.MAX_VALUE - j;
          }
          if (f2 >= 0.0F) {
            break label706;
          }
          j = i;
          if (f2 >= 0.0F) {
            break label712;
          }
          k = Integer.MAX_VALUE;
          if (f2 >= 0.0F) {
            break label719;
          }
          i1 = Integer.MAX_VALUE - j;
          if (f3 >= 0.0F) {
            break label726;
          }
          i = Integer.MAX_VALUE;
          localf.i = i;
          if (f3 <= 0.0F) {
            break label732;
          }
          f1 = Math.abs(PhotoView.o(localf.n).top);
          m = (int)f1;
          i = m;
          if (f3 < 0.0F) {
            i = Integer.MAX_VALUE - m;
          }
          if (f3 >= 0.0F) {
            break label760;
          }
          m = i;
          if (f3 >= 0.0F) {
            break label766;
          }
          n = Integer.MAX_VALUE;
          if (f3 >= 0.0F) {
            break label773;
          }
          i = Integer.MAX_VALUE - m;
          if (f2 == 0.0F)
          {
            k = 0;
            j = 0;
          }
          if (f3 == 0.0F)
          {
            n = 0;
            m = 0;
          }
          localOverScroller = localf.c;
          i5 = localf.h;
          i4 = localf.i;
          i3 = (int)f2;
          i2 = (int)f3;
          if (Math.abs(i1) >= PhotoView.J(localf.n) * 2) {
            break label776;
          }
          i1 = 0;
          label580:
          if (Math.abs(i) >= PhotoView.J(localf.n) * 2) {
            break label789;
          }
        }
        label672:
        label678:
        label706:
        label712:
        label719:
        label726:
        label732:
        label760:
        label766:
        label773:
        label776:
        label789:
        for (int i = 0;; i = PhotoView.J(localf.n))
        {
          localOverScroller.fling(i5, i4, i3, i2, j, k, m, n, i1, i);
          PhotoView.n(this.a).a();
          bool = super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
          break;
          f1 = f4;
          if (f5 >= -45.0F) {
            break label248;
          }
          f1 = f4 - 90.0F;
          break label248;
          i = 0;
          break label313;
          f1 = PhotoView.o(localf.n).right - PhotoView.p(localf.n).right;
          break label343;
          j = 0;
          break label377;
          k = i;
          break label388;
          i1 = i;
          break label402;
          i = 0;
          break label413;
          f1 = PhotoView.o(localf.n).bottom - PhotoView.p(localf.n).bottom;
          break label443;
          m = 0;
          break label477;
          n = i;
          break label488;
          break label502;
          i1 = PhotoView.J(localf.n);
          break label580;
        }
      }
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if (PhotoView.h(this.a) != null) {
      PhotoView.h(this.a).onLongClick(this.a);
    }
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PhotoView.n(this.a).a) {
      PhotoView.n(this.a).b();
    }
    if (this.a.a(paramFloat1))
    {
      if ((paramFloat1 >= 0.0F) || (PhotoView.o(this.a).left - paramFloat1 <= PhotoView.p(this.a).left)) {
        break label781;
      }
      paramFloat1 = PhotoView.o(this.a).left;
    }
    label775:
    label781:
    for (;;)
    {
      float f1 = paramFloat1;
      if (paramFloat1 > 0.0F)
      {
        f1 = paramFloat1;
        if (PhotoView.o(this.a).right - paramFloat1 < PhotoView.p(this.a).right) {
          f1 = PhotoView.o(this.a).right - PhotoView.p(this.a).right;
        }
      }
      PhotoView.b(this.a).postTranslate(-f1, 0.0F);
      PhotoView.e(this.a, f1);
      if (this.a.b(paramFloat2)) {
        if ((paramFloat2 >= 0.0F) || (PhotoView.o(this.a).top - paramFloat2 <= PhotoView.p(this.a).top)) {
          break label775;
        }
      }
      for (paramFloat1 = PhotoView.o(this.a).top;; paramFloat1 = paramFloat2)
      {
        paramFloat2 = paramFloat1;
        if (paramFloat1 > 0.0F)
        {
          paramFloat2 = paramFloat1;
          if (PhotoView.o(this.a).bottom - paramFloat1 < PhotoView.p(this.a).bottom) {
            paramFloat2 = PhotoView.o(this.a).bottom - PhotoView.p(this.a).bottom;
          }
        }
        PhotoView.b(this.a).postTranslate(0.0F, -paramFloat2);
        PhotoView.f(this.a, paramFloat2);
        for (;;)
        {
          PhotoView.f(this.a);
          return true;
          if ((!PhotoView.l(this.a)) && (!PhotoView.k(this.a)) && (!PhotoView.r(this.a))) {
            break;
          }
          PhotoView.s(this.a);
          float f2 = paramFloat1;
          if (!PhotoView.k(this.a))
          {
            f1 = paramFloat1;
            if (paramFloat1 < 0.0F)
            {
              f1 = paramFloat1;
              if (PhotoView.o(this.a).left - paramFloat1 > PhotoView.t(this.a).left) {
                f1 = PhotoView.a(this.a, PhotoView.o(this.a).left - PhotoView.t(this.a).left, paramFloat1);
              }
            }
            f2 = f1;
            if (f1 > 0.0F)
            {
              f2 = f1;
              if (PhotoView.o(this.a).right - f1 < PhotoView.t(this.a).right) {
                f2 = PhotoView.a(this.a, PhotoView.o(this.a).right - PhotoView.t(this.a).right, f1);
              }
            }
          }
          PhotoView.e(this.a, f2);
          PhotoView.b(this.a).postTranslate(-f2, 0.0F);
          PhotoView.b(this.a, true);
          break;
          if ((PhotoView.m(this.a)) || (PhotoView.r(this.a)) || (PhotoView.k(this.a)))
          {
            PhotoView.s(this.a);
            paramFloat1 = paramFloat2;
            if (!PhotoView.k(this.a))
            {
              f1 = paramFloat2;
              if (paramFloat2 < 0.0F)
              {
                f1 = paramFloat2;
                if (PhotoView.o(this.a).top - paramFloat2 > PhotoView.t(this.a).top) {
                  f1 = PhotoView.b(this.a, PhotoView.o(this.a).top - PhotoView.t(this.a).top, paramFloat2);
                }
              }
              paramFloat1 = f1;
              if (f1 > 0.0F)
              {
                paramFloat1 = f1;
                if (PhotoView.o(this.a).bottom - f1 < PhotoView.t(this.a).bottom) {
                  paramFloat1 = PhotoView.b(this.a, PhotoView.o(this.a).bottom - PhotoView.t(this.a).bottom, f1);
                }
              }
            }
            PhotoView.b(this.a).postTranslate(0.0F, -paramFloat1);
            PhotoView.f(this.a, paramFloat1);
            PhotoView.b(this.a, true);
          }
        }
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.a.postDelayed(PhotoView.j(this.a), 250L);
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */