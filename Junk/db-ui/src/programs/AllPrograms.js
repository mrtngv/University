import React from 'react';
import axios from 'axios';
import "@ui5/webcomponents/dist/Table.js";
import "@ui5/webcomponents/dist/TableColumn.js";
import "@ui5/webcomponents/dist/TableRow.js";
import "@ui5/webcomponents/dist/TableCell.js";
import "../navbar/Navbar.css";
import "@ui5/webcomponents/dist/Input.js";

class AllPrograms extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            universities: [],
            name: "",
            country: "",
            city: ""
        };

        this.handleInputValue = this.handleInputValue.bind(this);
        this.populate = this.populate.bind(this);
        this.submit = this.submit.bind(this);
    }

    submit(){
        axios.post("http://localhost:8080/api/program", {
            name: this.state.name,
            capacity: this.state.city,
          })
          .then(response => {
              this.populate();
          })
          .catch(function (error) {
            console.log(error);
          });
    }

    addEventListeners(){
        document.querySelectorAll('.input').forEach(item => {
            item.addEventListener("change", this.handleInputValue);
          })
    }

    populate () {
        const URL = "http://localhost:8080/api/program";
        axios.get(URL).then(o => {
            this.setState({
                universities: o.data,
                name: "",
                city: "",

            });
            console.log(o.data);
        })
    }

    componentDidMount() {
        this.addEventListeners();
        this.populate();
    }

    handleInputValue(event) {
        const { name, value } = event.target;
        this.setState({
            [name]: value
        });
        console.log(this.state.requestDate);
    }

    render() {
        return (
            <div className="right">
                <ui5-table class="demo-table" id="table">
                    <ui5-table-column slot="columns" >
                        <span>ID</span>
                    </ui5-table-column>

                    <ui5-table-column slot="columns" min-width="800" popin-text="Supplier">
                        <span>Име на Програма</span>
                    </ui5-table-column>

                    <ui5-table-column slot="columns" min-width="600" popin-text="Dimensions" demand-popin>
                        <span>Капацитет</span >
                    </ui5-table-column>

                    {this.state.universities.map((u) => (
                        <ui5-table-row>
                            <ui5-table-cell>
                                {u.id}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {u.name}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {u.capacity}
                            </ui5-table-cell>
                        
                        </ui5-table-row>
                    ))}
                </ui5-table>
                <div className="sit">
                <div className="down">
                    <b>Въвеведи Програма</b>
                </div>


                <div className="go">
                    <ui5-label for="senderLastNameInput" required>Име На Програма</ui5-label><br />
                    <ui5-input class="input" id="senderLastNameInput" value= {this.state.name} name="name" placeholder="" required></ui5-input><br />
                </div>
                <div className="go">
                    <ui5-label for="senderLastNameInput" required>Квота</ui5-label><br />
                    <ui5-input class="input" id="senderLastNameInput"  value = {this.state.city} name="city" placeholder="" required></ui5-input><br />
                </div>
                <div className="go">
                <ui5-button design="Default" onClick={this.submit}>Въвеведи</ui5-button>
                </div>
</div>
            </div>
        )
    }
}

export default AllPrograms;