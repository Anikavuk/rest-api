package com.example.restapi.controllers;

import com.example.restapi.dto.analytics.QueryData;
import com.example.restapi.dto.analytics.QueryHistory;
import com.example.restapi.services.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/byQuery")
    public List<QueryData> byQuery(){
        return analyticsService.byQuery();
    }

    @GetMapping("/history/{query}")
    public List<QueryHistory> historyQuery(@PathVariable String query, @Param("depth") int depth){
        return analyticsService.historyQuery(query, depth);
    }
}
