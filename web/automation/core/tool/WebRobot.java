package web.automation.core.tool;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;

import web.automation.core.exception.general.InvalidNumberOfParameterException;

public class WebRobot {

	public static void robotType(Robot robot,char character){
		switch (character) {
        case 'a': robotType(robot,KeyEvent.VK_A); break;
        case 'b': robotType(robot,KeyEvent.VK_B); break;
        case 'c': robotType(robot,KeyEvent.VK_C); break;
        case 'd': robotType(robot,KeyEvent.VK_D); break;
        case 'e': robotType(robot,KeyEvent.VK_E); break;
        case 'f': robotType(robot,KeyEvent.VK_F); break;
        case 'g': robotType(robot,KeyEvent.VK_G); break;
        case 'h': robotType(robot,KeyEvent.VK_H); break;
        case 'i': robotType(robot,KeyEvent.VK_I); break;
        case 'j': robotType(robot,KeyEvent.VK_J); break;
        case 'k': robotType(robot,KeyEvent.VK_K); break;
        case 'l': robotType(robot,KeyEvent.VK_L); break;
        case 'm': robotType(robot,KeyEvent.VK_M); break;
        case 'n': robotType(robot,KeyEvent.VK_N); break;
        case 'o': robotType(robot,KeyEvent.VK_O); break;
        case 'p': robotType(robot,KeyEvent.VK_P); break;
        case 'q': robotType(robot,KeyEvent.VK_Q); break;
        case 'r': robotType(robot,KeyEvent.VK_R); break;
        case 's': robotType(robot,KeyEvent.VK_S); break;
        case 't': robotType(robot,KeyEvent.VK_T); break;
        case 'u': robotType(robot,KeyEvent.VK_U); break;
        case 'v': robotType(robot,KeyEvent.VK_V); break;
        case 'w': robotType(robot,KeyEvent.VK_W); break;
        case 'x': robotType(robot,KeyEvent.VK_X); break;
        case 'y': robotType(robot,KeyEvent.VK_Y); break;
        case 'z': robotType(robot,KeyEvent.VK_Z); break;
        case 'A': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_A); break;
        case 'B': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_B); break;
        case 'C': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_C); break;
        case 'D': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_D); break;
        case 'E': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_E); break;
        case 'F': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_F); break;
        case 'G': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_G); break;
        case 'H': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_H); break;
        case 'I': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_I); break;
        case 'J': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_J); break;
        case 'K': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_K); break;
        case 'L': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_L); break;
        case 'M': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_M); break;
        case 'N': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_N); break;
        case 'O': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_O); break;
        case 'P': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_P); break;
        case 'Q': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_Q); break;
        case 'R': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_R); break;
        case 'S': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_S); break;
        case 'T': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_T); break;
        case 'U': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_U); break;
        case 'V': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_V); break;
        case 'W': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_W); break;
        case 'X': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_X); break;
        case 'Y': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_Y); break;
        case 'Z': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_Z); break;
        case '`': robotType(robot,KeyEvent.VK_BACK_QUOTE); break;
        case '0': robotType(robot,KeyEvent.VK_0); break;
        case '1': robotType(robot,KeyEvent.VK_1); break;
        case '2': robotType(robot,KeyEvent.VK_2); break;
        case '3': robotType(robot,KeyEvent.VK_3); break;
        case '4': robotType(robot,KeyEvent.VK_4); break;
        case '5': robotType(robot,KeyEvent.VK_5); break;
        case '6': robotType(robot,KeyEvent.VK_6); break;
        case '7': robotType(robot,KeyEvent.VK_7); break;
        case '8': robotType(robot,KeyEvent.VK_8); break;
        case '9': robotType(robot,KeyEvent.VK_9); break;
        case '-': robotType(robot,KeyEvent.VK_MINUS); break;
        case '=': robotType(robot,KeyEvent.VK_EQUALS); break;
        case '~': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE); break;
        case '!': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_1); break;
        case '@': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_2); break;
        case '#': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_3); break;
        case '$': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_4); break;
        case '%': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_5); break;
        case '^': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_6); break;
        case '&': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_7); break;
        case '*': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_8); break;
        case '(': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_9); break;
        case ')': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_0); break;
        case '_': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS); break;
        case '+': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_EQUALS); break;
        case '\t': robotType(robot,KeyEvent.VK_TAB); break;
        case '\n': robotType(robot,KeyEvent.VK_ENTER); break;
        case '[': robotType(robot,KeyEvent.VK_OPEN_BRACKET); break;
        case ']': robotType(robot,KeyEvent.VK_CLOSE_BRACKET); break;
        case '\\': robotType(robot,KeyEvent.VK_BACK_SLASH); break;
        case '{': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET); break;
        case '}': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET); break;
        case '|': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH); break;
        case ';': robotType(robot,KeyEvent.VK_SEMICOLON); break;
        case ':': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_SEMICOLON); break;
        case '\'': robotType(robot,KeyEvent.VK_QUOTE); break;
        case '"': robotType(robot,KeyEvent.VK_QUOTEDBL); break;
        case ',': robotType(robot,KeyEvent.VK_COMMA); break;
        case '<': robotType(robot,KeyEvent.VK_LESS); break;
        case '.': robotType(robot,KeyEvent.VK_PERIOD); break;
        case '>': robotType(robot,KeyEvent.VK_GREATER); break;
        case '/': robotType(robot,KeyEvent.VK_SLASH); break;
        case '?': robotType(robot,KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH); break;
        case ' ': robotType(robot,KeyEvent.VK_SPACE); break;
        default:
            throw new IllegalArgumentException("Cannot type character " + character);
        }
	}
	
	public static void robotType(Robot robot,int[] keyCodes,int offset,int length){
		if (length == 0) {
            return;
        }

        robot.keyPress(keyCodes[offset]);
        robotType(robot,keyCodes, offset + 1, length - 1);
        robot.keyRelease(keyCodes[offset]);
	}
	
	public static void robotType(Robot robot,int... keyCodes){
		robotType(robot,keyCodes, 0, keyCodes.length);
	  }
	
	public static void robotHotKey(Robot robot,char key,Keys... mod){
		int hot1 = mod.length;
		
		if(hot1 == 1){
			if (mod[0] == Keys.ALT){
				hot1 = KeyEvent.VK_ALT;
			}else if (mod[0] == Keys.CONTROL){
				hot1 = KeyEvent.VK_CONTROL;
			}else{
				throw new IllegalArgumentException("Modifier not supported: " + mod.toString());
			}
			
			switch (key) {
	        case 'a': robotType(robot,hot1,KeyEvent.VK_A); break;
	        case 'b': robotType(robot,hot1,KeyEvent.VK_B); break;
	        case 'c': robotType(robot,hot1,KeyEvent.VK_C); break;
	        case 'd': robotType(robot,hot1,KeyEvent.VK_D); break;
	        case 'e': robotType(robot,hot1,KeyEvent.VK_E); break;
	        case 'f': robotType(robot,hot1,KeyEvent.VK_F); break;
	        case 'g': robotType(robot,hot1,KeyEvent.VK_G); break;
	        case 'h': robotType(robot,hot1,KeyEvent.VK_H); break;
	        case 'i': robotType(robot,hot1,KeyEvent.VK_I); break;
	        case 'j': robotType(robot,hot1,KeyEvent.VK_J); break;
	        case 'k': robotType(robot,hot1,KeyEvent.VK_K); break;
	        case 'l': robotType(robot,hot1,KeyEvent.VK_L); break;
	        case 'm': robotType(robot,hot1,KeyEvent.VK_M); break;
	        case 'n': robotType(robot,hot1,KeyEvent.VK_N); break;
	        case 'o': robotType(robot,hot1,KeyEvent.VK_O); break;
	        case 'p': robotType(robot,hot1,KeyEvent.VK_P); break;
	        case 'q': robotType(robot,hot1,KeyEvent.VK_Q); break;
	        case 'r': robotType(robot,hot1,KeyEvent.VK_R); break;
	        case 's': robotType(robot,hot1,KeyEvent.VK_S); break;
	        case 't': robotType(robot,hot1,KeyEvent.VK_T); break;
	        case 'u': robotType(robot,hot1,KeyEvent.VK_U); break;
	        case 'v': robotType(robot,hot1,KeyEvent.VK_V); break;
	        case 'w': robotType(robot,hot1,KeyEvent.VK_W); break;
	        case 'x': robotType(robot,hot1,KeyEvent.VK_X); break;
	        case 'y': robotType(robot,hot1,KeyEvent.VK_Y); break;
	        case 'z': robotType(robot,hot1,KeyEvent.VK_Z); break;
	        default:
	            throw new IllegalArgumentException("Not supported: " + key);
			}
		}else if(hot1 == 2){
			if (mod[0] == Keys.ALT){
				hot1 = KeyEvent.VK_ALT;
			}else if (mod[0] == Keys.CONTROL){
				hot1 = KeyEvent.VK_CONTROL;
			}else{
				throw new IllegalArgumentException("Modifier not supported: " + mod.toString());
			}
			int hot2;
			if (mod[1] == Keys.ALT){
				hot2 = KeyEvent.VK_ALT;
			}else if (mod[1] == Keys.CONTROL){
				hot2 = KeyEvent.VK_CONTROL;
			}else{
				throw new IllegalArgumentException("Modifier not supported: " + mod.toString());
			}
			
			switch (key) {
	        case 'a': robotType(robot,hot1,hot2,KeyEvent.VK_A); break;
	        case 'b': robotType(robot,hot1,hot2,KeyEvent.VK_B); break;
	        case 'c': robotType(robot,hot1,hot2,KeyEvent.VK_C); break;
	        case 'd': robotType(robot,hot1,hot2,KeyEvent.VK_D); break;
	        case 'e': robotType(robot,hot1,hot2,KeyEvent.VK_E); break;
	        case 'f': robotType(robot,hot1,hot2,KeyEvent.VK_F); break;
	        case 'g': robotType(robot,hot1,hot2,KeyEvent.VK_G); break;
	        case 'h': robotType(robot,hot1,hot2,KeyEvent.VK_H); break;
	        case 'i': robotType(robot,hot1,hot2,KeyEvent.VK_I); break;
	        case 'j': robotType(robot,hot1,hot2,KeyEvent.VK_J); break;
	        case 'k': robotType(robot,hot1,hot2,KeyEvent.VK_K); break;
	        case 'l': robotType(robot,hot1,hot2,KeyEvent.VK_L); break;
	        case 'm': robotType(robot,hot1,hot2,KeyEvent.VK_M); break;
	        case 'n': robotType(robot,hot1,hot2,KeyEvent.VK_N); break;
	        case 'o': robotType(robot,hot1,hot2,KeyEvent.VK_O); break;
	        case 'p': robotType(robot,hot1,hot2,KeyEvent.VK_P); break;
	        case 'q': robotType(robot,hot1,hot2,KeyEvent.VK_Q); break;
	        case 'r': robotType(robot,hot1,hot2,KeyEvent.VK_R); break;
	        case 's': robotType(robot,hot1,hot2,KeyEvent.VK_S); break;
	        case 't': robotType(robot,hot1,hot2,KeyEvent.VK_T); break;
	        case 'u': robotType(robot,hot1,hot2,KeyEvent.VK_U); break;
	        case 'v': robotType(robot,hot1,hot2,KeyEvent.VK_V); break;
	        case 'w': robotType(robot,hot1,hot2,KeyEvent.VK_W); break;
	        case 'x': robotType(robot,hot1,hot2,KeyEvent.VK_X); break;
	        case 'y': robotType(robot,hot1,hot2,KeyEvent.VK_Y); break;
	        case 'z': robotType(robot,hot1,hot2,KeyEvent.VK_Z); break;
	        default:
	            throw new IllegalArgumentException("Not supported: " + key);
			}
		}else{
			throw new InvalidNumberOfParameterException("Only support 1 or 2 modifier parameters.");
		}
	}
	
	public static void robotKey(Robot robot,Keys key){
		switch (key) {
        case PAGE_DOWN: robotType(robot,KeyEvent.VK_PAGE_DOWN); break;
        case PAGE_UP: robotType(robot,KeyEvent.VK_PAGE_UP);  break;
        //case NULL: robotType(KeyEvent.VK_PAGE_UP);  break;
        case CANCEL: robotType(robot,KeyEvent.VK_CANCEL);  break;
        case HELP: robotType(robot,KeyEvent.VK_HELP);  break;
        case BACK_SPACE: robotType(robot,KeyEvent.VK_BACK_SPACE);  break;
        case TAB: robotType(robot,KeyEvent.VK_TAB);  break;
        case CLEAR: robotType(robot,KeyEvent.VK_CLEAR);  break;
        case RETURN: robotType(robot,KeyEvent.VK_ENTER);  break;
        case ENTER: robotType(robot,KeyEvent.VK_ENTER);  break;
        case SHIFT: robotType(robot,KeyEvent.VK_SHIFT);  break;
        case LEFT_SHIFT: robotType(robot,KeyEvent.VK_SHIFT); break;
        case CONTROL: robotType(robot,KeyEvent.VK_CONTROL); break;
        case LEFT_CONTROL: robotType(robot,KeyEvent.VK_CONTROL); break;
        case ALT: robotType(robot,KeyEvent.VK_ALT); break;
        case LEFT_ALT: robotType(robot,KeyEvent.VK_ALT); break;
        case PAUSE: robotType(robot,KeyEvent.VK_PAUSE); break;
        case ESCAPE: robotType(robot,KeyEvent.VK_ESCAPE); break;
        case SPACE: robotType(robot,KeyEvent.VK_SPACE); break;
        case END: robotType(robot,KeyEvent.VK_END); break;
        case HOME: robotType(robot,KeyEvent.VK_HOME); break;
        case LEFT: robotType(robot,KeyEvent.VK_LEFT); break;
        case ARROW_LEFT: robotType(robot,KeyEvent.VK_LEFT); break;
        case UP: robotType(robot,KeyEvent.VK_UP); break;
        case ARROW_UP: robotType(robot,KeyEvent.VK_UP); break;
        case RIGHT: robotType(robot,KeyEvent.VK_RIGHT); break;
        case ARROW_RIGHT: robotType(robot,KeyEvent.VK_RIGHT); break;
        case DOWN: robotType(robot,KeyEvent.VK_DOWN); break;
        case ARROW_DOWN: robotType(robot,KeyEvent.VK_DOWN); break;
        case INSERT: robotType(robot,KeyEvent.VK_INSERT); break;
        case DELETE: robotType(robot,KeyEvent.VK_DELETE); break;
        case SEMICOLON: robotType(robot,KeyEvent.VK_SEMICOLON); break;
        case EQUALS: robotType(robot,KeyEvent.VK_EQUALS); break;
        case NUMPAD0: robotType(robot,KeyEvent.VK_NUMPAD0);  break;
        case NUMPAD1: robotType(robot,KeyEvent.VK_NUMPAD1);  break;
        case NUMPAD2: robotType(robot,KeyEvent.VK_NUMPAD2);  break;
        case NUMPAD3: robotType(robot,KeyEvent.VK_NUMPAD3);  break;
        case NUMPAD4: robotType(robot,KeyEvent.VK_NUMPAD4);  break;
        case NUMPAD5: robotType(robot,KeyEvent.VK_NUMPAD5);  break;
        case NUMPAD6: robotType(robot,KeyEvent.VK_NUMPAD6);  break;
        case NUMPAD7: robotType(robot,KeyEvent.VK_NUMPAD7);  break;
        case NUMPAD8: robotType(robot,KeyEvent.VK_NUMPAD8);  break;
        case NUMPAD9: robotType(robot,KeyEvent.VK_NUMPAD9);  break;
        case MULTIPLY: robotType(robot,KeyEvent.VK_MULTIPLY);  break;
        case ADD: robotType(robot,KeyEvent.VK_ADD);  break;
        case SEPARATOR: robotType(robot,KeyEvent.VK_SEPARATOR); break; 
        case SUBTRACT: robotType(robot,KeyEvent.VK_SUBTRACT);  break;
        case DECIMAL: robotType(robot,KeyEvent.VK_DECIMAL);  break;
        case DIVIDE: robotType(robot,KeyEvent.VK_DIVIDE);  break;
        case F1: robotType(robot,KeyEvent.VK_F1);  break;
        case F2: robotType(robot,KeyEvent.VK_F2);  break;
        case F3: robotType(robot,KeyEvent.VK_F3);  break;
        case F4: robotType(robot,KeyEvent.VK_F4);  break;
        case F5: robotType(robot,KeyEvent.VK_F5);  break;
        case F6: robotType(robot,KeyEvent.VK_F6);  break;
        case F7: robotType(robot,KeyEvent.VK_F7);  break;
        case F8: robotType(robot,KeyEvent.VK_F8);  break;
        case F9: robotType(robot,KeyEvent.VK_F9);  break;
        case F10: robotType(robot,KeyEvent.VK_F10);  break;
        case F11: robotType(robot,KeyEvent.VK_F11);  break;
        case F12: robotType(robot,KeyEvent.VK_F12);  break;
        case META: robotType(robot,KeyEvent.VK_META);  break;
        case COMMAND: robotType(robot,KeyEvent.VK_META);  break;//MAC command key
        //case ZENKAKU_HANKAKU: robotType(KeyEvent.VK_FULL_WIDTH,KeyEvent.VK_HALF_WIDTH); break; 
        default:
            throw new IllegalArgumentException("Not supported: " + key.toString());
        }
	}
}
