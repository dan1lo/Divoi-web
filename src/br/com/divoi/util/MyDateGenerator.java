package br.com.divoi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Classe para geração e formatação de datas
 * 
 *
 */
public class MyDateGenerator {

	/**
	 * Converte uma data no formato {@link String} para o formato {@link Date}
	 * 
	 * @param dateString
	 * @return {@link Date}
	 */
	public static Date dateStringToSql(String dateString) {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
		try {
			return format.parse(dateString);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date dateStringToDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;

		try {
			date = formatter.parse(dateString);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public static Date getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFormatted = null;
		try {
			dateFormatted = new java.sql.Date(format.parse(dateFormat.format(date)).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateFormatted;
	}

	public static String dateToString(Date date) {

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		
		String reportDate = df.format(date);
		
		return reportDate;
	}
}
