package com.mikoglace.market.web.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikoglace.market.dto.PortfolioDTO;
import com.mikoglace.market.model.Portfolio;
import com.mikoglace.market.service.IService;

/**
 * REST controller for managing Portfolio.
 */
@RestController
@RequestMapping("/rest/portfolios")
public class PortfolioResource
		extends
		AbstractResource<Long, Portfolio, PortfolioDTO, IService<Long, Portfolio, PortfolioDTO>> {

	private final Logger log = LoggerFactory.getLogger(PortfolioResource.class);

	@Resource(name = "portfolioService")
	@Override
	public void setService(IService<Long, Portfolio, PortfolioDTO> service) {
		super.setService(service);
	}

	/**
	 * POST /rest/portfolios -> Create a new portfolio.
	 * @throws Exception 
	 */
	public void create(@RequestBody PortfolioDTO object) throws Exception {
		super.create(object);
	}

	/**
	 * GET /rest/portfolios -> get all the portfolios.
	 * @throws Exception 
	 */
	public List<PortfolioDTO> getAll() throws Exception {
		return super.getAll();
	}

	/**
	 * GET /rest/portfolios/:id -> get the "id" portfolio.
	 */
	public PortfolioDTO get(@PathVariable Long id, HttpServletResponse response) {
		return super.get(id, response);
	}

	/**
	 * DELETE /rest/portfolios/:id -> delete the "id" portfolio.
	 */
	public void delete(@PathVariable Long id, HttpServletResponse response) {
		super.delete(id, response);
	}
}
