package com.akshatr.travelportal.controller;

import com.akshatr.travelportal.model.dto.traveller.TravellerDetails;
import com.akshatr.travelportal.model.dto.traveller.TravellerUpdateRequest;
import com.akshatr.travelportal.service.TravellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traveller")
@RequiredArgsConstructor
public class TravellerController {
    private final TravellerService travellerService;

    @PostMapping("/save")
    public TravellerDetails save(@RequestBody TravellerUpdateRequest request){
        return new TravellerDetails(travellerService.update(request));
    }

    @GetMapping("/{uuid}")
    public TravellerDetails get(@PathVariable String uuid){
        return new TravellerDetails(travellerService.get(uuid));
    }

    @PostMapping("/search")
    public List<TravellerDetails> listUsers(){
        return travellerService.listTravellers().stream()
                .map(TravellerDetails::new)
                .toList();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        travellerService.delete(uuid);
    }
}
