import React from 'react';
import axios from 'axios';
import "@ui5/webcomponents/dist/Table.js";
import "@ui5/webcomponents/dist/TableColumn.js";
import "@ui5/webcomponents/dist/TableRow.js";
import "@ui5/webcomponents/dist/TableCell.js";
import "../navbar/Navbar.css";
import "@ui5/webcomponents/dist/Input.js";
import "@ui5/webcomponents/dist/ComboBox";
import "@ui5/webcomponents-fiori/dist/Bar.js";

class AllStudents extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            universities: [],
            students: [],
            firstName: "",
            middleName: "",
            lastName: "",
            university: ""
        };

        this.handleInputValue = this.handleInputValue.bind(this);
        this.populate = this.populate.bind(this);
        this.populateu = this.populateu.bind(this);
        this.submit = this.submit.bind(this);
        this.handleSelectionChange = this.handleSelectionChange.bind(this);
    }

    submit() {
        axios.post("http://localhost:8080/api/student", {
            firstName: this.state.firstName,
            middleName: this.state.middleName,
            lastName: this.state.lastName,
            university: this.state.university
        })
            .then(response => {
                this.populate();
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    addEventListeners() {
        document.querySelectorAll('.input').forEach(item => {
            item.addEventListener("change", this.handleInputValue);
        })
        document.querySelectorAll('.combo').forEach(item => {
            item.addEventListener("selection-change", this.handleSelectionChange);
        })
    }

    handleSelectionChange(e) {
        console.log(e.detail.item.attributes.text.value);
        this.setState({
            university: e.detail.item.attributes.text.value
        })
    }

    populate() {
        const URL = "http://localhost:8080/api/student";
        axios.get(URL).then(o => {
            this.setState({
                students: o.data,
            });
            console.log(o.data);
        })
    }

    populateu() {
        const URL = "http://localhost:8080/api/university/names";
        axios.get(URL).then(o => {
            this.setState({
                universities: o.data,
            });
            console.log(o.data);
        })
    }

    componentDidMount() {
        this.addEventListeners();
        this.populate();
        this.populateu();
    }

    handleInputValue(event) {
        const { name, value } = event.target;
        this.setState({
            [name]: value
        });
    }

    render() {
        return (
            <div className="right">
                <ui5-table class="demo-table" id="table">
                    <ui5-table-column slot="columns" >
                        <span>ID</span>
                    </ui5-table-column>

                    <ui5-table-column slot="columns" min-width="800" popin-text="Supplier">
                        <span>Име</span>
                    </ui5-table-column>

                    <ui5-table-column slot="columns" min-width="600" popin-text="Dimensions" demand-popin>
                        <span>Презиме</span >
                    </ui5-table-column>

                    <ui5-table-column slot="columns" min-width="600" popin-text="Dimensions" demand-popin>
                        <span>Фамилия</span >
                    </ui5-table-column>
                    <ui5-table-column slot="columns"  popin-text="Dimensions" demand-popin>
                        <span>Университет</span >
                    </ui5-table-column>
                    {this.state.students.map((u) => { return (

                        u.studentSet.map((s) => (
                        <ui5-table-row>
                            <ui5-table-cell>
                                {s.id}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {s.firstName}
                            </ui5-table-cell>
                            <ui5-table-cell>
                               {s.middleName}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {s.familyName}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {u.name}
                            </ui5-table-cell>
                        </ui5-table-row>))
                    )})}
                    </ui5-table>
                <div className="sit">
                    <div className="down">
                        <b>Въвеведи Студент</b>
                    </div>
                    <div className="go">
                        <ui5-label for="senderLastNameInput" required>Име</ui5-label><br />
                        <ui5-input class="input" id="senderLastNameInput" value={this.state.firstName} name="firstName" placeholder="" required></ui5-input><br />
                    </div>
                    <div className="go">
                        <ui5-label for="senderLastNameInput" required>Презиме</ui5-label><br />
                        <ui5-input class="input" id="senderLastNameInput" value={this.state.middleName} name="middleName" placeholder="" required></ui5-input><br />
                    </div>
                    <div className="go">
                        <ui5-label for="senderLastNameInput" required>Фамилия</ui5-label><br />
                        <ui5-input class="input" id="senderLastNameInput" name="lastName" value={this.state.lastName} placeholder="" required></ui5-input><br />
                    </div>
                    <div className="go">
                        <ui5-label for="senderLastNameInput" required>Университет</ui5-label><br />
                        <ui5-combobox class="combo" value-state="Success" value={"Избери Университет"}>
                            {this.state.universities.map((u) => (
                            <ui5-cb-item text={u}></ui5-cb-item>
                            ))}
                        </ui5-combobox>
                    </div>
                    <div className="go">
                        <ui5-button design="Default" onClick={this.submit}>Въвеведи</ui5-button>
                    </div>
                </div>
            </div>
        )
    }
}

export default AllStudents;