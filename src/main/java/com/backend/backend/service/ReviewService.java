package com.backend.backend.service;

import com.backend.backend.dto.ReviewDto;
import java.util.List;

public interface ReviewService {
    
    ReviewDto createReview(Long productId, ReviewDto reviewDto);
    List<ReviewDto> getReviewByProductId(Long id);    
    ReviewDto getReviewById(Long reviewId, Long productId);
    ReviewDto updateReview(Long reviewId, Long productId, ReviewDto reviewDto);
    void deleteReview(Long reviewId, Long productId);
    void test();
}
