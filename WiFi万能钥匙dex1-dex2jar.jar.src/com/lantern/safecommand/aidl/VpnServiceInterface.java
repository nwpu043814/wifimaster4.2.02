package com.lantern.safecommand.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface VpnServiceInterface
  extends IInterface
{
  public abstract void refreshConnectionState();
  
  public abstract void registerCallback(IVpnServiceCallback paramIVpnServiceCallback);
  
  public abstract void startVpn();
  
  public abstract void stopVpn();
  
  public abstract void uiBackToFront();
  
  public abstract void unregisterCallback(IVpnServiceCallback paramIVpnServiceCallback);
  
  public static abstract class Stub
    extends Binder
    implements VpnServiceInterface
  {
    private static final String DESCRIPTOR = "com.lantern.safecommand.aidl.VpnServiceInterface";
    static final int TRANSACTION_refreshConnectionState = 6;
    static final int TRANSACTION_registerCallback = 1;
    static final int TRANSACTION_startVpn = 3;
    static final int TRANSACTION_stopVpn = 4;
    static final int TRANSACTION_uiBackToFront = 5;
    static final int TRANSACTION_unregisterCallback = 2;
    
    public Stub()
    {
      attachInterface(this, "com.lantern.safecommand.aidl.VpnServiceInterface");
    }
    
    public static VpnServiceInterface asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.lantern.safecommand.aidl.VpnServiceInterface");
        if ((localIInterface != null) && ((localIInterface instanceof VpnServiceInterface))) {
          paramIBinder = (VpnServiceInterface)localIInterface;
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
      boolean bool = true;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      for (;;)
      {
        return bool;
        paramParcel2.writeString("com.lantern.safecommand.aidl.VpnServiceInterface");
        continue;
        paramParcel1.enforceInterface("com.lantern.safecommand.aidl.VpnServiceInterface");
        registerCallback(IVpnServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        continue;
        paramParcel1.enforceInterface("com.lantern.safecommand.aidl.VpnServiceInterface");
        unregisterCallback(IVpnServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        continue;
        paramParcel1.enforceInterface("com.lantern.safecommand.aidl.VpnServiceInterface");
        startVpn();
        continue;
        paramParcel1.enforceInterface("com.lantern.safecommand.aidl.VpnServiceInterface");
        stopVpn();
        continue;
        paramParcel1.enforceInterface("com.lantern.safecommand.aidl.VpnServiceInterface");
        uiBackToFront();
        continue;
        paramParcel1.enforceInterface("com.lantern.safecommand.aidl.VpnServiceInterface");
        refreshConnectionState();
      }
    }
    
    private static class Proxy
      implements VpnServiceInterface
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
        return "com.lantern.safecommand.aidl.VpnServiceInterface";
      }
      
      public void refreshConnectionState()
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.lantern.safecommand.aidl.VpnServiceInterface");
          this.mRemote.transact(6, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void registerCallback(IVpnServiceCallback paramIVpnServiceCallback)
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.lantern.safecommand.aidl.VpnServiceInterface");
          if (paramIVpnServiceCallback != null) {
            localIBinder = paramIVpnServiceCallback.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void startVpn()
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.lantern.safecommand.aidl.VpnServiceInterface");
          this.mRemote.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void stopVpn()
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.lantern.safecommand.aidl.VpnServiceInterface");
          this.mRemote.transact(4, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void uiBackToFront()
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.lantern.safecommand.aidl.VpnServiceInterface");
          this.mRemote.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void unregisterCallback(IVpnServiceCallback paramIVpnServiceCallback)
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.lantern.safecommand.aidl.VpnServiceInterface");
          if (paramIVpnServiceCallback != null) {
            localIBinder = paramIVpnServiceCallback.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/aidl/VpnServiceInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */