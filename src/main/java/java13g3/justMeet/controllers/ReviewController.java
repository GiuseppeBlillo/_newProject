package java13g3.justMeet.controllers;

import java13g3.justMeet.enumerations.RatingEnum;
import java13g3.justMeet.models.Event;
import java13g3.justMeet.models.Review;
import java13g3.justMeet.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
class ReviewController {
    private ReviewService reviewService;

    @Autowired
    ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        if(reviewService.createReview(review).isPresent()) {
            return ResponseEntity.ok(review);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve")
    public ResponseEntity<?> getAllReview(){
        List<Review> reviews = reviewService.getAllReviews();
        if (!reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable("id") Long reviewId){
        if (reviewService.getReviewById(reviewId).isPresent()){
            return ResponseEntity.ok(reviewService.getReviewById(reviewId));
        } else return ResponseEntity.notFound().build();
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> retrieveReviewByRating(@PathVariable("rating") RatingEnum stars) {
        Optional<List<Review>> reviewsOptional = reviewService.getReviewByRating(stars);
        if (reviewsOptional.isPresent()) {
            List<Review> reviews = reviewsOptional.get();
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Review>> updateReview(@PathVariable("id") Long id, @RequestBody Review r){
        Optional<Review> updatedReview = reviewService.updateReview(id, r);
        if (updatedReview.isPresent()) {
            reviewService.updateReview(id,r);
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Review>> deleteReviewById(@PathVariable("id") Long id) {
        Optional<Review> optionalReview = reviewService.deleteReview(id);
        if(optionalReview.isPresent()){
            reviewService.deleteReview(id);
            return ResponseEntity.ok(optionalReview);
        };
        return ResponseEntity.notFound().build();
    }

}
