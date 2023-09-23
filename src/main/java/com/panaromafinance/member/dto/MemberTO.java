package com.panaromafinance.member.dto;

import java.util.Date;
import java.util.List;

import com.panaromafinance.member.enums.KycLevel;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class MemberTO {
    Long id;
    String name;
    KycLevel kycLevel;
    String mobileNumber;
    Boolean mobileVerified;
    List<BankTO> banks;
    Date createdDate;
}
