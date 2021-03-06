package bluefay.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface StringDef
{
  String[] value() default {};
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/support/annotation/StringDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */