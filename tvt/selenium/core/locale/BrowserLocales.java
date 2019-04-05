/**
 * The locale values for browser.
 * 
 */
package tvt.selenium.core.locale;

import java.lang.reflect.Field;

public class BrowserLocales{

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
	public final static String Korean = "ko";
	/**
	 * Group 1 - {@value #Russian}
	 */
	public final static String Russian = "ru";
	
	
	/**
	 * Group 2
	 */
	//BiDi (2)
	/**
	 * Group 2 - {@value #Arabic}
	 */
	public final static String Arabic = "ar";
	/**
	 * Group 2 - {@value #Hebrew}
	 */
	public final static String Hebrew = "he";
	//Common languages in Security Products
	/**
	 * Group 2 - {@value #Finnish}
	 */
	public final static String Finnish = "fi";
	/**
	 * Group 2 - {@value #Danish}
	 */
	public final static String Danish = "da";
	/**
	 * Group 2 - {@value #Dutch}
	 */
	public final static String Dutch = "nl";
	/**
	 * Group 2 - {@value #Turkish}
	 */
	public final static String Turkish = "tr";
	/**
	 * Group 2 - {@value #Greek}
	 */
	public final static String Greek = "el";
	//Others
	/**
	 * Group 2 - {@value #Catalan}
	 */
	public final static String Catalan = "ca";
	/**
	 * Group 2 - {@value #NorwegianBokmal}
	 */
	public final static String NorwegianBokmal = "nb";
	/**
	 * Group 2 - {@value #PortugalPortuguese}
	 */
	public final static String PortugalPortuguese = "pt-PT";
	/**
	 * Group 2 - {@value #Swedish}
	 */
	public final static String Swedish = "sv";
	/**
	 * Group 2 - {@value #Thai}
	 */
	public final static String Thai = "th";
	
	/**
	 * Group 3
	 */
	//Common languages in Security Products
	/**
	 * Group 3 - {@value #Czech}
	 */
	public final static String Czech = "cs";
	/**
	 * Group 3 - {@value #Polish}
	 */
	public final static String Polish = "pl";
	/**
	 * Group 3 - {@value #Hungarian}
	 */
	public final static String Hungarian = "hu";
	//Others
	/**
	 * Group 3 - {@value #Bulgarian}
	 */
	public final static String Bulgarian = "bg";
	/**
	 * Group 3 - {@value #Croatian}
	 */
	public final static String Croatian = "hr";
	/**
	 * Group 3 - {@value #Icelandic}
	 */
	public final static String Icelandic = "is";
	/**
	 * Group 3 - {@value #Kazakh}
	 */
	public final static String Kazakh = "kk";
	/**
	 * Group 3 - {@value #Romanian}
	 */
	public final static String Romanian = "ro";
	/**
	 * Group 3 - {@value #Slovak}
	 */
	public final static String Slovak = "sk";
	/**
	 * Group 3 - {@value #Slovenian}
	 */
	public final static String Slovenian = "sl";
	/**
	 * Group 3 - {@value #Ukrainian}
	 */
	public final static String Ukrainian = "uk";
	
	/**
	 * Special
	 */
	/**
	 * Group others - {@value #Belarusian}
	 */
	public final static String Belarusian = "be-BY";
	/**
	 * Group others - {@value #Bosnian}
	 */
	public final static String Bosnian = "bs";
	/**
	 * Group others - {@value #SwissGerman}
	 */
	public final static String SwissGerman = "de-CH";
	/**
	 * Group others - {@value #UKEnglish}
	 */
	public final static String UKEnglish = "en-GB";
	/**
	 * Group others - {@value #Estonian}
	 */
	public final static String Estonian = "et";
	/**
	 * Group others - {@value #Basque}
	 */
	public final static String Basque = "eu-ES";
	/**
	 * Group others - {@value #BelgianFrench}
	 */
	public final static String BelgianFrench = "fr-BE";
	/**
	 * Group others - {@value #CanadianFrench}
	 */
	public final static String CanadianFrench = "fr-CA";
	/**
	 * Group others - {@value #SwissFrench}
	 */
	public final static String SwissFrench = "fr-CH";
	/**
	 * Group others - {@value #CroatianSRC}
	 */
	public final static String CroatianSRC = "hr-HR-SRC";
	/**
	 * Group others - {@value #Indonesian}
	 */
	public final static String Indonesian = "id";
	/**
	 * Group others - {@value #SwissItalian}
	 */
	public final static String SwissItalian = "it-CH";
	/**
	 * Group others - {@value #Lithuanian}
	 */
	public final static String Lithuanian = "lt";
	/**
	 * Group others - {@value #Latvian}
	 */
	public final static String Latvian = "lv";
	/**
	 * Group others - {@value #Macedonian}
	 */
	public final static String Macedonian = "mk";
	/**
	 * Group others - {@value #Mongolian}
	 */
	public final static String Mongolian = "mn";
	/**
	 * Group others - {@value #Malay}
	 */
	public final static String Malay = "ms";
	/**
	 * Group others - {@value #BelgianDutch}
	 */
	public final static String BelgianDutch = "nl-BE";
	/**
	 * Group others - {@value #Serbian}
	 */
	public final static String Serbian = "sr";
	/**
	 * Group others - {@value #Montenegrin}
	 */
	public final static String Montenegrin = "sr-Cyrl-ME";
	/**
	 * Group others - {@value #Vietnamese}
	 */
	public final static String Vietnamese = "vi";
	
	/**
	 * Not found on MTP
	 */
	/**
	 * Group not found - {@value #Afrikaans}
	 */
	public final static String Afrikaans = "af";
	/**
	 * Group not found - {@value #Albanian}
	 */
	public final static String Albanian = "sq";
	/**
	 * Group not found - {@value #Azerbajiani}
	 */
	public final static String Azerbajiani = "az";
	/**
	 * Group not found - {@value #CanadianEnglish}
	 */
	public final static String CanadianEnglish = "en-CA";
	/**
	 * Group not found - {@value #Farsi}
	 */
	public final static String Farsi = "fa";
	/**
	 * Group not found - {@value #Filipino} (Same as Tatalog)
	 */
	public final static String Filipino = "tl";
	/**
	 * Group not found - {@value #Hindi}
	 */
	public final static String Hindi = "hi";
	/**
	 * Group not found - {@value #LatinAmericanSpanish}
	 */
	public final static String LatinAmericanSpanish = "es-MX";
	/**
	 * Group not found - {@value #Sinhalese}
	 */
	public final static String Sinhalese = "si";
	/**
	 * Group not found - {@value #Swahili}
	 */
	public final static String Swahili = "sw";
	/**
	 * Group not found - {@value #Tagalog}
	 */
	public final static String Tagalog = "tl";
	/**
	 * Group not found - {@value #Urdu}
	 */
	public final static String Urdu = "ur";
	/**
	 * Group not found - {@value #Uzbek}
	 */
	public final static String Uzbek = "uz";
	
	/*
	 * Other TSC supported languages which are not added to the list above. 
	 * 
	 * Azerbaijan(Russian TSC), Byelorussian(Russian TSC)
	 * 
	 */
	
	public static boolean hasLocale(String localeText){
		for(Field locale : BrowserLocales.class.getDeclaredFields()){
			try {
				
				if (localeText.equals((String)locale.get(BrowserLocales.class))) return true;
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
    
    
    
    
    

}
