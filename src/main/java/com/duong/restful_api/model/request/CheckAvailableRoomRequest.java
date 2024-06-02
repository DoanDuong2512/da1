package com.duong.restful_api.model.request;

import com.duong.restful_api.entity.constant.FormatDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.text.DateFormat;
import java.time.LocalDateTime;

@Data
public class CheckAvailableRoomRequest {
    @JsonFormat(pattern = FormatDate.DATE_FORMAT)
    private LocalDateTime startDate;

    @JsonFormat(pattern = FormatDate.DATE_FORMAT)
    private LocalDateTime endDate;
}
