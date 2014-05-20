package com.mikoglace.market.web.rest;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mikoglace.market.service.IService;


@RequestMapping("/rest")
abstract class AbstractResource<ID extends Serializable, MODEL, DTO, S extends IService<ID, MODEL, DTO>> {

	private final Logger log = LoggerFactory.getLogger(InstrumentResource.class);

	protected S service;
	
	/**
	 * POST /rest/instruments -> Create a new instrument.
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public void create(@RequestBody DTO object) throws Exception {
		log.debug("REST request to save : {}", object);
		service.create(object);
	}

	/**
	 * GET /rest/instruments -> get all the instruments.
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<DTO> getAll() throws Exception {
		log.debug("REST request to get all");
		return service.getAll();
	}

	/**
	 * GET /rest/instruments/:id -> get the "id" instrument.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public DTO get(@PathVariable ID id, HttpServletResponse response) {
		log.debug("REST request to get : {}", id);
		DTO object = null;
		try {
			object = service.get(id);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		if (object == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return object;
	}

	/**
	 * DELETE /rest/instruments/:id -> delete the "id" instrument.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable ID id, HttpServletResponse response) {
		log.debug("REST request to delete : {}", id);
		try {
			service.delete(id);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	public void setService(S service) {
		this.service = service;
	}
	
}
