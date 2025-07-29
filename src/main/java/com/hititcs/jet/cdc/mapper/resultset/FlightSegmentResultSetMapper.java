package com.hititcs.jet.cdc.mapper.resultset;

import com.hazelcast.function.FunctionEx;
import com.hititcs.jet.cdc.record.FlightSegment;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class FlightSegmentResultSetMapper implements Serializable, FunctionEx<ResultSet, FlightSegment> {

    @Override
    public FlightSegment applyEx(ResultSet rs) throws SQLException {
        FlightSegment fs = new FlightSegment();

        fs.setSegIsn(rs.getLong("seg_isn"));
        fs.setDepCity(rs.getString("dep_city"));
        fs.setDepPort(rs.getString("dep_port"));
        fs.setSchDepDt(toLocalDateTime(rs,"sch_dep_dt"));
        fs.setSchArrDt(toLocalDateTime(rs,"sch_arr_dt"));
        fs.setArrPort(rs.getString("arr_port"));
        fs.setArrCity(rs.getString("arr_city"));
        fs.setSsNotify(rs.getString("ss_notify"));
        fs.setCxNotify(rs.getString("cx_notify"));
        fs.setWlOpen(rs.getString("wl_open"));
        fs.setWlAutoConfirm(rs.getString("wl_auto_confirm"));
        fs.setCrcComment(rs.getString("crc_comment"));
        fs.setSegmentType(rs.getString("segment_type"));
        fs.setInhibitSales(rs.getString("inhibit_sales"));
        fs.setDomestic(rs.getString("domestic"));
        fs.setDefaultInventoryTemplateIsn(rs.getObject("default_inventory_template_isn", Long.class));
        fs.setFltInfo(rs.getString("flt_info"));
        fs.setFltInfoText(rs.getString("flt_info_text"));
        fs.setAaCode(rs.getString("aa_code"));
        fs.setFltNo(rs.getString("flt_no"));
        fs.setSeatSellStatus(rs.getString("seat_sell_status"));
        fs.setIsIciOpen(rs.getString("is_ici_open"));
        fs.setIsIciOpenManual(rs.getString("is_ici_open_manual"));
        fs.setDistributionIsn(rs.getObject("distribution_isn", Long.class));
        fs.setDayOfWeek(rs.getString("day_of_week"));
        fs.setInhibitHoldBaggageSale(rs.getString("inhibit_hold_baggage_sale"));
        fs.setAllowKgBaggageSale(rs.getString("allow_kg_baggage_sale"));
        fs.setIsMobileCiOpen(rs.getString("is_mobile_ci_open"));
        fs.setIsMobileCiOpenManual(rs.getString("is_mobile_ci_open_manual"));
        fs.setEffectiveAfter(rs.getObject("effective_after", Long.class));
        fs.setOperatingProfileIsn(rs.getObject("operating_profile_isn", Long.class));
        fs.setAllowInv(rs.getString("allow_inv"));
        fs.setFltDuration(rs.getString("flt_duration"));
        fs.setDepCountry(rs.getString("dep_country"));
        fs.setArrCountry(rs.getString("arr_country"));
        fs.setOperatingCarrierCode(rs.getString("operating_carrier_code"));
        fs.setUtcSchDepDt(toLocalDateTime(rs, "utc_sch_dep_dt"));
        fs.setUtcSchArrDt(toLocalDateTime(rs,"utc_sch_arr_dt"));

        return fs;
    }

    private LocalDateTime toLocalDateTime(ResultSet rs, String column) throws SQLException {
        java.sql.Timestamp timestamp = rs.getTimestamp(column);
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
