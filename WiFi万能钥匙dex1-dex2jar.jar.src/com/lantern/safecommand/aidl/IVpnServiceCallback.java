package com.lantern.safecommand.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface IVpnServiceCallback
  extends IInterface
{
  public abstract void onStateChanged(ConnectionStateNotify paramConnectionStateNotify);
  
  public abstract void refreshConnectionStateDone();
  
  public static abstract class Stub
    extends Binder
    implements IVpnServiceCallback
  {
    private static final String DESCRIPTOR = "com.lantern.safecommand.aidl.IVpnServiceCallback";
    static final int TRANSACTION_onStateChanged = 1;
    static final int TRANSACTION_refreshConnectionStateDone = 2;
    
    public Stub()
    {
      attachInterface(this, "com.lantern.safecommand.aidl.IVpnServiceCallback");
    }
    
    public static IVpnServiceCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.lantern.safecommand.aidl.IVpnServiceCallback");
        if ((localIInterface != null) && ((localIInterface instanceof IVpnServiceCallback))) {
          paramIBinder = (IVpnServiceCallback)localIInterface;
        } else {
          paramIBinder = new Proxy(paramIBinder);
        }
      }
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      boolean bool;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      for (;;)
      {
        return bool;
        paramParcel2.writeString("com.lantern.safecommand.aidl.IVpnServiceCallback");
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.lantern.safecommand.aidl.IVpnServiceCallback");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (ConnectionStateNotify)ConnectionStateNotify.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onStateChanged(paramParcel1);
          paramParcel2.writeNoException();
          bool = true;
          break;
        }
        paramParcel1.enforceInterface("com.lantern.safecommand.aidl.IVpnServiceCallback");
        refreshConnectionStateDone();
        bool = true;
      }
    }
    
    private static class Proxy
      implements IVpnServiceCallback
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.lantern.safecommand.aidl.IVpnServiceCallback";
      }
      
      /* Error */
      public void onStateChanged(ConnectionStateNotify paramConnectionStateNotify)
      {
        // Byte code:
        //   0: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 48	com/lantern/safecommand/aidl/ConnectionStateNotify:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/lantern/safecommand/aidl/IVpnServiceCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_1
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 54 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 57	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 60	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 60	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 60	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 60	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	Proxy
        //   0	75	1	paramConnectionStateNotify	ConnectionStateNotify
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      public void refreshConnectionStateDone()
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.lantern.safecommand.aidl.IVpnServiceCallback");
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/aidl/IVpnServiceCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */