package com.personal.TravelPlanner.experimental;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.entity.hotel.Booking;
import com.personal.TravelPlanner.repository.hotel.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class DemoController {
    private  final BookingRepository repository;
    private final MongoTemplate mongoTemplate;

    @PostMapping
    public Booking demoBookingUpdate(@RequestBody Booking request){
        return mongoTemplate.save(request);
    }

    @GetMapping()
    public List<Booking> booking(@RequestBody Search search){
        List<LocalDate> dates = extractDates(search.getFrom(), search.getTo());
        Query query = new Query(Criteria.where("city").is(search.getCity()).and("date").in(dates).and("rooms").gt(0));
        List<Booking> booking =  mongoTemplate.find(query, Booking.class);
        return booking;
    }

    private List<LocalDate> extractDates(LocalDate fromDate, LocalDate toDate) {
        List<LocalDate> dates = new ArrayList<>();

        LocalDate currentDate = fromDate;
        while (!currentDate.isEqual(toDate)) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        return dates;
    }

}

