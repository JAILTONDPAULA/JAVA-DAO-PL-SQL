package model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataBase.Connect;
import dataBase.exception.DataBaseException;
import model.dao.DefaultDao;
import model.etities.Setor;

public class SetorDaoJDBC implements DefaultDao<Setor>{

	@Override
	public List<Setor> findAll() {
		Statement st = null;
		ResultSet rs = null;
		try {
			st   = Connect.oracle().createStatement();
			rs   = st.executeQuery("SELECT CD_SETOR,SETOR,CD_SUP_SETOR FROM EMPRESA.SETOR");
			List<Setor> setor = new ArrayList<>();
			while(rs.next()) {
				setor.add(new Setor(rs.getLong(1),rs.getString(2),findByCode(rs.getLong(3))));
			}
			
			return setor;
		}catch(SQLException e) {
			throw new DataBaseException(e.getMessage());
		}finally {
			Connect.closeResultSet(rs);
			Connect.closeStatement(st);
		}
	}

	@Override
	public void deleteByObject(Setor setor) {
		PreparedStatement ps    = null;
		try {
			ps   = Connect.oracle().prepareStatement("DELETE EMPRESA.SETOR WHERE CD_SETOR = ? ");
			ps.setLong(1,setor.getCodigo());
			ps.executeUpdate();
		}catch(SQLException e) {
			throw new DataBaseException(e.getMessage());
		}finally {
			Connect.closePreparedStatement(ps);
		}
	}

	@Override
	public void insert(List<Setor> st) {
		PreparedStatement ps    = null;
		ResultSet         rs    = null;
		try {
			for(Setor setores : st) {
				ps   = Connect.oracle().prepareStatement(
						      "INSERT INTO EMPRESA.SETOR"
						    + "(CD_SETOR,SETOR,CD_SUP_SETOR)"
						    + "VALUES"
						    + "(EMPRESA.SQ_SETOR.NEXTVAL,?,?)");
				ps.setString(1,setores.getSetor());
				if(setores.getSuperior() != null) {
					ps.setFloat(2, setores.getSuperior().getCodigo());
				}else {
					ps.setString(2,null);
				}
				ps.executeUpdate();
			}
		}catch(SQLException e) {
			throw new DataBaseException(e.getMessage());
		}finally {
			Connect.closeResultSet(rs);
			Connect.closeStatement(ps);
		}		
	}

	@Override
	public void update(List<Setor> st) {
		PreparedStatement ps = null;
		ResultSet   	  rs = null;
		try {
			for(Setor setor : st) {
				ps = Connect.oracle().prepareStatement("UPDATE EMPRESA.SETOR SET"
													 + "    SETOR        = UPPER(?),"
													 + "	CD_SUP_SETOR = ?"
													 + "WHERE"
													 + "    CD_SETOR     = ?");
				ps.setString(1,setor.getSetor());
				if(setor.getSuperior() != null) {
					ps.setLong(2,setor.getSuperior().getCodigo());
				}
				ps.setLong(3, setor.getCodigo());
			}
		}catch(SQLException e) {
			throw new DataBaseException(e.getMessage());
		}finally {
			Connect.closePreparedStatement(ps);
			Connect.closeResultSet(rs);
		}
		
	}

	@Override
	public Setor findByCode(Long code) {
		Setor     setor = null;
		Statement st    = null;
		ResultSet rs    = null;
		if(code == 0) {
			return setor;
		}
		try {
			st   = Connect.oracle().createStatement();
			String query = "SELECT CD_SETOR,SETOR,CD_SUP_SETOR FROM EMPRESA.SETOR WHERE CD_SETOR = "+code;
			rs   = st.executeQuery(query);
			if(rs.next()) {
				return new Setor(rs.getLong(1),rs.getString(2),findByCode(rs.getLong(3)));
			}else {
				throw new DataBaseException("Setor não encontrado");
			}
		}catch(SQLException e) {
			throw new DataBaseException(e.getMessage());
		}finally {
			Connect.closeResultSet(rs);
			Connect.closeStatement(st);
		}
	}

		
}
