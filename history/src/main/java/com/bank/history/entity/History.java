package com.bank.history.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Сущность, представляющая историю банковской операции.
 * Содержит информацию об идентификаторах различных аудитов, связанных с операцией.
 *
 * @author [Ольга]
 */
@Entity
@Table(name = "history")
@ToString
public class History {

    /**
     * Идентификатор истории.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Идентификатор аудита перевода.
     */
    private Long transferAuditId;

    /**
     * Идентификатор аудита профиля.
     */
    private Long profileAuditId;

    /**
     * Идентификатор аудита счета.
     */
    private Long accountAuditId;

    /**
     * Идентификатор аудита антифрода.
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
