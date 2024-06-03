package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {
	WebDriver driver;

	public CalendarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement eventNameEdt;

	@FindBy(xpath="//input[@id=\"date_start\"]")
	private WebElement startDateEdt;

	@FindBy(name = "due_date")
	private WebElement endDateEdt;

	@FindBy(xpath = "//input[contains(@title,\"Save\")]")
	private WebElement saveBtn;

	@FindBy(linkText = "All Events & Todos")
	private WebElement allEventsAndTodoslnk;

	@FindBy(name = "search_text")
	private WebElement searchForEdt;

	@FindBy(id = "bas_searchfield")
	private WebElement searchFieldDD;

	@FindBy(xpath = "//input[contains(@value,\"Search Now\")]")
	private WebElement searchNowBtn;

	@FindBy(xpath = "//b[.='Event Name']/../../td[2]")
	private WebElement eventNameTxt;

	@FindBy(xpath = "//b[.='Event starts at']/../../../tr[3]/td")
	private WebElement eventStartDateTxt;

	@FindBy(xpath = "//b[.='Event ends on']/../../../tr[3]/td")
	private WebElement eventEndDateTxt;

	@FindBy(name = "subject")
	private WebElement toDoEdt;

	@FindBy(xpath = "//b[.='To Do']/../../td[2]")
	private WebElement toDoTxt;

	@FindBy(xpath = "//b[.='Time & Date']/../../../tr[3]/td")
	private WebElement timeAndDateTxt;

	public WebElement getToDoEdt() {
		return toDoEdt;
	}

	public WebElement getToDoTxt() {
		return toDoTxt;
	}

	public WebElement getTimeAndDateTxt() {
		return timeAndDateTxt;
	}

	public WebElement getDueDateTxt() {
		return DueDateTxt;
	}

	@FindBy(xpath = "//b[.='Due Date']/../../../tr[2]/td")
	private WebElement DueDateTxt;

	public WebElement getEventNameEdt() {
		return eventNameEdt;
	}

	public WebElement getStartDateEdt() {
		return eventStartDateTxt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAllEventsAndTodoslnk() {
		return allEventsAndTodoslnk;
	}

	public WebElement getSearchForEdt() {
		return searchForEdt;
	}

	public WebElement getSearchFieldDD() {
		return searchFieldDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getEventNameTxt() {
		return eventNameTxt;
	}

	public WebElement getEventStartDateTxt() {
		return eventStartDateTxt;
	}

	public WebElement getEventEndDateTxt() {
		return eventEndDateTxt;
	}

}
