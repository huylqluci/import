package com.example.orm;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SiteServiceTest {
    @Mock
    SiteRepository siteRepository;


    @Autowired
    SiteService siteService;

    @Test
    public void importSuccess(){

    }
}