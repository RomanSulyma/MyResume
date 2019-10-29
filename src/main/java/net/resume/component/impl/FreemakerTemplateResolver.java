package net.resume.component.impl;

import java.io.IOException;
import java.io.StringReader;

import net.resume.component.TemplateResolver;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


//реализация получателя шаблонов, для отправки почтовых сообщений, который вытягивает из них нужные данные
@Component
public class FreemakerTemplateResolver implements TemplateResolver {

	@Override
	public String resolve(String stringTemplate, Object model) {
		try {
			Template template = new Template("", new StringReader(stringTemplate), new Configuration(Configuration.VERSION_2_3_0));
			return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
		} catch (IOException | TemplateException e) {
			throw new IllegalArgumentException("Can't resolve string template: " + e.getMessage(), e);
		}
	}
}
