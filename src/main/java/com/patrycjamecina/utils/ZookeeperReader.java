package com.patrycjamecina.utils;
import com.patrycjamecina.model.Zookeeper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ZookeeperReader {
    public Map<String, Zookeeper> fillStructureZookeeper() throws URISyntaxException, IOException {
        Map<String, Zookeeper> zookeeperMap = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("zookeeper").toURI()));
        lines.remove(0);
        for (String line : lines) {
            String[] source = line.split("\t");
            Zookeeper zookeeper = new Zookeeper();
            zookeeper.setId(source[0]);
            zookeeper.setName(source[1]);
            zookeeper.setGender(source[2]);
            zookeeperMap.put(source[0], zookeeper);
        }
        return zookeeperMap;
    }
}
