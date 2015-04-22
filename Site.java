package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement(name="SITE")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Site {
	@Id
	@XmlAttribute(name="ID")
	private Integer id;
	@XmlAttribute(name="NAME")
	private String name;
	@XmlAttribute(name="LATITUDE")
	private Double latitude;
	@XmlAttribute(name="LONGITUDE")
	private Double longitude;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Site(Integer id, String name, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

//required
	public Site() {
		super();
	}
	
}
