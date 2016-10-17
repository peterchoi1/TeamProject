package ssa.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import ssa.entity.Login;
import ssa.entity.Review;
import ssa.service.IReviewService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class ReviewController {
	
	@Autowired
	private IReviewService ReviewService;
	
	@RequestMapping(value= "/Review/{class_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getReviewsById(@PathVariable("class_id") int class_id) {
        List<Review> review = ReviewService.getReviewsById(class_id);
        return new ResponseEntity<List<Review>>(review, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/SingleReview/{id}", method = RequestMethod.GET)
    public ResponseEntity<Review> getReviewById(@PathVariable("id") int id) {
        Review review = ReviewService.getReviewById(id);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/deletereview/{id}", method = RequestMethod.DELETE)
    public void deleteReview(@PathVariable("id") int id) {
        ReviewService.deleteReview(id);
    }
	

	@RequestMapping(value= "/insertreview/", method = RequestMethod.POST)
	public ResponseEntity<Void> insertReview(@RequestBody Review ReviewData) {
		System.out.println(ReviewData);
		ReviewService.insertReview(ReviewData);
	    return new ResponseEntity<Void>(HttpStatus.OK);    
    }
	
	
	@RequestMapping(value= "/updatereview/", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateReview(@RequestBody Review ReviewData) {
		ReviewService.updateReview(ReviewData);
		return new ResponseEntity<Void>(HttpStatus.OK);
    }

	
}
