package com.akshatr.travelportal.controller;

import com.akshatr.travelportal.model.dto.ticket.TicketDetails;
import com.akshatr.travelportal.model.dto.ticket.TicketUpdateRequest;
import com.akshatr.travelportal.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/save")
    public TicketDetails save(@RequestBody TicketUpdateRequest request){
        return new TicketDetails(ticketService.update(request));
    }

    @GetMapping("/{uuid}")
    public TicketDetails get(@PathVariable String uuid){
        return new TicketDetails(ticketService.get(uuid));
    }

    @PostMapping("/search")
    public List<TicketDetails> listUsers(){
        return ticketService.listTickets().stream()
                .map(TicketDetails::new)
                .toList();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        ticketService.delete(uuid);
    }
}
