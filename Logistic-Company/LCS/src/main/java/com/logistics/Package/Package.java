package com.logistics.Package;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.logistics.UsersAndAuth.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(
        name="packages"
)
public class Package implements Comparable<Package> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "package_users",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> packageUsers = new ArrayList<>();

    @NotNull
    @Size(max = 50)
    @Column(name="senderFirstName", nullable = false)
    private String senderFirstName;

    @NotNull
    @Size(max = 50)
    @Column(name="senderLastName", nullable = false)
    private String senderLastName;

    @NotNull
    @Size(min = 6, max = 13)
    @Column(name="senderTelephoneNumber", nullable = false)
    private String senderTelephoneNumber;

    @Size(max = 50)
    @Column(name="senderEmail", nullable = false)
    private String senderEmail;

    @Column(name = "isFirm", columnDefinition = "boolean default false")
    private boolean isFirm = false;

    @Size(max = 100)
    @Column(name="firmName", nullable = true)
    private String firmName = "";

    @Column(name = "fromOffice", columnDefinition = "boolean default true")
    private boolean fromOffice = true;

    @NotNull
    @Size(max = 50)
    @Column(name="fromAddress", nullable = false)
    private String fromAddress;

    @NotNull
    @Size(max = 50)
    @Column(name="receiverFirstName", nullable = false)
    private String receiverFirstName;

    @NotNull
    @Size(max = 50)
    @Column(name="receiverLastName", nullable = false)
    private String receiverLastName;

    @NotNull
    @Size(min = 6, max = 13)
    @Column(name="receiverTelephoneNumber", nullable = false)
    private String receiverTelephoneNumber;

    @Size(max = 50)
    @Column(name="receiverEmail", nullable = false)
    private String receiverEmail;

    @Column(name = "toOffice", columnDefinition = "boolean default true")
    private boolean toOffice = true;

    @NotNull
    @Size(max = 50)
    @Column(name="toAddress", nullable = false)
    private String toAddress;

    @Enumerated(EnumType.STRING)
    private EPackageStatus ePackageStatus;

    @Enumerated(EnumType.STRING)
    private EPackageType ePackageType;

    @Enumerated(EnumType.STRING)
    private EPayMethod ePayMethod;

    @Column(name = "weight", precision=10, scale=2)
    private double weight;

    @Column(name = "isFragile", columnDefinition = "boolean default false")
    private boolean isFragile = false;

    @Column(name = "price", precision=10, scale=2)
    private double price;

    @Size(max = 50)
    @Column(name="comment", nullable = true)
    public String comment;

    @Column(name = "isReturnToOffice", columnDefinition = "boolean default false")
    private boolean isReturnToOffice = false;

    @Size(max = 100)
    @Column(name="returnLocation", nullable = true)
    private String returnLocation = "";

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name="privateCode", nullable = false)
    private String privateCode;

    @NotNull
    @Column(name="fromCity", nullable = false)
    private String fromCity;

    @NotNull
    @Column(name="toCity", nullable = false)
    private String toCity;

    @NotNull
    @Column(name="alternativeCity", nullable = false)
    private String alternativeCity;


    @Column(name="toFirmName", nullable = false)
    private String toFirmName;

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getAlternativeCity() {
        return alternativeCity;
    }

    public void setAlternativeCity(String alternativeCity) {
        this.alternativeCity = alternativeCity;
    }

    public String getToFirmName() {
        return toFirmName;
    }

    public void setToFirmName(String toFirmName) {
        this.toFirmName = toFirmName;
    }

    public boolean isToFirm() {
        return toFirm;
    }

    public void setToFirm(boolean toFirm) {
        this.toFirm = toFirm;
    }

    public LocalDate getDateOfSending() {
        return dateOfSending;
    }

    public void setDateOfSending(LocalDate dateOfSending) {
        this.dateOfSending = dateOfSending;
    }

    @Column(name = "toFirm", columnDefinition = "boolean default false")
    private boolean toFirm = false;

    @Column(name="dateOfRequest")
    private LocalDateTime dateOfRequest;

    @Column(name="dateOfRegistration")
    private LocalDateTime dateOfRegistration;

    @Column(name="dateOfDelivery")
    private LocalDate dateOfDelivery;

    @Column(name="dateOfSending")
    private LocalDate dateOfSending;

    @Column(name="cashOnDelivery")
    private double cashOnDelivery;

    @Column(name="iban")
    private String iban;

    @Column(name="isCashOnDelivery")
    private boolean isCashOnDelivery;

    @Column(name="bic")
    private String bic;

    @Column(name="bank")
    private String bank;

    @Column(name="returnCashCity")
    private String returnCashCity;

    @Column(name="returnCashAddress")
    private String returnCashAddress;

    public String getReturnCashCity() {
        return returnCashCity;
    }

    public void setReturnCashCity(String returnCashCity) {
        this.returnCashCity = returnCashCity;
    }

    public String getReturnCashAddress() {
        return returnCashAddress;
    }

    public void setReturnCashAddress(String returnCashAddress) {
        this.returnCashAddress = returnCashAddress;
    }

    @Column(name="bankAccountOwner")
    private String bankAccountOwner;

    @Column(name="returnCashToOffice")
    private boolean returnCashToOffice;

    public double getCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(double cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }



    public boolean getIsCashOnDelivery() {
        return isCashOnDelivery;
    }

    public void setIsCashOnDelivery(boolean cashOnDelivery) {
        isCashOnDelivery = cashOnDelivery;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccountOwner() {
        return bankAccountOwner;
    }

    public void setBankAccountOwner(String bankAccountOwner) {
        this.bankAccountOwner = bankAccountOwner;
    }

    public boolean getIsReturnCashToOffice() {
        return returnCashToOffice;
    }

    public void setIsReturnCashToOffice(boolean returnCashToOffice) {
        this.returnCashToOffice = returnCashToOffice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getPackageUsers() {
        return packageUsers;
    }

    public void setPackageUsers(List<User> packageUsers) {
        this.packageUsers = packageUsers;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getSenderTelephoneNumber() {
        return senderTelephoneNumber;
    }

    public void setSenderTelephoneNumber(String senderTelephoneNumber) {
        this.senderTelephoneNumber = senderTelephoneNumber;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public boolean isFirm() {
        return isFirm;
    }

    public void setFirm(boolean firm) {
        isFirm = firm;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public boolean isFromOffice() {
        return fromOffice;
    }

    public void setFromOffice(boolean fromOffice) {
        this.fromOffice = fromOffice;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getReceiverTelephoneNumber() {
        return receiverTelephoneNumber;
    }

    public void setReceiverTelephoneNumber(String receiverTelephoneNumber) {
        this.receiverTelephoneNumber = receiverTelephoneNumber;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public boolean isToOffice() {
        return toOffice;
    }

    public void setToOffice(boolean toOffice) {
        this.toOffice = toOffice;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public EPackageStatus getePackageStatus() {
        return ePackageStatus;
    }

    public void setePackageStatus(EPackageStatus ePackageStatus) {
        this.ePackageStatus = ePackageStatus;
    }

    public EPackageType getePackageType() {
        return ePackageType;
    }

    public void setePackageType(EPackageType ePackageType) {
        this.ePackageType = ePackageType;
    }

    public EPayMethod getePayMethod() {
        return ePayMethod;
    }

    public void setePayMethod(EPayMethod ePayMethod) {
        this.ePayMethod = ePayMethod;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isReturnToOffice() {
        return isReturnToOffice;
    }

    public void setReturnToOffice(boolean returnToOffice) {
        isReturnToOffice = returnToOffice;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public String getPrivateCode() {
        return privateCode;
    }

    public void setPrivateCode(String privateCode) {
        this.privateCode = privateCode;
    }

    public LocalDateTime getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(LocalDateTime dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public LocalDate getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(LocalDate dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public Package() {}

    public Package(String senderFirstName,
                   String senderLastName,
                   String senderTelephoneNumber,
                   String senderEmail,
                   boolean isFirm,
                   String firmName,
                   boolean fromOffice,
                   String fromAddress,
                   String receiverFirstName,
                   String receiverLastName,
                   String receiverTelephoneNumber,
                   String receiverEmail,
                   boolean toOffice,
                   String toAddress,
                   EPackageType ePackageType,
                   EPayMethod ePayMethod,
                   double weight,
                   boolean isFragile,
                   String comment,
                   boolean isReturnToOffice,
                   String returnLocation,
                   LocalDate dateOfDelivery,
                   LocalDate dateOfSending,
                   boolean toFirm,
                   String toFirmName,
                   String fromCity,
                   String toCity,
                   String alternativeCity
                   ) {
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
        this.senderTelephoneNumber = senderTelephoneNumber;
        this.senderEmail = senderEmail;
        this.isFirm = isFirm;
        this.firmName = firmName;
        this.fromOffice = fromOffice;
        this.fromAddress = fromAddress;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
        this.receiverTelephoneNumber = receiverTelephoneNumber;
        this.receiverEmail = receiverEmail;
        this.toOffice = toOffice;
        this.toAddress = toAddress;
        this.ePackageType = ePackageType;
        this.ePayMethod = ePayMethod;
        this.weight = weight;
        this.isFragile = isFragile;
        this.price = price;
        this.comment = comment;
        this.isReturnToOffice = isReturnToOffice;
        this.returnLocation = returnLocation;
        this.dateOfDelivery = dateOfDelivery;
        this.dateOfSending = dateOfSending;
        this.toFirm = toFirm;
        this.toFirmName = toFirmName;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.alternativeCity = alternativeCity;
    }
    @Override
    public int compareTo(Package p) {
        return getDateOfRequest().compareTo(p.getDateOfRequest());
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", packageUsers=" + packageUsers +
                ", senderFirstName='" + senderFirstName + '\'' +
                ", senderLastName='" + senderLastName + '\'' +
                ", senderTelephoneNumber='" + senderTelephoneNumber + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                ", isFirm=" + isFirm +
                ", firmName='" + firmName + '\'' +
                ", fromOffice=" + fromOffice +
                ", fromAddress='" + fromAddress + '\'' +
                ", receiverFirstName='" + receiverFirstName + '\'' +
                ", receiverLastName='" + receiverLastName + '\'' +
                ", receiverTelephoneNumber='" + receiverTelephoneNumber + '\'' +
                ", receiverEmail='" + receiverEmail + '\'' +
                ", toOffice=" + toOffice +
                ", toAddress='" + toAddress + '\'' +
                ", ePackageStatus=" + ePackageStatus +
                ", ePackageType=" + ePackageType +
                ", ePayMethod=" + ePayMethod +
                ", weight=" + weight +
                ", isFragile=" + isFragile +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", isReturnToOffice=" + isReturnToOffice +
                ", returnLocation='" + returnLocation + '\'' +
                ", privateCode='" + privateCode + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", alternativeCity='" + alternativeCity + '\'' +
                ", toFirmName='" + toFirmName + '\'' +
                ", toFirm=" + toFirm +
                ", dateOfRequest=" + dateOfRequest +
                ", dateOfRegistration=" + dateOfRegistration +
                ", dateOfDelivery=" + dateOfDelivery +
                ", dateOfSending=" + dateOfSending +
                '}';
    }
}

