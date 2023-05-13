package com.nathalia.dslist.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReplacementDto implements Serializable {
    private Integer sourceIndex;
    private Integer destinationIndex;
}
