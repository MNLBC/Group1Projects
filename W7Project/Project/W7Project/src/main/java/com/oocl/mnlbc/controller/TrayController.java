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
 * @author DELEOAN
 *
 */
@Controller
@RequestMapping("/tray")
public class TrayController {

	@Autowired
	TrayService trayService;

	@ResponseBody
	@RequestMapping(value = { "/getTrayByUserId" }, method = RequestMethod.POST)
	public List<Tray> getTrayByUserID(@RequestParam(required = true) int userId) {
		return trayService.getTrayByUserId(userId);
	}

	@ResponseBody
	@RequestMapping(value = { "/removeTrayByUserId" }, method = RequestMethod.POST)
	public boolean removeTrayByUserId(@RequestParam(required = true) int userId) {
		return trayService.removeTrayByUserId(userId);
	}

	@ResponseBody
	@RequestMapping(value = { "/addTray" }, method = RequestMethod.POST)
	public boolean addTray(@RequestParam(required = true) String trays) {
		return trayService.addTray(trays);
	}

	@ResponseBody
	@RequestMapping(value = { "/setTraySession" }, method = RequestMethod.POST)
	public String setTraySession(@RequestParam(required = true) String trays, HttpSession session) {
		return trayService.setTraySession(trays, session);
	}

	@ResponseBody
	@RequestMapping(value = { "/getTraySession" }, method = RequestMethod.POST)
	public String getTraySession(@RequestParam(required = true) String trays, HttpSession session) {
		return trayService.getTraySession(session);
	}

}
