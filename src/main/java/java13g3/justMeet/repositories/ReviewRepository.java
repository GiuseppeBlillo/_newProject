package java13g3.justMeet.repositories;

import java13g3.justMeet.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByRating(Integer stars);
}
