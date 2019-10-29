package net.resume.repository.storage;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

//Репозиторий для базовых операций со всеми обьектами
@NoRepositoryBean
public interface AbstractProfileEntityRepository<T> extends Repository<T, Long> {

	void deleteByProfileId(Long idProfile);
	
	List<T> findByProfileIdOrderByIdAsc(Long idProfile);
	
	<S extends T> S saveAndFlush(S entity);
	
	void flush();
}
