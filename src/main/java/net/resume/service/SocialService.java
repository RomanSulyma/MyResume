package net.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.resume.entity.Profile;
//сервис для получения профиля при помощи соц.сети
public interface SocialService<T> {

	@Nullable Profile loginOrSignup(@Nonnull T model);
}
