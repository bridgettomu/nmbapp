package com.nmb.nmbApp.service.impl;

import com.nmb.nmbApp.model.Account;
import com.nmb.nmbApp.model.Branch;
import com.nmb.nmbApp.repository.BranchRepository;
import com.nmb.nmbApp.service.iface.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository repository;

    @Override
    public Branch add(Branch branch) {
        return repository.save(branch);
    }

    @Override
    public Branch update(Branch branch) {
        Optional<Branch> branchFromDB = Optional.ofNullable(getOne(branch.getId()));
        if (branchFromDB.isEmpty()) throw new EntityNotFoundException("Branch Not Found");
        return repository.save(branch);
    }

    @Override
    public Branch getOne(Long branchId) {
        Optional<Branch> branch = repository.findById(branchId);
        if (branch.isEmpty()) throw new EntityNotFoundException("branch Not Found");

        return branch.get();
    }

    @Override
    public void deleteOne(Long branchId) {
        repository.deleteById(branchId);

    }

    @Override
    public void deleteAll() {
        repository.deleteAll();

    }

    @Override
    public List<Branch> getAll() {
        List<Branch> branch = repository.findAll();
        if (branch.isEmpty()) throw new EntityNotFoundException("branches Not Available");
        return branch;
    }
}
