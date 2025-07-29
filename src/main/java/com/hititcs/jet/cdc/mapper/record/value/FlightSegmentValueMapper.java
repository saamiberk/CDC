package com.hititcs.jet.cdc.mapper.record.value;

import com.hazelcast.enterprise.jet.cdc.ChangeRecord;
import com.hazelcast.function.FunctionEx;
import com.hititcs.jet.cdc.record.FlightSegment;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FlightSegmentValueMapper implements FunctionEx<ChangeRecord, FlightSegment>, Serializable {

    @Override
    public FlightSegment applyEx(ChangeRecord record) {
        try {
            return record.value().toObject(FlightSegment.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    boolean filter(FlightSegment flightSegment) {
        LocalDateTime lastFiveYear = LocalDateTime.now().minusYears(5);
        return flightSegment.getSchDepDt().isAfter(lastFiveYear);
    }
}
