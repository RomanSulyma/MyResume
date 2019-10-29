package net.resume.repository.storage;

import net.resume.entity.ProfileRestore;
import org.springframework.data.repository.CrudRepository;


public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore, Long> {
	
	ProfileRestore findByToken(String token);
}
