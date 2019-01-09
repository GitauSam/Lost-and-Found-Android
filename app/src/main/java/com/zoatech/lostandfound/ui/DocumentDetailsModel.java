package com.zoatech.lostandfound.ui;

class DocumentDetailsModel {
    private int id_number;
    private String type, status;

    DocumentDetailsModel(int id_number, String type, String status) {
        this.id_number = id_number;
        this.type = type;
        this.status = status;
    }

    int getId_number() {
        return id_number;
    }

    String getType() {
        return type;
    }

    String getStatus() {
        return status;
    }
}
