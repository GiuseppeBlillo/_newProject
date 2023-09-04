package java13g3.justMeet.services;

import java13g3.justMeet.enumerations.RatingEnum;
import java13g3.justMeet.models.Review;
import java13g3.justMeet.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    ReviewRepository reviewRepository;

    @Autowired
    ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public void createReview(Review r){
        if(r!=null) {
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

    public Optional<Review> updateReview(Long id, Review currentReview) {
        Optional<Review> updateReview = reviewRepository.findById(id);
        if (updateReview.isPresent()){
            updateReview.get().setText(currentReview.getText());
            updateReview.get().setPhotos(currentReview.getPhotos());
            updateReview.get().setRating(currentReview.getRating());
            reviewRepository.save(updateReview.get());
            return updateReview;
        } else {
            return Optional.empty();
        }
    }
    public void deleteReview(Long id){
        reviewRepository.deleteById(id);
    }
}
