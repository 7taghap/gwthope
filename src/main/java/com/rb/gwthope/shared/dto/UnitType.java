package com.rb.gwthope.shared.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the unit_type database table.
 * 
 */
@Entity
@Table(name="unit_type")
public class UnitType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="unit_id")
	private short unitId;

	@Column(name="default")
	private int default_;

	private String description;

	private String name;

	//bi-directional many-to-one association to UnitConversion
//	@OneToMany(mappedBy="unitTypeBean")
//	private Set<UnitConversion> unitConversions;

    public UnitType() {
    }

	public short getUnitId() {
		return this.unitId;
	}

	public void setUnitId(short unitId) {
		this.unitId = unitId;
	}

	public int getDefault_() {
		return this.default_;
	}

	public void setDefault_(int default_) {
		this.default_ = default_;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<UnitConversion> getUnitConversions() {
//		return this.unitConversions;
//	}
//
//	public void setUnitConversions(Set<UnitConversion> unitConversions) {
//		this.unitConversions = unitConversions;
//	}
	
}