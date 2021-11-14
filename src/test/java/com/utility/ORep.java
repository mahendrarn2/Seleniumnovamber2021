package com.utility;

public class ORep {
	
	public static final String ValidateEnterGMOonlineButtonWithName=constants.Name+"&"+"bSubmit";
	public static final String OnlineCatalogText =constants.xpath+"&"+"//h1[contains(text(),'OnLine Catalog')]";
	public static final String  TableColumnFieldsClearAndSendKeys=constants.Name+"&"+"QTY_TENTS";
	public static final String OnlineCatalogUnitPrice=constants.xpath+"&"+"//strong[contains(text(),'Dome Tent')]/../../following-sibling::td";
	public static final String placeOrderUnitPrice=constants.xpath+"&"+"(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[2]";
	public static final String totalPlaceOrderPrice=constants.xpath+"&"+"(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[3]";
	public static final String SalesTax=constants.xpath+"&"+"(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[3]/../following-sibling::tr[3]/td[2]";
    public static final String GrandTotalPrice=constants.xpath+"&"+"(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[3]/../following-sibling::tr[4]/td[2]";
    public static final String ShippingHandle=constants.xpath+"&"+"(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[3]/../following-sibling::tr[2]/td[2]";
    public static final String HandlingFrames=constants.Name+"&"+"iFramesURL";
    public static final String HandlingFramesField=constants.xpath+"&"+"//input[@type='text']";
    public static final String iFrameWithInAnFrameButton=constants.xpath+"&"+"//a[text()='Iframe with in an Iframe']";
    public static final String parentFrameElement=constants.xpath+"&"+"//iframe[@src='MultipleFrames.html']";
    public static final String childFrameElement=constants.xpath+"&"+"//iframe[@src='SingleFrame.html']";
    
}

