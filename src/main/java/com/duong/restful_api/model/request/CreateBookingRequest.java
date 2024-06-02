package com.duong.restful_api.model.request;

import com.duong.restful_api.entity.Customer;
import com.duong.restful_api.entity.Pet;
import com.duong.restful_api.entity.Room;
import com.duong.restful_api.entity.constant.FormatDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateBookingRequest {
    @JsonFormat(pattern = FormatDate.DATE_FORMAT)
    private LocalDateTime checkInDate;

    @JsonFormat(pattern = FormatDate.DATE_FORMAT)
    private LocalDateTime checkOutDate;

    private BigDecimal totalPrice;

    private String cameraLink;

    private int customerId;

    private int roomId;

    private int petId;
}
