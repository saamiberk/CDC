package com.hititcs.jet.cdc.record;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode
public class Inventory implements Serializable {
    @JsonProperty("rez_class")
    private String rezClass;

    @JsonProperty("seg_isn")
    private Long segIsn;

    @JsonProperty("cabin_class")
    private String cabinClass;

    @JsonProperty("autorization")
    private Integer autorization = 0;

    @JsonProperty("seats_sold")
    private Integer seatsSold = 0;

    @JsonProperty("wl_len")
    private Integer wlLen = 0;

    @JsonProperty("wl_max_len")
    private Integer wlMaxLen = 0;

    @JsonProperty("ss_notify_limit")
    private Integer ssNotifyLimit;

    @JsonProperty("cx_notify_limit")
    private Integer cxNotifyLimit;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @JsonProperty("seat_sold_limit")
    private Integer seatSoldLimit;

    @JsonProperty("last_incoming_avs_code")
    private String lastIncomingAvsCode;

    @JsonProperty("fare_level")
    private String fareLevel;

    @JsonProperty("effective_date")
    private LocalDateTime effectiveDate;

    @JsonProperty("discontinue_date")
    private LocalDateTime discontinueDate;

    @JsonProperty("sales_status")
    private String salesStatus = "O";

    @JsonProperty("inventory_group_no")
    private Integer inventoryGroupNo = 1;

    @JsonProperty("alm_seats_sold")
    private Integer almSeatsSold = 0;

    public Inventory() {
    }

    public Inventory(String rezClass, Long segIsn, String cabinClass,
                     Integer autorization, Integer seatsSold,
                     Integer wlLen, Integer wlMaxLen, Integer ssNotifyLimit,
                     Integer cxNotifyLimit, LocalDateTime lastUpdate,
                     Integer seatSoldLimit, String lastIncomingAvsCode,
                     String fareLevel, LocalDateTime effectiveDate,
                     LocalDateTime discontinueDate, String salesStatus,
                     Integer inventoryGroupNo, Integer almSeatsSold) {
        this.rezClass = rezClass;
        this.segIsn = segIsn;
        this.cabinClass = cabinClass;
        this.autorization = autorization;
        this.seatsSold = seatsSold;
        this.wlLen = wlLen;
        this.wlMaxLen = wlMaxLen;
        this.ssNotifyLimit = ssNotifyLimit;
        this.cxNotifyLimit = cxNotifyLimit;
        this.lastUpdate = lastUpdate;
        this.seatSoldLimit = seatSoldLimit;
        this.lastIncomingAvsCode = lastIncomingAvsCode;
        this.fareLevel = fareLevel;
        this.effectiveDate = effectiveDate;
        this.discontinueDate = discontinueDate;
        this.salesStatus = salesStatus;
        this.inventoryGroupNo = inventoryGroupNo;
        this.almSeatsSold = almSeatsSold;
    }

    public String getCustomKey() {
        return this.segIsn + "#" + this.rezClass;
    }

    public String getRezClass() {
        return rezClass;
    }

    public void setRezClass(String rezClass) {
        this.rezClass = rezClass;
    }

    public Long getSegIsn() {
        return segIsn;
    }

    public void setSegIsn(Long segIsn) {
        this.segIsn = segIsn;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public Integer getAutorization() {
        return autorization;
    }

    public void setAutorization(Integer autorization) {
        this.autorization = autorization;
    }

    public Integer getSeatsSold() {
        return seatsSold;
    }

    public void setSeatsSold(Integer seatsSold) {
        this.seatsSold = seatsSold;
    }

    public Integer getWlLen() {
        return wlLen;
    }

    public void setWlLen(Integer wlLen) {
        this.wlLen = wlLen;
    }

    public Integer getWlMaxLen() {
        return wlMaxLen;
    }

    public void setWlMaxLen(Integer wlMaxLen) {
        this.wlMaxLen = wlMaxLen;
    }

    public Integer getSsNotifyLimit() {
        return ssNotifyLimit;
    }

    public void setSsNotifyLimit(Integer ssNotifyLimit) {
        this.ssNotifyLimit = ssNotifyLimit;
    }

    public Integer getCxNotifyLimit() {
        return cxNotifyLimit;
    }

    public void setCxNotifyLimit(Integer cxNotifyLimit) {
        this.cxNotifyLimit = cxNotifyLimit;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getSeatSoldLimit() {
        return seatSoldLimit;
    }

    public void setSeatSoldLimit(Integer seatSoldLimit) {
        this.seatSoldLimit = seatSoldLimit;
    }

    public String getLastIncomingAvsCode() {
        return lastIncomingAvsCode;
    }

    public void setLastIncomingAvsCode(String lastIncomingAvsCode) {
        this.lastIncomingAvsCode = lastIncomingAvsCode;
    }

    public String getFareLevel() {
        return fareLevel;
    }

    public void setFareLevel(String fareLevel) {
        this.fareLevel = fareLevel;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getDiscontinueDate() {
        return discontinueDate;
    }

    public void setDiscontinueDate(LocalDateTime discontinueDate) {
        this.discontinueDate = discontinueDate;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public Integer getInventoryGroupNo() {
        return inventoryGroupNo;
    }

    public void setInventoryGroupNo(Integer inventoryGroupNo) {
        this.inventoryGroupNo = inventoryGroupNo;
    }

    public Integer getAlmSeatsSold() {
        return almSeatsSold;
    }

    public void setAlmSeatsSold(Integer almSeatsSold) {
        this.almSeatsSold = almSeatsSold;
    }
}
