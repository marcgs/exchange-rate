package com.mgomez.exchange.service;

import com.google.common.collect.ImmutableList;
import com.mgomez.exchange.date.DateFactory;
import com.mgomez.exchange.model.EuroXRef;
import com.mgomez.exchange.model.Period;
import com.mgomez.exchange.model.RatesPerPeriod;
import com.mgomez.exchange.xml.EuroXRefXmlParser;
import com.mgomez.exchange.xml.EuroXRefXmlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Collections.emptyList;

@Service
public class EuroXRefService {

    @Autowired
    private EuroXRefXmlParser xmlParser;
    @Autowired
    private EuroXRefXmlProvider xmlProvider;
    @Autowired
    private DateFactory dateFactory;

    private EuroXRef euroXRef;

    public EuroXRefService() {
    }

    //@VisibleForTesting
    EuroXRefService(EuroXRefXmlParser xmlParser, EuroXRefXmlProvider xmlProvider, DateFactory dateFactory) {
        this.xmlParser = xmlParser;
        this.xmlProvider = xmlProvider;
        this.dateFactory = dateFactory;
    }

    public EuroXRef getEuroXRef() {
        return euroXRef;
    }

    public EuroXRef getEuroXRef(final Integer daysFromToday) {
        String date = dateFactory.daysFromToday(daysFromToday);
        Optional<Period> optionalPeriod = euroXRef.getRatesPerPeriod().getPeriods().stream()
                .filter(period -> period.getTime().equals(date))
                .findFirst();
        List<Period> periods = optionalPeriod.isPresent() ? ImmutableList.of(optionalPeriod.get()) : emptyList();
        return new EuroXRef(euroXRef.getSubject(), euroXRef.getSender(), new RatesPerPeriod(periods));
    }

    @Scheduled(fixedDelay = 60000)
    public void updateData() throws Exception {
        String xmlData = xmlProvider.getXml();
        this.euroXRef = xmlParser.parseXml(xmlData);
    }


}
