package com.akshatr.travelportal.controller;

import com.akshatr.travelportal.model.dto.destination.DestinationDetails;
import com.akshatr.travelportal.model.dto.destination.DestinationUpdateRequest;
import com.akshatr.travelportal.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
@RequiredArgsConstructor
public class DestinationController {
    private final DestinationService destinationService;

    @PostMapping("/save")
    public DestinationDetails save(@RequestBody DestinationUpdateRequest request){
        return new DestinationDetails(destinationService.update(request));
    }

    @GetMapping("/{uuid}")
    public DestinationDetails get(@PathVariable String uuid){
        return new DestinationDetails(destinationService.get(uuid));
    }

    @PostMapping("/search")
    public List<DestinationDetails> listUsers(){
        return destinationService.listDestinations().stream()
                .map(DestinationDetails::new)
                .toList();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        destinationService.delete(uuid);
    }
}
