package com.kangxiaoguang.activemq.plugin;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ProducerBrokerExchange;
import org.apache.activemq.command.Message;
import org.apache.activemq.plugin.StatisticsBrokerPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//BrokerFilter这个类包含了broker的很多操作，可以看看源码了解一下
public class MessageLog extends BrokerFilter {
    private Log log;

    public MessageLog(Broker next) {
        super(next);
        log = LogFactory.getLog(StatisticsBrokerPlugin.class);
        log.info("initialize Message Log plugin");
    }

    @Override
    public void send(ProducerBrokerExchange producerExchange, Message messageSend) throws Exception {
        //在这里实现筛选
        if (messageSend.getProperty("appname") != null && messageSend.getProperty("misid") != null) {
            if (!messageSend.getProperty("appname").equals("OSCM") && !messageSend.getProperty("appname").equals(
                    "OSPM"))
                log.info("[FLOW_LOG] MissionID:  " + messageSend.getProperty("misid") + " Destination: " + messageSend.getDestination());
        }

        log.info("[FLOW_LOG]" + " Destination: " + messageSend.getDestination());
        super.send(producerExchange, messageSend);
    }
}
