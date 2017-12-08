package bluefay.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.bluefay.c.a.a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class q
  extends d<Preference, PreferenceGroup>
{
  private r b;
  
  public q(Context paramContext, r paramr)
  {
    super(paramContext);
    this.b = paramr;
    a("bluefay.preference.");
  }
  
  private boolean a(XmlPullParser paramXmlPullParser, Preference paramPreference, AttributeSet paramAttributeSet)
  {
    boolean bool2 = true;
    String str = paramXmlPullParser.getName();
    if (str.equals("intent")) {}
    for (;;)
    {
      boolean bool1;
      try
      {
        paramXmlPullParser = Intent.parseIntent(a().getResources(), paramXmlPullParser, paramAttributeSet);
        bool1 = bool2;
        if (paramXmlPullParser != null)
        {
          paramPreference.a(paramXmlPullParser);
          bool1 = bool2;
        }
        return bool1;
      }
      catch (IOException paramXmlPullParser)
      {
        paramPreference = new XmlPullParserException("Error parsing preference");
        paramPreference.initCause(paramXmlPullParser);
        throw paramPreference;
      }
      if (str.equals("extra"))
      {
        a().getResources().parseBundleExtra("extra", paramAttributeSet, paramPreference.m());
        try
        {
          a.a(paramXmlPullParser);
          bool1 = bool2;
        }
        catch (IOException paramPreference)
        {
          paramXmlPullParser = new XmlPullParserException("Error parsing preference");
          paramXmlPullParser.initCause(paramPreference);
          throw paramXmlPullParser;
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */