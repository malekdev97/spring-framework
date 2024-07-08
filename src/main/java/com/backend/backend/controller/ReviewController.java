package com.backend.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.backend.dto.ReviewDto;
import com.backend.backend.service.ReviewService;

@RestController
@RequestMapping("/api/v1/")
public class ReviewController {
    
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/product/{pId}/reviews")
    public ResponseEntity<List<ReviewDto>> getReviewByProductId(@PathVariable Long pId) {
        return ResponseEntity.ok(reviewService.getReviewByProductId(pId));
    }

    @PostMapping("/product/{pId}/reviews/create")
    public ResponseEntity<ReviewDto> createReview(@PathVariable Long pId, @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.ok(reviewService.createReview(pId, reviewDto));
    }

    @GetMapping("/product/{pId}/reviews/{rId}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable(value = "pId") Long pId, @PathVariable(value = "rId") Long rId) {
        return ResponseEntity.ok(reviewService.getReviewById(pId, rId));
    }

    @PutMapping("/product/{pId}/reviews/{rId}/update")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long pId, @PathVariable Long rId, @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.ok(reviewService.updateReview(pId, rId, reviewDto));
    }

    @DeleteMapping("/product/{pId}/reviews/{rId}/delete")
    public ResponseEntity<String> deleteReview(@PathVariable Long pId, @PathVariable Long rId) {
        reviewService.deleteReview(pId, rId);
        return ResponseEntity.ok("Review deleted successfully!!");
    }
}
