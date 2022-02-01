package com.nmb.nmbApp.service.iface;

import com.nmb.nmbApp.model.Account;
import com.nmb.nmbApp.model.Branch;

import java.util.List;

public interface BranchService {
    Branch add(Branch branch);
    Branch update(Branch branch);
    Branch getOne(Long branchId);
    void deleteOne(Long branchId);
    void deleteAll();
    List<Branch> getAll();
}
