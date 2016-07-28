/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Tray;
import com.oocl.mnlbc.service.TrayService;

/**
 * This is a controller for Tray requests
 * 
 * @author DELEOAN
 * @since 07/22/16
 */
@Controller
@RequestMapping("/tray")
public class TrayController {
	/**
	 * Automatic instantiation of Tray Service
	 */
	@Autowired
	TrayService trayService;

	/**
	 * This request is for getting all the tray by user id.
	 * 
	 * @param userId
	 *            the id of the user to be retrieved
	 * @return the list of all tray
	 */
	@ResponseBody
	@RequestMapping(value = { "/getTrayByUserId" }, method = RequestMethod.POST)
	public List<Tray> getTrayByUserID(@RequestParam(required = true) int userId) {
		return trayService.getTrayByUserId(userId);
	}

	/**
	 * This request is for removing tray using user id
	 * 
	 * @param userId
	 *            the id of the user to be removed
	 * @return a boolean result of deletion
	 */
	@ResponseBody
	@RequestMapping(value = { "/removeTrayByUserId" }, method = RequestMethod.POST)
	public boolean removeTrayByUserId(@RequestParam(required = true) int userId) {
		return trayService.removeTrayByUserId(userId);
	}

	/**
	 * This request is for adding tray
	 * 
	 * @param trays
	 *            the string tray to be inserted
	 * @return a boolean result of insertion
	 */
	@ResponseBody
	@RequestMapping(value = { "/addTray" }, method = RequestMethod.POST)
	public boolean addTray(@RequestParam(required = true) String trays) {
		return trayService.addTray(trays);
	}

	/**
	 * This request is for putting tray to session
	 * 
	 * @param trays
	 *            the string tray to be put to session
	 * @param session
	 *            the session of the page request
	 * @return a string of success
	 */
	@ResponseBody
	@RequestMapping(value = { "/setTraySession" }, method = RequestMethod.POST)
	public String setTraySession(@RequestParam(required = true) String trays, HttpSession session) {
		return trayService.setTraySession(trays, session);
	}

	/**
	 * This request is for getting tray from session
	 * 
	 * @param session
	 *            the session of the page request
	 * @return a string of success
	 */
	@ResponseBody
	@RequestMapping(value = { "/getTraySession" }, method = RequestMethod.GET)
	public String getTraySession(HttpSession session) {
		return trayService.getTraySession(session);
	}

}
