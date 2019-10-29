package net.resume.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import net.resume.entity.Hobby;
import net.resume.model.LanguageLevel;
import net.resume.model.LanguageType;

//сервис для обработки всех статических данных
public interface StaticDataService {

	@Nonnull Set<Hobby> listAllHobbies();
	
	@Nonnull List<Hobby> createHobbyEntitiesByNames(@Nonnull List<String> names);
	
	@Nonnull Map<Integer, String> mapMonths();
	
	@Nonnull List<Integer> listPracticsYears();
	
	@Nonnull List<Integer> listCourcesYears();
	
	@Nonnull List<Integer> listEducationYears();
	
	@Nonnull Collection<LanguageType> getAllLanguageTypes(); 
	
	@Nonnull Collection<LanguageLevel> getAllLanguageLevels();
}
