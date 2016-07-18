package com.oocl.mnlbc.app;

import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.dao.TransactionDAO;
import com.oocl.mnlbc.dao.TransactionDAOImpl;
import com.oocl.mnlbc.models.ComboMeal;
import com.oocl.mnlbc.models.Meal;

public class AppTest {

	private static TransactionDAO transaction = new TransactionDAOImpl();

	public static void main(String[] args) {
		AppTest app = new AppTest();
		app.insertComboMeal();
		List<ComboMeal> cmList = app.disCm();
		List<Meal> list = app.display();

		// for (Meal meal : list) {
		// System.out.println(meal.getName());
		// }

		for (ComboMeal cm : cmList) {
			list = app.perCmMeal(cm.getId());
			cm.setMealList(list);
		}

		for (ComboMeal cMeal : cmList) {
			System.out.println(cMeal.getName());
			for (Meal meal : cMeal.getMealList()) {
				System.out.println("-" + meal.getName());
			}
		}

	}

	private void insertMealOnly() {
		Meal meal = new Meal("Chicken", "Crispy Fried Chicken", "Category", "M01", 32.1, "image.jpg");
		transaction.insertMeal(meal);
	}

	private void insertComboMeal() {
		ComboMeal cMeal = new ComboMeal("CM3", "39ers 2PC Chicken", "2Chicken,Rice,Drinks", 40.3, "asdasd");
		List<Meal> mList = new ArrayList<Meal>();
		transaction.insertComboMeal(cMeal);
		int id = transaction.getComboMealIdByComboCode(cMeal.getCode());
		cMeal.setId(id);
		mList.add(transaction.getMealByMealCode("M1"));
		mList.add(transaction.getMealByMealCode("M1"));
		mList.add(transaction.getMealByMealCode("M2"));
		mList.add(transaction.getMealByMealCode("M3"));
		for (Meal meal : mList) {
			transaction.insertProductGroup(cMeal.getId(), meal);
		}
		cMeal.setMealList(mList);

	}

	// private List<Meal> getMealL(){
	// return transaction.
	// }

	private List<Meal> display() {
		return transaction.getMealsByName("");
		// return
	}

	private List<ComboMeal> disCm() {
		return transaction.getComboMeals();
	}

	private List<Meal> perCmMeal(int id) {
		return transaction.getMealsByComboId(id);

	}
}
