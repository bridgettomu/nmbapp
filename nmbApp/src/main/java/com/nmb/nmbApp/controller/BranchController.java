package com.nmb.nmbApp.controller;

import com.nmb.nmbApp.dto.AddBranchDTO;
import com.nmb.nmbApp.dto.UpdateBranchDTO;
import com.nmb.nmbApp.model.Branch;
import com.nmb.nmbApp.service.iface.BranchService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/branch",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BranchController {
    private final BranchService service;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<Branch> addBranch(@RequestBody AddBranchDTO addBranchDTO){
        Branch branch = modelMapper.map(addBranchDTO,Branch.class);
        return ResponseEntity.ok(service.add(branch));
    }

    @PutMapping("/update")
    public ResponseEntity<Branch> updateBranch(@RequestBody UpdateBranchDTO updateBranchDTO){
        Branch branch = modelMapper.map(updateBranchDTO,Branch.class);
        return ResponseEntity.ok(service.update(branch));
    }
    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Branch> getAllBranches(){
        return service.getAll();
    }

    @DeleteMapping("/one/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneBranch(@PathVariable("id") Long id){
        service.deleteOne(id);
    }

    @DeleteMapping("/delete-all")
    @ResponseStatus(HttpStatus.OK)
    public void getOneBranch(){
        service.deleteAll();
    }
}
