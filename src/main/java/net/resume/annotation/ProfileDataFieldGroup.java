package net.resume.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;


//после того как пометим поля в классе PRofile при запросе данной формы при изменение личных данных обновит в Entity поля помеченные данной аннотацией
@Retention(RUNTIME)
public @interface ProfileDataFieldGroup {

}
