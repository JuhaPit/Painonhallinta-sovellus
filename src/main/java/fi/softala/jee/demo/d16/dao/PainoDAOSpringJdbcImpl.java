package fi.softala.jee.demo.d16.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.softala.jee.demo.d16.bean.Paino;

@Repository
public class PainoDAOSpringJdbcImpl implements PainoDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Tallettaa parametrina annetun painon tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */
	public void talleta(Paino p) {
		final String sql = "insert into paino(pvm, paino) values(?,?)";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä.
		
		Date date = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		
		final String pvm = formatter.format(date);
		
		final String paino = p.getPaino();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, pvm);
				ps.setString(2, paino);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		p.setId(idHolder.getKey().intValue());

	}

	public List<Paino> haeKaikki() {

		String sql = "select id, pvm, paino from paino";
		RowMapper<Paino> mapper = new PainoRowMapper();
		List<Paino> painot = jdbcTemplate.query(sql, mapper);

		return painot;
	}
}
