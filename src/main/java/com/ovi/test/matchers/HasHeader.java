package com.ovi.test.matchers;

import org.apache.commons.lang.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.ovi.test.http.Header;
import com.ovi.test.http.Response;

public class HasHeader extends TypeSafeMatcher<Response> {

	private final String name;

	public HasHeader(final String name) {
		this.name = name;
	}

	@Override
	protected final boolean matchesSafely(final Response response) {

		for (final Header header : response.getHeaders()) {
			if (StringUtils.equals(header.getName(), name)) {
				return true;
			}
		}

		return false;

	}

	@Override
	public final void describeTo(final Description description) {
		description.appendText("Response with header named '" + name + "'");
	}

	@Override
	protected final void describeMismatchSafely(final Response response, final Description mismatchDescription) {
		final Header[] headers = response.getHeaders();

		if (headers.length == 0) {
			mismatchDescription.appendText("Response has no headers");
		} else {
			mismatchDescription.appendText("Response has headers [" + StringUtils.join(response.getHeaders(), ",") + "]");
		}
	}

}
