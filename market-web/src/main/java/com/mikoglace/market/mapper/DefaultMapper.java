package com.mikoglace.market.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultMapper extends DozerBeanMapper {
	
	public DefaultMapper() {
		List<String> mappingFileUrls = new ArrayList<>();
		mappingFileUrls.add("dozer/portfolio.xml");
		this.setMappingFiles(mappingFileUrls);
	}

}
