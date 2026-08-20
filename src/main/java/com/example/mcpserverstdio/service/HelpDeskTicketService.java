package com.example.mcpserverstdio.service;

import com.example.mcpserverstdio.entity.HelpDeskTicket;
import com.example.mcpserverstdio.model.TicketRequest;
import com.example.mcpserverstdio.repository.HelpDeskTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HelpDeskTicketService {

  private final HelpDeskTicketRepository helpDeskTicketRepository;

  public HelpDeskTicket createTicket(TicketRequest ticketInput, String priority, String contactPhone) {
    HelpDeskTicket ticket = HelpDeskTicket.builder()
            .issue(ticketInput.issue())
            .username(ticketInput.username())
            .status("OPEN")
            .priority(priority)
            .contactPhone(contactPhone)
            .createdAt(LocalDateTime.now())
            .eta(LocalDateTime.now().plusDays(7))
            .build();
    return helpDeskTicketRepository.save(ticket);
  }

  public List<HelpDeskTicket> getTicketsByUsername(String username) {
    List<HelpDeskTicket> helpDeskTickets = helpDeskTicketRepository.findByUsername(username);
    return helpDeskTickets;
  }

}
