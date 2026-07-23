package com.akshatr.travelportal.model.dto.ticket;

import com.akshatr.travelportal.model.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDetailsList {
    private int count;
    private List<TicketDetails> ticketsList;

    public TicketDetailsList(List<Ticket> tickets){
        this.count = tickets.size();
        this.ticketsList = tickets.stream()
                .map(TicketDetails::new)
                .toList();
    }
}
