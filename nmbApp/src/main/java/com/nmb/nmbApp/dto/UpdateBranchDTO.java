package com.nmb.nmbApp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateBranchDTO {
    private Long id;
    private String branchName;
    private UUID branchCode;
}
