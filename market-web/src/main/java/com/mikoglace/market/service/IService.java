package com.mikoglace.market.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IService<ID extends Serializable, MODEL, DTO> {
	
	public void create(DTO object) throws Exception ;

	public List<DTO> getAll() throws Exception;

	public DTO get(ID id) throws Exception;

	public void delete(ID id) throws Exception;

}
