package fi.softala.jee.demo.d16.dao;

import java.util.List;

import fi.softala.jee.demo.d16.bean.Paino;

public interface PainoDAO {

	public abstract void talleta(Paino paino);

	public abstract List<Paino> haeKaikki();

}
