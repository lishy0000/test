package com.succez;
import java.io.File;

import javax.servlet.http.HttpSession;

public class DropAction  extends AllAction implements Action{

		@Override
		public String getUri() {
			return "web/Drop.html";
		}


		public void doGet(RequestImpl request, ResponseImpl response,SessionManage sessions,String fiter,String sessionid)
				throws Exception {
			String ioio=request.getParameter("name");
			dropUser(ioio );
			Action action =new PrintAction();
			action.doGet(request, response, sessions, fiter,sessionid);
				
		
			
		}

	}


