package com.example.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    public List<Site> getAll (){
        return siteRepository.findAll();
    }

    public Site save (Site site){
        return siteRepository.save(site);
    }

    public void testAdd() {
        String[] arr = {"Khu A", "lo A", "Toa A", "Tang 1"};
        List<String> row1 = Arrays.stream(arr).toList();
        String[] arr12 = {"Khu A", "lo A", "Toa A", "Tang 2"};
        List<String> row2 = Arrays.stream(arr12).toList();
        String[] arr13 = {"Khu A", "lo A", "Toa A", "Tang 3"};
        List<String> row3 = Arrays.stream(arr13).toList();
        String[] arr14 = {"Khu A", "lo A", "Toa B", "Tang 1"};
        List<String> row4 = Arrays.stream(arr14).toList();

        String[] arr2 = {"Khu A", "lo A", "Toa B", "Tang 2"};
        List<String> row5 = Arrays.stream(arr2).toList();
        String[] arr21 = {"Khu A", "lo A", "Toa B", "Tang 3"};
        List<String> row6 = Arrays.stream(arr21).toList();
        String[] arr22 = {"Khu B", "lo A", "Toa A", "Tang 1"};
        List<String> row7 = Arrays.stream(arr22).toList();
        String[] arr23 = {"Khu B", "lo B", "Toa A", "Tang 2"};
        List<String> row8 = Arrays.stream(arr23).toList();
        String[] arr3 = {"Khu B", "lo B", "Nha 1", "Tang 2"};
        List<String> row9 = Arrays.stream(arr3).toList();

        List<List<String>> data = new ArrayList<>();
        data.add(row1);
        data.add(row2);
        data.add(row3);
        data.add(row4);
        data.add(row5);
        data.add(row6);
        data.add(row7);
        data.add(row8);
        data.add(row9);

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
            int pid = -1;
            for (String cell : row) {
                KeySite keySite = new KeySite(cell, pid);

                if (map.containsKey(keySite)) {
                    // đã tồn tại
                    pid = map.get(keySite);
                }else {
                    // chưa tồn tại
                    Site site1 = new Site(0, 0, "", "", "", "", cell, "", pid );
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
