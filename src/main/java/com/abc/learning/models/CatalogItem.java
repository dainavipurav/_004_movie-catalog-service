package com.abc.learning.models;

public class CatalogItem {

	private String id;
	private String name;
	private String desc;
	private int rating;

	public CatalogItem() {
	}

	public CatalogItem(String name, String desc, int rating) {
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}

	public CatalogItem(String id, String name, String desc, int rating) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
