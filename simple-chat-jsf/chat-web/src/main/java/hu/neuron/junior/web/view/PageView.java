package hu.neuron.junior.web.view;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "pageView")
@ViewScoped
public class PageView {

	private String locale;
	private static Map<String, Locale> countries;
	private static LinkedList<String> countriesList;

	@PostConstruct
	public void init() {

		countries = new LinkedHashMap<>();
		countries.put("English", Locale.ENGLISH);
		countries.put("Germany", Locale.GERMANY);

		countriesList = new LinkedList<String>();
		countriesList.add("English");
		countriesList.add("Germany");

	}

	public Locale getLocalVar() {

		if (locale != null) {
			return countries.get(locale);
		} else {
			return countries.get("English");
		}

	}

	public void setLocale() {

		FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) countries.get(locale));
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public LinkedList<String> getCountriesList() {
		return countriesList;
	}

	public void setCountriesList(LinkedList<String> countriesList) {
		PageView.countriesList = countriesList;
	}

}
