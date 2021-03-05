package br.com.pietrobondioli.processstorageapi.domain;

public class Process {

    private Integer processId;
    private String firstName;
    private String lastName;
    private String cpf;
    private String email;
    private Integer folder;
    private String receipt;
    private String receiptIssueDate;
    private String address;
    private String district;
    private String city;
    private String state;
    private String country;
    private String cep;
    private String notes;

    public Process(Integer processId,
                   String firstName,
                   String lastName,
                   String cpf,
                   String email,
                   Integer folder,
                   String receipt,
                   String receiptIssueDate,
                   String address,
                   String district,
                   String city,
                   String state,
                   String country,
                   String cep,
                   String notes) {
        this.processId = processId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.folder = folder;
        this.receipt = receipt;
        this.receiptIssueDate = receiptIssueDate;
        this.address = address;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.cep = cep;
        this.notes = notes;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFolder() {
        return folder;
    }

    public void setFolder(Integer folder) {
        this.folder = folder;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getReceiptIssueDate() {
        return receiptIssueDate;
    }

    public void setReceiptIssueDate(String receiptIssueDate) {
        this.receiptIssueDate = receiptIssueDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
