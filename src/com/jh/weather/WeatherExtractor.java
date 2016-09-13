/**
 * 
 */
package com.jh.weather;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.Calendar;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import com.jh.weather.bean.WeatherBean;
import com.jh.weather.util.DateUtil;;

/**
 * @author sumit
 *
 */
public class WeatherExtractor extends TimerTask {

	/**
	 * String to store the weather URL
	 */
	private String WEATHER_URL = "http://w1.weather.gov/xml/current_obs/KBWI.xml";
	
	/**
	 *  Relative Path 
	 */
	private String RELATIVE_PATH = "/Desktop/Weather/Data";
	
	/**
	 * File Dir
	 */
	private String FILE_DIR = System.getProperty("user.home");
	
	/**
	 * CSV_PREFIX
	 */
	private String CSV_PREFIX = "";
	
	/**
	 * CSV_SUFFIX
	 */
	private String CSV_SUFFIX = "";
	
	/**
	 *  INFO_LOG_PATH
	 */
	private String INFO_LOG_PATH = FILE_DIR + "/Desktop/Weather/Log";
	
	/**
	 * ERR_LOG_PATH
	 */
	private String ERR_LOG_PATH = FILE_DIR + "/Desktop/Weather/Log";

	/**
	 *  INFO_LOG_FILE
	 */
	private String INFO_LOG_FILE = "info";
	
	/**
	 * ERR_LOG_FILE
	 */
	private String ERR_LOG_FILE = "err";
	
	
	/**
	 * loadProperties from config.properties
	 */
	private void loadProperties() {
		String CONFIG_FILE = "config.properties";
		InputStream is = null;
		Properties props = new  Properties(); 
		//System.out.println("pwd: " + System.getProperty("user.dir"));
		try {
			is = new FileInputStream(CONFIG_FILE);
			props.load(is);
			// WEATHER_URL
			if(props.containsKey("WEATHER_URL")) {
				String prop = props.getProperty("WEATHER_URL").trim();
				if(prop != null && !prop.isEmpty()) {
					WEATHER_URL = prop;
				}
			} 
			// FILE_DIR
			if(props.containsKey("FILE_DIR")) {
				String prop = props.getProperty("FILE_DIR").trim();
				if(prop != null && !prop.isEmpty()) {
					FILE_DIR = prop;
				}
			}
			// RELATIVE_PATH
			if(props.containsKey("RELATIVE_PATH")) {
				String prop = props.getProperty("RELATIVE_PATH").trim();
				if(prop != null && !prop.isEmpty()) {
					RELATIVE_PATH = prop;
				}
			}
			// CSV_SUFFIX
			if(props.containsKey("CSV_SUFFIX")) {
				String prop = props.getProperty("CSV_SUFFIX").trim();
				if(prop != null && !prop.isEmpty()) {
					setCSV_SUFFIX(prop);
				}
			}
			// CSV_PREFIX
			if(props.containsKey("CSV_PREFIX")) {
				String prop = props.getProperty("CSV_PREFIX").trim();
				if(prop != null && !prop.isEmpty()) {
					setCSV_PREFIX(prop);
				}
			}
			// INFO_LOG_PATH
			if(props.containsKey("INFO_LOG_PATH")) {
				String prop = props.getProperty("INFO_LOG_PATH").trim();
				if(prop != null && !prop.isEmpty()) {
					setINFO_LOG_PATH(prop);
				}
			}
			// ERR_LOG_PATH
			if(props.containsKey("ERR_LOG_PATH")) {
				String prop = props.getProperty("ERR_LOG_PATH").trim();
				if(prop != null && !prop.isEmpty()) {
					setERR_LOG_PATH(prop);
				}
			}
			// INFO_LOG_FILE
			if(props.containsKey("INFO_LOG_FILE")) {
				String prop = props.getProperty("INFO_LOG_FILE").trim();
				if(prop != null && !prop.isEmpty()) {
					setINFO_LOG_FILE(prop);
				}
			}
			// ERR_LOG_FILE
			if(props.containsKey("ERR_LOG_FILE")) {
				String prop = props.getProperty("ERR_LOG_FILE").trim();
				if(prop != null && !prop.isEmpty()) {
					setERR_LOG_FILE(prop);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		WeatherExtractor wx = new WeatherExtractor(); 
		wx.fetchWeather();
		System.out.println(new DateUtil().getDefault() + " : Scheduled run #" + (++i));
		
		Timer timer = new Timer(); 
		int timeToNextHour = 60 - Calendar.getInstance().get(Calendar.MINUTE);
		timer.schedule(wx, 1000 * 60 * timeToNextHour, 1000 * 60 * 60); 
		System.out.println(new DateUtil().getDefault() + " : Scheduled run #" + (++i));
		//timer.purge();
	}

	/**
	 * @return the wEATHER_URL
	 */
	public String getWEATHER_URL() {
		return WEATHER_URL;
	}
	/**
	 * @param wEATHER_URL the wEATHER_URL to set
	 */
	public void setWEATHER_URL(String wEATHER_URL) {
		WEATHER_URL = wEATHER_URL;
	}
	/**
	 * @return the rELATIVE_PATH
	 */
	public String getRELATIVE_PATH() {
		return RELATIVE_PATH;
	}
	/**
	 * @param rELATIVE_PATH the rELATIVE_PATH to set
	 */
	public void setRELATIVE_PATH(String rELATIVE_PATH) {
		RELATIVE_PATH = rELATIVE_PATH;
	}
	
	/**
	 * @return the fILE_DIR
	 */
	public String getFILE_DIR() {
		return FILE_DIR;
	}

	/**
	 * @param fILE_DIR the fILE_DIR to set
	 */
	public void setFILE_DIR(String fILE_DIR) {
		FILE_DIR = fILE_DIR;
	}

	/**
	 * @return
	 */
	public String getCSV_PREFIX() {
		return CSV_PREFIX;
	}

	/**
	 * @param cSV_PREFIX
	 */
	public void setCSV_PREFIX(String cSV_PREFIX) {
		CSV_PREFIX = cSV_PREFIX;
	}

	/**
	 * @return
	 */
	public String getCSV_SUFFIX() {
		return CSV_SUFFIX;
	}

	/**
	 * @param cSV_SUFFIX
	 */
	public void setCSV_SUFFIX(String cSV_SUFFIX) {
		CSV_SUFFIX = cSV_SUFFIX;
	}

	/**
	 * @return the iNFO_LOG
	 */
	public String getINFO_LOG_PATH() {
		return INFO_LOG_PATH;
	}

	/**
	 * @param iNFO_LOG the iNFO_LOG to set
	 */
	public void setINFO_LOG_PATH(String iNFO_LOG) {
		INFO_LOG_PATH = iNFO_LOG;
	}

	/**
	 * @return the eRR_LOG
	 */
	public String getERR_LOG_PATH() {
		return ERR_LOG_PATH;
	}

	/**
	 * @param eRR_LOG the eRR_LOG to set
	 */
	public void setERR_LOG_PATH(String eRR_LOG) {
		ERR_LOG_PATH = eRR_LOG;
	}

	/**
	 * @return the iNFO_LOG_FILE
	 */
	public String getINFO_LOG_FILE() {
		return INFO_LOG_FILE;
	}

	/**
	 * @param iNFO_LOG_FILE the iNFO_LOG_FILE to set
	 */
	public void setINFO_LOG_FILE(String iNFO_LOG_FILE) {
		INFO_LOG_FILE = iNFO_LOG_FILE;
	}

	/**
	 * @return the eRR_LOG_FILE
	 */
	public String getERR_LOG_FILE() {
		return ERR_LOG_FILE;
	}

	/**
	 * @param eRR_LOG_FILE the eRR_LOG_FILE to set
	 */
	public void setERR_LOG_FILE(String eRR_LOG_FILE) {
		ERR_LOG_FILE = eRR_LOG_FILE;
	}

	/**
	 * getWeatherData
	 */
	public void getWeatherData() {
		loadProperties();
		String dateStr = new DateUtil().getCurrentTime(DateUtil.getDEFAULT_DATE());

		if(Files.notExists((new File(getINFO_LOG_PATH())).toPath(), LinkOption.NOFOLLOW_LINKS)) {
			Boolean mkdir = new File(getINFO_LOG_PATH()).mkdirs();
			if(!mkdir) {
				System.err.println(new DateUtil().getDefault() 
						+ ": Error Occurred: Can not make dir : " 
						+ getINFO_LOG_PATH());
			}
		}
		// Set output Stream 
		try {
			String infoFile = getINFO_LOG_PATH() + "/" + getINFO_LOG_FILE() 
									+ "-" + dateStr + ".log";
			System.setOut(new PrintStream(new FileOutputStream(new File(infoFile), true)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(Files.notExists((new File(getERR_LOG_PATH())).toPath(), LinkOption.NOFOLLOW_LINKS)) {
			Boolean mkdir = new File(getERR_LOG_PATH()).mkdirs();
			if(!mkdir) {
				System.err.println(new DateUtil().getDefault() + 
						" : Error Occurred: Can not make dir : " 
						+ getERR_LOG_PATH());
			}
		}
		// set error stream
		try {
			String errFile = getERR_LOG_PATH() + "/" + getERR_LOG_FILE() 
								+ "-" + dateStr + ".log";
			System.setErr(new PrintStream(new FileOutputStream(new File(errFile), true)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Document doc = getWeatherXML(getWEATHER_URL());
		WeatherXMLParser wxp = new WeatherXMLParser(doc);
		WeatherBean wb = wxp.parseDocument();
		writeToFile(wb);
		//System.out.println(new DateUtil().getDefault() + ": " 
		//			+ doc.getDocumentElement().getTagName() 
		//		+ ", " + doc.getDocumentElement().getChildNodes().getLength());
		//System.out.println(new DateUtil().getDefault() + ":"
		// 			+ doc.getDocumentElement().
		//		getElementsByTagName("credit").item(0).getTextContent());
	}

	/**
	 * writeToFile
	 * @param WeatherBean
	 */
	private void writeToFile(WeatherBean wb) {
		try {
			String file = getFile();
			String data = "\"" + new DateUtil().getCurrentTime(DateUtil.getDEFAULT_DATE_TIME()) 
					+ "\",\"" + wb.getObservationTimeString() + "\",\"" 
					+ wb.getTempF() + "\",\"" + wb.getRelativeHumidity() + "\"";
			FileWriter fw = new FileWriter(file, true);
			fw.write(data + System.lineSeparator());
			fw.flush();
			fw.close();
		} catch (IOException ioe) {
			System.err.println(new DateUtil().getDefault() + ": IOException");
			ioe.printStackTrace();
		}catch (Exception e) {
			System.err.println(new DateUtil().getDefault() + ": Exception");
			e.printStackTrace();
		}
	}
	
	/**
	 * getFile
	 * @return
	 */
	private String getFile() {
		String fileStr = "";
		String path =  FILE_DIR + getRELATIVE_PATH();
		try {
			fileStr = CSV_PREFIX 
					+ new DateUtil().getCurrentTime(DateUtil.getDEFAULT_DATE()) 
						+ CSV_SUFFIX + ".csv";
			if(Files.notExists((new File(path)).toPath(), LinkOption.NOFOLLOW_LINKS)) {
				Boolean mkdir = new File(path).mkdirs();
				if(!mkdir) {
					System.err.println(new DateUtil().getDefault() 
							+ ": Error Occurred: Can not make dir : " + path);
				}
			}
			File file = new File(path + "/" + fileStr);
			if(!file.exists()) {
				String header = "Recorded Time, Observation Time, Temp Fahrenheit, Relative Humidity";
				FileWriter fw = new FileWriter(file);
				fw.write(header + System.lineSeparator());
				fw.flush();
				fw.close();
			}
		} catch(FileNotFoundException fnf) {
			System.err.println(new DateUtil().getDefault() + ": FileNotFoundException");
			fnf.printStackTrace();
		} catch (IOException ioe) { 
			System.err.println(new DateUtil().getDefault() + ": IOException");
			ioe.printStackTrace();
		} catch (Exception e) {
			System.err.println(new DateUtil().getDefault() + ": Exception");
			e.printStackTrace();
		}
		return path + "/" + fileStr;
	}
	
	/**
	 * @param urlString
	 * @return
	 */
	private Document getWeatherXML(String urlString) {
		Document doc = null;
		try {
			// get URL stream
			final URL URL = new URL(urlString);
			InputStream is = URL.openConnection().getInputStream();
			
			// get url (xml) in a document
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(is);
		} catch (IOException e) {
			// TODO 
			System.err.println(new DateUtil().getDefault() 
					+ " : IO Exception occurred");
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			System.err.println(new DateUtil().getDefault() 
					+ ": Parser Config exception occurred "
					+ "(with new document Builder)");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO All other exceptions
			System.err.println(new DateUtil().getDefault() 
					+ ": Unknown exception occurred");
			e.printStackTrace();
		}
		return doc;
	}

	@Override
	public void run() {
		fetchWeather();
	}
	
	public void fetchWeather() {
		WeatherExtractor weatherExtractor = new WeatherExtractor();
		weatherExtractor.getWeatherData();
	}
	
}
