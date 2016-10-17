package ssa.service;

import java.util.List;

import ssa.entity.Review;

public interface IReviewService {

	List<Review> getReviewsById(int class_id);
	Review getReviewById(int id);
	void deleteReview(int id);
	void insertReview(Review Review);
	void updateReview(Review Review);
}
