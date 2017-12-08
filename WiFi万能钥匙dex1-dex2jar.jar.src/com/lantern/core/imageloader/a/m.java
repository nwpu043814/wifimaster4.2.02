package com.lantern.core.imageloader.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;

final class m
  extends ai
{
  private static final UriMatcher a;
  private final Context b;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    a = localUriMatcher;
    localUriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    a.addURI("com.android.contacts", "contacts/lookup/*", 1);
    a.addURI("com.android.contacts", "contacts/#/photo", 2);
    a.addURI("com.android.contacts", "contacts/#", 3);
    a.addURI("com.android.contacts", "display_photo/#", 4);
  }
  
  m(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public final boolean a(ag paramag)
  {
    Uri localUri = paramag.a;
    if (("content".equals(localUri.getScheme())) && (ContactsContract.Contacts.CONTENT_URI.getHost().equals(localUri.getHost())) && (a.match(paramag.a) != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final ai.a b(ag paramag)
  {
    ContentResolver localContentResolver = this.b.getContentResolver();
    Uri localUri = paramag.a;
    paramag = localUri;
    switch (a.match(localUri))
    {
    default: 
      throw new IllegalStateException("Invalid uri: " + localUri);
    case 1: 
      localUri = ContactsContract.Contacts.lookupContact(localContentResolver, localUri);
      paramag = localUri;
      if (localUri == null)
      {
        paramag = null;
        if (paramag == null) {
          break label144;
        }
      }
      break;
    }
    label144:
    for (paramag = new ai.a(paramag, aa.d.b);; paramag = null)
    {
      return paramag;
      if (Build.VERSION.SDK_INT < 14)
      {
        paramag = ContactsContract.Contacts.openContactPhotoInputStream(localContentResolver, paramag);
        break;
      }
      paramag = ContactsContract.Contacts.openContactPhotoInputStream(localContentResolver, paramag, true);
      break;
      paramag = localContentResolver.openInputStream(localUri);
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */