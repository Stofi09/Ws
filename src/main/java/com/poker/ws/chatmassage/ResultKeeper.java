package com.poker.ws.chatmassage;

import org.springframework.stereotype.Component;

@Component
public class ResultKeeper {

	private int res1 = 0;
	private int res2 = 0;
	
	
	public ResultKeeper() {	}
	
	protected void getRes(int res1,int res2) {
		this.res1 = res1;
		this.res2 = res2;
	}
	public int getRes1() {
		return res1;
	}
	public void setRes1(int res1) {
		this.res1 = res1;
	}
	public int getRes2() {
		return res2;
	}
	public void setRes2(int res2) {
		this.res2 = res2;
	}
	
	protected  void eraser() {
		this.res1 = 0;
		this.res2 = 0;
	}
}
