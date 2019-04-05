/**
 * Only the Baseline Translation Languages locale values is pre-configured with browser locales.
 * 
 */
package tvt.selenium.core.locale;

import java.lang.reflect.Field;

public class LocalesTemplate{

	/**
	 * English - {@value #English}
	 */
	public final static String English = "en";
	
	/**
	 * Test - {@value #Test}
	 */
	public static String Test = "ja";
	
	
	//Baseline Translation Languages (8)
	/**
	 * Group 1 - Baseline Translation Languages - {@value #German}
	 */
	public final static String German = "de";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #French}
	 */
	public final static String French = "fr";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #Italian}
	 */
	public final static String Italian = "it";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #Spanish}
	 */
	public final static String Spanish = "es-ES";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #BrazilianPortuguese}
	 */
	public final static String BrazilianPortuguese = "pt-BR";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #Japanese}
	 */
	public final static String Japanese = "ja";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #SimplifiedChinese}
	 */
	public final static String SimplifiedChinese = "zh-CN";
	/**
	 * Group 1 - Baseline Translation Languages - {@value #TraditionalChinese}
	 */
	public final static String TraditionalChinese = "zh-TW";
	//Others
	/**
	 * Group 1 - {@value #Korean}
	 */
	public final static String Korean = "";
	/**
	 * Group 1 - {@value #Russian}
	 */
	public final static String Russian = "";
	
	
	/**
	 * Group 2
	 */
	//BiDi (2)
	/**
	 * Group 2 - {@value #Arabic}
	 */
	public final static String Arabic = "";
	/**
	 * Group 2 - {@value #Hebrew}
	 */
	public final static String Hebrew = "";
	//Common languages in Security Products
	/**
	 * Group 2 - {@value #Finnish}
	 */
	public final static String Finnish = "";
	/**
	 * Group 2 - {@value #Danish}
	 */
	public final static String Danish = "";
	/**
	 * Group 2 - {@value #Dutch}
	 */
	public final static String Dutch = "";
	/**
	 * Group 2 - {@value #Turkish}
	 */
	public final static String Turkish = "";
	/**
	 * Group 2 - {@value #Greek}
	 */
	public final static String Greek = "";
	//Others
	/**
	 * Group 2 - {@value #Catalan}
	 */
	public final static String Catalan = "";
	/**
	 * Group 2 - {@value #NorwegianBokmal}
	 */
	public final static String NorwegianBokmal = "";
	/**
	 * Group 2 - {@value #PortugalPortuguese}
	 */
	public final static String PortugalPortuguese = "";
	/**
	 * Group 2 - {@value #Swedish}
	 */
	public final static String Swedish = "";
	/**
	 * Group 2 - {@value #Thai}
	 */
	public final static String Thai = "";
	
	/**
	 * Group 3
	 */
	//Common languages in Security Products
	/**
	 * Group 3 - {@value #Czech}
	 */
	public final static String Czech = "";
	/**
	 * Group 3 - {@value #Polish}
	 */
	public final static String Polish = "";
	/**
	 * Group 3 - {@value #Hungarian}
	 */
	public final static String Hungarian = "";
	//Others
	/**
	 * Group 3 - {@value #Bulgarian}
	 */
	public final static String Bulgarian = "";
	/**
	 * Group 3 - {@value #Croatian}
	 */
	public final static String Croatian = "";
	/**
	 * Group 3 - {@value #Icelandic}
	 */
	public final static String Icelandic = "";
	/**
	 * Group 3 - {@value #Kazakh}
	 */
	public final static String Kazakh = "";
	/**
	 * Group 3 - {@value #Romanian}
	 */
	public final static String Romanian = "";
	/**
	 * Group 3 - {@value #Slovak}
	 */
	public final static String Slovak = "";
	/**
	 * Group 3 - {@value #Slovenian}
	 */
	public final static String Slovenian = "";
	/**
	 * Group 3 - {@value #Ukrainian}
	 */
	public final static String Ukrainian = "";
	
	/**
	 * Special
	 */
	/**
	 * Group others - {@value #Belarusian}
	 */
	public final static String Belarusian = "";
	/**
	 * Group others - {@value #Bosnian}
	 */
	public final static String Bosnian = "";
	/**
	 * Group others - {@value #SwissGerman}
	 */
	public final static String SwissGerman = "";
	/**
	 * Group others - {@value #UKEnglish}
	 */
	public final static String UKEnglish = "";
	/**
	 * Group others - {@value #Estonian}
	 */
	public final static String Estonian = "";
	/**
	 * Group others - {@value #Basque}
	 */
	public final static String Basque = "";
	/**
	 * Group others - {@value #BelgianFrench}
	 */
	public final static String BelgianFrench = "";
	/**
	 * Group others - {@value #CanadianFrench}
	 */
	public final static String CanadianFrench = "";
	/**
	 * Group others - {@value #SwissFrench}
	 */
	public final static String SwissFrench = "";
	/**
	 * Group others - {@value #CroatianSRC}
	 */
	public final static String CroatianSRC = "";
	/**
	 * Group others - {@value #Indonesian}
	 */
	public final static String Indonesian = "";
	/**
	 * Group others - {@value #SwissItalian}
	 */
	public final static String SwissItalian = "";
	/**
	 * Group others - {@value #Lithuanian}
	 */
	public final static String Lithuanian = "";
	/**
	 * Group others - {@value #Latvian}
	 */
	public final static String Latvian = "";
	/**
	 * Group others - {@value #Macedonian}
	 */
	public final static String Macedonian = "";
	/**
	 * Group others - {@value #Mongolian}
	 */
	public final static String Mongolian = "";
	/**
	 * Group others - {@value #Malay}
	 */
	public final static String Malay = "";
	/**
	 * Group others - {@value #BelgianDutch}
	 */
	public final static String BelgianDutch = "";
	/**
	 * Group others - {@value #Serbian}
	 */
	public final static String Serbian = "";
	/**
	 * Group others - {@value #Montenegrin}
	 */
	public final static String Montenegrin = "";
	/**
	 * Group others - {@value #Vietnamese}
	 */
	public final static String Vietnamese = "";
	
	/**
	 * Not found on MTP
	 */
	/**
	 * Group not found - {@value #Afrikaans}
	 */
	public final static String Afrikaans = "";
	/**
	 * Group not found - {@value #Albanian}
	 */
	public final static String Albanian = "";
	/**
	 * Group not found - {@value #Azerbajiani}
	 */
	public final static String Azerbajiani = "";
	/**
	 * Group not found - {@value #CanadianEnglish}
	 */
	public final static String CanadianEnglish = "";
	/**
	 * Group not found - {@value #Farsi}
	 */
	public final static String Farsi = "";
	/**
	 * Group not found - {@value #Filipino} (Same as Tatalog)
	 */
	public final static String Filipino = "";
	/**
	 * Group not found - {@value #Hindi}
	 */
	public final static String Hindi = "";
	/**
	 * Group not found - {@value #LatinAmericanSpanish}
	 */
	public final static String LatinAmericanSpanish = "";
	/**
	 * Group not found - {@value #Sinhalese}
	 */
	public final static String Sinhalese = "";
	/**
	 * Group not found - {@value #Swahili}
	 */
	public final static String Swahili = "";
	/**
	 * Group not found - {@value #Tagalog}
	 */
	public final static String Tagalog = "";
	/**
	 * Group not found - {@value #Urdu}
	 */
	public final static String Urdu = "";
	/**
	 * Group not found - {@value #Uzbek}
	 */
	public final static String Uzbek = "";
	
	/*
	 * Other TSC supported languages which are not added to the list above. 
	 * 
	 * Azerbaijan(Russian TSC), Byelorussian(Russian TSC)
	 * 
	 */
	
	public static boolean hasLocale(String localeText){
		for(Field locale : LocalesTemplate.class.getDeclaredFields()){
			try {
				
				if (localeText.equals((String)locale.get(LocalesTemplate.class))) return true;
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
    
    
    
    
    

}
