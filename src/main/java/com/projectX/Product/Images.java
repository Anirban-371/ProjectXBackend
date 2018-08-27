package com.projectX.Product;

public class Images {
	String Bucket;
	String Key;
	String Location;
	String key;
	public String getBucket() {
		return Bucket;
	}
	public void setBucket(String bucket) {
		Bucket = bucket;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public String getkey() {
		return key;
	}
	public void setkey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Images [Bucket=");
		builder.append(Bucket);
		builder.append(", Key=");
		builder.append(Key);
		builder.append(", Location=");
		builder.append(Location);
		builder.append(", key=");
		builder.append(key);
		builder.append("]");
		return builder.toString();
	}
	
}
