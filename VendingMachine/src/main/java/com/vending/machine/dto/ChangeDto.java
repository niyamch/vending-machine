package com.vending.machine.dto;

public class ChangeDto {
	private int totalInStotinki;
	private int tenStoninkiQuantity = 0;
	private int twentyStoninkiQuantity = 0;
	private int fiftyStoninkiQuantity = 0;
	private int oneLevQuantity = 0;
	private int twoLevQuantity = 0;
	private String message;
	
	public ChangeDto(int totalInStotinki) {
		this.totalInStotinki = totalInStotinki;
	}

	public int getTotalInStotinki() {
		return totalInStotinki;
	}

	public void setTotalInStotinki(int totalInStotinki) {
		this.totalInStotinki = totalInStotinki;
	}

	public int getTenStoninkiQuantity() {
		return tenStoninkiQuantity;
	}

	public void setTenStoninkiQuantity(int tenStoninkiQuantity) {
		this.tenStoninkiQuantity = tenStoninkiQuantity;
	}

	public int getTwentyStoninkiQuantity() {
		return twentyStoninkiQuantity;
	}

	public void setTwentyStoninkiQuantity(int twentyStoninkiQuantity) {
		this.twentyStoninkiQuantity = twentyStoninkiQuantity;
	}

	public int getFiftyStoninkiQuantity() {
		return fiftyStoninkiQuantity;
	}

	public void setFiftyStoninkiQuantity(int fiftyStoninkiQuantity) {
		this.fiftyStoninkiQuantity = fiftyStoninkiQuantity;
	}

	public int getOneLevQuantity() {
		return oneLevQuantity;
	}

	public void setOneLevQuantity(int oneLevQuantity) {
		this.oneLevQuantity = oneLevQuantity;
	}

	public int getTwoLevQuantity() {
		return twoLevQuantity;
	}

	public void setTwoLevQuantity(int twoLevQuantity) {
		this.twoLevQuantity = twoLevQuantity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
