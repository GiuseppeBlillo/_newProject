package java13g3.justMeet.services;

import java13g3.justMeet.enumerations.RatingEnum;
import java13g3.justMeet.models.Review;
import java13g3.justMeet.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    ReviewRepository reviewRepository;

    @Autowired
    ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public void createReview(Review r){
        if (r != null){
            reviewRepository.save(r);
        }
    }
    public Review getReviewById(Long reviewId){
        return reviewRepository.findById(reviewId).orElse(null);
    }
    public List<Review> getReviewByRating(RatingEnum stars){
        return reviewRepository.findByRating(stars);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public void updateReview(Long id,Review r){
        reviewRepository.deleteById(id);
        reviewRepository.save(r);
    }
    public void deleteReview(Long id){
        reviewRepository.deleteById(id);
    }
}
