package java13g3.justMeet.controllers;

import java13g3.justMeet.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ReviewController {
    ReviewService reviewService;

    @Autowired
    ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
