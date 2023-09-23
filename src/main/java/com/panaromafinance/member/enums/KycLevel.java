package com.panaromafinance.member.enums;

public enum KycLevel {

	    NOT_VERIFIED("Not Verified"),
	    BASIC("Basic"),
	    PRO("Pro");

	    final String kycLevel;

	    KycLevel(String kycLevel) {
	        this.kycLevel = kycLevel;
	    }

}
