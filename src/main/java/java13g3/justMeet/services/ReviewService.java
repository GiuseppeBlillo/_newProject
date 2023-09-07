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
    public void createReview(Review r) throws Exception {
        if (r.getFieldText().isEmpty() || r.getPhotos().isEmpty() || r.getRating() == null || r.getRegistrationId() == null) {
            throw new Exception();
        } else{
            reviewRepository.save(r);
        }
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
        if (!reviews.isEmpty()) {
            return Optional.of(reviews);
        }
        return Optional.empty();
    }

    public Optional<List<Review>> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        if (!reviews.isEmpty()) {
            return Optional.of(reviews);
        }
        return Optional.empty();
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
    public void deleteReview(Long id) throws Exception {
        if (reviewRepository.findById(id).isPresent()) {
            reviewRepository.deleteById(id);
        } else {
            throw new Exception();
        }
    }
}