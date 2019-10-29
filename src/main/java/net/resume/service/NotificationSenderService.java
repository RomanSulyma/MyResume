package net.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.resume.entity.Profile;
import net.resume.model.NotificationMessage;

//куда и каким образом отправлять уведомления
public interface NotificationSenderService {

	void sendNotification(@Nonnull NotificationMessage message);

	@Nullable String getDestinationAddress(@Nonnull Profile profile);
}
