package java13g3.justMeet.controllers;

import java13g3.justMeet.enumerations.RatingEnum;
import java13g3.justMeet.models.Review;
import java13g3.justMeet.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<Review>> getAllReviews() {
        if (!reviewService.getAllReviews().isEmpty()){
            return ResponseEntity.ok(reviewService.getAllReviews());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable("id") Long reviewId){
        if (reviewService.getReviewById(reviewId).isPresent()){
            return ResponseEntity.ok(reviewService.getReviewById(reviewId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/rating/{rating}")
    public ResponseEntity<List<Review>> retrieveReviewByRating(@PathVariable("rating") RatingEnum stars) {
        if (!reviewService.getReviewByRating(stars).isEmpty()) {
            return ResponseEntity.ok(reviewService.getReviewByRating(stars));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateReview(@PathVariable("id") Long id, @RequestBody Review r){
        if (reviewService.updateReview(id,r).isPresent()){
            return ResponseEntity.ok(reviewService.updateReview(id, r));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/photo/{id}")
    public ResponseEntity<?> updateReviewPhoto(@PathVariable("id") Long id, @RequestParam("file") MultipartFile multipartFile) {
        if (reviewService.updateReviewWithPhoto(id, multipartFile).isPresent()){
            return ResponseEntity.ok(reviewService.updateReviewWithPhoto(id, multipartFile));
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
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}