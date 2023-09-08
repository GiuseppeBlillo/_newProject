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
    public Optional<Review> createReview(Review r) {
        Optional<Review> optionalReview = Optional.of(r);
        if (r.getFieldText().isEmpty() || r.getPhotos().isEmpty() || r.getRating() == null || r.getRegistrationId() == null) {
            return Optional.empty();
        } else{
            reviewRepository.save(r);
            return optionalReview;
        }
    }
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
    public Optional<Review> getReviewById(Long reviewId) {
        if (reviewRepository.findById(reviewId).isPresent()) {
            return reviewRepository.findById(reviewId);
        } else {
            return Optional.empty();
        }
    }
    public Optional<List<Review>> getReviewByRating(RatingEnum stars) {
        List<Review> reviews = reviewRepository.findByRating(stars);
        if (reviews.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(reviews);
        }
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
    public Optional<Review> deleteReview(long id){
        Optional<Review> deleteReview = reviewRepository.findById(id);
        if (deleteReview.isPresent()){
            reviewRepository.deleteById(id);
            return deleteReview;
        }else {
            return Optional.empty();
        }
    }
}