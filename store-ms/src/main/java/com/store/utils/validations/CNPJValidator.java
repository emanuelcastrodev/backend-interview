package com.store.utils.validations;

import com.store.utils.validations.interfaces.CNPJ;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CNPJValidator implements ConstraintValidator<CNPJ, String> {

	@Override
	public void initialize(CNPJ cnpj) {
		System.out.println(cnpj);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		value = value.replaceAll("[^\\d]", "");
		if (value.equals("00000000000000") || value.equals("11111111111111") || value.equals("22222222222222")
				|| value.equals("33333333333333") || value.equals("44444444444444") || value.equals("55555555555555")
				|| value.equals("66666666666666") || value.equals("77777777777777") || value.equals("88888888888888")
				|| value.equals("99999999999999") || !value.matches("\\d{14}"))
			return false;
		char dig13, dig14;
		int sm, i, r, num, peso;
		try {

			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {

				num = (int) (value.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (value.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			if ((dig13 == value.charAt(12)) && (dig14 == value.charAt(13)))
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}

}
