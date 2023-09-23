package com.panaromafinance.member.util;

import java.util.List;
import java.util.stream.Collectors;
import com.panaromafinance.member.dto.BankTO;
import com.panaromafinance.member.dto.MemberTO;
import com.panaromafinance.member.entity.Bank;
import com.panaromafinance.member.entity.Member;

public class ObjectConversion {
	 public static Member memberDtoToMember(MemberTO memberTO) {
	        return Member.builder()
	                .id(memberTO.getId())
	                .name(memberTO.getName())
	                .kycLevel(memberTO.getKycLevel())
	                .mobileNumber(memberTO.getMobileNumber())
	                .mobileVerified(memberTO.getMobileVerified())
	                .createdDate(memberTO.getCreatedDate())
	                .banks(memberTO.getBanks() != null ?
	                		memberTO
	                        .getBanks()
	                        .stream()
	                        .map(ObjectConversion::bankDtoToBank)
	                        .collect(Collectors.toList())
	                        : null)
	                .build();

	    }

	    public static Bank bankDtoToBank(BankTO bankTO) {
	        return Bank.builder()
	                .id(bankTO.getId())
	                .name(bankTO.getName())
	                .holderName(bankTO.getHolderName())
	                .country(bankTO.getCountry())
	                .accountNumber(bankTO.getAccountNumber())
	                .build();
	    }

	    public static MemberTO memberToMemberDto(Member member) {
	        return MemberTO.builder()
	                .id(member.getId())
	                .name(member.getName())
	                .kycLevel(member.getKycLevel())
	                .mobileNumber(member.getMobileNumber())
	                .mobileVerified(member.getMobileVerified())
	                .createdDate(member.getCreatedDate())
	                .banks(member.getBanks() != null ?
	                        member
	                        .getBanks()
	                        .stream()
	                        .map(ObjectConversion::bankToBankDto)
	                        .collect(Collectors.toList())
	                        : null)
	                .build();
	    }

	    public static BankTO bankToBankDto(Bank bank) {
	        return BankTO.builder()
	                .id(bank.getId())
	                .name(bank.getName())
	                .holderName(bank.getHolderName())
	                .country(bank.getCountry())
	                .accountNumber(bank.getAccountNumber())
	                .build();
	    }

	    public static List<BankTO> banksToBankDtos(List<Bank> banks) {
	        return banks
	                .stream()
	                .map(ObjectConversion::bankToBankDto)
	                .collect(Collectors.toList());
	    }

	    public static List<MemberTO> membersToMemberDtos(List<Member> members) {
	        return members
	                .stream()
	                .map(ObjectConversion::memberToMemberDto)
	                .collect(Collectors.toList());
	    }
}
