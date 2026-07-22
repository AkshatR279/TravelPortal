package com.akshatr.travelportal.model.dto.ticket;

import com.akshatr.travelportal.model.dto.journey.JourneyDetails;
import com.akshatr.travelportal.model.dto.traveller.TravellerDetailsList;
import com.akshatr.travelportal.model.dto.user.UserDetails;
import com.akshatr.travelportal.model.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDetails {
    private UUID uuid;
    private String code;
    private String name;
    private Boolean active;
    private UserDetails user;
    private JourneyDetails journey;
    private TravellerDetailsList travellers;

    public TicketDetails(Ticket ticket){
        this.uuid = ticket.getUuid();
        this.code = ticket.getCode();
        this.name = ticket.getName();
        this.active = ticket.getActive();
        this.user = new UserDetails(ticket.getUser());
        this.journey = new JourneyDetails(ticket.getJourney());
        this.travellers = new TravellerDetailsList(ticket.getTravellers());
    }
}
