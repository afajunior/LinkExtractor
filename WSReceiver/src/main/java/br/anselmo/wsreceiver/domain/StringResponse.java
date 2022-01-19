package br.anselmo.wsreceiver.domain;

public class StringResponse {
    private final String response;

    public StringResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
