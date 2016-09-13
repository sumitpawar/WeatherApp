/**
 * 
 */
package com.jh.weather;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jh.weather.bean.WeatherBean;
import com.jh.weather.util.DateUtil;

/**
 * @author sumit
 *
 */
public class WeatherXMLParser {

	/**
	 * W3C XML Document
	 */
	private Document doc = null;
	
	/**
	 * W3C Document "root" Element
	 */
	private Element root = null;

	/**
	 * Constructor with 1 argument doc
	 */
	public WeatherXMLParser(Document doc) {
		this.doc = doc;
		this.root = doc.getDocumentElement();
	}

	/**
	 * Constructor with 1 argument doc root
	 */
	public WeatherXMLParser(Element root) {
		this.root = root;
	}
	
	/**
	 * @return the doc
	 */
	public Document getDoc() {
		return doc;
	}

	/**
	 * @param doc the doc to set
	 */
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	/**
	 * @return the root
	 */
	public Element getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Element root) {
		this.root = root;
	}

	/**
	 * @param doc
	 * @return
	 */
	public WeatherBean parseDocument() {
		WeatherBean wb = new WeatherBean();
		try {
			if(root.hasChildNodes()) {
				
				// credit 
				wb.setCredit(getElement("credit"));
				
				// credit URL
				wb.setCreditUrl(getElement("credit_URL"));
				
				// image
				NodeList imageList = root.getElementsByTagName("image");
				if(imageList.getLength() >= 1) {
					Node node = imageList.item(0);
					NodeList imageChildren = node.getChildNodes();
					int len = imageChildren.getLength();
					System.err.println(new DateUtil().getDefault()  
							+ ": Info: Image node length: " + len);
					for(int i = 0; i < len; i++) {
						Node child = imageChildren.item(i);
						String nodeName = child.getNodeName();
						if(nodeName.equals("url")) {						// image URL
							wb.setImageUrl(child.getNodeValue());
						}else if(nodeName.equals("title")) { 				// image Title
							wb.setImageTitle(child.getNodeValue());
						}else if(nodeName.equals("link")) {					// image Link
							wb.setImageLink(child.getNodeValue());
						} else {
							System.err.println(new DateUtil().getDefault() 
									+" : Error Occured: IMAGE Unknown node name : [" 
									+ nodeName + ", " + child.getNodeValue() + "]");
						}
					}
				} else {
					System.err.println(new DateUtil().getDefault() + " : Error occurred: No Node for image");
				}

				// suggested_pickup
				wb.setSuggestedPickUp(getElement("suggested_pickup"));
				
				// suggested_pickup_period
				wb.setSuggestedPickupPeriod(getElement("suggested_pickup_period"));
				
				// location
				wb.setLocation(getElement("location"));
				
				// station_id
				wb.setStationId(getElement("station_id"));
				
				// latitude
				String latitude = getElement("latitude");
				try {
					wb.setLatitude(Double.parseDouble(latitude));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault()  
							+ ": Error Occurred: latitude not double value: " + latitude);
					nfe.printStackTrace();
				}
				
				// longitude
				String longitude = getElement("longitude");
				try {
					wb.setLongitude(Double.parseDouble(longitude));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ " : Error Occurred: longitude not double value: " + longitude);
					nfe.printStackTrace();
				}
				
				// observation_time
				wb.setObservationTimeString(getElement("observation_time"));
				// TODO: 
				wb.setObservationTime(null);
				
				// observation_time_rfc822
				wb.setObservationTimeRfc822String(getElement("observation_time_rfc822"));
				// TODO: 
				wb.setObservationTimeRfc822(null);
				
				// weather
				wb.setWeather(getElement("weather"));
				
				// temperature_string
				wb.setTemperatureString(getElement("temperature_string"));
				
				// temp_f
				String tempF = getElement("temp_f");
				try {
					wb.setTempF(Double.parseDouble(tempF));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ ": Error Occurred: temperature fahrenheit not double value: " 
							+ tempF);
					nfe.printStackTrace();
				}
				
				// temp_c
				String tempC = getElement("temp_c");
				try {
					wb.setTempC(Double.parseDouble(tempC));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ ": Error Occurred: temperature celcius not double value: "
							 + tempC);
					nfe.printStackTrace();
				}
				
				// relative_humidity
				String relativeHumidity = getElement("relative_humidity");
				try {
					wb.setRelativeHumidity(Double.parseDouble(relativeHumidity));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ " : Error Occurred: relative_humidity not double value: "
							 + relativeHumidity);
					nfe.printStackTrace();
				}
				
				// wind_string
				wb.setWindString(getElement("wind_string"));
				
				// wind_dir
				wb.setWindDir(getElement("wind_dir"));
				
				// wind_degrees
				String windDegrees = getElement("wind_degrees");
				try {
					wb.setWindDegrees(Double.parseDouble(windDegrees));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault()  
							+ ": Error Occurred: wind_degrees not double value: "
							 + windDegrees);
					nfe.printStackTrace();
				}
				
				// wind_mph
				String windMph = getElement("wind_mph");
				try {
					wb.setWindMph(Double.parseDouble(windMph));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ ": Error Occurred: wind_mph not double value: "
							 + windMph);
					nfe.printStackTrace();
				}
				
				// wind_kt
				String windKt = getElement("wind_kt");
				try {
					wb.setWindKt(Double.parseDouble(windKt));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ ": Error Occurred: wind_kt not double value: "
							 + windKt);
					nfe.printStackTrace();
				}
				
				// pressure_string
				wb.setPressureString(getElement("pressure_string"));
				
				// pressure_mb
				String pressureMb = getElement("pressure_mb");
				try {
					wb.setPressureMb(Double.parseDouble(pressureMb));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault()  
							+ ": Error Occurred: pressure_mb not double value: "
							 + pressureMb);
					nfe.printStackTrace();
				}
				
				// pressure_in
				String pressureIn = getElement("pressure_in");
				try {
					wb.setPressureIn(Double.parseDouble(pressureIn));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ ": Error Occurred: pressure_in not double value: "
							 + pressureIn);
					nfe.printStackTrace();
				}
				
				// dewpoint_string
				wb.setDewpointString(getElement("dewpoint_string"));
				
				// dewpoint_f
				String dewpointF = getElement("dewpoint_f");
				try {
					wb.setDewpointF(Double.parseDouble(dewpointF));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ ": Error Occurred: dewpoint_f not double value: "
							 + dewpointF);
					nfe.printStackTrace();
				}
				
				// dewpoint_c
				String dewpointC = getElement("dewpoint_c");
				try {
					wb.setDewpointC(Double.parseDouble(dewpointC));
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ ": Error Occurred: dewpoint_c not double value: "
							 + dewpointC);
					nfe.printStackTrace();
				}
				
				// heat_index_string
				wb.setHeatIndexString(getElement("heat_index_string"));
				
				// heat_index_f
				String heatIndexF = getElement("heat_index_f");
				try {
					if(!heatIndexF.isEmpty()) {
						wb.setHeatIndexF(Double.parseDouble(heatIndexF));
					}
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+" : Error Occurred: heat_index_f not double value: "
							 + heatIndexF);
					nfe.printStackTrace();
				}
				
				// heat_index_c
				String heatIndexC = getElement("heat_index_c");
				try {
					if(!heatIndexC.isEmpty()) {
						wb.setHeatIndexC(Double.parseDouble(heatIndexC));
					}
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ ": Error Occurred: heat_index_c not double value: "
							 + heatIndexC);
					nfe.printStackTrace();
				}
				
				// visibility_mi
				String visibilityMi = getElement("visibility_mi");
				try {
					if(!visibilityMi.isEmpty()) {
						wb.setVisibilityMi(Double.parseDouble(visibilityMi));
					}
				} catch (NumberFormatException nfe) {
					System.err.println(new DateUtil().getDefault() 
							+ " : Error Occurred: visibility_mi not double value: "
							 + visibilityMi);
					nfe.printStackTrace();
				}
				
				// icon_url_base
				wb.setIconUrlBase(getElement("icon_url_base"));
				
				// two_day_history_url
				wb.setTwoDayHistoryUrl(getElement("two_day_history_url"));
				
				// icon_url_name
				wb.setIconUrlName(getElement("icon_url_name"));
				
				// ob_url
				wb.setObUrl(getElement("ob_url"));
				
				// disclaimer_url
				wb.setDisclaimerUrl(getElement("disclaimer_url"));
				
				// copyright_url
				wb.setCopyrightUrl(getElement("copyright_url"));
				
				// privacy_policy_url
				wb.setPrivacyPolicyUrl(getElement("privacy_policy_url"));
				
			} else {
				System.err.println(new DateUtil().getDefault() 
						+" : Error Occurred: No Child Nodes obtained, total nodes: " 
						+ root.getChildNodes().getLength());
			}
		} catch(Exception e) {
			// TODO
			e.printStackTrace();
		}
		return wb;
	}
	
	private String getElement(String elementTag) {
		String value = "";
		try {
			NodeList nodeList = root.getElementsByTagName(elementTag);
			int size = nodeList.getLength();
			if(size == 1) {
				Node node = nodeList.item(0);
				// value = node.getNodeValue(); // Doesn't work, takes the value attr
				value = node.getTextContent();
			} else if (size > 1) {
				System.out.println(new DateUtil().getDefault() 
						+ ": Check: More than one nodes for tag: " + elementTag);
				Node node = nodeList.item(0);
				value = node.getNodeValue();
			} else {
				System.err.println(new DateUtil().getDefault()  
						+ " : Error Occurred: No node with name : " + elementTag);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
