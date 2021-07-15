package com.techelevator;

import com.techelevator.view.*;

import java.io.FileNotFoundException;
import java.util.*;


public class CateringSystemCLI {

	private final String PRINT_MAIN_MENU_DISPLAY_ITEMS1 = "1";
	private final String MAIN_MENU_ORDER2 = "2";
	private final String MAIN_MENU_QUIT="3";
	private final String MENU2_ADD_MONEY = "1";
	private final String MENU2_SELECT_PRODUCT = "2";
	private final String MENU2_COMPLETE_TRANSACTION = "3";


	private UI ui;
	private CashRegister cash;
	AuditReport auditReport = new AuditReport();
	Item item=new Item();
	Inventory inventory = new Inventory("cateringsystem.csv");
	TreeMap<String, Item> map = inventory.loadInventoryItems();


	public CateringSystemCLI(UI ui) throws FileNotFoundException {
		this.ui = ui;
		this.cash = new CashRegister();
	}

	public static void main(String[] args) throws FileNotFoundException {
		UI menu = new UI();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}


	public void run() {


		//probably should do stuff here... ;-)
        ui.cateringSystem();
		boolean runningMain = true;
		while (runningMain) {
			String response = ui.printOptionsMenu1();
			if (response.equals(PRINT_MAIN_MENU_DISPLAY_ITEMS1)) {

				ui.printListOfItems(map);
			} else if (response.equals(MAIN_MENU_ORDER2)) {

				boolean isMenu2Again = true;
				while (isMenu2Again) {

					//display menu2
					String printOptionsMenuResponse2 = ui.printOptionsMenu2(cash.getBalance());
					if (printOptionsMenuResponse2.equals(MENU2_ADD_MONEY)) {

						String userAddMoney = ui.addMoneyOption();
						double addMoney1 = Double.parseDouble(userAddMoney);

						auditReport.addMoneyWriter(addMoney1,cash.getBalance()+addMoney1);

						cash.addMoney(addMoney1);


					} else if (printOptionsMenuResponse2.equals(MENU2_SELECT_PRODUCT)) {

						ui.printListOfItems(map);

						String userSelectProduct = ui.selectItemWithCode();


						if (map.containsKey(userSelectProduct)) {
							String userSelectQuantity = ui.selectItemQuantity();



							boolean b = map.get(userSelectProduct).getItemCount() >= Integer.parseInt(userSelectQuantity);


							if (map.get(userSelectProduct).isEnoughQuantity() && cash.getBalance() >= map.get(userSelectProduct).getPrice() * Double.parseDouble(userSelectQuantity) && b) {

									map.get(userSelectProduct).setItemCount(map.get(userSelectProduct).getItemCount() - Integer.parseInt(userSelectQuantity));


								cash.withdrawMoney(map.get(userSelectProduct).getPrice() * Double.parseDouble(userSelectQuantity));

								List<String> listOfPurchasedItems = cash.log(map.get(userSelectProduct).getName(),Integer.parseInt(userSelectQuantity), map.get(userSelectProduct).getItemType(),( map.get(userSelectProduct).getPrice() * Double.parseDouble(userSelectQuantity)), cash.getBalance());
								for (String item : listOfPurchasedItems) {
									System.out.println(item);
								}
								auditReport.addItemToCartWriter(map.get(userSelectProduct),Integer.parseInt(userSelectQuantity),cash.getBalance());
								System.out.println("Item purchased\n");
							} else if (!b) {
								System.out.println("Insufficient amount");


							} else {
								System.out.println("Insufficient Funds,please make a deposit");

							}

						} else {
							System.out.println("NOT VALID CODE");

						}


					} else if (printOptionsMenuResponse2.equalsIgnoreCase(MENU2_COMPLETE_TRANSACTION)) {
						cash.printChange(cash.getBalance());
						cash.getChangeBills(cash.getBalance());
						auditReport.giveChangeWriter(cash.getBalance());
						cash.setBalance(0.0);

					    System.out.println("Current Account balance : $" + cash.getBalance() + "\n");

						break;
					}

					runningMain = true;
				}


			}else if(response.equalsIgnoreCase(MAIN_MENU_QUIT)){
				runningMain=false;
			}

		}


	}
}





	



