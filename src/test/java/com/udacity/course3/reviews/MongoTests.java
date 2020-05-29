package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.CommentDocument;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.repository.Mongo.MongoReviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class MongoTests {

    @Autowired
    MongoReviewRepository mongoReviewRepository;

    @AfterEach
    public void tearDown() {
        mongoReviewRepository.deleteAll();
    }

    @Test
    public void testReviewDocument() {
        CommentDocument comment = new CommentDocument();
        comment.setCommentContent("Great Phone!");
        comment.setCommentId(123);

        ReviewDocument review = new ReviewDocument();
        review.setReviewId(123);
        review.setProductId(456);
        review.setReviewContent("Phone Review");
        review.add(comment);

        mongoReviewRepository.save(review);

        ReviewDocument savedReview = mongoReviewRepository.findAll().get(0);
        CommentDocument savedComment = savedReview.getCommentDocuments().get(0);
        assertEquals(123, savedReview.getReviewId().intValue());
        assertEquals(456, savedReview.getProductId().intValue());
        assertEquals("Phone Review", savedReview.getReviewContent());
        assertEquals(123, comment.getCommentId().intValue());
        assertEquals("Great Phone!", comment.getCommentContent());

        List<Review> reviews = mongoReviewRepository.findAllByProductId(456);
        assertEquals(1,reviews.size());
        assertEquals("Phone Review",reviews.get(0).getReviewContent());

    }

}