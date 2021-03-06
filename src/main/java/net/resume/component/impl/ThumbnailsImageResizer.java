package net.resume.component.impl;

import java.io.IOException;
import java.nio.file.Path;

import net.resume.component.ImageResizer;
import org.springframework.stereotype.Component;

import net.coobird.thumbnailator.Thumbnails;

//позволяет изменять размер картинок по шаблону из класса Constants
@Component
public class ThumbnailsImageResizer implements ImageResizer {

	@Override
	public void resizeImage(Path sourceImageFile, Path destImageFile, int width, int height) throws IOException {
		Thumbnails.of(sourceImageFile.toFile()).size(width, height).toFile(destImageFile.toFile());
	}
}
