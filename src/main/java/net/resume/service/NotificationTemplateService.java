package net.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.resume.model.NotificationMessage;
//формирует сообщение по шаблону
public interface NotificationTemplateService {

	@Nonnull NotificationMessage createNotificationMessage (@Nonnull String templateName, @Nullable Object model);
}
