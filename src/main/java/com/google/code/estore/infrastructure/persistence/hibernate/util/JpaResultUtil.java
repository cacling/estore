package com.google.code.estore.infrastructure.persistence.hibernate.util;

import java.util.ArrayList;
import java.util.List;

public class JpaResultUtil {
	
	@SuppressWarnings("rawtypes")
	public static List getExtractedResults(List<Object[]> results, int extractIdx) {
		List extractedResults = new ArrayList();
		for (Object[] result : results) {
		    extractedResults.add(result[extractIdx]);
		}
		return extractedResults;
	}

}
