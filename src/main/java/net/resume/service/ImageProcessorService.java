package net.resume.service;

import javax.annotation.Nonnull;

import org.springframework.web.multipart.MultipartFile;

import net.resume.model.UploadCertificateResult;
import net.resume.model.UploadResult;

//сервис для создания из Multipart готового файла(картинка) и вернуть ссылку на саму картинку
public interface ImageProcessorService {

	@Nonnull UploadResult processNewProfilePhoto(@Nonnull MultipartFile uploadPhoto);

	@Nonnull UploadCertificateResult processNewCertificateImage(@Nonnull MultipartFile uploadCertificateImage);
}
