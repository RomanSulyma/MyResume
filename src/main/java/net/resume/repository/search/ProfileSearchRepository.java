package net.resume.repository.search;

import net.resume.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

//Формирует запрос на поиск по какому либо параметру
public interface ProfileSearchRepository extends ElasticsearchRepository<Profile, Long> {


	Page<Profile> findByObjectiveLikeOrSummaryLikeOrInfoLikeOrCertificatesNameLikeOrLanguagesNameLikeOrPracticsCompanyLikeOrPracticsPositionLikeOrPracticsResponsibilitiesLikeOrSkillsValueLike(
			String objective, String info, String summary, String certificateName, String languageName, String practicCompany, 
			String practicPosition, String practicResponsibility, String skillValue, Pageable pageable);
	
}
