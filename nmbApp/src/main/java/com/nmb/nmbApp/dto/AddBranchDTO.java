package com.nmb.nmbApp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddBranchDTO {
    private String branchName;
    private UUID branchCode;
}
