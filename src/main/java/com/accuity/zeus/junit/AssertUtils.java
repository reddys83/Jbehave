package com.accuity.zeus.junit;

import org.apache.commons.lang3.StringUtils;

import static org.junit.Assert.*;

public class AssertUtils {

	public static void assertEqualsOrIsExpectedBlank(String expected, String actual) {
		if (StringUtils.isBlank(expected)) {
			assertTrue(StringUtils.isBlank(actual));
		} else {
			assertEquals(expected, actual);
		}
	}
}
