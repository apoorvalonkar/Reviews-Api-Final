package com.udacity.course3.reviews.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Integer commentId;

	@Column(name = "comment_text")
	private String commentContent;

	@ManyToOne(targetEntity = Review.class)
	@JoinColumn(name = "review_id")
	private Review review;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Review getReviewId() {
		return review;
	}

	public void setReviewId(Review review) {
		this.review = review;
	}
}
