package net.resume.component.impl;

import net.resume.component.TranslitConverter;
import org.springframework.stereotype.Component;

import net.sf.junidecode.Junidecode;

//позволяет конвертировать русские символы в английские
@Component
public class JunidecodeTranslitConverter implements TranslitConverter {

	@Override
	public String translit(String text) {
		return Junidecode.unidecode(text);
	}
}
