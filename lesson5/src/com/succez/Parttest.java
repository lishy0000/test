package com.succez;

import java.io.File;

import com.Action.Tool;



public class Parttest {
	static UserManager umg= UserManager.getSingleton();
	public static void main(String args[]) {
	User user=new User("ie","i",true,1,"","",1);
	umg.modifySql(user);
	}

}
