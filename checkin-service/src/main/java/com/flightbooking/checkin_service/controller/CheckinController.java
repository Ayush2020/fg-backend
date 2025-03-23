package com.flightbooking.checkin_service.controller;

import com.flightbooking.checkin_service.dto.CheckinRequest;
import com.flightbooking.checkin_service.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkin")
public class CheckinController {

    @Autowired
    private CheckinService checkinService;

    @PostMapping
    public String checkInPassenger(@RequestBody CheckinRequest request) {
        return checkinService.checkInPassenger(request);
    }
}
