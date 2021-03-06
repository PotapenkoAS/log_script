package com.company;

import java.util.HashMap;

public class PodsCatalog {

    public static HashMap<String, String> PODS = new HashMap<>();


    public static void init() {
        PODS.put("aqf", "arsnova-query-facade");
        PODS.put("фйа", "arsnova-query-facade");
        PODS.put("vqf", "verona-query-facade");
        PODS.put("мйа", "verona-query-facade");
        PODS.put("dqf", "dbo-query-facade");
        PODS.put("вйа", "dbo-query-facade");
        PODS.put("cccc", "card-contract-creation-command");
        PODS.put("сссс", "card-contract-creation-command");
        PODS.put("ccac", "card-contract-activation-command");
        PODS.put("ссфс", "card-contract-activation-command");
        PODS.put("laoc", "loan-application-offer-command");
        PODS.put("дфщс", "loan-application-offer-command");
        PODS.put("ht", "human-task");
        PODS.put("ре", "human-task");
        PODS.put("sfc", "scoring-full-command");
        PODS.put("ыас", "scoring-full-command");
        PODS.put("ccc", "contract-creation-command");
        PODS.put("ссс", "contract-creation-command");
        PODS.put("cac", "contract-activation-command");
        PODS.put("сфс", "contract-activation-command");
        PODS.put("ad", "application-document");
        PODS.put("фв", "application-document");
        PODS.put("omdm", "omdm-adapter");
        PODS.put("щьвь", "omdm-adapter");
        PODS.put("cdm", "client-data-manager");
        PODS.put("свь", "client-data-manager");
        PODS.put("d84", "account-d84-creation-command");
        PODS.put("в84", "account-d84-creation-command");
        PODS.put("plastic", "card-plastic-delivery-command");
        PODS.put("здфыешс", "card-plastic-delivery-command");
        PODS.put("sign", "loan-application-sign-types");
        PODS.put("ышпт", "loan-application-sign-types");
        PODS.put("last", "loan-application-sign-types");
        PODS.put("дфые", "loan-application-sign-types");
        PODS.put("pc", "params-collector");
        PODS.put("зс", "params-collector");
        PODS.put("dm", "decision-maker");
        PODS.put("вь", "decision-maker");
        PODS.put("la", "loan-application");
        PODS.put("дф", "loan-application");
        PODS.put("lapt", "loan-application-process-terminator");
        PODS.put("дфзе", "loan-application-process-terminator");
        PODS.put("not", "notification");
        PODS.put("тще", "notification");
        PODS.put("close", "card-contract-closing-command");
        PODS.put("сдщыу", "card-contract-closing-command");
        PODS.put("laps", "loan-application-process-support");
        PODS.put("дфзы", "loan-application-process-support");
        PODS.put("lae", "loan-application-events");
        PODS.put("дфу", "loan-application-events");
        PODS.put("lac", "loan-application-cleaner");
        PODS.put("дфс", "loan-application-cleaner");
        PODS.put("sc", "scoring-command");
        PODS.put("ыс", "scoring-command");
        PODS.put("ltct","loan-to-card-transfer-command");
        PODS.put("десе","loan-to-card-transfer-command");
        PODS.put("lah","loan-application-history");
        PODS.put("дфр","loan-application-history");
        PODS.put("ma","match-application");
        PODS.put("ьф","match-application");
        PODS.put("cat","loan-application-catalog");
        PODS.put("сфе","loan-application-catalog");
        PODS.put("aml","aml-check-command");
        PODS.put("фьд","aml-check-command");
        PODS.put("cngc","contract-number-generation-command");
        PODS.put("стпс","contract-number-generation-command");
        PODS.put("blac","basic-loan-application-command");
        PODS.put("идфс","basic-loan-application-command");
        PODS.put("basic","basic-loan-application-command");
        PODS.put("ифышс","basic-loan-application-command");
        PODS.put("asc","authorization-scans-command");
        PODS.put("фыс","authorization-scans-command");
        PODS.put("vc","verification-command");
        PODS.put("мс","verification-command");
        PODS.put("ic","identification-command");
        PODS.put("шс","identification-command");
        PODS.put("lcat","loan-application-catalog");
        PODS.put("дсфе","loan-application-catalog");
        PODS.put("pch","private-credit-history");
        PODS.put("зср","private-credit-history");
        PODS.put("goac","grant-operation-access-command");
        PODS.put("пщфс","grant-operation-access-command");
        PODS.put("sh","sms-handler");
        PODS.put("ыр","sms-handler");
        PODS.put("h","handler");
        PODS.put("р","handler");
        PODS.put("afs","afs-check");
        PODS.put("фаы","afs-check");
        PODS.put("afsc","afs-check-command");
        PODS.put("фаыс","afs-check-command");
        PODS.put("aup","arsnova-user-profile");
        PODS.put("фгз","arsnova-user-profile");
        PODS.put("ccclc","card-contract-closing-command");
        PODS.put("сссдс","card-contract-closing-command");
        PODS.put("cdc","carrier-delivery-command");
        PODS.put("свс","carrier-delivery-command");
        PODS.put("ca","clean-address");
        PODS.put("сф","clean-address");
        PODS.put("cdsc","client-data-sync-command");
        PODS.put("свыс","client-data-sync-command");
        PODS.put("chc","credit-history-command");
        PODS.put("срс","credit-history-command");
        PODS.put("chp","credit-history-profile");
        PODS.put("срз","credit-history-profile");
        PODS.put("cr","credit-report");
        PODS.put("ск","credit-report");
        PODS.put("edc","esign-document-command");
        PODS.put("увс","esign-document-command");
        PODS.put("foac","front-office-auth-client");
        PODS.put("ащфс","front-office-auth-client");
        PODS.put("fop","front-office-permissions");
        PODS.put("ащз","front-office-permissions");
        PODS.put("hta","human-task-arbitrator");
        PODS.put("реф","human-task-arbitrator");
        PODS.put("ips","ips-archive-loan-application-dispatcher");
        PODS.put("шзы","ips-archive-loan-application-dispatcher");
        PODS.put("lapl","loan-application-process-log");
        PODS.put("дфзд","loan-application-process-log");
        PODS.put("li","loan-insurance");
        PODS.put("дш","loan-insurance");
        PODS.put("lpi","loan-product-irr");
        PODS.put("дзш","loan-product-irr");
        PODS.put("lpcc","loyalty-program-check-command");
        PODS.put("дзсс","loyalty-program-check-command");
        PODS.put("msc","mail-stream-commander");
        PODS.put("ьыс","mail-stream-commander");
        PODS.put("pse","pfr-statement-extractor");
        PODS.put("зыу","pfr-statement-extractor");
        PODS.put("po","poa-operator");
        PODS.put("зщ","poa-operator");
        PODS.put("psc","product-switcher-command");
        PODS.put("зыс","product-switcher-command");
        PODS.put("ssc","send-sms-command");
        PODS.put("ыыс","send-sms-command");
        PODS.put("vh","verona-handler");
        PODS.put("мр","verona-handler");
        PODS.put("vht","verona-human-task");
        PODS.put("мре","verona-human-task");
        PODS.put("xsoc","x-sell-offer-command");
        PODS.put("чыщс","x-sell-offer-command");
        PODS.put("xsell","x-sell-offer-command");
        PODS.put("чыудд","x-sell-offer-command");








    }
}
