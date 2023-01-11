package com.romanov.flight.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PaginationOutput {
    private Integer page;
    private Integer pageSize;
    private Long totalElements;
    private List<FlightOutput> items;

}
