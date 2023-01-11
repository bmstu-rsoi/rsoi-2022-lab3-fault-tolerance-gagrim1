package com.romanov.privilege.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DiscountOutput {
    Integer privilegeId;
    Integer price;
    Integer priceAfterDiscount;
    Integer priceDifference;
    Integer newBalance;
}
