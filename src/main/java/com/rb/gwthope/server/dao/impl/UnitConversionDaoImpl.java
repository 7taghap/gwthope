package com.rb.gwthope.server.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;


import com.rb.gwthope.server.constants.MyNamedQueries;
import com.rb.gwthope.server.dao.UnitConversionDao;
import com.rb.gwthope.shared.dto.UnitConversion;

@Repository
public class UnitConversionDaoImpl extends
		AbstractJpaDao<Integer, UnitConversion> implements UnitConversionDao {

	private static Logger logger = Logger.getLogger(UnitConversionDaoImpl.class.getName());
	
	public UnitConversionDaoImpl() {
		setClazz(UnitConversion.class);
	}

	@Override
	public List<UnitConversion> getAllUnitConversion() {
		// TODO Auto-generated method stub
		logger.info("entitymanager :" + entityManager);
		List<UnitConversion> unitConverstions = findAll();
		logger.info("unitConversion size :" + unitConverstions.size());
		return unitConverstions;
	}

	@Override
	public UnitConversion saveUnitConversion(UnitConversion unitConversion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConversion findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUnitConversion(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
