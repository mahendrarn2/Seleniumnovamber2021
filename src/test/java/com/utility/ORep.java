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
    public static final String rightClick=constants.xpath+"&"+"//span[@class='context-menu-one btn btn-neutral']";
    public static final String CopytheRightClick=constants.xpath+"&"+"//span[text()='Copy']";
    public static final String DoubleClick_frame=constants.xpath+"&"+"//iframe";
    public static final String DoubleClickThe_block=constants.xpath+"&"+"//span[text()='Double click the block']/preceding-sibling::div";
    public static final String DragAndDropFrame=constants.xpath+"&"+"//iframe[@class='demo-frame']";
    public static final String Drag=constants.ID+"&"+"draggable";
    public static final String Drop=constants.ID+"&"+"droppable";
    public static final String DropText=constants.xpath+"&"+"//div[@id='droppable']/p";
    
    public static final String AlertButton=constants.xpath+"&"+"//input[@name='alert']";
    public static final String ConfirmButton=constants.xpath+"&"+"//input[@name='confirmation']";
    public static final String PromptButton=constants.xpath+"&"+"//input[@name='prompt']";
    
    public static final String Fileupload=constants.xpath+"&"+"//input[@id='input-4']/preceding-sibling::span";
    public static final String FileDownload=constants.xpath+"&"+"//a[text()='Download']";
    public static final String FileDownload1=constants.xpath+"&"+"//a[@download='file-sample_100kB.doc']";
    
    public static final String Links=constants.tagName+"&"+"a";
    
    public static final String RegisterFirstName=constants.xpath+"&"+"//input[@ng-model='FirstName']";
    public static final String RegisterLastName=constants.xpath+"&"+"//input[@ng-model='LastName']";
    public static final String RegisterAdress=constants.xpath+"&"+"//textarea[@ng-model='Adress']";
    public static final String RegisterEmailAdress=constants.xpath+"&"+"//input[@ng-model='EmailAdress']";
    public static final String RegisterPhone=constants.xpath+"&"+"//input[@ng-model='Phone']";
    public static final String RegisterGenderMale=constants.xpath+"&"+"//input[@value='Male']";
    public static final String RegisterGenderFeMale=constants.xpath+"&"+"//input[@value='FeMale']";
    public static final String RegisterHobbiesCricket=constants.xpath+"&"+"//input[@value='Cricket']";
    public static final String RegisterHobbiesMovies=constants.xpath+"&"+"//input[@value='Movies']";
    public static final String RegisterHobbiesHockey=constants.xpath+"&"+"//input[@value='Hockey']";
    public static final String RegisterLanguages=constants.xpath+"&"+"//div[@id='msdd']";
    public static final String RegisterLanguages_DropDownItems=constants.xpath+"&"+"//div[@id='msdd']/following-sibling::div/ul/li";
    public static final String RegisterSkills=constants.xpath+"&"+"//select[@type='text' and @id='Skills']";
    public static final String Register_Skills_Label=constants.xpath+"&"+"//*[@id='Skills']/../../label";
    public static final String Register_Skills_DropDownItem=constants.xpath+"&"+"//select[@id='Skills']/option";
    //public static final String RegisterCountry=constants.xpath+"&"+"//select[@id='countries']";
    public static final String RegisterSelect_Country=constants.xpath+"&"+"//span[@role='combobox']";
    public static final String RegisterSelect_Country_Search=constants.xpath+"&"+"//*[@type='search']";
    public static final String RegisterDOBYear=constants.xpath+"&"+"//select[@id='yearbox']";
    public static final String RegisterDOBYear_DropDownItem=constants.xpath+"&"+"//*[@id='yearbox']/option";
    public static final String RegisterDOBMonth=constants.xpath+"&"+"//select[@placeholder='Month']";
    public static final String RegisterDOBMonth_DropDownItem=constants.xpath+"&"+"//select[@placeholder='Month']/option";
    public static final String RegisterDOBDate=constants.xpath+"&"+"//select[@id='daybox']";
    public static final String RegisterDOBDate_DropDownItem=constants.xpath+"&"+"//select[@id='daybox']/option";
    public static final String RegisterPassword=constants.xpath+"&"+"//input[@id='firstpassword']";
    public static final String RegisterConfirmPassword=constants.xpath+"&"+"//input[@id='secondpassword']";
    public static final String RegisterLanguageClose=constants.xpath+"&"+"//span[@class='ui-icon ui-icon-close']";
    
    public static final String CalendarFrame=constants.xpath+"&"+"//iframe[@class='demo-frame']";
    public static final String Cal_From=constants.xpath+"&"+"//input[@id='from']";
    public static final String Cal_to=constants.xpath+"&"+"//input[@id='to']";
    public static final String Cal_FromDate=constants.xpath+"&"+"//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[4]/a";
    public static final String Cal_ToDate=constants.xpath+"&"+"//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[5]/a";
    public static final String Cal_FromMonth=constants.xpath+"&"+"//Select[@class='ui-datepicker-month']";
    public static final String Cal_ToMonth=constants.xpath+"&"+"//*[@id='ui-datepicker-div']/div[1]/div/div/select";
}

