package br.com.fiap.gs1.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	private static DateTimeFormatter dateFormatDefault = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static final String regexFormatDefault = "([1-2][0-9]|[0][1-9]|[3][0-1])\\\\/([0][1-9]|[1][0-2])\\\\/[1-9][0-9][0-9]{2}";

	public static LocalDate somarDias(LocalDate inicial, long dias) {
		return inicial.plusDays(dias);
	}

	public static LocalDate getFromString(String dataString) {
		return LocalDate.parse(dataString, dateFormatDefault);
	}

	public static String getFormatted(LocalDate dataDecolagem) {
		return dataDecolagem.format(dateFormatDefault);
	}

}
