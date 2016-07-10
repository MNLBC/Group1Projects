package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oocl.mnlbc.dao.TransactionDAO;
import com.oocl.mnlbc.dao.TransactionDAOImpl;
import com.oocl.mnlbc.models.Meal;

public class TransactionTest {
	TransactionDAO trans = new TransactionDAOImpl();

	@Test
	public void testInsertUser() {
		Meal meal = new Meal("Sprite", "Sprite", "Drinks", "D01", 12, "resource/img/sprite.png");
		fail("Not yet implemented");
	}

	@Test
	public void testInsertMeal() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertComboMeal() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertProductGroup() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOrderItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsUsernameExisting() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmailExisting() {
		fail("Not yet implemented");
	}

}
