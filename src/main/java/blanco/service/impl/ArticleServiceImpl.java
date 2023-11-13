package blanco.service.impl;

import org.springframework.stereotype.Service;

import blanco.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Override
	public String getArticle() {
		
		return "Fetched Article";
	}
}
