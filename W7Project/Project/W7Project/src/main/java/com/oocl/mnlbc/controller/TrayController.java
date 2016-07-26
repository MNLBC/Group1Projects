/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.dao.TrayDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.Tray;
import org.codehaus.jackson.map.DeserializationConfig;

/**
 * @author DELEOAN
 *
 */
@Controller
@RequestMapping("/tray")
public class TrayController {

	final static Logger logger = Logger.getLogger(OrderItemController.class);
	@Autowired
	TrayDAO trayDAO;

	@Autowired
	OrderDAO orderDAO;

	@ResponseBody
	@RequestMapping(value = { "/getTrayByUserId" }, method = RequestMethod.POST)
	public List<Tray> getTrayByUserID(@RequestParam(required = true) int userId) {
		List<Tray> trays = trayDAO.getAllTrayByUserId(userId);
		logger.info("Getting all order by User ID");
		return trays;
	}

	@ResponseBody
	@RequestMapping(value = { "/removeTrayByUserId" }, method = RequestMethod.POST)
	public boolean removeTrayByUserId(@RequestParam(required = true) int userId) {
		List<Tray> trays = trayDAO.getAllTrayByUserId(userId);
		for (Tray tray : trays) {
			trayDAO.delete(tray);
		}
		logger.info("Getting all order by User ID");
		return true;
	}

	@ResponseBody
	@RequestMapping(value = { "/addTray" }, method = RequestMethod.POST)
	public boolean addTray(@RequestParam(required = true) String trays) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		List<Tray> trayList = null;
		try {

			trayList = mapper.readValue(trays, mapper.getTypeFactory().constructCollectionType(List.class, Tray.class));
			trayDAO.addListTray(trayList);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

}
