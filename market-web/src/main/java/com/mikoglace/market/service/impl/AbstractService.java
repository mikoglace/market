package com.mikoglace.market.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mikoglace.market.service.IService;

@Service
abstract class AbstractService<ID extends Serializable, MODEL, DTO> implements IService<ID, MODEL, DTO> {

	@Inject
	protected Mapper mapper;
	
	protected JpaRepository<MODEL, ID> repository;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void create(DTO object) throws Exception {
		//TODO
		throw new Exception("not yet implemented");
	}

	@Transactional(readOnly=true)
	public List<DTO> getAll() throws Exception {
		List<MODEL> list = repository.findAll();
		return convertList(list);
	}

	@Transactional(readOnly=true)
	public DTO get(ID id) throws Exception {
		MODEL object = repository.findOne(id);
		return mapper.map(object, getClazz());
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(ID id) throws Exception {
		//TODO
		throw new Exception("not yet implemented");
	}

	private List<DTO> convertList(List<MODEL> list) {
		List<DTO> dtoList = new ArrayList<DTO>();
		for(MODEL m : list) {
			dtoList.add(mapper.map(m, getClazz()));
		}
		return dtoList;
	}
	
	public void setRepository(JpaRepository<MODEL, ID> repository) {
		this.repository = repository;
	}
	
	abstract Class<DTO> getClazz();
	
}
