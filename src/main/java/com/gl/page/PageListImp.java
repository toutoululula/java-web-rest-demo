package com.gl.page;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("PageList")
public class PageListImp implements PageList {
	private Page page=null;
	public Page getPageList(List<?> li,long total_size) {
		// TODO Auto-generated method stub
		if(null==li)return null;
		if(null==page)page=new Page();
		page.setRows(li);
		page.setTotal(total_size);;
		return page;
	}

	
}
