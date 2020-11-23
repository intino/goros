package org.monet.bpi.java;

import org.monet.bpi.FileService;
import org.monet.bpi.types.File;

public class FileServiceImpl extends FileService {

	@Override
	public File getResourcesDirImpl() {
		return null;
	}

	@Override
	public File getResourcesDataDirImpl() {
		return null;
	}

	@Override
	public File getResourcesImagesDirImpl() {
		return null;
	}

	public static void init() {
		instance = new FileServiceImpl();
	}

}
