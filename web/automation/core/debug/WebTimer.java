package web.automation.core.debug;

import web.automation.core.browser.WebBrowser;
import web.automation.core.exception.general.WebTimerException;
import web.automation.core.tool.WebDate;

public class WebTimer {

	WebBrowser browser;
	WebDebug debug;
	
	Long startTime;
	Long endTime;
	
	public WebTimer(WebBrowser browser){
		this.browser = browser;
		debug = browser.debug();
	}
	
	public void start(boolean displayMsg){
		startTime=System.nanoTime();
		if(displayMsg){
			debug.debugTimer("Start at "+WebDate.timeForTimer());
			debug.printSplitter(WebDebug.DEBUGTIMER);
		}
	}
	
	public WebTimer stop(boolean displayMsg){
		endTime=System.nanoTime();
		if(displayMsg){
			debug.debugTimer("Stop at "+WebDate.timeForTimer());
			debug.printSplitter(WebDebug.DEBUGTIMER);
		}
		return this;
	}
	
	public Long getTime(){
		if(startTime == null)throw new WebTimerException("The timer is not started.");
		return System.nanoTime()-startTime;
	}
	
	public Long getElapseTime(){
		if(startTime == null)throw new WebTimerException("The timer is not started.");
		if(endTime == null)throw new WebTimerException("The timer is not stopped.");
		return endTime-startTime;
	}
	
	public void printElapseTime(){
		debug.debugTimer("Elapse Time: "+convertElapseTime());
		debug.printSplitter(WebDebug.DEBUGTIMER);
	}
	
	public String convertElapseTime(){
		double s = getElapseTime().doubleValue()/1E9;
		int m,h;
		String time;
		if(s > 60){
			m = (int) (s/60);
			s = s-(m*60);
			if(m > 60){
				h = m/60;
				m = m-(h*60);
				time = h+" hour(s) "+m+" minute(s) "+s+" sencond(s)";
			}else{
				time = m+" minute(s) "+s+" sencond(s)";
			}
		}else{
			time = s+" sencond(s)";
		}
		
		return time;
	}
}
