package net.resume.component.impl;

import net.resume.component.DataBuilder;
import net.resume.util.DataUtil;
import org.springframework.stereotype.Component;


//позволяет строить такие обьекты как UID пользователя , ссылку на восстановление и перестраивать UID , а так же строить имя сертификата
@Component
public class DataBuilderImpl implements DataBuilder {
	private static final String UID_DELIMETER = "-";
	
	@Override
	public String buildProfileUid(String firstName, String lastName) {
		return DataUtil.normalizeName(firstName) + UID_DELIMETER + DataUtil.normalizeName(lastName);
	}

	@Override
	public String buildRestoreAccessLink(String appHost, String token) {
		return appHost + "/restore/" + token;
	}

	@Override
	public String rebuildUidWithRandomSuffix(String baseUid, String alphabet, int letterCount) {
		return baseUid + UID_DELIMETER + DataUtil.generateRandomString(alphabet, letterCount);
	}

	@Override
	public String buildCertificateName(String fileName) {
		if (fileName == null) {
			return null;
		}
		int point = fileName.lastIndexOf('.');
		if (point != -1) {
			fileName = fileName.substring(0, point);
		}
		return DataUtil.capitalizeName(fileName);
	}
}
