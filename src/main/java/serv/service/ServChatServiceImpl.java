package serv.service;

import serv.Dao.ServChatDao;
import serv.Dao.Impl.ServChatDaoImpl;

public class ServChatServiceImpl {
	private ServChatDao dao;

	public ServChatServiceImpl() {
			dao = new ServChatDaoImpl();
	}
	
	
}