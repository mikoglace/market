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

import com.mikoglace.market.dto.InstrumentDTO;
import com.mikoglace.market.model.Instrument;
import com.mikoglace.market.service.IService;

/**
 * REST controller for managing Instrument.
 */
@RestController
@RequestMapping("/rest/instruments")
public class InstrumentResource extends AbstractResource<Long, Instrument, InstrumentDTO, IService<Long,Instrument,InstrumentDTO>> {

	private final Logger log = LoggerFactory.getLogger(InstrumentResource.class);

	@Resource(name = "instrumentService")
	@Override
	public void setService(IService<Long, Instrument, InstrumentDTO> service) {
		super.setService(service);
	}
	
	

	/**
	 * POST /rest/instruments -> Create a new instrument.
	 * @throws Exception 
	 */
	public void create(@RequestBody InstrumentDTO object) throws Exception {
		super.create(object);
	}

	/**
	 * GET /rest/instruments -> get all the instruments.
	 * @throws Exception 
	 */
	public List<InstrumentDTO> getAll() throws Exception {
		return super.getAll();
	}

	/**
	 * GET /rest/instruments/:id -> get the "id" instrument.
	 */
	public InstrumentDTO get(@PathVariable Long id, HttpServletResponse response) {
		return super.get(id, response);
	}

	/**
	 * DELETE /rest/instruments/:id -> delete the "id" instrument.
	 */
	public void delete(@PathVariable Long id, HttpServletResponse response) {
		super.delete(id, response);
	}
	

}
