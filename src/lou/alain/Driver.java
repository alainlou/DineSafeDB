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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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

public class Driver {
	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	public static String everything;
    public static String TEST_XML_STRING = "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";
    private static boolean keepGoing = false;
    private static JSONObject example;
	private static Database db;
	private static int counter;
	
	public static void main(String[] args) throws IOException {
		File file = new File("dinesafe.xml");
		File out = new File("Output.txt");
		FileReader reader;
		FileWriter writer;
		
		try {
			//CloudantClient client = ClientBuilder.account("someaccount").username("someusername").password("somepassword").build();			
						
				
			
			db = client.database("dinesafe", false);
			
			reader = new FileReader(file);
			BufferedReader bf = new BufferedReader(reader);
			InputStream is = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(is);
			/**DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docB = new DocumentBuild()
			Document doc = parser.handler().parse(bis);**/
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
						/**if(e.getElementsByTagName("AMOUNT_FINED").item(0).getTextContent().isEmpty()){
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
						}
						else{**/
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
						//}
						
					}
				}
				
			} catch (ParserConfigurationException | SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/**
			StringBuilder allTheText = new StringBuilder();
			
			writer = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(writer);	
			
			String line;
			while((line = bf.readLine()) != null){
				if(line.contains("<ROW>")){
					//System.out.println(line);
					allTheText.append(line);
					keepGoing = true;
				}
				else if(line.contains("</ROW>")){
					allTheText.append(line);
					//System.out.println(allTheText.toString());
					example = XML.toJSONObject(allTheText.toString());
					db.save(example);
					System.out.println(example.toString());
					bw.write(example.toString());
					allTheText = new StringBuilder();
					keepGoing = false;					
				}
				else if(keepGoing){
					allTheText.append(line);
				}
				
			}
			
			
			/**everything = allTheText.toString();
			JSONObject xmlJSONObj = XML.toJSONObject(everything);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            
            
            bw.write(jsonPrettyPrintString);
            //System.out.println(jsonPrettyPrintString);**/  
		} 
		
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (JSONException e){
			e.printStackTrace();
		}
		
		System.out.println(counter);
	}

}
