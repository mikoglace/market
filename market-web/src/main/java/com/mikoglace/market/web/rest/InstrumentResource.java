package com.mikoglace.market.web.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mikoglace.market.model.Instrument;

/**
 * REST controller for managing Portfolio.
 */
@RestController
@RequestMapping("/rest/instruments")
public class InstrumentResource extends AbstractResource<Instrument, JpaRepository<Instrument,Long>> {

	private final Logger log = LoggerFactory.getLogger(InstrumentResource.class);

	@Resource(name="instrumentRepository")
	public void setRepository(JpaRepository<Instrument, Long> repository) {
		super.setRepository(repository);
	}

	/**
	 * POST /rest/instruments -> Create a new Instrument.
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public void create(@RequestBody Instrument object) {
		repository.save(object);
	}

	/**
	 * GET /rest/instruments -> get all the portfolios.
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Instrument> getAll() {
		return repository.findAll();
	}

	/**
	 * GET /rest/instruments/:id -> get the "id" portfolio.
	 */
	public Instrument get(@PathVariable Long id, HttpServletResponse response) {
		return super.get(id, response);
	}

	/**
	 * DELETE /rest/instruments/:id -> delete the "id" portfolio.
	 */
	public void delete(@PathVariable Long id, HttpServletResponse response) {
		repository.delete(id);
	}
}
