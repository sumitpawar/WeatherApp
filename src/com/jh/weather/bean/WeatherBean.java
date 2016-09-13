/**
 * 
 */
package com.jh.weather.bean;

import java.util.Date;

/**
 * @author sumit
 *
 */
public class WeatherBean {
	
	/**
	 * Credits
	 */
	private String credit = "";
	
	/**
	 * Credits URL
	 */
	private String creditUrl = "";
	
	/**
	 *  Image Title
	 */
	private String imageTitle = "";
	
	/**
	 * Image URL
	 */
	private String imageUrl = "";
	
	/**
	 * Image Link
	 */
	private String imageLink = "";
	
	
	/**
	 * Suggested Pick Up
	 */
	private String suggestedPickUp="";
	
	/**
	 * Suggested Pickup Period 
	 */
	private String suggestedPickupPeriod = "";
	
	/**
	 * Location
	 */
	private String location = "";
	
	/**
	 * Station Id
	 */
	private String stationId = "";
	
	/**
	 * Latitude
	 */
	private double latitude;
	
	/**
	 * longitude
	 */
	private double longitude;
	
	/**
	 * Observation Time String 
	 */
	private String observationTimeString = "";
	
	/**
	 * Observation Time
	 */
	private Date observationTime;
	
	/**
	 * Observation Time Rfc822 String 
	 */
	private String observationTimeRfc822String = "";
	
	/**
	 * Observation Time Rfc822
	 */
	private Date observationTimeRfc822;
	
	/**
	 * Weather 
	 */
	private String weather = "";
	
	/**
	 * Temperature String 
	 */
	private String temperatureString = "";
	
	/**
	 * Temp F
	 */
	private double tempF;
	
	/**
	 * Temp C
	 */
	private double tempC;
	
	/**
	 * Relative Humidity
	 */
	private double relativeHumidity;
	
	/**
	 * Wind String 
	 */
	private String windString = "";
	
	/**
	 * Wind Direction
	 */
	private String windDir = "";
	
	/**
	 * Wind Degrees
	 */
	private double windDegrees;
	
	/**
	 * Wind MPH
	 */
	private double windMph;
	
	/**
	 * Wind KT
	 */
	private double windKt;
	
	/**
	 * Pressure String 
	 */
	private String pressureString = "";
	
	/**
	 * Pressure MB
	 */
	private double pressureMb;
	
	/**
	 * Pressure In
	 */
	private double pressureIn;
	
	/**
	 * Dewpoint String
	 */
	private String dewpointString = "";
	
	/**
	 * Dewpoint F
	 */
	private double dewpointF;
	
	/**
	 * Dewpoint C
	 */
	private double dewpointC;
	
	/**
	 * Heat Index String
	 */
	private String heatIndexString = "";
	
	/**
	 * Heat Index F
	 */
	private double heatIndexF;
	
	/**
	 * Heat Index C
	 */
	private double heatIndexC;
	
	/**
	 * Visibility mi
	 */
	private double visibilityMi;
	
	/**
	 * Icon URL Base 
	 */
	private String iconUrlBase = "";
	
	/**
	 * Two Day History URL
	 */
	private String twoDayHistoryUrl = "";
	
	/**
	 * Icon URL Name 
	 */
	private String iconUrlName = "";
	
	/**
	 * ob URL 
	 */
	private String obUrl = "";
	
	/**
	 * Disclaimer URL 
	 */
	private String disclaimerUrl = "";
	
	/**
	 * Copyright URL
	 */
	private String copyrightUrl = "";
	
	/**
	 * Privacy Policy URL
	 */
	private String privacyPolicyUrl = "";
		

	/**
	 * @return the credit
	 */
	public String getCredit() {
		return credit;
	}


	/**
	 * @param credit the credit to set
	 */
	public void setCredit(String credit) {
		this.credit = credit;
	}


	/**
	 * @return the creditUrl
	 */
	public String getCreditUrl() {
		return creditUrl;
	}


	/**
	 * @param creditUrl the creditUrl to set
	 */
	public void setCreditUrl(String creditUrl) {
		this.creditUrl = creditUrl;
	}


	/**
	 * @return the imageTitle
	 */
	public String getImageTitle() {
		return imageTitle;
	}


	/**
	 * @param imageTitle the imageTitle to set
	 */
	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}


	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}


	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	/**
	 * @return the imageLink
	 */
	public String getImageLink() {
		return imageLink;
	}


	/**
	 * @param imageLink the imageLink to set
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}


	/**
	 * @return the suggestedPickUp
	 */
	public String getSuggestedPickUp() {
		return suggestedPickUp;
	}


	/**
	 * @param suggestedPickUp the suggestedPickUp to set
	 */
	public void setSuggestedPickUp(String suggestedPickUp) {
		this.suggestedPickUp = suggestedPickUp;
	}


	/**
	 * @return the suggestedPickupPeriod
	 */
	public String getSuggestedPickupPeriod() {
		return suggestedPickupPeriod;
	}


	/**
	 * @param suggestedPickupPeriod the suggestedPickupPeriod to set
	 */
	public void setSuggestedPickupPeriod(String suggestedPickupPeriod) {
		this.suggestedPickupPeriod = suggestedPickupPeriod;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the stationId
	 */
	public String getStationId() {
		return stationId;
	}


	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}


	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}


	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}


	/**
	 * @param doubleitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	/**
	 * @return the observationTimeString
	 */
	public String getObservationTimeString() {
		return observationTimeString;
	}


	/**
	 * @param observationTimeString the observationTimeString to set
	 */
	public void setObservationTimeString(String observationTimeString) {
		this.observationTimeString = observationTimeString;
	}


	/**
	 * @return the observationTime
	 */
	public Date getObservationTime() {
		return observationTime;
	}


	/**
	 * @param observationTime the observationTime to set
	 */
	public void setObservationTime(Date observationTime) {
		this.observationTime = observationTime;
	}


	/**
	 * @return the observationTimeRfc822String
	 */
	public String getObservationTimeRfc822String() {
		return observationTimeRfc822String;
	}


	/**
	 * @param observationTimeRfc822String the observationTimeRfc822String to set
	 */
	public void setObservationTimeRfc822String(String observationTimeRfc822String) {
		this.observationTimeRfc822String = observationTimeRfc822String;
	}


	/**
	 * @return the observationTimeRfc822
	 */
	public Date getObservationTimeRfc822() {
		return observationTimeRfc822;
	}


	/**
	 * @param observationTimeRfc822 the observationTimeRfc822 to set
	 */
	public void setObservationTimeRfc822(Date observationTimeRfc822) {
		this.observationTimeRfc822 = observationTimeRfc822;
	}


	/**
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}


	/**
	 * @param weather the weather to set
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}


	/**
	 * @return the temperatureString
	 */
	public String getTemperatureString() {
		return temperatureString;
	}


	/**
	 * @param temperatureString the temperatureString to set
	 */
	public void setTemperatureString(String temperatureString) {
		this.temperatureString = temperatureString;
	}


	/**
	 * @return the tempF
	 */
	public double getTempF() {
		return tempF;
	}


	/**
	 * @param tempF the tempF to set
	 */
	public void setTempF(double tempF) {
		this.tempF = tempF;
	}


	/**
	 * @return the tempC
	 */
	public double getTempC() {
		return tempC;
	}


	/**
	 * @param tempC the tempC to set
	 */
	public void setTempC(double tempC) {
		this.tempC = tempC;
	}


	/**
	 * @return the relativeHumidity
	 */
	public double getRelativeHumidity() {
		return relativeHumidity;
	}


	/**
	 * @param relativeHumidity the relativeHumidity to set
	 */
	public void setRelativeHumidity(double relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}


	/**
	 * @return the windString
	 */
	public String getWindString() {
		return windString;
	}


	/**
	 * @param windString the windString to set
	 */
	public void setWindString(String windString) {
		this.windString = windString;
	}


	/**
	 * @return the windDir
	 */
	public String getWindDir() {
		return windDir;
	}


	/**
	 * @param windDir the windDir to set
	 */
	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}


	/**
	 * @return the windDegrees
	 */
	public double getWindDegrees() {
		return windDegrees;
	}


	/**
	 * @param windDegrees the windDegrees to set
	 */
	public void setWindDegrees(double windDegrees) {
		this.windDegrees = windDegrees;
	}


	/**
	 * @return the wind_mph
	 */
	public double getWindMph() {
		return windMph;
	}


	/**
	 * @param wind_mph the wind_mph to set
	 */
	public void setWindMph(double windMph) {
		this.windMph = windMph;
	}


	/**
	 * @return the wind_kt
	 */
	public double getWindKt() {
		return windKt;
	}


	/**
	 * @param wind_kt the wind_kt to set
	 */
	public void setWindKt(double windKt) {
		this.windKt = windKt;
	}


	/**
	 * @return the pressureString
	 */
	public String getPressureString() {
		return pressureString;
	}


	/**
	 * @param pressureString the pressureString to set
	 */
	public void setPressureString(String pressureString) {
		this.pressureString = pressureString;
	}


	/**
	 * @return the pressure_mb
	 */
	public double getPressureMb() {
		return pressureMb;
	}


	/**
	 * @param pressure_mb the pressure_mb to set
	 */
	public void setPressureMb(double pressureMb) {
		this.pressureMb = pressureMb;
	}


	/**
	 * @return the pressureI
	 */
	public double getPressureIn() {
		return pressureIn;
	}


	/**
	 * @param pressureIn the pressureIn to set
	 */
	public void setPressureIn(double pressureIn) {
		this.pressureIn = pressureIn;
	}


	/**
	 * @return the dewpointString
	 */
	public String getDewpointString() {
		return dewpointString;
	}


	/**
	 * @param dewpointString the dewpointString to set
	 */
	public void setDewpointString(String dewpointString) {
		this.dewpointString = dewpointString;
	}


	/**
	 * @return the dewpointF
	 */
	public double getDewpointF() {
		return dewpointF;
	}


	/**
	 * @param dewpointF the dewpointF to set
	 */
	public void setDewpointF(double dewpointF) {
		this.dewpointF = dewpointF;
	}


	/**
	 * @return the dewpointC
	 */
	public double getDewpointC() {
		return dewpointC;
	}


	/**
	 * @param dewpointC the dewpointC to set
	 */
	public void setDewpointC(double dewpointC) {
		this.dewpointC = dewpointC;
	}


	/**
	 * @return the heatIndexString
	 */
	public String getHeatIndexString() {
		return heatIndexString;
	}


	/**
	 * @param heatIndexString the heatIndexString to set
	 */
	public void setHeatIndexString(String heatIndexString) {
		this.heatIndexString = heatIndexString;
	}


	/**
	 * @return the heatIndexF
	 */
	public double getHeatIndexF() {
		return heatIndexF;
	}


	/**
	 * @param heatIndexF the heatIndexF to set
	 */
	public void setHeatIndexF(double heatIndexF) {
		this.heatIndexF = heatIndexF;
	}


	/**
	 * @return the heatIndexC
	 */
	public double getHeatIndexC() {
		return heatIndexC;
	}


	/**
	 * @param heatIndexC the heatIndexC to set
	 */
	public void setHeatIndexC(double heatIndexC) {
		this.heatIndexC = heatIndexC;
	}


	/**
	 * @return the visibilityMi
	 */
	public double getVisibilityMi() {
		return visibilityMi;
	}


	/**
	 * @param visibilityMi the visibilityMi to set
	 */
	public void setVisibilityMi(double visibilityMi) {
		this.visibilityMi = visibilityMi;
	}


	/**
	 * @return the iconUrlBase
	 */
	public String getIconUrlBase() {
		return iconUrlBase;
	}


	/**
	 * @param iconUrlBase the iconUrlBase to set
	 */
	public void setIconUrlBase(String iconUrlBase) {
		this.iconUrlBase = iconUrlBase;
	}


	/**
	 * @return the twoDayHistoryUrl
	 */
	public String getTwoDayHistoryUrl() {
		return twoDayHistoryUrl;
	}


	/**
	 * @param twoDayHistoryUrl the twoDayHistoryUrl to set
	 */
	public void setTwoDayHistoryUrl(String twoDayHistoryUrl) {
		this.twoDayHistoryUrl = twoDayHistoryUrl;
	}


	/**
	 * @return the iconUrlName
	 */
	public String getIconUrlName() {
		return iconUrlName;
	}


	/**
	 * @param iconUrlName the iconUrlName to set
	 */
	public void setIconUrlName(String iconUrlName) {
		this.iconUrlName = iconUrlName;
	}


	/**
	 * @return the obUrl
	 */
	public String getObUrl() {
		return obUrl;
	}


	/**
	 * @param obUrl the obUrl to set
	 */
	public void setObUrl(String obUrl) {
		this.obUrl = obUrl;
	}


	/**
	 * @return the disclaimerUrl
	 */
	public String getDisclaimerUrl() {
		return disclaimerUrl;
	}


	/**
	 * @param disclaimerUrl the disclaimerUrl to set
	 */
	public void setDisclaimerUrl(String disclaimerUrl) {
		this.disclaimerUrl = disclaimerUrl;
	}


	/**
	 * @return the copyrightUrl
	 */
	public String getCopyrightUrl() {
		return copyrightUrl;
	}


	/**
	 * @param copyrightUrl the copyrightUrl to set
	 */
	public void setCopyrightUrl(String copyrightUrl) {
		this.copyrightUrl = copyrightUrl;
	}


	/**
	 * @return the privacyPolicyUrl
	 */
	public String getPrivacyPolicyUrl() {
		return privacyPolicyUrl;
	}


	/**
	 * @param privacyPolicyUrl the privacyPolicyUrl to set
	 */
	public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
		this.privacyPolicyUrl = privacyPolicyUrl;
	}

	@Override
	public String toString() {
		return "WeatherBean [credit=" + credit + ", creditUrl=" + creditUrl + ", imageTitle=" + imageTitle
				+ ", imageUrl=" + imageUrl + ", imageLink=" + imageLink + ", suggestedPickUp=" + suggestedPickUp
				+ ", suggestedPickupPeriod=" + suggestedPickupPeriod + ", location=" + location + ", stationId="
				+ stationId + ", latitude=" + latitude + ", longitude=" + longitude + ", observationTimeString="
				+ observationTimeString + ", observationTime=" + observationTime + ", observationTimeRfc822String="
				+ observationTimeRfc822String + ", observationTimeRfc822=" + observationTimeRfc822 + ", weather="
				+ weather + ", temperatureString=" + temperatureString + ", tempF=" + tempF + ", tempC=" + tempC
				+ ", relativeHumidity=" + relativeHumidity + ", windString=" + windString + ", windDir=" + windDir
				+ ", windDegrees=" + windDegrees + ", windMph=" + windMph + ", windKt=" + windKt
				+ ", pressureString=" + pressureString + ", pressureMb=" + pressureMb + ", pressureIn=" + pressureIn
				+ ", dewpointString=" + dewpointString + ", dewpointF=" + dewpointF + ", dewpointC=" + dewpointC
				+ ", heatIndexString=" + heatIndexString + ", heatIndexF=" + heatIndexF + ", heatIndexC=" + heatIndexC
				+ ", visibilityMi=" + visibilityMi + ", iconUrlBase=" + iconUrlBase + ", twoDayHistoryUrl="
				+ twoDayHistoryUrl + ", iconUrlName=" + iconUrlName + ", obUrl=" + obUrl + ", disclaimerUrl="
				+ disclaimerUrl + ", copyrightUrl=" + copyrightUrl + ", privacyPolicyUrl=" + privacyPolicyUrl + "]";
	}
	
}
