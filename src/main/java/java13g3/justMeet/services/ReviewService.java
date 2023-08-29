package java13g3.justMeet.services;

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
    public Review createNew(Review r){
        if (r != null){
            return reviewRepository.save(r);
        } return null;
    }

    public List<Review> findallReviews(){
        return reviewRepository.findAll();
    }

    public Review updateReview(Review r){
        reviewRepository.deleteById(r.getId());
        return reviewRepository.save(r);
    }

    public void deleteReview(Review r){
        reviewRepository.delete(r);
    }
}
