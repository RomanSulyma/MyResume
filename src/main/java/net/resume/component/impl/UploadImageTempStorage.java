package net.resume.component.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import net.resume.exception.CantCompleteClientRequestException;
import net.resume.model.UploadTempPath;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UploadImageTempStorage {
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadImageTempStorage.class);
	private final ThreadLocal<UploadTempPath> currentUploadTempPath = new ThreadLocal<>();

	public UploadTempPath getCurrentUploadTempPath() {
		return currentUploadTempPath.get();
	}
	//обворачиваем все классы помеченные данной аннотацией , а так же в случае ошибки удаляем временный файл
	@Around("@annotation(net.resume.annotation.EnableUploadImageTempStorage)")
	public Object advice(ProceedingJoinPoint pjp) throws Throwable {
		UploadTempPath uploadTempPath = null;
		try {
			uploadTempPath = new UploadTempPath();
			currentUploadTempPath.set(uploadTempPath);
			LOGGER.debug("Before method: {}", pjp.getSignature());
			return pjp.proceed();
		} catch (IOException e) {
			throw new CantCompleteClientRequestException("Can't create temp image files: " + e.getMessage(), e);
		} finally {
			LOGGER.debug("After method: {}", pjp.getSignature());
			currentUploadTempPath.remove();
			if (uploadTempPath != null) {
				deleteQuietly(uploadTempPath.getLargeImagePath());
				deleteQuietly(uploadTempPath.getSmallImagePath());
			}
		}
	}
	//непосредственно удаляет файлы
	protected void deleteQuietly(Path path) {
		try {
			Files.deleteIfExists(path);
			LOGGER.debug("Delete temp file {} successful", path);
		} catch (Exception e) {
			LOGGER.warn("Can't remove temp file: " + path, e);
		}
	}
}
