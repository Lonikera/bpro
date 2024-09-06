package com.bank.history.dto;

/**
 * DTO (Data Transfer Object) для представления истории банковских операций.
 * Содержит информацию об идентификаторах аудита различных сущностей, связанных с банковской историей.
 *
 * @author [Ольга]
 */
public class HistoryDTO {

    /**
     * Уникальный идентификатор истории.
     */
    private Long id;

    /**
     * Идентификатор аудита операции перевода.
     */
    private Long transferAuditId;

    /**
     * Идентификатор аудита профиля пользователя.
     */
    private Long profileAuditId;

    /**
     * Идентификатор аудита банковского счета.
     */
    private Long accountAuditId;

    /**
     * Идентификатор аудита антифрод-проверки.
     */
    private Long antiFraudAuditId;

    /**
     * Идентификатор аудита публичной информации о банке.
     */
    private Long publicBankInfoAuditId;

    /**
     * Идентификатор аудита авторизации.
     */
    private Long authorizationAuditId;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransferAuditId() {
        return transferAuditId;
    }

    public void setTransferAuditId(Long transferAuditId) {
        this.transferAuditId = transferAuditId;
    }

    public Long getProfileAuditId() {
        return profileAuditId;
    }

    public void setProfileAuditId(Long profileAuditId) {
        this.profileAuditId = profileAuditId;
    }

    public Long getAccountAuditId() {
        return accountAuditId;
    }

    public void setAccountAuditId(Long accountAuditId) {
        this.accountAuditId = accountAuditId;
    }

    public Long getAntiFraudAuditId() {
        return antiFraudAuditId;
    }

    public void setAntiFraudAuditId(Long antiFraudAuditId) {
        this.antiFraudAuditId = antiFraudAuditId;
    }

    public Long getPublicBankInfoAuditId() {
        return publicBankInfoAuditId;
    }

    public void setPublicBankInfoAuditId(Long publicBankInfoAuditId) {
        this.publicBankInfoAuditId = publicBankInfoAuditId;
    }

    public Long getAuthorizationAuditId() {
        return authorizationAuditId;
    }

    public void setAuthorizationAuditId(Long authorizationAuditId) {
        this.authorizationAuditId = authorizationAuditId;
    }
}
