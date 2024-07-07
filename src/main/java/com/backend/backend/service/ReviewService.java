package com.backend.backend.service;

import com.backend.backend.dto.ReviewDto;
import java.util.List;

public interface ReviewService {
    
    ReviewDto createReview(Long productId, ReviewDto reviewDto);
    List<ReviewDto> getReviewByProductId(int id);
}
