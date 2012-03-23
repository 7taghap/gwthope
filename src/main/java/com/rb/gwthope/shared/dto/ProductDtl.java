package com.rb.gwthope.shared.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product_dtl database table.
 * 
 */
@Entity
@Table(name="product_dtl")
public class ProductDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_dtl_id")
	private String productDtlId;

	@Column(name="created_by")
	private String createdBy;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="last_updated_by")
	private String lastUpdatedBy;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	private double price;

	@Column(name="price_type")
	private int priceType;

	@Column(name="qty_on_hand")
	private float qtyOnHand;

	@Column(name="selling_qty")
	private float sellingQty;

	private int status;

	@Column(name="sug_price")
	private double sugPrice;

	//bi-directional many-to-one association to UnitConversion
    @ManyToOne
	@JoinColumn(name="package_type")
	private UnitConversion unitConversion;

	//bi-directional many-to-one association to Product
    @ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

    public ProductDtl() {
    }

	public String getProductDtlId() {
		return this.productDtlId;
	}

	public void setProductDtlId(String productDtlId) {
		this.productDtlId = productDtlId;
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

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPriceType() {
		return this.priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}

	public float getQtyOnHand() {
		return this.qtyOnHand;
	}

	public void setQtyOnHand(float qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}

	public float getSellingQty() {
		return this.sellingQty;
	}

	public void setSellingQty(float sellingQty) {
		this.sellingQty = sellingQty;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getSugPrice() {
		return this.sugPrice;
	}

	public void setSugPrice(double sugPrice) {
		this.sugPrice = sugPrice;
	}

	public UnitConversion getUnitConversion() {
		return this.unitConversion;
	}

	public void setUnitConversion(UnitConversion unitConversion) {
		this.unitConversion = unitConversion;
	}
	
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}