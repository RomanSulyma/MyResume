package net.resume.service.impl;

import net.resume.entity.Profile;
import net.resume.repository.storage.ProfileRepository;
import net.resume.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//кеширует обьекты профиля из БД по указанному имени
@Service
public class CacheServiceImpl implements CacheService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);
	@Autowired
	private ProfileRepository profileRepository;
	//загружает обьект из кеша если он еще не создан
	@Override
	@Cacheable(cacheNames="profile")
	public Profile findProfileByUid(String uid) {
		try {
			LOGGER.debug("Profile not found in cache by uid={}, load profile from repository ", uid);
			return profileRepository.findByUid(uid);
		} finally {
			LOGGER.debug("Profile successful added to cache by uid={}", uid);
		}
	}
	//Удаляет обьект из кеша
	@Override
	@CacheEvict(cacheNames="profile")
	public void deleteProfileByUid(String uid) {
		LOGGER.debug("Profile removed from cache by uid={}", uid);
	}
}
