package lou.alain;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

public class Driver {
	public int PRETTY_PRINT_INDENT_FACTOR = 4;
	public String everything;
    public String TEST_XML_STRING = "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";
    private boolean keepGoing = false;
    private JSONObject example;
	private static Database db;
	private static Database allRightNow;
	private static int counter = 0;
	private File file;
	
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("dinesafe.xml");						
		CloudantClient client = ClientBuilder.account("alainlou").username("alainlou").password("alainlou").build();
		db = client.database("dinesafe", false);
		allRightNow = client.database("withcoordinates", true);
		
		InputStream is = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(is);
		
		//uploadDatabase(bis);
		String selector = String.format("\"selector\": { \"name\": {\"$eq\": \"%s\"}}", "POPEYE'S");
		List<Review> r = db.findByIndex(selector, Review.class);
		
		//getCoordinatesForDB(r);
		
		System.out.println(r.size());
		
		System.out.println(counter);
	}
	
	public static void getCoordinatesForDB(List<Review> r) throws ApiException, InterruptedException, IOException{
		GeoApiContext context = new GeoApiContext().setApiKey("GETYOUROWN");
		
		for(int i = 0; i < r.size(); i++){
			Review a = r.get(i);
			GeocodingResult[] results = GeocodingApi.geocode(context, a.getAddress()).await();
			try{
				a.setCoordinates(results[0].geometry.location.lat, results[0].geometry.location.lng);
			}
			catch(IndexOutOfBoundsException e){
				continue;
			}
			allRightNow.save(a);
			counter++;
			System.out.println(a.getAddress());
		}
		
	}
	
	public Review getReview(){
		return null;
	}
	
	public static void uploadDatabase(BufferedInputStream bis) throws IOException{
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(bis);
			document.getDocumentElement().normalize();
			System.out.println("Root element: " + document.getDocumentElement().getNodeName());
			NodeList nodeList = document.getElementsByTagName("ROW");
			
			for(int i = 0; i < nodeList.getLength(); i++){
				Node n = nodeList.item(i);
				if(n.getNodeType() == Node.ELEMENT_NODE){
					Element e = (Element)n;
					try{
						Review r = new Review(Integer.parseInt(e.getElementsByTagName("INSPECTION_ID").item(0).getTextContent()),
							Integer.parseInt(e.getElementsByTagName("ESTABLISHMENT_ID").item(0).getTextContent()),
							e.getElementsByTagName("ESTABLISHMENT_NAME").item(0).getTextContent(), 
							e.getElementsByTagName("ESTABLISHMENTTYPE").item(0).getTextContent(), 
							e.getElementsByTagName("ESTABLISHMENT_ADDRESS").item(0).getTextContent(), 
							e.getElementsByTagName("ESTABLISHMENT_STATUS").item(0).getTextContent(), 
							Integer.parseInt(e.getElementsByTagName("MINIMUM_INSPECTIONS_PERYEAR").item(0).getTextContent()),
							e.getElementsByTagName("INFRACTION_DETAILS").item(0).getTextContent(), 
							e.getElementsByTagName("INSPECTION_DATE").item(0).getTextContent(), 
							e.getElementsByTagName("SEVERITY").item(0).getTextContent(), 
							e.getElementsByTagName("ACTION").item(0).getTextContent(),
							e.getElementsByTagName("COURT_OUTCOME").item(0).getTextContent(),
							Double.parseDouble(e.getElementsByTagName("AMOUNT_FINED").item(0).getTextContent()));
					
							System.out.println(r);
							db.save(r);
						
							counter++;
					}
					catch(NumberFormatException f){
						Review r = new Review(Integer.parseInt(e.getElementsByTagName("INSPECTION_ID").item(0).getTextContent()),
							Integer.parseInt(e.getElementsByTagName("ESTABLISHMENT_ID").item(0).getTextContent()),
							e.getElementsByTagName("ESTABLISHMENT_NAME").item(0).getTextContent(), 
							e.getElementsByTagName("ESTABLISHMENTTYPE").item(0).getTextContent(), 
							e.getElementsByTagName("ESTABLISHMENT_ADDRESS").item(0).getTextContent(), 
							e.getElementsByTagName("ESTABLISHMENT_STATUS").item(0).getTextContent(), 
							Integer.parseInt(e.getElementsByTagName("MINIMUM_INSPECTIONS_PERYEAR").item(0).getTextContent()),
							e.getElementsByTagName("INFRACTION_DETAILS").item(0).getTextContent(), 
							e.getElementsByTagName("INSPECTION_DATE").item(0).getTextContent(), 
							e.getElementsByTagName("SEVERITY").item(0).getTextContent(), 
							e.getElementsByTagName("ACTION").item(0).getTextContent(),
							e.getElementsByTagName("COURT_OUTCOME").item(0).getTextContent());
					
							System.out.println(r);
							db.save(r);
					
							counter++;
					}
					
					
				}
			}
			
		} 
		
		catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
		System.out.println(counter);
	}
}
	

