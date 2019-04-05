/**
 * The locale values match the TSC name in MTP
 * Other locale (not found in MTO) is using three-letter codes referred from https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
 * 
 */
package tvt.selenium.core.locale;

import java.lang.reflect.Field;

import tvt.selenium.core.exception.general.InvalidValueException;

public class WebLocales{

	/**
	 * English - {@value #English}
	 */
	public final static String English = "ENG";
	
	/**
	 * Test - {@value #Test}
	 */
	public final static String Test = "DEV";
	
	
	//Baseline Translation Languages (8)
	/**
	 * Group 1 - Baseline Translation Languages - {@value #German}
	 */
	public final static String German = "GER";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #French}
	 */
	public final static String French = "FRE";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #Italian}
	 */
	public final static String Italian = "ITA";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #Spanish}
	 */
	public final static String Spanish = "SPA";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #BrazilianPortuguese}
	 */
	public final static String BrazilianPortuguese = "BPO";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #Japanese}
	 */
	public final static String Japanese = "JPN";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #SimplifiedChinese}
	 */
	public final static String SimplifiedChinese = "CHS";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #TraditionalChinese}
	 */
	public final static String TraditionalChinese = "CHT";
	//Others
	/**
	 * Group 1 - {@value #Korean}
	 */
	public final static String Korean = "KOR";
	/**
	 * Group 1 - {@value #Russian}
	 */
	public final static String Russian = "RUS";
	
	
	/**
	 * Group 2
	 */
	//BiDi (2)
	/**
	 * Group 2 - {@value #Arabic}
	 */
	public final static String Arabic = "ARA";
	/**
	 * Group 2 - {@value #Hebrew}
	 */
	public final static String Hebrew = "HEB";
	//Common languages in Security Products
	/**
	 * Group 2 - {@value #Finnish}
	 */
	public final static String Finnish = "FIN";
	/**
	 * Group 2 - {@value #Danish}
	 */
	public final static String Danish = "DAN";
	/**
	 * Group 2 - {@value #Dutch}
	 */
	public final static String Dutch = "DUT";
	/**
	 * Group 2 - {@value #Turkish}
	 */
	public final static String Turkish = "TUR";
	/**
	 * Group 2 - {@value #Greek}
	 */
	public final static String Greek = "ELL";
	//Others
	/**
	 * Group 2 - {@value #Catalan}
	 */
	public final static String Catalan = "CAT";
	/**
	 * Group 2 - {@value #NorwegianBokmal}
	 */
	public final static String NorwegianBokmal = "NOR";
	/**
	 * Group 2 - {@value #PortugalPortuguese}
	 */
	public final static String PortugalPortuguese = "PTG";
	/**
	 * Group 2 - {@value #Swedish}
	 */
	public final static String Swedish = "SVE";
	/**
	 * Group 2 - {@value #Thai}
	 */
	public final static String Thai = "THA";
	
	/**
	 * Group 3
	 */
	//Common languages in Security Products
	/**
	 * Group 3 - {@value #Czech}
	 */
	public final static String Czech = "CSY";
	/**
	 * Group 3 - {@value #Polish}
	 */
	public final static String Polish = "POL";
	/**
	 * Group 3 - {@value #Hungarian}
	 */
	public final static String Hungarian = "HUN";
	//Others
	/**
	 * Group 3 - {@value #Bulgarian}
	 */
	public final static String Bulgarian = "BGR";
	/**
	 * Group 3 - {@value #Croatian}
	 */
	public final static String Croatian = "HRV";
	/**
	 * Group 3 - {@value #Icelandic}
	 */
	public final static String Icelandic = "ICE";
	/**
	 * Group 3 - {@value #Kazakh}
	 */
	public final static String Kazakh = "KAZ";
	/**
	 * Group 3 - {@value #Romanian}
	 */
	public final static String Romanian = "ROM";
	/**
	 * Group 3 - {@value #Slovak}
	 */
	public final static String Slovak = "SKY";
	/**
	 * Group 3 - {@value #Slovenian}
	 */
	public final static String Slovenian = "SLO";
	/**
	 * Group 3 - {@value #Ukrainian}
	 */
	public final static String Ukrainian = "UKR";
	
	/**
	 * Special
	 */
	/**
	 * Group others - {@value #Belarusian}
	 */
	public final static String Belarusian = "BEL";
	/**
	 * Group others - {@value #Bosnian}
	 */
	public final static String Bosnian = "BOS";
	/**
	 * Group others - {@value #SwissGerman}
	 */
	public final static String SwissGerman = "SWG";
	/**
	 * Group others - {@value #UKEnglish}
	 */
	public final static String UKEnglish = "UKE";
	/**
	 * Group others - {@value #Estonian}
	 */
	public final static String Estonian = "EST";
	/**
	 * Group others - {@value #Basque}
	 */
	public final static String Basque = "BAQ";
	/**
	 * Group others - {@value #BelgianFrench}
	 */
	public final static String BelgianFrench = "BFR";
	/**
	 * Group others - {@value #CanadianFrench}
	 */
	public final static String CanadianFrench = "CFR";
	/**
	 * Group others - {@value #SwissFrench}
	 */
	public final static String SwissFrench = "SWF";
	/**
	 * Group others - {@value #CroatianSRC}
	 */
	public final static String CroatianSRC = "SRC";
	/**
	 * Group others - {@value #Indonesian}
	 */
	public final static String Indonesian = "IND";
	/**
	 * Group others - {@value #SwissItalian}
	 */
	public final static String SwissItalian = "SWI";
	/**
	 * Group others - {@value #Lithuanian}
	 */
	public final static String Lithuanian = "LTU";
	/**
	 * Group others - {@value #Latvian}
	 */
	public final static String Latvian = "LVA";
	/**
	 * Group others - {@value #Macedonian}
	 */
	public final static String Macedonian = "MKD";
	/**
	 * Group others - {@value #Mongolian}
	 */
	public final static String Mongolian = "MON";
	/**
	 * Group others - {@value #Malay}
	 */
	public final static String Malay = "ZLM";
	/**
	 * Group others - {@value #BelgianDutch}
	 */
	public final static String BelgianDutch = "BDU";
	/**
	 * Group others - {@value #Serbian}
	 */
	public final static String Serbian = "SRB";
	/**
	 * Group others - {@value #Montenegrin}
	 */
	public final static String Montenegrin = "SER";
	/**
	 * Group others - {@value #Vietnamese}
	 */
	public final static String Vietnamese = "VIT";
	
	/**
	 * Not found on MTP
	 */
	/**
	 * Group not found - {@value #Afrikaans}
	 */
	public final static String Afrikaans = "AFR";
	/**
	 * Group not found - {@value #Albanian}
	 */
	public final static String Albanian = "SQI";
	/**
	 * Group not found - {@value #Azerbajiani}
	 */
	public final static String Azerbajiani = "AZE";
	/**
	 * Group not found - {@value #CanadianEnglish}
	 */
	public final static String CanadianEnglish = "CAE";
	/**
	 * Group not found - {@value #Farsi}
	 */
	public final static String Farsi = "FAS";
	/**
	 * Group not found - {@value #Filipino}
	 */
	public final static String Filipino = "FIL";
	/**
	 * Group not found - {@value #Hindi}
	 */
	public final static String Hindi = "HIN";
	/**
	 * Group not found - {@value #LatinAmericanSpanish}
	 */
	public final static String LatinAmericanSpanish = "LAS";
	/**
	 * Group not found - {@value #Sinhalese}
	 */
	public final static String Sinhalese = "SIN";
	/**
	 * Group not found - {@value #Swahili}
	 */
	public final static String Swahili = "SWA";
	/**
	 * Group not found - {@value #Tagalog}
	 */
	public final static String Tagalog = "TGL";
	/**
	 * Group not found - {@value #Urdu}
	 */
	public final static String Urdu = "URD";
	/**
	 * Group not found - {@value #Uzbek}
	 */
	public final static String Uzbek = "UZB";
	
	/*
	 * Other TSC supported languages which are not added to the list above. 
	 * 
	 * Azerbaijan(Russian TSC), Byelorussian(Russian TSC)
	 * 
	 */
	
	public static boolean hasLocale(String localeText){
		for(Field locale : WebLocales.class.getDeclaredFields()){
			try {
				
				if (localeText.equals((String)locale.get(WebLocales.class))) return true;
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
    
	public static String toBrowserLocale(String localeText){
		return convertTo(localeText,BrowserLocales.class);
	}
	
	public static String convertTo(String localeText,Class<?> localesClass){
		for(Field locale : WebLocales.class.getDeclaredFields()){
			try {
				if (localeText.equals((String)locale.get(WebLocales.class))){
					String name = locale.getName();
					for(Field browser : localesClass.getDeclaredFields()){
						try {
							if (name.equals(browser.getName())){
								String value = (String)browser.get(localesClass);
								if(value != null && !value.isEmpty()){
									return value;
								}else{
									throw new InvalidValueException("Varialbe with name '"+name+"' is null or empty in "+localesClass.toString());
								}
							}
						} catch (IllegalArgumentException | IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					throw new InvalidValueException("Varialbe with name '"+name+"' is not found in "+localesClass.toString());
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		throw new InvalidValueException(localeText+" is not found in "+WebLocales.class.toString());
	}
    

}
