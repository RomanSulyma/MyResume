package net.resume.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;


//указывает на поле которое будет использовано как информация о себе в профиле, в entity
@Retention(RUNTIME)
public @interface ProfileInfoField {

}
