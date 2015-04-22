package model;

import java.io.File;
import java.util.List;

import javax.persistence.*;
import javax.xml.*;
import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.persistence.*;
import javax.print.attribute.standard.Media;

import model.Site;
import model.SiteList;

public class SiteDao {
//private static EntityManagerFactory factory;
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("XSLT-and-JPA-Assignment");
	static EntityManager em = factory.createEntityManager();
	
	
//findSite
	private static Site findSite(Integer id){
		return em.find(Site.class, id);
	}
	
//findAllSite
	private static List<Site> findAllSite(){
		Query query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();
	}
	 
	
	public void exportSiteDatabaseToXmlFile(SiteList sitelist, String xmlFileName) {
		File xmlFile = new File(xmlFileName);
		try {
			JAXBContext jaxb = JAXBContext.newInstance(SiteList.class);
			Unmarshaller unmarshaller = jaxb.createUnmarshaller()
// unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			unmarshaller.unmarshal(xmlFile);
		} catch (JAXBException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void convertXmlFileToOutputFile(
			String sitelistXmlFileName,
			String outputFileName,
			String xsltFileName)
	{
		File inputXmlFile = new File(sitelistXmlFileName);
		File outputXmlFile = new File(outputFileName);
		File xsltFile = new File(xsltFileName);
		
		StreamSource source = new StreamSource(inputXmlFile);
		StreamSource xslt    = new StreamSource(xsltFile);
		StreamResult output = new StreamResult(outputXmlFile);
		
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer transformer = factory.newTransformer(xslt);
			transformer.transform(source, output);
		} catch (TransformerConfigurationException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
//Test Case
		List<Site> Sites= findAllSite();
		SiteList list = new SiteList();
		list.setSiteList(Sites);
		
		for(int i=0;i<Sites.size();i++){
			System.out.println(Sites.get(i).getName());
		}
		
		SiteDao dao = new SiteDao();
		dao.exportSiteDatabaseToXmlFile(list, "/xml/sites.xml");
		dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/sites.html", "xml/sites2html.xslt");
		
	} 

}
