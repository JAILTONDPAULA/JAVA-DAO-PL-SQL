package model.dao;

import model.dao.impl.SetorDaoJDBC;

public class DaoFactory {
	public static SetorDaoJDBC createSetorDao() {
		return new SetorDaoJDBC();
	}
}
