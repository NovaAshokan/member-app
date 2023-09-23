package com.panaromafinance.member.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.panaromafinance.member.enums.KycLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "PF_MEMBER")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "KYC_LEVEL")
	private KycLevel kycLevel;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "MOBILE_VERIFIED")
	private Boolean mobileVerified;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private List<Bank> banks;

	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

}
