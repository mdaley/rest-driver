/**
 * Copyright © 2010-2011 Nokia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.restdriver.serverdriver;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import com.github.restdriver.serverdriver.http.response.Response;
import com.github.restdriver.serverdriver.matchers.HasHeader;
import com.github.restdriver.serverdriver.matchers.HasHeaderWithValue;
import com.github.restdriver.serverdriver.matchers.HasResponseBody;
import com.github.restdriver.serverdriver.matchers.HasStatusCode;

/**
 * Class to help easy & fluent use of our matchers.
 */
public final class Matchers {

    private Matchers() {
    }

    /**
     * Creates a new instance of HasStatusCode.
     * 
     * @param statusCode
     *            The status code to match
     * @return The new matcher
     */
    public static TypeSafeMatcher<Response> hasStatusCode(int statusCode) {
        return new HasStatusCode(is(statusCode));
    }

    /**
     * Creates a new instance of HasStatusCode.
     * 
     * @param statusCodeMatcher
     *            The matcher against which the status code will be evaluated
     * @return The new matcher
     */
    public static TypeSafeMatcher<Response> hasStatusCode(Matcher<Integer> statusCodeMatcher) {
        return new HasStatusCode(statusCodeMatcher);
    }

    /**
     * Creates a new instance of HasResponseBody.
     * 
     * @param bodyMatcher
     *            The matcher against which the response body will be evaluated
     * @return The new matcher
     */
    public static TypeSafeMatcher<Response> hasResponseBody(Matcher<String> bodyMatcher) {
        return new HasResponseBody(bodyMatcher);
    }

    /**
     * Creates a new instance of HasHeader.
     * 
     * @param name
     *            The name of the header to check for the presence of
     * @return The new matcher
     */
    public static TypeSafeMatcher<Response> hasHeader(String name) {
        return new HasHeader(name);
    }

    /**
     * Creates a new instance of HasHeaderWithValue.
     * 
     * @param name
     *            The name of the header to check for the presence and value of
     * @param valueMatcher
     *            The matcher against which the header value will be evaluated
     * @return The new matcher
     */
    public static TypeSafeMatcher<Response> hasHeaderWithValue(String name, Matcher<String> valueMatcher) {
        return new HasHeaderWithValue(name, valueMatcher);
    }

}