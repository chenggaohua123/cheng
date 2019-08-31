package cn.clothing.test;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ThreadException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
		StackTraceElement[] stackTraceElements=this.getStackTrace();
		for (int i = 0; i < stackTraceElements.length; i++) {
			System.out.println("\n---the  "+i+"  element"+"---");
	        System.out.println("toString:"+stackTraceElements[i].toString());
	        System.out.println("ClassName:"+stackTraceElements[i].getClassName());
	        System.out.println("FileName:"+stackTraceElements[i].getFileName());
	        System.out.println("LineNumber:"+stackTraceElements[i].getLineNumber());
	        System.out.println("MethodName:"+stackTraceElements[i].getMethodName());
		}
	}
	

}
