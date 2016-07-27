package com.oocl.mnlbc.service.impl;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.dao.TrayDAO;
import com.oocl.mnlbc.entity.Tray;

@Service
public class TrayService {
	
	final static Logger logger = Logger.getLogger(TrayService.class);
	
	@Autowired
	TrayDAO trayDao;
	
	public List<Tray> getTrayByUserId(int userId){
		logger.info("Getting all order by User ID");
		return trayDao.getAllTrayByUserId(userId);
	}
	
	public boolean removeTrayByUserId(int userId){
		List<Tray> trays =  getTrayByUserId(userId);
		logger.info("Getting all order tray by User ID");
		for (Tray tray : trays) {
			trayDao.delete(tray);
		}
		logger.info("Removing all order by User ID");
		return true;
	}
	
	public boolean addTray(String trays){
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		List<Tray> trayList = null;
		try {
			trayList = mapper.readValue(trays, mapper.getTypeFactory().constructCollectionType(List.class, Tray.class));
			trayDao.addListTray(trayList);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Adding  all order by User ID");
		return true;
	}
	
	
}
