package com.hititcs.jet.cdc.record;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode
public class FlightSegment implements Serializable {

    @JsonProperty("seg_isn")
    private Long segIsn;

    @JsonProperty("dep_city")
    private String depCity;

    @JsonProperty("dep_port")
    private String depPort;

    @JsonProperty("sch_dep_dt")
    private LocalDateTime schDepDt;

    @JsonProperty("sch_arr_dt")
    private LocalDateTime schArrDt;

    @JsonProperty("arr_port")
    private String arrPort;

    @JsonProperty("arr_city")
    private String arrCity;

    @JsonProperty("ss_notify")
    private String ssNotify;

    @JsonProperty("cx_notify")
    private String cxNotify;

    @JsonProperty("wl_open")
    private String wlOpen;

    @JsonProperty("wl_auto_confirm")
    private String wlAutoConfirm;

    @JsonProperty("crc_comment")
    private String crcComment;

    @JsonProperty("segment_type")
    private String segmentType;

    @JsonProperty("inhibit_sales")
    private String inhibitSales;

    @JsonProperty("domestic")
    private String domestic;

    @JsonProperty("default_inventory_template_isn")
    private Long defaultInventoryTemplateIsn;

    @JsonProperty("flt_info")
    private String fltInfo;

    @JsonProperty("flt_info_text")
    private String fltInfoText;

    @JsonProperty("aa_code")
    private String aaCode;

    @JsonProperty("flt_no")
    private String fltNo;

    @JsonProperty("seat_sell_status")
    private String seatSellStatus;

    @JsonProperty("is_ici_open")
    private String isIciOpen;

    @JsonProperty("is_ici_open_manual")
    private String isIciOpenManual;

    @JsonProperty("distribution_isn")
    private Long distributionIsn;

    @JsonProperty("day_of_week")
    private String dayOfWeek;

    @JsonProperty("inhibit_hold_baggage_sale")
    private String inhibitHoldBaggageSale;

    @JsonProperty("allow_kg_baggage_sale")
    private String allowKgBaggageSale;

    @JsonProperty("is_mobile_ci_open")
    private String isMobileCiOpen;

    @JsonProperty("is_mobile_ci_open_manual")
    private String isMobileCiOpenManual;

    @JsonProperty("effective_after")
    private Long effectiveAfter;

    @JsonProperty("operating_profile_isn")
    private Long operatingProfileIsn;

    @JsonProperty("allow_inv")
    private String allowInv;

    @JsonProperty("flt_duration")
    private String fltDuration;

    @JsonProperty("dep_country")
    private String depCountry;

    @JsonProperty("arr_country")
    private String arrCountry;

    @JsonProperty("operating_carrier_code")
    private String operatingCarrierCode;

    @JsonProperty("utc_sch_dep_dt")
    private LocalDateTime utcSchDepDt;

    @JsonProperty("utc_sch_arr_dt")
    private LocalDateTime utcSchArrDt;

    public Long getSegIsn() {
        return segIsn;
    }

    public void setSegIsn(Long segIsn) {
        this.segIsn = segIsn;
    }

    public String getDepCity() {
        return depCity;
    }

    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    public String getDepPort() {
        return depPort;
    }

    public void setDepPort(String depPort) {
        this.depPort = depPort;
    }

    public LocalDateTime getSchDepDt() {
        return schDepDt;
    }

    public void setSchDepDt(LocalDateTime schDepDt) {
        this.schDepDt = schDepDt;
    }

    public LocalDateTime getSchArrDt() {
        return schArrDt;
    }

    public void setSchArrDt(LocalDateTime schArrDt) {
        this.schArrDt = schArrDt;
    }

    public String getArrPort() {
        return arrPort;
    }

    public LocalDateTime getUtcSchDepDt() {
        return utcSchDepDt;
    }

    public void setUtcSchDepDt(LocalDateTime utcSchDepDt) {
        this.utcSchDepDt = utcSchDepDt;
    }

    public LocalDateTime getUtcSchArrDt() {
        return utcSchArrDt;
    }

    public void setUtcSchArrDt(LocalDateTime utcSchArrDt) {
        this.utcSchArrDt = utcSchArrDt;
    }

    public void setArrPort(String arrPort) {
        this.arrPort = arrPort;
    }

    public String getArrCity() {
        return arrCity;
    }

    public void setArrCity(String arrCity) {
        this.arrCity = arrCity;
    }

    public String getSsNotify() {
        return ssNotify;
    }

    public void setSsNotify(String ssNotify) {
        this.ssNotify = ssNotify;
    }

    public String getCxNotify() {
        return cxNotify;
    }

    public void setCxNotify(String cxNotify) {
        this.cxNotify = cxNotify;
    }

    public String getWlOpen() {
        return wlOpen;
    }

    public void setWlOpen(String wlOpen) {
        this.wlOpen = wlOpen;
    }

    public String getWlAutoConfirm() {
        return wlAutoConfirm;
    }

    public void setWlAutoConfirm(String wlAutoConfirm) {
        this.wlAutoConfirm = wlAutoConfirm;
    }

    public String getCrcComment() {
        return crcComment;
    }

    public void setCrcComment(String crcComment) {
        this.crcComment = crcComment;
    }

    public String getSegmentType() {
        return segmentType;
    }

    public void setSegmentType(String segmentType) {
        this.segmentType = segmentType;
    }

    public String getInhibitSales() {
        return inhibitSales;
    }

    public void setInhibitSales(String inhibitSales) {
        this.inhibitSales = inhibitSales;
    }

    public String getDomestic() {
        return domestic;
    }

    public void setDomestic(String domestic) {
        this.domestic = domestic;
    }

    public Long getDefaultInventoryTemplateIsn() {
        return defaultInventoryTemplateIsn;
    }

    public void setDefaultInventoryTemplateIsn(Long defaultInventoryTemplateIsn) {
        this.defaultInventoryTemplateIsn = defaultInventoryTemplateIsn;
    }

    public String getFltInfo() {
        return fltInfo;
    }

    public void setFltInfo(String fltInfo) {
        this.fltInfo = fltInfo;
    }

    public String getFltInfoText() {
        return fltInfoText;
    }

    public void setFltInfoText(String fltInfoText) {
        this.fltInfoText = fltInfoText;
    }

    public String getAaCode() {
        return aaCode;
    }

    public void setAaCode(String aaCode) {
        this.aaCode = aaCode;
    }

    public String getFltNo() {
        return fltNo;
    }

    public void setFltNo(String fltNo) {
        this.fltNo = fltNo;
    }

    public String getSeatSellStatus() {
        return seatSellStatus;
    }

    public void setSeatSellStatus(String seatSellStatus) {
        this.seatSellStatus = seatSellStatus;
    }

    public String getIsIciOpen() {
        return isIciOpen;
    }

    public void setIsIciOpen(String isIciOpen) {
        this.isIciOpen = isIciOpen;
    }

    public String getIsIciOpenManual() {
        return isIciOpenManual;
    }

    public void setIsIciOpenManual(String isIciOpenManual) {
        this.isIciOpenManual = isIciOpenManual;
    }

    public Long getDistributionIsn() {
        return distributionIsn;
    }

    public void setDistributionIsn(Long distributionIsn) {
        this.distributionIsn = distributionIsn;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getInhibitHoldBaggageSale() {
        return inhibitHoldBaggageSale;
    }

    public void setInhibitHoldBaggageSale(String inhibitHoldBaggageSale) {
        this.inhibitHoldBaggageSale = inhibitHoldBaggageSale;
    }

    public String getAllowKgBaggageSale() {
        return allowKgBaggageSale;
    }

    public void setAllowKgBaggageSale(String allowKgBaggageSale) {
        this.allowKgBaggageSale = allowKgBaggageSale;
    }

    public String getIsMobileCiOpen() {
        return isMobileCiOpen;
    }

    public void setIsMobileCiOpen(String isMobileCiOpen) {
        this.isMobileCiOpen = isMobileCiOpen;
    }

    public String getIsMobileCiOpenManual() {
        return isMobileCiOpenManual;
    }

    public void setIsMobileCiOpenManual(String isMobileCiOpenManual) {
        this.isMobileCiOpenManual = isMobileCiOpenManual;
    }

    public Long getEffectiveAfter() {
        return effectiveAfter;
    }

    public void setEffectiveAfter(Long effectiveAfter) {
        this.effectiveAfter = effectiveAfter;
    }

    public Long getOperatingProfileIsn() {
        return operatingProfileIsn;
    }

    public void setOperatingProfileIsn(Long operatingProfileIsn) {
        this.operatingProfileIsn = operatingProfileIsn;
    }

    public String getAllowInv() {
        return allowInv;
    }

    public void setAllowInv(String allowInv) {
        this.allowInv = allowInv;
    }

    public String getFltDuration() {
        return fltDuration;
    }

    public void setFltDuration(String fltDuration) {
        this.fltDuration = fltDuration;
    }

    public String getDepCountry() {
        return depCountry;
    }

    public void setDepCountry(String depCountry) {
        this.depCountry = depCountry;
    }

    public String getArrCountry() {
        return arrCountry;
    }

    public void setArrCountry(String arrCountry) {
        this.arrCountry = arrCountry;
    }

    public String getOperatingCarrierCode() {
        return operatingCarrierCode;
    }

    public void setOperatingCarrierCode(String operatingCarrierCode) {
        this.operatingCarrierCode = operatingCarrierCode;
    }

}
