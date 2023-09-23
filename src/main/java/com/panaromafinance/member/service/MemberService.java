package com.panaromafinance.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.panaromafinance.member.dto.BankTO;
import com.panaromafinance.member.dto.MemberTO;
import com.panaromafinance.member.entity.Bank;
import com.panaromafinance.member.entity.Member;
import com.panaromafinance.member.exception.MemberException;
import com.panaromafinance.member.repository.BankRepository;
import com.panaromafinance.member.repository.MemberRepository;
import com.panaromafinance.member.util.ObjectConversion;

@Service
public class MemberService implements MemberServiceInterface {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BankRepository bankRepository;

	public MemberTO createMember(MemberTO memberDTO) {
		Member member = ObjectConversion.memberDtoToMember(memberDTO);
		member = memberRepository.save(member);
		return ObjectConversion.memberToMemberDto(member);
	}

	public MemberTO getMemberById(Long memberId) {
		assertMemberExists(memberId);

		Member member = memberRepository.findById(memberId).get();
		return ObjectConversion.memberToMemberDto(member);
	}
	
	public MemberTO updateMember(Long memberId, MemberTO memberDTO) {
		assert memberDTO != null;
		assertMemberExists(memberId);
		Member member = ObjectConversion.memberDtoToMember(memberDTO);
		member = memberRepository.save(member);
		return ObjectConversion.memberToMemberDto(member);
	}

	public void deleteMember(Long memberId) {
		assertMemberExists(memberId);
		memberRepository.deleteById(memberId);
	}

	public List<MemberTO> findAll() {
		return ObjectConversion.membersToMemberDtos(memberRepository.findAll());
	}

	private void assertMemberExists(Long memberId) {
		if (!memberRepository.existsById(memberId)) {
			throw new MemberException(HttpStatus.NOT_FOUND, "Resource with id " + memberId + " not exists.");
		}
	}

	private void assertBankExists(Long bankId) {
		if (!bankRepository.existsById(bankId)) {
			throw new MemberException(HttpStatus.NOT_FOUND, "Resource with id " + bankId + " not exists.");
		}
	}

	// Bank operation related method
	public BankTO addBank(Long memberId, BankTO bankDTO) {
		assertMemberExists(memberId);
		Bank bank = ObjectConversion.bankDtoToBank(bankDTO);
		bank.setMember(Member.builder().id(memberId).build());
		bank = bankRepository.save(bank);
		return ObjectConversion.bankToBankDto(bank);
	}

	public BankTO updateBank(Long memberId, Long bankId, BankTO bankDTO) {
		assertMemberExists(memberId);
		assertBankExists(bankId);

		Bank bankToUpdate = bankRepository.getReferenceById(bankId);

		if (!bankToUpdate.getMember().getId().equals(memberId)) {
			throw new MemberException(HttpStatus.BAD_REQUEST, "Bank not associated with this Member");
		}

		bankToUpdate.setCountry(bankDTO.getCountry());
		bankToUpdate.setAccountNumber(bankDTO.getAccountNumber());
		bankToUpdate.setName(bankDTO.getName());
		bankToUpdate.setHolderName(bankDTO.getHolderName());
		bankToUpdate = bankRepository.save(bankToUpdate);
		return ObjectConversion.bankToBankDto(bankToUpdate);
	}

	public void removeBank(Long memberId, Long bankId) {
		assertMemberExists(memberId);
		assertBankExists(bankId);

		Bank bankToUpdate = bankRepository.getReferenceById(bankId);

		if (!bankToUpdate.getMember().getId().equals(memberId)) {
			throw new MemberException(HttpStatus.BAD_REQUEST, "Bank not associated with this Member");
		}

		bankRepository.deleteById(bankId);
	}

	public List<BankTO> getAllBanks(Long memberId) {
		assertMemberExists(memberId);
		return ObjectConversion.banksToBankDtos(bankRepository.findByMemberId(memberId));
	}

	public List<MemberTO> findMembersByCountry(String country) {
		return ObjectConversion.membersToMemberDtos(memberRepository.findByBanksCountry(country));
	}
}
