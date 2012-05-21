package com.rb.gwthope.shared.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@Table(name="product_category")
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_category_id")
	private int productCategoryId;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="category_type")
	private int categoryType;

	private String description;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="effective_end_date")
	private Date effectiveEndDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="effective_start_date")
	private Date effectiveStartDate;

	@Column(name="parent_category")
	private int parentCategory;

    public ProductCategory() {
    }

	public int getProductCategoryId() {
		return this.productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryType() {
		return this.categoryType;
	}

	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEffectiveEndDate() {
		return this.effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public Date getEffectiveStartDate() {
		return this.effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public int getParentCategory() {
		return this.parentCategory;
	}

	public void setParentCategory(int parentCategory) {
		this.parentCategory = parentCategory;
	}

	@Override
	public String toString() {
		return "ProductCategory [productCategoryId=" + productCategoryId
				+ ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + ", description=" + description
				+ ", effectiveEndDate=" + effectiveEndDate
				+ ", effectiveStartDate=" + effectiveStartDate
				+ ", parentCategory=" + parentCategory + "]";
	}

}