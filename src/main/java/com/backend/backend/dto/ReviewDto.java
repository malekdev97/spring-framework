package com.backend.backend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class ReviewDto {
    private Long id;
    private String title;
    private String content;
    private int rate;

    public ReviewDto(){
        
    }
}
