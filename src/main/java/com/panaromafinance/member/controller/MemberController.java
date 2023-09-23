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
import com.panaromafinance.member.dto.MemberTO;
import com.panaromafinance.member.service.MemberService;

@RestController
public class MemberController {


    @Autowired
    private MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<Object> createMember(@RequestBody MemberTO memberTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.createMember(memberTO));
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Object> getMemberById(@PathVariable("id") Long memberId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberService.getMemberById(memberId));
    }
    
    @GetMapping ("/members")
    public ResponseEntity<Object> getAllMember() {
        return ResponseEntity.accepted().body(memberService.findAll());
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Object> updateMember(@PathVariable("id") Long memberId, @RequestBody MemberTO memberDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberService.updateMember(memberId, memberDTO));
    }

    @DeleteMapping ("/members/{id}")
    public ResponseEntity<Object> deleteMember(@PathVariable("id") Long memberId) {
    	memberService.deleteMember(memberId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping ("/bank/{country}")
    public ResponseEntity<Object> getAllMemberHavingBankAccountInCountry(@PathVariable("country") String country) {
        return ResponseEntity.accepted().body(memberService.findMembersByCountry(country));
    }


}