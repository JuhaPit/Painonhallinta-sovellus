package fi.softala.jee.demo.d16.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.jee.demo.d16.bean.Paino;
import fi.softala.jee.demo.d16.bean.PainoImpl;

public class PainoRowMapper implements RowMapper<Paino> {

	public Paino mapRow(ResultSet rs, int rowNum) throws SQLException {
		Paino p = new PainoImpl();
		p.setPvm(rs.getString("pvm"));
		p.setPaino(rs.getString("paino"));
		p.setId(rs.getInt("id"));
		
		return p;
	}

}
