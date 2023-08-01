package com.yg.dao;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() { }
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		switch(command) {
		case "login" : action = new LoginAction(); break;
		case "register" : action = new RegisterAction(); break;
		case "adv" : action = new AdverAction(); break;
		case "buy" : action = new BuyAction(); break;
		case "start" : action = new StartAction(); break;
		case "end" : action = new EndAction(); break;
		case "updateM" : action = new UpdateMember(); break;
		case "deleteM" : action = new DeleteMember(); break;
		} 
		return action;
	}
}
