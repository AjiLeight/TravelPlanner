package com.personal.TravelPlanner.controller.hotel;

import com.personal.TravelPlanner.dto.hotel.CapacityResponseDTO;
import com.personal.TravelPlanner.dto.hotel.UpdateCapacityRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/hotel/rooms")
@RestController
public interface RoomsController {
    @PostMapping("")
    public ResponseEntity<String> addRooms(
            @RequestParam("hotel") String hotelEmail,
            @RequestParam("capacity") Integer capacity
    );

    @GetMapping("{hotel}")
    public ResponseEntity<CapacityResponseDTO> getCapacity(@PathVariable @Email String hotel);

    @PutMapping()
    public ResponseEntity<CapacityResponseDTO> updateCapacity(@RequestBody @Valid UpdateCapacityRequestDTO request ) throws Exception;
}
