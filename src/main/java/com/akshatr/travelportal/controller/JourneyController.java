package com.akshatr.travelportal.controller;

import com.akshatr.travelportal.model.dto.company.CompanyDetails;
import com.akshatr.travelportal.model.dto.company.CompanyUpdateRequest;
import com.akshatr.travelportal.model.dto.journey.JourneyDetails;
import com.akshatr.travelportal.model.dto.journey.JourneyUpdateRequest;
import com.akshatr.travelportal.service.CompanyService;
import com.akshatr.travelportal.service.JourneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journey")
@RequiredArgsConstructor
public class JourneyController {
    private final JourneyService journeyService;

    @PostMapping("/save")
    public JourneyDetails save(@RequestBody JourneyUpdateRequest request){
        return new JourneyDetails(journeyService.update(request));
    }

    @GetMapping("/{uuid}")
    public JourneyDetails get(@PathVariable String uuid){
        return new JourneyDetails(journeyService.get(uuid));
    }

    @PostMapping("/search")
    public List<JourneyDetails> listUsers(){
        return journeyService.listJourneys().stream()
                .map(JourneyDetails::new)
                .toList();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        journeyService.delete(uuid);
    }
}
