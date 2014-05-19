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

import com.mikoglace.market.model.Portfolio;

/**
 * REST controller for managing Portfolio.
 */
@RestController
@RequestMapping("/rest/portfolios")
public class PortfolioResource extends AbstractResource<Portfolio, JpaRepository<Portfolio,Long>> {

	private final Logger log = LoggerFactory.getLogger(PortfolioResource.class);

	@Resource(name="portfolioRepository")
	public void setRepository(JpaRepository<Portfolio, Long> repository) {
		super.setRepository(repository);
	}

	/**
	 * POST /rest/portfolios -> Create a new portfolio.
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public void create(@RequestBody Portfolio object) {
		repository.save(object);
	}

	/**
	 * GET /rest/portfolios -> get all the portfolios.
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Portfolio> getAll() {
		return repository.findAll();
	}

	/**
	 * GET /rest/portfolios/:id -> get the "id" portfolio.
	 */
	public Portfolio get(@PathVariable Long id, HttpServletResponse response) {
		return super.get(id, response);
	}

	/**
	 * DELETE /rest/portfolios/:id -> delete the "id" portfolio.
	 */
	public void delete(@PathVariable Long id, HttpServletResponse response) {
		repository.delete(id);
	}
}
