package com.projectX.Product;

public class Review {
	String comment;
	float rating;
	String ownername;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [comment=");
		builder.append(comment);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", ownername=");
		builder.append(ownername);
		builder.append("]");
		return builder.toString();
	}
}
