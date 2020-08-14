package org.monet.bpi.java;

import org.monet.bpi.NewsService;
import org.monet.bpi.Post;
import org.monet.bpi.Task;

public class NewsServiceImpl extends NewsService {

	@Override
	protected void commentPostImpl(Post post, String text, String author) {

	}

	@Override
	protected void postToUserImpl(Post post, String userId) {

	}

	@Override
	protected void postAndNotifyToUserImpl(Post post, String userId) {

	}

	@Override
	protected void postToRoleImpl(Post post, String role) {

	}

	@Override
	protected void postAndNotifyToRoleImpl(Post post, String role) {

	}

	@Override
	protected void postToTaskTeamImpl(Post post, Task task) {

	}

	@Override
	protected void postAndNotifyToTaskTeamImpl(Post post, Task task) {

	}

	@Override
	protected void postToAllImpl(Post post) {

	}

	@Override
	protected void postAndNotifyToAllImpl(Post post) {

	}
}