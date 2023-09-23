package com.panaromafinance.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.panaromafinance.member.dto.BankTO;
import com.panaromafinance.member.service.MemberService;

@RestController
public class BankController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/members/{memberId}/banks")
	public ResponseEntity<Object> addBank(@PathVariable("memberId") Long memberId, @RequestBody BankTO bankDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(memberService.addBank(memberId, bankDTO));
	}

	@PutMapping("/members/{memberId}/banks/{bankId}")
	public ResponseEntity<Object> updateBank(@PathVariable("memberId") Long memberId,
			@PathVariable("bankId") Long bankId, @RequestBody BankTO bankDTO) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberService.updateBank(memberId, bankId, bankDTO));
	}

	@DeleteMapping("/members/{memberId}/banks/{bankId}")
	public ResponseEntity<Object> deleteBank(@PathVariable("memberId") Long memberId,
			@PathVariable("bankId") Long bankId) {
		memberService.removeBank(memberId, bankId);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/members/{memberId}/banks")
	public ResponseEntity<Object> getAllBank(@PathVariable("memberId") Long memberId) {
		return ResponseEntity.accepted().body(memberService.getAllBanks(memberId));
	}
}
