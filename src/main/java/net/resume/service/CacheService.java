package net.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.resume.entity.Profile;

//проверяет наличие профиля в кеше и если есть , то загружает из кеша, если нету то добавляет в кеш из БД , так же может удалять профили из кеша
public interface CacheService {

	@Nullable Profile findProfileByUid(@Nonnull String uid);
	
	void deleteProfileByUid(@Nonnull String uid);
}
