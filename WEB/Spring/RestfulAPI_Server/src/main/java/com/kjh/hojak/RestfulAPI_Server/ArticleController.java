package com.kjh.hojak.RestfulAPI_Server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Article> test() {
		List<Article> list = new ArrayList<Article>();

		for (int i = 0; i < 10; ++i) {
			Article tempArticle = new Article();
			tempArticle.setSeq(i);
			tempArticle.setText("This is text : " + i);
			tempArticle.setTitle("This is title : " + i);
			tempArticle.setWriter("I am writer : " + i);
			
			list.add(tempArticle);
		}
		return list;
	}
	
	@RequestMapping(value="article/{seq}", method=RequestMethod.GET)
	public Article detail(@PathVariable("seq") long seq){
		Article article = new Article();
		article.setSeq(seq);
		article.setText("This this text");
		article.setTitle("This is title");
		article.setWriter("I am writer");
		
		return article;
	}
}
