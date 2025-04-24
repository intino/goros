package io.intino.goros.unit.util;

import io.intino.alexandria.Resource;
import io.intino.alexandria.logger.Logger;

import java.io.IOException;
import java.io.InputStream;

public class ResourceHelper {

	public static InputStream streamOf(Resource resource) {
		try {
			return resource.stream();
		} catch (IOException e) {
			Logger.error(e);
			return null;
		}
	}

}
