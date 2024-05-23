package com.example.lucake.service.template;

public interface TestTemplate extends ApiServiceTemplate<String, String> {

    @Override
    default String doTemplateActions() {

        this.A();

        this.B();

        this.C();

        return this.buildServiceRs();
    }

    void A();

    void B();

    void C();

    default String buildServiceRs() {
        return new String();
    }

}
