package net.resume.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;


//добавляет аспект UploadImage к классу который помечен аннотацией
@Retention(RUNTIME)
public @interface EnableUploadImageTempStorage {

}
