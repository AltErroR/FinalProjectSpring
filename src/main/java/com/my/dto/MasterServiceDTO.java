package com.my.dto;

import org.springframework.stereotype.Component;


@Component
public class MasterServiceDTO {
    private String masterLogin;
    private String serviceName;

    public MasterServiceDTO(){};

    public MasterServiceDTO(String masterLogin, String serviceName) {
        this.masterLogin=masterLogin;
        this.serviceName=serviceName;
    }

    public String getMasterLogin() {
        return masterLogin;
    }

    public void setMasterLogin(String masterLogin) {
        this.masterLogin = masterLogin;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
