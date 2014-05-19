package com.mikoglace.market.web.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/rest")
abstract class AbstractResource<T, R extends JpaRepository<T, Long>> {

	private final Logger log = LoggerFactory.getLogger(InstrumentResource.class);

	protected R repository;
	
	/**
	 * POST /rest/instruments -> Create a new instrument.
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public void create(@RequestBody T object) {
		log.debug("REST request to save : {}", object);
		repository.save(object);
	}

	/**
	 * GET /rest/instruments -> get all the instruments.
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<T> getAll() {
		log.debug("REST request to get all");
		return repository.findAll();
	}

	/**
	 * GET /rest/instruments/:id -> get the "id" instrument.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public T get(@PathVariable Long id, HttpServletResponse response) {
		log.debug("REST request to get : {}", id);
		T object = repository.findOne(id);
		if (object == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return object;
	}

	/**
	 * DELETE /rest/instruments/:id -> delete the "id" instrument.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable Long id, HttpServletResponse response) {
		log.debug("REST request to delete : {}", id);
		repository.delete(id);
	}

	public void setRepository(R repository) {
		this.repository = repository;
	}
	
}
