import React from 'react';
import axios from 'axios';

import "./AllPackages.css";
import { DOMAIN } from ".././constants/Domain.js";
import { mapPackageStatus } from ".././constants/MapPackageStatus";

import "@ui5/webcomponents/dist/Label";
import "@ui5/webcomponents-fiori/dist/Timeline";
import "@ui5/webcomponents-fiori/dist/Bar.js";
import "@ui5/webcomponents-fiori/dist/FlexibleColumnLayout.js";
import "@ui5/webcomponents/dist/Input.js";
import "@ui5/webcomponents/dist/List.js";
import "@ui5/webcomponents/dist/StandardListItem.js";
import "@ui5/webcomponents/dist/Table.js";
import "@ui5/webcomponents/dist/TableColumn.js";
import "@ui5/webcomponents/dist/TableRow.js";
import "@ui5/webcomponents/dist/TableCell.js"
import "@ui5/webcomponents/dist/Badge";
import Package from '../packageSubmit/Package';

class AllPackages extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            packages: [],
            filteredPackages: [],
            selectedPackageId: 1,
            role: "",
            accessToken: "",
            fromDate: "",
            toDate: "",
            filterInput: "",
            statuses: [],
            packageStatus: "",
            counter: 2
        };
        this.handleInputValue = this.handleInputValue.bind(this);
        this.handleSelectionValue = this.handleSelectionValue.bind(this);
        this.onPackageDetailsClose = this.onPackageDetailsClose.bind(this);
        this.onPackageListSelect = this.onPackageListSelect.bind(this);
        this.onFilter = this.onFilter.bind(this);
        this.onFilterClear = this.onFilterClear.bind(this);
        this.onPackageEdit = this.onPackageEdit.bind(this);
        this.onPackageDelete = this.onPackageDelete.bind(this);
        this.onStatusChange = this.onStatusChange.bind(this);
        this.firstTime = this.firstTime.bind(this);
        this.onMy = this.onMy.bind(this);
        this.onMine = this.onMine.bind(this);
    }

    handleInputValue(event) {
        const { name, value } = event.target;
        this.setState({
            [name]: value
        });
    }

    handleSelectionValue(event) {
        this.setState({
            [event.target.name]: event.target.selectedOption.value
        });
    }

    onStatusChange() {
       const URL = DOMAIN + "api/packages/status";

       const statusDetails = {
           "id": this.state.selectedPackageId,
           "ePackageStatus": this.state.packageStatus
       }

       axios.put(URL, statusDetails, {
        headers: {
            'Authorization': 'Bearer ' + this.state.accessToken
        }
    }).then(res => {
        this.firstTime();
    });
    }

    onPackageListSelect(event) {
        const id = event.detail.item.getAttribute("data-id");
        this.setState({
            selectedPackageId: id
        })

        const URL = DOMAIN + 'api/packages/status/' + id;

        axios.get(URL, {
            headers: {
                'Authorization': 'Bearer ' + this.state.accessToken
            }
        }).then(s => {
            const statuses = s.data;
            this.setState({
                statuses: statuses,
                packageStatus: statuses[0]
            });
        });
    }

    onPackageDetailsClose() {
        this.setState({
            selectedPackageId: -1
        })
    }

    onPackageDelete() {
        const URL = DOMAIN + 'api/packages/' + this.state.selectedPackageId;

        axios.delete(URL, {
            headers: {
                'Authorization': 'Bearer ' + this.state.accessToken
            }
        }).then(res => {
            this.firstTime();
        });
    }

    onFilter() {
        let filterApplied = this.state.packages;
        if (this.state.filterInput !== "") {
            filterApplied = filterApplied.filter(p => (p.senderFirstName + " " + p.senderLastName) === this.state.filterInput
                || p.senderLastName === this.state.filterInput || (p.receiverFirstName + " " + p.receiverLastName) === this.state.filterInput
                || p.receiverLastName === this.state.filterInput || p.senderTelephoneNumber === this.state.filterInput
                || p.receiverTelephoneNumber === this.state.filterInput || p.senderEmail === this.state.filterInput
                || p.receiverEmail === this.state.filterInput || p.fromAddress === this.state.filterInput
                || p.fromCity === this.state.filterInput || p.toAddress === this.state.filterInput || p.toCity === this.state.filterInput
                || p.ePackageStatus === this.state.filterInput);
            console.log(filterApplied);
        }
        if (this.state.fromDate !== "" && this.state.toDate === "") {
            filterApplied = filterApplied.filter(p => p.dateOfSending === this.state.fromDate);
        }
        if (this.state.fromDate !== "" && this.state.toDate !== "") {
            filterApplied = filterApplied.filter(p => Date.parse(p.dateOfSending) >= Date.parse(this.state.fromDate)
                && Date.parse(p.dateOfSending) <= Date.parse(this.state.toDate));
        }
        this.setState({
            filteredPackages: filterApplied
        })
    }

    onFilterClear() {
        console.log("CLEAR");
        this.setState({
            filteredPackages: this.state.packages,
            filterInput: "",
            toDate: "",
            fromDate: ""
        });
    }

    onPackageEdit() {
        this.props.history.push({
            pathname: '/package/edit',
            state: this.state.selectedPackageId
        })
    }

    addEventListeners() {
        const packageList = document.getElementById('packageList');
        if (packageList) {
            packageList.addEventListener("item-click", this.onPackageListSelect);
        }

        document.querySelectorAll('.input').forEach(item => {
            item.addEventListener("change", this.handleInputValue);
        })

        const filterButton = document.getElementById('filter-search-button-add-package');
        if (filterButton) {
            filterButton.addEventListener("click", this.onFilter);
        }

        const statusSelect = document.getElementById("status-change-select");
        if (statusSelect) {
            statusSelect.addEventListener("change", this.handleSelectionValue);
        }

        const statusButton = document.getElementById("change-status-button");
        if (statusButton) {
            statusButton.addEventListener("click", this.onStatusChange);
        }
       
    }

    removeEventListeners() {
        const packageList = document.getElementById('packageList');
        if (packageList) {
            packageList.removeEventListener("item-click", this.onPackageListSelect);
        }

        document.querySelectorAll('.input').forEach(item => {
            item.removeEventListener("change", this.handleInputValue);
        })

        const filterButton = document.getElementById('filter-search-button-add-package');
        if (filterButton) {
            filterButton.removeEventListener("click", this.onFilter);
        }

        const statusSelect = document.getElementById("status-change-select");
        if (statusSelect) {
            statusSelect.removeEventListener("change", this.handleSelectionValue);
        }

        const statusButton = document.getElementById("change-status-button");
        if (statusButton) {
            statusButton.removeEventListener("click", this.onStatusChange);
        }
       

    }

    componentDidUpdate() {
        this.removeEventListeners();
        this.addEventListeners();
    }

    componentDidMount() {
        this.addEventListeners();
        this.firstTime();

    }

    onMine() {
        if(this.state.counter % 2 === 0) {
            this.firstTime();
        }else{
            this.onMy();
        }
    }

    onMy() {
        const URL = DOMAIN + "api/packages/mine";

        const accessToken = JSON.parse(sessionStorage.getItem('user')).accessToken;

        if (accessToken) {

            axios.get(URL, {
                headers: {
                    'Authorization': 'Bearer ' + accessToken
                }
            }).then(p => {
                console.log(p.data);
                this.setState({
                    packages: p.data,
                    filteredPackages: p.data,
                    accessToken: accessToken,
                    counter: this.state.counter + 1
                });

                if (this.state.filteredPackages.length !== 0) {
                    this.setState({
                        selectedPackageId: this.state.filteredPackages[0].id
                    })
                }
            })
        }
    }

    firstTime() {
        const URL = DOMAIN + "api/packages";

        const accessToken = JSON.parse(sessionStorage.getItem('user')).accessToken;

        if (accessToken) {

            axios.get(URL, {
                headers: {
                    'Authorization': 'Bearer ' + accessToken
                }
            }).then(p => {
                console.log(p.data);
                this.setState({
                    packages: p.data,
                    filteredPackages: p.data,
                    accessToken: accessToken,
                    counter: this.state.counter + 1
                });

                if (this.state.filteredPackages.length !== 0) {
                    this.setState({
                        selectedPackageId: this.state.filteredPackages[0].id
                    })
                }
            })

            try {
                const role = JSON.parse(sessionStorage.getItem('user')).role;
                this.setState({
                    role: role
                })
            }
            catch (e) { }

        }
    }

    render() {
        const Package = this.state.filteredPackages.find(d => d.id == this.state.selectedPackageId);
        return (
            <div className="packages-view-container">
                {this.state.filteredPackages.length !== 0 && this.state.packages.length !== 0 ?
                    <div className="packages-view-table">
                        {/* {this.state.role !== "ROLE_CLIENT" && */}
                        <div className="filter-container">
                            <ui5-title level="H4">Филтър</ui5-title>
                            <div className="filter-contents">
                                <ui5-input class="input" name="filterInput" value={this.state.filterInput} placeholder="Име, телефон, имейл, офис, адрес"></ui5-input>
                                <ui5-date-picker class="input" id="from-date-input" value={this.state.fromDate} format-pattern='yyyy-MM-dd' name="fromDate" placeholder="От дата"></ui5-date-picker>
                                <ui5-date-picker class="input" value={this.state.toDate} format-pattern='yyyy-MM-dd' name="toDate" placeholder="До дата"></ui5-date-picker>
                                <ui5-button id="filter-search-button-add-package" design="Emphasized">Търси</ui5-button>
                                <ui5-button id="filter-clear-button" onClick={this.onFilterClear}>Изчисти</ui5-button>
                                <ui5-button id="filter-mine" icon="activities" onClick={this.onMine}>Моите пратки</ui5-button>
                            </div>
                        </div>
                        {/* } */}
                        <ui5-flexible-column-layout id="fcl" layout="TwoColumnsMidExpanded">
                            <div slot="startColumn">
                                <ui5-list id="packageList" header-text="Пратки">
                                    {this.state.filteredPackages.map(m => {
                                        return (
                                            <div>
                                                <ui5-li data-id={m.id} icon="navigation-right-arrow"
                                                    icon-end description={"Получател: " + m.receiverFirstName + " " + m.receiverLastName}
                                                    info={mapPackageStatus(m.ePackageStatus)} info-state="Success">{m.senderFirstName + " " + m.senderLastName}</ui5-li>
                                            </div>
                                        )
                                    })}

                                </ui5-list>
                            </div>
                            {Package ?
                                <div slot="midColumn">
                                    <div class="colHeader">
                                        {this.state.role !== "ROLE_CLIENT" ?
                                            <ui5-bar>
                                                <ui5-select id="status-change-select" name="packageStatus" slot="startContent">
                                                    {this.state.statuses.map(s => {
                                                        return (
                                                            <ui5-option value={s}>{mapPackageStatus(s)}</ui5-option>
                                                        )
                                                    })}
                                                </ui5-select>
                                                <ui5-button id="change-status-button" slot="startContent">Промени</ui5-button>
                                                <ui5-button design="Positive" slot="endContent" onClick={this.onPackageEdit}>Редактирай</ui5-button>
                                                <ui5-button design="Negative" slot="endContent" onClick={this.onPackageDelete}>Изтрий</ui5-button>
                                                <ui5-button id="mid-column-close-button" design="Transparent" slot="endContent" onClick={this.onPackageDetailsClose}>Затвори</ui5-button>
                                            </ui5-bar> :
                                            <ui5-bar>
                                                <ui5-button id="mid-column-close-button" design="Transparent" slot="endContent" onClick={this.onPackageDetailsClose}>Затвори</ui5-button>
                                            </ui5-bar>}
                                    </div>
                                    <ui5-timeline>
                                        <ui5-timeline-item id="test-item" icon="person-placeholder" item-name="Потребителски данни:">
                                            <div className="information-container">
                                                <div className="first-information-child">
                                                    <div className="information-row">
                                                        <div className="information-item">Пратено От:</div> &nbsp;&nbsp;&nbsp;
                                                        <span>
                                                            {Package.firm && <b>{Package.firmName},  </b>}
                                                            <b>{Package.senderFirstName} </b>
                                                            <b>{Package.senderLastName}</b>
                                                        </span>
                                                    </div>
                                                    <div className="information-row">
                                                        <div className="information-item">От Адрес:</div> &nbsp;&nbsp;&nbsp;
                                                        <span>
                                                            {Package.fromOffice && <b>ОФИС: </b>}
                                                            <b>{Package.fromCity},  {Package.fromAddress}</b>
                                                        </span>
                                                    </div>
                                                </div>
                                                <div>
                                                    <div className="information-row">
                                                        <div className="information-item">Телефон:</div> &nbsp;&nbsp;&nbsp;
                                                        <span><b>{Package.senderTelephoneNumber}</b></span>
                                                    </div>
                                                    <div className="information-row">
                                                        <div className="information-item">Имейл:</div> &nbsp;&nbsp;&nbsp;
                                                        <span>{Package.senderEmail !== "" ? <b>{Package.senderEmail}</b>
                                                            : <b>Няма въведен имейл</b>}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </ui5-timeline-item>

                                        <ui5-timeline-item id="test-item" icon="locate-me" item-name="Данни за Доставка:">
                                            <div className="information-container">
                                                <div className="first-information-child">
                                                    <div className="information-row">
                                                        <div className="information-item">Пратено До:</div> &nbsp;&nbsp;&nbsp;
                                                        <span>
                                                            {Package.toFirm && <b>{Package.toFirmName},  </b>}
                                                            <b>{Package.receiverFirstName} </b>
                                                            <b>{Package.receiverLastName}</b>
                                                        </span>
                                                    </div>
                                                    <div className="information-row">
                                                        <div className="information-item">Доставка до:</div> &nbsp;&nbsp;&nbsp;
                                                        <span>
                                                            {Package.toOffice && <b>ОФИС: </b>}
                                                            <b>{Package.toCity},  {Package.toAddress}</b>
                                                        </span>
                                                    </div>
                                                </div>
                                                <div>
                                                    <div className="information-row">
                                                        <div className="information-item">Телефон:</div> &nbsp;&nbsp;&nbsp;
                                                        <span><b>{Package.receiverTelephoneNumber}</b></span>
                                                    </div>
                                                    <div className="information-row">
                                                        <div className="information-item">Имейл:</div> &nbsp;&nbsp;&nbsp;
                                                        <span>{Package.receiverEmail !== "" ? <b>{Package.receiverEmail}</b>
                                                            : <b>Няма въведен имейл</b>}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </ui5-timeline-item>

                                        <ui5-timeline-item id="test-item" icon="tags" item-name="Допълнителна информация към пратката:">
                                            <div className="information-container">
                                                <div className="first-information-child">
                                                    <div className="information-row">
                                                        <div className="information-item">Коментар:</div> &nbsp;&nbsp;&nbsp;
                                                        <span>{Package.comment !== "" ? <b>{Package.comment}</b>
                                                            : <b>Няма коментар към пратката</b>}</span>
                                                    </div>
                                                    <div className="information-row">
                                                        <div className="information-item">Алтернативен адрес:</div> &nbsp;&nbsp;&nbsp;
                                                        <span>
                                                            {Package.returnToOffice && <b>ОФИС: </b>}
                                                            <b>{Package.alternativeCity},  {Package.returnLocation}</b>
                                                        </span>
                                                    </div>
                                                    <div className="information-row">
                                                        {Package.fragile && <ui5-badge color-scheme="9">Чупливи предмети</ui5-badge>}
                                                    </div>
                                                </div>
                                                <div>
                                                    <div className="information-row">
                                                        <div className="information-item">Тип:</div> &nbsp;&nbsp;&nbsp;
                                                        <span><b>{Package.ePackageType}</b></span>
                                                    </div>
                                                    <div className="information-row">
                                                        <div className="information-item">Тегло:</div> &nbsp;&nbsp;&nbsp;
                                                        <span><b>{Package.weight}кг</b></span>
                                                    </div>
                                                    <div className="information-row">
                                                        <div className="information-item">Цена:</div> &nbsp;&nbsp;&nbsp;
                                                        <span><b>{Package.price.toFixed(2)}лв.</b></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </ui5-timeline-item>

                                        {Package.isCashOnDelivery &&

                                            <ui5-timeline-item id="test-item" icon="sap-icon://money-bills" item-name="Наложен платеж">
                                                <div className="information-container">
                                                    <div className="first-information-child">
                                                        <div className="information-row">
                                                            <div className="information-item">Сума:</div> &nbsp;&nbsp;&nbsp;
                                                            <span><b>{Package.cashOnDelivery}лв.</b></span>
                                                        </div>
                                                        <div className="information-row">
                                                            <div className="information-item">Изплащане до:</div> &nbsp;&nbsp;&nbsp;
                                                            {Package.iban === "" ?
                                                                <span>
                                                                    {Package.isReturnCashToOffice && <b>ОФИС: </b>}
                                                                    <b>{Package.returnCashCity},  {Package.returnCashAddress}</b>
                                                                </span>
                                                                :
                                                                <span>
                                                                    <b>Банков превод</b>
                                                                </span>
                                                            }
                                                        </div>
                                                    </div>
                                                    {Package.iban !== "" ? <div>
                                                        <div className="information-row">
                                                            <div className="information-item">Титуляр:</div> &nbsp;&nbsp;&nbsp;
                                                            <span><b>{Package.bankAccountOwner}</b></span>
                                                        </div>
                                                        <div className="information-row">
                                                            <div className="information-item">IBAN:</div> &nbsp;&nbsp;&nbsp;
                                                            <span><b>{Package.iban}</b></span>
                                                        </div>
                                                        <div className="information-row">
                                                            <div className="information-item">BIC:</div> &nbsp;&nbsp;&nbsp;
                                                            <span><b>{Package.bic}</b></span>
                                                        </div>
                                                        <div className="information-row">
                                                            <div className="information-item">Банка:</div> &nbsp;&nbsp;&nbsp;
                                                            <span><b>{Package.bank}</b></span>
                                                        </div>
                                                    </div> : <div></div>}

                                                </div>
                                            </ui5-timeline-item>}

                                        <ui5-timeline-item title-text="Статус на Пратката"
                                            subtitle-text={Package.dateOfRegistration !== null ?
                                                ("Обработена на " + Package.dateOfRegistration.slice(0, 10)) : "Непотвърдена"} icon="calendar">
                                            <div className="information-container">
                                                <div className="first-information-child">
                                                    <div className="information-row">
                                                        <div className="information-item">Дата на заявяване:</div> &nbsp;&nbsp;&nbsp;
                                                        <span><b>{Package.dateOfRequest.slice(0, 10)}</b></span>
                                                    </div>
                                                    <div className="information-row">
                                                        <div className="information-item">Дата на изпращане:</div> &nbsp;&nbsp;&nbsp;
                                                        <span><b>{Package.dateOfSending}</b></span>
                                                    </div>
                                                </div>
                                                <div>
                                                    <div className="information-row">
                                                        <div className="information-item">Очаквана дата за вземане/доставка:</div> &nbsp;&nbsp;&nbsp;
                                                        <span><b>{Package.dateOfDelivery}</b></span>
                                                    </div>
                                                    <ui5-badge color-scheme="6">
                                                        <ui5-icon name="accept" slot="icon"></ui5-icon>{mapPackageStatus(Package.ePackageStatus)}
                                                    </ui5-badge>
                                                </div>
                                            </div>
                                        </ui5-timeline-item>
                                    </ui5-timeline>
                                </div> : null}
                        </ui5-flexible-column-layout>
                    </div> :
                    this.state.packages.length === 0 ? <ui5-messagestrip type="Information" no-close-button>Няма налични пратки до момента.</ui5-messagestrip> :
                        <ui5-messagestrip type="Information" no-close-button>Не съществуват пратки с избраните филтри.</ui5-messagestrip>
                }
            </div>
        )
    }
}

export default AllPackages