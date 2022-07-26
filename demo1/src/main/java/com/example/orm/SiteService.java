package com.example.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SiteService {
    @Autowired
    private SiteRepository siteRepository;
    public void testAdd() {
        String[] arr = {"Khu A", "lo A", "Toa A", "Tang 1"};
        List<String> row1 = Arrays.stream(arr).toList();
        String[] arr12 = {"Khu A", "lo A", "Toa A", "Tang 2"};
        List<String> row2 = Arrays.stream(arr12).toList();
        List<List<String>> data = new ArrayList<>();
        data.add(row1);
        data.add(row2);

        List<Site> sites = saveList(data);
        System.out.println(sites);
    }
    public List<Site> saveList(List<List<String>> data) {
        // Load Map
        List<Site> sites = siteRepository.findAll();
        Map<KeySite, Integer> map = loadMapToDataDB(sites);
        // For and Save
        int i;
        List<Site> sites2 = new ArrayList<>();
        for (List<String> row : data) {
            i = 0;
            int pid = 1;
            for (String cell : row) {
                KeySite keySite = new KeySite(cell, pid);
                if (map.containsKey(keySite)) {
                    // đã tồn tại
                    pid = map.get(keySite);
                }else {
                    // chưa tồn tại
                    Site site1 = new Site(0, null, "", "", "", "", cell, "", pid );
                    Site site2 = siteRepository.save(site1);
                    map.put (new KeySite(cell, pid), site2.getId());
                    pid = site2.getId();
                    // addFromMap
                }
            }
        }
        return sites;
    }
    private Map<KeySite, Integer> loadMapToDataDB(List<Site> sites) {
        Map<KeySite, Integer> map = new HashMap<KeySite, Integer>();
        for (Site site : sites) {
            map.put(new KeySite(site.getName(), site.getPid()), site.getId());
        }
        return map;
    }
}
