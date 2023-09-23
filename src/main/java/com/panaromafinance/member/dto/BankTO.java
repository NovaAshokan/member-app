package com.panaromafinance.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@Builder
@ToString
public class BankTO {
    Long id;
    String accountNumber;
    String name;
    String country;
    String holderName;
}