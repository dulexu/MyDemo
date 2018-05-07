package aaa;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.Thread;

import java.util.List;

import java.util.ArrayList;

/**
 * @author Lexu
 * @date 2018/5/
 *
 *
 */

public class RobotTest {
	
    public static void main(String[] args){
		
        System.out.println("start");
		for(int i=0;i
				<50;i++){
			System.out.println("第"+i+"次");
			save();
			try {
                
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		System.out.println("end");
    }
	public RobotTest(){}
	
	
    private static Robot robot;
    private static int PAUSE_INTERVAL;
    static {
        try {
            PAUSE_INTERVAL = 1000;
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
	
    static List<Integer> enterSeq;
    static List<Integer> ctrlSSeq;
    static List<Integer> leftSeq;
    static {
        enterSeq = new ArrayList<>();
        ctrlSSeq = new ArrayList<>();
        leftSeq = new ArrayList<>();

        enterSeq.add(KeyEvent.VK_ENTER);
        ctrlSSeq.add(KeyEvent.VK_CONTROL);
        ctrlSSeq.add(KeyEvent.VK_S);
		leftSeq.add(KeyEvent.VK_LEFT);
    }
	// [ left + (ctrl + s) + enter]
    public static void save() {
        pressVK(leftSeq);
        pressVK(ctrlSSeq);
        pressVK(enterSeq);
    }
	 
    public static void pressVK(List<Integer> keyCodes) {
        for(int i=0; i<keyCodes.size(); i++) {
            robot.keyPress(keyCodes.get(i));
        }
			try {
                
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        for(int i=keyCodes.size()-1; i>=0; i--) {
            robot.keyRelease(keyCodes.get(i));
        }
		System.out.println("pressVK--"+keyCodes.toString());
		
		try {
                
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		
    }
	private void sleep1s(){
		try {
                
                Thread.sleep(PAUSE_INTERVAL);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	}
}
