package com.rb.gwthope.shared.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.rb.gwthope.server.constants.MyNamedQueries;

/**
 * The persistent class for the unit_conversion database table.
 * 
 */
@Entity
//@NamedQueries({
//	@NamedQuery(name=MyNamedQueries.UNIT_CONVERSION_FIND_ALL,
//			query="select o from UnitConversion o")
//})
@Table(name="unit_conversion")
public class UnitConversion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String abbr;

	private float factor;

	private String name;

	private short status;

//	//bi-directional many-to-one association to Product
//	@OneToMany(mappedBy="unitConversion")
//	private Set<Product> products;
//
//	//bi-directional many-to-one association to ProductDtl
//	@OneToMany(mappedBy="unitConversion")
//	private Set<ProductDtl> productDtls;

	//bi-directional many-to-one association to UnitType
//    @ManyToOne
//	@JoinColumn(name="unit_type")
//	private UnitType unitTypeBean;

    public UnitConversion() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbbr() {
		return this.abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public float getFactor() {
		return this.factor;
	}

	public void setFactor(float factor) {
		this.factor = factor;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	
//	public UnitType getUnitTypeBean() {
//		return this.unitTypeBean;
//	}
//
//	public void setUnitTypeBean(UnitType unitTypeBean) {
//		this.unitTypeBean = unitTypeBean;
//	}
	
}