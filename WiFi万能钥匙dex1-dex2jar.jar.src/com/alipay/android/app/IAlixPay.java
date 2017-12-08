package com.alipay.android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface IAlixPay
  extends IInterface
{
  public abstract String Pay(String paramString);
  
  public abstract String prePay(String paramString);
  
  public abstract void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback);
  
  public abstract String test();
  
  public abstract void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback);
  
  public static abstract class Stub
    extends Binder
    implements IAlixPay
  {
    private static final String DESCRIPTOR = "com.alipay.android.app.IAlixPay";
    static final int TRANSACTION_Pay = 1;
    static final int TRANSACTION_prePay = 5;
    static final int TRANSACTION_registerCallback = 3;
    static final int TRANSACTION_test = 2;
    static final int TRANSACTION_unregisterCallback = 4;
    
    public Stub()
    {
      attachInterface(this, "com.alipay.android.app.IAlixPay");
    }
    
    public static IAlixPay asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.alipay.android.app.IAlixPay");
        if ((localIInterface != null) && ((localIInterface instanceof IAlixPay))) {
          paramIBinder = (IAlixPay)localIInterface;
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
      boolean bool = true;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      for (;;)
      {
        return bool;
        paramParcel2.writeString("com.alipay.android.app.IAlixPay");
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        paramParcel1 = Pay(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        paramParcel1 = test();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        registerCallback(IRemoteServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        unregisterCallback(IRemoteServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        paramParcel1 = prePay(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
      }
    }
    
    private static final class a
      implements IAlixPay
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public final String Pay(String paramString)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          localParcel1.writeString(paramString);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final IBinder asBinder()
      {
        return this.a;
      }
      
      public final String prePay(String paramString)
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          localParcel2.writeString(paramString);
          this.a.transact(5, localParcel2, localParcel1, 0);
          localParcel1.readException();
          paramString = localParcel1.readString();
          return paramString;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      /* Error */
      public final void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 61 1 0
        //   24: astore_1
        //   25: aload_3
        //   26: aload_1
        //   27: invokevirtual 64	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/alipay/android/app/IAlixPay$Stub$a:a	Landroid/os/IBinder;
        //   34: iconst_3
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 42 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 45	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 52	android/os/Parcel:recycle	()V
        //   52: aload_3
        //   53: invokevirtual 52	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_2
        //   64: invokevirtual 52	android/os/Parcel:recycle	()V
        //   67: aload_3
        //   68: invokevirtual 52	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	paramIRemoteServiceCallback	IRemoteServiceCallback
        //   7	57	2	localParcel1	Parcel
        //   3	65	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
      
      public final String test()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public final void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 61 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 64	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/alipay/android/app/IAlixPay$Stub$a:a	Landroid/os/IBinder;
        //   34: iconst_4
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 42 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 45	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 52	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 52	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 52	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 52	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	paramIRemoteServiceCallback	IRemoteServiceCallback
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/app/IAlixPay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */