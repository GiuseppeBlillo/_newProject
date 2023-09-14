package java13g3.justMeet.services;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import java13g3.justMeet.enumerations.RatingEnum;
import java13g3.justMeet.models.Review;
import java13g3.justMeet.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private Storage storage;

    @Value("${google.cloud.storage.bucketName}")
    private String bucketName;

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

    public Optional<Review> updateReviewWithPhoto(Long id, MultipartFile o) {
        Optional<Review> reviewTemp = reviewRepository.findById(id);
        if (reviewTemp.isPresent()) {
            try {
                Storage st = storage;
                String buckName = bucketName;
                String objName = "review-pictures/" + id + "/" + o.getOriginalFilename();

                BlobId bID = BlobId.of(buckName, objName);
                BlobInfo bInfo = BlobInfo.newBuilder(bID).build();
                Blob bl = st.create(bInfo, o.getBytes());

                String phUrl = "https://storage.googleapis.com/" + buckName + "/" + objName;

                Review review = reviewTemp.get();

                review.setPhotos(phUrl);
                reviewRepository.save(review);
                return Optional.of(review);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }
}