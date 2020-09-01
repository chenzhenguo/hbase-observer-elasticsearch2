package org.eminem.hbase.observer;
/**
 * Created on 2020.9.1
 *
 * @author chenzhenguo
 */

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ES Cleint class
 */
public class ESClient {

    public static Client client;

    /**
     * init ES client
     */
    public static void initEsClient() throws UnknownHostException {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        Settings esSettings = Settings.builder().put("cluster.name", "elasticsearch").build();//设置ES实例的名称
        client = new PreBuiltTransportClient(esSettings).addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

    }

    /**
     * Close ES client
     */
    public static void closeEsClient() {
        client.close();
    }
}