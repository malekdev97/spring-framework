package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.backend.dto.ReviewDto;
import com.backend.backend.model.Product;
import com.backend.backend.model.Review;
import com.backend.backend.repository.ProductRepository;
import com.backend.backend.repository.ReviewRepository;

public class ReviewServiceImpl implements ReviewService {

    private ProductRepository productRepository;
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ReviewDto createReview(Long productId, ReviewDto reviewDto) {
        return null;

    }

    @Override
    public List<ReviewDto> getReviewByProductId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReviewByProductId'");
    }
    
}
