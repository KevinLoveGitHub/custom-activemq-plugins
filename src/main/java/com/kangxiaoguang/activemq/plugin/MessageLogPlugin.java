package com.kangxiaoguang.activemq.plugin;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.plugin.StatisticsBrokerPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MessageLogPlugin implements BrokerPlugin {

  private Log log = LogFactory.getLog(StatisticsBrokerPlugin.class);

  public Broker installPlugin(Broker broker) throws Exception {
    log.info("install MessageLogPlugin");   
    return new MessageLog(broker);   
  }   
}
