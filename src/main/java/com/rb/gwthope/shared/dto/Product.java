package com.rb.gwthope.shared.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private String productId;

	private short category;

	@Column(name="created_by")
	private String createdBy;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private String imgfile;

	@Column(name="product_desc")
	private String productDesc;

	@Column(name="product_name")
	private String productName;

	@Column(name="product_type")
	private short productType;

	private String shelf;

	@Column(name="total_qty_on_hand")
	private float totalQtyOnHand;

	@Column(name="update_by")
	private String updateBy;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to UnitConversion
    @ManyToOne
	@JoinColumn(name="unit_type")
	private UnitConversion unitConversion;

	//bi-directional many-to-one association to ProductDtl
	@OneToMany(mappedBy="product")
	private Set<ProductDtl> productDtls;

    public Product() {
    }

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public short getCategory() {
		return this.category;
	}

	public void setCategory(short category) {
		this.category = category;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getImgfile() {
		return this.imgfile;
	}

	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}

	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public short getProductType() {
		return this.productType;
	}

	public void setProductType(short productType) {
		this.productType = productType;
	}

	public String getShelf() {
		return this.shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public float getTotalQtyOnHand() {
		return this.totalQtyOnHand;
	}

	public void setTotalQtyOnHand(float totalQtyOnHand) {
		this.totalQtyOnHand = totalQtyOnHand;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public UnitConversion getUnitConversion() {
		return this.unitConversion;
	}

	public void setUnitConversion(UnitConversion unitConversion) {
		this.unitConversion = unitConversion;
	}
	
	public Set<ProductDtl> getProductDtls() {
		return this.productDtls;
	}

	public void setProductDtls(Set<ProductDtl> productDtls) {
		this.productDtls = productDtls;
	}
	
}