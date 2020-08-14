package org.monet.bpi.java;

import org.monet.bpi.JobResponse;
import org.monet.bpi.Schema;
import org.monet.bpi.SensorResponse;
import org.monet.bpi.types.*;

import java.util.List;

public class JobResponseImpl extends ProviderResponseImpl implements JobResponse, SensorResponse {

	@Override
	public Date getStartDate() {
		return null;
	}

	@Override
	public Date getEndDate() {
		return null;
	}

	@Override
	public Schema getSchema() {
		return null;
	}

	@Override
	public File getFile(FileLink link) {
		return null;
	}

	@Override
	public List<File> getFiles(List<FileLink> links) {
		return null;
	}

	@Override
	public Picture getPicture(PictureLink link) {
		return null;
	}

	@Override
	public List<Picture> getPictures(List<PictureLink> links) {
		return null;
	}

	@Override
	public Video getVideo(VideoLink link) {
		return null;
	}

	@Override
	public List<Video> getVideos(List<VideoLink> links) {
		return null;
	}
}
