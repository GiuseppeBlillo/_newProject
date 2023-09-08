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
    @Autowired
    private ReviewRepository reviewRepository;
    public Review createReview(Review r) {
        return reviewRepository.save(r);
    }
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }
    public List<Review> getReviewByRating(RatingEnum stars) {
        return reviewRepository.findByRating(stars);
    }
    public Optional<Review> updateReview(Long id, Review currentReview) {
        Optional<Review> updateReview = reviewRepository.findById(id);
        if (updateReview.isPresent()){
            updateReview.get().setText(currentReview.getText());
            updateReview.get().setPhotos(currentReview.getPhotos());
            updateReview.get().setRating(currentReview.getRating());
            return Optional.of(reviewRepository.save(updateReview.get()));
        } else {
            return Optional.empty();
        }
    }
    public Optional<Review> deleteReview(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent()) {
            reviewRepository.deleteById(id);
            return optionalReview;
        } else {
            return Optional.empty();
        }
    }
}