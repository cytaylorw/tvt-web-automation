package tvt.selenium.core.tool;

import tvt.selenium.core.exception.general.InvalidValueException;

public class WebCSS {

	// Remove 'px' and convert to int
	public static int convertCssSizeToInt(String size){
		if(size.endsWith("px")){
			size = size.substring(0, size.length()-2);
		}else{
			throw new InvalidValueException("String does not end with 'px': "+size);
		}
		return Integer.parseInt(size);
	}
}
