package net.resume.component;

import java.lang.annotation.Annotation;

import javax.annotation.Nonnull;

import org.springframework.validation.BindingResult;


public interface FormErrorConverter {

	void convertFormErrorToFieldError(@Nonnull Class<? extends Annotation> validationAnnotationClass, @Nonnull Object formInstance, @Nonnull BindingResult bindingResult);
}
