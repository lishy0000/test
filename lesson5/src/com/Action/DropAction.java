package com.Action;
import com.succez.*;

public class DropAction extends AllAction implements Action {

	@Override
	public String getUri() {
		return "web/Drop.html";
	}

	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		UserManager umg = UserManager.getSingleton();
		String ioio = request.getParameter("name");
		umg.dropUser(ioio);
		Action action = new PrintAction();
		action.doGet(request, response, sessions, fiter, sessionid);

	}

}
