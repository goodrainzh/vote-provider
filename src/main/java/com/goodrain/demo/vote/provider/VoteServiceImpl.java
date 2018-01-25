package com.goodrain.demo.vote.provider;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.goodrain.demo.vote.service.VoteService;

@Component("voteService")
public class VoteServiceImpl implements VoteService {
	private Logger logger = LoggerFactory.getLogger(VoteServiceImpl.class);

	Map<String, Integer> voteMapDB = new HashMap<String, Integer>();

	public String agree(String name, String topic) {
		if (!voteMapDB.containsKey(topic)) {
			voteMapDB.put(topic, 1);
		} else {
			voteMapDB.put(topic, voteMapDB.get(topic) + 1);
		}
		logger.info("User [ {} ] vote topic [ {} ] agree! now topic count is [ {} ]", name, topic,
				voteMapDB.get(topic));
		return "User [ "+ name +" ] vote topic ["+ topic +"] agree! now topic count is [ "+ voteMapDB.get(topic) +" ]";
	}

	public String disagree(String name, String topic) {
		if (!voteMapDB.containsKey(topic)) {
			voteMapDB.put(topic, 0);
		} else {
			voteMapDB.put(topic, voteMapDB.get(topic) - 1);
		}
		logger.info("User [ {} ] vote topic [ {} ] disagree! now topic count is [ {} ]", name, topic,
				voteMapDB.get(topic));
		return "User [ "+ name +" ] vote topic ["+ topic +"] disagree! now topic count is [ "+ voteMapDB.get(topic) +" ]";
	}

}
