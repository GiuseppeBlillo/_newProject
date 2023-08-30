package java13g3.justMeet.controllers;

import java13g3.justMeet.enumerations.RatingEnum;
import java13g3.justMeet.models.Review;
import java13g3.justMeet.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/review")
class ReviewController {
    private ReviewService reviewService;

    @Autowired
    ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody Review review){
        if (review != null){
            reviewService.createReview(review);
            return ResponseEntity.ok("Review created!");
        } else return ResponseEntity.badRequest().body("Review cannot be created!");
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<Review>> reviewList(){
        try{
            return ResponseEntity.ok(reviewService.getAllReviews());
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") Long reviewId){
        if (reviewService.getReviewById(reviewId) != null){
            return ResponseEntity.ok(reviewService.getReviewById(reviewId));
        } else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Review>> retrieveReviewByRating(@PathVariable("rating") RatingEnum stars){
        try{
            return ResponseEntity.ok(reviewService.getReviewByRating(stars));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateReview(@RequestBody Review review){
        try{
            reviewService.updateReview(review);
            return ResponseEntity.ok("Recensione aggiornata!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Impossibile aggiornare la recensione!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable("id") Long id){
        try{
            reviewService.deleteReview(id);
            return ResponseEntity.ok("Recensione cancellata!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Impossibile cancellare la recensione!");
        }
    }

}
