package com.duong.restful_api.service;

import com.duong.restful_api.entity.Booking;
import com.duong.restful_api.entity.Customer;
import com.duong.restful_api.entity.Pet;
import com.duong.restful_api.entity.Room;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.BookingDto;
import com.duong.restful_api.model.request.CreateBookingRequest;
import com.duong.restful_api.repository.BookingRepository;
import com.duong.restful_api.repository.CustomerRepository;
import com.duong.restful_api.repository.PetRepository;
import com.duong.restful_api.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BookingDto> getListBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingDto> result = new ArrayList<>();
        for (Booking booking : bookings) {
            result.add(modelMapper.map(booking, BookingDto.class));
        }
        return result;
    }

    public BookingDto createBooking(CreateBookingRequest req) {
        Room room = roomRepository.findById(req.getRoomId()).orElse(null);
        if(room == null) {
            throw new NotFoundException("Không tìm thấy phòng");
        }
        Customer customer = customerRepository.findById(req.getCustomerId()).orElse(null);
        if(customer == null) {
            throw new NotFoundException("Không tìm thấy khách hàng");
        }

        Pet pet = petRepository.findById(req.getPetId()).orElse(null);
        if(pet == null) {
            throw new NotFoundException("Không tìm thấy thú cưng");
        }


        Booking booking = new Booking();
        booking.setCheckInDate(req.getCheckInDate());
        booking.setCheckOutDate(req.getCheckOutDate());
        booking.setRoom(room);
        booking.setCustomer(customer);
        booking.setPet(pet);
        booking.setTotalPrice(req.getTotalPrice());
        bookingRepository.save(booking);
        return modelMapper.map(booking, BookingDto.class);

    }
}
