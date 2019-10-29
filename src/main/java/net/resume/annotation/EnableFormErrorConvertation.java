package net.resume.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


//описывает ошибку поля в форме как локальную, тем самым можно определить поле которое вызвало данную ошибку и применить к нему текст ошибки
@Target({ TYPE })
@Retention(RUNTIME)
@Documented
public @interface EnableFormErrorConvertation {

	String formName();
	
	String fieldReference();
	
	Class<? extends Annotation> validationAnnotationClass();
	
	@Target({ TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		EnableFormErrorConvertation[] value();
	}
}
