package com.panaromafinance.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "PF_BANK")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "ID")
	private Long id;
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	@Column(name = "NAME")
	private String name;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "HOLDER_NAME")
	private String holderName;
	@ManyToOne
	private Member member;
}
