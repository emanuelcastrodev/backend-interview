package com.store.utils;

import org.springframework.util.ObjectUtils;

public class Masks {

	public static String formatCNJP(String cnpj) {
		if (ObjectUtils.isEmpty(cnpj))
			return null;
		String cleanNumbers = cnpj.replaceAll("[^\\d]", "");
		return cleanNumbers.replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
	}
}
