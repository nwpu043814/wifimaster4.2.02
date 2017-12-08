package com.alipay.android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface IRemoteServiceCallback
  extends IInterface
{
  public abstract boolean isHideLoadingScreen();
  
  public abstract void payEnd(boolean paramBoolean, String paramString);
  
  public abstract void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle);
  
  public static abstract class Stub
    extends Binder
    implements IRemoteServiceCallback
  {
    private static final String DESCRIPTOR = "com.alipay.android.app.IRemoteServiceCallback";
    static final int TRANSACTION_isHideLoadingScreen = 3;
    static final int TRANSACTION_payEnd = 2;
    static final int TRANSACTION_startActivity = 1;
    
    public Stub()
    {
      attachInterface(this, "com.alipay.android.app.IRemoteServiceCallback");
    }
    
    public static IRemoteServiceCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.alipay.android.app.IRemoteServiceCallback");
        if ((localIInterface != null) && ((localIInterface instanceof IRemoteServiceCallback))) {
          paramIBinder = (IRemoteServiceCallback)localIInterface;
        } else {
          paramIBinder = new a(paramIBinder);
        }
      }
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      int i = 0;
      boolean bool1 = false;
      boolean bool2 = true;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      for (;;)
      {
        return bool1;
        paramParcel2.writeString("com.alipay.android.app.IRemoteServiceCallback");
        bool1 = bool2;
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
        String str1 = paramParcel1.readString();
        String str2 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          startActivity(str1, str2, paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          bool1 = bool2;
          break;
        }
        paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        payEnd(bool1, paramParcel1.readString());
        paramParcel2.writeNoException();
        bool1 = bool2;
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
        bool1 = isHideLoadingScreen();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        bool1 = bool2;
      }
    }
    
    private static final class a
      implements IRemoteServiceCallback
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.a;
      }
      
      public final boolean isHideLoadingScreen()
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void payEnd(boolean paramBoolean, String paramString)
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          localParcel2.writeString(paramString);
          this.a.transact(2, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      /* Error */
      public final void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 31
        //   14: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 6
        //   19: aload_1
        //   20: invokevirtual 60	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 6
        //   25: aload_2
        //   26: invokevirtual 60	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   29: aload 6
        //   31: iload_3
        //   32: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   35: aload 4
        //   37: ifnull +49 -> 86
        //   40: aload 6
        //   42: iconst_1
        //   43: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   46: aload 4
        //   48: aload 6
        //   50: iconst_0
        //   51: invokevirtual 68	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   54: aload_0
        //   55: getfield 18	com/alipay/android/app/IRemoteServiceCallback$Stub$a:a	Landroid/os/IBinder;
        //   58: iconst_1
        //   59: aload 6
        //   61: aload 5
        //   63: iconst_0
        //   64: invokeinterface 41 5 0
        //   69: pop
        //   70: aload 5
        //   72: invokevirtual 44	android/os/Parcel:readException	()V
        //   75: aload 5
        //   77: invokevirtual 51	android/os/Parcel:recycle	()V
        //   80: aload 6
        //   82: invokevirtual 51	android/os/Parcel:recycle	()V
        //   85: return
        //   86: aload 6
        //   88: iconst_0
        //   89: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   92: goto -38 -> 54
        //   95: astore_1
        //   96: aload 5
        //   98: invokevirtual 51	android/os/Parcel:recycle	()V
        //   101: aload 6
        //   103: invokevirtual 51	android/os/Parcel:recycle	()V
        //   106: aload_1
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	a
        //   0	108	1	paramString1	String
        //   0	108	2	paramString2	String
        //   0	108	3	paramInt	int
        //   0	108	4	paramBundle	Bundle
        //   8	89	5	localParcel1	Parcel
        //   3	99	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	35	95	finally
        //   40	54	95	finally
        //   54	75	95	finally
        //   86	92	95	finally
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/app/IRemoteServiceCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */