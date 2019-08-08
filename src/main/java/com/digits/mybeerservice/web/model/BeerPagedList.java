package com.digits.mybeerservice.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPagedList extends PageImpl<BeerDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3292484938112870999L;

	public BeerPagedList(List<BeerDto> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}
	
	public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

}
