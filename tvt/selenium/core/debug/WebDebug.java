/**
 * WebDug class is only for internal use to print messages in eclipse console
 * 
 * @author Taylor Wong
 * 
 */
package tvt.selenium.core.debug;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import tvt.selenium.core.exception.image.WebScreenException;
import tvt.selenium.core.tool.WebDate;


public class WebDebug {

	private Logger logger;
	private int debugLVL;
	private FileHandler fh;
	
	public static final int DEBUGROBOT=3;
	public static final int DEBUGWAIT=4;
	public static final int DEBUGLOCATOR=5;
	public static final int DEBUGBROWSER=6;
	public static final int DEBUGDRIVER=7;
	public static final int DEBUGSCREEN=9;
	public static final int DEBUGLOGGER=10;
	public static final int DEBUGTIMER=99;
	
	public static final String SPLITTER = "<<------------------------------------------------------------------------------------------->>";
	
	
	/**
	 * WebDebug Constructor
	 * @param level Set the debug level
	 */
	public WebDebug (String filePrefix,String directory,int level){
		setDebugLevel(level);
		createLogFile(filePrefix,directory);
	}
	
	public WebDebug (int level){
		setDebugLevel(level);
		logger = null;
		print(debugMessage("Log file is disabled",2));
		printSplitter();
	}
	
	private void createLogFile(String filePrefix,String directory){
		if(debugLVL <= DEBUGLOGGER){
			logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
			logger.setUseParentHandlers(false);
			try {
				String filename = filePrefix+"@"+WebDate.timeForLogFile()+".log";
				if(directory.endsWith("\\")){
					filename = directory+filename;
				}else{
					filename = directory+"\\"+filename;
				}
				File dir = new File(directory);
				if(!dir.exists()){
					dir.mkdirs();
					if(dir.exists()){
						print(debugMessage("Directory created.",2));
					}else{
						throw new WebScreenException("Fail to create directory: "+directory);
					}
				}else if(!dir.isDirectory()){
					throw new WebScreenException("Not a directory: "+directory);
				}else{
					print(debugMessage("Directory already exists.",2));
				}
				fh=new FileHandler(filename);
				fh.setFormatter(new LogFormatter());
				//logger.setLevel(Level.ALL);
				logger.addHandler(fh);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			logger = null;
			print(debugMessage("Log file is disabled",2));
		}
		printSplitter();
	}
	
	public int getDebugLevel(){
		return debugLVL;
	}
	
	public void setDebugLevel(int level){
		debugLVL=level;
		print(debugMessage("Set debug level to "+level,2));
	}
	
	public void printSplitter(){
		print(SPLITTER);
	}
	
	public void printSplitter(int debugLVL){
		if(this.debugLVL <= debugLVL)print(SPLITTER);
	}
	
	public void printLineBreak(){
		print(System.lineSeparator());
	}
	
	public void printLineBreak(int debugLVL){
		if(this.debugLVL <= debugLVL)print(System.lineSeparator());
	}
	
	public void printMessage(String message){
		print(debugMessage(message));
	}
	
	public void printLogInfo(String message){
		if(logger != null)logger.info(message);
	}
	
	public void printLogWarning(String message){
		if(logger != null)logger.warning(message);
	}
	
	public void printException(String message,Exception e){
		if(logger != null)logger.log(Level.SEVERE,message,e);
	}
	
	public void debugBrowser(String message){
		if(debugLVL <= DEBUGBROWSER)print(debugMessage(message));
	}
	
	public void debugDriver(String message){
		if(debugLVL <= DEBUGDRIVER)print(debugMessage(message));
	}
	
	public void debugRobot(String message){
		if(debugLVL <= DEBUGROBOT)print(debugMessage(message));
	}
	
	public void debugWait(String message){
		if(debugLVL <= DEBUGWAIT)print(debugMessage(message));
	}
	
	public void debugScreen(String message){
		if(debugLVL <= DEBUGSCREEN)print(debugMessage(message));
	}
	
	public void debugLocator(String message){
		if(debugLVL <= DEBUGLOCATOR)print(debugMessage(message));
	}

	public void debugTimer(String message){
		if(debugLVL <= DEBUGTIMER)print(debugMessage(message));
	}
	
	private void print(String message){
		System.out.println(message);
		printLogInfo(message);
	}
	
	private String debugMessage(String message){
		String className = Thread.currentThread().getStackTrace()[3].getClassName();
		return "<"+className.substring(className.lastIndexOf('.') + 1)+"> "+Thread.currentThread().getStackTrace()[3].getMethodName()+": "+message;
	}
	
	private String debugMessage(String message,int traceIndex){
		String className = Thread.currentThread().getStackTrace()[traceIndex].getClassName();
		return "<"+className.substring(className.lastIndexOf('.') + 1)+"> "+Thread.currentThread().getStackTrace()[traceIndex].getMethodName()+": "+message;
	}
}
