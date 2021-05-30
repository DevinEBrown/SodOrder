package edu.cpt187.brown.participation;

public class SodOrder 
{

	//Class CONSTANTS
	private final String ITEM_NAME_PREMIUM = "Premium Sod";
	private final String ITEM_NAME_SPECIAL = "Special Sod";
	private final String ITEM_NAME_BASIC = "Basic Sod";
	private final double ITEM_PRICE_PREMIUM = 9.95;
	private final double ITEM_PRICE_SPECIAL = 5.95;
	private final double ITEM_PRICE_BASIC = 1.95;
	private final String DISCOUNT_NAME_MEMBER = "Member";
	private final String DISCOUNT_NAME_SENIOR = "Senior";
	private final String DISCOUNT_NAME_NONE = "No Discount";
	private final double DISCOUNT_RATE_MEMBER = .25; 
	private final double DISCOUNT_RATE_SENIOR = .15;
	private final double DISCOUNT_RATE_NONE = 0.0;
	private final double TAX_RATE = .075;

	//non class CONSTANTS 
	private String itemName = "";
	private double itemPrice = 0.0;
	private double discountRate = 0.0; 
	private int howMany = 0; 

	public SodOrder()
	{	
	}//End of Constructor


	//set method
	public void setItemName(char borrowedMenuSelection) 
	{
		if (borrowedMenuSelection =='A') 
		{
			itemName = ITEM_NAME_PREMIUM;
		}
		else if (borrowedMenuSelection =='B')
		{
			itemName = ITEM_NAME_SPECIAL; 
		}
		else 
		{
			itemName = ITEM_NAME_BASIC;
		}
	}//end of setItemName

	public void setItemPrice(char borrowedMenuSelection)
	{
		if (borrowedMenuSelection == 'A') 
		{
			itemPrice = ITEM_PRICE_PREMIUM;
		}
		else if (borrowedMenuSelection == 'B') 
		{
			itemPrice = ITEM_PRICE_SPECIAL; 
		}
		else 
		{
			itemPrice = ITEM_PRICE_BASIC; 
		}
	}//End of setItemPrice


	public void setDiscountRate(char borrowedMenuSelection) 
	{
		if (borrowedMenuSelection =='A') 
		{
			discountRate = DISCOUNT_RATE_MEMBER;
		}
		else if(borrowedMenuSelection =='B') 
		{
			discountRate = DISCOUNT_RATE_SENIOR; 
		}
		else 
		{
			discountRate = DISCOUNT_RATE_NONE; 
		}
	}//End of setDiscountRate
	
	public void setHowMany(int borrowedHowMany)
	{
		howMany = borrowedHowMany; 
	}

	//get method
	public String getItemName()
	{
		return itemName; 
	}

	public double getItemPrice()
	{
		return itemPrice; 
	}

	public int getHowMany()
	{
		return howMany;
	}

	public double getDiscountRate() 
	{
		return discountRate; 
	}

	public double getDiscountAmt()
	{
		return itemPrice*discountRate; 
	}

	public double getDiscountPrice()
	{
		return itemPrice - getDiscountAmt();		
	}

	public double getSubTotal()
	{
		return howMany*getDiscountPrice();	
	}

	public double getTaxRate()
	{
		return TAX_RATE; 
	}
	public double getTaxAmt()
	{
		return TAX_RATE*getSubTotal();
	}

	public double getTotalCost() 
	{
		return getTaxAmt()+getSubTotal(); 
	}

	
	public String getItemNamePremium()
	{
		return ITEM_NAME_PREMIUM; 
	}

	public String getItemNameSpecial()
	{
		return ITEM_NAME_SPECIAL; 
	}

	public String getItemNameBasic() 
	{
		return ITEM_NAME_BASIC;
	}

	public double getItemPricePremium()
	{
		return ITEM_PRICE_PREMIUM; 
	}

	public double getItemPriceSpecial()
	{
		return ITEM_PRICE_SPECIAL; 
	}

	public double getItemPriceBasic()
	{
		return ITEM_PRICE_BASIC; 
	}

	public String getDiscountNameMember()
	{
		return DISCOUNT_NAME_MEMBER; 
	}

	public String getDiscountNameSenior()
	{
		return DISCOUNT_NAME_SENIOR;
	}

	public String getDiscountNameNone()
	{
		return DISCOUNT_NAME_NONE; 
	}

	public double getDiscountRateMember()
	{
		return DISCOUNT_RATE_MEMBER;
	}

	public double getDiscountRateSenior()
	{
		return DISCOUNT_RATE_SENIOR; 
	}

	public double getDiscountRateNone()
	{
		return DISCOUNT_RATE_NONE; 
	}

}//End of Class SodOrder
