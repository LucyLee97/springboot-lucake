package com.example.lucake.service.template;

public interface ApiServiceTemplate<Rq, Rs> {
    /**
     * 資料初始化
     */
    void init(Rq serviceRq);

    /**
     * 執行Template方法
     * 
     * @return API Response
     */
    Rs doTemplateActions();

    /**
     * 執行Template方法
     * 
     * @param serviceRq 輸入內容
     * @return 輸出內容
     */
    default Rs doTemplateActions(Rq serviceRq) {
        this.init(serviceRq);
        try {
            Rs serviceRs = this.doTemplateActions();
            this.onTemplateActionsSuccess(serviceRq, serviceRs);
            return serviceRs;
        } catch (Throwable e) {
            this.onTemplateActionsError(serviceRq, e);
            throw e;
        }
    }

    default void onTemplateActionsError(Rq serviceRq, Throwable e) {
    }

    default void onTemplateActionsSuccess(Rq serviceRq, Rs serviceRs) {
    }

}
