package model;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="SITE-LIST")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class SiteList {
	@XmlElement(name="sitelist")
	private List<Site> sitelist;

	public List<Site> getSiteList() {
		return sitelist;
	}
	public void setSiteList(List<Site> sitelist) {
		this.sitelist = sitelist;
	}
	public SiteList(List<Site> sitelist) {
		super();
		this.sitelist = sitelist;
	}
	public SiteList() {
		super();
	}
}