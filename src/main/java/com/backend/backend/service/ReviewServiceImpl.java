package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.dto.ReviewDto;
import com.backend.backend.exception.ProductNotFoundException;
import com.backend.backend.model.Product;
import com.backend.backend.model.Review;
import com.backend.backend.repository.ProductRepository;
import com.backend.backend.repository.ReviewRepository;
import com.backend.backend.service.*;
import java.util.stream.Collectors;

@Service
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
        Review review = mapToEntity(reviewDto);

        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product with id not found!"));

        review.setProduct(product);

        Review newReview = reviewRepository.save(review);

        return mapToDto(newReview);
    }

    @Override
    public List<ReviewDto> getReviewByProductId(Long id) {
        List<Review> reviews = reviewRepository.findByProductId(id);

        return reviews.stream().map(review -> mapToDto(review)).collect((Collectors.toList()));
    }

    private ReviewDto mapToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setContent(review.getContent());
        reviewDto.setRate(review.getRate());
        return reviewDto;
    }

    private Review mapToEntity(ReviewDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setRate(reviewDto.getRate());
        return review;
    }
    
}
