package com.rb.gwthope.server.dao;

import java.util.List;

import com.rb.gwthope.shared.dto.UnitConversion;

public interface UnitConversionDao {

	public List<UnitConversion> getAllUnitConversion();
	public UnitConversion saveUnitConversion(UnitConversion unitConversion);
	public UnitConversion findById(int id);
	public boolean deleteUnitConversion(int id);
	
}
