package com.dct.swocean.entity;

import java.io.Serializable;

import com.dct.swocean.entity.SysDonationInfo;

public class Donor implements Serializable {

	private String pic;
	private String name;
	private String donor;
	private Long payAmount;

	public String getDonor() {
		return donor;
	}

	public void setDonor(String donor) {
		this.donor = donor;
	}

	public Long getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
