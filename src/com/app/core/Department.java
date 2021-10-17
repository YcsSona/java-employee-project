package com.app.core;

public enum Department {
	SALES, HR, MARKETING, RND, FINANCE;

	@Override
	public String toString() {
		return ordinal() + ":" + name();
	}
}
