package com.example.orm.dto;

public class ImportSiteResponse extends ResponseObject<SiteResponse> {
    public ImportSiteResponse(ResponseObject<SiteResponse> responseObject) {
        super(responseObject.getData(), responseObject.getMessage(), responseObject.getErrors());
    }
}

