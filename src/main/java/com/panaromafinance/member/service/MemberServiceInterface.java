package com.panaromafinance.member.service;


import java.util.List;

import com.panaromafinance.member.dto.BankTO;
import com.panaromafinance.member.dto.MemberTO;

public interface MemberServiceInterface {

	MemberTO createMember(MemberTO memberTO);

	Object updateMember(Long memberId, MemberTO memberDTO);

	Object findAll();

	Object findMembersByCountry(String country);

	void deleteMember(Long memberId);

	BankTO addBank(Long memberId, BankTO bankTO);

	BankTO updateBank(Long memberId, Long bankId, BankTO bankDTO);

	void removeBank(Long memberId, Long bankId);

	List<BankTO> getAllBanks(Long memberId);

}
