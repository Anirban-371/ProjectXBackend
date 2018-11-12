package com.projectXNeighbour.Settings;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Services")
public class Services {
	@Id
	private String id;
	private String name;
	private String[] tags;
	private String img;
	private String title;
	private String category;
	private String categoryId;
	private boolean is_promotion;
	private boolean is_discount;
	private float discountRate;
	private String[] country;
	private String promotionStartDate;
	private String promotionEndDate;
	private String description;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public boolean isIs_promotion() {
		return is_promotion;
	}
	public void setIs_promotion(boolean is_promotion) {
		this.is_promotion = is_promotion;
	}
	public boolean isIs_discount() {
		return is_discount;
	}
	public void setIs_discount(boolean is_discount) {
		this.is_discount = is_discount;
	}
	public float getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}
	public String[] getCountry() {
		return country;
	}
	public void setCountry(String[] country) {
		this.country = country;
	}
	public String getPromotionStartDate() {
		return promotionStartDate;
	}
	public void setPromotionStartDate(String promotionStartDate) {
		this.promotionStartDate = promotionStartDate;
	}
	public String getPromotionEndDate() {
		return promotionEndDate;
	}
	public void setPromotionEndDate(String promotionEndDate) {
		this.promotionEndDate = promotionEndDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Services [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", tags=");
		builder.append(Arrays.toString(tags));
		builder.append(", img=");
		builder.append(img);
		builder.append(", title=");
		builder.append(title);
		builder.append(", category=");
		builder.append(category);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", is_promotion=");
		builder.append(is_promotion);
		builder.append(", is_discount=");
		builder.append(is_discount);
		builder.append(", discountRate=");
		builder.append(discountRate);
		builder.append(", country=");
		builder.append(Arrays.toString(country));
		builder.append(", promotionStartDate=");
		builder.append(promotionStartDate);
		builder.append(", promotionEndDate=");
		builder.append(promotionEndDate);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", modifiedBy=");
		builder.append(modifiedBy);
		builder.append(", modifiedDate=");
		builder.append(modifiedDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
