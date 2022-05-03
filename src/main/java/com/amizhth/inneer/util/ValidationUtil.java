package com.amizhth.inneer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

	public static boolean validateMobileNumber(String mobileNumber) {
		Pattern ptrn = Pattern.compile("(0|91)?[7-9][0-9]{9}");
		Matcher match = ptrn.matcher(mobileNumber);
		return (match.find() && match.group().equals(mobileNumber));
	}
	
}
