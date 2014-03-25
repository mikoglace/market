package com.mikoglace.market.web.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mikoglace.market.model.Portfolio;
import com.mikoglace.market.repository.PortfolioRepository;

/**
 * REST controller for managing Portfolio.
 */
@RestController
@RequestMapping("/app")
public class PortfolioResource {

	private final Logger log = LoggerFactory.getLogger(PortfolioResource.class);

	@Resource(name="portfolioRepository")
	private PortfolioRepository portfolioRepository;

	/**
	 * POST /rest/portfolios -> Create a new portfolio.
	 */
	@RequestMapping(value = "/rest/portfolios", method = RequestMethod.POST, produces = "application/json")
	public void create(@RequestBody Portfolio portfolio) {
		log.debug("REST request to save Portfolio : {}", portfolio);
		portfolioRepository.save(portfolio);
	}

	/**
	 * GET /rest/portfolios -> get all the portfolios.
	 */
	@RequestMapping(value = "/rest/portfolios", method = RequestMethod.GET, produces = "application/json")
	public List<Portfolio> getAll() {
		log.debug("REST request to get all Portfolios");
		return portfolioRepository.findAll();
	}

	/**
	 * GET /rest/portfolios/:id -> get the "id" portfolio.
	 */
	@RequestMapping(value = "/rest/portfolios/{id}", method = RequestMethod.GET, produces = "application/json")
	public Portfolio get(@PathVariable Long id, HttpServletResponse response) {
		log.debug("REST request to get Portfolio : {}", id);
		Portfolio portfolio = portfolioRepository.findOne(id);
		if (portfolio == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return portfolio;
	}

	/**
	 * DELETE /rest/portfolios/:id -> delete the "id" portfolio.
	 */
	@RequestMapping(value = "/rest/portfolios/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable Long id, HttpServletResponse response) {
		log.debug("REST request to delete Portfolio : {}", id);
		portfolioRepository.delete(id);
	}
}
