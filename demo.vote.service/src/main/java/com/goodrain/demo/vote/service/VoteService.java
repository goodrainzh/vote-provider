package com.goodrain.demo.vote.service;

public interface VoteService {
	public String agree(String name, String topic);

	public String disagree(String name, String topic);
}
