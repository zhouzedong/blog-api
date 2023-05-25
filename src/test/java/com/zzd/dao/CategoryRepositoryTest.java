package com.zzd.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzd.BlogApiApplicationTests;
import com.zzd.repository.CategoryRepository;

public class CategoryRepositoryTest extends BlogApiApplicationTests{

	@Autowired
	private CategoryRepository	categoryRepository;

	@Test
	public void test() {
	}
}
