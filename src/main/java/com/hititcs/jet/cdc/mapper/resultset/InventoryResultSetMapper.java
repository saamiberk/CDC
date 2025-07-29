package com.hititcs.jet.cdc.mapper.resultset;

import com.hazelcast.function.FunctionEx;
import com.hititcs.jet.cdc.record.FlightSegment;
import com.hititcs.jet.cdc.record.Inventory;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class InventoryResultSetMapper implements Serializable, FunctionEx<ResultSet, Inventory> {

    @Override
    public Inventory applyEx(ResultSet rs) throws SQLException {
        Inventory inventory = new Inventory();

        inventory.setRezClass(rs.getString("rez_class"));
        inventory.setSegIsn(rs.getLong("seg_isn"));
        inventory.setCabinClass(rs.getString("cabin_class"));
        inventory.setAutorization(rs.getInt("autorization"));
        inventory.setSeatsSold(rs.getInt("seats_sold"));
        inventory.setWlLen(rs.getInt("wl_len"));
        inventory.setWlMaxLen(rs.getInt("wl_max_len"));
        inventory.setSsNotifyLimit(rs.getObject("ss_notify_limit", Integer.class));
        inventory.setCxNotifyLimit(rs.getObject("cx_notify_limit", Integer.class));
        inventory.setLastUpdate(rs.getTimestamp("last_update").toLocalDateTime());
        inventory.setSeatSoldLimit(rs.getObject("seat_sold_limit", Integer.class));
        inventory.setLastIncomingAvsCode(rs.getString("last_incoming_avs_code"));
        inventory.setFareLevel(rs.getString("fare_level"));
        inventory.setEffectiveDate(toLocalDateTime(rs, "effective_date"));
        inventory.setDiscontinueDate(toLocalDateTime(rs, "discontinue_date"));
        inventory.setSalesStatus(rs.getString("sales_status"));
        inventory.setInventoryGroupNo(rs.getInt("inventory_group_no"));
        inventory.setAlmSeatsSold(rs.getInt("alm_seats_sold"));

        return inventory;
    }

    private LocalDateTime toLocalDateTime(ResultSet rs, String column) throws SQLException {
        java.sql.Timestamp timestamp = rs.getTimestamp(column);
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
