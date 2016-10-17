package ssa.dao;

import java.util.List;

import ssa.entity.Review;

public interface IReviewDAO {
	
	List<Review> getReviewsById(int class_id);
	Review getReviewById(int id);
	void insertReview(Review Review);
	void deleteReview(int id);
	void updateReview(Review Review);

}
