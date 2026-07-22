package com.akshatr.travelportal.controller;

import com.akshatr.travelportal.model.dto.company.CompanyDetails;
import com.akshatr.travelportal.model.dto.company.CompanyUpdateRequest;
import com.akshatr.travelportal.model.dto.user.UserDetails;
import com.akshatr.travelportal.model.dto.user.UserUpdateRequest;
import com.akshatr.travelportal.service.CompanyService;
import com.akshatr.travelportal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/save")
    public CompanyDetails save(@RequestBody CompanyUpdateRequest request){
        return new CompanyDetails(companyService.update(request));
    }

    @GetMapping("/{uuid}")
    public CompanyDetails get(@PathVariable String uuid){
        return new CompanyDetails(companyService.get(uuid));
    }

    @PostMapping("/search")
    public List<CompanyDetails> listUsers(){
        return companyService.listCompanies().stream()
                .map(CompanyDetails::new)
                .toList();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        companyService.delete(uuid);
    }
}
